<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create user</title>

    <link rel="stylesheet" type="text/css" href="styles/form-styles.css"/>
    <link rel="stylesheet" type="text/css" href="styles/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="styles/bootstrap/css/bootstrap-theme.css"/>
</head>

<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="dispatcher?command=adminPage">Shop</a>
        </div>
        <div>
            <ul class="nav navbar-nav  navbar-right">
                <li>
                    <a href="dispatcher?command=adminPage"><span class="glyphicon glyphicon-home"></span> Home</a>
                </li>
                <li>
                    <a href="dispatcher?command=logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
      <div class="form-container">
        <form class="form-signin" method="post" action="dispatcher?command=createUser">
            <h2 class="form-signin-heading">Create user form</h2>
            <div class="form-group-lg">
                <select class="form-control" name="role">
                    <option value="customer">customer</option>
                    <option value="seller">seller</option>
                    <option value="admin">admin</option>
                </select>
                <input class="form-control" type="text" name="firstName" placeholder="First Name"
                       value="${user.firstName}"/>
                <c:if test="${errors.firstName!=null}">
                    <span class="form-span"><c:out value="${errors.firstName}"/></span>
                </c:if>

                <input class="form-control" type="text" name="lastName" placeholder="Last Name"
                       value="${user.lastName}"/>
                <c:if test="${errors.lastName!=null}">
                    <span class="form-span"><c:out value="${errors.lastName}"/></span>
                </c:if>

                <input class="form-control" type="text" name="address" placeholder="Address" value="${user.address}"/>
                <c:if test="${errors.address!=null}">
                    <span class="form-span"> <c:out value="${errors.address}"/></span>
                </c:if>

                <input class="form-control" type="text" name="phone" value="${user.phone}"
                       placeholder="Phone xxx-xxx-xx-xx"/>
                <c:if test="${errors.phone!=null}">
                    <span class="form-span"><c:out value="${errors.phone}"/></span>
                </c:if>

                <input class="form-control" type="email" name="email" placeholder="Email" value="${user.email}"/>
                <c:if test="${errors.email!=null}">
                    <span class="form-span"><c:out value="${errors.email}"/></span>
                </c:if>

                <input class="form-control" type="password" name="password" placeholder="Password"
                       value="${user.password}"/>
                <c:if test="${errors.password!=null}">
                    <span class="form-span"><c:out value="${errors.password}"/></span>
                </c:if>
            </div>
            <div class="btn-block">
                <input class="btn btn-info" type="submit" value="create"/>
                <input class="btn btn-default" type="reset" value="reset"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>
