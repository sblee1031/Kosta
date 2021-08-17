<%@ page contentType="text/html; charset=UTF-8"%>

<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!-- 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 -->
<script>
  $(function () {
	$('div.productinfo>div>ol>li>button').click(function(){
		var prod_no = $(this).parents('ol').find('li>span.prod_no').html();
		console.log(prod_no);
		var quantity = $(this).parents('ol').find('li>input[type=number]').val();
		console.log(quantity);
		$.ajax({
			url: './putcart',
			method: 'get',
			data: {prod_no: prod_no, quantity: quantity},
			success:function(responseData){
				alert(responseData);
				
				//div영역보여주기
				$('div.productinfo>div.modal').show();
			},error:function(jqXHR){
				alert(jqXHR.status);
			}
		});
	});
	
	//계속하기 버튼 클릭이벤트처리
	$('div.productinfo>div.modal>button.productlist').click(function(){
		//상품목록보기메뉴에 click이벤트를 강제발생
		$('body > nav > ol > li > a[href="./productlist"]').trigger('click');
	});
	//장바구니보기 버튼 클릭이벤트처리
	$('div.productinfo>div.modal>button.viewcart').click(function(){
		$('body > nav > ol > li > a[href="./viewcart"]').trigger('click');
	});
  });
</script>
<c:set var="p" value="${requestScope.p}"/>
<div class="productinfo" style="width:50%">
 <div style="float:left;width:40%">
  <img src="./images/${p.prod_no}.jpg" alt="${p.prod_name}" style="max-width: 100%">
  </div>
 <div style="float:right;width:50%">
  <ol style="list-style-type: none; padding:0px">
    <li>상품번호:<span class="prod_no">${p.prod_no}</span></li>
    <li>상품명:<span>${p.prod_name}</span></li>
    <li>가격:<span>${p.prod_price}</span></li>
    <li>수량:<input type="number" value="1" max="99"></li>
    <li><button>장바구니 넣기</button></li>
    <li>  
  </ol>
 </div>
 <div class="modal" style="clear:both; display:none;">
   <button class="viewcart">장바구니 보기</button>
   <button class="productlist">계속하기</button>
 </div>
</div>