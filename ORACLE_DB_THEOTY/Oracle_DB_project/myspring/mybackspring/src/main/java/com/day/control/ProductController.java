package com.day.control;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.day.dto.Product;
import com.day.exception.FindException;
import com.day.service.ProductService;

@Controller //@Repository, @Service, @Controller은 모두 @Component의 하위 어노테이션이다.
public class ProductController {
	private Logger log = Logger.getLogger(ProductController.class);
	
	//@GetMapping("/productinfo")
	/*public void productInfo(HttpServletRequest request) {
		String prod_no = request.getParameter("prod_no");
		log.info("ProductController의 productInfo()입니다." + prod_no);
	}*/
	/*public void productInfo(String prod_no) {
		log.info("ProductController의 productInfo()입니다." + prod_no);
	}*/
	/*public void productInfo(@RequestParam(name = "prod_no", required = false, defaultValue = "") String no) {
		log.info("ProductController의 productInfo()입니다." + no);
	}*/
	@GetMapping("/register")
	/*public void add(String prod_no, String prod_name, int prod_price) {
		log.info("add()입니다.");
	}*/
	/*
	 public void add(Product p) { log.info("add()입니다. prod_no=" + p.getProd_no()
	  +", prod_name="+ p.getProd_name()+", prod_price="+p.getProd_price());
	  } */	
	public void add(String[] prod_no) {
		log.info("add()입니다.");
		for(String no : prod_no) {
			log.info(no);
		}
	}
/*	public void add(ArrayList<String> prod_no) {
		log.info("add()입니다.");
		for(String no : prod_no) {
			log.info(no);
		}
	}*/
	@Autowired
	private ProductService service;
	
	@GetMapping("/productinfo")
	/*public void productInfo(String prod_no, Model model) {
		try {
			Product p = service.findByNo(prod_no);
			//request.setAtrribute("p",p);
			model.addAttribute("p", p);
			
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	public ModelAndView productInfo(String prod_no) {
		ModelAndView mnv = new ModelAndView();
		try {
			Product p = service.findByNo(prod_no);
			mnv.setViewName("productinfo");
			mnv.addObject("p", p);
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mnv.setViewName("fail");
		}
		return mnv;
	}
	
	public String productInfo(String prod_no, Model model) {
		String viewName;
		try {
			Product p = service.findByNo(prod_no);
			model.addAttribute("p", p);
			viewName = "productinfo";
		}catch (FindException e){
			e.printStackTrace();
			viewName = "fail";
		}
		return viewName;
	}
	
}
