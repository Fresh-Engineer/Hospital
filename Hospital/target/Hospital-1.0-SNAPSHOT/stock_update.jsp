<%--
  Created by IntelliJ IDEA.
  User: sihongxiao
  Date: 2021/12/28
  Time: 7:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改库存信息</title>
    <style>
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<h2>修改库存信息</h2>
<hr>
<form action="UpdateStock.do" method="post">
    <input type="hidden" name="m_sid" value="${stock.m_sid}">
    药品名称：
    <input type="text" name="m_name" value="${stock.m_name}"><br><br>
    库存量：
    <input type="text" name="m_snumber" value="${stock.m_snumber}"><br><br>
    <input type="submit" value="确认修改">
    <input type="reset" name="重置">
</form>
<a href="javascript:" onclick="history.go(-1)"><h2>返回</h2></a>
</body>
</html>