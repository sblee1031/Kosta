package com.day.dao;
import java.util.List;

import com.day.dto.Product;
import com.day.exception.FindException;

public interface ProductDAO{
	/**
	 * 상품 전체검색한다
	 * @return 전체상품
	 * @throws FindException 상품이 없을 경우 또는 상품찾기를 실패한 경우 발생한다
	 */
	public List<Product> selectAll() throws FindException;
	
	/**
	 * 상품 전체 검색한다
	 * @param currentPage 페이지
	 * @return 페이지에 해당하는 상품들
	 * @throws FindException 상품이 없을 경우 또는 상품찾기를 실패한 경우 발생한다
	 */
	public List<Product> selectAll(int currentPage) throws FindException;
	
	/**
	 * 상품번호로 검색한다
	 * @param prod_no 상품번호
	 * @return 상품번호에 해당하는 상품
	 * @throws FindException 상품이 없을 경우 또는 상품찾기를 실패한 경우 발생한다
	 */
	public Product selectByNo(String prod_no) throws FindException;
	
	/**
	 * 상품명으로 검색한다
	 * @param word 상품명에 해당하는 단어
	 * @return 단어를 포함한 상품들
	 * @throws FindException 상품이 없을 경우 또는 상품찾기를 실패한 경우 발생한다
	 */
	public List<Product> selectByName(String word) throws FindException;
}