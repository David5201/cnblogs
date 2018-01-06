<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>

<body>
	<form action="servlet/LoginServlet" method="post">
		<p align="center">
			用 户 名: <input type="text" name="familyName">
		</p>
		<br>
		<font color="red">${requestScope.errors}</font>
		<p align="center">
			密 码: <input type="password" name="sex">
		</p>
		<br>
		<p align="center">
			<input type="submit" value="登陆">
		</p>
		<br>
	</form>
	<font color="red">${requestScope.user}</font>
</body>
</html>