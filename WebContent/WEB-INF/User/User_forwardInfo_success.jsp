<!-- 个人管理 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人管理</title>
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
<style>
#main{margin-left:9%;margin-right:8%;}
#alert_p{margin-left:0;display:none;}
#title_p{margin-right:90px;}
.mysty{padding-top:10px;}
.tit{font-size:30px;font-weight:bold;}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$("#editbtn").attr('disabled',false);
	$("#savebtn").attr('disabled',true);
	$("input").attr('disabled',true);
	$("#editbtn").click(function(){
		$("input").attr('disabled',false);
		$("#editbtn").attr('disabled',true);
		$("#savebtn").attr('disabled',false);
	});
	$("#savebtn").click(function(){
		var flag = $("#username").val()=='' || $("#realname").val()=='' || $("#pwd").val()=='' || $("#addr").val()=='' 
		|| $("#phone").val()=='' ;
		if(flag){
			$("#alert_p").show();
		}else{
			$("#alert_p").hide();
		}
		return !flag;
	});
});

</script>
</head>
<body>
<nav class="navbar navbar-default navbar-static-top mysty" role="navigation">
  <div class="container">
  	<p class="navbar-text navbar-left tit" id="title_p">机票服务中心 </p>
  	<ul class="nav nav-pills" role="tablist">
	  <li role="presentation" ><a href="index.jsp">首页</a></li>
	  <li role="presentation" ><a href="Flight_queryFlight2">机票查询</a></li>
	  <li role="presentation"><a href="Order_queryOrder">机票管理</a></li>
	  <li role="presentation" class="active"><a href="User_forwardInfo">个人管理</a></li>
	</ul>
  	<span class="navbar-text navbar-right ">您好！
		<s:property value="#session.user.username"/> || <a href="User_logout" class="navbar-link">登出</a>
	</span>
  </div>
</nav>
<hr>
<div id="main">
<div class="alert alert-success" role="alert">个人信息</div>

<form class="form-horizontal" role="form"  method="post" action="User_modInfo">

   <button type="button" class="btn btn-default" id="editbtn">编辑</button>
   <button type="submit" class="btn btn-default" id="savebtn">保存</button>
   
   <div class="alert alert-danger col-sm-4" role="alert" id="alert_p" >请填写完整信息！</div>

  <div class="form-group">
    <label for="uname" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="username"  name="user.username" value=<s:property value="user.username"/>>
    </div>
  </div>
  <div class="form-group">
    <label for="realname" class="col-sm-2 control-label">真实姓名</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="realname"  name="user.realname" value=<s:property value="user.realname"/>>
    </div>
  </div>
  <div class="form-group">
    <label for="pwd" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="pwd"  name="user.password" value=<s:property value="user.password"/>>
    </div>
  </div>
  <div class="form-group">
    <label for="address" class="col-sm-2 control-label">地址</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="addr"  name="user.address" value=<s:property value="user.address"/>>
    </div>
  </div>
  <div class="form-group">
    <label for="phone" class="col-sm-2 control-label">手机号</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="phone"  name="user.phone" value=<s:property value="user.phone"/>>
    </div>
  </div>

    
  
				  
</form>
</div>

</body>
</html>