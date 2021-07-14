package com.day.control;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;


public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MultipartRequest mr;
		//String saveDirectory = "E:\\JAVA_WORK\\myweb\\myback\\upload";
		String saveDirectory = getServletContext().getRealPath("upload");
		int maxPostSize = 1024*1024;
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		
//		mr = new MultipartRequest(request, saveDirectory);
		mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding,policy);
		String tValue = mr.getParameter("t");
		File file = mr.getFile("f");
		System.out.println(file.getName());//파일이름
		System.out.println(file.length());
		
		File oldF = new File(saveDirectory, file.getName());
		File newF = new File(saveDirectory,"id1_"+ file.getName());
		if(oldF.renameTo(newF)) {
			System.out.println(file.getName() + "->" + newF.getName());
		}
		
//		InputStream is = request.getInputStream();
//		Scanner sc = new Scanner(is);
//		String line = null;
//		
//		while(sc.hasNextLine()) {
//			line = sc.nextLine();
//			System.out.println(line);
//		}
//		sc.close();
	}

}
