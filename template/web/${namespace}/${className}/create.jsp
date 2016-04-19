<#include "/macro.include"/>
<#include "/custom.include"/>  
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign actionExtension = "do"> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<link href="<c:url value="/styles/global.css"/>" type="text/css" rel="stylesheet">
<title><%=${className}.TABLE_ALIAS%>新增</title>
	<s:form action="${actionBasePath}/save.${actionExtension}" method="post" onsubmit="return validateinput()"  theme="simple">
	<div class="bread">
                    您的当前位置：<a href="${'$'}{ctx}/pages/${className}/list.do?efbuttons=<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efbuttons"))%>&efpopup=<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efpopup"))%>&efgridHeight=<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efgridHeight"))%>&efrowNum=<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efrowNum"))%>&efrowList=<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efrowList"))%>&efcd=<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efcd"))%>" target="_self"><%=${className}.TABLE_ALIAS%>列表</a>&gt;<span>新增<%=${className}.TABLE_ALIAS%>新增</span>
	</div>
	<table width="90%" align="center" cellpadding="0" cellspacing="0" border="0">	
	<tr>
	<td>
         <div class="dialogTitle clearfix">
            <div>新增<%=${className}.TABLE_ALIAS%></div>
        </div>
    </td></tr>
    <tr>
    <td>      
 		<table class="formTable" align="center">
		<%@ include file="form_include.jsp" %>
		</table>
	</td>
	</tr>
	
	<tr><td>
		<div class="dialogBtn">
			<input type="submit" class="btn" value="提交" onfocus="this.blur();"/>
			<input type="button" class="btn" value="返回"   onfocus="this.blur();" onclick="history.back()"/>
		</div>
	</td></tr>
	</table>
	</s:form>	