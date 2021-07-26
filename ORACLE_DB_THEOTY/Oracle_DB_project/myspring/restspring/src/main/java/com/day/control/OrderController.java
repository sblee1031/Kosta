package com.day.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.day.dto.Customer;
import com.day.dto.OrderInfo;
import com.day.dto.OrderLine;
import com.day.dto.Product;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.service.OrderService;

//@Controller
public class OrderController {
	@Autowired
	OrderService service;
	@GetMapping("/addorder")
	@ResponseBody
	public Object addOrder(HttpSession session) {
		Customer c = (Customer)session.getAttribute("loginInfo");
		Map<String, Object> map = new HashMap<>();
		if(c == null) {
			//로그인 안된 사용자 status-0, 장바구니 없음 status:-1, 추가실패:status:-2, msg:실패이유
			//정상처리 : status:1
			map.put("status", 1);
		}else {
			//1.장바구니 내용
			Map<String, Integer> cart = (Map)session.getAttribute("cart");
			System.out.println("cart size : "+cart.size());
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
					try {
						service.add(info);
						session.removeAttribute("cart");//장바구니 비우기
						map.put("status", 1);
					} catch (AddException e) {//추가실패인경우
						e.printStackTrace();
						map.put("msg", e.getMessage());
						map.put("status", -2);
					}
				//service.add()
			}else { // 장바구니 비어 있는경우
				map.put("status", -1);
			}
		}
		return map;
	}
	@GetMapping("/orderlist")
	@ResponseBody
	public Object orderList(HttpSession session) {
		Customer c = (Customer)session.getAttribute("loginInfo");
		Map<String, Object> map = new HashMap<>();
		if(c == null) {
			//로그인 안된 사용자 status-0, 장바구니 없음 status:-1, 추가실패:status:-2, msg:실패이유
			//정상처리 : status:1
			map.put("status", 0);
		}else {
			try {
				List<OrderInfo> infos = service.findById(c.getId());
					map.put("status", 1);
					map.put("orderList", infos);
			} catch (FindException e) {
					//e1.printStackTrace();
				map.put("status", -1);
				map.put("msg", e.getMessage());
			}
		}
		return map;
		}
}
