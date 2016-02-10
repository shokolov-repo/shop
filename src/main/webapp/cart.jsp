<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cart</title>
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
        <div>
            <ul class="nav navbar-nav navbar-right">

                <li>
                    <a href="dispatcher?command=indexPage"><span class="glyphicon glyphicon-home"></span> Home</a>
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


<div class="container">

    <%--<div class="jumbotron">--%>
    <%--<button id="btn1">#btn1</button>--%>
    <%--<button id="btn2">#btn2</button>--%>
    <%--<button id="btn3">#btn3</button>--%>
    <%--</div>--%>
    <%--<div class="row">--%>
    <%--<div class="col-xs-3">--%>
    <%--<div id="panel1" class="panel panel-primary">--%>
    <%--<div class="panel panel-heading">#head1</div>--%>
    <%--<div class="panel panel-body">body</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div class="col-xs-3">--%>
    <%--<div id="panel2" class="panel panel-primary">--%>
    <%--<div class="panel panel-heading">#head2</div>--%>
    <%--<div class="panel panel-body">body</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div class="col-xs-3">--%>
    <%--<div id="panel3" class="panel panel-primary">--%>
    <%--<div class="panel panel-heading">#head3</div>--%>
    <%--<div class="panel panel-body">body</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>


    <table id="table" class="table table-hover table-bordered">
        <thead>
        <tr class="bg-info">
            <th>title</th>
            <th>price</th>
            <th>quantity</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach var="addProduct" items="${cart}">
            <tbody>
            <tr>
                <td><c:out value="${addProduct.title}"/></td>
                <td><c:out value="${addProduct.price}"/></td>
                <td>
                    <input class="input-cost" type="text" onblur="recalculateCost(${addProduct.id})"
                           value="${addProduct.quantity}"/><br/>
                </td>
                <td>
                    <a class="btn btn-danger center-block" href="dispatcher?command=delFromCart&id=${addProduct.id}">Delete
                        from cart</a>
                </td>
            </tr>
            </tbody>
        </c:forEach>
        <thead>
        <tr class="bg-info">
            <th>cost</th>
            <th id="costValue"><c:out value="${cost}"/></th>

            <th></th>
            <th><a class=" btn btn-success center-block" href="#">Buy now</a></th>
        </tr>
        </thead>
    </table>

</div>
<script type="text/javascript">
    function recalculateCost(productId) {
        var val = $(' input.input-cost').val();
        $.ajax({
            type: 'POST',
            data: {
                "val": val,
                "id": productId
            },
            url: 'dispatcher?command=costProductCart',
            success: function () {
                $('#costValue').load(' #costValue');
            },
            error: function () {
                $('#costValue').html('error');
            }
        })
    }
    //    $(function () {
    //        $('input.input-cost').on('blur', recalculateCost(productId));
    //    });
    //        $(function () {
    //            $('#btn1').on('mouseover', function () {
    //                $('#panel1').fadeToggle(200);
    //            });
    //            $('#btn2').on('click', function () {
    //                $('#panel2').fadeToggle(200);
    //            });
    //            $('#btn3').on('blur', function () {
    //                $('#panel3').fadeToggle(200);
    //            });
    //        });
</script>
</body>

</html>
