<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户登录</title>
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
<style>
#main{margin:10% 30% auto 30%;}
#acc{margin-top:30px;padding-top:20px;}
#loginbtn{maigin-left:20px;}
#iii{margin-top:20px;}
#alert_p{display:none; margin-top:10px;}
</style>
</head>
<body>
<div id="main">
<div class="panel panel-info">
 <div class="panel-heading">请输入账号密码以完成支付！</div>
<form class="form-horizontal" role="form"  method="post" action="Account_login?orderno=<s:property value='orderno'/>" id="acc">

  <div class="form-group iii">
    <label for="uname" class="col-sm-2 control-label">帐户名</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="username"  name="account.account">
    </div>
  </div>
  <div class="form-group">
    <label for="pwd" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-4">
      <input type="password" class="form-control" id="pwd"  name="account.password">
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-8">
      <button type="submit" class="btn btn-warning" id="loginbtn">确定</button>
    </div>
  </div>
    <div class="alert alert-danger col-sm-4" role="alert" id="alert_p" >请填写完整信息！</div>
  
				  
</form>
</div>
</div>

</body>
</html>