package com.day.service;

import java.io.FileInputStream;
import java.util.Properties;

import com.day.dao.CustomerDAO;
import com.day.dto.Customer;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.exception.ModifyException;

public class CustomerService {
	private CustomerDAO dao;
	private static CustomerService service = new CustomerService();
	private CustomerService() {
		Properties env = new Properties();
		try {
			env.load(new FileInputStream("classes.prop"));
			String className = env.getProperty("customerDAO");
			Class c = Class.forName(className);
			dao = (CustomerDAO)c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param c
	 * @throws AddException
	 */
	public void signup(Customer c) throws AddException{
		dao.insert(c);
	}
	/**
	 * 
	 * @param id
	 * @param pwd
	 * @throws FindException
	 */
	public void login(String id, String pwd) throws FindException{
		Customer c = dao.selectById(id);
		if(!c.getPwd().equals(pwd)) {
			throw new FindException("로그인 실패");
		}
	}
	/**
	 * 
	 * @param id
	 * @return
	 * @throws FindException
	 */
	public Customer detail(String id) throws FindException{
		return dao.selectById(id);
	}
	/**
	 * 
	 * @param c
	 * @throws ModifyException
	 */
	public void modify(Customer c) throws ModifyException{
		if(c.getEnabled() == 0) { //
			throw new ModifyException("탈퇴작업은 할 수 없습니다");
		}
		dao.update(c);
	}
	/**
	 * 
	 * @param c
	 * @throws ModifyException
	 */
	public void leave(Customer c) throws ModifyException{
		c.setEnabled(0);
		dao.update(c);
	}
	
}
