<%@ page contentType="text/html; charset=UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<th>구분</th>
	<th>상품번호</th>
	<th>상품이름</th>
	<th>상품가격</th>
	<th>제조일자</th>
	<th>이미지</th>
<c:set var = "products" value="${requestScope.list}"></c:set>
<c:forEach var="p" items="${products}" varStatus="statusObj">

	<tr><!-- 첫번째 줄 시작 -->
	    <td>${statusObj.index}</td>
	    <td>${p.prod_no}</td>
	    <td>${p.prod_name}</td>
	    <td>${p.prod_price}</td>
	    <td>${p.prod_mf_dt}</td>
	    <td><img src="https://image.istarbucks.co.kr/common/img/main/rewards-logo.png" alt="KOSTA_BUCKS_logo" /></td>
	    
	</tr><!-- 첫번째 줄 끝 -->
	



</c:forEach>
    </table>
</body>
</html>