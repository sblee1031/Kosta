package hello.hellospring.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dao.MemberDAO;
import dto.MemberDTO;

@Controller
public class LoginController {

	MemberDTO memberDTO = MemberDTO.getInstance();
	MemberDAO memberDAO = MemberDAO.getInstance();
	
	
	@GetMapping("main")
	public String create() {
		return "main";
	}
	
	@PostMapping("login")
	public String login(MemberDTO form) {
		memberDTO.setMember_Id(form.getMember_Id());
		memberDTO.setMember_Pw(form.getMember_Pw());
		ArrayList<String> login_arr = memberDAO.MemberMatch(form.getMember_Id(), form.getMember_Pw());
//		System.out.println(login_arr.toString());
//		System.out.println("id : "+memberDTO.getMember_Id());
//		System.out.println("pw : "+memberDTO.getMember_Pw());
		String login ="";
		if(login_arr.size()==0){
			login = "login_fail";//로그인 실패
			System.out.println("로그인 실패");
		}
		else if(memberDTO.getMember_Id().equals(login_arr.get(0))&&memberDTO.getMember_Pw().equals(login_arr.get(1))) {
			login = "redirect:cartable";//로그인 성공
			System.out.println("로그인 성공");
		}
		login_arr.clear();
		return login;
	}
	
	
}
