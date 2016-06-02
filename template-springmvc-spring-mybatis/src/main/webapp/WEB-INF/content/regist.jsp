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
  <form action="user/${uuid}.html" method="post">
	  <table>
		  <tr>
			  <td align="right">username</td>
			  <td align="left"><input id="n" name="user" type="text" maxLength="40"/></td>
		  </tr>
		  <tr>
			  <td align="right">password</td>
			  <td align="left"><input id="p" name="passwd" type="password" maxLength="40"/></td>
		  </tr>
		  <tr>
			  <td align="center" colSpan="2">
				  <input type="hidden" name="_method" value="PUT">
				  <input type="submit" value="commit"/>
			  </td>
		  </tr>
	  </table>
  </form>
  </body>
</html>
