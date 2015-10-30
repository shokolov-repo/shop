<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <c:if test="${error!=null}">
                <tr>
                    <th colspan="2">
                        <div style="color: #BA0000;"><c:out value="${error}"/></div>
                    </th>
                </tr>
            </c:if>
            <tr>
                <td style="display: table-cell;">First Name</td>
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
                <td><label>E-mail<span
                        style="color: #BA0000; font-family: Verdana; font-size: 16px; font-weight: bold;"> *</span></label>
                </td>
                <td><input type="email" name="email" value="" required/></td>
            </tr>
            <tr>
                <td><label>Password<span
                        style="color: #BA0000; font-family: Verdana; font-size: 16px; font-weight: bold;"> *</span></label>
                </td>
                <td><input type="password" name="password" value="" required/></td>
            </tr>
            <tr>
                <td><label>Confirm password<span
                        style="color: #BA0000; font-family: Verdana; font-size: 16px; font-weight: bold;"> *</span></label>
                </td>
                <td><input type="password" name="password" value="" required/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Submit"/> <input type="reset" value="Reset"/></td>
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
