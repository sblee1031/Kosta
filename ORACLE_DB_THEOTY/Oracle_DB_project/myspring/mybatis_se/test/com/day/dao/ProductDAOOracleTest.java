package com.day.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.day.dto.Product;
import com.day.exception.FindException;

class ProductDAOOracleTest {
	static private ProductDAO dao;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeAll메서드 호출");
		dao = new ProductDAOOracle();
	}
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("@BeforeEach메서드 호출");
	}
	@Test
	void testSelectByNo() throws FindException {
		//fail("Not yet implemented");
		System.out.println("testSelectByNo메서드 호출");
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

	@AfterEach
	void tearDown() {
	System.out.println("@AfterEach메서드 호출");
	
	
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterAll 메서드 호출");
	}

}
