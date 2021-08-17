<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page import="java.util.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>accessError.jsp</title>
</head>
<body>
<h1>Access Denied Page</h1>
<hr>
<h2>SPRING_SECURITY_403_EXCEPTION.getMessage() : <c:out value="${SPRING_SECURITY_403_EXCEPTION.getMessage()}"/></h2>

<hr>
<h2>
인증된 아이디는 sec:authentication property="principal.username"으로 확인할 수 있다<br>
sec:authentication property="principal.username" : 
      <sec:authentication property="principal.username"/>
</h2>
<hr>
<h2>requestScope.msg : <c:out value="${requestScope.msg}"/></h2>

<hr>
<a href="${pageContext.request.contextPath}">메인</a>
</body>
</html>
