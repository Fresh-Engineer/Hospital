<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/patientcss.css" />
	<title>Insert title here</title>
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
	<h2 class="container">费用</h2>
	<hr>
	<nav class="nav" role="navigation">
		<div class="nav_div" id="select">
			<a href="add_cost.jsp"><h3>添加费用信息</h3></a>
		</div>
	</nav>

	<table class="t">
		<thead>
			<tr>
				<th><input type="checkbox" id="checkAll"
					disabled autocomplete="off" /></th>
				
				<th>编号</th>
				<th>患者姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>联系方式</th>
				<th>费用</th>
				<th>状态</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="cost" varStatus="stc">
			<tr>
				<td><input value="" check='box' type="checkbox" /></td>
				<td>${cost.cost_id}</td>
				<td>${cost.p_name}</td>
				<td>${cost.sex}</td>
				<td>${cost.age}</td>
				<td>${cost.phone}</td>
				<td>${cost.cost}</td>
				<td>${cost.state}</td>
				<td>${cost.created}</td>
				<td>
					<input type="button" value="修改" onclick="ToUpdateCost(${cost.cost_id})">
					<input type="button" value="删除" class="delete" onclick="deletePatient(${cost.cost_id});">
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="index.jsp"><h2>返回系统主页</h2></a>
</body>
<script type="text/javascript">
	function ToUpdateCost(CostId1){
		window.location.href = "ToUpdateCost.do?cost_id="+CostId1;
	}
	function deletePatient(CostId){
		var isDelete = window.confirm("确认删除吗？点击确定,数据将无法恢复！");
		if(isDelete){
			window.location.href = "costDelete.do?cost_id="+CostId;		
		}	
	}
</script>
</html>