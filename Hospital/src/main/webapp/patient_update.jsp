<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改患者信息</title>
</head>
<body>
<h2>修改信息</h2>
<hr>
<form action="UpdatePatient.do" method="post">
    <input type="hidden" name="p_id" value="${pat.p_id}"><br><br>
    患者姓名：
    <input type="text" name="p_name" value="${pat.p_name}"><br><br>
    患者性别：
    <input type="text" name="sex" value="${pat.sex}"><br><br>
    患者年龄：
    <input type="text" name="age" value="${pat.age}"><br><br>
    联系方式：
    <input type="text" name="phone" value="${pat.phone}"><br><br>

    <input type="submit" value="确认修改">
    <input type="reset" name="重置">
</form>
<h3><a href="javascript:" onclick="history.go(-1)">取消</a></h3>
</body>
</html>