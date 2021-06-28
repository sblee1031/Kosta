package com.day.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.day.dto.Customer;
import com.day.dto.OrderInfo;
import com.day.exception.FindException;
import com.day.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class OrderListServlet
 */
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-mm-dd"));
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		//로그인된 사용자만 주문가능

		Customer c = (Customer)session.getAttribute("loginInfo");
		
		if(c == null) {
			//로그인 안된 사용자 status-0, 장바구니 없음 status:-1, 추가실패:status:-2, msg:실패이유
			//정상처리 : status:1
//			request.setAttribute("status", 0);
			Map<String, Integer> map = new HashMap<>();
			map.put("status", 0);
			out.print(mapper.writeValueAsString(map));
		}else {
			//3.비지니스 로직 호출
			ServletContext sc = getServletContext();
			OrderService.envProp = sc.getRealPath(sc.getInitParameter("env"));
			OrderService service;
			service = OrderService.getInstance();
			try {
				List<OrderInfo> list = service.findById(c.getId());
				String jsonStr = mapper.writeValueAsString(list);
				System.out.println(jsonStr);
				out.print(jsonStr);
			} catch (FindException e1) {
				e1.printStackTrace();
			}
		}
	}

}
