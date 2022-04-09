<%--
  Created by IntelliJ IDEA.
  User: sihongxiao
  Date: 2021/12/28
  Time: 2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>添加药品信息</title>
    <meta charset="UTF-8">
    <style>
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<h2>添加药品</h2>
<hr>
<form action="addMedicine.do" method="post">
    药品名称：
    <input type="text" name="m_name"><br><br>
    药品类型：
    <input type="text" name="m_type"><br><br>
    药品品牌：
    <input type="text" name="m_brand"><br><br>
    药品价格：
    <input type="text" name="m_price"><br><br>
    药品规格：
    <input type="text" name="m_specification"><br><br>
    <input type="submit" value="添加">
    <input type="reset" name="重置">
</form>
<a href="javascript:" onclick="history.go(-1)"><h2>返回</h2></a>
</body>
</html>