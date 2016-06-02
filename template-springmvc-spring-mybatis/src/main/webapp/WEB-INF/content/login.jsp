<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
  <head>
    <title>My JSP 'Login.jsp' starting page</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Expires" content="-1">
	<link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/common.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.js"></script>
	<meta name="viewport" content="width=device-width,height=device-height, initial-scale=1, maximum-scale=1, user-scalable=no">
    <script type="text/javascript">
	</script>
	<style type="text/css">
	</style>
  </head>
  <body>
  <form action="login.html" method="post">
	  <label>用户名：</label><input type="text" name="userName"/><br/>
	  <label>密码：</label><input type="password" name="password"/><br/>
	  <input type="submit" value="login"/>
	  <input type="reset" value="reset"/>
  </form>

  <form action="regist.html" method="post">
	  <input type="submit" value="注册" onclick=""/>
  </form>

  ${error}
  </body>
</html>	