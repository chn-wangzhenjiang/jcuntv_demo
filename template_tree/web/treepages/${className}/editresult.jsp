<%@page import="${basepackage}.model.*" %>
<#include "/macro.include"/> 
<#include "/custom.include"/> 
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign actionExtension = "do"> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<base target="_self"/>
<script type="text/javascript">
function unicode(s){ 
var len=s.length; 
var rs=""; 
for(var i=0;i<len;i++){ 
var k=s.substring(i,i+1); 
rs+="&#"+s.charCodeAt(i)+";"; 
} 
return rs; 
} 

function runicode(s){ 
	var k=s.split(";"); 
	var rs=""; 
	for(i=0;i<k.length;i++){
		if(k[i].indexOf("&#")!=-1){ 
			var m=k[i].replace(/&#/,""); 
			rs+=String.fromCharCode(m);
		}else rs += k[i];
	} 
	return rs; 
} 

  var Sys = {};
        var ua = navigator.userAgent.toLowerCase();
        var s;
        (s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] :
        (s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :
        (s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :
        (s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :
        (s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;
function closethis(){        
	window.returnValue={'id':'<s:property value="%{model.${table.treeIdColumn?lower_case}}" />','name':runicode('<s:property value="%{model.${table.treeNameColumn?lower_case}}" />')};
	if(Sys.ie){
		var obj = window.dialogArguments;
		//firefox 无法通过obj，只能通过window.returnValue ie9则必须通过下面这个方法，否则会被限制
		if(obj!=null)obj.setReturnValue('<s:property value="%{action}"/>',window.returnValue);
	}
	window.close();
}
</script>
<title><%=${className}.TABLE_ALIAS%>信息</title>
<link href="<c:url value="/styles/global.css"/>" type="text/css" rel="stylesheet">
<body>
	<s:form action="${actionBasePath}/list.${actionExtension}" method="get" theme="simple">	
	<table width="90%" align="center" cellpadding="0" cellspacing="0" border="0">	
	<tr>
	<td>
         <div class="dialogTitle clearfix">
            <div><%=Cmscategory.TABLE_ALIAS%>处理成功</div>
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
			<input type="button" class="btn" value="确定"   onfocus="this.blur();" onclick="closethis()"/>			
		</div>
		</div>
	</td></tr>
	</table>
	</s:form>
</body>		