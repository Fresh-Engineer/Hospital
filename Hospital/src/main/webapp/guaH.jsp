<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="utf-8">
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
<title>Insert title here</title>
</head>
<body>
	<h2 class="container">挂号记录</h2>
	<hr>
	<nav class="nav" role="navigation">
		<div class="nav_div" id="select">
			<a href="regist.html"><h3>添加挂号记录</h3></a>
		</div>
	</nav>

	<table class="t">
		<thead>
			<tr>
				<th><input type="checkbox" id="checkAll"
					disabled autocomplete="off" /></th>
				
				<th>日期</th>
				<th>姓名</th>
				<th>性别</th>
				<th>身份号</th>
				<th>联系方式</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="regist" varStatus="stc">
			<tr>
				<td><input value="" check='box' type="checkbox" /></td>
				<td>${regist.datetime}</td>
				<td>${regist.userName}</td>
				<td>${regist.sex}</td>
				<td>${regist.IDcard}</td>
				<td>${regist.phone}</td>
				<td>
					<input type="button" value="修改" class="update" onclick="ToUpdate('${regist.IDcard}');">
					<input type="button" value="删除" class="delete" onclick="deletePatient('${regist.IDcard}');">
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="index.jsp"><h2>返回系统主页</h2></a>
</body>
<script type="text/javascript">
	function ToUpdate(IDcard1){
		window.location.href = "ToRegistUpdate.do?IDcard="+IDcard1;
	}
	function deletePatient(IDcard){
		var isDelete = window.confirm("确认删除吗？点击确定,数据将无法恢复！");
		if(isDelete){
			window.location.href = "registDelete.do?IDcard="+IDcard;		
		}	
	}
</script>
</html>