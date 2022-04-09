<%--
  Created by IntelliJ IDEA.
  User: sihongxiao
  Date: 2021/12/27
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>编辑挂号信息</h2>
<hr>

<form action="UpdateRegist.do" method="post">
    原日期：&nbsp;&nbsp;${regist.datetime}<br>
    日期：<br>
    <input type="date" name="datetime"><br>
    姓名：<br>
    <input type="text" name="userName" value="${regist.userName}"><br>
    原性别：&nbsp;&nbsp;${regist.sex}<br>
    性别：<input type="radio" name="sex" value="男">男
    <input type="radio" name="sex" value="女">女<br>
    身份证号：<br>
    <input type="text" name="IDcard" readonly="readonly" value="${regist.IDcard}"><br>
    手机号：<br>
    <input type="text" name="phone" value="${regist.phone}"><br>
    <input type="submit" value="确认修改" >
    <input type="reset" name="重置">
</form>
</body>
</html>
