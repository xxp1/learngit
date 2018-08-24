<%@ page pageEncoding="utf-8"%>

<script type="text/javascript">
	$(function() {
		//初始化dialog
		$("#table").datagrid({
			//适应网格宽度
			fitColumns : true,
			//定义从服务器进行排序
			remoteSort : true,
			//显示行列数
			rownumbers : true,
			url : "${pageContext.request.contextPath}/userP/queryPage.do",
			//工具栏
			toolbar : "#div",
			//显示分页工具栏
			pagination : true,
			pageNumber : 1,
			pageSize : 3,
			pageList : [ 2,3,, 4, 8, 10 ],
		});

		// 初始化“添加用户”按钮
		$("#query").linkbutton({
			
			iconCls:'icon-add',
			onClick : function() {
				$.get(
					"${pageContext.request.contextPath}/userP/User.do",		
					function(){
						$.messager.show({
							title:"导出",
							msg:"导出成功"
						});
					},
					"text"
					
				);
			}
		});
		$("#z").linkbutton({
			onClick : function() {
			
			}
		});
		$("#upload").linkbutton({
			onClick : function() {
				
			}
		});
		$("#import").linkbutton({
			onClick : function() {
				$("#importDialog").dialog("open");
			}
		});
		
		
		$("#importDialog").dialog({
			title : "导入数据",
			width : 500,
			height : 300,
			modal : true,
			href : "${pageContext.request.contextPath }/import.jsp",
			closed : true
		});
	});	
		
		

</script>
	
	<table id="table">
		<thead>
			<tr>
				<th data-options="field:'bbb',width:10,checkbox:true"></th>
				<th data-options="field:'id',width:10">id</th>
				<th data-options="field:'iphone',width:10">手机号</th>
				<th data-options="field:'password',width:10">密码</th>
				<th data-options="field:'image',width:10">头像</th>
				<th data-options="field:'faming',width:10">时尚</th>
				<th data-options="field:'username',width:10">用户名</th>
				<th data-options="field:'sex',width:10">性别</th>
				<th data-options="field:'address',width:10">地址</th>
				<th data-options="field:'qianming',width:10">签名</th>
				<th data-options="field:'status',width:10">状态</th>
				<th data-options="field:'aaa',width:10">操作</th>
			</tr>
		</thead>
	</table>

	<div id="div">
		<a id="query">全部导出</a>
		<a id="z">自定义导出</a>
		<a id="upload">模板下载</a>
		<a id="import">导入</a>
	</div>
	
	<div id="importDialog"></div>
	
	