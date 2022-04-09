<%--
  Created by IntelliJ IDEA.
  User: sihongxiao
  Date: 2021/12/28
  Time: 6:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加药品库存信息</title>
    <style>
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<h2>添加库存信息</h2>
<hr>
<form action="AddStock.do" method="post">
    药品名称：
    <input type="text" name="m_name"><br><br>
    生产日期：
    <input type="date" name="m_pdate"><br><br>
    保质期：
    <input type="date" name="m_edate"><br><br>
    库存量：
    <input type="text" name="m_snumber"><br><br>
    存放位置：
    <input type="text" name="m_place"><br><br>
    <input type="submit" value="添加">
    <input type="reset" name="重置">
</form>
<a href="javascript:" onclick="history.go(-1)"><h2>返回</h2></a>
</body>
</html>