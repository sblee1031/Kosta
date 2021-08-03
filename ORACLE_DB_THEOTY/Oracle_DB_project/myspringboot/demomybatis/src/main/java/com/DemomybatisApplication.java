package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.day.dao"})
public class DemomybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemomybatisApplication.class, args);
	}

}
