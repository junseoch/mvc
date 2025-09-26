<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>
	<form action="/mvc/write-ok.product" method="get">
	
		<div>
			<span>상품 이름<input name="productName"/></span>
		</div>
		<div>
			<span>상품 가격<input name="productPrice"/></span>
		</div>
		<div>
			<span>상품 재고<input name="productStock"/></span>
		</div>
	
		<button>등록 완료</button>
	</form>
</body>
</html>