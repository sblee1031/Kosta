package com.day.front;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.lang.model.element.QualifiedNameable;

import com.day.dto.Product;
import com.day.exception.FindException;
import com.day.servise.ProductService;

public class Main {
	private ProductService service;
	private Map<Product, Integer> cart;
	private Scanner sc = new Scanner(System.in);
	public Main() {
		cart = new HashMap<>();
		//service = new ProductService();
		service = ProductService.getInstance();
		String line = "quit";
		do {
			if(line.equals("1")) {
				viewCart();
			}else {
				list();
			}
			System.out.println("작업종류 : 1. 장바구니 보기, 엔터. 상품목록, quit. 종료");
			line = sc.nextLine();
		}while(!line.equals("quit"));
	}
	public void viewCart() {
		System.out.println("장바구니 내용");
		Set<Product> keys = cart.keySet();//맵의 키들
		for(Product p : keys) {
			int quantity = cart.get(p);//키에 해당하는 밸류 얻기
			System.out.println(p.getProd_no()+" : "+p.getProd_name()+" : "+p.getProd_price()+" : "+quantity);
		}
	}
	public void info(Product p) {
		
		System.out.println(p.getProd_no());
		System.out.println(p.getProd_name());
		System.out.println(p.getProd_price());
		System.out.println(p.getProd_mf_dt());
		System.out.println(p.getProd_detail());
		int quantity; //선택한 제품 수량
		while(true) {
			System.out.println("-----------");
			System.out.println("수량을 입력하세요.");
			String line = sc.nextLine();
			try {
				quantity = Integer.parseInt(line);
				break;
			} catch (Exception e) {
				System.out.println("다시 입력하세요.");
			}
			
		}
		System.out.println("장바구니에 추가하려면 y/ 종료하려면 n을 입력하세요");
		String line = sc.nextLine();
		if(line.equals("y")) {
			//장바구니에 추가
			//기존 상품이 존재할 경우 수량을 누적하고, 
			//기존상품이 없을 경우에는 장바구니에 상품과 수량을 추가한다.
			Integer oldQuantity = cart.get(p);
			if (oldQuantity !=null) {//기존 상품이 존재할 경우
				quantity += oldQuantity;//수량 누적
			}
			cart.put(p, quantity);
			System.out.println("장바구니에 추가 되었습니다.");
		}
		System.out.println("-------------");
	}
	public void list() {
		try {
			List<Product> all = service.findAll();
			int index = 1; //순번 표시를 위한 index
			for(Product p : all) {
				System.out.println(index+ " : "+p.getProd_no()+" : "+p.getProd_name()+" : "+p.getProd_price());
				index++;//자동 증감
			}
			System.out.println("--------------");
			System.out.println("번호를 선택하세요 :");
			
			String line = sc.nextLine();
			int no = Integer.parseInt(line);
			Product p = all.get(no-1);
			info(p);
			

		} catch (FindException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
