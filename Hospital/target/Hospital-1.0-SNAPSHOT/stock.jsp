<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <title>药品库存信息</title>
    <link rel="stylesheet" type="text/css" href="css/patientcss.css"/>
    <style>

        li {
            list-style-type: none;
        }

        .nav_div {
            border: none;
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
<h2 class="container">药品库存</h2>
<hr>
<nav class="nav" role="navigation">
    <div class="nav_div" id="select">
        <a href="add_stock.jsp"><h3>添加库存信息</h3></a>
    </div>
</nav>

<table class="t">
    <thead>
    <tr>
        <th><input type="checkbox" id="checkAll"
                   disabled autocomplete="off"/></th>
        <th>库存编号</th>
        <th>药品名称</th>
        <th>生产日期</th>
        <th>保质期</th>
        <th>库存量</th>
        <th>存放位置</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="stock" varStatus="stc">
    <tr>
        <td><input value="" type="checkbox"/></td>
        <td>${stock.m_sid} </td>
        <td>${stock.m_name} </td>
        <td>${stock.m_pdate}</td>
        <td>${stock.m_edate}</td>
        <td>${stock.m_snumber}</td>
        <td>${stock.m_place}</td>
        <td>
            <input type="button" value="编辑" onclick="toUpdates(${stock.m_sid})">
            <input type="button" value="删除" class="delete" id="delAll" onclick="deleteStock(${stock.m_sid});">
        </td>
    </tr>
    </c:forEach>
</table>
<a href="index.jsp"><h2>返回系统主页</h2></a>
</body>
<script type="text/javascript">
    function deleteStock(m_sid) {
        var isDelete = window.confirm("确认删除吗？点击确定,数据将无法恢复！");
        if (isDelete) {
            window.location.href = "msdelete.do?m_sid=" + m_sid;
        }
    }

    function toUpdates(m_sid) {
        window.location.href = "ToUpdateStock.do?m_sid=" + m_sid;
    }
</script>
</html>