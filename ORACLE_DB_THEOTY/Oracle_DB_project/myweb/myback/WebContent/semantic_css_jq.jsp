<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>구조화용 태그</title>
  <link rel="stylesheet" href="./css/basic.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <style>
    header {
      margin: auto;
      height: 150px;
      text-align: center;
      line-height: 150px;
      font-size: 3em;
      color: skyblue;
      background-color: lavenderblush;

      /*background-image: url(./images/11.JPG); */
    }

    header>img {
      margin: 25px 10px;
      display: block;
      float: left;
      width: 100px;
    }

    div#body {
      width: 100%;
      margin: 0px;
      position: relative;
      background-color: skyblue;
    }

    nav {
      font-size: 1.5em;
      background-color: #444;
      width: 100%;
      height: 20%;
      margin: 0px;
    }

    nav>a {
      display: inline;
      color: white;
      padding: 0px 10px;
      text-decoration: none;
    }

    nav a:hover {
      background-color: #111;
    }


    div#section {

      height: 450px;
      float: left;
      max-width: 85%;
      height: 100%;

      font-size: 12pt;
      font-weight: 700;
    }

    article {
      margin: 10px;
      width: 100%;
      height: 350px;
      overflow: auto;
      background-image: url(https://image.istarbucks.co.kr/upload/common/img/main/2021/m_reserve_sundried_brazil_bean.jpg);
      background-size: 100%;
      background-repeat: no-repeat;
    }

    aside {
      float: right;
      width: 20%;
      margin: 0px;

    }

    footer {
      height: 150px;
      line-height: 150px;
      clear: both;
      text-align: center;
      font-weight: 600;
      background-color: lightsalmon;
      font-size: 1.0em;
      font-weight: 700;

      overflow: auto;

    }

    img#h_card {
      position: fixed;
      width: 10%;
      top: 25%;
      right: 3%;
    }
  </style>

  <script>
    $(function () {
      //DOM트리에서 nav>ol>li>a객체들 찾기
      var $menuObj = $('nav>a');

      //DOM트리에서 section객체 찾기
      var $section = $('section');
      $menuObj.click(function () {
        //클린된 현재 객체의 href속성값 얻기 : .attr('href');
        var href = $(this).attr('href');
        switch (href) {
          case './login.html':
          case './signup.html':
          case './productlist':
          case './viewcart':
          case './orderlist':
            $section.load(href, function (responseTxt, statusTxt, xhr) {
              if (statusTxt == "error")
                alert("Error: " + xhr.status + ": " + xhr.statusText);
            });   //요청경로 파일을 찾지 못할시 404 에러 코드 발생
            break;
          case './logout':
        	  $section.load(href, function (responseTxt, statusTxt, xhr) {
                  if (statusTxt == "error")
                    alert("Error: " + xhr.status + ": " + xhr.statusText);
                });   //요청경로 파일을 찾지 못할시 404 에러 코드 발생
        	  location.href="./semantic_css_jq.jsp";
        	  break;
        	  
        }

        return false;

      });
    });
  </script>
</head>

