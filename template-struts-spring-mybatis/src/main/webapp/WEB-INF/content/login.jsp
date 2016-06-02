<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
  <head>
    <title>社区养老-登录</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Expires" content="-1">
	<link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/common.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.js"></script>
	<meta name="viewport" content="width=device-width,height=device-height, initial-scale=1, maximum-scale=1, user-scalable=no">
    <script type="text/javascript">
		  $("#username").html("您的信息输入错误，请重试!").show(300).delay(3000).hide(300);
		  if(window !=top){  
		  	 top.location.href=location.href;  
		  } 
	</script>
	<style type="text/css">
	.rowLogin{width:550px;margin:100px auto;float:none;}
	.footerLogin{width:400px;margin:auto;float:none;}
	</style>
  </head>
  <body>
	<div class="container-fluid">
		<div id='header' class='row header'>
		  <div class='col-md-2 col-md-offset-2'>
			<img src="img/logo.png" width="200" height="86"/>
			<!-- <img src="img/logo-1.png" width="200" height="86"/> -->
		  </div>
		</div>
		<div id='content' class='row'>
		  <div class='rowLogin'>
			<div class='row'>
				<div class='loginMain loginW'>
                <div class="loginMain-iconbox">
                <div class="username"></div>
                <div class="passtword"></div>
                </div>
					<form action="<%=request.getContextPath()%>/login.action" method="post" class="form-signin">
						<h2 class="form-signin-heading" style="text-align:center;white-space: nowrap;">
												95002智慧养老服务中心
												<!-- 普陀久龄家园关爱服务中心 -->
						</h2>
						<div class="form-group">
							<label class="sr-only" for="userName">userName:${error}</label>
							<input type="text" autofocus  required id="userName" name="userName" placeholder="账号" class="form-control" />
						</div>
						<div class="form-group">
							<label class="sr-only" for="passwd">passwd:</label>
							<input type="password" required id="passwd" name="password" placeholder="密码" class="form-control"/>
						</div>
						<div class="checkbox">
						  <label style="color: red;">
						   ${error}
						  </label>
						</div>
						<button type="submit" class="btn btn-sm btn-primary btn-block">登录</button>
					</form>
				</div>
				<div class='col-md-10'></div>

			</div>
		  </div>
		  <div class='footerLogin'>
			<div class="fundes">
				<h3></h3>
			</div>
		   </div>
		</div>	
	</div>
  </body>
</html>	