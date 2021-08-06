package com.example.jpa.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "order_line")
@Table(name = "jpaorder_line")
public class OrderLine implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name = "order_no")
	private OrderInfo order_info;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "order_prod_no")
	private Product order_p;
	private int order_quantity;
	
	public OrderInfo getOrder_info() {
		return order_info;
	}
	public void setOrder_info(OrderInfo order_info) {
		this.order_info = order_info;
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
	public int hashCode() {
		return Objects.hash(order_info, order_p);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLine other = (OrderLine) obj;
		return Objects.equals(order_info, other.order_info) && Objects.equals(order_p, other.order_p);
	}

}