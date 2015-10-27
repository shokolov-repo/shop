<%--
  Created by IntelliJ IDEA.
  User: dmity
  Date: 25.10.15
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AdminPage</title>
    <style>
        div {
            padding: 5px;
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
<div>
    <p style="text-align: right;">
        <a href="dispatcher?command=logout">
            <input type="submit" value="logout"/>
        </a>
    </p>
</div>
<table border="1">
    <header>
        <td>first name</td>
        <td>last name</td>
        <td>address</td>
        <td>phone</td>
        <td>email</td>
        <td>role</td>
        <td>delete</td>
        <td>edit</td>
        <td>edit comment</td>
    </header>
    <c:forEach var="user" items="${users}">
    <tr>
        <td><c:out value="${user.firstName}"/></td>
        <td><c:out value="${user.lastName}"/></td>
        <td><c:out value="${user.address}"/></td>
        <td><c:out value="${user.phone}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td><c:out value="${user.role}"/></td>
        <td><a href="dispatcher?command=deleteUser">delete user</a></td>
        <td><a href="dispatcher?command=editUser">edit user</a></td>
        <td><a href="dispatcher?command=editUserComment">edit comment</a></td>
    </tr>
    </c:forEach>
</body>
</html>
