<%--
  Created by IntelliJ IDEA.
  User: dmity
  Date: 20.10.15
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form method="post" action="dispatcher?command=registration">
    <center>
        <table border="1" width="30%" cellpadding="5">
            <thead>
            <tr>
                <th colspan="2">Enter Information Here</th>
            </tr>
            </thead>
            <tbody>
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
                <td><input type="email" name="email" value=""/></td>
            </tr>

            <tr>
                <td>Password</td>
                <td><input type="password" name="password1" value=""/></td>
            </tr>
            <tr>
                <td>Confirm Password</td>
                <td><input type="password" name="password2" value=""/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
                <td><input type="reset" value="Reset"/></td>
            </tr>
            <tr>
                <td colspan="2"><a href="dispatcher?command=indexPage">Login Here</a></td>
            </tr>
            </tbody>
        </table>
    </center>
</form>
</body>
</html>
