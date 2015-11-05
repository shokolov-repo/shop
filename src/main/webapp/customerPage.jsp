<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Page</title>
</head>
<body>
<c:if test="${info!=null}">
    <div style="color: #BA0000;">
        <c:out value="${info}"/>
    </div>
</c:if>
<div style="float: right;">

    <c:out value="${principal.firstName}"/>

    <a href="dispatcher?command=indexPage"><input type="submit" value="home"/></a>
    <a href="dispatcher?command=cart"><input type="submit" value="cart"/></a>
    <a href="editProfile.jsp"><input type="submit" value="edit profile"/></a>
    <a href="dispatcher?command=logout"><input type="submit" value="logout"/></a>

</div>
<c:if test="${error!=null}">
    <div style="color: #BA0000;">
        <c:out value="${error}"/>
    </div>
</c:if>
<table border="1">
    <header>
        <td>date order</td>
        <td>status</td>
        <td></td>
    </header>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td><c:out value="${order.dateOrder}"/></td>
            <td><c:out value="${order.status}"/></td>
            <td><a href="dispatcher?command=orderPage&id=${order.id}"><input type="submit" value="detail"/></a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
