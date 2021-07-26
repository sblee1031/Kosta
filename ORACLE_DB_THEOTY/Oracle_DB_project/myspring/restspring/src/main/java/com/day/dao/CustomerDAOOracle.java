package com.day.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.day.dto.Customer;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.exception.ModifyException;
@Repository("customerDAO")
public class CustomerDAOOracle implements CustomerDAO {
//	@Autowired
//	private DataSource ds;
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Override
	public void insert(Customer c) throws AddException {
			SqlSession session = null;
			try {
				session = sessionFactory.openSession();
				session.insert("com.day.dto.CustomerMapper.insert",c);
			}catch(Exception e) {
				e.printStackTrace();
				throw new AddException(e.getMessage());
				
			}finally {
				if(session !=null) {
					session.close();
				}
			}
				
	}

	@Override
	public Customer selectById(String id) throws FindException {//로그인, 자기정보조회
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			Customer c = session.selectOne("com.day.dto.CustomerMapper.selectById", id);
			return c;
		}catch(Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}finally {
			if(session !=null) {
				session.close();
			}
		}
		
	}

	@Override
	public void update(Customer c) throws ModifyException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			session.update("com.day.dto.CustomerMapper.update", c);
		}catch(Exception e) {
			e.printStackTrace();
			throw new ModifyException(e.getMessage());
		}finally {
			if(session !=null) {
				session.close();
			}
		}
	}

	public static void main(String[] args) {
//		try {//고객가입 메서드
//			CustomerDAOOracle dao = new CustomerDAOOracle();
//			String id ="t3";
//			String pwd = "t3";
//			String name = "t3";
//			
//			Customer customer = new Customer(id,pwd,name);
//			dao.insert(customer);
//			System.out.println("id : "+ id + "pwd : "+ pwd +"name : "+ name +" 가입완료");
//			
//		} catch(AddException e) {//자식 exception 발생시 selectAll에서 발생의 경우
//			System.out.println(e.getMessage());
//		
//		}
//		catch (Exception e) {//부모 exception 발생시 ProductDAOOracle JDBC연경 상황에서 발생
//			System.out.println(e.getMessage());
//		}
		
		
//		try {//로그인, 조회 테스트
//			CustomerDAOOracle dao = new CustomerDAOOracle();
//			String id ="i3";
//			String pwd = "p4";
//			Customer customer = dao.selectById(id);
//			System.out.println("id : "+ customer.getId() 
//			+ " pwd : "+ customer.getPwd()  +" name : "+ customer.getName()  +" 조회");
//			
//			if(pwd.equals(customer.getPwd())){
//				System.out.println("로그인 성공");
//			}else if(pwd.equals(customer.getPwd())) {
//				System.out.println("패스워드가 일치하지 않습니다.");
//			}
//			
//		} catch (FindException e) {
//			System.out.println(e.getMessage());
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		

		try {//수정 테스트
		CustomerDAOOracle dao = new CustomerDAOOracle();
		String id = "id2";
		String pwd ="p2311";
		String name = "n231";
		String bulidingno = "111";
		Customer customer = new Customer(id, pwd, name, bulidingno);

		dao.update(customer);
		
		Customer db_c = dao.selectById(id);//수정된 값 id 재조회
		System.out.println("id : "+ db_c.getId() 
		+ " / pwd : "+ db_c.getPwd()  +" / name : "+ db_c.getName()  + " / buildingno : "
				+ db_c.getBuildingno() +"- 조회 완료");

	} catch (ModifyException e) {
		System.out.println(e.getMessage());
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}
		
		
//		try {//탈퇴 테스트
//		CustomerDAOOracle dao = new CustomerDAOOracle();
//		String id = "id2";
//		Customer customer = new Customer(id, null, null, null);
//	
//		dao.update(customer);
//	
//		} catch (ModifyException e) {
//			System.out.println(e.getMessage());
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		
		
	}//main

}
