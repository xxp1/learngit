<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html> 
<head><title>请稍等...</title> 
<script language='javascript' type='text/javascript'> 
var secs =0; //倒计时的秒数 
var URL ; 
function Load(url){ 
URL =url; 
for(var i=secs;i>=0;i--) 
{ 
window.setTimeout('doUpdate(' + i + ')', (secs-i) * 1000); 
} 
} 
function doUpdate(num) 
{ 
document.getElementById('ShowDiv').innerHTML = '将在'+num+'秒后自动跳转到通讯录' ; 
if(num == 0) { window.location=URL; } 
} 
</script> 
</head> 
<body> 
<div id="ShowDiv"></div> 
<script language="javascript"> 
Load("${pageContext.request.contextPath}/main.jsp"); 
</script> 
</body> 
</html>

