package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.impl.ChargeDAO_impl;
import db.DBClose;
import db.DBConnection;
import dto.ChargeDTO;

public class ChargeDAO implements ChargeDAO_impl {
	
	private static ChargeDAO chargedao = null;
	
	public static ChargeDAO getInstance() {
		if (chargedao == null) {
			chargedao = new ChargeDAO();
		}
		return chargedao;
	}
	
	// car_Size(차량 크기)를 매개변수로 받아 Charge 테이블에서 select-one
	public List<ChargeDTO> select_One(String car_Size) {
		String sql = "SELECT * FROM Charge WHERE car_Size = '" + car_Size + "'";  
		
		Connection conn = null;        // DB Connection
		PreparedStatement psmt = null; // SWL
		ResultSet rs = null;           // result

		List<ChargeDTO> charge_List = new ArrayList<ChargeDTO>();
	    
	    try { 
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while(rs.next()) {
			    ChargeDTO chargeDTO = new ChargeDTO(
			          rs.getString("car_Size")   
			          ,rs.getInt("ten_Min")
			          ,rs.getInt("one_Hour")
			          ,rs.getInt("three_Hour")
			          ,rs.getInt("six_Hour")
			          ,rs.getInt("one_Day")
			          ,rs.getInt("three_Day")
			    );
			    charge_List.add(chargeDTO);
			}

	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	DBClose.close(psmt, conn, rs);
	    }
	    return charge_List;
	}
}
