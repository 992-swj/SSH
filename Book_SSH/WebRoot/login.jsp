<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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

<title>用户登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
center {
	border: 1px solid red;
	width: 800px;
	margin: 150px auto;
	padding: 15px;
}
</style>

</head>

<body>
	<center>
        <h1>SSH项目整合（Struts+Spring+Hibernate）</h1>
        <h2>登录页面</h2>
        <span style="color:red">
        <s:property value="message"/>
        </span>
        <form action="login" method="POST">
            <label for="username">用户名:</label>
            <input type="text" name="username"  placeholder="请输入用户名">
            <label for="password">密码:</label>
            <input type="text" name="password"  placeholder="请输入密码">
            <br>
            <hr style="width: 800px;">
            <input type="submit" value="登录">
        </form>
    </center>
</body>
</html>
