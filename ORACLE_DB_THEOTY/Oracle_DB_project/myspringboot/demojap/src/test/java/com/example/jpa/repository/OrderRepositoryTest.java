package com.example.jpa.repository;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.entity.Customer;
import com.example.jpa.entity.OrderInfo;
import com.example.jpa.entity.OrderLine;
import com.example.jpa.entity.Product;

@SpringBootTest
class OrderRepositoryTest {
	@Autowired
	private OrderInfoRepository orderInfoRepository;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Test
	@DisplayName("주문기본추가: 주문번호 SEQUENCE값으로 일련번호추가, 주문자ID ManyToOne으로 추가")
	void insert() {	
		OrderInfo info  = new OrderInfo();
		Customer order_c = new Customer();
		order_c.setId("id8");
		info.setOrder_c(order_c);
		
		List<OrderLine> lines = new ArrayList<>();
		for(int i=1; i<3; i++) {
			OrderLine line = new OrderLine();
			line.setOrder_info(info);
			Product order_p = new Product();
			order_p.setProd_no("C000" + i);
			line.setOrder_p(order_p);
			line.setOrder_quantity(i*10+1);
			lines.add(line);
		}
		info.setLines(lines);
		orderInfoRepository.save(info);		
	}
	
	
//	@Transactional
	@Test
	void findByIdTest() {	
		int order_no = 1;
		Optional<OrderInfo> optProduct = orderInfoRepository.findById(order_no); 
		OrderInfo info = optProduct.get();
		
		log.info("FIND:" + info);
	}
	
	@Transactional
	@Test
	void findAll() {
		Iterable<OrderInfo> iterable = orderInfoRepository.findAll();
		iterable.forEach(info->{
			log.error("--주문기본정보--");
			log.error("info.no:" + info.getOrder_no() + ", c.id:" + info.getOrder_c().getId());
			log.error("--주문상세정보--");
			info.getLines().forEach(
					line->log.error("line.no:" + line.getOrder_info().getOrder_no() 
							+ ", line.p.prod_no:" + line.getOrder_p().getProd_no())
			);
		});
	}
	
}
