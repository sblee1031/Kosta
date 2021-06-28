package com.day.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.day.dto.Customer;
import com.day.dto.OrderInfo;
import com.day.dto.OrderLine;
import com.day.dto.Product;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.service.OrderService;


public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//로그인된 사용자만 주문가능
		String path = "orderlist1.jsp";
		Customer c = (Customer)session.getAttribute("loginInfo");
		
		if(c == null) {
			//로그인 안된 사용자 status-0, 장바구니 없음 status:-1, 추가실패:status:-2, msg:실패이유
			//정상처리 : status:1
			request.setAttribute("status", 0);
		}else {
			//3.비지니스 로직 호출
			ServletContext sc = getServletContext();
			OrderService.envProp = sc.getRealPath(sc.getInitParameter("env"));
			OrderService service;
			service = OrderService.getInstance();
			try {
				List<OrderInfo> list = service.findNyId(c.getId());
				if(list.size()==0) {
					request.setAttribute("status", -1);
				}else {
					request.setAttribute("status", 1);
					request.setAttribute("orderList", list);
				}
				System.out.println(list.get(0));
				System.out.println(list.get(1));
			} catch (FindException e1) {
				e1.printStackTrace();
			}
			
		}
		 RequestDispatcher rd = request.getRequestDispatcher(path);
		 rd.forward(request, response);
		
	}

}
