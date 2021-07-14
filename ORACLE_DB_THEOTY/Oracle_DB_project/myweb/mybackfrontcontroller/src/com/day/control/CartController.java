package com.day.control;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.day.dto.Product;
import com.day.exception.FindException;
import com.day.service.ProductService;

public class CartController implements Controller {

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
	public String putcart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		Map<String, Integer> cart = (Map)session.getAttribute("cart");
		if(cart == null) {
			cart = new HashMap<>();
			session.setAttribute("cart", cart);
		}
		//요청전달데이터 얻기
		String prod_no = request.getParameter("prod_no");
		String quantity = request.getParameter("quantity");
		Integer intQuantity = new Integer(quantity);
		Integer oldQuantity = (Integer)cart.get(prod_no);
		if(oldQuantity != null) {
			intQuantity += oldQuantity;
		}
		cart.put(prod_no, intQuantity);
		
		System.out.println(cart);
		String path = "success.jsp";
		return path;
	}
	public String viewcart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//1.요청전달데이터 얻기
				//2. 비지니스로직 호출
				ProductService service;
				 service = ProductService.getInstance();
				//세션의 장바구니를 찾기
				HttpSession session = request.getSession();
				Map<String, Integer> cart = (Map)session.getAttribute("cart");
				
				Map<Product, Integer> result = new HashMap<>();
				//장바구니가 있다면
				if(cart != null && cart.size() >0) {
				//	상품번호에 해당하는 상품 정보 찾기
					Set<String>prod_nos = cart.keySet();
					for(String prod_no: prod_nos) {
						Product p;
						try {
							p = service.findByNo(prod_no);
							result.put(p, cart.get(prod_no));
						} catch (FindException e) {
							e.printStackTrace();
						}
					}
					
				}
				//3.요청속성 추가
				request.setAttribute("result", result);
				
				//4. 페이지 이동
				String path = "viewcart.jsp";
				return path;
	}

}
