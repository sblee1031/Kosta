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

import com.day.dto.Product;
import com.day.exception.FindException;
import com.day.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class ProductInfoServlet
 */
public class ProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper;
		mapper = new ObjectMapper();
		String jsonStr ="";
		//1. 요청전달데이터 얻기
		String prod_no = request.getParameter("prod_no");
		
		ProductService service;
		//2. 비지니스로직호출
		ServletContext sc = getServletContext();		
		ProductService.envProp = sc.getRealPath(sc.getInitParameter("env"));
		service = ProductService.getInstance();
		String path = "";
		try {
			Product p = service.findByNo(prod_no);
			jsonStr = mapper.writeValueAsString(p);
		} catch (FindException e) {
			e.printStackTrace();
			Map<String, Object> map = new HashMap<>();
			map.put("status", -1);
			map.put("msg", e.getMessage());
			jsonStr = mapper.writeValueAsString(map);
		}
		response.setContentType("application/json;charset=utf-8"); //응답형식지정
		PrintWriter out = response.getWriter();
		out.print(jsonStr);
	}

}
