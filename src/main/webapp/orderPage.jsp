<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div style="float: right;">

    <c:out value="${principal.firstName}"/>
    <a href="dispatcher?command=indexPage"><input type="submit" value="home"/></a>
    <a href="dispatcher?command=customerPage"><input type="submit" value="My profile"/></a>
    <a href="dispatcher?command=cart"><input type="submit" value="cart"/></a>
    <a href="dispatcher?command=logout"><input type="submit" value="logout"/></a>

</div>
<table border="1">
    <header>
        <td>title</td>
        <td>quantity</td>
        <td>price</td>
    </header>
    <c:forEach var="product" items="${products}">
        <tr>
            <td><c:out value="${product.title}"/></td>
            <td><c:out value="${product.quantity}"/></td>
            <td><c:out value="${product.price}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
