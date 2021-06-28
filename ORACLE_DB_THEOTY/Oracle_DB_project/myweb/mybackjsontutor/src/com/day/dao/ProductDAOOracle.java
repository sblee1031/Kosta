package com.day.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.day.dto.Product;
import com.day.exception.FindException;
import com.day.sql.MyConnection;

public class ProductDAOOracle implements ProductDAO {
	public ProductDAOOracle() throws Exception{
		//JDBC드라이버로드		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("JDBC드라이버로드 성공");		

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
		
		String selectALLSQL = "SELECT * FROM product ORDER BY prod_no ASC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(selectALLSQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				//행의 컬럼값 얻기
				String prod_no = rs.getString("prod_no");
				String prod_name = rs.getString("prod_name");
				int prod_price = rs.getInt("prod_price");
				java.sql.Date prod_mf_dt = rs.getDate("prod_mf_dt");
				
				Product p = new Product(prod_no, prod_name, prod_price, prod_mf_dt, null);
				list.add(p);
			}
			if(list.size() == 0) {
				throw new FindException("상품이 없습니다");
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();	
			throw new FindException(e.getMessage());
		} finally {
			//DB연결해제
			MyConnection.close(con, pstmt, rs);
		}		
	}

	@Override
	public List<Product> selectAll(int currentPage) throws FindException {
		int cnt_per_page = 4; //페이지별 보여줄 목록수
		Connection con = null;
		try {
			con = MyConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<>();
		String selectAllPageSQL = "SELECT *\r\n" + 
				"FROM (SELECT rownum rn, a.*\r\n" + 
				"           FROM   (SELECT *\r\n" + 
				"                        FROM product \r\n" + 
				"                        --WHERE order_dt BETWEEN '21/01/01' AND '21/03/31' \r\n" + 
				"                        ORDER BY prod_no ASC\r\n" + 
				"                       ) a\r\n" + 
				"          )\r\n" + 
				"WHERE rn BETWEEN START_ROW(?, ?) AND  END_ROW(?, ?)" ;		
		try {
			pstmt = con.prepareStatement(selectAllPageSQL);
			pstmt.setInt(1, currentPage);
			pstmt.setInt(2, cnt_per_page);
			pstmt.setInt(3, currentPage);
			pstmt.setInt(4, cnt_per_page);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				//행의 컬럼값 얻기
				String prod_no = rs.getString("prod_no");
				String prod_name = rs.getString("prod_name");
				int prod_price = rs.getInt("prod_price");
				java.sql.Date prod_mf_dt = rs.getDate("prod_mf_dt");
				
				Product p = new Product(prod_no, prod_name, prod_price, prod_mf_dt, null);
				list.add(p);
			}
			if(list.size() == 0) {
				throw new FindException("상품이 없습니다");
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();	
			throw new FindException(e.getMessage());
		} finally {
			//DB연결해제
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
		//TODO 상품객체반환
		try {
			pstmt = con.prepareStatement(selectByNoSQL);
			pstmt.setString(1, prod_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String prod_name = rs.getString("prod_name");
				int prod_price = rs.getInt("prod_price");
				java.sql.Date prod_mf_dt = rs.getDate("prod_mf_dt");				
				Product p = new Product(prod_no, prod_name, prod_price, prod_mf_dt, null);
				return p;
			}
			throw new FindException("상품이 없습니다");
		} catch (SQLException e) {
			e.printStackTrace();			
			throw new FindException(e.getMessage());
		} finally {
			//DB연결해제
			MyConnection.close(con, pstmt, rs);
		}		
	}

	@Override
	public List<Product> selectByName(String word) throws FindException {
		//DB연결
		Connection con = null;
		try {
			con = MyConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}		
		
		PreparedStatement pstmt = null;
		String selectByNameSQL = 
				"SELECT * FROM product WHERE prod_name LIKE ? ORDER BY prod_no";
		ResultSet rs = null;
		List<Product> list = new ArrayList<>();
		//SQL구문 송신, 
		//수신결과를 List화, 반환
		try {
			pstmt = con.prepareStatement(selectByNameSQL);
			pstmt.setString(1, "%" + word +"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String prod_no = rs.getString("prod_no");
				String prod_name = rs.getString("prod_name");
				int prod_price = rs.getInt("prod_price");
				Date prod_mf_dt = rs.getDate("prod_mf_dt");
				Product p = new Product(prod_no, prod_name, prod_price, prod_mf_dt, null);
				list.add(p);
			}
			if(list.size() == 0) {
				throw new FindException("상품이 없습니다");
			}
//			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			//DB연결해제
			MyConnection.close(con, pstmt, rs);
		}
		return list;
	}
	public static void main(String[] args) {
//		try {
//			ProductDAOOracle dao = new ProductDAOOracle();
//			List<Product> all = dao.selectAll();
//			for(Product p: all) {
//				System.out.println(p); //p.toString()자동호출됨
//			}
//		} catch(FindException e) {
//			System.out.println(e.getMessage());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		
//		int currentPage = 3;
//		System.out.println(currentPage +"페이지의 내용입니다");
//		try {
//			ProductDAOOracle dao = new ProductDAOOracle();
//			
//			List<Product> all = dao.selectAll(currentPage);
//			
//			for(Product p: all) {
//				System.out.println(p); //p.toString()자동호출됨
//			}
//		} catch(FindException e) {
//			System.out.println(e.getMessage());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
//		String prod_no = "X0002";
//		System.out.println(prod_no+"번 상품정보");
//		try {
//			ProductDAOOracle dao = new ProductDAOOracle();
//			Product p = dao.selectByNo(prod_no);
//			System.out.println(p);
//		} catch(FindException e) {
//			System.out.println(e.getMessage());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		String word = "리";
		System.out.println("\""+word+"\"단어를 포함한 상품목록");
		try {
			ProductDAOOracle dao = new ProductDAOOracle();
			List<Product> list = dao.selectByName(word);
			for(Product p: list) {
				System.out.println(p);
			}
		} catch(FindException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
}
