<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cart</title>

</head>
<body>
<div style="float: right;">

    <c:out value="${error}"/>
    <c:out value="${principal.firstName}"/>
    <a href="dispatcher?command=indexPage"><input type="submit" value="home"/></a>
    <a href="dispatcher?command=customerPage"><input type="submit" value="My profile"/></a>
    <a href="dispatcher?command=logout"><input type="submit" value="logout"/></a>

</div>
    <table border="1">
        <header>
            <td style="background-color: aqua;">title</td>
            <td style="background-color: aqua;">price</td>
            <td style="background-color: aqua;">quantity</td>
            <td style="background-color: aqua;"></td>
        </header>
        <c:forEach var="addProduct" items="${cart}">
            <tr>
                <td><c:out value="${addProduct.title}"/></td>
                <td><c:out value="${addProduct.price}"/></td>
                <td></td>
                <td><a href="dispatcher?command=delFromCart&id=${addProduct.id}">del</a></td>
            </tr>
        </c:forEach>
        <tr style="background-color: aqua;">
            <td>total price</td>
            <td><c:out value="${totalPrice}"/></td>
            <td></td>
            <td><input type="submit" value="Buy now"/></td>
        </tr>

    </table>
</body>
</html>
