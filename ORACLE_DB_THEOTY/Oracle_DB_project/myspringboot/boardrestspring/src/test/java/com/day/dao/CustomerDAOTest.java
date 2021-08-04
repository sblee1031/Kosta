package com.day.dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.day.dto.Customer;
import com.day.exception.FindException;

class CustomerDAOTest {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CustomerDAO dao;
	@Test
	void test() throws FindException {
		//assertNotNull(dao); 
		Customer c = dao.selectById("id1");
		log.error(c.toString());
		assertNotNull(c.getId());
	}

}
