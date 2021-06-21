package com.day.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MoveServlet
 */
public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//응답형식 지정: text/html
		response.setContentType("text/html;charset=UTF-8");
		
		//응답출력스트림 얻기
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<ol>");
		out.print("<li><a href=\"./move?opt=forward\">포워드</a></li>");
		out.print("<li><a href=\"./move?opt=include\">인클루드</li>");
		out.print("<li><a href=\"./move?opt=redirect\">리다이렉트</li>");
		out.print("</ol>");
		out.print("</body>");
		out.print("</html>");
		
	}
	private void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답형식 지정: text/html
		response.setContentType("text/html;charset=UTF-8");
		
		//응답출력스트림 얻기
		PrintWriter out = response.getWriter();
		out.print("before forward");
		String path = "first";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response); //완전 이동
		out.print("after forward");
	}
	private void include(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
		
		//응답출력스트림 얻기
		PrintWriter out = response.getWriter();
		out.print("before include");
		String path = "first";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.include(request, response); // 다른곳으로 이동했다가 다시 돌아옮
		out.print("after include");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청전달 데이터(이름:opt)가 전달안된 경우
		String opt = request.getParameter("opt");
		if(opt == null || opt.equals("")) {
			show(request, response);
		}else if(opt.equals("forward")) {
			forward(request, response);
		}else if (opt.equals("include")) {
			include(request, response);
		}else if(opt.equals("redirect")) {
			
		}
	}

}
