<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: pink;">
<h1>/sample/member page</h1>
<h2>username : <sec:authentication property="principal.username"/></h2>
<ul>
<li><a href="${pageContext.request.contextPath}/logout">내장된 로그아웃</a></li>
<li><a href="${pageContext.request.contextPath}/myLogout">사용자정의 로그아웃</a></li>
<li><a href="#">내정보보기</a></li>
<li><a href="#">상품목록</a></li>
<li><a href="${pageContext.request.contextPath}/order/view">주문목록</a></li>
<li><a href="${pageContext.request.contextPath}/order/put">주문하기</a></li>
<li><a href="${pageContext.request.contextPath}">메인메뉴</a></li>
</ul>
</body>
</html>
