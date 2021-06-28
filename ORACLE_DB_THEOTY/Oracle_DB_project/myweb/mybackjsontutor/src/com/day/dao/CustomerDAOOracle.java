package com.day.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.day.dto.Customer;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.exception.ModifyException;
import com.day.sql.MyConnection;

public class CustomerDAOOracle implements CustomerDAO{

	@Override
	public void insert(Customer c) throws AddException {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer selectById(String id) throws FindException {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = MyConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}

		String selectByIdSQL = "SELECT * FROM customer WHERE id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(selectByIdSQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Customer(rs.getString("id"), rs.getString("pwd"), rs.getString("name"));
			}
			throw new FindException("아이디가 존재하지 않습니다");
		}catch(SQLException e) {
			throw new FindException(e.getMessage());
		}finally {
			MyConnection.close(con, pstmt, rs);
		}
	}

	@Override
	public void update(Customer c) throws ModifyException {
		String updateSQL = "UPDATE customer SET "; //pwd = 'p1', name = 'n1', buildingno='1'
		String updateSQL1 = " WHERE id = ?";

		boolean flag = false; //변경할 값이 있는 경우 true

		String pwd = c.getPwd();		
		if( pwd != null && !pwd.equals("")) {
			updateSQL += "pwd = '" + pwd + "'";
			flag = true;
		}		

		String name = c.getName();		
		if( name != null && !name.equals("")) {
			if(flag) {
				updateSQL += ",";
			}		
			updateSQL += "name = '" + name + "'";
			flag = true;
		}		

		String buildingno = c.getBuildingno();		
		if( buildingno != null && !buildingno.equals("")) {
			if(flag) {
				updateSQL += ",";
			}	
			updateSQL += "buildingno = '" + buildingno + "'";
			flag = true;
		}


		int enabled = c.getEnabled();		
		if( enabled > -1 ) { //0-탈퇴, 1-활동 
			if(flag) {
				updateSQL += ",";
			}
			updateSQL += "enabled = '" + enabled + "'";
			flag = true;
		}

		System.out.println(updateSQL + updateSQL1);
		if(!flag) {
			throw new ModifyException("수정할 내용이 없습니다");
		}

		/*Connection con = null;
		try {
			con = MyConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/

		//updateSQL + updateSQL1;
	}
	public static void main(String[] args) {
		CustomerDAOOracle dao = new CustomerDAOOracle();
		Customer c = new Customer();
		c.setId("id1");
		//c.setPwd("pp1");
		c.setName("nn1");
		//c.setBuildingno("b1");
		c.setEnabled(-1); 
		try {
			dao.update(c);
		} catch (ModifyException e) {
			e.printStackTrace();
		}
	}

}