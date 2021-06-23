<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.FileInputStream"%>
<%@page errorPage="err.jsp" %>
<%@page buffer="1kb" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
for(int i=1; i<=100; i++){
%> <div><%=i %> </div>
<%
}
%>
<%
String fileName = "a.txt";
FileInputStream fis = null;
fis = new FileInputStream(fileName);
%>

<%-- <%
String fileName = "a.txt";
FileInputStream fis = null;
try{
fis = new FileInputStream(fileName);
}catch(FileNotFoundException e){
	request.setAttribute("exception", e);
	String path = "err.jsp";
	RequestDispatcher rd = request.getRequestDispatcher(path);
	rd.forward(request, response);
}
%> --%>


<%-- <%//a.txt 파일 내용 1바이트 읽기
String fileName = "a.txt";
FileInputStream fis = null;
try{
fis = new FileInputStream(fileName);
}catch(FileNotFoundException e){
%>
<h1> 오류 내용<%=e.getMessage() %></h1>
<%
}
%> --%>
<h1>END</h1>
</body>
</html>