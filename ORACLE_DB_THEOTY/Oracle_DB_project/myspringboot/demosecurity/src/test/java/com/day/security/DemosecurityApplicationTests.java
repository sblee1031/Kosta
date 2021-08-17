package com.day.security;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DemosecurityApplicationTests {
	@Autowired
	ApplicationContext ctx;
	@Test
	void contextLoads() {
		DataSource ds = ctx.getBean("dataSource", DataSource.class);
		assertNotNull(ds);
	}

}
