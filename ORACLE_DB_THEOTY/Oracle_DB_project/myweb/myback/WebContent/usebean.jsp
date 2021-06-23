<%@page import="com.day.dto.OrderInfo"%>
<%@page import="com.day.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%// 서블릿에서 할일
request.setAttribute("resultInt", 1);
request.setAttribute("resultCustomer", new Customer("id1","p1","n1"));

%>

<%//이동된 jsp에서 할일
//요청객체에서 (이름: "resultInt")값 얻기
//int resultIntValue = (Integer)request.getAttribute("resultInt"); //오토박싱, 언박싱
Integer resultIntegerValue = (Integer)request.getAttribute("resultInt");
if(resultIntegerValue != null){
	resultIntegerValue = resultIntegerValue.intValue();
}
%>
<%--//요청객체의 속성(이름:"resultCustomer")값 얻기
Customer resultC = (Customer)request.getAttribute("resultCustomer");
//요청객체가 null이면 매개변수 없는 생성자를 이용해 객체생성하기, 
//요청객체속성(이름:"resultCustomer", 값 : resultC)으로 추가하기
if(resultC ==null){
	resultC = new Customer();
	request.setAttribute("reusultCustomer", resultC);
}
--%>
<jsp:useBean id="resultCustomer" class="com.day.dto.Customer" scope ="request"/>

<%--resultC.setEnabled(0);--%>
<jsp:setProperty name="resultCustomer" property="enabled" value="0"/>" <!-- setter메서드 요청과 같은 효과임 -->

<%-- out.print(resultC.getId()); --%>
<jsp:getProperty name="resultCustomer" property="enabled"/>

<%--
//요청속성(이름:"orderInfo")얻기
//null인 경우 객체생성후 요청속성으로 추가
OrderInfo oi = (OrderInfo)request.getAttribute("orderInfo");
if(oi == null){
	oi = new OrderInfo();
	request.setAttribute("orderInfo", oi);
}
--%>
<jsp:useBean id = "orderInfo" class="com.day.dto.OrderInfo" scope="request"/>
<%//요청속성(이름:"orderInfo")의 프로퍼티중  order_c값을 설정한다
Customer c = new Customer();
oi.setOrder_c(c);
%>