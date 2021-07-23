package com.day.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.day.dto.Customer;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService service;
	@PostMapping("/login")
	@ResponseBody
	public Object login(String id, String pwd, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		session.removeAttribute("loginInfo");
		String path;
		try {
			Customer loginInfo = service.login(id, pwd);
			//로그인 정보를 세션에 추가
			
			session.setAttribute("loginInfo", loginInfo);
			map.put("status",1);
			//3. 성공
		} catch (FindException e) {
			e.printStackTrace();
			map.put("status",0);
			map.put("msg",e.getMessage());
			//4. 실패
		}
		return map;
	}
	@GetMapping("/checklogined")
	@ResponseBody
	public Object loginchk(HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		Customer loginInfo = (Customer)session.getAttribute("loginInfo");
		//로그인 정보를 세션에 추가
		if(loginInfo != null) {
		session.setAttribute("loginInfo", loginInfo);
		map.put("status",1);
		//3. 성공
		}else {
			map.put("status",0);
		}
		return map;
	}
	
	@GetMapping("/logout")
	@ResponseBody
	public void logout(HttpSession session) {
		session.invalidate();//세션제거
		String path = "success";
	}
	
	@PostMapping("/iddupchk")
	@ResponseBody
	public Object idDupChk(String id) {
		Map<String, Object> map = new HashMap<>();
		try {
			Customer c = service.findById(id);
			if(c != null) {
				map.put("status", -1);//아이디 중복
			}else {
				 map.put("status", 1);//아이디 없음
			}
		}catch(FindException e) {
			e.printStackTrace();
		}
		return map;
	}
	@PostMapping("/signup")
	@ResponseBody
	public Object signup(Customer c) {
		Map<String, Object> map = new HashMap<>();
		try {
			service.signup(c);
			map.put("status","1");
		} catch (AddException e) {
			e.printStackTrace();
			map.put("status","0");
		}
		return map;
	}
	
}
