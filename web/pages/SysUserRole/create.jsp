<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<link href="<c:url value="/styles/common.css"/>" type="text/css" rel="stylesheet">
<rapid:override name="head">
	<title><%=SysUserRole.TABLE_ALIAS%>新增</title>
</rapid:override>

<rapid:override name="content">
	<s:form action="/pages/SysUserRole/save.do" method="post">
		
		<br>
		<table class="formTable">
		<%@ include file="form_include.jsp" %>
		</table>
		<table  ><tr><td class="buttoncss"></td><td>
		<input id="submitButton" name="submitButton" type="submit" value="提交" />
		<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/SysUserRole/list.do'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		</td></tr></table>
	</s:form>
	
	<script>
		
		new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
			var finalResult = result;
			
			//在这里添加自定义验证
			
			return disableSubmit(finalResult,'submitButton');
		}});
	</script>
</rapid:override>

<%@ include file="base.jsp" %>