<%@ page pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/back/easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/back/easyui/themes/icon.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath }/back/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/back/easyui/jquery.easyui.min.js"></script>

	
	<script type="text/javascript" src="${pageContext.request.contextPath }/back/editor/kindeditor-common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/back/editor/kindeditor.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/back/editor/lang/zh_CN.js"></script>

	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台管理首页</title>
<script type="text/javascript">

$(function(){
	//手风琴菜单选项卡
	$.post(
	"${pageContext.request.contextPath}/menu/query.do",
	function(data){
		$.each(data,function(index,obj){
			var content="";
			$.each(obj.list,function(i,o){
				content+="<a onclick='selectTab(\""+o.name+"\",\""+o.icon+"\",\""+o.href+"\")' style='width:100%' class ='easyui-linkbutton' data-options='iconCls:\""+o.icon+"\"'>"+o.name+"</a>"
			})
			$("#aa").accordion("add",{
				title:obj.name,
				content:content,
				iconCls:obj.icon
			});
			})
	},
	"JSON"
	)
})

function selectTab(name,icons,href){
	//如果已经存在则选中
	if($("#tt").tabs("exists",name)){
		//选中
		$("#tt").tabs("select",name);
	}else{
	//如果不存在则创建
	$("#tt").tabs("add",{
		title:name,
		iconCls:icons,
		closable:true,
		href:"${pageContext.request.contextPath}/"+href
	})
	}
}
</script>
</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.admin.name } &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>
       
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;建普科技</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">
			
		</div>
    </div>
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		  <!--   <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(${pageContext.request.contextPath}/back/img/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>--> 
		</div>
    </div>   
    
    
   <!-- <shiro:hasRole name="super">  
		<a>添加</a>
		<a>删除</a>
		<a>修改</a>
	</shiro:hasRole>
	<shiro:hasAnyRoles name="admin,super">
		<a>查看</a>
	</shiro:hasAnyRoles>
     --> 
</body> 
</html>