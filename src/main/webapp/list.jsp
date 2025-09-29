<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
<%-- 
   <h1>상품 리스트</h1>
   <%
      List<ProductVO> products = (List<ProductVO>)request.getAttribute("products");
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
            <td><%=product.getId() %></td>
            <td>
               <a href="/mvc/read.product?id=<%=product.getId() %>"><%=product.getProductName() %></a>
            </td>
            <td><%=product.getProductPrice() %></td>
            <td><%=product.getProductStock() %></td>
         </tr>
   <%
      }
   <%-- %>         
      </table>
      <div>
         <a href="/mvc/write.product">상품 등록</a>
      </div> --%>
      
   <h1>상품 리스트</h1>
      <table>
         <tr>
            <th>상품 번호</th>
            <th>상품 이름</th>
            <th>상품 가격</th>
            <th>상품 재고</th>
         </tr>
         <c:forEach var="product" items="${products}">
            <tr>
               <td><c:out value="${product.getId()}"></c:out></td>
               <td>
                  <a href="/mvc/read.product?id=${product.getId()}">
                     <c:out value="${product.getProductName()}"></c:out>
                  </a>
               </td>
               <td><c:out value="${product.getProductPrice()}"></c:out></td>
               <td><c:out value="${product.getProductStock()}"></c:out></td>
            </tr>
         </c:forEach>
      </table>
      <div>
         <a href="/mvc/write.product">상품 등록</a>
      </div>
</body>
<script type="text/javascript">
   /* console.log("${products}")
   console.log(${productsJSON}) */
   /* JSON.stringify() : 데이터 -> JSON
   JSON.parse() : JSON -> 데이터 */
/*    const products = JSON.parse(`${productsJSON}`);
   console.log(products)
   products.forEach((product) => {
      console.log(product)
   }) */
   const products = JSON.parse(`${productsJSON}`);
   const table = document.querySelector("table");
   
   products.forEach((product) => {
      /* console.log(product) */
/*       console.log("상품명 `${product.productName}`) : JSTL문법과 JS(ES6) 템플릿 리터럴 문법과 충돌 */
      console.log("상품명" + product.productName)
      table.innerHTML += (
         "<tr>" +
            "<td>" + product.id + "</td>" + 
            "<td>" + product.productName + "</td>" + 
            "<td>" + product.productPrice + "</td>" + 
            "<td>" + product.productStock + "</td>" + 
         "</tr>"
      )
   })
</script>
</html>