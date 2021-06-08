package com.day.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.day.dto.Product;
import com.day.exception.FindException;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> selectAll(int currentPage) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product selectByNo(String prod_no) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> selectByName(String word) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}

}
