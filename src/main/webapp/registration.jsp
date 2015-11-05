<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form method="post" action="dispatcher?command=registration">
    <table border="1" width="30%" cellpadding="5">

        <thead>
        <tr>
            <th colspan="2">Enter Information Here</th>
        </tr>
        </thead>

        <tbody>
        <tr>
            <td><label>First Name<span
                    style="color: #BA0000; font-family: Verdana; font-size: 16px; font-weight: bold;"> *</span></label>
            </td>
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
        </tr>
        <tr>
            <c:if test="${errors.phone!=null}">
                <th colspan="2">
                    <div style="color: #BA0000;"><c:out value="${errors.phone}"/></div>
                </th>
            </c:if>
        </tr>
        <tr>
            <td><label>E-mail<span
                    style="color: #BA0000; font-family: Verdana; font-size: 16px; font-weight: bold;"> *</span></label>
            </td>
            <td><input type="email" name="email" value="${user.email}" placeholder="x@x.x"/></td>
        <tr><c:if test="${errors.email!=null}">
            <th colspan="2">
                <div style="color: #BA0000;"><c:out value="${errors.email}"/></div>
            </th>
        </c:if></tr>
        </tr>

        <tr>
            <td><label>Password<span
                    style="color: #BA0000; font-family: Verdana; font-size: 16px; font-weight: bold;"> *</span></label>
            </td>
            <td><input type="password" name="password1" value=""/></td>
        <tr>
            <c:if test="${errors.password1!=null}">
                <th colspan="2">
                    <div style="color: #BA0000;"><c:out value="${errors.password1}"/></div>
                </th>
            </c:if>
        </tr>
        </tr>

        <tr>
        <tr>
            <td>
                <label>
                    Confirm password
                    <span style="color: #BA0000; font-family: Verdana; font-size: 16px; font-weight: bold;"> *</span>
                </label>
            </td>
            <td><input type="password" name="password2" value=""/></td>
        </tr>
        <tr>
            <c:if test="${errors.password2!=null}">
                <th colspan="2">
                    <div style="color: #BA0000;"><c:out value="${errors.password2}"/></div>
                </th>
            </c:if>
            <c:if test="${errors.password!=null&&errors.password1==null&&errors.password2==null}">
                <th colspan="2">
                    <div style="color: #BA0000;"><c:out value="${errors.password}"/></div>
                </th>
            </c:if>
        </tr>
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
</form>

</body>
</html>
