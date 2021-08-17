package com.day.security.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.day.security.dto.Product;
import com.day.security.exception.FindException;

@Repository
public class ProductDAOOracle implements ProductDAO {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public List<Product> selectAll() throws FindException {	
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			List<Product>list =session.selectList("com.day.dto.ProductMapper.selectAll");			
			//log.info("selectAll-1");
			return list;
		}catch(Exception e) {
			throw new FindException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}		
	}

	@Override
	public List<Product> selectAll(int currentPage) throws FindException {
		int cnt_per_page = 4; //페이지별 보여줄 목록수
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			HashMap<String, Integer>map = new HashMap<>();
			map.put("cnt_per_page", cnt_per_page);
			map.put("currentPage", currentPage);
			List<Product> list = session.selectList("com.day.dto.ProductMapper.selectAllPage", map);
			if(list.size() == 0) {
				throw new FindException("상품이 없습니다");
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();	
			throw new FindException(e.getMessage());
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public Product selectByNo(String prod_no) throws FindException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			Product p = session.selectOne("com.day.dto.ProductMapper.selectByNo", 
					prod_no);
			if(p == null) {

				log.error("in selectByNo : 상품없음");
				throw new FindException("상품이 없습니다");
			}

			log.error("in selectByNo : 상품있음");
			return p;
		} catch (Exception e) {
			e.printStackTrace();			
			throw new FindException(e.getMessage());
		} finally {
			//DB연결해제
			if(session != null)session.close();
		}		
	}

	@Override
	public List<Product> selectByName(String word) throws FindException {		
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			HashMap<String, String>map = new HashMap<>();
			map.put("word", word);
			map.put("ordermethod", "prod_no ASC");
			List<Product> list = session.selectList("com.day.dto.ProductMapper.selectByName", map);
			if(list.size() == 0) {
				throw new FindException("상품이 없습니다");
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			//DB연결해제
			if(session != null) {
				session.close();
			}
		}
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
