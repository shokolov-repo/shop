<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>edit profile</title>
</head>
<body>
<div style="float: right;"><c:out value="${principal.firstName}"/></div>
<form method="post" action="dispatcher?command=editProfile">
    <table border="1" width="30%" cellpadding="5">
        <thead>
        <tr>
            <th colspan="2">Enter new data here</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>First Name</td>
            <c:if test="${user==null}">
            <td><input type="text" name="firstName" value="${principal.firstName}"/></td>
            </c:if>
            <c:if test="${user!=null}">
            <td><input type="text" name="firstName" value="${user.firstName}"/></td>
            </c:if>
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
            <c:if test="${user==null}">
            <td><input type="text" name="lastName" value="${principal.lastName}"/></td>
            </c:if>
            <c:if test="${user!=null}">
            <td><input type="text" name="lastName" value="${user.lastName}"/></td>
            </c:if>
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
            <c:if test="${user==null}">
                <td><input type="text" name="address" value="${principal.address}"/></td>
            </c:if>
            <c:if test="${user!=null}">
                <td><input type="text" name="address" value="${user.address}"/></td>
            </c:if>
        </tr>
        <tr>
            <td>Phone</td>
            <c:if test="${user==null}">
            <td><input type="tel" name="phone" value="${principal.phone}" placeholder="xxx-xxx-xx-xx"/></td>
            </c:if>
            <c:if test="${user!=null}">
            <td><input type="tel" name="phone" value="${user.phone}" placeholder="xxx-xxx-xx-xx"/></td>
            </c:if>
        <tr>
            <c:if test="${errors.phone!=null}">
                <th colspan="2">
                    <div style="color: #BA0000;"><c:out value="${errors.phone}"/></div>
                </th>
            </c:if>
        </tr>
        <tr>
            <td>Password</td>
            <c:if test="${user==null}">
                <td><input type="text" name="password1" value="${principal.password}"/></td>
            </c:if>
            <c:if test="${user!=null}">
                <td><input type="text" name="password1" value="${user.password}"/></td>
            </c:if>
        </tr>
        <tr>
            <c:if test="${errors.password1!=null}">
                <th colspan="2">
                    <div style="color: #BA0000;"><c:out value="${errors.password1}"/></div>
                </th>
            </c:if>
        </tr>
        <tr>
            <td>Confirm Password</td>
            <c:if test="${user==null}">
                <td><input type="text" name="password2" value="${principal.password}"/></td>
            </c:if>
            <c:if test="${user!=null}">
                <td><input type="text" name="password2" value="${user.password}"/></td>
            </c:if></tr>
        <tr>
            <c:if test="${errors.password2!=null}">
                <th colspan="2">
                    <div style="color: #BA0000;"><c:out value="${errors.password2}"/></div>
                </th>
            </c:if>
        </tr>
        <tr>
            <c:if test="${errors.password!=null&&errors.password1==null&&errors.password2==null}">
                <th colspan="2">
                    <div style="color: #BA0000;"><c:out value="${errors.password}"/></div>
                </th>
            </c:if>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="edit"/> <input type="reset" value="Reset"/></td>
        </tr>
        <tr>
            <td colspan="2"><a href="dispatcher?command=customerPage">Back to my profile</a></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
