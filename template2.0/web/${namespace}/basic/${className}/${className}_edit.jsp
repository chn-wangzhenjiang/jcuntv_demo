<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<#assign className = table.className>   
<#assign pkName = table.pkName>
<#assign lowerCasePKName = table.pkName?lower_case>
<#assign classNameLower = className?uncap_first>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		
		<meta charset="utf-8" />
		<title></title>
		
		<meta name="description" content="overview & stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="static/css/bootstrap.min.css" rel="stylesheet" />
		<link href="static/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="static/css/font-awesome.min.css" />
		<!-- 下拉框 -->
		<link rel="stylesheet" href="static/css/chosen.css" />
		
		<link rel="stylesheet" href="static/css/ace.min.css" />
		<link rel="stylesheet" href="static/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="static/css/ace-skins.min.css" />
		
		<link rel="stylesheet" href="static/css/datepicker.css" /><!-- 日期框 -->
		<link rel="stylesheet" href="static/css/bootstrap-timepicker.css" />
		<link rel="stylesheet" href="static/css/daterangepicker.css" />
		<link rel="stylesheet" href="static/css/colorpicker.css" />		
		<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="static/js/jquery.tips.js"></script>

	</head>
<body>
	<form  class="form-horizontal" action="${classNameLower}/${'$'}{msg}.do" name="myForm" id="myForm" method="post">
	<#list table.columns as column>
	<#if column.htmlHidden>
		<input type="hidden" id="${column.sqlName}" name="${column.sqlName}" value="${'$'}{pd.${column.sqlName}}" />
	</#if>
	</#list>
	<fieldset>
      <div id="legend" class="">
        <legend class="">表单名</legend>
      </div>     
			<#-- 定义要显示的列数 columnCount -->
<#assign columnCount = 2>
<#assign columns = table.columns>
<#-- 计算显示当前记录集需要的表格行数 rowCount -->
<#assign rowCount = table.columns?size-1>
<#if rowCount % columnCount == 0>
    <#assign rowCount = ( rowCount/ columnCount) - 1 >
<#else>
    <#assign rowCount = ( rowCount / columnCount) >
