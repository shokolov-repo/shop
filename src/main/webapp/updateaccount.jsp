<%--
  Created by IntelliJ IDEA.
  User: dmity
  Date: 22.10.15
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Update Account</title>
</head>
<body>
<form method="post" action="dispatcher?command=updateAccount">
  <center>
    <table border="1" width="30%" cellpadding="5">
      <thead>
      <tr>
        <th colspan="2">Enter new data here</th>
      </tr>
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
        <td><input type="text" name="email" value=""/></td>
      </tr>

      <tr>
        <td>Enter new Password</td>
        <td><input type="password" name="password" value=""/></td>
      </tr>
      <tr>
        <td><input type="submit" value="Update"/></td>
        <td><input type="reset" value="Reset"/></td>
      </tr>
      <tr>
        <td colspan="2"><a href="user.jsp">Home page</a></td>
      </tr>
      </tbody>
    </table>
  </center>
</form>
</body>
</html>
