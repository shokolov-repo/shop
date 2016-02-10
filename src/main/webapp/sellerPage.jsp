<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Seller</title>
    <link rel="stylesheet" type="text/css" href="styles/styles.css"/>
    <link rel="stylesheet" type="text/css" href="styles/form-styles.css"/>
    <link rel="stylesheet" type="text/css" href="styles/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="styles/bootstrap/css/bootstrap-theme.css"/>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="dispatcher?command=sellerPage">Shop</a>
        </div>
        <div>
            <ul class="nav navbar-nav  navbar-right">
                <li>
                    <a href="dispatcher?command=logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<table class="table">
    <thead class="bg-info">
    <tr>
        <th>customer id</th>
        <th>date order</th>
        <th>status</th>
        <th></th>
    </tr>
    </thead>
    <c:forEach var="order" items="${orders}">
        <tbody>
        <tr>
            <td><c:out value="${order.dateOrder}"/></td>
            <td><c:out value="${order.status}"/></td>
            <td><a href="dispatcher?command=getCustomer&id=${order.id}"><input type="submit" value="customer data"/></a>
            </td>
            <td><a href="dispatcher?command=editStatus&id=${order.id}"><input type="submit" value="edit status"/></a>
            </td>
        </tr>
        </tbody>
    </c:forEach>
</table>

</body>
</html>
