package com;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class BoardrestspringApplicationTests {
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	ApplicationContext ctx;
	@Test
	void contextLoads() {
		//log.error("----" + ctx.getBean("customerDAOOracle").toString());
		assertNotNull(ctx.getBean("repBoardController"));
	}

}
