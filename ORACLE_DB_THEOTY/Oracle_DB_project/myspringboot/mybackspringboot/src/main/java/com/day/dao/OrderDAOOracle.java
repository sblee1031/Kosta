package com.day.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.day.dto.OrderInfo;
import com.day.dto.OrderLine;
import com.day.exception.AddException;
import com.day.exception.FindException;
@Repository("orderDAO")

public class OrderDAOOracle implements OrderDAO{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Transactional
	public void test() {
		//session.insert(~~)
		//session.insert
		String str = null;
		System.out.println(str.length());//NullPointerException이 발생하면 자동 rollback됨
		
	}
	
	@Override
	@Transactional(rollbackFor = AddException.class)
	public void insert(OrderInfo info) throws AddException {
		//log.info(info);
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			insertInfo(session,info); // ex: 주문수량이 아주 큰값인경우, 주문기본테이블 데이터추가성공
			insertLines(session, info.getLines()); //					주문상세테이블 데이터추가실패 //
			
		}catch(Exception e) {
//			e.printStackTrace();
			throw new AddException(e.getMessage());
			
		}finally {
			if(session !=null) {
				session.close();
			}
		}
	}
	/**
	 * 주문기본정보 추가한다
	 * @param con DB연결객체
	 * @param info 주문기본정보
	 * @throws AddException
	 */
	private void insertInfo(SqlSession session, OrderInfo info) throws AddException{
		//SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			session.insert("com.day.dto.OrderMapper.insertInfo", info);
		}catch(Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
			
		}finally {
			if(session !=null) {
				session.close();
			}
		}
		
	}

	/**
	 * 주문 상세 정보를 추가한다
	 * @param con DB연결객체
	 * @param lines 주문상세정보들
	 * @throws AddException
	 */
	private void insertLines(SqlSession session, List<OrderLine> lines) throws AddException {
		try {
			session = sessionFactory.openSession();
			for (OrderLine line : lines) {
				session.insert("com.day.dto.OrderMapper.insertLine",line);
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
			
		}finally {
			if(session !=null) {
				session.close();
			}
		}
		
	}


	@Override
	   public List<OrderInfo> selectById(String id) throws FindException {
	      SqlSession session = null;
	      try {
	         session = sessionFactory.openSession();
	         List<OrderInfo> list = session.selectList("com.day.dto.OrderMapper.selectById", id);
	        // session.commit();
	      
	         if (list.size() == 0) {
	            throw new FindException("주문내역이 없습니다.");
	         }
	         return list;
	      } catch (Exception e) {
	         e.printStackTrace();
	         throw new FindException(e.getMessage());
	      } finally {
	         if (session != null) {
	            session.close();
	         }
	      }
	   }
	
	public static void main(String[] args) {
		
//			OrderDAOOracle dao = new OrderDAOOracle(); //insert()메서드 테스트
//			
//			OrderInfo info = new OrderInfo();
//			Customer c = new Customer();  c.setId("id1");
//			info.setOrder_c(c);
//			
//			List<OrderLine> lines = new ArrayList<>();	
//			for(int i=1; i<=3; i++) {
//				OrderLine line = new OrderLine();
//				Product p = new Product();  p.setProd_no("C000" + i);
//				line.setOrder_p(p);
//				line.setOrder_quantity(i);
//				lines.add(line);
//			}
//			info.setLines(lines);
//			
//			try {
//				dao.insert(info);
//			} catch (AddException e) {
//				e.printStackTrace();
//			}
		
			OrderDAOOracle dao = new OrderDAOOracle();
			 List<OrderInfo> list = new ArrayList<>();
			 try {
				list = dao.selectById("id2");
			} catch (FindException e) {
				e.printStackTrace();
			}
			 for (int i = 0; i < list.size(); i++) {
				 System.out.println(list.get(i));
			}
		}
}
