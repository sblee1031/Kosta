package com.day.security.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.day.security.dao.ProductDAO;
import com.day.security.dto.Product;
import com.day.security.exception.FindException;

@Service
public class ProductService {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductDAO dao;
	public List<Product> findAll() throws FindException{
		return dao.selectAll();
	}
	public List<Product> findAll(int currentPage) throws FindException{
		return dao.selectAll(currentPage);
	}
	public Product findByNo(String prod_no) throws FindException{
		//상품번호를 복호화
		//dao.selectByNo(복호화된 값);
		log.error("in findByNo : 상품있음");
		return dao.selectByNo(prod_no);
	}
	public List<Product> findByName(String word) throws FindException{
		return dao.selectByName(word);
	}
}
