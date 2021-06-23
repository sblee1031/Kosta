package com.day.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.day.dao.ProductDAO;
import com.day.dto.Product;
import com.day.exception.FindException;

public class ProductService {

	private ProductDAO dao;
	public static String envProp;//
//	private static ProductService service = new ProductService();
	private static ProductService service;
	public static ProductService getInstance() {
		if(service == null) {
			service = new ProductService();
		}
		return service;
	}
	
	private ProductService() {
//		dao = new ProductDAOFile();
		Properties env = new Properties();
		try {
//			env.load(new FileInputStream("classes.prop"));
			env.load(new FileInputStream(envProp));
			String className = env.getProperty("productDAO");
			Class c = Class.forName(className);//JVM에 로드됨.
			dao = (ProductDAO)c.newInstance();//자동객체생성
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (InstantiationException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

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
	
	public static void main(String[] args) {
		ProductService service = ProductService.getInstance();
		try {
			List<Product> all= service.findAll();
			for(Product p : all) {
				System.out.println(p);
			}
		} catch (FindException e) {
			e.printStackTrace();
		}
	}

}
