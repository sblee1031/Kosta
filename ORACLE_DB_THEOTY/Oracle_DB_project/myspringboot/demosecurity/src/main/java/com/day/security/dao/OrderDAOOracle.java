package com.day.security.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.day.security.dto.OrderInfo;
import com.day.security.dto.OrderLine;
import com.day.security.exception.AddException;
import com.day.security.exception.FindException;
@Repository

public class OrderDAOOracle implements OrderDAO {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Transactional()
	public void test() {
		//session.insert(~~~);
		//session.insert(~~~);
		String str = null;
		System.out.println(str.length()); //NullPointerException이 발생하면 자동 rollback됨
	}
	@Override
	@Transactional(rollbackFor = AddException.class)
	public void insert(OrderInfo info) throws AddException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			insertInfo(session, info); //ex: 주문수량이 아주 큰값인 경우, 주문기본테이블 데이터추가성공
			insertLines(session, info.getLines()); //             주문상세테이블 데이터추가 실패 -> AddException발생
			//session.commit(); //커밋                          //              모두 롤백됨   
		}catch(Exception e) {
//			try {
//				session.rollback(); //롤백
//			} catch (Exception e1) {
//			}
			throw new AddException(e.getMessage());
		}finally {
			if(session != null)
			session.close();
		}
	}
	/**
	 * 주문기본정보 추가한다
	 * @param con DB연결객체
	 * @param info 주문기본정보
	 * @throws AddException
	 */
	private void insertInfo(SqlSession session, OrderInfo info) throws AddException{
		try {
			session.insert("com.day.dto.OrderMapper.insertInfo", info);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AddException("주문기본추가실패:" + e.getMessage());
		}		
	}
	
	/**
	 * 주문 상세 정보들 추가한다
	 * @param con DB연결객체
	 * @param lines 주문상세정보들
	 * @throws AddException
	 */
	private void insertLines(SqlSession session, List<OrderLine> lines) throws AddException{
		try {
			for(OrderLine line: lines) {
				session.insert("com.day.dto.OrderMapper.insertLine", line);
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new AddException("주문상세 추가실패:" + e.getMessage());
		}
	}
	
	@Override
	public List<OrderInfo> selectById(String id) throws FindException {

		List<OrderInfo> list = new ArrayList<>();
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			list = session.selectList("com.day.dto.OrderMapper.selectById", id);
			if(list.size() == 0) {
				throw new FindException("주문내역이 없습니다");
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}finally {
			if(session != null)
				session.close();
		}
	}
}
