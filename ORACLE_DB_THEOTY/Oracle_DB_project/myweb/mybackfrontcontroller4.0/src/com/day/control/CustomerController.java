package com.day.control;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.day.dto.Customer;
import com.day.exception.FindException;
import com.day.service.CustomerService;

public class CustomerController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		System.out.println("contextPath:" + contextPath +", servletPath:" + servletPath);
		String methodName = servletPath.split("/", 2)[1]; //"/login"
		//if("login".equals(servletPath)) {
		//	login(request, response);
		//}		
		try {
			Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			String viewPath = (String)method.invoke(this, request, response);
			return viewPath;
		} catch (Exception e) {
			e.printStackTrace();
			return "fail.jsp";
		}

	}
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.addHeader("Access-Control-Allow-Origin", "*"); //보안 정책 허용.

		//1. 요청전달데이터 얻기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		CustomerService service = CustomerService.getInstance();
		//2. 비지니스로직 호출
		String path = "";
		HttpSession session = request.getSession();
		session.removeAttribute("loginInfo");
		try {
			Customer loginInfo = service.login(id, pwd);
			//로그인 정보를 세션에 추가
			
			session.setAttribute("loginInfo", loginInfo);
			//3. 성공
			path = "success.jsp";
		} catch (FindException e) {
			e.printStackTrace();
			//4. 실패
			path = "fail.jsp";
		}
		return path;
		//5. 페이지 이동
//		RequestDispatcher rd = request.getRequestDispatcher(path);
//		rd.forward(request, response);
	}
	public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		session.invalidate();//세션제거
		
		String path = "success.jsp";
		return path;
//		RequestDispatcher rd = request.getRequestDispatcher(path);
//		rd.forward(request, response);
	}
}
