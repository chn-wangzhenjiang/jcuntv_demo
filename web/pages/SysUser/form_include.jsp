<%@page import="com.pkit.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->
	
	<s:textfield label="%{@com.pkit.model.SysUser@ALIAS_USERNAME}" key="username" value="%{model.username}" cssClass="required " required="true" />
	
	
	<s:textfield label="%{@com.pkit.model.SysUser@ALIAS_PASSWORD}" key="password" value="%{model.password}" cssClass="required " required="true" />
	
	
	<s:textfield label="%{@com.pkit.model.SysUser@ALIAS_NAME}" key="name" value="%{model.name}" cssClass="" required="false" />
	
	
	<s:textfield label="%{@com.pkit.model.SysUser@ALIAS_EMAIL}" key="email" value="%{model.email}" cssClass="validate-email " required="false" />
	
	
	<s:textfield label="%{@com.pkit.model.SysUser@ALIAS_PHONE_NUMBER}" key="phoneNumber" value="%{model.phoneNumber}" cssClass="" required="false" />
	
	
	<s:textfield label="%{@com.pkit.model.SysUser@ALIAS_PASSWORD_HINT}" key="passwordHint" value="%{model.passwordHint}" cssClass="" required="false" />
	
	
	<s:select label="%{@com.pkit.model.SysUser@ALIAS_ACCOUNT_TYPE}" key="accountType" value="%{model.accountType}" list="#{'1':'系统点数','2':'人民币','3':'美元'}" cssClass="comboxcss" required="false"/> 
	
	
	<tr>	
		<td class="tdLabel">
			<span class="required">*</span><%=SysUser.ALIAS_CREATE_DATE%>:
		</td>	
		<td>
		<input value="${model.createDateString}" onclick="WdatePicker({dateFmt:'<%=SysUser.FORMAT_CREATE_DATE%>'})" id="createDateString" name="createDateString"  maxlength="0" class="required " />
		</td>
	</tr>
	
