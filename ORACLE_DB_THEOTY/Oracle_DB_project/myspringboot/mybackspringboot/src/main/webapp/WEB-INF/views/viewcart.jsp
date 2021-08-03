<%@page import="java.text.DecimalFormat"%>
<%@page import="com.day.dto.Product"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page  contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
  <script>
  	$(function(){
  		$('div.viewcart>button.addorder').click(function(){
  			$.ajax({
  				url:'./addorder',
  				method:'get',
  				success:function(responseData){
  					//console.log(responseData);
  					alert(responseData.trim());
  						var status = responseData.trim();
  				        switch (status) {
  				        case '주문추가 성공':
  				        	console.log('status : '+status);
  				        	//$('a.orderlist').trigger('click');
  				        	var nav = document.querySelector('a.orderlist');
  				        	nav.click(); 
  				        	
  				        	break;
  				        case '주문추가 실패':
  				        	console.log('status : '+status);
  				        	break;
  				        case '로그인 하세요':
  				        	console.log('status : '+status);
  				        	break;
  				        case '추가실패':
  				        	console.log('status : '+status);
  				          break;
  				      }
  				},
  			});
  		});
  	});
  </script>
<%--
Map<Product, Integer> result = (Map)request.getAttribute("result");
if(result==null || result.size()==0){--%>
<c:set var="result" value="${requestScope.result}"/>
<c:choose>
<c:when test="${empty result}"> <!--  -->
장바구니가 비었습니다.	
</c:when>
<%--
return;
}
--%>
<c:otherwise>
<%--DecimalFormat df = new DecimalFormat("#,##0"); --%>
<div class="viewcart">
<h3>장바구니</h3>
<table>
<tr>
<th>상품번호</th><th>상품명</th><th>가격</th><th>수량</th><th>금액</th>

</tr>
<%--Set<Product> products = result.keySet();
for(Product p : products){
	Integer quantity = result.get(p);
--%>

<c:forEach var="kv" items = "${result}">
<c:set var = "p" value="${kv.key}"></c:set>
<c:set var = "quantity" value="${kv.value}"></c:set>
<tr>
<td>${r.prod_no}</td>
<td>${r.prod_name}</td>
</tr>
<tr><td>${p.prod_no}</td>
<td>${p.prod_name}</td>
<td>${p.prod_price}</td>
<td>${quantity}</td>
<td style="text-align:right">
<fmt:formatNumber pattern="#,##0" value="${p.prod_price * quantity}"/></td>
</tr> 
</c:forEach>
</table>
<button class="addorder">주문하기</button>
</div>
</c:otherwise>
</c:choose>
