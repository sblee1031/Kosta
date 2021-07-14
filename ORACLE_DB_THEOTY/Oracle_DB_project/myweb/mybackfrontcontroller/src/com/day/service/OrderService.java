package com.day.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.day.dao.OrderDAO;
import com.day.dto.OrderInfo;
import com.day.exception.AddException;
import com.day.exception.FindException;

public class OrderService {

	private OrderDAO dao;
	public static String envProp;//
//	private static ProductService service = new ProductService();
	private static OrderService service;
	public static OrderService getInstance() {
		if(service == null) {
			service = new OrderService();
		}
		return service;
	}
	
	private OrderService() {
//		dao = new ProductDAOFile();
		Properties env = new Properties();
		try {
//			env.load(new FileInputStream("classes.prop"));
			env.load(new FileInputStream(envProp));
			String className = env.getProperty("orderDAO");
			Class c = Class.forName(className);//JVM에 로드됨.
			dao = (OrderDAO)c.newInstance();//자동객체생성
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

	public void add(OrderInfo info) throws AddException {
		dao.insert(info);
	}
	public List<OrderInfo> findById(String id) throws FindException{
		return dao.selectById(id);
	}
}
