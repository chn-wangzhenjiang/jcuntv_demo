<%@page import="com.company.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>
	<link href="<c:url value="/widgets/simpletable/simpletable.css"/>" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="<c:url value="/widgets/simpletable/simpletable.js"/>"></script>
	
<div class="gridTable">
<simpletable:pageToolbar page="${page}">
			
		</simpletable:pageToolbar>
	
		<table width="100%"  border="0" cellspacing="0" class="gridBody">
		  <thead>
			  
			  <tr>
				<th style="width:1px;"> </th>
				<th style="width:1px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th sortColumn="username" ><%=SysUser.ALIAS_USERNAME%></th>
				<th sortColumn="password" ><%=SysUser.ALIAS_PASSWORD%></th>
				<th sortColumn="name" ><%=SysUser.ALIAS_NAME%></th>
				<th sortColumn="email" ><%=SysUser.ALIAS_EMAIL%></th>
				<th sortColumn="phone_number" ><%=SysUser.ALIAS_PHONE_NUMBER%></th>
				<th sortColumn="password_hint" ><%=SysUser.ALIAS_PASSWORD_HINT%></th>
				<th sortColumn="account_type" ><%=SysUser.ALIAS_ACCOUNT_TYPE%></th>
				<th sortColumn="create_date" ><%=SysUser.ALIAS_CREATE_DATE%></th>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="id=${item.id}&"></td>
				
				<td><c:out value='${item.username}'/>&nbsp;</td>
				<td><c:out value='${item.password}'/>&nbsp;</td>
				<td><c:out value='${item.name}'/>&nbsp;</td>
				<td><c:out value='${item.email}'/>&nbsp;</td>
				<td><c:out value='${item.phoneNumber}'/>&nbsp;</td>
				<td><c:out value='${item.passwordHint}'/>&nbsp;</td>
				<td><c:out value='${item.accountTypeEnum}'/>&nbsp;</td>
				<td><c:out value='${item.createDateString}'/>&nbsp;</td>
				<td>
					<a href="javascript:void(-1)" onclick="openPage('${ctx}/pages/SysUser/show.do?id=${item.id}&')">查看</a>&nbsp;&nbsp;&nbsp;
					<a href="${ctx}/pages/SysUser/edit.do?id=${item.id}&">修改</a>
				</td>
			  </tr>
			  
		  	  </c:forEach>
		  </tbody>
		</table>
	
		<simpletable:pageToolbar page="${page}">
		</simpletable:pageToolbar>

</div>
<script type="text/javascript" >
function openPage(url){
			openDialog(url,'myDialog',600,500,400,150);
		}
parent.document.getElementById("Container").innerHTML='';
</script>