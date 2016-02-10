<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>

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
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="dispatcher?command=indexPage"><span class="glyphicon glyphicon-home"></span> Home</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="form-container">
        <form class="form-signin" method="post" action="dispatcher?command=registration">
            <h2 class="form-signin-heading">Registration</h2>

            <div class="form-group-lg">
                <input class="form-control" type="text" name="firstName" value="${user.firstName}"
                       placeholder="First Name *"/>
                <c:if test="${errors.firstName!=null}">
                    <span class="form-span"><c:out value="${errors.firstName}"/></span>
                </c:if>

                <input class="form-control" type="text" name="lastName" value="${user.lastName}"
                       placeholder="Last Name"/>
                <c:if test="${errors.lastName!=null}">
                    <span class="form-span"><c:out value="${errors.lastName}"/></span>
                </c:if>

                <input class="form-control" type="text" name="address" value="${user.address}" placeholder="Address"/>
                <c:if test="${errors.address!=null}">
                    <span class="form-span"><c:out value="${errors.address}"/></span>
                </c:if>

                <input class="form-control" type="tel" name="phone" value="${user.phone}"
                       placeholder="Phone xxx-xxx-xx-xx"/>
                <c:if test="${errors.phone!=null}">
                    <span class="form-span"><c:out value="${errors.phone}"/></span>
                </c:if>

                <input class="form-control" type="email" name="email" value="${user.email}"
                       placeholder="E-mail * x@x.x"/>
                <c:if test="${errors.email!=null}">
                    <span class="form-span"><c:out value="${errors.email}"/></span>
                </c:if>

                <input class="form-control" type="password" name="password1" value="" placeholder="Password *"/>
                <c:if test="${errors.password1!=null}">
                    <span class="form-span"><c:out value="${errors.password1}"/></span>
                </c:if>


                <input class="form-control" type="password" name="password2" value="" placeholder="Confirm password *"/>
                <c:if test="${errors.password2!=null}">
                    <span class="form-span"><c:out value="${errors.password2}"/></span>
                </c:if>
                <c:if test="${errors.password!=null}">
                    <span class="form-span"><c:out value="${errors.password}"/></span>
                </c:if>
            </div>


            <div class="btn-block">
                <input class="btn btn-success" type="submit" value="Submit"/>
                <input class="btn btn-default" type="reset" value="Reset"/>
            </div>

        </form>
    </div>
</div>

</body>
</html>
