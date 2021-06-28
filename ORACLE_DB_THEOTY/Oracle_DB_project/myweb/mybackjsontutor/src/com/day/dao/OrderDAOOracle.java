package com.day.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.day.dto.Customer;
import com.day.dto.OrderInfo;
import com.day.dto.OrderLine;
import com.day.dto.Product;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.sql.MyConnection;

public class OrderDAOOracle implements OrderDAO {
	@Override
	public void insert(OrderInfo info) throws AddException {
		Connection con = null;
		try {
			con = MyConnection.getConnection();
			con.setAutoCommit(false); //자동커밋 해제
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}
		try {
			insertInfo(con, info);
			insertLines(con, info.getLines());
			con.commit(); //커밋
		}catch(Exception e) {
			try {
				con.rollback(); //롤백
			} catch (SQLException e1) {
			}
			throw new AddException(e.getMessage());
		}finally {
			MyConnection.close(con, null, null);
		}
	}
	/**
	 * 주문기본정보 추가한다
	 * @param con DB연결객체
	 * @param info 주문기본정보
	 * @throws AddException
	 */
	private void insertInfo(Connection con, OrderInfo info) throws AddException{
		//SQL송신
		PreparedStatement pstmt = null;
		String insertInfoSQL = "INSERT INTO order_info(order_no, order_id)"
				+ " VALUES (ORDER_SEQ.NEXTVAL, ?)";
		try {
			pstmt = con.prepareStatement(insertInfoSQL);
			pstmt.setString(1, info.getOrder_c().getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddException("주문기본추가실패:" + e.getMessage());
		}finally {
			MyConnection.close(null, pstmt, null);
		}		
	}
	
	/**
	 * 주문 상세 정보들 추가한다
	 * @param con DB연결객체
	 * @param lines 주문상세정보들
	 * @throws AddException
	 */
	private void insertLines(Connection con, List<OrderLine> lines) throws AddException{
		PreparedStatement pstmt = null;
		String insertLineSQL = "INSERT INTO order_line(order_no, order_prod_no, order_quantity)\r\n" + 
				                              "VALUES (ORDER_SEQ.CURRVAL, ?,    ?)";
		try {
			pstmt = con.prepareStatement(insertLineSQL);
			for(OrderLine line: lines) {
				pstmt.setString(1, line.getOrder_p().getProd_no());
				pstmt.setInt(2, line.getOrder_quantity());
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddException("주문상세 추가실패:" + e.getMessage());
		} finally {
			MyConnection.close(null, pstmt, null);
		}
	}
	
	@Override
	public List<OrderInfo> selectById(String id) throws FindException {
		Connection con = null;
		try {
			con = MyConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}
		String selectByIdSQL = "SELECT oi.order_no, order_dt, order_prod_no,  prod_name, prod_price, order_quantity \r\n" + 
				"FROM order_info oi JOIN order_line ol ON(oi.order_no = ol.order_no)\r\n" + 
				"JOIN product p  ON (ol.order_prod_no = p.prod_no)\r\n" + 
				"WHERE order_id = ?\r\n" + 
				"ORDER BY oi.order_no DESC, order_prod_no";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<OrderInfo> list = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(selectByIdSQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			int oldOrder_no = 0;
			List<OrderLine> lines = null;
			while(rs.next()) {
				//기존주문번호와 현재행의 주문번호가 다르면 
				// OrderInfo객체생성,list에 추가 OrderInfo info = new OrderInfo(); list.add(info)
				// order_no값과 order_dt값을 info객체에 설정
				// lines생성후 OrderInfo객체에 설정  lines = new ArrayList<>(); info.setLines(lines);
				// 현재행의 주문번호를 기존주문번호로 대입
				int order_no = rs.getInt("order_no");
				if(oldOrder_no != order_no) {
					OrderInfo info = new OrderInfo(); 
					list.add(info);
//					Customer order_c = new Customer(); order_c.setId("order_id");
//					info.setOrder_c(order_c);
					info.setOrder_no(order_no);
					info.setOrder_dt(rs.getDate("order_dt"));
					lines = new ArrayList<>();
					info.setLines(lines);
					oldOrder_no = order_no;
				}
				//OrderLine객체생성, lines에 추가 OrderLine line = new OrderLine(); lines.add(line);
				OrderLine line = new OrderLine();
				line.setOrder_no(order_no);
				Product order_p = new Product();
				order_p.setProd_no(rs.getString("order_prod_no"));
				order_p.setProd_name(rs.getString("prod_name"));
				order_p.setProd_price(rs.getInt("prod_price"));
				line.setOrder_p(order_p);
				line.setOrder_quantity(rs.getInt("order_quantity"));
				lines.add(line);
			}
			if(list.size() == 0) {
				throw new FindException("주문내역이 없습니다");
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}finally {
			MyConnection.close(con, pstmt, rs);
		}
	}
	
	public static void main(String[] args) {
		OrderDAOOracle dao = new OrderDAOOracle();
		
//		OrderInfo info = new OrderInfo();
//		Customer c = new Customer();  c.setId("id1");
//		info.setOrder_c(c);
//		
//		List<OrderLine> lines = new ArrayList<>();	
//		for(int i=1; i<=3; i++) {
//			OrderLine line = new OrderLine();
//			Product p = new Product();  p.setProd_no("C000" + i);
//			line.setOrder_p(p);
//			line.setOrder_quantity(i*1000);
//			lines.add(line);
//		}
//		info.setLines(lines);
//		
//		try {
//			dao.insert(info);
//		} catch (AddException e) {
//			e.printStackTrace();
//		}
		
		String order_id = "id1";
		try {
			List<OrderInfo> list = dao.selectById(order_id);
			System.out.println(list);
			System.out.println("총 주문횟수: " + list.size()); //2
			
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
