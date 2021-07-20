package com.day.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.day.dto.Product;
import com.day.exception.FindException;

@ExtendWith(SpringExtension.class)

@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})


class ProductDAOOracleTest {
	@Autowired
	@Qualifier("productDAO1")
	private ProductDAO dao;
	private Logger log = Logger.getLogger(ProductDAOOracleTest.class.getName());

//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//		System.out.println("@BeforeAll메서드 호출");
//		dao = new ProductDAOOracle();
//	}
//	@BeforeEach
//	void setUp() throws Exception {
//		System.out.println("@BeforeEach메서드 호출");
//	}
	@Test
	void testSelectByNo() throws FindException {
		//fail("Not yet implemented");
//		System.out.println("testSelectByNo메서드 호출");
		log.debug("testSelectByNo DEBUG");
		log.info("testSelectByNo INFO");
		log.warn("testSelectByNo WARN");
		log.error("testSelectByNo ERROR");
		String prod_no = "C0001";
		Product p = dao.selectByNo(prod_no); //db검색결과
		
		String expectedProdName = "아메리카노";//예상
		int expectedProdPrice = 1000;
		assertEquals(expectedProdName, p.getProd_name());		
		assertEquals(expectedProdPrice, p.getProd_price());	
		assertTrue(expectedProdPrice== p.getProd_price());
	}
	@Test
	void testSelectAll() throws FindException {
		//fail("Not yet implemented");
		System.out.println("testSelectAll메서드 호출");
		List<Product> list = dao.selectAll();
		int expectedSize = 7;
		assertTrue(expectedSize == list.size());
	}
	@Test
	void testSelectByName() throws FindException {
		//fail("Not yet implemented");
		System.out.println("testSelectByName메서드 호출");
		String word = "아";
		List<Product> list = dao.selectByName(word);
		int expectedSize = 2;
		String expectedProd_no = "C0001";
		assertTrue(expectedSize == list.size());
		assertEquals(expectedProd_no, list.get(0).getProd_no());
	}
	@Test
	void testSelectByNameNotFound() {
		String word = "가";
		FindException expectedException;
		expectedException = assertThrows(FindException.class,
				                         ()->dao.selectByName(word));
	    
		String expectedMsg = "상품이 없습니다";
		assertEquals(expectedMsg, expectedException.getMessage());
	}



	@AfterEach
	void tearDown() {
	System.out.println("@AfterEach메서드 호출");
	
	
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterAll 메서드 호출");
	}

}
