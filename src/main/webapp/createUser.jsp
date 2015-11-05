<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create user</title>
</head>

<body>
<div style="float: right;">

    <c:out value="${principal.firstName}"/>

    <a href="dispatcher?command=adminPage"><input type="submit" value="home"/></a>
    <a href="dispatcher?command=logout"><input type="submit" value="logout"/></a>

</div>
<form method="post" action="dispatcher?command=createUser">
    <table border="1" width="30%" cellpadding="5">
        <thead>
        </thead>
        <tbody>
        <tr>
            <td>Role</td>
            <td>
                <select name="role">
                    <option value="customer">customer</option>
                    <option value="seller">seller</option>
                    <option value="admin">admin</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>First Name</td>
            <td><input type="text" name="firstName" value="${user.firstName}"/></td>
        <tr>
            <c:if test="${errors.firstName!=null}">
                <th colspan="2">
                    <div style="color: #BA0000;"><c:out value="${errors.firstName}"/></div>
                </th>
            </c:if>
        </tr>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastName" value="${user.lastName}"/></td>
        <tr>
            <c:if test="${errors.lastName!=null}">
                <th colspan="2">
                    <div style="color: #BA0000;"><c:out value="${errors.lastName}"/></div>
                </th>
            </c:if>
        </tr>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" value="${user.address}"/></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="tel" name="phone" value="${user.phone}" placeholder="xxx-xxx-xx-xx"/></td>
        <tr>
            <c:if test="${errors.phone!=null}">
                <th colspan="2">
                    <div style="color: #BA0000;"><c:out value="${errors.phone}" /></div>
                </th>
            </c:if>
        </tr>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" value="${user.email}"/></td>
        <tr>
            <c:if test="${errors.email!=null}">
                <th colspan="2">
                    <div style="color: #BA0000;"><c:out value="${errors.email}"/></div>
                </th>
            </c:if>
        </tr>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" value="${user.password}"/></td>
        <tr>
            <c:if test="${errors.password!=null}">
                <th colspan="2">
                    <div style="color: #BA0000;"><c:out value="${errors.password}"/></div>
                </th>
            </c:if>
        </tr>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="create"/> <input type="reset" value="reset"/></td>
        </tr>

        </tbody>
    </table>
</form>
</body>
</html>
