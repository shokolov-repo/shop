<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div style="text-align: right;">
    <c:out value="${principal.firstName}"/>
    <a href="dispatcher?command=sellerPage"><input type="submit" value="home"/></a>
    <a href="dispatcher?command=logout"><input type="submit" value="logout"/></a>
</div>
<table border="1">
    <tr>
        <th>first name</th>
        <th>phone</th>
        <th>email</th>
    <tr>
        <td><c:out value="${customer.firstName}"/></td>
        <td><c:out value="${customer.phone}"/></td>
        <td><c:out value="${customer.email}"/></td>
    </tr>
</table>

</body>
</html>
