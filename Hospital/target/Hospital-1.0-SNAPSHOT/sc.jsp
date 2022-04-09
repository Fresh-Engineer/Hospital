<%@ page contentType="text/html; charset=utf-8" %>
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
<h2 class="container">手术列表</h2>
<hr>
<nav class="nav" role="navigation">
    <div class="nav_div" id="select">
        <a href="addsc.html"><h3>添加手术信息</h3></a>
    </div>
</nav>
<table class="t">
    <thead>
    <tr>
        <th><input type="checkbox" id="checkAll"
                   disabled autocomplete="off"/></th>
        <th>手术代码</th>
        <th>手术编号</th>
        <th>手术时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="sc" varStatus="stc">
    <tr>
        <td><input value="" type="checkbox"/></td>
        <td>${sc.sno}</td>
        <td>${sc.ssno}</td>
        <td>${sc.srade}</td>
        <td>
<%--            <input type="button" value="新增" class="update" id="upAll" onclick="toUpdate(${ipd.ward_id});">--%>
            <input type="button" value="删除" class="delete" id="delAll" onclick="deleteSc(${sc.sno});">
        </td>
    </tr>
    </c:forEach>
</table>
<a href="index.jsp"><h2>返回系统主页</h2></a>
</body>
<script type="text/javascript">
    function deleteSc(sno) {
        var isDelete = window.confirm("确认删除吗？点击确定,数据将无法恢复！");
        if (isDelete) {
            window.location.href = "sdelete.do?sno=" + sno;
        }
    }
</script>

</html>