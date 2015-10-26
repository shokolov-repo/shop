<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>basket</title>
</head>
<body>
<table border="1">
  <header>
    <td>title</td>
    <td>price</td>
    <td>quantity</td>
    <td>del</td>
  </header>
  <c:forEach var="addProduct" items="${addProducts}">
    <tr>
      <td><c:out value="${addProduct.title}"/></td>
      <td><c:out value="${addProduct.price}"/></td>
      <td><c:out value="${addProduct.quantity}"/></td>
      <td><a href="dispatcher?command=delProductFromBasket&productId='+${product.id}'">del</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
