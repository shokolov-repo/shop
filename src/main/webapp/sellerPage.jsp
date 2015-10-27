<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Seller</title>
</head>
<body>


<div>
    <p style="text-align: right;">
        <%
            out.print(session.getAttribute("name"));
        %>
        <a href="dispatcher?command=logout">
            <input type="submit" value="logout"/>
        </a>
        <a href="editProfile.jsp">
            <button type="submit" value="update account">update account</button>
        </a>
    </p>
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
            <td><c:out value="${order.userId}"/></td>
            <td><c:out value="${order.dateOrder}"/></td>
            <td><c:out value="${order.status}"/></td>
            <td><a href="dispatcher?command=editStatus&orderId='${order.id}">edit status</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
