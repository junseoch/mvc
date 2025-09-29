<%@page import="com.app.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
</head>
<body>
	
	<!-- 부모 : object  자식 : VO -->
	<%
		ProductVO product = (ProductVO)request.getAttribute("product"); 
		System.out.println(product);
	%>
	
	<form action="/mvc/update-ok.product" method="get">
		<input name='id'/>
	
		<div>
			<span>상품 이름<input name="productName" value="<%=product.getProductName()%>"></span>
		</div>
		<div>
			<span>상품 가격<input name="productPrice" value="<%=product.getProductPrice()%>"></span>
		</div>
		<div>
			<span>상품 재고<input name="productStock" value="<%=product.getProductStock()%>"></span>
		</div>
	
		<button>등록 완료</button>
	</form>
	
</body>
</html>