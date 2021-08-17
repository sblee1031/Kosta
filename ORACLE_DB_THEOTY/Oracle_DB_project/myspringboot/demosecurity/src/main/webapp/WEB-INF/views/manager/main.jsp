<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function () {
 });
</script>  
</head>
<body style="background-color: orange;">
<header>
<h1>manager page</h1>
<h2>username :  <sec:authentication property="principal.username"/></h2>
</header>
<nav>
<ol>
<li><a href="${pageContext.request.contextPath}/myLogout">사용자정의 로그아웃</a></li>
<li><a href="#">주문목록</a></li>
<li><a href="#">매출현황</a></li>
<li><a href="${pageContext.request.contextPath}">메인메뉴</a></li>
</ol>
</nav>
<section>
</section>
</body>
</html>
