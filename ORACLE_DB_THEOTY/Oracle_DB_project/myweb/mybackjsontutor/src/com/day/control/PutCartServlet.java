package com.day.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PutCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<String, Integer>cart = (Map)session.getAttribute("cart");
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
		
	}
}
