<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Page</title>
</head>
<body>
<div style="float: right;">

    <c:out value="${user.firstName}"/>
    <a href="dispatcher?command=logout"><input type="submit" value="logout"/></a>
    <a href="updateAccount.jsp"><input type="submit" value="update account"/></a>
    <a href="basket.jsp"><input type="submit" value="basket"/></a>

</div>
<table border="1">
    <header>
        <td>date order</td>
        <td>status</td>
    </header>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td><c:out value="${order.dateOrder}"/></td>
            <td><c:out value="${order.status}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
