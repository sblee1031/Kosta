package com.day.dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.day.dto.Product;
import com.day.exception.FindException;
@SpringBootTest
class ProductDAOTest {

	@Autowired
	ProductDAO dao;
	@Test
	void test() throws FindException {
		Product p = dao.selectByNo("C0001");
		String expectedName = "아메리카노";
		assertEquals("아메리카노",p.getProd_name());
	}

}
