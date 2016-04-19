<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<#assign className = table.className>   
<#assign pkName = table.pkName>
<#assign lowerCasePKName = table.pkName?lower_case>
<#assign classNameLower = className?uncap_first>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<base href="<%=basePath%>">
	<!-- jsp文件头和头部 -->
	<%@ include file="../../system/admin/top.jsp"%>   
	</head>
<body>
		
		
<div class="container-fluid" id="main-container">


<div id="page-content" class="clearfix">
						
  <div class="row-fluid">

	<div class="row-fluid">
	
			<!-- 检索  -->
			<form action="${classNameLower}/list.do" method="post" name="myForm" id="myForm">
			<table border='0'>
			
			</table>
			<!-- 检索  -->
		
		
			<table id="table_report" class="table table-striped table-bordered table-hover">
				
				<thead>
					<tr>
						<th class="center">
						<label><input type="checkbox" id="zcheckbox" /><span class="lbl"></span></label>
						</th>					
					<#list table.columns as column>
					<#if !column.htmlHidden>
						<#if column.listShow!="0">	
							<th>${column.columnAlias}</th>
						</#if>
					</#if>
					</#list>
					</tr>
				</thead>
										
				<tbody>
					
				<!-- 开始循环 -->	
				<c:choose>
					<c:when test="${'$'}{not empty dataList}">
						<c:if test="${'$'}{QX.cha == 1 }">
						<c:forEach items="${'$'}{dataList}" var="item" varStatus="vs">
									
							<tr>
								<td class='center' style="width: 30px;">
									<label><input type='checkbox' name='ids' value="${'$'}{item.${pkName}}" id="ids" alt="ids"/><span class="lbl"></span></label>
								</td>
								<!-- <td class='center' style="width: 30px;">${'$'}{vs.index+1}</td> -->
					<#list table.columns as column>
					<#if !column.htmlHidden>
						<#if column.listShow!="0">	
							<td>
								<#if column.displayType="combo">
									
									${'$'}{item.${column.sqlName}}
									
									
								<#elseif column.displayType="unixtime">
									<#if column.dataformat="yyyy-MM-dd">
										${'$'}{item.${column.sqlName}}
									</#if>
								<#elseif column.displayType="popup">
									${'$'}{item.${column.sqlName}}
								<#elseif column.displayType="efcdpopup">
									${'$'}{item.${column.sqlName}}
								<#elseif column.displayType="condpopup">
									${'$'}{item.${column.sqlName}}
								<#else>	
									${'$'}{item.${column.sqlName}}
								</#if>
							</td>
						</#if>
					</#if>
					</#list>
					<td style="width: 30px;" class="center">
									<div class='hidden-phone visible-desktop btn-group'>									
										<c:if test="${'$'}{QX.edit != 1 && QX.del != 1 }">
										<span class="label label-large label-grey arrowed-in-right arrowed-in"><i class="icon-lock" title="无权限"></i></span>
										</c:if>
										<div class="inline position-relative">
										<button class="btn btn-mini btn-info" data-toggle="dropdown"><i class="icon-cog icon-only"></i></button>
										<ul class="dropdown-menu dropdown-icon-only dropdown-light pull-right dropdown-caret dropdown-close">
											<c:if test="${'$'}{QX.edit == 1 }">
											<li><a style="cursor:pointer;" title="编辑" onclick="edit('${'$'}{item.${table.pkName}}');" class="tooltip-success" data-rel="tooltip" title="" data-placement="left"><span class="green"><i class="icon-edit"></i></span></a></li>
											</c:if>
											<c:if test="${'$'}{QX.del == 1 }">
											<li><a style="cursor:pointer;" title="删除" onclick="del('${'$'}{item.${table.pkName}}');" class="tooltip-error" data-rel="tooltip" title="" data-placement="left"><span class="red"><i class="icon-trash"></i></span> </a></li>
											</c:if>
										</ul>
										</div>
									</div>
								</td>
							</tr>
						
						</c:forEach>
						</c:if>
						
						<c:if test="${'$'}{QX.cha == 0 }">
							<tr>
								<td colspan="100" class="center">您无权查看</td>
							</tr>
						</c:if>
					</c:when>
					<c:otherwise>
						<tr class="main_info">
							<td colspan="100" class="center" >没有相关数据</td>
						</tr>
					</c:otherwise>
				</c:choose>
					
				
				</tbody>
			</table>
			
		<div class="page-header position-relative">
		<table style="width:100%;">
			<tr>
				<td style="vertical-align:top;">
					<c:if test="${'$'}{QX.add == 1 }">
					<a class="btn btn-small btn-success" onclick="add();">新增</a>
					</c:if>
					<c:if test="${'$'}{QX.del == 1 }">
					<a class="btn btn-small btn-danger" onclick="makeAll('确定要删除选中的数据吗?');" title="批量删除" ><i class='icon-trash'></i></a>
					</c:if>
				</td>
				<td style="vertical-align:top;"><div class="pagination" style="float: right;padding-top: 0px;margin-top: 0px;">${'$'}{page.pageStr}</div></td>
			</tr>
		</table>
		</div>
		</form>
	</div>
 
 
 
 
	<!-- PAGE CONTENT ENDS HERE -->
  </div><!--/row-->
	
