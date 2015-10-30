<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>
        Shop
    </title>
    <style>
        body {
            background: url(http://4.bp.blogspot.com/-Ek0auGwstqY/USITkC7wfcI/AAAAAAAAA6k/i-UvbPB47s4/s1600/image-wallpaper-1920-1200-Funny-Cat-Orion-Maine-Coon-kitten-LOL-cats-Ni79987411.jpg);
        }

        form {
            width: 450px;
            height: 20px;
        }
    </style>
</head>

<body>
<c:if test="${user!=null}">
    <div style="float: right;">
        <c:out value="${user.firstName}"/>
        <a href="dispatcher?command=cart"><input type="submit" value="cart"/></a>
        <a href="dispatcher?command=customerPage"><input type="submit" value="My profile"/></a>
        <a href="dispatcher?command=logout"><input type="submit" value="logout"/></a>
    </div>
</c:if>
<c:if test="${user==null}">

    <div style="float: right;">
        <a href="registration.jsp"><input type="submit" value="registration"/></a>
    </div>
    <div style="float: right;">
        <form method="post" action="dispatcher?command=login">
            <input type="email" name="email" required title="enter your email" placeholder="E-mail">
            <input type="password" name="password" required title="enter your password" placeholder="Password"/>
            <input type="submit" value="login"/>
        </form>
    </div>
</c:if>

<table border="1" style="background-color: white;">
    <thead>
    <c:if test="${error!=null}">
    <tr>
        <th colspan="5">
            <div style="color: #BA0000;"><c:out value="${error}"/></div>
        </th>
    </tr>
    </c:if>
    <td>title</td>
    <td>price</td>
    <td>quantity</td>
    <td>description</td>
    <c:if test="${user!=null}">
    <td></td>
    </c:if>
    <thead>
    <tbody>
    <c:forEach var="product" items="${products}">
    <tr>
        <td><c:out value="${product.title}"/></td>
        <td><c:out value="${product.price}"/></td>
        <td><c:out value="${product.quantity}"/></td>
        <td><c:out value="${product.description}"/></td>
        <c:if test="${user!=null}">
            <td><a href="dispatcher?command=addProductToCart&id=${product.id}"><input type="submit"
                                                                                      value="add to cart"/></a></td>
        </c:if>
    </tr>
    </c:forEach>
    <tbody>
</table>
</body>
</html>

