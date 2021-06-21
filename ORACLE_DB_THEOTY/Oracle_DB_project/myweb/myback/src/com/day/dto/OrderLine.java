package com.day.dto;

public class OrderLine {
	private int order_no;
	//private String order_prod_no;
	private Product order_p;
	private int order_quantity;
	
	public OrderLine() {
		super();
	}
	
	public OrderLine(Product order_p, int order_quantity) {
		super();
		this.order_p = order_p;
		this.order_quantity = order_quantity;
	}

	public OrderLine(int order_no, Product order_p, int order_quantity) {
		super();
		this.order_no = order_no;
		this.order_p = order_p;
		this.order_quantity = order_quantity;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public Product getOrder_p() {
		return order_p;
	}

	public void setOrder_p(Product order_p) {
		this.order_p = order_p;
	}

	public int getOrder_quantity() {
		return order_quantity;
	}

	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}

	@Override
	public String toString() {
		return "OrderLine [order_no=" + order_no + ", order_p=" + order_p + ", order_quantity=" + order_quantity + "]";
	}
}