package com.day.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.day.dto.Customer;
import com.day.dto.OrderInfo;
import com.day.dto.OrderLine;
import com.day.dto.Product;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.service.OrderService;

@Controller
public class OrderController {
	private Logger log = Logger.getLogger(OrderController.class);
	@Autowired
	OrderService service;
	@GetMapping("/addorder")
	public String addOrder(HttpSession session, Model model) {
		String path = "addorder";
		Customer c = (Customer)session.getAttribute("loginInfo");
		
		if(c == null) {
			//로그인 안된 사용자 status-0, 장바구니 없음 status:-1, 추가실패:status:-2, msg:실패이유
			//정상처리 : status:1
			model.addAttribute("status", 0);
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
						model.addAttribute("status", 1);
					} catch (AddException e) {//추가실패인경우
						e.printStackTrace();
						model.addAttribute("msg", e.getMessage());
						model.addAttribute("status", -2);
					}
				//service.add()
			}else { // 장바구니 비어 있는경우
				model.addAttribute("status", -1);
			}
		}
		return path;
	}
	@GetMapping("/orderlist")
	public String orderList(HttpSession session, Model model) {
		Customer c = (Customer)session.getAttribute("loginInfo");
		if(c == null) {
			//로그인 안된 사용자 status-0, 장바구니 없음 status:-1, 추가실패:status:-2, msg:실패이유
			//정상처리 : status:1
			model.addAttribute("status", 0);
		}else {
			try {
				List<OrderInfo> infos = service.findById(c.getId());
					log.error(infos.get(0).getLines().get(0).getOrder_p());
					model.addAttribute("status", 1);
					model.addAttribute("orderList", infos);
			} catch (FindException e) {
					//e1.printStackTrace();
					model.addAttribute("status", -1);
					model.addAttribute("msg", e.getMessage());
			}
		}
		String path = "orderlist";
		return path;
		}
}
