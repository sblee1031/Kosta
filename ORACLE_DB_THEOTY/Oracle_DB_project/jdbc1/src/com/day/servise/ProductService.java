package com.day.servise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.day.dao.ProductDAO;
import com.day.dto.Product;
import com.day.exception.FindException;

public class ProductService {

	private ProductDAO dao;
	private static ProductService service = new ProductService();
	
	public static ProductService getInstance() {
		return service;
	}
	
	private ProductService() {
//		dao = new ProductDAOFile();
		Properties env = new Properties();
		try {
			env.load(new FileInputStream("classes.prop"));
			String className = env.getProperty("productDAO");
			Class c = Class.forName(className);
			dao = (ProductDAO)c.newInstance();
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
	}

}
