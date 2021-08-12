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
// @JoinColumn은 자식엔티티클래스에서만 사용할 수 있다
// name속성값은 자식엔티티에 해당테이블의 컬럼명을 적어준다
	@JoinColumn(name = "order_id")
	private Customer order_c;
	
	@CreationTimestamp
	private Date order_dt;
	
	@OneToMany(
			//영속성전이
//			OrderRepositoryTest의 insert()추가시
//			cascade=CascadeType.ALL이 아니면
//					Hibernate: select jpaorder_seq.nextval from dual
//					Hibernate: select customer_.id, customer_.buildingno as buildingno2_0_, customer_.enabled as enabled3_0_, customer_.name as name4_0_, customer_.pwd as pwd5_0_ from jpacustomer customer_ where customer_.id=?
//					Hibernate: insert into jpaorder_info (order_id, order_dt, order_no) values (?, ?, ?)
//			cascade=CascadeType.ALL이면
//					Hibernate: select jpaorder_seq.nextval from dual
//					Hibernate: select customer_.id, customer_.buildingno as buildingno2_0_, customer_.enabled as enabled3_0_, customer_.name as name4_0_, customer_.pwd as pwd5_0_ from jpacustomer customer_ where customer_.id=?
//					Hibernate: insert into jpaorder_info (order_id, order_dt, order_no) values (?, ?, ?)
//					Hibernate: insert into jpaorder_line (order_quantity, order_prod_no, order_no) values (?, ?, ?)
//					Hibernate: insert into jpaorder_line (order_quantity, order_prod_no, order_no) values (?, ?, ?)
			 cascade = CascadeType.ALL
			, 
			// 양방향(양쪽에서 모두 참조를 사용)경우 
			// 어떤쪽이 PK가 되고 어떤쪽이 FK가 되는지를 명시해 줄 필요가 있다.
			// @OneToMany어노테이션의 mappedBy속성을 이용해서 
			// 자신이 다른객체에게'매여있다'는 것을 명시해야한다.

			// 자식엔티티가있는 상태에서는 부모엔티티 삭제가 불가능하기때문에 
			// '부모엔터티는 자식엔티티에게 매여있다'고 볼 수 있다 
			// mappedBy속성 값은 자식엔티티클래스의 FK역할을 하는 멤버필드명을 지정한다
			mappedBy = "order_info"
			,
			
			//JPA는 연관관계가 있는 엔티티를 조회할 때 defualt로 지연로딩을 합니다. 
			//여러 엔티티들과 종속적인 관계를 맺고 있다면 조인이 필요, 조인이 복잡할 수록 성능저하!, 
			//정보가 필요하기 전까지 최대한 테이블에 접근하지 않는 방식을 사용합니다.
			//즉시 로딩은 조인은 이용해서 정보를 처리합니다.
			//즉시로딩을 안한다면 @Transactional로 처리할 수 도 있습니다.

//			@OneToMany의 속성으로 
//			  fetch = FetchType.LAZY를 사용(지연로딩)하거나
//			  OrderRepositoryTest의 findAll() @Transactional없이전체검색시
//					Hibernate: select orderinfo0_.order_no as order_no1_1_, orderinfo0_.order_id as order_id3_1_, orderinfo0_.order_dt as order_dt2_1_ from jpaorder_info orderinfo0_
//					Hibernate: select customer0_.id as id1_0_0_, customer0_.buildingno as buildingno2_0_0_, customer0_.enabled as enabled3_0_0_, customer0_.name as name4_0_0_, customer0_.pwd as pwd5_0_0_ from jpacustomer customer0_ where customer0_.id=?
//                    결과 : --주문기본정보--
//					          info.no:1, c.id:id1
//					        --주문상세정보--
			
//			@OneToMany의 속성으로 
//			  fetch = FetchType.EAGER를 사용(즉시로딩)하거나 
//			  OrderRepositoryTest의 findAll()에 @Transactional 사용하면 전체검색시
//                  결과 : 
//					Hibernate: select orderinfo0_.order_no as order_no1_1_, orderinfo0_.order_id as order_id3_1_, orderinfo0_.order_dt as order_dt2_1_ from jpaorder_info orderinfo0_
//					Hibernate: select customer0_.id as id1_0_0_, customer0_.buildingno as buildingno2_0_0_, customer0_.enabled as enabled3_0_0_, customer0_.name as name4_0_0_, customer0_.pwd as pwd5_0_0_ from jpacustomer customer0_ where customer0_.id=?
//                          --주문기본정보--
//					          info.no:1, c.id:id1
			
//		            Hibernate: select lines0_.order_no as order_no3_2_0_, lines0_.order_prod_no as order_prod_no2_2_0_, lines0_.order_prod_no as order_prod_no2_2_1_, lines0_.order_no as order_no3_2_1_, lines0_.order_quantity as order_quantity1_2_1_, product1_.prod_no as prod_no1_3_2_, product1_.prod_mf_dt as prod_mf_dt2_3_2_, product1_.prod_name as prod_name3_3_2_, product1_.prod_price as prod_price4_3_2_ from jpaorder_line lines0_ inner join jpaproduct product1_ on lines0_.order_prod_no=product1_.prod_no where lines0_.order_no=?
//					        --주문상세정보--
//					line.no:1, line.p.prod_no:C0001
//					line.no:1, line.p.prod_no:C0002
			fetch = FetchType.LAZY
			)	
//	@JoinColumn(name = "order_no")(X)
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