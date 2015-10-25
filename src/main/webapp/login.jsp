<%--
  Created by IntelliJ IDEA.
  User: dmity
  Date: 20.10.15
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>shop</title>
</head>
<body>
<%--<h2><%= request.getAttribute("error")%></h2>--%>
<form method="post" action="dispatcher?command=login">
    <center>
        <table border="1" width="30%" cellpadding="3">

            <tbody>
            <tr>
                <td>E-mail</td>
                <td><input type="text" name="email" value=""/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" value=""/></td>
            </tr>
            <tr>
                <td><input type="submit" value="login"/></td>
                <td><input type="reset" value="Reset"/></td>
            </tr>
            <tr>
                <td colspan="2"><a href="registration.jsp">Register Here</a></td>
            </tr>
            </tbody>
        </table>
    </center>
</form>
</body>
</html>
