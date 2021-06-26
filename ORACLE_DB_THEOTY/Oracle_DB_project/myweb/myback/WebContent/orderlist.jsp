<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="status" value="${requestScope.status}"/>
<c:set var="orderList" value="${requestScope.orderList}"/>
<div style="width:100%">
<c:choose>
<c:when test="${status==-1}"> <!--  -->
주문목록이 없습니다.	
</c:when>

<c:when test="${status==0}"> <!--  -->
로그인 후 이용바랍니다.	
</c:when>

<c:when test="${status==1}"> <!--  -->
<div style="font-size:30pt; text-align:center;">주문목록</div>
<br>
<table style="border:1px solid black; border-collapse: collapse;text-align: center; width:100%">
	<tr style="font-size:15pt">
        <th>주문번호</th>
         <th>주문일자</th>
        <th>상품번호</th>
        <th>상품이름</th>
        <th>상품가격</th>
       <th>상품수량</th>
       <th>결제금액</th>
     </tr>
   <c:forEach items="${orderList}" var="o" varStatus="statusObj">
 
     <tr>
        <th>${o.order_no}</th>
         <th>${o.order_dt}</th>
        <th>${o.lines[0].order_p.prod_no}</th>
        <th>${o.lines[0].order_p.prod_name}</th>
        <th>${o.lines[0].order_p.prod_price}</th>
       <th>${o.lines[0].order_quantity}</th>
       <th >
<fmt:formatNumber pattern="#,##0" value="${o.lines[0].order_p.prod_price * o.lines[0].order_quantity}"/></th>
     </tr>
   </c:forEach> 
   </table>
</c:when>


</c:choose>



</div>