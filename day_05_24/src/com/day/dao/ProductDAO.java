/*
 * 추가한다
 * 전체조회한다
 * 상품번호로 조회 한다
 * 상품명으로 조회한다
 * 수정한다
 * 삭제한다
*/

package com.day.dao;

import java.util.List;

import com.day.dto.Product;
import com.day.exception.FindException;

public class ProductDAO {

	/**
	 * 
	 * @return
	 */
	public List<Product> selectAll() throws FindException{ 
		return null;
	}
	
	public Product selectByNo(String prod_no) {
		return null;
	}
	
	public List<Product> selectByName(String word){
		return null;
		
	}
	
	
}
