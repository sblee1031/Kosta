package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemomybatisApplicationTests {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	@Test
	void contextLoads() {
		log.error(sqlSessionFactory.toString());
		   assertNotNull(sqlSessionFactory);
	}

}
