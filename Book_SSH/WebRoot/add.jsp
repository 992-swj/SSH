<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加数据</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	    <style>
        center{
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
        <h2>添加页面</h2>
        <form action="add" method="post">
            <table>
                <tr>
                    <td><label for="TITLE">书名</label></td>
                    <td><input type="text" name="bookinfo.title" id="TITLE"></td>
                </tr>
                <tr>
                    <td><label for="AUTHOR">作者</label></td>
                    <td><input type="text" name="bookinfo.author" id="AUTHOR"></td>
                </tr>
                <tr>
                    <td><label for="PRICE">价钱</label></td>
                    <td><input type="text" name="bookinfo.price" id="PRICE"></td>
                </tr>
                <tr>
                    <td><label for="PUBDATE">时间</label></td>
                    <td><input type="date" name="bookinfo.pubdate" id="PUBDATE"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="添加">
                        <input type="reset" value="重置"></td>
                </tr>
            </table>

        </form>
    </center>
  </body>
</html>
