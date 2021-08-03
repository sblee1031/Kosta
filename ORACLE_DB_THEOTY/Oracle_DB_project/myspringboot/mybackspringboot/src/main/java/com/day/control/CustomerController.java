package com.day.control;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.day.dto.Customer;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.service.CustomerService;

@Controller
public class CustomerController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@GetMapping("/login")
	public void loginGet() {
		log.info("GET");
	}
	
	@Autowired
	CustomerService service;
	@PostMapping("/login")
	public String login(String id, String pwd, HttpSession session) {
		session.removeAttribute("loginInfo");
		String path;
		try {
			Customer loginInfo = service.login(id, pwd);
			//로그인 정보를 세션에 추가
			
			session.setAttribute("loginInfo", loginInfo);
			//3. 성공
			path = "success";
		} catch (FindException e) {
			e.printStackTrace();
			//4. 실패
			path = "fail";
		}
		return path;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();//세션제거
		
		String path = "success";
		return path;
	}
	@GetMapping("/iddupchk")
	public void idDupChk(String id, Model model) {
		try {
			Customer c = service.findById(id);
			model.addAttribute("result","0");
		}catch(FindException e) {
			model.addAttribute("result", "1");
			
		}
	}
	@PostMapping("/signup")
	public void signup(Customer c, Model model) {
		log.info(c.toString());
		try {
			service.signup(c);
			model.addAttribute("result","1");
		} catch (AddException e) {
			e.printStackTrace();
			model.addAttribute("result","0");
		}
	}
	
}
