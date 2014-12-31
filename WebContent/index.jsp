<!-- 主界面 -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>机票服务中心</title>
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="js/jquery-1.10.2.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<style>
#main{margin:20px 30% 10px 10%;}
#title_p{margin-right:90px;}
#alert_p{margin-left:18%;display:none;}
.mysty{padding-top:10px;}
.tit{font-size:30px;font-weight:bold;}
</style>
<script type="text/javascript">
$(document).ready(function(){
	  $("#subbtn").click(function(){
			var flag = $("#departplace").val()=='' || $("#arrivalplace").val()=='' || $("#departtime").val()=='';
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
	  <li role="presentation" class="active"><a href="index.jsp">首页</a></li>
	   <li role="presentation"><a href="Flight_queryFlight2">机票查询</a></li>
	  <li role="presentation"><a href="Order_queryOrder">机票管理</a></li>
	  <li role="presentation"><a href="User_forwardInfo">个人管理</a></li>
	</ul>
	<span class="navbar-text navbar-right ">您好！
		<s:if test="#session.user==null">请 <a href="User_forwardLogin" class="navbar-link">登陆</a> | <a href="User_forwardRegister" class="navbar-link">注册</a>
		</s:if>
	<s:else>
		<s:property value="#session.user.username"/> || <a href="User_logout" class="navbar-link">登出</a>
	</s:else>
	</span>
  	
  </div>
</nav>
<hr>
<div id="main">
	<div class="panel panel-primary">
		<div class="panel-heading">机票查询</div>
		<div class="panel-body">
			<form class="form-horizontal" role="form"  method="post" action="Flight_queryFlight" >
				<div class="form-group">
				    <label for="departinput" class="col-sm-2 control-label">出发地</label>
				    <div class="col-sm-4">
				      <input type="text" class="form-control" id="departplace" placeholder="中文" name="flight.depart_city">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="arrivalinput" class="col-sm-2 control-label">目的地</label>
				    <div class="col-sm-4">
				      <input type="text" class="form-control" id="arrivalplace" placeholder="中文" name="flight.arrival_city">
				    </div>
				  </div>
				  <%-- <div class="form_date date form-group">
				    <label for="departtimeinput" class="col-sm-2 control-label">出发时间</label>
				    <div class="col-sm-4">
				      <input type="text" class="form-control span2" id="departtime"  name="flight.depart_time">
				      <span class="add-on"><i class="icon-th"></i></span>
				    </div>
				  </div> --%>
				  <div class="form-group">
	                <label for="departtimeinput" class="col-sm-2 control-label">出发时间</label>
	                <div class="input-group date form_datetime col-sm-4"  data-date-format="yyyy-mm-dd" data-date="">
	                    <input class="form-control" style="margin-left:15px;" type="text" id="departtime" name="flight.depart_time" readonly>
						<span class="input-group-addon" ><span class="glyphicon glyphicon-time" style="margin-left:15px;"></span></span>
	                </div>
            	</div>
            	
            	
            	
				  <div class="col-sm-offset-2 col-sm-4">	  
					<button type="submit" class="btn btn-warning" id="subbtn">查询</button>
				  </div>
				  <br><br>
				  <div class="alert alert-danger col-sm-4" role="alert" id="alert_p" >请填写完整信息！</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
$('.form_datetime').datetimepicker({
	 weekStart: 1,
     todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
});
</script>
</body>
</html>