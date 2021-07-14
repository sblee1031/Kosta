<%@page import="com.day.dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="lang" value="ko"></c:set>
<c:if test="${lang=='ko'}">
	안녕하세요.
</c:if>
<c:choose>
	<c:when test="${lang=='ko'}">안녕하세요.</c:when>
	<c:when test="${lang=='fr'}">Bonjour</c:when>
	<c:otherwise>HELLO</c:otherwise>
</c:choose>

<c:forEach begin="1" end="5" step="2" var="i">
${i }</c:forEach>
<hr>
<%//서블릿에서 할일
List<Product> list = new ArrayList<>();
list.add(new Product("C0001","A", 10));
list.add(new Product("C0002","B", 20));
list.add(new Product("C0003","C", 30));
request.setAttribute("list", list);
//이 JSP로 forward 됐다
%>

<c:set var = "products" value="${requestScope.list}"></c:set>
<c:forEach var="p" items="${products}" varStatus="statusObj">
${statusObj.index} - ${p.prod_no}:${p.prod_name}:${p.prod_price}<br></c:forEach>


</body>
</html>