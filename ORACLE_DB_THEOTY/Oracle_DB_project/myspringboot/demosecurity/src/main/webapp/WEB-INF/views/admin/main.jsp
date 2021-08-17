<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function () {
  //DOM트리에서 nav>ol>li>a객체들 찾기
  var $menuObj = $('nav>ol>li>a');
  
  //DOM트리에서 section객체 찾기
  var $section = $('section');
  
  $menuObj.click(function () {
    //클릭된현재객체의 href속성값 얻기 : .attr('href');
    var href = $(this).attr('href');
    switch (href) {
    case './productlist':
      	$section.load(href, function(responseTxt, statusTxt, xhr){
      	      if(statusTxt == "error")
      	        alert("Error: " + xhr.status + ": " + xhr.statusText);
   	    });
      	return false;
     default:
    	 return true;
    }//end switch
    
  });//end $menuObj.click
});
</script>  
</head>
<body style="background-color: lightblue;">
<header>
<h1>admin page</h1>


<p>principal : <sec:authentication property="principal"/></p>
<h2>username :  <sec:authentication property="principal.username"/></h2>
<h3>관리자 화면</h3>
</header>
<nav>
<ol>
<li><a href="${pageContext.request.contextPath}/logout">내장된 로그아웃</a></li>
<li><a href="${pageContext.request.contextPath}/myLogout">사용자정의 로그아웃</a></li>
<li><a href="./productlist">상품목록</a></li>
<li><a href="#">상품추가</a></li>
<li><a href="#">상품수정</a></li>
<li><a href="${pageContext.request.contextPath}">메인메뉴</a></li>
</ol>
</nav>
<section>
</section>
</body>
</html>
