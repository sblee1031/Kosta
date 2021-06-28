package com.day.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.day.dto.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CheckloginedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper;
		mapper = new ObjectMapper();
		String jsonStr ="";
		
		HttpSession session = request.getSession();
		Map<String, Object>map = new HashMap<>();
		Customer c = (Customer)session.getAttribute("loginInfo");
		int status;
		if(c == null) {
			status = 0;
		}else {
			status = 1;
		}
		map.put("status", status);
		jsonStr = mapper.writeValueAsString(map);
		
		response.setContentType("application/json;charset=utf-8"); //응답형식지정
		PrintWriter out = response.getWriter();
		out.print(jsonStr);
	}
}