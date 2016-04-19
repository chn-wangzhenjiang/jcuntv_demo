<%@page import="com.pkit.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=SysUserRole.TABLE_ALIAS%> 维护</title>
	<link href="<c:url value="/styles/common.css"/>" type="text/css" rel="stylesheet">
	<link href="<c:url value="/widgets/simpletable/simpletable.css"/>" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="<c:url value="/widgets/simpletable/simpletable.js"/>"></script>
	
	<script type="text/javascript" >
		$(document).ready(function() {
			// 分页需要依赖的初始化动作
			window.simpleTable = new SimpleTable('queryForm',${page.thisPageNumber},${page.pageSize},'${pageRequest.sortColumns}');
		});
		function search(){
			var s = document.getElementById("searchImg").src;
			if(document.getElementById("queryPanelId").style.display!="none"){
				document.getElementById("queryPanelId").style.display="none";
				document.getElementById("searchImg").src=s.replace('magnifier1.png','magnifier.png');				
			}else{
				document.getElementById("queryPanelId").style.display="";
				document.getElementById("searchImg").src=s.replace('magnifier.png','magnifier1.png');
			}
		}
		function openPage(url){
			openDialog(url,'myDialog',600,500,400,150);
		}
	</script>
</rapid:override>

<rapid:override name="content">
	<form id="queryForm" name="queryForm" action="<c:url value="/pages/SysUserRole/list.do"/>" method="get" style="display: inline;">
	<div class="queryPanel" id="queryPanelId" style="display:none" >
		<fieldset>
			<legend>搜索</legend>
			<table class="queryPanel_table">
				<tr class="queryPanel_tr">	
					
						<td class="queryPanel_tdLabel"><%=SysUserRole.ALIAS_USER_ID%></td>		
							<td>
						<input value="${query.userId}" id="userId" name="userId" maxlength="19"  class="queryPanel_input"/>
					</td>
					
						<td class="queryPanel_tdLabel"><%=SysUserRole.ALIAS_ROLE_ID%></td>		
							<td>
						<input value="${query.roleId}" id="roleId" name="roleId" maxlength="19"  class="queryPanel_input"/>
					</td>
				</tr>	
			</table>
		</fieldset>
	 </div>
	
	<div class="gridTable">
	
		<simpletable:pageToolbar page="${page}">
			<img id="searchImg" src="${ctx}/images/magnifier.png" width="22" onclick="search()" class="stdButton" alt="" />
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="showLoading();getReferenceForm(this).action='${ctx}/pages/SysUserRole/list.do'"/>
			<input type="submit" class="stdButton" style="width:80px" value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/SysUserRole/create.do'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="batchDelete('${ctx}/pages/SysUserRole/delete.do','items',document.forms.queryForm)"/>
			<input type="button" class="stdButton" style="width:80px" value="刷新" onclick="showLoading();window.location.reload()"/>
		</simpletable:pageToolbar>
	
		<table width="100%"  border="0" cellspacing="0" class="gridBody">
		  <thead>
			  
			  <tr>
				<th style="width:1px;"> </th>
				<th style="width:1px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th sortColumn="user_id" ><%=SysUserRole.ALIAS_USER_ID%></th>
				<th sortColumn="role_id" ><%=SysUserRole.ALIAS_ROLE_ID%></th>
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="id=${item.id}&"></td>
				
				<td><c:out value='${item.sysUser.username}'/>&nbsp;</td>
				<td><c:out value='${item.roleId}'/>&nbsp;</td>
				<td>
					<a href="javascript:void(-1)" onclick="openPage('${ctx}/pages/SysUserRole/show.do?id=${item.id}&')">查看</a>&nbsp;&nbsp;&nbsp;
					<a href="${ctx}/pages/SysUserRole/edit.do?id=${item.id}&">修改</a>
				</td>
			  </tr>
			  
		  	  </c:forEach>
		  </tbody>
		</table>
	
		<simpletable:pageToolbar page="${page}">
		</simpletable:pageToolbar>
	</div>
	</form>
</rapid:override>
<script type="text/javascript" >
function showLoading(){
	parent.document.getElementById("Container").style.display="";
	parent.document.getElementById("gridFrameDiv").style.display="none";
}
parent.document.getElementById("Container").style.display="none";
parent.document.getElementById("gridFrameDiv").style.display="";
</script>
<%@ include file="base.jsp" %>

