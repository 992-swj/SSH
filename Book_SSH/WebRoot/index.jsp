<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function doPage(num) {
		frm.pageIndex.value = num;
		frm.submit();
	}
</script>
<style type="text/css">
	a{
		text-decoration: none;
	}
</style>
</head>

<body>
	<center>
		<h1>SSH项目整合（Struts+Spring+Hibernate）</h1>
		<h2>分页,欢迎你：<s:property value="#session.userinfo.username"/></h2>
		<form action="limit" method="post" name="frm">
			<input type="hidden" name="pageIndex" value="1"> 请输入书名:<input
				type="text" value="<s:property value="map.title"/>" name="title"> <input type="button" value="查询"
				onclick="doPage(1)">
			<a href="add.jsp">添加</a>
		</form>

		<table border="1" width="800">
			<thead>
				<tr>
					<th>编号</th>
					<th>书名</th>
					<th>作者</th>
					<th>价格</th>
					<th>时间</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="list" var="a">
					<tr>
						<td><s:property value="#a.bookid" /></td>
						<td><s:property value="#a.title" /></td>
						<td><s:property value="#a.author" /></td>
						<td><s:property value="#a.price" /></td>
						<td>
							<s:date name="#a.pubdate" var="mydate" format="yyyy-MM-dd"/>
							<s:property value="mydate"/>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>

		<div>
			<p>
				<s:property value="map.pageIndex" />
				/
				<s:property value="map.SumIndex" />
			</p>
			<p>
				<a href="javascript:doPage(1)">首页</a> <a
					href="javascript:doPage(<s:property value="map.prev"/>)">上页</a> <a
					href="javascript:doPage(<s:property value="map.next"/>)">下页</a> <a
					href="javascript:doPage(<s:property value="map.SumIndex"/>)">尾页</a>
			</p>
		</div>
	</center>

</body>
</html>
