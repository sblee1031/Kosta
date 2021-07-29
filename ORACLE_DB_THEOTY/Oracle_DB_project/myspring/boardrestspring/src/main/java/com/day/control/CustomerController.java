package com.day.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.day.dto.Customer;
import com.day.exception.FindException;
import com.day.service.CustomerService;

@RestController
@RequestMapping("/customer/*")
public class CustomerController {

	@Autowired
	private CustomerService service;
	@PostMapping("/login")
	public Map<String, Object> login(String id, String pwd, HttpSession request){
		Customer login = (Customer)request.getAttribute("loginInfo");
		Customer c = new Customer();
		Map<String, Object> result = new HashMap<>();
		if(login==null) {
			try {
				System.out.println(id+" / "+pwd);
				c = service.login(id, pwd);
				request.setAttribute("loginInfo", c);
				result.put("status",1);
				result.put("loginInfo",c);
			} catch (Exception e) {
				result.put("status",0);//실패
				result.put("msg",e.getMessage());//실패
			}
		}else {
			result.put("status",1);
			result.put("loginInfo",login);
		}
		return result;
	}
	@PostMapping("/logout")
	public Map<String, Object> login(HttpSession request){
		Map<String, Object> result = new HashMap<>();
		request.invalidate();
		result.put("status",0);
		return result;
	}
}
