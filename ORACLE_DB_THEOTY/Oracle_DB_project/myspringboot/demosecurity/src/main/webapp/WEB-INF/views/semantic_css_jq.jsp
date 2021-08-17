<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
  <head>
  <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>구조화용 태그</title>
    <link rel="stylesheet" href="./css/basic.css" />
    <style>
      /* * {
        box-sizing: border-box;
      } */
      body {
        font-size: 100%;
      }
      header {
        color: blue;
        background-color: yellow;
        font-size: 2em;
        font-weight: bold;
        width: 80%;
        height: 100px;
        margin: 0px auto;
        line-height: 100px;
        text-align: center;
      }

      header > a.logo {
        background-image: url('./images/logo.png');
        height: 75px;
        width: 75px;
        margin: 16px 0px;
        display: block;
        float: left;
      }
      nav {
        width: 100%;
        height: 50px;
        background-color: #333;
        color: white;
      }
      nav > ol {
        list-style-type: none;
        padding-left: 0px;
      }
      nav > ol > li {
        float: left;
        margin: 10px 30px;
      }

      nav > ol > li > a {
        display: block;
        padding: 8px;
        /* background-color: #dddddd; */
        color: white;
        text-decoration: none;
      }

      nav > ol > li > a:hover {
        background-color: #111;
      }
      section {
        clear: both;
        border: 1px solid;
        width: 75%;
        height: 600px;
        float: left;
        overflow: auto;
      }
      article {
        border: 1px solid;
        background-image: url('https://www.starbucks.co.kr/common/img/main/store_exp_img03.png');
        width: 95%;
        height: 45%;
        padding: 10px;
        margin: 5px;
      }
      aside {
        border: 1px solid;
        width: 20%;
        height: 500px;
        float: right;
      }
      footer {
        border: 1px solid;
        width: 80%;
        height: 80px;
        margin: 0px auto;
        clear: both;
      }
    </style>
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
            case './html/login.html':
            case './html/signup.html':
            case './productlist':
            case './viewcart':
            case './orderlist':
            	$section.load(href, function(responseTxt, statusTxt, xhr){
            	      if(statusTxt == "error")
            	        alert("Error: " + xhr.status + ": " + xhr.statusText);
            	    });
            	break;
            case './customerlogout':            	
            	$section.load(href, function(responseTxt, statusTxt, xhr){
          	      if(statusTxt == "error")
          	        alert("Error: " + xhr.status + ": " + xhr.statusText);
          	    });
            	location.href="./user";
            	break;
            	
            	
            case './admin':
            	location.href=href;
            	break;
            case './manager':
            	location.href=href;
            	break;
            case './myLogout':
            	location.href=href;
            	break;
            	
            	
            case './admin/addproduct':
            	$section.load(href);
            	break;
           }
          return false;
        });
      });
    </script>
  </head>
  <body>
    <header>
      <a class="logo" href="#"></a>
      KOSTABUCKS
    </header>
    <nav>
    <%-- 권한 없이 접속한 경우 --%>
     <sec:authorize access="! isAuthenticated()">
       <ol>
     <c:choose>
        <c:when test="${empty sessionScope.loginInfo}">
          <li><a href="./html/login.html">로그인</a></li>
          <li><a href="./html/signup.html">가입</a></li>
        </c:when>
        <c:otherwise>
          <li>${loginInfo.id}님 반갑습니다. <a href="./customerlogout">로그아웃</a>
        </c:otherwise>
      </c:choose>
      
        <li><a href="./productlist">상품목록</a></li>
        <li><a href="./viewcart">장바구니보기</a></li>
        
      <c:if test="${!empty sessionScope.loginInfo}">
        <li><a href="./orderlist">주문목록</a></li>
      </c:if>
      
       <li><a href="./admin">관리자</a></li>
       <li><a href="./manager">매니저</a></li>
     </ol>
     </sec:authorize>
         <%-- 권한 없이 접속한 경우 끝 --%>
         
              <%-- ROLE_ADMIN권한 접속한 경우  --%>
     <sec:authorize access="hasRole('ROLE_ADMIN')">
       <ol>
         <li>관리자 :  <sec:authentication property="principal.username"/></li>
         <li><a href="./admin/addproduct">관리자권한-상품추가</a></li>
		 <li><a href="./myLogout">로그아웃</a></li>
       </ol>
     </sec:authorize>
           <%-- ROLE_ADMIN권한 접속한 경우 끝  --%>
           
              <%-- ROLE_MANAGER권한 접속한 경우  --%>
     <sec:authorize access="hasRole('ROLE_MANAGER')">
        <ol>
         <li>매니저 :  <sec:authentication property="principal.username"/></li>
         <li><a href="#">매니저권한-매출현황</a></li>
         <li><a href="./myLogout">로그아웃</a></li>
        </ol>
     </sec:authorize>
   <%-- ROLE_MANAGER권한 접속한 경우 끝 --%>
    </nav>
    <section>
      <article>
        여름의 시작을 함께할 인도네시아 웨스트 자바. 허브의 복합적인 풍미와 낮은 산미, 은은하게
        달콤한 바닐라향이 매력적인 원두 자세히 보기
      </article>
      <article>
        차별화된 커피 경험을 누릴 수 있는 리저브 매장, 다양한 방법으로 편리하게 즐길 수 있는
        드라이브 스루 매장, 함께해서 더 따뜻할수 있는 지역사회 소통 공간 커뮤니티 매장
      </article>
    </section>

    <aside>KOSTABUCKS 현대카드</aside>
    <footer>
 (주)스타벅스커피 코리아 
    </footer>
  </body>
</html>
