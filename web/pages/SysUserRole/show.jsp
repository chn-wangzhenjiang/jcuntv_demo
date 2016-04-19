<%@page import="com.pkit.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=SysUserRole.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<s:form action="/pages/SysUserRole/list.do" method="get" theme="simple">
		
		<s:hidden name="id" id="id" value="%{model.id}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=SysUserRole.ALIAS_USER_ID%></td>	
				<td><s:property value="%{model.sysUser.username}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SysUserRole.ALIAS_ROLE_ID%></td>	
				<td><s:property value="%{model.roleId}" /></td>
			</tr>
		</table>
	</s:form>
	<div align="center"><input type="button"  class="dialogclose"  value="关闭" onclick="window.close()"/></div>
</rapid:override>

<%@ include file="base.jsp" %>