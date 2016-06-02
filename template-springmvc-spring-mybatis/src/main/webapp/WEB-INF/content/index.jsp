<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
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
  		<form action="login.html" method="post">
			<label> username: <input type="text"  placeholder="username" /> </label> <br/>
			<label> password:<input type="text" placeholder="password" /></label><br>
			<input type="submit" value="登陆" onclick=""/>
		</form>
		<form action="regist.html" method="post">
			<input type="submit" value="注册" onclick=""/>
		</form>

		This is my JSP page. <br>

		<!-- RESTful 风格的请求 -->
		<form action="user" method="post">
			<input type="hidden" name="_method" value="PUT">
			<input type="submit" value="put">
		</form>
		<form action="user" method="post">
			<input type="submit" value="post">
		</form>
		<form action="user" method="get">
			<input type="submit" value="get">
		</form>
		<form action="user" method="post">
			<input type="hidden" name="_method" value="DELETE">
			<input type="submit" value="delete">
		</form>
  </body>
</html>
