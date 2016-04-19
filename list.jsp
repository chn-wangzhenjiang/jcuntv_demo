<%@page import="${basepackage}.model.*" %>
<#include "/macro.include"/> 
<#include "/custom.include"/> 
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
  
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=${className}.TABLE_ALIAS%> 维护</title>
	<link rel="stylesheet" href="../../css/mod.css" />
	<link href="<c:url value="/styles/common.css"/>" type="text/css" rel="stylesheet">
	<link rel="stylesheet" href="../../css/mod.css" />
	<link href="<c:url value="/widgets/simpletable/simpletable.css"/>" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="<c:url value="/widgets/simpletable/simpletable.js"/>"></script>
	
	<script type="text/javascript" >
		$(document).ready(function() {
			// 分页需要依赖的初始化动作
			window.simpleTable = new SimpleTable('queryForm',<@jspEl 'page.thisPageNumber'/>,<@jspEl 'page.pageSize'/>,'<@jspEl 'pageRequest.sortColumns'/>');
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
	<form id="queryForm" name="queryForm" action="<c:url value="${actionBasePath}/list.do"/>" method="get" style="display: inline;">
	<div class="queryPanel" id="queryPanelId" style="display:none" >
		<fieldset>
			<legend>搜索</legend>
			<table class="queryPanel_table">
				<#list table.notPkColumns?chunk(4) as row>
				<tr class="queryPanel_tr">	
					<#list row as column>
					<#if !column.htmlHidden>	
					
						<#if column.isDateTimeColumn>
						<td class="queryPanel_tdLabel"><%=${className}.ALIAS_${column.constantName}%></td>		
							<td>
						<input value="<fmt:formatDate value='<@jspEl "query."+column.columnNameLower+'Begin'/>' pattern='<%=${className}.FORMAT_${column.constantName}%>'/>" onclick="WdatePicker({dateFmt:'<%=${className}.FORMAT_${column.constantName}%>'})" id="${column.columnNameLower}Begin" name="${column.columnNameLower}Begin" class="queryPanel_input"  />
						<input value="<fmt:formatDate value='<@jspEl "query."+column.columnNameLower+'End'/>' pattern='<%=${className}.FORMAT_${column.constantName}%>'/>" onclick="WdatePicker({dateFmt:'<%=${className}.FORMAT_${column.constantName}%>'})" id="${column.columnNameLower}End" name="${column.columnNameLower}End"  class="queryPanel_input" />
						<#elseif column.enumString!="">
						<td class="queryPanel_tdLabel" colspan="2">
							<table align="left" class="queryPanel_comtable">
							<s:select label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" key="${column.columnNameLower}" value="${"query."+column.columnNameLower}" headerKey=""   headerValue="请选择" list="${column.enumComboxList}" cssClass="comboxcss" required="${(!column.nullable)?string}"/>
							</table>
						</td> 
						<#else>
						<td class="queryPanel_tdLabel"><%=${className}.ALIAS_${column.constantName}%></td>		
							<td>
						<input value="<@jspEl "query."+column.columnNameLower/>" id="${column.columnNameLower}" name="${column.columnNameLower}" maxlength="${column.size}"  class="queryPanel_input"/>
						</#if>
					</td>
					</#if>
					</#list>
				</tr>	
				</#list>			
			</table>
		</fieldset>
	 </div>
	
	<div class="gridTable">
	
		<simpletable:pageToolbar page="<@jspEl 'page'/>">
			<img id="searchImg" src="<@jspEl 'ctx'/>/images/magnifier.png" width="22" onclick="search()" class="stdButton" alt="" />
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="showLoading();getReferenceForm(this).action='<@jspEl 'ctx'/>${actionBasePath}/list.do'"/>
			<input type="submit" class="stdButton" style="width:80px" value="新增" onclick="getReferenceForm(this).action='<@jspEl 'ctx'/>${actionBasePath}/create.do'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="batchDelete('<@jspEl 'ctx'/>${actionBasePath}/delete.do','items',document.forms.queryForm)"/>
			<input type="button" class="stdButton" style="width:80px" value="刷新" onclick="showLoading();window.location.reload()"/>
		</simpletable:pageToolbar>
	
		<table width="100%"  border="0" cellspacing="0" class="gridBody">
		  <thead>
			  
			  <tr>
				<th style="width:1px;"> </th>
				<th style="width:1px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<#list table.columns as column>
				<#if !column.htmlHidden>
				<th sortColumn="${column.sqlName}" ><%=${className}.ALIAS_${column.constantName}%></th>
				</#if>
				</#list>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="<@jspEl 'page.result'/>" var="item" varStatus="status">
		  	  
			  <tr class="<@jspEl "status.count % 2 == 0 ? 'odd' : 'even'"/>">
				<td><@jspEl 'page.thisPageFirstElementNumber + status.index'/></td>
				<td><input type="checkbox" name="items" value="<@generateIdQueryString/>"></td>
				
				<#list table.columns as column>
				<#if !column.htmlHidden>
				<td align="center"><#rt>
					<#compress>
					<#if column.isDateTimeColumn>
					<c:out value='<@jspEl "item."+column.columnNameLower+"String"/>'/>&nbsp;
					<#elseif column.displayType="datetime">
					    <c:out value='<@jspEl "item."+column.columnNameLower+"AsDateTime"/>'/>&nbsp;
					<#elseif column.enumString!="">
					<c:out value='<@jspEl "item."+column.columnNameLower+"Enum"/>'/>&nbsp;
					<#else>
					<c:out value='<@jspEl "item."+column.columnNameLower/>'/>&nbsp;
					</#if>
					</#compress>
				<#lt></td>
				</#if>
				</#list>
				<td>
					<a href="javascript:openPage('<@jspEl 'ctx'/>${actionBasePath}/show.do?<@generateIdQueryString/>')">查看</a>&nbsp;&nbsp;&nbsp;
					<a href="<@jspEl 'ctx'/>${actionBasePath}/edit.do?<@generateIdQueryString/>">修改</a>
				</td>
			  </tr>
			  
		  	  </c:forEach>
		  </tbody>
		</table>
	
		<simpletable:pageToolbar page="<@jspEl 'page'/>">
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

<#macro generateIdQueryString>
	<#if table.compositeId>
		<#assign itemPrefix = 'item.id.'>
	<#else>
		<#assign itemPrefix = 'item.'>
	</#if>
<#compress>
		<#list table.compositeIdColumns as column>
			<#t>${column.columnNameLower}=<@jspEl itemPrefix + column.columnNameLower/>&
		</#list>				
</#compress>
</#macro>