package com.day.control;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.day.dto.Product;
import com.day.exception.FindException;
import com.day.service.ProductService;

public class ProductController implements Controller {

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
	
	public String productlist(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//1.요청데이터 얻기
		//2.비지니스로직 호출
		ProductService service;
		 service = ProductService.getInstance();
			try {
				List<Product> productList = service.findAll();
				request.setAttribute("productList", productList);
			} catch (FindException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		String path ="";
		
		if(request.getAttribute("productList")!=null) {
			path = "/productlist.jsp";
		}else {
			path = "/fail.jsp";
		}
		
		//RequestDispatcher rd = request.getRequestDispatcher(path); // first 객체가 있는지 확인한다.
		//rd.forward(request, response); //완전 이동
		return path;
	}
	public String productinfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//1.요청데이터 얻기
		String prod_no = request.getParameter("prod_no");
		ProductService service;

		//2.비지니스로직 호출
		 service = ProductService.getInstance();
		 String path = "";
		 try {
			Product p = service.findByNo(prod_no);
			request.setAttribute("p", p);
			path = "productinfo.jsp";
		} catch (FindException e) {
			e.printStackTrace();
		}
		 return path;
	}

}
