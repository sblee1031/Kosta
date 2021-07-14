<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>별점화면</title>
</head>
<body>
<% String score = request.getParameter("score");
int intScore = Integer.parseInt(score);

%>
<%!int member_count;
int total; %>

<%
if(score==null || score =="") {
	out.print("다시 별점을 선택해주세요.");
}else{
	out.print("선택한 별점은 "+request.getParameter("score")+ " 점 입니다.");
	member_count += 1;
	this.total += intScore;
}
%><br>
<hr>
<%out.print("전체 별점은 "+ total+ " 점 입니다."); %><br>
<%
double avg = (double)total/member_count;
out.print("평점은 "+ avg+ " 점 입니다."); 
%>
<%DecimalFormat df = new DecimalFormat("0.0"); %>
<br>
평점은 약 <%=df.format(avg)%> 입니다.
<br>
<%out.print("전체 참여자 "+ member_count+ " 명 입니다."); %>


 <br>
<a href="score.html">별점주기</a>
</body>
</html>