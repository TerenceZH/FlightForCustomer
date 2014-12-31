<!-- 登陆界面 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
<style>
#main{margin:20px 30% 10px 10%;}
#title_p{margin-right:90px;}
#alert_p{margin-left:17%;display:none;}
.mysty{padding-top:10px;}
.tit{font-size:30px;font-weight:bold;}
</style>
<script>
$(document).ready(function(){
	  $("#loginbtn").click(function(){
			var flag = $("#username").val()=='' || $("#pwd").val()=='' || $("#validatecode").val()=='';
			if(flag){
				$("#alert_p").show();
			}else{
				$("#alert_p").hide();
			}
			return !flag;
	  });
	  $("#registerbtn").click(function(){
		  location.href = "User_forwardRegister";
	  });
	});
</script>
</head>
<body>
<nav class="navbar navbar-default navbar-static-top mysty" role="navigation">
  <div class="container">
  	<p class="navbar-text navbar-left tit" id="title_p">机票服务中心 </p>
  	<ul class="nav nav-pills" role="tablist">
	  <li role="presentation" class = "active"><a href="index.jsp">首页</a></li>
	   <li role="presentation"><a href="Flight_queryFlight2">机票查询</a></li>
	  <li role="presentation"><a href="#">机票管理</a></li>
	  <li role="presentation"><a href="#">个人管理</a></li>
	</ul>
  	<span class="navbar-text navbar-right ">您好！请 <a href="User_forwardLogin" class="navbar-link">登陆</a> | <a href="User_forwardRegister" class="navbar-link">注册</a></span>
  </div>
</nav>
<hr>
<div id="main">
<div class="alert alert-success" role="alert">您现在的位置：首页>>登陆</div>

<form class="form-horizontal" role="form"  method="post" action="User_login">
  <div class="form-group">
    <label for="uname" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="username" placeholder="用户名" name="user.username">
    </div>
  </div>
  <div class="form-group">
    <label for="pwd" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-4">
      <input type="password" class="form-control" id="pwd" placeholder="密码" name="user.password">
    </div>
  </div>
  <div class="form-group">
    <label for="validateCode" class="col-sm-2 control-label">验证码</label>
    <div class="col-sm-4">
      <input type="password" class="form-control" id="validatecode" placeholder="验证码" name="validatecode">
    </div>
    <div><img src="authImg" onclick="changeValidateCode(this)"></div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-8">
      <button type="submit" class="btn btn-warning" id="loginbtn">登陆</button>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-8">
      <button type="button" class="btn btn-default" id="registerbtn">快速注册</button>
    </div>
  </div>
    <div class="alert alert-danger col-sm-4" role="alert" id="alert_p" >请填写完整信息！</div>
  
				  
</form>
</div>
<br><br>
<hr><hr>
<script type="text/javascript">
  function changeValidateCode(obj){
    var now = new Date().getTime();
    obj.src = "authImg?d=" + now;
  }
</script>
</body>
</html>