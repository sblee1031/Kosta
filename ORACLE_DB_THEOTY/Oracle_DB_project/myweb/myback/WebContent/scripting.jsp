<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int i=9; %> <!-- Scriptlet -->
<%i++; %>
<%out.print("i변수의 값은 : "+i); %>
<hr>
지역변수 i변수 값은 : <%=i %> <!--Expression 표현 -->
<hr>
<%! int i; %> <!-- Declaration 선언 -->
멤버 변수값은 : <%=this.i %>
<%--<%!out.print("_jspService()의 외부입니다"); %>--%>
<hr>
<%//자바 주석문 %>
<!-- html 주석문 -->
<%-- jsp 전용 주석문 : 퍼포먼스 향상에 기여됨. --%>
</body>
</html>