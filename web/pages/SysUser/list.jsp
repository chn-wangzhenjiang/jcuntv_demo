<%@page import="com.pkit.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=SysUser.TABLE_ALIAS%> 维护</title>
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
	<form id="queryForm" name="queryForm" action="<c:url value="/pages/SysUser/list.do"/>" method="get" style="display: inline;">
	<div class="queryPanel" id="queryPanelId" style="display:none" >
		<fieldset>
			<legend>搜索</legend>
			<table class="queryPanel_table">
				<tr class="queryPanel_tr">	
					
						<td class="queryPanel_tdLabel"><%=SysUser.ALIAS_USERNAME%></td>		
							<td>
						<input value="${query.username}" id="username" name="username" maxlength="50"  class="queryPanel_input"/>
					</td>
					
						<td class="queryPanel_tdLabel"><%=SysUser.ALIAS_PASSWORD%></td>		
							<td>
						<input value="${query.password}" id="password" name="password" maxlength="255"  class="queryPanel_input"/>
					</td>
					
						<td class="queryPanel_tdLabel"><%=SysUser.ALIAS_NAME%></td>		
							<td>
						<input value="${query.name}" id="name" name="name" maxlength="50"  class="queryPanel_input"/>
					</td>
					
						<td class="queryPanel_tdLabel"><%=SysUser.ALIAS_EMAIL%></td>		
							<td>
						<input value="${query.email}" id="email" name="email" maxlength="255"  class="queryPanel_input"/>
					</td>
				</tr>	
				<tr class="queryPanel_tr">	
					
						<td class="queryPanel_tdLabel"><%=SysUser.ALIAS_PHONE_NUMBER%></td>		
							<td>
						<input value="${query.phoneNumber}" id="phoneNumber" name="phoneNumber" maxlength="255"  class="queryPanel_input"/>
					</td>
					
						<td class="queryPanel_tdLabel"><%=SysUser.ALIAS_PASSWORD_HINT%></td>		
							<td>
						<input value="${query.passwordHint}" id="passwordHint" name="passwordHint" maxlength="255"  class="queryPanel_input"/>
					</td>
					
						<td class="queryPanel_tdLabel" colspan="2">
							<table align="left" class="queryPanel_comtable">
							<s:select label="%{@com.pkit.model.SysUser@ALIAS_ACCOUNT_TYPE}" key="accountType" value="query.accountType" headerKey=""   headerValue="请选择" list="#{'1':'系统点数','2':'人民币','3':'美元'}" cssClass="comboxcss" required="false"/>
							</table>
						</td> 
					</td>
					
						<td class="queryPanel_tdLabel"><%=SysUser.ALIAS_CREATE_DATE%></td>		
							<td>
						<input value="<fmt:formatDate value='${query.createDateBegin}' pattern='<%=SysUser.FORMAT_CREATE_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=SysUser.FORMAT_CREATE_DATE%>'})" id="createDateBegin" name="createDateBegin" class="queryPanel_input"  />
						<input value="<fmt:formatDate value='${query.createDateEnd}' pattern='<%=SysUser.FORMAT_CREATE_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=SysUser.FORMAT_CREATE_DATE%>'})" id="createDateEnd" name="createDateEnd"  class="queryPanel_input" />
					</td>
				</tr>	
			</table>
		</fieldset>
	 </div>
	
	<div class="gridTable">
	
		<simpletable:pageToolbar page="${page}">
			<img id="searchImg" src="${ctx}/images/magnifier.png" width="22" onclick="search()" class="stdButton" alt="" />
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="showLoading();getReferenceForm(this).action='${ctx}/pages/SysUser/list.do'"/>
			<input type="submit" class="stdButton" style="width:80px" value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/SysUser/create.do'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="batchDelete('${ctx}/pages/SysUser/delete.do','items',document.forms.queryForm)"/>
			<input type="button" class="stdButton" style="width:80px" value="刷新" onclick="showLoading();window.location.reload()"/>
		</simpletable:pageToolbar>
	
		<table width="100%"  border="0" cellspacing="0" class="gridBody">
		  <thead>
			  
			  <tr>
				<th style="width:1px;"> </th>
				<th style="width:1px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th sortColumn="username" ><%=SysUser.ALIAS_USERNAME%></th>
				<th sortColumn="password" ><%=SysUser.ALIAS_PASSWORD%></th>
				<th sortColumn="name" ><%=SysUser.ALIAS_NAME%></th>
				<th sortColumn="email" ><%=SysUser.ALIAS_EMAIL%></th>
				<th sortColumn="phone_number" ><%=SysUser.ALIAS_PHONE_NUMBER%></th>
				<th sortColumn="password_hint" ><%=SysUser.ALIAS_PASSWORD_HINT%></th>
				<th sortColumn="account_type" ><%=SysUser.ALIAS_ACCOUNT_TYPE%></th>
				<th sortColumn="create_date" ><%=SysUser.ALIAS_CREATE_DATE%></th>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="id=${item.id}&"></td>
				
				<td><c:out value='${item.username}'/>&nbsp;</td>
				<td><c:out value='${item.password}'/>&nbsp;</td>
				<td><c:out value='${item.name}'/>&nbsp;</td>
				<td><c:out value='${item.email}'/>&nbsp;</td>
				<td><c:out value='${item.phoneNumber}'/>&nbsp;</td>
				<td><c:out value='${item.passwordHint}'/>&nbsp;</td>
				<td><c:out value='${item.accountTypeEnum}'/>&nbsp;</td>
				<td><c:out value='${item.createDateString}'/>&nbsp;</td>
				<td>
					<a href="javascript:void(-1)" onclick="openPage('${ctx}/pages/SysUser/show.do?id=${item.id}&')">查看</a>&nbsp;&nbsp;&nbsp;
					<a href="${ctx}/pages/SysUser/edit.do?id=${item.id}&">修改</a>
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