</#if>
<#-- 循环所有字段，如果是multiline,richtext就直接单行 -->
<#assign rowseq=1>
<#list columns as column>
<#if !column.htmlHidden>

	<div class="control-group">  
	 <label class="control-label">${column.columnAlias}</label>
	 <div class="controls">	
	<#if column.displayType="multiline">		   			 
            <div class="textarea">
                  <textarea type="" class="" id="${column.sqlName}" name="${column.sqlName}"> </textarea>
            </div>          
	<#else>	 	
			<#if column.isDateTimeColumn>			
				<input type="text" class="Wdate" id="${column.sqlName}AsString" name="${column.sqlName}AsString" style="width:140px" onFocus="new WdatePicker(this,'%Y-%M-%D %h:%m:%s',true)" value="${'$'}{pd.${column.sqlName}AsString}"/>
				
			<#elseif column.displayType="image">
								
			<#elseif column.displayType="popup">	
				<input type="hidden" id="${column.sqlName}" name="${column.sqlName}" value="${'$'}{pd.${column.sqlName}}" />
				<table border="0" cellpaccing="0" cellpadding="0" style="width:100%">
				<tr>
				<td style="border:0px;">
					<input ="text"  id="${column.fkalias}" name="${column.fkalias}" value="${'$'}{pd.${column.fkalias}}" cssClass="inputClass"  theme="simple" readonly="true" />
					
				</td>
				<td style="width:20px;border:0px;">
					<img src="static/images/getbyid.gif" onclick="selectItem('${column.fktableAsClassName}','${column.sqlName}','${column.fkalias}','${column.fkfilter}')"/>
				</td>
							
				</tr>
				</table>
			<#elseif column.displayType="efcdpopup">	
				<input type="hidden" id="${column.sqlName}" name="${column.sqlName}" value="${'$'}{pd.${column.sqlName}}" />
				<table border="0" cellpaccing="0" cellpadding="0" style="width:100%">
				<tr>
				<td style="width:20px;border:0px;">
					<img src="${'$'}{ctx}/images/edit/getbyid.gif" onclick="condSelectItem('${column.sqlName}','${column.fkalias}')"/>
				</td>
				<td style="border:0px;">
					<input type="text"  id="${column.fkalias}" name="${column.fkalias}" value="${'$'}{pd.${column.fkalias}}" cssClass="inputClass"  theme="simple" readonly="true" />		
				</td>			
				</tr>
				</table>
			<#elseif column.displayType="condpopup">	
				<table border="0" cellpaccing="0" cellpadding="0" style="width:100%">
				<tr>
				<td style="width:20px;border:0px;">
					<img src="${'$'}{ctx}/images/edit/getbyid.gif" onclick="condSelectItem('${column.sqlName}','${column.sqlName}Display')"/>
				</td>
				<td style="border:0px;">
					<input type="text" id="${column.sqlName}" name="${column.sqlName}" value="${'$'}{pd.${column.sqlName}}" cssClass="inputClass"  theme="simple" readonly="true" />
				</td>			
				</tr>
				</table>
			<#elseif column.displayType="file">
				<table border="0" cellpaccing="0" cellpadding="0" style="width:100%">
				<tr>
				<td style="width:20px;border:0px;">
					<img src="${'$'}{ctx}/images/edit/icon-upload.gif" onclick="selectFile('http','${table.className}','${column.sqlName}','${column.uploadfolder}')"/>
				</td>
				<td style="width:20px;border:0px;">
					<img src="${'$'}{ctx}/images/edit/icon-view.gif" border="0" onclick="viewfile('${column.sqlName}')"/>
				</td>
				<td style="border:0px;">									   								
					<input type="text" id="${column.sqlName}" name="${column.sqlName}" value="${'$'}{pd.${column.sqlName}}" cssClass="inputClass"  theme="simple"/>					
				</td>			
				</tr>
				</table>
			<#elseif column.displayType="imagefile">
				<table border="0" cellpaccing="0" cellpadding="0" style="width:100%">
				<tr>
				<td style="width:20px;border:0px;">
					<img src="${'$'}{ctx}/images/edit/getbyid.gif" onclick="selectFile('image','${table.className}','${column.sqlName}','${column.uploadfolder}')"/>
				</td>
				<td style="border:0px;">					
					<img id="img__${column.sqlName}" src="${'$'}{pd.${column.sqlName}}" width="30" height="30" border="0" onclick="viewimage('${column.sqlName}')"/>
					<input type="hidden" id="${column.sqlName}" name="${column.sqlName}" value="${'$'}{pd.${column.sqlName}}" />					
				</td>			
				</tr>
				</table>
			<#elseif column.displayType="httpfile">
				<table border="0" cellpaccing="0" cellpadding="0" style="width:100%">
				<tr>
				<td style="width:20px;border:0px;">
					<img src="${'$'}{ctx}/images/edit/getbyid.gif" onclick="selectFile('http','${table.className}','${column.sqlName}','${column.uploadfolder}')"/>
				</td>
				<td style="border:0px;">
					<input type="text" id="${column.sqlName}" name="${column.sqlName}" value="${'$'}{pd.${column.sqlName}}" cssClass="inputClass"  theme="simple"/>
				</td>			
				</tr>
				</table>
			<#elseif column.displayType="ftpfile">
				<table border="0" cellpaccing="0" cellpadding="0" style="width:100%">
				<tr>
				<td style="width:20px;border:0px;">
					<img src="${'$'}{ctx}/images/edit/getbyid.gif" onclick="selectFile('ftp','${table.className}','${column.sqlName}','${column.uploadfolder}')"/>
				</td>
				<td style="border:0px;">
					<input type="text" id="${column.sqlName}" name="${column.sqlName}" value="${'$'}{pd.${column.sqlName}}" cssClass="inputClass"  theme="simple"/>
				</td>			
				</tr>
				</table>	
			<#elseif column.displayType="combo">	
			<!--headerKey="0"   headerValue="请选择" -->
				<#if column.dataSrcType="1">									
						<select name="${column.sqlName}" id="${column.sqlName}" title="${column.sqlName}">						
						<#assign tmpenum= column.enumMap/>
						<#list tmpenum?keys as testKey> 
       						<option value="${testKey}"
       						 <c:if test="${'$'}{pd.${column.sqlName} == '${testKey}' }">selected = "selected"</c:if> >${tmpenum[testKey]}</option> 
						</#list>
						</select>						
				<#else>
					
				</#if>
			<#elseif column.displayType="unixtime">
				<#if column.editable="false">
					<input type="hidden" id="${column.sqlName}" name="${column.sqlName}" value="${'$'}{pd.${column.sqlName}}"/>
					<input type="text" id="${column.sqlName}AsDateTime" name="${column.sqlName}AsDateTime" value="${'$'}{pd.${column.sqlName}AsDateTime}" cssClass="inputClass" required="${(!column.nullable)?string}"  theme="simple" readonly="true"/>
				<#elseif column.generate=="">
					
					<input type="hidden" id="${column.sqlName}" name="${column.sqlName}" value="${'$'}{pd.${column.sqlName}}"/>				
	  				<#if column.dataformat="yyyy-MM-dd">
	  					<#if column.trigger!="">	
	  						<input type="text" class="Wdate" id="${column.sqlName}AsDateTime" name="${column.sqlName}AsDateTime" 
	  				style="width:80px" onFocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy-MM-dd',onpicked:function(dp){ trigger_onChange('${column.sqlName}','${column.trigger}'); return false;}})" value="${'$'}{pd.${column.sqlName}AsDateTime}"/>	  				
	  					<#else>
	  						<input type="text" class="Wdate" id="${column.sqlName}AsDateTime" name="${column.sqlName}AsDateTime" 
	  				style="width:80px" onFocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy-MM-dd'})" value="${'$'}{pd.${column.sqlName}AsDateTime}"/>	  				
	  					</#if>		
	  				<#else>
	  					<#if column.trigger!="">	
	  					<input type="text" class="Wdate" id="${column.sqlName}AsDateTime" name="${column.sqlName}AsDateTime" 
	  						style="width:140px" onFocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm:ss',onpicked:function(dp){ trigger_onChange('${column.sqlName}','${column.trigger}'); return false;}})" value="${'$'}{pd.${column.sqlName}AsDateTime}"/>
	  					<#else>
	  						<input type="text" class="Wdate" id="${column.sqlName}AsDateTime" name="${column.sqlName}AsDateTime" 
	  						style="width:140px" onFocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${'$'}{pd.${column.sqlName}AsDateTime}"/>
	  				
	  					</#if>
	  				</#if>
	  			
				<#else>
					<input type="hidden" id="${column.sqlName}" name="${column.sqlName}" value="${'$'}{pd.${column.sqlName}}"/>				
				</#if>
				
			<#elseif column.displayType="datetime">
				<#if column.editable="false">
					<input type="hidden" id="${column.sqlName}" name="${column.sqlName}" value="${'$'}{pd.${column.sqlName}}"/>					
				<#else>				
				<#if column.javaType="java.lang.Long">
				<#elseif column.isDateTimeColumn>			
					<input type="text" class="Wdate" id="${column.sqlName}AsString" name="${column.sqlName}AsString" style="width:140px" onFocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm:ss',onpicked:function(dp){ trigger_onChange('${column.sqlName}','${column.trigger}'); return false;}})" value="${'$'}{pd.${column.sqlName}AsString}"/>					
				<#else>
					<#if column.dataformat=="yyyy-MM-dd hh:mm:ss">
						<#if column.trigger!="">	
							<input type="text" class="Wdate" id="${column.sqlName}" name="${column.sqlName}" style="width:140px" onFocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm:ss',onpicked:function(dp){ trigger_onChange('${column.sqlName}','${column.trigger}'); return false;}})" value="${'$'}{pd.${column.sqlName}}"/>
						<#else>
						<input type="text" class="Wdate" id="${column.sqlName}" name="${column.sqlName}" style="width:140px" onFocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${'$'}{pd.${column.sqlName}}"/>						
						</#if>
					<#elseif column.dataformat=="yyyy-MM-dd">
						<#if column.trigger!="">	
							<input type="text" class="Wdate" id="${column.sqlName}" name="${column.sqlName}" style="width:140px" onFocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy-MM-dd',onpicked:function(dp){ trigger_onChange('${column.sqlName}','${column.trigger}'); return false;}})" value="${'$'}{pd.${column.sqlName}}"/>
						<#else>
							<input type="text" class="Wdate" id="${column.sqlName}" name="${column.sqlName}" style="width:140px" onFocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy-MM-dd'})" value="${'$'}{pd.${column.sqlName}}"/>
						</#if>					
					<#elseif column.dataformat=="yyyyMMdd">
						<#if column.trigger!="">	
							<input type="text" class="Wdate" id="${column.sqlName}" name="${column.sqlName}" style="width:140px" onFocus="WdatePicker({isShowWeek:true,dateFmt:'yyyyMMdd',onpicked:function(dp){ trigger_onChange('${column.sqlName}','${column.trigger}'); return false;}})" value="${'$'}{pd.${column.sqlName}}"/>
						<#else>
							<input type="text" class="Wdate" id="${column.sqlName}" name="${column.sqlName}" style="width:140px" onFocus="WdatePicker({isShowWeek:true,dateFmt:'yyyyMMdd'})" value="${'$'}{pd.${column.sqlName}}"/>
						</#if>										
					<#else>
						<#if column.trigger!="">	
							<input type="text" class="Wdate" id="${column.sqlName}" name="${column.sqlName}" style="width:140px" onFocus="WdatePicker({isShowWeek:true,dateFmt:'yyyyMMddHHmmss',onpicked:function(dp){ trigger_onChange('${column.sqlName}','${column.trigger}'); return false;}})" value="${'$'}{pd.${column.sqlName}}"/>
						<#else>
							<input type="text" class="Wdate" id="${column.sqlName}" name="${column.sqlName}" style="width:140px" onFocus="WdatePicker({isShowWeek:true,dateFmt:'yyyyMMddHHmmss'})" value="${'$'}{pd.${column.sqlName}}"/>
						</#if>
					</#if>
				</#if>
				</#if>
			<#elseif column.displayType="time">
				<input id="${column.sqlName}" name="${column.sqlName}" type="text" readonly class="inputClass" value="${'$'}{model.${column.sqlName}}"  onclick="_TimeCtrl_SetTime(this,'${column.dataformat}')"/>
			<#elseif column.displayType="password">	 
				<input type="password" id="${column.sqlName}" name="${column.sqlName}" value="${'$'}{pd.${column.sqlName}}" cssClass="inputClass" />
			<#elseif column.displayType="md5password">	 
				<input type="hidden" id="${column.sqlName}" name="${column.sqlName}" value="${'$'}{pd.${column.sqlName}}"/>				
				<input type="password" id="${column.sqlName}__md5" name="${column.sqlName}__md5" value="" cssClass="inputClass" />
				
			<#elseif column.displayType="md5password">
				<div class="span3">
						<label><input name="${column.sqlName}" class="ace-switch" type="checkbox" /><span class="lbl"></span></label>
				</div>
	 		<#else>						
				<#if column.editable="false">
	  				<input type="text" id="${column.sqlName}" name="${column.sqlName}" value="${'$'}{pd.${column.sqlName}}" readonly="readonly" />
	  			<#else>
	  				<#if column.trigger!="">	  				
	  					<input type="text" id="${column.sqlName}" name="${column.sqlName}" value="${'$'}{pd.${column.sqlName}}" onChange="trigger_onChange('${column.sqlName}','${column.trigger}')"/>
	  				<#else>
	  					<input type="text" id="${column.sqlName}" name="${column.sqlName}" value="${'$'}{pd.${column.sqlName}}"/>
	  				</#if>
	  			</#if>
	  		</#if>	  			
	</#if><#-- 非richtext & multiline -->
	<#assign rowseq=rowseq+1>
	  </div><!-- control -->
	</div><!-- control group -->
