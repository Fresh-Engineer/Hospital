<%--
  Created by IntelliJ IDEA.
  User: sihongxiao
  Date: 2021/12/28
  Time: 4:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>修改住院患者信息</title>
</head>
<body>
<h2>修改住院患者信息</h2>
<hr>
<form action="UpdateInPatient.do" method="post">
    <input type="text" name="ward_id" value="${inpatient.ward_id}" style="display: none">
    患者姓名：
    <input type="text" name="p_name" value="${inpatient.p_name}"><br><br>
    &nbsp;&nbsp;&nbsp;床位号：
    <input type="text" name="bed_id" value="${inpatient.bed_id}"><br><br>
    费&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用：
    <input type="text" name="cost" value="${inpatient.cost}"><br><br>

    <input type="submit" value="修改">
    <input type="reset" name="重置">
</form>
<h3><a href="javascript:" onclick="history.go(-1)">取消</a></h3>
</body>

</html>