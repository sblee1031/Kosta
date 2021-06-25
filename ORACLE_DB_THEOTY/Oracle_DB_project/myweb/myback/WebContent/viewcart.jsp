<%@page import="com.day.dto.Product"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page  contentType="text/html; charset=UTF-8" %>
<%
Map<Product, Integer> result = (Map)request.getAttribute("result");
if(result==null || result.size()==0){%>
장바구니가 비었습니다.	
<%
return;
}
%>
<table>
<%Set<Product> products = result.keySet();
for(Product p : products){
	Integer quantity = result.get(p);
%><tr><td><%=p.getProd_no()%></td>
<td><%=p.getProd_name()%></td>
<td><%=p.getProd_price()%></td>
<td><%=quantity%></td>
</tr> 
<%}
%>
</table>