package com.day.security.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/myLogin")
	public void getMyLogin(String error, String logout, Model model) {
		if(error != null) { //인증실패인 경우 전달된 요청전달데이터 error
			//error내용을 view에 전달
			//model.addAttribute("error", "인증실패되었습니다"); //?
			model.addAttribute("error", error);

			log.error("ERROR : " + error);
		}
		if(logout != null) { //로그아웃된 경우 
			model.addAttribute("logout", "로그아웃되었습니다");
		}
	} 


	@RequestMapping("/accessError")
	public void accessError(Authentication auth, Model model) {
		log.error("accessError");
		if(auth != null) {
			String userName = auth.getName(); 
			model.addAttribute("msg", userName+"은 접근불가한 사이트입니다");
		}
	}

	@GetMapping("/admin")
	public String admin() { 
		//return "admin/main";
		return "semantic_css_jq";
	}
	@GetMapping("/user")
	public String user() { 
		return "semantic_css_jq";
	}
	@GetMapping("/manager")
	public String manager() { 
		//return "manager/main";
		return "semantic_css_jq";
	}
	
	@GetMapping("/admin/addproduct")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_ADMIN')") 
	public String addProduct(Authentication auth) {
		String username = auth.getName();
		return username +"관리자가 상품을 추가했습니다";
	}

}
