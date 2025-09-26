<%@page import="com.app.vo.ProductVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<%
		List<ProductVO> products = (List<ProductVO>)request.getAttribute("products"); // 다운 캐스팅
	%>
	
	<table>
		<tr>
			<th>상품 번호</th>
			<th>상품 이름</th>
			<th>상품 가격</th>
			<th>상품 재고</th>
		</tr>
		<%
			for(ProductVO product: products){
		%>
		
		<tr>
			<td><%=product.getId()%></td>
			<td>
				<a href="/mvc/read.product?id=<%=product.getId()%>"><%=product.getProductName()%></a></td>
			<td><%=product.getProductPrice()%></td>
			<td><%=product.getProductStock()%></td>
		</tr>
		
	<%
		}
	%>
	
	</table>	
	<div>
		<button><a href="/mvc/write.product">상품 등록</a></button>
	</div>
	
</body>
</html>