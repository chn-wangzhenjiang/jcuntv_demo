<%@page import="${basepackage}.model.*" %>
<#include "/macro.include"/> 
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<link type="text/css" rel="stylesheet" href="${'$'}{ctx}/js/dialog/jquery_dialog.css" />
<script type="text/javascript" src="${'$'}{ctx}/js/dialog/jquery.js"></script>
<script type="text/javascript" src="${'$'}{ctx}/js/dialog/jquery_dialog.js"></script>
<script type="text/javascript">
 function dialog_callback(result,idname,resultdata){
 	if(resultdata!=null)
 	{ 	
	 <#list table.columns as column>		
		<#if column.displayType="popup">
			if(idname=='${column.columnNameLower}'){
 				$('${'#'}'+idname).val(resultdata.${column.fkidcolumn})
 				$('${'#'}'+'${column.fkalias}').val(resultdata.${column.fknamecolumn});
 			}
	 	</#if>
	  </#list>		
 	}
 }
 function selectItem(idname,namefield){
 	JqueryDialog.Open(dialog_callback,idname,'选择', '${'$'}{ctx}/selectDispatch.do?s=${className}', 620, 350);
 }
</script>

<#list table.columns as column>
<#if column.htmlHidden>
	<s:hidden id="${column.columnNameLower}" name="${column.columnNameLower}" />
</#if>
</#list>

<!-- ONGL access static field: @package.class@field or @vs@field --> 
<#-- 定义要显示的列数 columnCount -->
<#assign columnCount = 2>
<#assign columns = table.columns>
<#-- 计算显示当前记录集需要的表格行数 rowCount -->
<#assign rowCount = table.columns?size>
<#if rowCount % columnCount == 0>
    <#assign rowCount = ( rowCount/ columnCount) - 1 >
<#else>
    <#assign rowCount = ( rowCount / columnCount) >
</#if>

rowcount:${rowCount}
<#list 0..rowCount as row >
    <tr>
        <#-- 内层循环输出表格的 td  -->
        <#list 0..columnCount - 1 as cell >
		<#if table.columns[row * columnCount + cell]?? >                        
        <#assign column = table.columns[row * columnCount + cell]>

  <#if !column.htmlHidden>
		<#if column.isDateTimeColumn>
		<td class="tdLabel">
			<#if !column.nullable><span class="required">*</span></#if><%=${className}.ALIAS_${column.constantName}%>:
		</td>	
		<td>
		<input value="<@jspEl 'model.'+column.columnNameLower+'String'/>" onclick="WdatePicker({dateFmt:'<%=${className}.FORMAT_${column.constantName}%>'})" id="${column.columnNameLower}String" name="${column.columnNameLower}String"  maxlength="0" class="${column.validateString}" />
		</td>
	<#elseif column.displayType="popup">
		<td class="tdLabel">
			<#if !column.nullable><span class="required">*</span></#if><%=${className}.ALIAS_${column.constantName}%>:
		</td>
		<td>	
			<s:hidden id="${column.columnNameLower}" name="${column.columnNameLower}" />
			<table border="0" cellpaccing="0" cellpadding="0" style="width:100%">
			<tr>
			<td style="width:20px;">
				<img src="${'$'}{ctx}/images/edit/getbyid.gif" onclick="selectItem('${column.columnNameLower}')"/>
			</td>
			<td>
				<s:textfield label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.fkalias}" name="${column.fkalias}" value="%{model.${column.fkalias}}" cssClass="inputClass"  theme="simple" readonly="true" />
			</td>			
			</tr>
			</table>
		</td>
	<#elseif column.displayType="combo">	
		<td class="tdLabel">
			<#if !column.nullable><span class="required">*</span></#if><%=${className}.ALIAS_${column.constantName}%>:
		</td>
		<td>
		<!--headerKey="0"   headerValue="请选择" -->
			<s:select label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.columnNameLower}" name="${column.columnNameLower}" value="%{model.${column.columnNameLower}}" list="${column.enumComboxList}" cssClass="comboxcss" required="${(!column.nullable)?string}" theme="simple"/>	
		</td>
	<#elseif column.displayType="unixtime">
		<td class="tdLabel">
			<#if !column.nullable><span class="required">*</span></#if><%=${className}.ALIAS_${column.constantName}%>:
		</td>
		<td>
			<s:hidden id="${column.columnNameLower}" name="${column.columnNameLower}" value="%{model.${column.columnNameLower}}"/>
			<s:label value="%{model.${column.columnNameLower}AsDateTime}" theme="simple"/>
		</td>
	<#else>
		<td class="tdLabel">
			<#if !column.nullable><span class="required">*</span></#if><%=${className}.ALIAS_${column.constantName}%>:
		</td>
		<td>		
	  <#if column.enumString!="">				
	  	<s:select label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.columnNameLower}" name="${column.columnNameLower}" value="%{model.${column.columnNameLower}}" headerKey="0"   headerValue="请选择" list="${column.enumComboxList}" cssClass="comboxcss" required="${(!column.nullable)?string}" theme="simple"/>					 	
	  <#else>
		<s:textfield label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.columnNameLower}" name="${column.columnNameLower}" value="%{model.${column.columnNameLower}}" cssClass="inputClass" required="${(!column.nullable)?string}"  theme="simple"/>
	  </#if>
	   </td>	  
	</#if>	
</#if>

  <#else>
	 <td>&nbsp;</td>
	 <td>&nbsp;</td>
  </#if>
</#list>
</tr>
</#list>