</#if>  <#-- !column.htmlHidden -->

</#list>
<#-- 增加一行补充，防止少了 -->
<#if rowseq%2!=1>
 	 <td class="tdLabel">&nbsp;</td>
	 <td class="tdField">&nbsp;</td>
  </tr>
</#if>
			<tr>
				<td class="center" colspan="4">
					<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
					<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
				</td>
			</tr>
		</table>
		</div>
		
		<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
		
	</form>
	
	
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/ace-elements.min.js"></script>
		<script src="static/js/ace.min.js"></script>
		<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript" src="static/js/bootstrap-timepicker.min.js"></script><!-- 时间 -->
		<script type="text/javascript">
		
		$(function() {
			
			//单选框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//日期框
			$('.date-picker').datepicker();
			
<#list table.columns as column>
	<#if column.htmlHidden>
				
			<#if column.displayType="time">
				${'$'}('#${column.sqlName}').timepicker({
					minuteStep: 1,
					showSeconds: true,
					showMeridian: false
				});
			</#if>
	</#if>
</#list>
			
			
		});
		

$(top.hangge());
	
	$(document).ready(function(){
		
	});
	
	function ismail(mail){
	return(new RegExp(/^(?:[a-zA-Z0-9]+[_\-\+\.]?)*[a-zA-Z0-9]+@(?:([a-zA-Z0-9]+[_\-]?)*[a-zA-Z0-9]+\.)+([a-zA-Z]{2,})+$/).test(mail));
	}
	
	//保存
	function save(){	
			$("#myForm").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();	
	}
		</script>
	
</body>
</html>