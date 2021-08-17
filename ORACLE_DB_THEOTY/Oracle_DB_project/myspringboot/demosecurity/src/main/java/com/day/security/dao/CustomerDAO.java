package com.day.security.dao;

import com.day.security.dto.Customer;
import com.day.security.exception.AddException;
import com.day.security.exception.FindException;
import com.day.security.exception.ModifyException;

public interface CustomerDAO {
	/**
	 * 
	 * @param c
	 * @throws AddException
	 */
	void insert(Customer c) throws AddException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws FindException
	 */
	Customer selectById(String id) throws FindException;
	/**
	 * 
	 * @param c
	 * @throws ModifyException
	 */
	void update(Customer c) throws ModifyException;
}
