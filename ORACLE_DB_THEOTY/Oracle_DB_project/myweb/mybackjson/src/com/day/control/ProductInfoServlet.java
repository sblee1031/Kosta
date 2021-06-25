package com.day.control;

import java.io.IOException;
import java.util.List;

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
		String prod_no = request.getParameter("prod_no");
		ProductService service;
		ServletContext sc = getServletContext();		
		ProductService.envProp = sc.getRealPath(sc.getInitParameter("env"));
		service = ProductService.getInstance();
		
		ObjectMapper mapper;
		mapper = new ObjectMapper();
		try {
			Product p = service.findByNo(prod_no);
			
			String list = mapper.writeValueAsString(p);
			response.setContentType("application/json;charset=utf-8"); //응답형식지정
			response.getWriter().print(list);
		} catch (FindException e) {
			e.printStackTrace();
		}
	}

}
