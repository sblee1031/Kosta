package com.day.control.FirstServlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        System.out.println("FirstServlet객체생성됨");
//        //context-param얻기
//        ServletContext sc = getServletContext();
//        String devName = sc.getInitParameter("Developer");
//        System.out.println("책임 개발자 :" + devName);
    }


	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FirstServlet의 init() 메서드 호출");
		super.init(config); //servletcontext객체 참조 작업 해줌.
		//context-param얻기
	      ServletContext sc = getServletContext();
	      String devName = sc.getInitParameter("Developer");
	      System.out.println("책임 개발자 :" + devName);
	      String realPath = sc.getRealPath("logo.jpg");
	      System.out.println("logo.jpg의 실제경로 :"+realPath);
	      File file = new File(realPath);
	      if(!file.exists()) {
	    	  System.out.println("logo.jpg 파일이 없습니다");
	      }
	      //servlet의 init-param값 얻기
	      String fileName=this.getInitParameter("fileName");
	      System.out.println("FistServlet에서만 사용할 수 있는 파라메터 fileName:" + fileName);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("FirstServlet의 destroy() 메서드 호출");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("FirstServlet의 doGet() 메서드 호출");
		String idValue = request.getParameter("id");
		String pwdValue =request.getParameter("pwd");
		
		System.out.println("요청전달데이터 id :" +idValue + ", pwd : "+pwdValue);
		String[] cArr = request.getParameterValues("c"); // 전달이 아예 되지 않을 경우를 준비해야함.
		if(cArr != null) {
			for(String cValue : cArr) {
				System.out.println("요청전달 데이터 C:" + cValue);
			}
		}
		
//		http://localhost:8888/myback/first?id=id1&pwd=p1&c=c1&c=c2
//		http://localhost:8888/myback/first?id=id1&pwd=p1  ->cArr은 null / nullpointException 발생
//		http://localhost:8888/myback/first?id=id1- > pwValue는 null
//		http://localhost:8888/myback/first?id=&pwd=p1 ->idValue는 ""
		
		String contextPath = request.getContextPath();
		System.out.println(getServletContext().getContextPath());// getContextPath(); 와 같음.
		String uri = request.getRequestURI();
		StringBuffer url = request.getRequestURL();
		System.out.println("contextPath:" + contextPath); //  /myback
		System.out.println("uri : " + uri); //  /myback/first
		System.out.println("url : " + url); // http://localhost:8888/myback/first
		String servletPath = request.getServletPath();
		System.out.println("servletPath : "+servletPath);  // servletPath: /first
		
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet의 doPost() 메서드 호출");		
	}

}
