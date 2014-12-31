<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>机票管理</title>
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
<style>
#main{margin:20px 30% 10px 10%;}
#title_p{margin-right:90px;}
#alert_p{margin-left:10px;;display:none;text-size:10px;}
.mysty{padding-top:10px;}
.tit{font-size:30px;font-weight:bold;}
.canbtn{margin:5px auto 5px 10px}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$("#delbtn").click(function(){
		var ischecked = false;
		for(item in $(".ch")){
			if(item.prop("checked")){
				ischecked = true;break;
			}
		}
		if(!ischecked){
			$("#alert_p").show();
		}else{
			$("#alert_p").hide();
		}
		return ischecked;
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
	   <li role="presentation"><a href="Flight_queryFlight2">机票查询</a></li>
	  <li role="presentation" class="active"><a href="Order_queryOrder">机票管理</a></li>
	  <li role="presentation"><a href="User_forwardInfo">个人管理</a></li>
	</ul>
	<span class="navbar-text navbar-right ">您好！
		<s:property value="#session.user.username"/> || <a href="User_logout" class="navbar-link">登出</a>
	</span>
  	
  </div>
</nav>
<hr>

<div id="main">
<div class="panel panel-default">
  <div class="panel-heading">
  	您的订票
  </div>
  <form action="Order_delOrders" method="post" >
  <button type="submit" class="btn btn-warning canbtn" id="delbtn">取消订单</button>
  <br>
   <div class="alert alert-danger col-sm-4" role="alert" id="alert_p" >请选择至少一个订单！</div>
  <table class="table table-hover table-striped table-condensed">
    <tr>
    	<th>选择</th>
    	<th>航班号</th>
    	<th>出发地点</th>
    	<th>到达地点</th>
    	<th>出发时间</th>
    	<th>到达时间</th>
    	<th>座位号</th>
    	<th>备注</th>
    </tr>
    <s:iterator value="list">
		<tr>
			<td><s:if test="issent==0" ><input type="checkbox" name="id" class="ch" value =<s:property value="id"/>  ></s:if>
			<s:else><input type="checkbox" name="id" class="ch" value =<s:property value="id"/>  disabled></s:else></td>
			<td><s:property value="flight.flightno"/></td>
			<td><s:property value="flight.depart_city"/></td>
			<td><s:property value="flight.arrival_city"/></td>
			<td><s:property value="flight.depart_time"/></td>
			<td><s:property value="flight.arrival_time"/></td>
			<td><s:property value="seatno"/></td>
			<td><s:if test="issent==0" ><a href="Account_forwardLogin?orderno=<s:property value='id' />">去付款</a></s:if>
			<s:else>已支付</s:else>
			</td>
		</tr>
	</s:iterator>
  </table>
  </form>
</div>
</div>
<hr>

</body>
</html>