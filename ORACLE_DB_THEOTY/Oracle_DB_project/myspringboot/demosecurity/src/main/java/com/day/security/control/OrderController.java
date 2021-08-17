package com.day.security.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.day.security.dto.Customer;
import com.day.security.dto.OrderInfo;
import com.day.security.dto.OrderLine;
import com.day.security.dto.Product;
import com.day.security.exception.AddException;
import com.day.security.exception.FindException;
import com.day.security.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService service;
	private Logger log = LoggerFactory.getLogger(this.getClass());

	
	@GetMapping("/addorder")
	public void addOrder(HttpSession session, Model model) {
		//로그인된 사용자만 주문가능
		Customer c = (Customer)session.getAttribute("loginInfo");
		if(c == null) {
			//로그인안된 사용자 status:0, 장바구니없음 status: -1, 추가실패:status: -2/ msg:실패이유, 
			//정상처리 : status:1
			model.addAttribute("status", 0); 
		}else {
			//1.장바구니내용 
			Map<String, Integer> cart = (Map)session.getAttribute("cart");
			if(cart != null && cart.size() > 0) {
				//2.장바구니내용을 OrderInfo객체로 변환
				OrderInfo info = new OrderInfo();
				info.setOrder_c(c);
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
				try {
					service.add(info);//주문추가
					session.removeAttribute("cart");//장바구니 비우기
					model.addAttribute("status", 1);
					log.info("주문추가성공");
				} catch (AddException e) { //추가실패인 겨우
					e.printStackTrace();
					model.addAttribute("msg", e.getMessage());
					model.addAttribute("status", -2);
					log.info("주문추가실패");
				}			
			}else { //장바구니가 비어있는 경우
				model.addAttribute("status", -1);
				log.info("주문-장바구니 빔");
			}
		}
	}
	
	@GetMapping("/orderlist")
	public void OrderList(HttpSession session, Model model) {
		Customer c = (Customer)session.getAttribute("loginInfo");
		if(c == null) {
			model.addAttribute("status", 0); //로그인 안한경우
		}else {
			//2. 비지니스로직 호출
			try {
				List<OrderInfo> infos = service.findById(c.getId());
				log.error(infos.get(0).getLines().get(0).getOrder_p().toString());
				
				model.addAttribute("infos", infos);
				
			} catch (FindException e) {
				e.printStackTrace();
				model.addAttribute("status", -1); //주문목록이 없는 경우
				model.addAttribute("msg", e.getMessage()); //예외메시지
			}
		}
	}
}
