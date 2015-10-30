<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>edit profile</title>
</head>
<body>
<form method="post" action="dispatcher?command=editProfile">
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
            <td>Enter new First Name</td>
            <td><input type="text" name="firstName" value=""/></td>
        </tr>
        <tr>
            <td>Enter new Last Name</td>
            <td><input type="text" name="lastName" value=""/></td>
        </tr>
        <tr>
            <td>Enter new Address</td>
            <td><input type="text" name="address" value=""/></td>
        </tr>
        <tr>
            <td>Enter new Phone</td>
            <td><input type="text" name="phone" value=""/></td>
        </tr>
        <tr>
            <td>Enter new Email</td>
            <td><input type="text" name="email" value="" required/></td>
        </tr>

        <tr>
            <td>Enter new Password</td>
            <td><input type="password" name="password" value="" required/></td>
        </tr>
        <tr>
            <td><input type="submit" value="edit"/></td>
            <td><input type="reset" value="Reset"/></td>
        </tr>
        <tr>
            <td colspan="2"><a href="dispatcher?command=customerPage">Back to my profile</a></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
