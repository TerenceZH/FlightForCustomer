<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>ErrorOccurred</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>

<script type="text/javascript">
$(function(){

	function returnCorrect() {
		//alert(document.getElementById("errorInfo").value);
		setTimeout(goBack,1500);
	}
	
	function goBack() {
		window.history.back();
	}
	window.onload = returnCorrect;
	
});
	
</script>
</head>
<body>
<s:property value="message"/>
<input type="hidden" value="<s:property value='message'/>" id="errorInfo"/>
<script type="text/javascript">
</script>
</body>
</html>