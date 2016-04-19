<%@page import="com.company.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ include file="/commons/taglibs.jsp" %>
<link href="<c:url value="/styles/common.css"/>" type="text/css" rel="stylesheet">

<div id="Container"><table class="loadingTable"><tr class="loadingTabletr" align="center"><td><img src='${ctx}/images/loading.gif'/></td></tr></table></div>
	
<div id="gridFrameDiv" class="gridFrameDivcss" ><iframe id="gridFrame"  name="gridFrame" class="iframeGridcss" src="${ctx}/pages/SysUser/list.do"></iframe></div>
	

