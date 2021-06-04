package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.impl.CustomerDAO_impl;
import db.DBClose;
import db.DBConnection;
import dto.CarDTO;
import dto.CustomerDTO;

public class CustomerDAO implements CustomerDAO_impl {
	private static CustomerDAO customerdao = null;
	
	public static CustomerDAO getInstance() {
		if (customerdao == null) {
			customerdao = new CustomerDAO();
		}
		return customerdao;
	}
	
	// INSERT agree, li_Num, li_Date, ph_Num
	@Override
	public void insert_Table(CustomerDTO dto) {
		String sql = "INSERT INTO Customer (start_Time, li_Num, li_Date, ph_Num, car_Num, agree, lent_Time, pay_Method, pay_Money, isKey) VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		Connection conn = null;        // DB Connection
		PreparedStatement psmt = null; // SWL
		ResultSet rs = null;           // result
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getStart_Time());
			psmt.setString(2, dto.getLi_num());
			psmt.setString(3, dto.getLi_Date());
			psmt.setString(4, dto.getPh_Num());
			psmt.setString(5, dto.getCar_Num());
			psmt.setBoolean(6, dto.isAgree());
			psmt.setString(7, dto.getLent_Time());
			psmt.setString(8, dto.getPay_Method());
			psmt.setInt(9, dto.getPay_Money());
			psmt.setBoolean(10, dto.isKey());
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
	}
	
	@Override
	public void update_Table(CustomerDTO dto) { // isKey false, return_Time, overpay_Method, overpay_Money
		String sql = String.format("UPDATE Customer SET isKey = %s, return_Time = '%s', overpay_Method = '%s', overpay_Money = '%s' WHERE car_Num = '%s'", dto.isKey(), dto.getReturn_Time(), dto.getOverpay_Method(), dto.getOverpay_Money(), dto.getCar_Num());
		
		Connection conn = null;        // DB Connection
		PreparedStatement psmt = null; // SWL
		ResultSet rs = null;           // result
		
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

	@Override
	public List<CustomerDTO> select_All() {
		String sql = "SELECT * FROM Customer";
		
		Connection conn = null;        // DB Connection
		PreparedStatement psmt = null; // SWL
		ResultSet rs = null;           // result
		
		List<CustomerDTO> lastRow = new ArrayList();
		
		//물음표에는 우리가 처리한 데이터 관련 넣기
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);	
			psmt.execute();
			rs = psmt.executeQuery();
			while(rs.next()) {
				CustomerDTO customer_All = new CustomerDTO(
						 rs.getString("li_Num")
						,rs.getString("li_Date")
						,rs.getString("ph_Num")
						,rs.getString("car_Num")
						,rs.getBoolean("Agree")
						,rs.getString("lent_Time")
						,rs.getString("start_Time")
						,rs.getString("return_Time")
						,rs.getString("pay_Method")
						,rs.getInt("pay_Money")
						,rs.getString("overpay_Method")
						,rs.getString("overpay_Money")
						,rs.getBoolean("isKey")
						);
				lastRow.add(customer_All);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}			
		return lastRow;
	}

	@Override
	public List<CustomerDTO> select_One(String car_Num) {
		List<CustomerDTO> ct_lent_Car = new ArrayList();
		String sql = "SELECT * FROM Customer WHERE car_Num LIKE '%%" + car_Num + "'" ; // DB에서 ID체크
		
		Connection conn = null;        // DB Connection
		PreparedStatement psmt = null; // SWL
		ResultSet rs = null;           // result
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.execute();
			rs = psmt.executeQuery();
			while(rs.next()) {//전체 테이블 탐색
				CustomerDTO customerDTO = new CustomerDTO(
						 rs.getString("li_Num")
						,rs.getString("li_Date")
						,rs.getString("ph_Num")
						,rs.getString("car_Num")
						,rs.getBoolean("Agree")
						,rs.getString("lent_Time")
						,rs.getString("start_Time")
						,rs.getString("return_Time")
						,rs.getString("pay_Method")
						,rs.getInt("pay_Money")
						,rs.getString("overpay_Method")
						,rs.getString("overpay_Money")
						,rs.getBoolean("isKey")
						);
				ct_lent_Car.add(customerDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return ct_lent_Car;		
	}
	
	// 총 이용 시간을 구하는 메소드, 매개변수 : 차량번호(ex - 2010, 1013, ...)
	public String date_Diff(String car_Num) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm"); // 연/월/일 시:분
		
		// 대여 시각 & 반납 시각 String 타입
		String date_1 = null; // 서비스 시작 시간(start_Time)
		String date_2 = format.format(cal.getTime()); // 현재 시각(반납 시각)
		
		// 대여 시각 & 반납 시각 Date 타입
		Date start_Date = null;
		Date last_Date = null;

		String sql = String.format("SELECT start_Time FROM CUSTOMER WHERE car_Num LIKE \'%%%s\';", car_Num) ;
		
		Connection conn = null;        // DB Connection
		PreparedStatement psmt = null; // SWL
		ResultSet rs = null;           // result
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);	
			psmt.execute();
			rs = psmt.executeQuery();
			while(rs.next()) {
				date_1 = rs.getString("start_Time"); // 21/05/12 18:40
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			start_Date = format.parse(date_1);
			last_Date = format.parse(date_2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long diff = last_Date.getTime() - start_Date.getTime();

		long diffDays = diff / (24 * 60 * 60 * 1000); // 일
		diff %= (24 * 60 * 60 * 1000);
		long diffHours = diff / (60 * 60 * 1000);     // 시
		diff %= (60 * 60 * 1000);
		long diffMinutes = diff / (60 * 1000);        // 분		
		diff %= (60 * 1000);
		
		String result = diffDays + "일 " + diffHours + "시 " + diffMinutes + "분";
		
		return result;
	}
	// DELETE
	   public void delete_Table(String index) {
	      String sql = String.format("DELETE FROM Customer WHERE li_Num = '" +index+"'");
	      System.out.println(index);
	      Connection conn = null;        // DB Connection
	      PreparedStatement psmt = null; // SWL
	      ResultSet rs = null;           // result
	      
	      try {
	         conn = DBConnection.getConnection();
	         psmt = conn.prepareStatement(sql);
	         psmt.execute();
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         DBClose.close(psmt, conn, rs);
	         System.out.println(index+" 삭제완료");
	      }
	   }


}
