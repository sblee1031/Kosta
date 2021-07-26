package com.day.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.day.dao.ProductDAO;
import com.day.dto.Product;
import com.day.exception.FindException;
@Service
public class ProductService {
	@Autowired
	@Qualifier("productDAO1")
	private ProductDAO dao;
	
	public List<Product> findAll() throws FindException{
		return dao.selectAll();
//		List<Product> list = dao.selectAll();
//		list암호화
//		암호화된 리스트 반환
	}
	public List<Product> findAll(int currentPage) throws FindException{
		return dao.selectAll(currentPage);
	}
	public Product findByNo(String prod_no) throws FindException{
		return dao.selectByNo(prod_no);
	}
	public List<Product> findByName(String word) throws FindException{
		//상품번호를 복호화
		//dao.selectByNo(복호화 값);
		return dao.selectByName(word);
	}


}
