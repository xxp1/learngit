
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="${pageContext.request.contextPath }/back/img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/back/css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/back/css/login.css" type="text/css"></link>
	<script type="text/javascript" src="${pageContext.request.contextPath }/back/script/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/back/script/common.js"></script>
	<script type="text/javascript">
	
		$(function(){
			//点击更换验证码：
			$("#captchaImage").click(function(){//点击更换验证码
				$(this).attr("src","${pageContext.request.contextPath}/image/image1.do?flag="+Math.random());
			});
			
			//  form 表单提交
			$("#loginForm").bind("submit",function(){
				url:"${pageContext.request.contextPath}/admin/login.do"
				
			//	return false;
			});
			
		});
	</script>
	
</head>
<body>
	
		<div class="login">
			<form id="loginForm" action="${pageContext.request.contextPath}/admin/login.do" method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
						
		</td>
							<th>
								用户名:
							</th>
							<td>
								<input type="text"  name="name" class="text" maxlength="20"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" name="password" class="text" maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input name="code" type="text" maxlength="4"/>
								<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath }/image/image1.do" title="点击更换验证码"/><br/>
								
								<!--  <a href="javascript:void(0)" onclick="document.getElementById('imgVcode').src='<s:url  action='${pageContext.request.contextPath }/image/image1.do' />?time='+(new Date()).getTime();">看不清，再换一张</a>-->
							</td>
						</tr> 				
			
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="submit" class="loginButton" value="登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2005-2013.</div>
				<div class="link">
					<a href="">前台首页</a> |
					<a href="">官方网站</a> |
					<a href="">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
				
				ul.tab   overflow:hidden;
				
				background: url(../img/input.gif) 0px 0px repeat-x;
				html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, font, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, dd, dl, dt, li, ol, ul, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td {
	padding: 0px;
	margin: 0px;
	border: 0px;
	outline: 0px;
}
				
			</form>
			
		</div>
</body>
</html>