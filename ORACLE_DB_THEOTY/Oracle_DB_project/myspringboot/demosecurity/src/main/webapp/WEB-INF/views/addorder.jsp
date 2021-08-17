<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--addorder.jsp--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
${requestScope.status}
<%--
<c:set var="status" value="${requestScope.status}"/>

 <c:choose>
<c:when test="${status==1}">
   주문추가 성공 
</c:when>
<c:otherwise>
 주문추가 실패
  <c:if test="${status==0}">
    로그인 하세요
  </c:if>
  <c:if test="${status==-1}">
  장바구니가 비었습니다
  </c:if>
  <c:if test="${status==-2}">
    추가 실패 ${requestScope.msg}
  </c:if>
</c:otherwise>
</c:choose> --%>