<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>
        Shop
    </title>
</head>

<body>
<c:if test="${user!=null}">
    <div style="float: right;">
        
        <c:out value="${user.firstName}"/>
        <a href="dispatcher?command=cart"><input type="submit" value="cart"/></a>
        <a href="dispatcher?command=customerPage"><input type="submit" value="My profile"/></a>
        <a href="dispatcher?command=logout"><input type="submit" value="logout"/></a>
    </div>
    <table border="1">
        <header>
            <label>title</label>
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
                <td><a href="dispatcher?command=addProductToCart&id=${product.id}"><input type="submit" value="add to cart"/></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${user==null}">
    <div style="float: right;">
        <form method="post" action="dispatcher?command=login">
            <lable>E-mail</lable>
            <input type="email" name="email" value=""/>
            <label>Password</label>
            <input type="password" name="password" value=""/>
            <input type="submit" value="login"/>
            <input type="reset" value="Reset"/>
            <a href="registration.jsp">
                <button type="submit" value="registration">registration</button>
            </a>
        </form>
        <h3>SHOP</h3>
    </div>
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

