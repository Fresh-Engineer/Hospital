<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<title>药品信息</title>
<link rel="stylesheet" type="text/css" href="css/patientcss.css" />
	<style>

		li {
			list-style-type: none;
		}
		.nav_div {
			border: none;
		}
		.nav_div h3{
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
	<h2 class="container">药品列表</h2>
	<hr>
	<nav class="nav" role="navigation">
		<div class="nav_div" id="select">
			<a href="addmedicine.jsp"><h3>添加药品信息</h3></a>
		</div>
	</nav>

	<table class="t" >
		<thead>
			<tr>
				<th><input type="checkbox" id="checkAll"
					disabled autocomplete="off" /></th>
				<th>药品编号</th>
				<th>药品名称</th>
				<th>类型</th>
				<th>品牌</th>
				<th>价格</th>
				<th>药品规格</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="medicine" varStatus="stc">
			<tr>
				<td><input value="" type="checkbox" /></td>
				<td>${medicine.m_id}</td>
				<td>${medicine.m_name}</td>
				<td>${medicine.m_type}</td>
				<td>${medicine.m_brand}</td>
				<td>${medicine.m_price}</td>
				<td>${medicine.m_specification}</td>
				<td>
					<input type="button" value="修改" onclick="ToUpdateMedicine(${medicine.m_id})">
					<input type="button" value="删除" class="delete" id="delAll" onclick="deleteMedicine(${medicine.m_id});">
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="index.jsp"><h2>返回系统主页</h2></a>
</body>
<script type="text/javascript">
	function ToUpdateMedicine(m_id){
		window.location.href = "MtoUpdate.do?m_id="+m_id;
	}
	function deleteMedicine(m_Id){
		var isDelete = window.confirm("确认删除吗？点击确定,数据将无法恢复！");
		if(isDelete){
			window.location.href = "mdelete.do?m_id="+m_Id;
		}
	}
</script>

</html>