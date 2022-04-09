<%--
  Created by IntelliJ IDEA.
  User: 买热孜亚
  Date: 2021/12/26
  Time: 20:08
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
            margin: 0 auto;
        }

        a {
            text-decoration: none;
            text-align: center;
        }

        a h3 {
            margin: 0 auto;
            line-height: 50px;
            vertical-align: middle;
        }
    </style>
</head>
<body>
<h2 class="container">住院信息列表</h2>
<hr>
<nav class="nav" role="navigation">
    <div class="nav_div" id="select">
        <div style="margin: 0 auto">
            <a href="add_inpatient.jsp"><h3>添加住院患者信息</h3></a>
        </div>
    </div>
</nav>

<table class="t">
    <thead>
    <tr>
        <th><input type="checkbox" id="checkAll"
                   disabled autocomplete="off"/></th>
        <th>病房号</th>
        <th>患者姓名</th>
        <th>床位号</th>
        <th>费用</th>
        <th>住院时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${inpatientList}" var="ipd" varStatus="stc">
    <tr>
        <td><input value="" check='box' type="checkbox"/></td>

        <td>${ipd.ward_id}</td>
        <td>${ipd.p_name}</td>
        <td>${ipd.bed_id}</td>
        <td>${ipd.cost}</td>
        <td>${ipd.indated}</td>
        <td>
            <!--  <button type="button" class="c">删除</button>-->
            <input type="button" value="修改" class="update" id="upAll" onclick="toUpdateInPatient(${ipd.ward_id});">
            <input type="button" value="删除" class="delete" id="delAll" onclick="deleteInPatient(${ipd.ward_id});">
        </td>
    </tr>
    </c:forEach>
</table>
<a href="index.jsp"><h2>返回系统主页</h2></a>
</body>
<script type="text/javascript">
    function deleteInPatient(InPatientId) {
        var isDelete = window.confirm("确认删除吗？点击确定,数据将无法恢复！");
        if (isDelete) {
            window.location.href = "DeleteInPatient.do?ward_id=" + InPatientId;
        }
    }

    function toUpdateInPatient(PatientId) {
        window.location.href = "FindByInPatientId.do?ward_id=" + PatientId;
    }

</script>

</html>