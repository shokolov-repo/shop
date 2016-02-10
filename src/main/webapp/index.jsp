<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>
        Shop
    </title>
    <link rel="stylesheet" type="text/css" href="styles/styles.css"/>
    <link rel="stylesheet" type="text/css" href="styles/form-styles.css"/>
    <link rel="stylesheet" type="text/css" href="styles/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="styles/bootstrap/css/bootstrap-theme.css"/>

    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
</head>

<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="dispatcher?command=indexPage">Shop</a>
        </div>
        <c:if test="${principal!=null}">
            <div>
                <ul class="nav navbar-nav  navbar-right">
                    <li><a href="dispatcher?command=cart"><span class="glyphicon glyphicon-shopping-cart"></span>
                        Cart</a></li>
                    <li>
                        <a href="dispatcher?command=customerPage"><span class="glyphicon glyphicon-user"></span> My
                            profile</a>
                    </li>
                    <li><a href="dispatcher?command=logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
                    </li>
                </ul>
            </div>
        </c:if>
        <c:if test="${principal==null}">
            <ul class="nav navbar-nav  navbar-right">
                <li>
                    <a href="registration.jsp"><span class="glyphicon glyphicon-registration-mark"></span>
                        Registration</a>
                </li>
            </ul>
            <form class=" nav navbar-form navbar-right" method="post" action="dispatcher?command=login">
                <input class="form-control" type="email" name="email" required title="enter your email"
                       placeholder="E-mail">
                <input class="form-control" type="password" name="password" required title="enter your password"
                       placeholder="Password"/>
                <button class="btn-link" type="submit"><span class="glyphicon glyphicon-log-in"></span> Login
                </button>
            </form>
        </c:if>
    </div>
</nav>
<div class="tab-panels">
    <ul class="tabs nav nav-tabs">
        <li rel="first" class="active"><a href="#"><span class="glyphicon glyphicon-th"></span></a></li>
        <li rel="second"><a href="#"><span class="glyphicon glyphicon-th-list"></span></a></li>
    </ul>

    <div id="first" class="panel active">
        <c:forEach var="product" items="${products}">
            <div class="col-lg-2 panel-info">
                <div class="panel-heading"><c:out value="title : ${product.title}"/></div>
                <div class="panel-body"><c:out value="price : ${product.price}"/>
                    <hr/>
                <c:out value="quantity : ${product.quantity}"/></div>
                <div class="panel-footer"><c:out value="${product.description}"/></div>
                <c:if test="${principal!=null}">
                    <a class="btn btn-success center-block" href="dispatcher?command=addProductToCart&id=${product.id}">add to cart</a><br/>
                </c:if>
            </div>
        </c:forEach>
    </div>
    <div id="second" class="panel">
        <table class="table table-hover table-bordered">
            <thead class="bg-info">
            <tr>
                <th>title</th>
                <th>price</th>
                <th>quantity</th>
                <th>description</th>
                <c:if test="${principal!=null}">
                    <th></th>
                </c:if>
            </tr>
            <thead>
            <tbody>
            <c:forEach var="product" items="${products}">
            <tr>
                <td><c:out value="${product.title}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.quantity}"/></td>
                <td><c:out value="${product.description}"/></td>
                <c:if test="${principal!=null}">
                    <td><a class="btn btn-success center-block"
                           href="dispatcher?command=addProductToCart&id=${product.id}">add
                        to cart</a></td>
                </c:if>
            </tr>
            </c:forEach>
            <tbody>
        </table>
    </div>
</div>
<script>
    $(function () {
        $('.tab-panels .tabs li').on('click', function () {

            $('.tab-panels .tabs li.active').removeClass('active');
            $(this).addClass('active');
            var panelToShow = $(this).attr('rel');

            $('.tab-panels .panel.active').slideUp(500, function () {
                $(this).removeClass('active');

                $('#' + panelToShow).slideDown(500, function () {
                    $(this).addClass('active');
                });
            });
        });
    });
</script>
</body>
</html>

