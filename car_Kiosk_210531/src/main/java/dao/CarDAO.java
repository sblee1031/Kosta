package dao;

import dao.impl.CarDAO_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import db.DBConnection;
import dto.CarDTO;
import db.DBClose;

public class CarDAO implements CarDAO_impl {
	private static CarDAO cardao = null;
	
	public static CarDAO getInstance() {
		if (cardao == null) {
			cardao = new CarDAO();
		}
		return cardao;
	}
	
	// UPDATE isKey 
	public void update_Key(String car_Num, int n) {
		String sql = "UPDATE Car SET isKey = '" + n + "' WHERE car_Num = '" + car_Num + "'";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
	};
	
	// SELECT ALL
	public List<CarDTO> select_All(){
		String sql = "SELECT * FROM Car";
		List<CarDTO> car_List = new ArrayList();
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while(rs.next()) {
				CarDTO carDTO = new CarDTO(
						rs.getString("car_Name")	
						,rs.getString("car_Num")
						,rs.getBoolean("isKey")
						,rs.getString("car_Url")
						,rs.getString("size")
						);
				car_List.add(carDTO);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return car_List;
	};
	
	// SELECT ONE
	public List<CarDTO> select_One(String car_Num) {
		String sql = String.format("SELECT * FROM Car WHERE car_Num LIKE '%%%s'", car_Num);
		System.out.println(sql);

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<CarDTO> car_List = new ArrayList();
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			// 전체 테이블 탐색
			while(rs.next()) {
				CarDTO carDTO = new CarDTO(
						rs.getString("car_Name")	
						,rs.getString("car_Num")
						,rs.getBoolean("isKey")
						,rs.getString("car_Url")
						,rs.getString("size")
						);
				// DB의 필드명
				car_List.add(carDTO); //sql문의 실행 결과에 부합하는 결과를 car_List에 저장 
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return car_List;	
	};
	
	public List<CarDTO> SelectTable(String carName){
		List<CarDTO> carList = new ArrayList();
		
		String sql = "SELECT * FROM Car WHERE car_Name LIKE ? AND isKey LIKE '1'";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, carName);//carName과 true값인걸 들고오겠다
			
			rs = psmt.executeQuery();

			while(rs.next()) {//전체 테이블 탐색
				CarDTO carDTO = new CarDTO(
						rs.getString("car_Name")	
						,rs.getString("car_Num")
						,rs.getBoolean("isKey")
						,rs.getString("car_Url")
						,rs.getString("size")
						);
				//db안을 검색하므로 db안의 필드명을 써야함
				carList.add(carDTO);//sql과 일치하는거 carList에 넣는다. 
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return carList;
	}
	// DELETE
	   public void delete_Table(String index) {
	      String sql = String.format("DELETE FROM Car WHERE car_Num = '" +index+"'");
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
		// Car ADD
	   public void add_Table(String car_Name, String car_Num,  String car_Url,
				 boolean car_Iskey, String car_Size) {
		   String sql = "INSERT INTO Car(car_Name,car_Num,isKey,car_Url,size)"+"values('"+car_Name+"','"+car_Num+"',"+car_Iskey+",'"+car_Url+"','"+car_Size+"')";
//	      String sql = "INSERT INTO Car ('car_Name','car_Num',isKey,'car_Url','size')"+"values ("+car_Name+","+car_Num+","+car_Iskey+","+car_Url+","+car_Size+")";
	      System.out.println(sql);
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
	         System.out.println(car_Name+" 추가완료");
	      }
	   }
	
	
}
