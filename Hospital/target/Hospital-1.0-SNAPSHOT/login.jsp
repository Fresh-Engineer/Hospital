<%--
  Created by IntelliJ IDEA.
  User: 斯洪霄
  Date: 2021/12/26
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>医疗管理系统</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/common.css">
    <style>
        .background {
            position: absolute;
            margin: 330px auto;
            width: 100%;
            height: 200px;
            z-index: -20;
        }

        .form {
            display: flex;
            flex-direction: column;
            position: relative;
            margin: 0 auto;
            top: 260px;
            width: 600px;
            height: 320px;
            border: 2px solid cornflowerblue;
            background-color: white;
        }

        .title {
            background-color: gainsboro;
            height: 68px;
        }

        .title h3 {
            display: inline-block;
            font-size: 23px;
            line-height: 68px;
            vertical-align: middle;
            margin: 0 auto;
        }

        .title h3:nth-of-type(1) {
            margin-left: 250px;
        }

        .title h3:nth-of-type(2) {
            color: coral;
            margin-left: 160px;
        }

        .title a {
            display: inline-block;
        }

        .title img {
            margin-right: 10px;
            width: 30px;
            height: 30px;
            line-height: 68px;
            vertical-align: middle;
        }

        .content {
            padding: 20px;
            height: 140px;
            display: flex;
            flex-direction: column;
            justify-content: space-around;
        }

        .content div {
            margin: 0 auto;
            width: 460px;
            height: 50px;
            border: 2px solid darkgray;
            border-radius: 5px;
        }

        .content input {
            position: relative;
            top: -12px;
            left: 3px;
            height: 45px;
            width: 390px;
            border: none;
            outline: none;
            font-size: 20px;
        }

        .content img {
            position: relative;
            width: 42px;
            height: 42px;
            top: 5px;
            left: 5px;
        }

        .content i {
            height: 40px;
            display: inline-block;
            position: relative;
            top: 5px;
            left: 2px;
            border: 1px solid darkgray;
        }

        .bottom {
            margin: 0 auto;
            width: 400px;
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            height: 53px;
        }

        .bottom input {
            width: 160px;
            height: 50px;
            background: cornflowerblue;
            border: none;
            border-radius: 5px;
            font-size: 20px;
        }
    </style>
</head>
<body>
<div class="background"></div>
<form class="form" action="Login.do" method="post">
    <div class="title">
        <h3>后台登录</h3>
        <h3>注册</h3>
<%--转到注册页面--%>
        <a href="register.jsp">
            <img src="img/right.png" alt="注册">
        </a>
    </div>
    <div class="content">
        <div>
<%--输入用户名--%>
            <img src="img/user.png" alt="用户名">
            <i></i>
            <input type="text" maxlength="32" name="username">
        </div>
        <div>
<%--输入密码--%>
            <img src="img/password.png" alt="密码">
            <i></i>
            <input type="password" maxlength="32" name="password">
        </div>
    </div>
    <div class="bottom">
        <input type="submit" value="登录" id="button1" onmousedown="changeColor1()" onmouseup="exchangeColor1()">
        <input type="reset" value="重置" id="button2" onmousedown="changeColor2()" onmouseup="exchangeColor2()">
    </div>
</form>
</body>
<script src="js/jquery-3.5.1.js"></script>
<script>
    function changeColor1() {
        $('#button1').css('background', 'blue');
    }

    function exchangeColor1() {
        $('#button1').css('background', 'cornflowerblue');
    }

    function changeColor2() {
        $('#button2').css('background', 'blue');
    }

    function exchangeColor2() {
        $('#button2').css('background', 'cornflowerblue');
    }
</script>
</html>
