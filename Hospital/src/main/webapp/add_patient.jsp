<%--
  Created by IntelliJ IDEA.
  User: sihongxiao
  Date: 2021/12/27
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>title</title>
</head>
<body>
<h2>新增患者</h2>
<hr>
<form action="add.do" method="post">
    患者姓名：
    <input type="text" name="p_name"><br><br>
    患者性别：
    <input type="text" name="sex"><br><br>
    患者年龄：
    <input type="text" name="age"><br><br>
    联系方式：
    <input type="text" name="phone"><br><br>

    <input type="submit" value="增加">
    <input type="reset" name="重置">
</form>
<a href="javascript:" onclick="history.go(-1)"><h3>取消</h3></a>
</body>

</html>
