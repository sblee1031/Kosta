package com.day.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.day.dto.Product;
import com.day.exception.FindException;
import com.day.service.ProductService;

/**
 * Servlet implementation class ViewCartServlet
 */
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.요청전달데이터 얻기
		//2. 비지니스로직 호출
		ProductService service;
		ServletContext sc = getServletContext();
		ProductService.envProp = sc.getRealPath(sc.getInitParameter("env"));
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
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