<body>
  <div class="body" id="body">
    <header>
      <img src="https://image.istarbucks.co.kr/common/img/main/rewards-logo.png" alt="KOSTA_BUCKS_logo" />

      KOSTA_BUCKS
    </header>

    <nav class="nav">
    	<c:choose>
    	<c:when test= "${empty sessionScope.loginInfo}">
      <a href="./login.html">로그인</a>
      <a href="./signup.html">가입</a>
      </c:when>
      <c:otherwise>
      	${loginInfo.id} 님 반갑습니다.<a href="./logout">로그아웃</a>
      </c:otherwise>
      </c:choose>
      <a type="productlist" href="./productlist">상품목록</a>
      <a type="viewcart" href="./viewcart">장바구니보기</a>
      <c:if test="${!empty sessionScope.loginInfo}">
      	<a class ="orderlist" type="orderlist" href="./orderlist">주문목록</a>
      </c:if>
    </nav>

    <div id="section">
      <section>
        <article style="color:black; text-shadow: 1px 1px 5px yellow ;">

          다크 초콜릿 모카의 진한 바디감과 함께 헤이즐넛 향과 달콤한 카라멜
          크림 폼으로 벨벳같은 부드러움까지 살린 리저브 나이트로 커피클
          스타벅스 e-Gift Card를 선물하실 경우 발신자의 정보는 스타벅스 웹회원 정보에 등록된 휴대폰 번호 또는 e-Mail 주소로 자동 설정되어 있습니다.
          회원 정보를 수정하시려면 개인정보 확인 및 수정을 클릭해 주세요.
          구매 가능한 최소 금액 단위는 5천원이며, 1만원 이상부터는 1만원 단위로 최대 50만원까지, 1회 당 최대 10개의 휴대폰 또는 e-Mail로 보내실 수 있습니다.
          또한, 바로 결제하여 즉시 구매하시거나 장바구니 내역에 담아두었다가 추후에 결제하실 수도 있습니다.
          전송시간은 즉시 또는 생일, 기념일 등 선물하시고자 하는 특정일에 예약전송을 하실 수 있습니다.
          즉시전송을 선택하신 경우 결제가 완료된 시점에 선물 받는 분께 바로 발송됩니다.
          예약 설정은 30일 이내만 가능하며 당일 예약은 되지 않으니 당일 선물은 즉시전송으로 선택하여 주십시오.
          선물하려는 휴대폰 번호와 e-Mail은 유효한 번호와 주소로 입력해주시기 바라며, 휴대폰으로 선물 시 발송량에 따라 지정하신 시간보다 수신이 지연될 수 있고
          단말기에 따라 MMS 수신이 불가능한 경우 스타벅스 e-Gift Card를 받지 못하실 수 있습니다.
          스타벅스 e-Gift Card는 상업적으로 이용 할 수 없으며, 스타벅스에서 제공된 기능이 아닌 불법적이고 비정상 방법으로 사용하여 발생된 문제에 대해 스타벅스는 책임을 지지 않습니다.
          .<br>
          .<br>
          .<br>
          .<br>
          .<br>
          .<br>
          끝.
        </article>

        <article>

          아카라멜향을 머금은 애플의 달콤함과 부드러운 콜드 크레마를 조화롭게
          느낄 수 있는 리저브 나이트로 음료
          스타벅스 e-Gift Card는 웹에서 신용카드, 실시간 계좌이체, 앱에서 신용카드, 휴대폰, SSG PAY로 결제 가능합니다.
          선물 받으시는 분이 2명 이상일 경우 또는 예약 전송을 하시는 경우는 휴대폰 소액결제 수단을 선택할 수 없습니다.
          신용카드 결제 관련
          개인 신용 카드의 1개월간 상품권 구매 한도는 100만원 이며, 한도에 대해서는 카드사에 문의해 주시기 바랍니다.
          (법인카드의 경우, 사업자별로 부개 한도가 상이하오니, 각 사업자에 문의해 주시기 바랍니다.)
          법인카드로 구매 시, 청구서 상 "상품권" 유형으로 표시됩니다. (별도 상품권 가맹)
          카드유형 또는 카드사에 따라 부분취소에 제약이 있을 수 있으니 카드사로 문의해 주시기 바랍니다.
          휴대폰 소액결제 관련
          휴대폰 소액결제 한도는 통신사 또는 요금납부 내역 등 개인별로 상이하오니 통신사 또는 PG사(이니시스)로 문의해주시기 바랍니다.
          애플리케이션 운영체제 및 버전에 따라 결제 수단의 차이가 있을 수 있습니다.
        </article>
      </section>


      <aside>
        <img id="h_card" src="https://image.istarbucks.co.kr/upload/banner/floatingbnr/9vF68i_20210218134422111.png"
          alt="스타벅스 - 현대카드 PLCC" class="pc-badge" />
      </aside>
    </div>
    <div id="footer">
      <footer>
        사업자등록번호 : 201-81-21515 (주)스타벅스커피 코리아 대표이사 : 송
        데이비드 호섭 TEL : 1522-3232 개인정보 책임자 : 하익성
      </footer>
    </div>
    </div>
    <!-- <div>
      DIV
      <div>
        DIV2
        <h3>h3</h3>
        <div>
          DIV3
          <div>DIV4</div>
        </div>
      </div>
    </div> -->
</body>

</html>