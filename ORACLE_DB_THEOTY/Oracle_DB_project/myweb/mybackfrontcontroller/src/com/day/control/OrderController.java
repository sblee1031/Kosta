package com.day.control;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
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

public class OrderController implements Controller {

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
	
	
	public String addorder(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		//로그인된 사용자만 주문가능
		String path = "addorder.jsp";
		Customer c = (Customer)session.getAttribute("loginInfo");
		if(c == null) {
			//로그인 안된 사용자 status-0, 장바구니 없음 status:-1, 추가실패:status:-2, msg:실패이유
			//정상처리 : status:1
			request.setAttribute("status", 0);
		}else {
			
			//1.장바구니 내용
			Map<String, Integer> cart = (Map)session.getAttribute("cart");
			if(cart != null && cart.size()>0) {
				//2.장바구니 내용을 OrderInfo객체로 변환
				OrderInfo info = new OrderInfo();
				List<OrderLine> lines = new ArrayList<>();
				for(String prod_no : cart.keySet()) {
					int quantity = cart.get(prod_no);
					
					OrderLine line = new OrderLine(); //주문상세
					Product order_p = new Product();
					order_p.setProd_no(prod_no);
					line.setOrder_p(order_p); //주문상품
					line.setOrder_quantity(quantity);//주문수량
					lines.add(line);
				}
				info.setLines(lines); //주문 상세들
				info.setOrder_c(c);//주문자
				//3.비지니스 로직 호출
				OrderService service;
				service = OrderService.getInstance();
					try {
						service.add(info);
						session.removeAttribute("cart");//장바구니 비우기
						request.setAttribute("status", 1);
					} catch (AddException e) {//추가실패인경우
						e.printStackTrace();
						request.setAttribute("msg", e.getMessage());
						request.setAttribute("status", -2);
					}
				//service.add()
			}else { // 장바구니 비어 있는경우
				request.setAttribute("status", -1);
			}
		}
		return path;
	}
	
	public String orderlist(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
	HttpSession session = request.getSession();
	//로그인된 사용자만 주문가능

	Customer c = (Customer)session.getAttribute("loginInfo");
	
	if(c == null) {
		//로그인 안된 사용자 status-0, 장바구니 없음 status:-1, 추가실패:status:-2, msg:실패이유
		//정상처리 : status:1
		request.setAttribute("status", 0);
	}else {
		//3.비지니스 로직 호출
		OrderService service;
		service = OrderService.getInstance();
		try {
			List<OrderInfo> list = service.findById(c.getId());
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
	String path = "orderlist1.jsp";
	return path;
	}
}