</div><!--/#page-content-->
</div><!--/.fluid-container#main-container-->
		
		<!-- 返回顶部  -->
		<a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse">
			<i class="icon-double-angle-up icon-only"></i>
		</a>
		
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/ace-elements.min.js"></script>
		<script src="static/js/ace.min.js"></script>
		
		<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript" src="static/js/bootbox.min.js"></script><!-- 确认窗口 -->
		<!-- 引入 -->
		<script type="text/javascript" src="static/js/jquery.tips.js"></script><!--提示框-->
		<script type="text/javascript">
		
		${'$'}(top.hangge());
		
		//检索
		function search(){
			top.jzts();
			${'$'}("#myForm").submit();
		}
		
		//新增
		function add(){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="新增${table.tableAlias}";
			 diag.URL = '<%=basePath%>${classNameLower}/goAdd.do';
			 diag.Width = ${table.dlgwidth};
			 diag.Height = ${table.dlgheight};
			 diag.CancelEvent = function(){ //关闭事件
				 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					 if('${'$'}{page.currentPage}' == '0'){
						 top.jzts();
						 setTimeout("self.location=self.location",100);
					 }else{
						 nextPage(${'$'}{page.currentPage});
					 }
				}
				diag.close();
			 };
			 diag.show();
		}
		
		//修改
		function edit(id){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="会员资料";
			 diag.URL = '<%=basePath%>${classNameLower}/goEdit.do?${pkName}='+id;
			 diag.Width = ${table.dlgwidth};
			 diag.Height = ${table.dlgheight};
			 diag.CancelEvent = function(){ //关闭事件
				 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					 nextPage(${'$'}{page.currentPage});
				}
				diag.close();
			 };
			 diag.show();
		}
		
		//删除
		function del(id,msg){
			bootbox.confirm("确定要删除["+msg+"]吗?", function(result) {
				if(result) {
					top.jzts();
					var url = "<%=basePath%>${classNameLower}/delete.do?${pkName}="+id+"&tm="+new Date().getTime();
					$.get(url,function(data){
						nextPage(${'$'}{page.currentPage});
					});
				}
			});
		}
		
		</script>
		
		<script type="text/javascript">
		
		${'$'}(function() {
			
			//下拉框
			${'$'}(".chzn-select").chosen(); 
			${'$'}(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//日期框
			${'$'}('.date-picker').datepicker();
			
			//复选框
			${'$'}('table th input:checkbox').on('click' , function(){
				var that = this;
				${'$'}(this).closest('table').find('tr > td:first-child input:checkbox')
				.each(function(){
					this.checked = that.checked;
					${'$'}(this).closest('tr').toggleClass('selected');
				});
					
			});
			
		});
		
		
		//批量操作
		function makeAll(msg){
			bootbox.confirm(msg, function(result) {
				if(result) {
					var str = '';
					var emstr = '';
					var phones = '';
					for(var i=0;i < document.getElementsByName('ids').length;i++)
					{
						  if(document.getElementsByName('ids')[i].checked)
						  	if(str=='') str += document.getElementsByName('ids')[i].value;
						  	else str += ',' + document.getElementsByName('ids')[i].value;
					}
					if(str==''){
						bootbox.dialog("您没有选择任何内容!", 
							[
							  {
								"label" : "关闭",
								"class" : "btn-small btn-success",
								"callback": function() {
									//Example.show("great success");
									}
								}
							 ]
						);
						
						${'$'}("#zcheckbox").tips({
							side:3,
				            msg:'点这里全选',
				            bg:'#AE81FF',
				            time:8
				        });
						
						return;
					}else{
						if(msg == '确定要删除选中的数据吗?'){
							top.jzts();
							${'$'}.ajax({
								type: "POST",
								url: '<%=basePath%>${classNameLower}/deleteAll.do?tm='+new Date().getTime(),
						    	data: {IDS:str},
								dataType:'json',
								//beforeSend: validateData,
								cache: false,
								success: function(data){
									 ${'$'}.each(data.list, function(i, list){
											nextPage(${'$'}{page.currentPage});
									 });
								}
							});
						}						
					}
				}
			});
		}
		
		//导出excel
		function toExcel(){
			//var STATUS = $("#STATUS").val();
			window.location.href='<%=basePath%>happuser/excel.do';
		}
		</script>
		
	</body>
</html>

