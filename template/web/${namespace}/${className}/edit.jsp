<#include "/macro.include"/> 
<#include "/custom.include"/> 
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign actionExtension = "do"> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<title><%=${className}.TABLE_ALIAS%>编辑</title>
<link href="<c:url value="/styles/global.css"/>" type="text/css" rel="stylesheet">
<s:form action="${actionBasePath}/update.${actionExtension}" method="post" onsubmit="return validateinput()"  theme="simple">
	<div class="bread">
                    您的当前位置：<a href="${'$'}{ctx}/pages/${className}/list.do?efbuttons=<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efbuttons"))%>&efpopup=<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efpopup"))%>&efgridHeight=<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efgridHeight"))%>&efrowNum=<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efrowNum"))%>&efrowList=<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efrowList"))%>&efcd=<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efcd"))%>" target="_self"><%=${className}.TABLE_ALIAS%>列表</a>&gt;<span><%=${className}.TABLE_ALIAS%>编辑</span>
	</div>
	<table width="90%" align="center" cellpadding="0" cellspacing="0" border="0">	
	<tr>
	<td>
         <div class="dialogTitle clearfix">
            <div><%=${className}.TABLE_ALIAS%>编辑</div>
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