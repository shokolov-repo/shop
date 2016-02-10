<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>edit profile</title>
    <link rel="stylesheet" type="text/css" href="styles/styles.css"/>
    <link rel="stylesheet" type="text/css" href="styles/form-styles.css"/>
    <link rel="stylesheet" type="text/css" href="styles/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="styles/bootstrap/css/bootstrap-theme.css"/>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="dispatcher?command=indexPage">Shop</a>
        </div>
        <div>
            <ul class="nav navbar-nav  navbar-right">
                <li>
                    <a href="dispatcher?command=indexPage"><span class="glyphicon glyphicon-home"></span> Home</a>
                </li>
                <li><a href="dispatcher?command=cart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a>
                </li>
                <li>
                    <a href="dispatcher?command=customerPage"><span class="glyphicon glyphicon-user"></span> My profile</a>
                </li>
                <li>
                    <a href="dispatcher?command=logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="form-container">
    <form class="form-signin" method="post" action="dispatcher?command=editProfile">
        <h2 class="form-signin-heading">Enter new data here</h2>
        <c:if test="${info!=null}">
            <span class="form-span"><c:out value="${info}"/></span>
        </c:if>
        <div class="form-group-lg">
            <c:if test="${user==null}">
                <input class="form-control" type="text" name="firstName" placeholder="${principal.firstName}"/>
            </c:if>
            <c:if test="${user!=null}">
                <input class="form-control" type="text" name="firstName" placeholder="${user.firstName}"/>
            </c:if>
            <c:if test="${errors.firstName!=null}">
                <span class="form-span"><c:out value="${errors.firstName}"/></span>
            </c:if>

            <c:if test="${user==null}">
                <input class="form-control" type="text" name="lastName" placeholder="${principal.lastName}"/>
            </c:if>
            <c:if test="${user!=null}">
                <input class="form-control" type="text" name="lastName" placeholder="${user.lastName}"/>
            </c:if>
            <c:if test="${errors.lastName!=null}">
                <span class="form-span"><c:out value="${errors.lastName}"/></span>
            </c:if>

            <c:if test="${user==null}">
                <input class="form-control" type="text" name="address" placeholder="${principal.address}"/>
            </c:if>
            <c:if test="${user!=null}">
                <input class="form-control" type="text" name="address" placeholder="${user.address}"/>
            </c:if>
            <c:if test="${errors.address!=null}">
                <span class="form-span"><c:out value="${errors.address}"/></span>
            </c:if>

            <c:if test="${user==null}">
                <input class="form-control" type="tel" name="phone" placeholder="${principal.phone}"/>
            </c:if>
            <c:if test="${user!=null}">
                <input class="form-control" type="tel" name="phone" placeholder="${user.phone}"/>
            </c:if>
            <c:if test="${errors.phone!=null}">
                <span class="form-span"><c:out value="${errors.phone}"/></span>
            </c:if>

            <c:if test="${user==null}">
                <input class="form-control" type="password" name="password1" placeholder="${principal.password}"/>
            </c:if>
            <c:if test="${user!=null}">
                <input class="form-control" type="password" name="password1" placeholder="${user.password}"/>
            </c:if>
            <c:if test="${errors.password1!=null}">
                <span class="form-span"><c:out value="${errors.password1}"/></span>
            </c:if>

            <c:if test="${user==null}">
                <input class="form-control" type="password" name="password2" placeholder="${principal.password}"/>
            </c:if>
            <c:if test="${user!=null}">
                <input class="form-control" type="password" name="password2" placeholder="${user.password}"/>
            </c:if>
            <c:if test="${errors.password2!=null}">
                <span class="form-span"><c:out value="${errors.password2}"/></span>
            </c:if>
            <c:if test="${errors.password!=null}">
                <span class="form-span"><c:out value="${errors.password}"/></span>
            </c:if>
        </div>
        <div class="btn-block">
            <input class="btn btn-success" type="submit" value="Edit"/>
            <input class="btn btn-default" type="reset" value="Reset"/>
        </div>
    </form>
</div>
</body>
</html>
