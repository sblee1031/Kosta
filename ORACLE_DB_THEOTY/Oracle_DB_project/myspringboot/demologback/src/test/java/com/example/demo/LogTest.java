package com.example.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
                                
import org.springframework.boot.test.context.SpringBootTest; 
@SpringBootTest
class LogTest {
	  private Logger log = LoggerFactory.getLogger(this.getClass());

	@Test
	void test() {
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
	}
	@Test
	void loop() {
		for(int i=0; i<100; i++) {
		log.debug("디버그"+i);
		log.info("인포"+i);
		log.warn("워닝"+i);
		log.error("에러"+i);
		}
	}

}
