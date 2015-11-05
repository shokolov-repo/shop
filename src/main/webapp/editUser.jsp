<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>edit user</title>
</head>
<body>
<form method="post" action="dispatcher?command=edit&id=${user.id}">
    <table border="1" width="30%" cellpadding="5">
        <thead>
        <tr>
            <th colspan="2">Enter new data here</th>
        </tr>
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
            <td><input type="text" name="phone" value="${user.phone}" placeholder="xxx-xxx-xx-xx"/></td>
        </tr>
        <tr>
            <c:if test="${errors.phone!=null}">
                <th colspan="2">
                    <div style="color: #BA0000;"><c:out value="${errors.phone}"/></div>
                </th>
            </c:if>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" value="${user.password}"/></td>
        </tr>
        <tr>
            <c:if test="${errors.password!=null}">
                <th colspan="2">
                    <div style="color: #BA0000;"><c:out value="${errors.password}"/></div>
                </th>
            </c:if>
        </tr>

        <tr>
            <td></td>
            <td><input type="submit" value="submit"/>
                <input type="reset" value="Reset"/></td>
        </tr>
        <tr>
            <td colspan="2"><a href="dispatcher?command=adminPage">Back</a></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
