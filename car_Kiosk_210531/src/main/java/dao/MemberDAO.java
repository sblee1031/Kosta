package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.MemberDTO;

public class MemberDAO {

	private int last_seq;
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private MemberDAO() {
		try {
			Class.forName("org.sqlite.JDBC"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static MemberDAO memberDao = new MemberDAO();
	
	public static MemberDAO getInstance() {//외부에서 new연산자 못쓰게 막아주는 역할
		if(memberDao == null)
			memberDao = new MemberDAO();//비어있으면 생성해주고
		return memberDao;//없으면 기존꺼 가져옴
	}
	

	//db 연동 메소드
	public Connection getConnection() {
		try {
			String dbFile = ".\\db\\carKiosk.db";
			String dbFileUrl ="jdbc:sqlite:"+dbFile;
			conn=DriverManager.getConnection(dbFileUrl);
			System.out.println("DB Connection Success!");
			
			String dropSql = "SELECT MAX(mem_Num) FROM Member";// 마지막 seq 값 가져오는 SQL문		
			pstmt = conn.prepareStatement(dropSql);	
			pstmt.execute();
			rs = pstmt.executeQuery();
			String seq = rs.getString(1);
			last_seq = Integer.parseInt(seq);
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return conn;
	}

	//Member 테이블 ID,PW 매칭 메서드
	public ArrayList<String> MemberMatch(String id, String pw) {
		getConnection();		
		String loginId = "";
		String loginPw = "";
		ArrayList<String> login_arr = new ArrayList<String>();
		String sql = "SELECT * FROM Member WHERE member_Id ='"+id+"'" ; // DB에서 ID체크
		String sql2 = "SELECT * FROM Member WHERE member_Id ='"+id+"' AND member_Pw ='"+pw+"'" ; //DB에서 PW체크
		//물음표에는 우리가 처리한 데이터 관련 넣기
		try {
			pstmt = conn.prepareStatement(sql);	
			pstmt.execute();
			rs = pstmt.executeQuery();
			loginId = rs.getString("member_Id");
			
			if(!loginId.equals("")) {
				login_arr.add(loginId);
				System.out.println(login_arr.get(0));
				pstmt = conn.prepareStatement(sql2);	
				pstmt.execute();
				rs = pstmt.executeQuery();
				loginPw = rs.getString("member_Pw");
				
				if(!loginPw.equals("")) {
					login_arr.add(loginPw);
					
					while(rs.next()) {//전체 테이블 탐색
						String li_Num = rs.getString("li_Num");
						String li_Date =rs.getString("li_Date");
						String ph_Num =rs.getString("ph_Num");
						int mileage = rs.getInt("mileage");
							
						login_arr.add(li_Num);
						login_arr.add(li_Date);
						login_arr.add(ph_Num);
						login_arr.add(Integer.toString(mileage));
					};
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("검색된 DB 없음");
		} finally {
			try{
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	return login_arr;			
	}
	
	//member테이블 회원 추가
	public void member_Add() {
		getConnection();		
		MemberDTO memberDTO = MemberDTO.getInstance();
		String sql = "INSERT INTO Member (member_Id,member_Pw,li_Num,li_Date,ph_Num, mileage) VALUES (?,?,?,?,?,?)";
		//물음표에는 우리가 처리한 데이터 관련 넣기
		
		try {
			pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, memberDTO.getMember_Id());
			pstmt.setString(2, memberDTO.getMember_Pw());
			pstmt.setString(3, memberDTO.getLi_num());
			pstmt.setString(4, memberDTO.getLi_Date());
			pstmt.setString(5, memberDTO.getPh_Num());
			pstmt.setInt(6, 0);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//member테이블 ID검증 메서드
	public boolean member_Id_Check(String id) {
		getConnection();	
		boolean id_check = true;
		MemberDTO memberDTO = MemberDTO.getInstance();
		String sql = "SELECT * FROM Member WHERE member_Id = '"+memberDTO.getMember_Id()+"'";
		
		try {
			pstmt = conn.prepareStatement(sql);	
			pstmt.execute();
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id_check = true; //ID 중복!!
			}else {
				id_check = false; //ID 중복아님!!
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("===DB정보 없음==");
		} finally {
			try{	
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return id_check; 
	}
	
	// UPDATE 마일리지
	public void update_Mileage(MemberDTO memberDTO) {
		
		Connection conn = null;        // DB Connection
		PreparedStatement psmt = null; // SWL
		ResultSet rs = null;           // result
		
		String sql = String.format("UPDATE Member SET Mileage = %d where member_Id = '%s'", memberDTO.getMileage(), memberDTO.getMember_Id());
		System.out.println(sql);
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
	}
}



