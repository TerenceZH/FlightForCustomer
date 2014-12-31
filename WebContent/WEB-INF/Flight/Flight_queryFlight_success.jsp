<!-- 机票查询界面 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>机票查询</title>
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<style>
#main{margin-left:9%;margin-right:8%;}
#alert_p{margin-left:0;display:none;}
#title_p{margin-right:90px;}
.mysty{padding-top:10px;}
.tit{font-size:30px;font-weight:bold;}
.blue{color:blue;}
.gray{color:gray;}
</style>
<script type="text/javascript">
$(document).ready(function(){
	  $("#subbtn").click(function(){
			var flag = $("#depart_place").val()=='' || $("#arrive_place").val()=='' || $("#depart_time").val()=='';
			if(flag){
				$("#alert_p").show();
			}else{
				$("#alert_p").hide();
			}
			return !flag;
	  });
	  $(".clicki").click(function(){
		  var id = $(this).children("td:first").text();
		  var nu =  $(this).children("td:eq(4)").text();
		  if(nu=='0'){
			  alert("机票已售罄！");
		  }else{
			  if(confirm('确定购买？')){
				  window.location.href = "Order_addOrder?flightno="+id;
			  }
		  }
/* 		  var depart_city = $(this).children("td:eq(1)").text(); */
		  
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
	  <li role="presentation" class="active"><a href="Flight_queryFlight2">机票查询</a></li>
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
<div class="panel panel-default">
  <div class="panel-heading">
  	<form class="form-inline" role="form" method="post" action="Flight_queryFlight" >
  		<div class="form-group">
		    <label  for="departplace">出发地</label>
		    <input type="text" class="form-control" id="depart_place" placeholder="中文" name="flight.depart_city" value=<s:property value="flight.depart_city"/>>
		</div>
		<div class="form-group">
		    <label  for="arrivalplace">目的地</label>
		    <input type="text" class="form-control" id="arrive_place" placeholder="中文" name="flight.arrival_city" value=<s:property value="flight.arrival_city"/>>
		</div>
		<!-- <div class="form-group">
		    <label  for="departtime">出发日期</label>
		    <input type="text" class="form-control" id="depart_time" name="flight.depart_time" value=<s:property value="flight.depart_time"/>>
		</div> -->
		
		<div class="form-group">
	                <label for="departtime">出发时间</label>
	                <div class="input-group date form_datetime"  data-date-format="yyyy-mm-dd" data-date="" >
	                    <input class="form-control" type="text" id="depart_time" name="flight.depart_time"  value="<s:property value="flight.depart_time"/>" readonly>
						<span class="input-group-addon" ><span class="glyphicon glyphicon-time" ></span></span>
	                </div>
            	</div>
		
		<div class="form-group">
			<button type="submit" class="btn btn-warning" id="subbtn">查询</button>
			<span class="alert alert-danger" role="alert" id="alert_p" >信息不完整！</span>
		</div>
  	</form>
  </div>
  <table class="table table-hover table-striped table-condensed">
    <tr>
    	<th>航班号</th>
    	<th>出发时间</th>
    	<th>到达时间</th>
    	<th>总座位</th>
    	<th>剩余座位</th>
    	<th>票价</th>
    </tr>
    <s:iterator value="list">
		<tr class="clicki">
			<td><s:property value="flightno"/></td>
			<td><s:property value="depart_time"/></td>
			<td><s:property value="arrival_time"/></td>
			<td><s:property value="seat"/></td>
			<td><s:property value="tickets_left"/></td>
			<td><s:property value="price"/></td>
		</tr>
	</s:iterator>
  </table>
</div>
</div>
<hr>
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