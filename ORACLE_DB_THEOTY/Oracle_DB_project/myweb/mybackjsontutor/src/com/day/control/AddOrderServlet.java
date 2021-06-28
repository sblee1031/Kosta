package com.day.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
import com.day.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper;
		mapper = new ObjectMapper();
		String jsonStr ="";
		
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<>();
		//로그인된 사용자만 주문가능
		Customer c = (Customer)session.getAttribute("loginInfo");
		if(c == null) {
			//로그인안된 사용자 status:0, 장바구니없음 status: -1, 추가실패:status: -2/ msg:실패이유, 
			//정상처리 : status:1
			map.put("status", 0);
		}else {
			//----로그인된 경우 테스트----
			//Customer c = new Customer();
			//c.setId("id1");
			//-----------------------
			//1.장바구니내용 
			Map<String, Integer> cart = (Map)session.getAttribute("cart");
			if(cart != null && cart.size() > 0) {
				//2.장바구니내용을 OrderInfo객체로 변환
				OrderInfo info = new OrderInfo();
				List<OrderLine> lines = new ArrayList<>();
				for(String prod_no: cart.keySet()) {
					int quantity = cart.get(prod_no);
					
					OrderLine line = new OrderLine(); //주문상세
					Product order_p = new Product(); 
					order_p.setProd_no(prod_no);
					line.setOrder_p(order_p);   //주문상품				
					line.setOrder_quantity(quantity);//주문수량
					lines.add(line);
				}		
				info.setLines(lines); //주문상세들			
				info.setOrder_c(c); //주문자
				//3.비지니스로직 호출
				ServletContext sc = getServletContext();		
				OrderService.envProp = sc.getRealPath(sc.getInitParameter("env"));
				OrderService service;
				service = OrderService.getInstance();
				try {
					service.add(info);//주문추가
					session.removeAttribute("cart");//장바구니 비우기
//					request.setAttribute("status", 1);
					map.put("status", 1);
				} catch (AddException e) { //추가실패인 겨우
					e.printStackTrace();
//					request.setAttribute("msg", e.getMessage());
//					request.setAttribute("status", -2);
					map.put("msg", e.getMessage());
					map.put("status", -2);
				}			
			}else { //장바구니가 비어있는 경우
//				request.setAttribute("status", -1);
				map.put("status", -1);
			}
		}
		jsonStr = mapper.writeValueAsString(map);
		response.setContentType("application/json;charset=utf-8"); //응답형식지정
		PrintWriter out = response.getWriter();
		out.print(jsonStr);
	}

}
