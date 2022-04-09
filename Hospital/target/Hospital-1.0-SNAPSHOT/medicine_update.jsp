<%--
  Created by IntelliJ IDEA.
  User: sihongxiao
  Date: 2021/12/28
  Time: 3:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改药品信息</title>
    <style>
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<h2>修改药品信息</h2>
<hr>
<form action="UpdateMedicine.do" method="post">
    <input type="text" name="m_id" value="${medicine.m_id}" style="display:none;">
    药品名称：
    <input type="text" name="m_name" value="${medicine.m_name}"><br><br>
    药品类型：
    <input type="text" name="m_type" value="${medicine.m_type}"><br><br>
    药品品牌：
    <input type="text" name="m_brand" value="${medicine.m_brand}"><br><br>
    药品价格：
    <input type="text" name="m_price" value="${medicine.m_price}"><br><br>
    药品规格：
    <input type="text" name="m_specification" value="${medicine.m_specification}"><br><br>
    <input type="submit" value="修改">
    <input type="reset" name="重置">
</form>
<a href="javascript:" onclick="history.go(-1)"><h2>返回</h2></a>
</body>
</html>