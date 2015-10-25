<%--
  Created by IntelliJ IDEA.
  User: dmity
  Date: 20.10.15
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table width="100%" height="100%" bgcolor="white" cellpadding="0" cellspacing="0" border="0">
    <tr>
        <td>
            <table width="100%" height="10%" bgcolor="white" cellpadding="0" cellspacing="0" border="0">
                <tr>
                    <td>
                        <form method="post" action="dispatcher?command=logout">
                            <p style="text-align: right;"><input type="submit" value="logout"/></p>
                        </form>
                        <p style="text-align: center;">
                            <a href="product.jsp">
                                <button type="submit" value="buy">ПАКУПАТЬ ХАЧУ</button>
                            </a>
                        </p>
                    </td>
                </tr>
            </table>
            <table width="100%" height="80%" bgcolor="white" cellpadding="0" cellspacing="0" border="0">
                <tr>
                    <td width="80%" height="100%" bgcolor="#e6e6fa">
                        <table>
                            <tr>
                                <td>
                                    <h1>profile</h1>
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td width="20%" height="100%" bgcolor="#f0f8ff">
                        <table>
                            <tr>
                                <td>
                                    <h1>orders</h1>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            <table width="100%" height="10%" bgcolor="#e6e6fa" cellpadding="" cellspacing="" border="">
                <tr>
                    <td>
                        <p style="text-align: center;">
                            <a href="updateaccount.jsp">
                                <button type="submit" value="update account">update account</button>
                            </a>
                        </p>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
