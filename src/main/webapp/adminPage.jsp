<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AdminPage</title>
    <link rel="stylesheet" type="text/css" href="styles/form-styles.css"/>
    <link rel="stylesheet" type="text/css" href="styles/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="styles/bootstrap/css/bootstrap-theme.css"/>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="dispatcher?command=adminPage">Shop</a>
        </div>
        <div>
            <ul class="nav navbar-nav  navbar-right">
                <li>
                    <a href="createUser.jsp"><span class="glyphicon glyphicon-plus"></span> Create user</a>
                </li>
                <li>
                    <a href="dispatcher?command=logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<table class="table table-bordered table-hover ">
    <thead class="bg-info">
    <tr>
        <th>first name</th>
        <th>last name</th>
        <th>address</th>
        <th>phone</th>
        <th>email</th>
        <th>role</th>
        <th>delete</th>
        <th>edit</th>
    </tr>
    </thead>
    <c:forEach var="user" items="${users}">
    <tbody>
    <tr>
        <td><c:out value="${user.firstName}"/></td>
        <td><c:out value="${user.lastName}"/></td>
        <td><c:out value="${user.address}"/></td>
        <td><c:out value="${user.phone}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td><c:out value="${user.role}"/></td>
        <td><a class="btn" href="dispatcher?command=deleteUser&id=${user.id}">delete</a></td>
        <td><a class="btn" href="dispatcher?command=editUser&id=${user.id}">edit</a></td>
    </tr>
    </tbody>
    </c:forEach>
</body>
</html>
