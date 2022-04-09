<%--
  Created by IntelliJ IDEA.
  User: 斯洪霄
  Date: 2021/12/26
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/patientcss.css">
    <title>医疗管理系统</title>
    <style>
        li {
            list-style-type: none;
        }

        .nav_div {
            border: none;
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
<h2 class="container">患者列表</h2>
<hr>
<div class="nav" role="navigation">
    <div class="nav_div" id="select">
        <ul>
            <li>
                <form class="nav_form" role="search">
                    <div style="margin: 0 auto">
                        <a href="add_patient.jsp"><h3>添加患者信息</h3></a>
                    </div>
                </form>
            </li>
        </ul>
    </div>
</div>

<table class="t">
    <thead>
    <tr>
        <th><input type="checkbox" id="checkAll"
                   disabled autocomplete="off"/></th>
        <th>患者编号</th>
        <th>患者姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>联系方式</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${patientList}" var="pat" varStatus="stc">
    <tr>
        <td><input value="" check='box' type="checkbox"/></td>
        <td>${pat.p_id}</td>
        <td>${pat.p_name}</td>
        <td>${pat.sex}</td>
        <td>${pat.age}</td>
        <td>${pat.phone}</td>
        <td>${pat.created}</td>
        <td>
            <!--  <button type="button" class="c">删除</button>-->
            <input type="button" value="修改" class="update" id="upAll" onclick="toUpdate(${pat.p_id});">
            <input type="button" value="删除" class="delete" id="delAll" onclick="deletePatient(${pat.p_id});">

        </td>
    </tr>
    </c:forEach>
</table>
<a href="index.jsp"><h2>返回系统主页</h2></a>
</body>
<script type="text/javascript">
    function deletePatient(PatientId) {
        var isDelete = window.confirm("确认删除吗？点击确定,数据将无法恢复！");
        if (isDelete) {
            window.location.href = "DeletePatient.do?p_id=" + PatientId;
        }
    }

    function toUpdate(PatientId) {
        window.location.href = "FindByPatientId.do?p_id=" + PatientId;
    }

</script>

</html>