package com.day.dao;

import com.day.dto.Customer;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.exception.ModifyException;

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
