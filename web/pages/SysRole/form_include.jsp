<%@page import="com.pkit.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->
	
	<s:textfield label="%{@com.pkit.model.SysRole@ALIAS_NAME}" key="name" value="%{model.name}" cssClass="required " required="true" />
	
	
	<s:textfield label="%{@com.pkit.model.SysRole@ALIAS_DESCRIPTION}" key="description" value="%{model.description}" cssClass="required " required="true" />
	
	
	<s:textfield label="%{@com.pkit.model.SysRole@ALIAS_LOCKED}" key="locked" value="%{model.locked}" cssClass="required validate-integer max-value-2147483647" required="true" />
	
