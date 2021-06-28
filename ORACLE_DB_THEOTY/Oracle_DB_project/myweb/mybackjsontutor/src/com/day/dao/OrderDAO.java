package com.day.dao;

import java.util.List;

import com.day.dto.OrderInfo;
import com.day.exception.AddException;
import com.day.exception.FindException;

public interface OrderDAO {
	/**
	 * 주문추가한다. 주문기본정보추가와 주문상세정보들을 추가한다.
	 * @param info
	 * @throws AddException
	 */
	void insert(OrderInfo  info) throws AddException;
	
	/**
	 * 주문검색한다
	 * @param id 고객아이디
	 * @return
	 * @throws FindException
	 */
	List<OrderInfo> selectById(String id) throws FindException;
}
