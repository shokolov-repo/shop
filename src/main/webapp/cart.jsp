<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>basket</title>

</head>
<body>
<div style="float: right;">

    <c:out value="${user.firstName}"/>
    <a href="dispatcher?command=indexPage"><input type="submit" value="home"/></a>
    <a href="dispatcher?command=customerPage"><input type="submit" value="My profile"/></a>
    <a href="dispatcher?command=logout"><input type="submit" value="logout"/></a>

</div>
<table border="1">
    <header>
        <td>title   </td>
        <td>price   </td>
        <td>quantity</td>
        <td>        </td>
    </header>
    <c:forEach var="addProduct" items="${cart}">
        <tr>
            <td><c:out value="${addProduct.title}"/></td>
            <td><c:out value="${addProduct.price}"/></td>
            <td><c:out value="${addProduct.quantity}"/></td>
            <td><a href="dispatcher?command=delFromCart&id=${addProduct.id}">del</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
