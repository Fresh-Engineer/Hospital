<%--
  Created by IntelliJ IDEA.
  User: sihongxiao
  Date: 2021/12/27
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加费用信息</title>
    <link rel="stylesheet" href="css/patientcss.css">
    <style>
        form {
            width: 260px;
            height: 260px;
            display: block;
        }

        label {
            width: 80px;
            height: 30px;
        }

        input {
            margin-right: 0;
            float: right;
        }

        a {
            text-decoration: none;
        }

        .check {
            display: inline-block;
            width: 260px;
            height: 30px;
        }

        .button {
            display: flex;
            flex-direction: row;
            justify-content: space-around;
        }
    </style>
</head>
<body>
<h2>添加费用信息</h2>
<hr>
<form action="CostAdd.do" method="post">
    <label for="p_name">患者姓名：</label>
    <input type="text" id="p_name" name="p_name">
    <br><br>
    <label for="sex">性别：</label>
    <input type="text" id="sex" name="sex">
    <br><br>
    <label for="age">年龄：</label>
    <input type="text" id="age" name="age">
    <br><br>
    <label for="phone">电话号码：</label>
    <input type="text" id="phone" name="phone">
    <br><br>
    <label for="cost">费用：</label>
    <input type="text" id="cost" name="cost">
    <br><br>
    <div class="check">
        <label for="state" style="margin-right: 20px;">状态：</label>
        <input style="float: none" type="radio" id="state" name="state" value="已支付">已支付
        <input style="float: none" type="radio" name="state" value="未支付">未支付
        <br><br>
    </div>
    <div class="button">
        <input style="float: none; margin-left: 40px;" type="submit" value="添加">
        <input style="float: none; margin-right: 40px;" type="reset" name="重置">
    </div>
</form>
<hr>
<a href="javascript:" onclick="window.history.go(-1)"><h3>取消</h3></a>
</body>
</html>
