package com.day.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파일이름 요청전달데이터 얻기
		String name = request.getParameter("name");
		System.out.println("요청전달데이터 파일이름:" + name);
		//다운로드할 파일의 실제 경로 얻기
		String path = this.getServletContext().getRealPath("upload"); //"d:/upload";
		
		//응답형식 : text/html, application/json, application/octet-stream(무조건다운로드)
		response.setContentType("application/octet-stream;charset=UTF-8");
		
		//다운로드시 파일이름 결정
		//response.setHeader("Content-Disposition", "attachment;filename=" + name);
		//response.setHeader("Content-Disposition", "attachment;filename=" + new String(name.getBytes("UTF-8"), "ISO-8859-1"));
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(name, "UTF-8"));
		
		
		//응답출력스트림
		//PrintWriter out = response.getWriter(); (X) --문자형태로 응답출력
		ServletOutputStream sos = response.getOutputStream(); //--바이트형태로 파일을 출력
		
		//파일읽기
		FileInputStream fis = null;
		File f = new File(path, name);
		fis = new FileInputStream(f);
		byte[]buf = new byte[1024]; //한번에 1kb씩 읽을 버퍼
//		while(true) {
//			int readByteCnt = fis.read(buf); //readByteCnt : 읽은 바이트수
//			if(readByteCnt == -1) { //파일의 끝
//				break;
//			}
//		}
		
		int readByteCnt = -1;
		while( (readByteCnt = fis.read(buf)) != -1 ) {
			sos.write(buf, 0, readByteCnt); //쓰기
		}
	
	}

}
