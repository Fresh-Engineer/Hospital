<%--
  Created by IntelliJ IDEA.
  User: sihongxiao
  Date: 2021/12/27
  Time: 6:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>title</title>
</head>
<body>
<h2>新增住院患者</h2>
<hr>
<form action="AddInPatient.do" method="post">
    患者姓名：
    <input type="text" name="p_name"><br><br>
    &nbsp;&nbsp;&nbsp;床位号：
    <input type="text" name="bed_id"><br><br>
    费&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用：
    <input type="text" name="cost"><br><br>

    <input type="submit" value="增加">
    <input type="reset" name="重置">
</form>
<h3><a href="javascript:" onclick="history.go(-1)">取消</a></h3>
</body>

</html>