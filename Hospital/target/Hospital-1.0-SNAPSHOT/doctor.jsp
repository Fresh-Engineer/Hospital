<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/patientcss.css"/>
    <title>Insert title here</title>
    <style>
        li {
            list-style-type: none;
        }

        .nav_div h3 {
            line-height: 50px;
            vertical-align: middle;
        }

        a {
            text-decoration: none;
            text-align: center;
        }

        a h3 {
            margin: 0 auto;
        }
    </style>
</head>

<body>
<h2 class="container">医生列表</h2>
<hr>
<nav class="nav" role="navigation">
    <div class="nav_div" id="select">
        <a href="adddoctor.html"><h3>添加医生信息</h3></a>
    </div>
</nav>
<table class="t">
    <thead>
    <tr>
        <th><input type="checkbox" id="checkAll"
                   disabled autocomplete="off"/></th>
        <th>医生编号</th>
        <th>医生职称</th>
        <th>医生姓名</th>
        <th>医生卡</th>
        <th>操作</th>
    </tr>
    </thead>


    <tbody>
    <c:forEach items="${list}" var="doctor" varStatus="stc">
    <tr>
        <td><input value="" type="checkbox"/></td>
        <td>${doctor.cnoo}</td>
        <td>${doctor.cname}</td>
        <td>${doctor.cteacher}</td>
        <td>${doctor.ccredit}</td>
        <td>
<%--            <input type="button" value="新增" class="update" id="upAll" onclick="window.location.href='adddoctor.html'">--%>
            <input type="button" value="删除" class="delete" id="delAll" onclick="deleteDoctor(${doctor.cnoo});">
        </td>
    </tr>
    </c:forEach>
</table>
<a href="index.jsp"><h2>返回系统主页</h2></a>
</body>
<script type="text/javascript">
    function deleteDoctor(cnoo) {
        var isDelete = window.confirm("确认删除吗？点击确定,数据将无法恢复！");
        if (isDelete) {
            window.location.href = "ddelete.do?cnoo=" + cnoo;
        }
    }
</script>

</html>