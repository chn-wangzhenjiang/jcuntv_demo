<%@page import="${basepackage}.model.*" %>
<#include "/macro.include"/> 
<#include "/custom.include"/> 
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign actionExtension = "do"> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<title><%=${className}.TABLE_ALIAS%>信息</title>
<link href="<c:url value="/styles/global.css"/>" type="text/css" rel="stylesheet">
<body>
	<s:form action="${actionBasePath}/list.${actionExtension}" method="get" theme="simple">
	<div class="bread">
                    您的当前位置：<a href="${'$'}{ctx}/pages/${className}/list.do?efbuttons=<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efbuttons"))%>&efpopup=<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efpopup"))%>&efgridHeight=<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efgridHeight"))%>&efrowNum=<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efrowNum"))%>&efrowList=<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efrowList"))%>&efcd=<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efcd"))%>" target="_self"><%=${className}.TABLE_ALIAS%>列表</a>&gt;<span>查看<%=${className}.TABLE_ALIAS%></span>
	</div>
	<table width="90%" align="center" cellpadding="0" cellspacing="0" border="0">	
	<tr>
	<td>
         <div class="dialogTitle clearfix">
            <div><%=${className}.TABLE_ALIAS%>查看</div>
        </div>
    </td></tr>
    <tr>
    <td>      
    	
	<#list table.columns as column>
	<#if column.pk>
		<s:hidden name="${column.columnNameLower}" id="${column.columnNameLower}" value="%{model.${column.columnNameLower}}"/>
	</#if>
	</#list>	
		<table class="formTable">
		
		<#-- 定义要显示的列数 columnCount -->
<#assign columnCount = 2>
<#assign columns = table.columns>
<#-- 计算显示当前记录集需要的表格行数 rowCount -->
<#assign rowCount = table.columns?size-1>
<#if rowCount % columnCount == 0>
    <#assign rowCount = ( rowCount/ columnCount) - 1 >
<#else>
    <#assign rowCount = ( rowCount / columnCount) >
</#if>
<#list 0..rowCount as row >
    <tr>
        <#-- 内层循环输出表格的 td  -->
        <#list 0..columnCount - 1 as cell >
		<#if table.columns[1+row * columnCount + cell]?? >                        
        <#assign column = table.columns[1+row * columnCount + cell]>
      	<#if !column.htmlHidden>
			<td class="tdLabel"><%=${className}.ALIAS_${column.constantName}%>:&nbsp;</td>	
			<td class="tdField">				
			<#if column.isDateTimeColumn>			
				<s:property value="%{model.${column.columnNameLower}AsString}" />
			<#elseif column.displayType="popup">	
				<s:property value="%{model.${column.fkalias}}" />
			<#elseif column.displayType="combo">					
				<s:property value="%{model.${column.columnNameLower}Enum}" />			
			<#elseif column.displayType="unixtime">
				<s:property value="%{model.${column.columnNameLower}AsDateTime}" />
			<#elseif column.displayType="multiline">
				<s:property value="%{model.${column.columnNameLower}AsLabel}" />
			<#else>		
	  			<s:property value="%{model.${column.columnNameLower}}" />
	  		</#if>
			</td>				
		</#if>
		<#else>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</#if>
		</#list>
	    
	    </tr>
    </#list>
	   </table>
	</td>
	</tr>
	<tr><td>
		<div class="dialogBtn">
			<input type="button" class="btn" value="返回"   onfocus="this.blur();" onclick="history.back()"/>
		</div>
	</td></tr>
	</table>
	</s:form>
</body>		