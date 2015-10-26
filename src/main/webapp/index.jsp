<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>
        Shop
    </title>
</head>

<body>
<div style="float: right;">

    <%--<c:set var="user" scope="session" value="${user}"/>--%>
    <c:if test="${user!=null}">

        <c:out value="${user.firstName}"/>
        <a href="dispatcher?command=customerPage&id=${user.id}">
            <button type="submit" value="">My profile</button>
        </a>
        <a href="dispatcher?command=logout">
            <button type="submit" value="">logout</button>
        </a>
    </c:if>
</div>
<div style="float: right;">
    <c:if test="${user==null}">

        <form method="post" action="dispatcher?command=login">
            <lable>E-mail</lable>
            <input type="text" name="email" value=""/>
            <label>Password</label>
            <input type="password" name="password" value=""/>
            <input type="submit" value="login"/>
            <input type="reset" value="Reset"/>
            <a href="registration.jsp">
                <button type="submit" value="registration">registration</button>
            </a></td>
        </form>
    </c:if>

    <h3>SHOP</h3>
</div>
<c:if test="${user!=null}">
    <table border="1">
        <header>
            <td>title</td>
            <td>price</td>
            <td>quantity</td>
            <td>description</td>
            <td></td>
        </header>
        <c:forEach var="product" items="${products}">
            <tr>
                <td><c:out value="${product.title}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.quantity}"/></td>
                <td><c:out value="${product.description}"/></td>
                <td><a href="dispatcher?command=addProductToBasket&productId=${product.id}">add</a></td>

            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${user==null}">
    <table border="1">
        <header>
            <td>title</td>
            <td>price</td>
            <td>quantity</td>
            <td>description</td>
        </header>
        <c:forEach var="product" items="${products}">
            <tr>
                <td><c:out value="${product.title}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.quantity}"/></td>
                <td><c:out value="${product.description}"/></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<div>
    bottom
</div>
</body>
</html>

