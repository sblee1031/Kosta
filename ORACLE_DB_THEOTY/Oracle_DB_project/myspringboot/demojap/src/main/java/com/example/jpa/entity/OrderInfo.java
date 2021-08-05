package com.example.jpa.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
@Entity(name="order_info")
@Table(name="jpaorder_info")
@SequenceGenerator(
		   name = "jpaorder_seq_generator"// 사용할 sequence 이름
		  ,sequenceName ="jpaorder_seq" // 실제 데이터베이스 sequence 이름
		  ,initialValue = 1
		  , allocationSize = 1
		)
public class OrderInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE
					,generator = "jpaorder_seq_generator")
	private int order_no;
	@ManyToOne
	@JoinColumn(name = "order_id")
//	@Transient
	private Customer order_c;
	
	@CreationTimestamp
	private Date order_dt;
	
	@OneToMany(
			//영속성전이
			cascade = CascadeType.ALL
			, 
			//JPA는 연관관계가 있는 엔티티를 조회할 때 defualt로 지연로딩을 합니다. 여러 엔티티들과 종속적인 관계를 맺고 있다면 조인이 필요, 조인이 복잡할 수록 성능저하!, 정보가 필요하기 전까지 최대한 테이블에 접근하지 않는 방식을 사용합니다.
			//즉시 로딩은 조인은 이용해서 정보를 처리합니다.
			//즉시로딩을 안한다면 @Transactional로 처리할 수 도 있습니다.
			fetch = FetchType.EAGER
			,mappedBy = "order_info"
			)
	
//	@JoinColumn(name = "order_no")
//@Transient
	private List<OrderLine> lines;
	public OrderInfo() {
		super();
	}
	
	public OrderInfo(Customer order_c) {
		super();
		this.order_c = order_c;
	}
	
	public OrderInfo(Customer order_c, List<OrderLine> lines) {
		super();
		this.order_c = order_c;
		this.lines = lines;
	}
	public OrderInfo(int order_no, Customer order_c, Date order_dt, List<OrderLine> lines) {
		super();
		this.order_no = order_no;
		this.order_c = order_c;
		this.order_dt = order_dt;
		this.lines = lines;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public Customer getOrder_c() {
		return order_c;
	}

	public void setOrder_c(Customer order_c) {
		this.order_c = order_c;
	}

	public Date getOrder_dt() {
		return order_dt;
	}

	public void setOrder_dt(Date order_dt) {
		this.order_dt = order_dt;
	}

	public List<OrderLine> getLines() {
		return lines;
	}

	public void setLines(List<OrderLine> lines) {
		this.lines = lines;
	}

	@Override
	public String toString() {
		return "OrderInfo [order_no=" + order_no + ", order_c=" + order_c + ", order_dt=" + order_dt + ", lines="
				+ lines + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(order_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderInfo other = (OrderInfo) obj;
		return order_no == other.order_no;
	}
	
	
}