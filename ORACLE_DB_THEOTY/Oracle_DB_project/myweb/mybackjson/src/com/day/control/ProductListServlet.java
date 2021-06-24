package com.day.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ProductListServlet
 */
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service;
		ServletContext sc = getServletContext();		
		ProductService.envProp = sc.getRealPath(sc.getInitParameter("env"));
		service = ProductService.getInstance();
		
		ObjectMapper mapper;
		mapper = new ObjectMapper();
//		String path;
		try {
			List<Product> p_list = service.findAll();
//			request.setAttribute("productList", list);
			
			String list = mapper.writeValueAsString(p_list);
//			System.out.println(list);
			response.setContentType("application/json;charset=utf-8"); //응답형식지정
//			PrintWriter out = response.getWriter();
//			out.print(list);
			response.getWriter().print(list);
//			path = "/productlist.jsp"; 
		} catch (FindException e) {
			e.printStackTrace();
//			path = "/fail.jsp";
		}
//		RequestDispatcher rd = request.getRequestDispatcher(path);
//		rd.forward(request, response);
		//jackson라이브러리를 이용하여 작성
	
	}

}
