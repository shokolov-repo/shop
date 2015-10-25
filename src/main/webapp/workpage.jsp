<%--
  Created by IntelliJ IDEA.
  User: dmity
  Date: 23.10.15
  Time: 7:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<style type="text/css">
  /*.block1 {*/
    /*width: 200px;*/
    /*background: #ccc;*/
    /*padding: 5px;*/
    /*padding-right: 20px;*/
    /*border: solid 1px black;*/
    /*float: left;*/
  /*}*/
  /*.block2 {*/
    /*width: 200px;*/
    /*background: #fc0;*/
    /*padding: 5px;*/
    /*border: solid 1px black;*/
    /*float: left;*/
    /*position: relative;*/
    /*top: 40px;*/
    /*left: -70px;*/
  /*}*/
  div {
    border: 1px solid black; /* Параметры рамки */
    padding: 5px; /* Поля вокруг текста */
    margin-bottom: 5px; /* Отступ снизу */
  }
  #left { text-align: left; }
  #right { text-align: right; }
  #center { text-align: center; }
  .content {
    /*width: 100%; /!* Ширина слоя *!/*/
    background: #fc0; /* Цвет фона */
  }
</style>
</head>
<body>

<%--<div class="block1">Lorem ipsum dolor sit amet, consectetuer--%>
  <%--adipiscing elit, sed diem nonummy nibh euismod tincidunt ut lacreet--%>
  <%--dolore magna aliguam erat volutpat.</div>--%>
<%--<div class="block2">Ut wisis enim ad minim veniam, quis nostrud--%>
  <%--exerci tution ullamcorper suscipit lobortis nisl ut aliquip ex--%>
  <%--ea commodo consequat.</div>--%>
<div id="left"><div class="content">Выравнивание по левому краюyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy
8888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii
uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu
jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj
llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll</div></div>
<div id="center"><div class="content">Выравнивание по центру</div></div>
<div id="right"><div class="content">Выравнивание по правому краю</div></div>
</body>
</html>