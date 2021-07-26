package com.day.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.day.dto.Product;
import com.day.exception.FindException;
import com.day.service.ProductService;

//@Controller //@Repository, @Service, @Controller은 모두 @Component의 하위 어노테이션이다.
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/productinfo")
	@ResponseBody
//	public String productInfo(String prod_no) {
//		String jsonStr;
//		try {
//			Product p = service.findByNo(prod_no);
//			jsonStr = "{\"msg\": \"success\"}";
//		}catch (FindException e){
//			e.printStackTrace();
//			jsonStr ="{\"msg\": \"fail\"}";
//		}
//		return jsonStr;
//	}
	
	
//	public Product productInfo(String prod_no) {
//		try{
//			Product p = service.findByNo(prod_no);
//			return p; //Product타입의 객체의 toString()호출되어 응답바디에 쓰기 된다.
//		}catch (FindException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
	public Object productInfo(String prod_no) {
		HashMap<String, Object> map = new HashMap<>();
		try{
			Product p = service.findByNo(prod_no);
			return p;
		}catch (FindException e) {
			e.printStackTrace();
			map.put("status", 0);
			map.put("msg",e.getMessage());
			return map;
		}
		
	}
	
//	@GetMapping("/productlist")
//	public String productList(Model model) {
//		List<Product> productList;
//		try {
//			productList = service.findAll();
//			model.addAttribute("productList", productList);
//			return "productlist";
//		} catch (FindException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			model.addAttribute("msg", e.getMessage());
//			return "fail";
//		}
//		
//	}
	
	@GetMapping("/productlist")
	@ResponseBody
	public List<Product> productList(){
		List<Product> list;
		try {
			list = service.findAll();
			return list;
		}catch(FindException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
