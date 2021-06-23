package com.day.control;

import java.io.IOException;
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
			try {
				List<Product> all = service.findAll();
				request.setAttribute("list", all);
			} catch (FindException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		String path ="";
		
		if(request.getAttribute("list")!=null) {
			path = "/productlist.jsp";
		}else {
			path = "/fail.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path); // first 객체가 있는지 확인한다.
		rd.forward(request, response); //완전 이동
	}

}
