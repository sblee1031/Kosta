<%@ page contentType="text/html; charset=UTF-8"%>
<%!int totalScore = 0; //총점
   int cnt = 0; //별점주기 참여횟수
%>    
<% 
String score = request.getParameter("score");
totalScore += Integer.parseInt(score);
cnt++; //참여횟수 누적
double avg = (double)totalScore / cnt; 
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
선택한 별점은<%=score%>점 입니다.
<br>
별점 총점은 <%=totalScore%>점입니다.
<br>
평점은 <%=avg %>점 입니다.
<br>
<%java.text.DecimalFormat df = new java.text.DecimalFormat("0.0"); %>
평점은 <%=df.format(avg)%>점 입니다.


<hr>
<a href="score.html">별점주기</a>
</body>
</html>
