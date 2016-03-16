<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Page</title>
    <link rel="stylesheet" type="text/css" href="styles/styles.css"/>
    <link rel="stylesheet" type="text/css" href="styles/form-styles.css"/>
    <link rel="stylesheet" type="text/css" href="styles/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="styles/bootstrap/css/bootstrap-theme.css"/>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="dispatcher?command=indexPage">Shop</a>
        </div>
        <div>
            <ul class="nav navbar-nav  navbar-right">
                <li>
                    <a href="dispatcher?command=indexPage"><span class="glyphicon glyphicon-home"></span> Home</a>
                </li>
                <li><a href="dispatcher?command=cart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a>
                </li>
                <li><a href="editProfile.jsp"><span class="glyphicon glyphicon-edit"></span> Edit profile</a></li>
                <li><a href="dispatcher?command=logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <table class="table table-bordered table-hover">
        <thead>
        <tr class="bg-info">
            <th>date order</th>
            <th>status</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td><c:out value="${order.dateOrder}"/></td>
                <td><c:out value="${order.status}"/></td>
                <td><a class="btn btn-info center-block" href="dispatcher?command=orderPage&id=${order.id}">Detail</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
