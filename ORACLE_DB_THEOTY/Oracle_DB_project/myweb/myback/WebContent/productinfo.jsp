<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
-->
<script>
	$(function(){
		$('div.productinfo>div>ol>li>button').click(function(){
			console.log($(this).parents('ol').find('li>span.prod_no'));
			var prod_no = $(this).parents('ol').find('li>span.prod_no').html();
			console.log(prod_no);
			var quantity = $(this).parents('ol').find('li>input[type=number]').val();
			console.log(quantity);
			 $.ajax({
				url : './putcart',
				method : 'get',
				data : {prod_no: prod_no , quantity : quantity},
				success :function(responseData){
					alert(responseData);
					//div영역 보여주기
					$('div.productinfo>div.modal').show();
				}
			}); 
		});
		//계속하기 버튼이 클릭 이벤트 처리
		$('div.productinfo>div.modal>button.productlist').click(function(){
			console.log(this);
			//상품목록보기메뉴 click이벤트를 강제 발생 #body > nav > a:nth-child(4)
			$('div > nav > a[type="productlist"]').trigger('click');
		});
		
		//장바구니 버튼 클릭이벤트처리
		$('div.productinfo>div.modal>button.viewcart').click(function(){
			console.log(this);
			//장바구니메뉴 click이벤트를 강제 발생
			$('div > nav > a[type="viewcart"]').trigger('click');
		});
		
	});
</script>
<c:set var="p" value="${requestScope.p}"/>
<div class="productinfo">

<div style="float:left; width:40%">
	<img src="./images/${p.prod_no}.jpg" style="width:200px" alt="${p.prod_name}">
</div>
<div style="float:right; width:50%">
	<ol style="list-style-type:none; padding:0px">
		<li>상품번호:<span class="prod_no">${p.prod_no}</span></li>
		<li>상품명:<span>${p.prod_name}</span></li>
		<li>가격:<span>${p.prod_price}</span></li>
		<li>수량:<input type="number" value="1" max="99"></li>
		<li><button >장바구니 넣기</button></li>
	</ol>
</div>
<div class="modal" style="clear:both; display:none;">
<button class="viewcart">장바구니 보기</button>
<button class="productlist">계속하기</button>
</div>
</div>