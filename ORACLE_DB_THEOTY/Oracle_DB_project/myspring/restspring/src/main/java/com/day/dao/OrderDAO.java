package com.day.dao;

import java.util.List;

import com.day.dto.OrderInfo;
import com.day.exception.AddException;
import com.day.exception.FindException;

public interface OrderDAO {
	/**
	 * 주문추가한다. 주문기본정보추가와 주문상세정보
	 * @param info
	 * @throws AddException
	 */
	
	void insert(OrderInfo info) throws AddException;
	
	
	/**
	 * 주문번호에 해당하는 정보를 불러온다.
	 * @param id
	 * @return
	 * @throws FindException
	 */
	public List<OrderInfo> selectById(String id) throws FindException;
}
