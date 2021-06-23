package com.day.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.day.exception.FindException;
import com.day.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*"); //보안 정책 허용.

		//1. 요청전달데이터 얻기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		ServletContext sc =getServletContext();
		
		CustomerService.envProp = sc.getRealPath(sc.getInitParameter("env"));
		CustomerService service = CustomerService.getInstance();
		//2. 비지니스로직 호출
//		String path = "";
//		String msg = "";
//		String jsonStr = "";
		ObjectMapper mapper;
		mapper = new ObjectMapper();
		String jackson = "";
		Map<String, String> map = new HashMap<>();
		try {
			service.login(id, pwd);
			//3. 성공
//			path = "success.jsp";
//			msg = "성공";
//			jsonStr = "{\"status\" : 1}";
			map.put("status", "1");
			map.put("msg", "로그인 성공");
			jackson = mapper.writeValueAsString(map);
			System.out.println(map);
		} catch (FindException e) {
			e.printStackTrace();
			//4. 실패
//			path = "fail.jsp";
//			msg = "실패";
//			jsonStr="{\"status\" : -1, \"msg\":\""+ e.getMessage()+"\"}";
			map.put("status", "-1");
			map.put("msg", e.getMessage());
			jackson = mapper.writeValueAsString(map);
		}
		//5. 페이지 이동
//		RequestDispatcher rd = request.getRequestDispatcher(path);
//		rd.forward(request, response);
		
		//6. 응답 
		response.setContentType("application/json;charset=utf-8"); //응답형식지정
		PrintWriter out = response.getWriter();
//		out.print(jsonStr);
		out.print(jackson);
		
	}

}
