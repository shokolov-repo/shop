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
</head>
<body>
<div style="color: #BA0000;"><c:out value="${error}"/></div>
<div style="text-align: right;">

    <a href="dispatcher?command=logout"><input type="submit" value="logout"/></a>
    <a href="createUser.jsp"><input type="submit" value="create user"/></a>
</div>
<table border="1">
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
    <c:forEach var="user" items="${users}">
    <tr>
        <td><c:out value="${user.firstName}"/></td>
        <td><c:out value="${user.lastName}"/></td>
        <td><c:out value="${user.address}"/></td>
        <td><c:out value="${user.phone}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td><c:out value="${user.role}"/></td>
        <td><a href="dispatcher?command=deleteUser&id=${user.id}">delete user</a></td>
        <td><a href="dispatcher?command=editUser&id=${user.id}">edit user</a></td>
    </tr>
    </c:forEach>
</body>
</html>
