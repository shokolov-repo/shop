<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order page</title>
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
            <ul class="nav navbar-nav navbar-right">
                <li><a href="dispatcher?command=indexPage"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                <li><a href="dispatcher?command=cart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a>
                </li>
                <li><a href="dispatcher?command=customerPage"><span class="glyphicon glyphicon-user"></span> My profile</a>
                </li>
                <li><a href="dispatcher?command=logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<table class="table table-hover table-bordered">
    <thead class="bg-info">
    <tr>
        <th>title</th>
        <th>quantity</th>
        <th>price</th>
    </tr>
    </thead>
    <c:forEach var="product" items="${products}">
        <tbody>
        <tr>
            <td><c:out value="${product.title}"/></td>
            <td><c:out value="${product.quantity}"/></td>
            <td><c:out value="${product.price}"/></td>
        </tr>
        </tbody>
    </c:forEach>
</table>
</body>
</html>
