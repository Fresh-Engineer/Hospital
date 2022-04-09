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
<h2 class="container">科室列表</h2>
<hr>
<table class="t">
    <thead>
    <tr>
        <th><input type="checkbox" id="checkAll"
                   disabled autocomplete="off"/></th>
        <th>科室编号</th>
        <th>科室名称</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="department" varStatus="stc">
    <tr>
        <td><input value="" type="checkbox"/></td>
        <td>${department.kno}</td>
        <td>${department.kname}</td>
        <td>
            <input type="button" value="新增" class="update" id="upAll" onclick="toUpdate(${ipd.ward_id});">
            <input type="button" value="删除" class="delete" id="delAll" onclick="deleteDepartment(${department.kno});">
        </td>
    </tr>
    </c:forEach>
</table>
<a href="index.jsp"><h2>返回系统主页</h2></a>
</body>
<script type="text/javascript">
    function deleteDepartment(kno) {
        var isDelete = window.confirm("确认删除吗？点击确定,数据将无法恢复！");
        if (isDelete) {
            window.location.href = "kdelete.do?kno=" + kno;
        }
    }
</script>

</html>