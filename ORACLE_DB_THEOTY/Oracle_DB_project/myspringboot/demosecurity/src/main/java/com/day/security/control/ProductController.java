package com.day.security.control;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.day.security.dto.Product;
import com.day.security.exception.FindException;
import com.day.security.service.ProductService;

@Controller 
public class ProductController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ProductService service;
	
	@GetMapping("/productinfo")
	public String productInfo(String prod_no, Model model) {
		String viewName;
		try {
			Product p = service.findByNo(prod_no);
			model.addAttribute("p", p);
			viewName = "productinfo";
			log.error("상품있음");
		} catch (FindException e) {
			log.error("상품없음");
			e.printStackTrace();
			viewName = "fail";
		}
		return viewName;
	}	
	
	@GetMapping("/productlist")
	public String productList(Model model) {
		List<Product> list;
		try {
			list = service.findAll();
			model.addAttribute("productList", list); //대소문자 주의하세요~~~
			return "productlist";
		} catch (FindException e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "fail";
		}		
	}
	
	
}
