<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Seller</title>
</head>
<body>


<div style="float: right;">

    <c:out value="${user.firstName}"/>
    <a href="dispatcher?command=logout"><input type="submit" value="logout"/></a>

</div>
<table border="1">
    <header>
        <td>customer id</td>
        <td>date order</td>
        <td>status</td>
        <td></td>
    </header>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td><c:out value="${order.dateOrder}"/></td>
            <td><c:out value="${order.status}"/></td>
            <td><a href="dispatcher?command=getCustomer&id=${order.id}"><input type="submit" value="customer data"/></a></td>
            <td><a href="dispatcher?command=editStatus&id=${order.id}"><input type="submit" value="edit status"/></a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
