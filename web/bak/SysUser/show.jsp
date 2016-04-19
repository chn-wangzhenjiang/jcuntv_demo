<%@page import="com.company.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=SysUser.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<s:form action="/pages/SysUser/list.do" method="get" theme="simple">
		
		<s:hidden name="id" id="id" value="%{model.id}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=SysUser.ALIAS_USERNAME%></td>	
				<td><s:property value="%{model.username}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SysUser.ALIAS_PASSWORD%></td>	
				<td><s:property value="%{model.password}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SysUser.ALIAS_NAME%></td>	
				<td><s:property value="%{model.name}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SysUser.ALIAS_EMAIL%></td>	
				<td><s:property value="%{model.email}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SysUser.ALIAS_PHONE_NUMBER%></td>	
				<td><s:property value="%{model.phoneNumber}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SysUser.ALIAS_PASSWORD_HINT%></td>	
				<td><s:property value="%{model.passwordHint}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SysUser.ALIAS_ACCOUNT_TYPE%></td>	
				<td><s:property value="%{model.accountTypeEnum}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SysUser.ALIAS_CREATE_DATE%></td>	
				<td><s:property value="%{model.createDateString}" /></td>
			</tr>
		</table>
	</s:form>
	<div align="center"><input type="button"  class="dialogclose"  value="关闭" onclick="window.close()"/></div>
</rapid:override>

<%@ include file="base.jsp" %>