package com.day.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.day.service.CustomerService;
import com.day.service.OrderService;
import com.day.service.ProductService;


@WebServlet(urlPatterns = {"/"})
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("DispatcherServlet이 호출됨");

		ServletContext sc = getServletContext();
		CustomerService.envProp = sc.getRealPath(sc.getInitParameter("env"));
		ProductService.envProp = sc.getRealPath(sc.getInitParameter("env"));
		OrderService.envProp = sc.getRealPath(sc.getInitParameter("env"));
	
		//요청servletpath에 따라 사용될 Controller와 method가 달라짐
		String servletPath = request.getServletPath();
		//System.out.println(servletPath);
		Controller controller;
		//controller.prop파일로드
		
//		String realPath = sc.getRealPath("/WEB-INF/controller.prop");//프로퍼티파일의 실제 경로 찾기
		String realPath = sc.getRealPath(sc.getInitParameter("env.controller"));
		Properties env = new Properties();
		env.load(new FileInputStream(realPath));
		
		String controllerClassName = env.getProperty(servletPath);
		//System.out.println(controllerClassName);
		try {
			Class clazz = Class.forName(controllerClassName);
			Object obj = clazz.newInstance();
			controller = (Controller)obj;
			String viewPath = controller.execute(request,response);
			RequestDispatcher rd = request.getRequestDispatcher(viewPath);
			rd.forward(request, response);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
//		customerController = new CustomerController();
//		customerController.execute(request,response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
