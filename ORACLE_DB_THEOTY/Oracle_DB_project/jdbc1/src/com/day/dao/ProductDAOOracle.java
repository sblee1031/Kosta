package com.day.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.day.dto.Product;
import com.day.exception.FindException;
import com.day.sql.MyConnection;

public class ProductDAOOracle implements ProductDAO {
	
	public ProductDAOOracle() throws Exception {//throws를 사용해 떠넘기기.
		// JDBC드라이버 로드
//		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이버 로드 성공");
//		} catch(ClassNotFoundException e) {
//			e.printStackTrace();
			return;
//		}
	}

	@Override
	public List<Product> selectAll() throws FindException {
		//DB연결
		Connection con = null;
		try {
			con = MyConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}
		String SelectALLSQL = "SELECT * FROM product ORDER BY prod_no ASC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<>();
		
		try {
			pstmt = con.prepareStatement(SelectALLSQL);
			rs = pstmt.executeQuery(); //preparedStatement 사용시 excuteQuery ResultSet값이 없어야 한다.!!
			while(rs.next()) {
				//행의 컬럼값 얻기
				String prod_no = rs.getString("prod_no");
				String prod_name = rs.getString("PROD_NAME");
				int prod_price = rs.getInt("PROD_PRICE");
				java.sql.Date prod_mf_dt = rs.getDate("PROD_MF_DT");
				
				Product p = new Product(prod_no, prod_name, prod_price, prod_mf_dt, null); //DB값 읽어와 DTO에 담기
				list.add(p);
				
			}
			if(list.size() == 0) {
				throw new FindException("상품이 없습니다");
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage()); //콘솔에 예외 종류, 내용, 줄번호 출력 (가공예외)
		}finally{
			//DB연결 해제
			MyConnection.close(con, pstmt, rs);
		}
	
	}

	@Override
	public List<Product> selectAll(int currentPage) throws FindException {
		int cnt_per_page = 4; //페이지별 보여줄 목록수
		//전체건수 : 7건, 총페이지수 : 2페이지
		Connection con = null;
		try {
			con = MyConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectALLPageSQL = "SELECT *\r\n" + 
				"FROM (SELECT rownum rn, a.*\r\n" + 
				"           FROM   (SELECT *\r\n" + 
				"                        FROM order_view \r\n" + 
				"                        --WHERE order_dt BETWEEN '21/01/01' AND '21/03/31' \r\n" + 
				"                        ORDER BY order_no DESC\r\n" + 
				"                       ) a\r\n" + 
				"          )\r\n" + 
				"WHERE rn BETWEEN START_ROW(?, ?) AND  END_ROW(?, ?)\r\n"; //Oracle Start_row(시작페이지) END_row(끝페이지 출력) 함수 활용.
		List<Product> list = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(selectALLPageSQL);
			pstmt.setInt(1, currentPage);
			pstmt.setInt(2, cnt_per_page);
			pstmt.setInt(3, currentPage);
			pstmt.setInt(4, cnt_per_page);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				//행의 컬럼값 얻기
				
				String prod_no = rs.getString("prod_no");
				String prod_name = rs.getString("PROD_NAME");
				int prod_price = rs.getInt("PROD_PRICE");
				java.sql.Date prod_mf_dt = rs.getDate("PROD_MF_DT");
				
				Product p = new Product(prod_no, prod_name, prod_price, prod_mf_dt, null); //DB값 읽어와 DTO에 담기
				list.add(p);
			}
			if(list.size() == 0) {
				
				throw new FindException("상품이 없습니다");
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage()); //콘솔에 예외 종류, 내용, 줄번호 출력 (가공예외)
		}finally{
			//DB연결 해제
			MyConnection.close(con, pstmt, rs);
		}
		
	}

	@Override
	public Product selectByNo(String prod_no) throws FindException {
		Connection con = null;
		try {
			con = MyConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}
		
		String selectByNoSQL = "SELECT * FROM product WHERE prod_no = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<>();
		Product p = null;
		try {
			pstmt = con.prepareStatement(selectByNoSQL);
			pstmt.setString(1, prod_no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				//행의 컬럼값 얻기
				String prod_no_db = rs.getString("prod_no");
				String prod_name = rs.getString("PROD_NAME");
				int prod_price = rs.getInt("PROD_PRICE");
				java.sql.Date prod_mf_dt = rs.getDate("PROD_MF_DT");
				
				p = new Product(prod_no_db, prod_name, prod_price, prod_mf_dt, null); //DB값 읽어와 DTO에 담기
			}
			if(p == null) {
				throw new FindException("상품이 없습니다");
			}
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage()); //콘솔에 예외 종류, 내용, 줄번호 출력 (가공예외)
		}finally{
			//DB연결 해제
			MyConnection.close(con, pstmt, rs);
		}
	}

	@Override
	public List<Product> selectByName(String word) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		try {
			ProductDAOOracle dao = new ProductDAOOracle();
//			List<Product> all = dao.selectAll(4);
//			for(Product p: all) {
//				System.out.println(p);
//			}
			
			Product p = dao.selectByNo("C0012");
			System.out.println(p);
			
		}catch(FindException e) {//자식 exception 발생시 selectAll에서 발생의 경우
//			e.printStackTrace();
			System.out.println(e.getMessage());
		
		}
		catch (Exception e) {//부모 exception 발생시 ProductDAOOracle JDBC연경 상황에서 발생
			System.out.println(e.getMessage());
		}
		
	}
}
