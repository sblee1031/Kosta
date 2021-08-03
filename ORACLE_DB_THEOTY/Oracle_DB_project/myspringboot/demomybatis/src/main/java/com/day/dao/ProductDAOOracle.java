package com.day.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.day.dto.Product;
import com.day.exception.FindException;

//@Repository("productDAO1")
@Repository
public class ProductDAOOracle implements ProductDAO {
	@Autowired
	//@Qualifier("Underscore")
	private SqlSessionFactory sqlSessionFactory;
	
//	public ProductDAOOracle() {
//		String resource = "mybatis-config.xml"; //"org/mybatis/example/mybatis-config.xml";
//		InputStream inputStream;
//		try {
//			inputStream = Resources.getResourceAsStream(resource);
//			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
//	}
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public List<Product> selectAll() throws FindException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession(); //jdbc MyConnetion 역할.
			List<Product> list = session.selectList("com.day.dto.ProductMapper.selectAll");
			return list;
		}catch (Exception e) {
			throw new FindException(e.getMessage()); //콘솔에 예외 종류, 내용, 줄번호 출력 (가공예외)
		}finally{
			//DB연결 해제
			if(session !=null) {
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
			HashMap<String, Integer> map = new HashMap<>();
			map.put("cnt_per_page", cnt_per_page);
			map.put("currentPage", currentPage);
			List<Product> list = session.selectList("com.day.dto.ProductMapper.selectAllPage", map);
			if(list.size() == 0) {
				throw new FindException("상품이 없습니다");
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage()); //콘솔에 예외 종류, 내용, 줄번호 출력 (가공예외)
		}finally{
			//DB연결 해제
			if(session !=null) {
				session.close();
			}
		}
		
	}

	@Override
	public Product selectByNo(String prod_no) throws FindException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			Product p = session.selectOne("com.day.dto.ProductMapper.selectByNo", prod_no);
			if(p==null) {
				throw new FindException("상품이 없습니다.");
			}return p;
		} catch (Exception e) {
			throw new FindException(e.getMessage()); //콘솔에 예외 종류, 내용, 줄번호 출력 (가공예외)
		}finally{
			//DB연결 해제
			if(session !=null) {
				session.close();
			}
		}
	}

	@Override
	public List<Product> selectByName(String word) throws FindException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			HashMap<String, String> map = new HashMap<>();
			map.put("word", word);
			map.put("ordermethod", "prod_no ASC");
			List<Product> list = session.selectList("com.day.dto.ProductMapper.selectByName", map);
			if(list.size() == 0) {
				throw new FindException("상품이 없습니다");
			}return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage()); //콘솔에 예외 종류, 내용, 줄번호 출력 (가공예외)
		}finally{
			//DB연결 해제
			if(session !=null) {
				session.close();
			}
		}
	}

	public static void main(String[] args) {
		try {
			ProductDAOOracle dao = new ProductDAOOracle();
//			List<Product> all = dao.selectAll(4);
//			for(Product p: all) {
//				System.out.println(p);
//			}
			
//			Product p = dao.selectByNo("C0001");
//			System.out.println(p);
			
			String word = "리";
			System.out.println("\""+word+"\""+ "단어를 포함한 상품목록");
			List<Product> list = dao.selectByName(word);
			for(Product p : list) {
				System.out.println(p);
			}
			
		}catch(FindException e) {//자식 exception 발생시 selectAll에서 발생의 경우
//			e.printStackTrace();
			System.out.println(e.getMessage());
		
		}
		catch (Exception e) {//부모 exception 발생시 ProductDAOOracle JDBC연경 상황에서 발생
			System.out.println(e.getMessage());
		}
		
	}
}
