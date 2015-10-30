<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create user</title>
</head>

<body>
<div style="float: right;">

    <c:out value="${user.firstName}"/>

    <a href="dispatcher?command=adminPage"><input type="submit" value="home"/></a>
    <a href="dispatcher?command=logout"><input type="submit" value="logout"/></a>

</div>
<form method="post" action="dispatcher?command=createUser">
    <table border="1" width="30%" cellpadding="5">
        <thead>
        <c:if test="${error!=null}">
            <tr>
                <th colspan="2" style="color: #BA0000;">
                    <c:out value="${error}"/>
                </th>
            </tr>
        </c:if>
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
            <td><input type="text" name="firstName" value=""/></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastName" value=""/></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" value=""/></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="tel" name="phone" value=""/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" name="email" value="" required/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" value="" required/></td>
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
