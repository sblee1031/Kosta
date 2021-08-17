<%@page import="java.text.DecimalFormat"%>
<%@page import="com.day.security.dto.Product"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 --> <script>
  $(function () {
	  $('div.viewcart>button.addorder').click(function(){
		  $.ajax({
			  url:'./addorder',
			  method:'get',
			  success:function(responseData){
				  switch(responseData.trim()){
				  
				  case '-1':
					  alert('장바구니가 비었습니다');
					  break;
				  case '0':
					  alert('로그인 하세요');
					  $('body > nav > ol > li > a[href="./html/login.html"]').trigger('click');
					  break;
				  case '1':
					  alert('주문추가 성공');
					  $('body > nav > ol > li > a[href="./productlist"]').trigger('click');
					  break;
			      default:
					  alert('추가 실패 :' + responseData.trim());
					  break;
				  }
				  //alert(responseData.trim());
				  //상품목록보기메뉴에 click이벤트를 강제발생
				  //$('body > nav > ol > li > a[href="./productlist"]').trigger('click');
			  }
 		  });
	  });
  });
</script>
<c:set var="result" value="${requestScope.result}"/>
<c:choose>
<c:when test="${empty result}">
 장바구니가 비었습니다
</c:when>	
<c:otherwise>
<div class="viewcart">
<h3>장바구니</h3>
<table>
<tr>
  <th>상품번호</th><th>상품명</th><th>가격</th><th>수량</th><th>금액</th>
</tr>
<c:forEach items="${result}" var="kv">
   <c:set var="p" value="${kv.key}"/>
   <c:set var="quantity" value="${kv.value}" />
<tr><td>${p.prod_no}</td>
      <td>${p.prod_name}</td>
      <td>${p.prod_price}</td>
      <td>${quantity}</td>
      <td><fmt:formatNumber pattern="#,##0" value="${p.prod_price * quantity}"/></td>
</tr>
</c:forEach>
</table>
<button class="addorder">주문하기</button>
</div>

</c:otherwise>
</c:choose>

