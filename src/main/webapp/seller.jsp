<%@ page import="dao.impl.OrderDAOImpl" %>
<%@ page import="entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Seller</title>
</head>
<body>
<c:forEach var="i" begin="1" end="5">
Item <c:out value="${i}"/><p>
    </c:forEach>

<div>
    <div>
        <form method="post" action="dispatcher?command=logout">
            <p style="text-align: right;"><input type="submit" value="logout"/></p>
        </form>
    </div>
    <div>
        <div>
            <%--<%--%>
                <%--List<Order> orders = new OrderDAOImpl().findAll();--%>
                <%--request.setAttribute("orders", orders);--%>
            <%--%>--%>

            <c:forEach var="order" items="${orders}">
            order <c:out default="" value="${order.status}"/>
            <input type="submit" value="status order"/>
            <input type="submit" value="delete order"/>
            <input type="submit" value="update order"/>

            <p>
                </c:forEach>
        </div>
        <div>
            <p style="text-align: center;">
                products list
                <input type="submit" value="add product"/>
                <input type="submit" value="delete product"/>
                <input type="submit" value="update product"/>
            </p>
        </div>
    </div>
</div>
</body>
</html>
