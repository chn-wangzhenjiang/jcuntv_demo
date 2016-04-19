<%@page import="com.pkit.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->
	
	<s:textfield label="%{@com.pkit.model.SysUserRole@ALIAS_USER_ID}" key="userId" value="%{model.userId}" cssClass="required validate-integer " required="true" />
	
	
	<s:textfield label="%{@com.pkit.model.SysUserRole@ALIAS_ROLE_ID}" key="roleId" value="%{model.roleId}" cssClass="required validate-integer " required="true" />
	
<s:select label="%{@com.pkit.model.SysUserRole@ALIAS_USER_ID}" name="user_id" listKey="user_id"  listValue="name" value="%{model.userId}"  list="%{user_idlists}" required="true" cssClass="comboxcss" />
	
	
						<s:select label="%{@com.pkit.model.SysUserRole@ALIAS_ROLE_ID}" name="role_id" listKey="role_id"  listValue="name" value="%{model.roleId}"  list="%{role_idlists}" required="true" cssClass="comboxcss" />