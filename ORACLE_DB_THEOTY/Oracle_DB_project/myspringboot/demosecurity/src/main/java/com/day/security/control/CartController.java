package com.day.security.control;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.day.security.dto.Product;
import com.day.security.exception.FindException;
import com.day.security.service.ProductService;

@Controller
public class CartController {
	@Autowired
	private ProductService service;
	
	@GetMapping("/putcart")
	public String putCart(String prod_no, int quantity,HttpSession session) {
		Map<String, Integer>cart = (Map)session.getAttribute("cart");
		if(cart == null) {
			cart = new HashMap<>();
			session.setAttribute("cart", cart);
		}	
		Integer oldQuantity = (Integer)cart.get(prod_no);
		if(oldQuantity != null) {
			quantity += oldQuantity;
		}		
		cart.put(prod_no, quantity);	
		return "success";
	}
	
	@GetMapping("/viewcart")
	public void viewCart(HttpSession session, Model model) {
		//세션의 장바구니를 찾기
		Map<String, Integer>cart = (Map)session.getAttribute("cart");	
		Map<Product, Integer>result = new HashMap<>();
		//장바구니가 있다면
		if(cart != null && cart.size() > 0) {
			//System.out.println("장바구니 크기: " + cart.size());
			//상품번호에 해당하는 상품정보찾기
			Set<String>prod_nos = cart.keySet();
			for(String prod_no: prod_nos) {
				Product p;
				try {
					p = service.findByNo(prod_no);
					result.put(p, cart.get(prod_no));//요청속성으로 사용할 result에 추가
				} catch (FindException e) {
					e.printStackTrace();
				}
			}
		}
		model.addAttribute("result", result);
	}
	
}
