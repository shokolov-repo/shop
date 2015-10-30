<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>edit profile</title>
</head>
<body>
<form method="post" action="dispatcher?command=edit&id=${user.id}">
    <table border="1" width="30%" cellpadding="5">
        <thead>
        <tr>
            <th colspan="2">Enter new data here</th>
        </tr>
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
            <td>Enter new Role</td>
            <td>
                <select  name="role">
                <option value="customer">customer</option>
                <option value="seller">seller</option>
                <option value="admin">admin</option>
            </select>
            </td>
        </tr>
        <tr>
            <td>Enter new First Name</td>
            <td><input type="text" name="firstName" value="${user.firstName}"/></td>
        </tr>
        <tr>
            <td>Enter new Last Name</td>
            <td><input type="text" name="lastName" value="${user.lastName}"/></td>
        </tr>
        <tr>
            <td>Enter new Address</td>
            <td><input type="text" name="address" value="${user.address}"/></td>
        </tr>
        <tr>
            <td>Enter new Phone</td>
            <td><input type="text" name="phone" value="${user.phone}"/></td>
        </tr>
        <tr>
            <td>Enter new Email</td>
            <td><input type="email" name="email" value="${user.email}" required/></td>
        </tr>

        <tr>
            <td>Enter new Password</td>
            <td><input type="password" name="password" value="${user.password}" required/></td>
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
