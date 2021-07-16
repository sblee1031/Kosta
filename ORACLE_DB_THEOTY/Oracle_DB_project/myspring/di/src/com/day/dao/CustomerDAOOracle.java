package com.day.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.day.dto.Customer;
import com.day.dto.Product;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.exception.ModifyException;
import com.day.sql.MyConnection;
@Repository("customerDAO")
public class CustomerDAOOracle implements CustomerDAO {
	
	public CustomerDAOOracle() throws Exception {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이버 로드 성공");
			return;
	}

	@Override
	public void insert(Customer c) throws AddException {
		//DB연결
				Connection con = null;
				try {
					con = MyConnection.getConnection();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new AddException(e.getMessage());
				}
				String InsertSQL = "INSERT INTO customer(id,pwd,name) VALUES (?,?,?)";
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					pstmt = con.prepareStatement(InsertSQL);
					pstmt.setString(1, c.getId());
					pstmt.setString(2, c.getPwd());
					pstmt.setString(3, c.getName());
					pstmt.executeQuery();
					
				} catch (SQLException e) {
					e.printStackTrace();
					throw new AddException(e.getMessage());
				}finally{
					//DB연결 해제
					MyConnection.close(con, pstmt, rs);
				}
				
	}

	@Override
	public Customer selectById(String id) throws FindException {//로그인, 자기정보조회
			Connection con = null;
			try {
				con = MyConnection.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new FindException(e.getMessage());
			}
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String selectById = "SELECT * FROM customer WHERE id = ? ";
			Customer c = null;
			try {
				pstmt = con.prepareStatement(selectById);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					//행의 컬럼값 얻기
					String Str_id = rs.getString("id");
					String pwd = rs.getString("pwd");
					String name = rs.getString("name");
					String buildingno = rs.getString("buildingno");
					if(buildingno!=null) {
					buildingno = buildingno.trim();//char 자리수 트림
					}
					c = new Customer(Str_id, pwd, name, buildingno); //DB값 읽어와 DTO에 담기
				}
				if(c == null) {
					throw new FindException("조회된 id가 없습니다.");
				}return c;
			}catch (SQLException e) {
				e.printStackTrace();
				throw new FindException(e.getMessage()); //콘솔에 예외 종류, 내용, 줄번호 출력 (가공예외)
			}finally{
				MyConnection.close(con, pstmt, rs);
			}
			
		
	}

	@Override
	public void update(Customer c) throws ModifyException {
		if(c.getName()==null
				&&c.getPwd()==null
				&&c.getBuildingno()==null) {
			Connection con = null;
			try {
				con = MyConnection.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ModifyException(e.getMessage());
			}
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String updateSQL = "UPDATE customer \r\n" + 
								"SET enabled = 0 \r\n" + 
								"WHERE id = ?";
			try {
				pstmt = con.prepareStatement(updateSQL);
				pstmt.setString(1, c.getId());
				pstmt.executeQuery();
				System.out.println(c.getId() +" 탈퇴 완료 ");
			}catch (SQLException e) {
				e.printStackTrace();
				throw new ModifyException(e.getMessage()); //콘솔에 예외 종류, 내용, 줄번호 출력 (가공예외)
			}finally{
				MyConnection.close(con, pstmt, rs);
			}
			
		} else {
			//강사님 구현 코드
//			String updateSQL = "UPDATE customer SET ";
//			String updateSQL1 = " WHERE ID='"+c.getId()+"'";
//			String pwd=c.getPwd();
//			boolean flag = false;
//			if(pwd!=null&&!pwd.equals("")) {
//				updateSQL +="pwd='"+c.getPwd()+"' ";
//				flag=true;
//			}
//			
//			String name=c.getName();
//			if(name!=null&&!name.equals("")) {
//				if(flag) {
//					updateSQL +=",";
//				}
//				updateSQL +="name='"+c.getName()+"' ";
//				flag=true;
//			}
//			String buildingno=c.getBuildingno();
//			if(buildingno!=null&&!buildingno.equals("")) {
//				if(flag) {
//					updateSQL +=",";
//				}
//				updateSQL +="buildingno='"+c.getBuildingno()+"' ";
//				flag=true;
//			}
//			int enabled=c.getEnabled();
//			if(enabled>-1) { // 0 탈퇴, 1 활동
//				if(flag) {
//					updateSQL +=",";
//				}
//				updateSQL +="enabled='"+c.getEnabled()+"' ";
//				flag=true;
//			}
//			if(flag=false) {
//				throw new ModifyException("실패");
//			}
//			updateSQL+=updateSQL1;
//   강사님 코드 끝
			
		Customer db_c = null;//DB 기존 정보
		Customer new_c = new Customer(null, null, null, null);//바뀔 정보
		
		try {//selectById를 통해 DB 회원정보 가져오기
			db_c = selectById(c.getId());
//			System.out.println(c.getId()+" 조회 완료");
		} catch (FindException e1) {
			e1.printStackTrace();
		}
		new_c.setId(c.getId());//ID 입력
		new_c.setPwd(c.getPwd());
		new_c.setName(c.getName());
		new_c.setBuildingno(c.getBuildingno());
		
		if(!c.getPwd().equals(db_c.getPwd())) {
			new_c.setPwd(c.getPwd());
			System.out.println("* 비밀번호 변경");
		}if(!c.getName().equals(db_c.getName())) {
			new_c.setName(c.getName());
			System.out.println("* 이름 변경");
		}if(!c.getBuildingno().equals(db_c.getBuildingno())) {
			new_c.setBuildingno(c.getBuildingno());
			System.out.println("* buildingno 변경");
		}if(c.getPwd().equals(db_c.getPwd())&&
				c.getName().equals(db_c.getName())&&
						c.getBuildingno().equals(db_c.getBuildingno())) {
			System.out.println("* 변경사항 없습니다.");
		}
		Connection con = null;
		try {
			con = MyConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ModifyException(e.getMessage());
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String updateSQL = "UPDATE customer \r\n" + 
				"			SET pwd = ? ,\r\n" + 
				"			     name = ?, \r\n" + 
				"			     buildingno = ? \r\n" + 
				"			WHERE id = ? ";
		try {
			pstmt = con.prepareStatement(updateSQL);
			pstmt.setString(1, new_c.getPwd());
			pstmt.setString(2, new_c.getName());
			pstmt.setString(3, new_c.getBuildingno());
			pstmt.setString(4, new_c.getId());
			pstmt.executeQuery();
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new ModifyException(e.getMessage()); //콘솔에 예외 종류, 내용, 줄번호 출력 (가공예외)
		}finally{
			MyConnection.close(con, pstmt, rs);
		}
		
		}
	}

	public static void main(String[] args) {
//		try {//고객가입 메서드
//			CustomerDAOOracle dao = new CustomerDAOOracle();
//			String id ="t3";
//			String pwd = "t3";
//			String name = "t3";
//			
//			Customer customer = new Customer(id,pwd,name);
//			dao.insert(customer);
//			System.out.println("id : "+ id + "pwd : "+ pwd +"name : "+ name +" 가입완료");
//			
//		} catch(AddException e) {//자식 exception 발생시 selectAll에서 발생의 경우
//			System.out.println(e.getMessage());
//		
//		}
//		catch (Exception e) {//부모 exception 발생시 ProductDAOOracle JDBC연경 상황에서 발생
//			System.out.println(e.getMessage());
//		}
		
		
//		try {//로그인, 조회 테스트
//			CustomerDAOOracle dao = new CustomerDAOOracle();
//			String id ="i3";
//			String pwd = "p4";
//			Customer customer = dao.selectById(id);
//			System.out.println("id : "+ customer.getId() 
//			+ " pwd : "+ customer.getPwd()  +" name : "+ customer.getName()  +" 조회");
//			
//			if(pwd.equals(customer.getPwd())){
//				System.out.println("로그인 성공");
//			}else if(pwd.equals(customer.getPwd())) {
//				System.out.println("패스워드가 일치하지 않습니다.");
//			}
//			
//		} catch (FindException e) {
//			System.out.println(e.getMessage());
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		

		try {//수정 테스트
		CustomerDAOOracle dao = new CustomerDAOOracle();
		String id = "id2";
		String pwd ="p2311";
		String name = "n231";
		String bulidingno = "111";
		Customer customer = new Customer(id, pwd, name, bulidingno);

		dao.update(customer);
		
		Customer db_c = dao.selectById(id);//수정된 값 id 재조회
		System.out.println("id : "+ db_c.getId() 
		+ " / pwd : "+ db_c.getPwd()  +" / name : "+ db_c.getName()  + " / buildingno : "
				+ db_c.getBuildingno() +"- 조회 완료");

	} catch (ModifyException e) {
		System.out.println(e.getMessage());
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}
		
		
//		try {//탈퇴 테스트
//		CustomerDAOOracle dao = new CustomerDAOOracle();
//		String id = "id2";
//		Customer customer = new Customer(id, null, null, null);
//	
//		dao.update(customer);
//	
//		} catch (ModifyException e) {
//			System.out.println(e.getMessage());
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		
		
	}//main

}
