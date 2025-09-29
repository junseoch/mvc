<%@page import="com.app.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 조회</title>
</head>
<body>
	
	<%
		ProductVO product = (ProductVO)request.getAttribute("product"); // 다운 캐스팅
		System.out.println(product);
	%>
	
	<div>
		<h1>상품명: <%=product.getProductName() %></h1>
		<p>상품가격 : <%=product.getProductPrice() %></p>
		<p>상품재고 : <%=product.getProductStock() %></p>
	</div>
	<div>
		<button><a href="/mvc/list.product">상품 목록</a></button>
		<button><a href="/mvc/update.product?id=<%=product.getId() %>">상품 수정</a></button>
		<button><a href="/mvc/delete-ok.product?id=<%=product.getId() %>">상품 삭제</a></button>
	</div>
	
</body>
</html>