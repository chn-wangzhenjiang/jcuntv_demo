<%@page import="${basepackage}.model.*" %>
<#include "/macro.include"/> 
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<link type="text/css" rel="stylesheet" href="${'$'}{ctx}/js/dialog/jquery_dialog.css" />
<script type="text/javascript" src="${'$'}{ctx}/js/dialog/jquery.js"></script>
<script type="text/javascript" src="${'$'}{ctx}/js/dialog/jquery_dialog.js"></script>
<script type="text/javascript" src="${'$'}{ctx}/js/validate.js"></script>
<script language="javascript" type="text/javascript" src="${'$'}{ctx}/js/datepicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="${'$'}{ctx}/js/mytimectrl.js"></script>
<link href="${'$'}{ctx}/js/datepicker/default/datepicker.css" rel="stylesheet" type="text/css"/>
<link href="${'$'}{ctx}/js/datepicker/whyGreen/datepicker.css" rel="stylesheet" type="text/css" disabled="disabled"/>


<script type="text/javascript">
	function validateinput()
	{ 
   <#list table.columns as column>		
		<#if column.validate!="">
			<#if column.displayType="popup">
			
				if(!${column.validate}(document.getElementById('${column.columnNameLower}'),'${column.remarks}','${column.size}')){
					return false;
				}
			<#elseif column.displayType="condpopup">
				if(!${column.validate}(document.getElementById('${column.columnNameLower}'),'${column.remarks}','${column.size}')){
					return false;
				}
			<#elseif column.displayType="combo">
				if(!${column.validate}(document.getElementById('${column.columnNameLower}'),'${column.remarks}','${column.size}')){
					return false;
				}
			<#elseif column.displayType="file">
				if(!${column.validate}(document.getElementById('${column.columnNameLower}'),'${column.remarks}','${column.size}')){
					return false;
				}
			<#elseif column.displayType="ftpfile">
				if(!${column.validate}(document.getElementById('${column.columnNameLower}'),'${column.remarks}','${column.size}')){
					return false;
				}
			<#elseif column.displayType="httpfile">
				if(!${column.validate}(document.getElementById('${column.columnNameLower}'),'${column.remarks}','${column.size}')){
					return false;
				}
			<#elseif column.displayType="datetime">	
				if(!${column.validate}(document.getElementById('${column.columnNameLower}'),'${column.remarks}','${column.size}')){
					return false;
				}
			<#elseif column.displayType="time">
				if(!${column.validate}(document.getElementById('${column.columnNameLower}'),'${column.remarks}','${column.size}')){
					return false;
				}
			<#else>
				<#if column.editable!="false">
				if(!${column.validate}(document.getElementById('${column.columnNameLower}'),'${column.remarks}','${column.size}')){
					return false;
				}
				</#if>				
			</#if>
		</#if>
   </#list>
		return true;
	}
 	function dialog_callback(result,idname,resultdata){
    	if(result=="ok"){
 	  		if(resultdata!=null)
 	 		{ 	
	 <#list table.columns as column>		
		<#if column.displayType="popup">
				if(idname=='${column.columnNameLower}'){
 					$('${'#'}'+idname).val(resultdata.${column.fkidcolumn});
 					$('${'#'}'+'${column.fkalias}').val(resultdata.${column.fknamecolumn});
 					$('${'#'}'+'${column.fkalias}').focus();
 				}
 		<#elseif column.displayType="efcdpopup">
				if(idname=='${column.columnNameLower}'){
 					$('${'#'}'+idname).val(resultdata.${column.fkidcolumn});
 					$('${'#'}'+'${column.fkalias}').val(resultdata.${column.fknamecolumn});
 					$('${'#'}'+'${column.fkalias}').focus();
 				}
 		<#elseif column.displayType="condpopup">
 			<#if column.dataSrcType="2">
 			  	if(idname=='${column.columnNameLower}'){
				<#list column.dataSrcList as item>
					 	<#if item_index=0> 
					if(tmpcondvalue=='${item.key}')
					{
 						$('${'#'}'+idname).val(resultdata.${item.fkidcolumn});
 						<#list column.otherFieldsList as otheritem>
 							$('${'#'}${otheritem?uncap_first}').val(resultdata.${item.fknamecolumn});
 						</#list>
 						$('${'#'}'+idname).focus();

 					}
 						<#else>
 					else if(tmpcondvalue=='${item.key}')
					{
 						$('${'#'}'+idname).val(resultdata.${item.fkidcolumn});
 						<#list column.otherFieldsList as otheritem>
 							$('${'#'}${otheritem?uncap_first}').val(resultdata.${item.fknamecolumn});
 						</#list>
 						$('${'#'}'+idname).focus();
 					}	
 					</#if>
				</#list> 				
 			}
 			</#if>
	 	</#if>	 		 
	  </#list>		
 	  }
 	}else if(result=="empty"){

<#list table.columns as column>		
		<#if column.displayType="popup">
			if(idname=='${column.columnNameLower}'){
 				$('${'#'}'+idname).val("");
 				$('${'#'}'+'${column.fkalias}').val("");
 				$('${'#'}'+'${column.fkalias}').focus();
 			}
 		<#elseif column.displayType="efcdpopup">
			if(idname=='${column.columnNameLower}'){
 				$('${'#'}'+idname).val("");
 				$('${'#'}'+'${column.fkalias}').val("");
 				$('${'#'}'+'${column.fkalias}').focus();
 			}
 		<#elseif column.displayType="condpopup">
 			<#if column.dataSrcType="2">
 			  if(idname=='${column.columnNameLower}'){
				<#list column.dataSrcList as item>
					 	<#if item_index=0> 
					if(tmpcondvalue=='${item.key}')
					{
 						$('${'#'}'+idname).val("");
 						<#list column.otherFieldsList as otheritem>
 							$('${'#'}${otheritem?uncap_first}').val("");
 						</#list>
 						$('${'#'}'+idname).focus();

 					}
 						<#else>
 					else if(tmpcondvalue=='${item.key}')
					{
 						$('${'#'}'+idname).val("");
 						<#list column.otherFieldsList as otheritem>
 							$('${'#'}${otheritem?uncap_first}').val("");
 						</#list>
 						$('${'#'}'+idname).focus();
 					}	
 					</#if>
				</#list> 				
 			}
 			</#if>
	 	</#if>	 		 
	  </#list>		 	
 		}
 	}
  	function selectItem(s,idname,namefield,c){
 		JqueryDialog.Open1(dialog_callback,idname,'选择', '${'$'}{ctx}/selectDispatch.do?mode=1&s='+s+'&c='+c, 620, 350,true,true,true,true);
  	}
	function viewimage(id){
  		var tmpurl = document.getElementById(id).src;
  		window.open(tmpurl);
  	}
  	function viewfile(filename){
  			var tmpurl = '<s:property value="%{resourcebase}"/>'+'/'+filename;
  			window.open(tmpurl);
  	}
	function   downloadfile(filename)
	{  	
		var tmpurl = '<s:property value="%{resourcebase}"/>'+'/'+filename;
		if(document.all.a1==null)
		{  
				objIframe=document.createElement("IFRAME");  
				document.body.insertBefore(objIframe); 
				objIframe.outerHTML=   "<iframe   name=a1   style='width:0;hieght:0'   src="+tmpurl+"></iframe>";  
				re=setTimeout("savepic()",1)  
		}  
		else
		{  
				clearTimeout(re)  
				pic   =   window.open(tmpurl,"a1")  
				pic.document.execCommand("SaveAs")  
				document.all.a1.removeNode(true)  
		}
	}  
 
	function dialog_filecallback(result,idname,resultdata){
 		if(resultdata!=null){
 			$('${'#ahref__'}'+idname).attr('href',resultdata.filename);
 			$('${'#'}'+idname).val(resultdata.filename);//resultdata.fullurl
 			$('${'#'}'+idname).focus();
		} 	
	}
 
   	function dialog_imagecallback(result,idname,resultdata){
 		if(resultdata!=null){
 			$('${'#ahref__'}'+idname).attr('href',resultdata.filename);
 			$('${'#'}'+idname).val(resultdata.filename);
 			$('${'#img__'}'+idname).attr('src',resultdata.filename); 		
 		} 	
  	}
  	function dialog_ftpfilecallback(result,idname,resultdata){
 		if(resultdata!=null){
 			$('${'#'}'+idname).val(resultdata.fullftpurl);
 			$('${'#'}'+idname).focus();
 		}
 	}
 	function selectFile(type,s,idname){
 		if(type=='ftp')
 			JqueryDialog.Open(dialog_ftpfilecallback,idname,'选择', '${'$'}{ctx}/fileBrowser.do', 720, 400);
 		else if(type=='image')
 		 	JqueryDialog.Open(dialog_imagecallback,idname,'选择', '${'$'}{ctx}/upload.jsp', 720, 400);
 		else JqueryDialog.Open(dialog_filecallback,idname,'选择', '${'$'}{ctx}/upload.jsp', 720, 400);
 	
 	}
 	function condSelectItem(idname,namefield){
  		var s="";
  		var c="";
 	<#list table.columns as column> 		
 		<#if column.displayType="efcdpopup">
		if(idname=='${column.columnNameLower}')
		{
			tmpcondvalue = ${'$'}('${'#'}${column.cond?uncap_first}').val();
			
			s = '${column.fktable?substring(2)}'; 
			<#--&efcd=value1:1:abcd;value2:1:abcd; -->
			c = '${column.fkcondcolumn}'+':1:'+tmpcondvalue; 			
		} 		
 		<#elseif column.displayType="condpopup">	
 		if(idname=='${column.columnNameLower}')
 		{
			tmpcondvalue = ${'$'}('${'#'}${column.cond?uncap_first}').val();
			<#if column.dataSrcType="2">
 				<#list column.dataSrcList as item>
 			 	<#if item_index=0> 
			if(tmpcondvalue=='${item.key}')
				<#else>
			else if(tmpcondvalue=='${item.key}')			
				</#if>
			{
				s = '${item.fktable?substring(2)}';  
			} 
 				</#list>
			</#if>
		}
  		</#if>
 	</#list>
  		selectItem(s,idname,namefield,c);
	}
</script>
<s:hidden id="efcd" name="efcd" value="%{efcd}"/>
<s:hidden id="efbuttons" name="efbuttons" value="%{efbuttons}"/>
<s:hidden id="efgridHeight" name="efgridHeight" value="%{efgridHeight}"/>
<s:hidden id="efrowNum" name="efrowNum" value="%{efrowNum}"/>
<s:hidden id="efrowList" name="efrowList" value="%{efrowList}"/>
<s:hidden id="efpopup" name="efpopup" value="%{efpopup}"/>

<#list table.columns as column>
<#if column.htmlHidden>
	<s:hidden id="${column.columnNameLower}" name="${column.columnNameLower}" />
</#if>
</#list>
<!-- ONGL access static field: @package.class@field or @vs@field --> 
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
    <#-- 如果当前是奇数行就有换行-->
    <#if rowseq%2==1>
    	<tr>
    </#if>   
	<#if column.displayType="multiline">	
	    <#-- 如果前面有一个字段显示了，当前就是偶数字段，那么应该让前面的单独一行-->
	    <#if rowseq%2==0>
	    	 <td class="tdLabel">&nbsp;</td>
	 		 <td class="tdField">&nbsp;</td>
  		   </tr>
  		   <tr>
	    </#if>	
	    <td class="tdLabel">  			
			<#if !column.nullable><span class="required">*</span>
			<#elseif column.mandatory==1>
				<span class="required">*</span>
			<#elseif column.generate!="">
  				<span class="required">A</span>  			
			</#if>
			<%=${className}.ALIAS_${column.constantName}%>:&nbsp;
		</td>	
		<td class="tdField" colspan="3">
			<s:textarea label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.columnNameLower}" name="${column.columnNameLower}" value="%{model.${column.columnNameLower}}" cssClass="inputClass" required="${(!column.nullable)?string}" rows="10" theme="simple"/>
		</td>		
		<#if rowseq%2==0>
			<#assign rowseq=rowseq+2> <#-- 跳过一个字段显示位置-->
		<#else>
			<#assign rowseq=rowseq+1> <#-- 跳过一个字段显示位置-->
		</#if>						
	<#else>
	 		<td class="tdLabel">  			
				<#if !column.nullable><span class="required">*</span>
				<#elseif column.mandatory==1>
					<span class="required">*</span>
				<#elseif column.generate!="">
  					<span class="required">A</span>  			
				</#if>
				<%=${className}.ALIAS_${column.constantName}%>:&nbsp;
			</td>	
			<td class="tdField">
			<#if column.isDateTimeColumn>			
				<input type="text" class="Wdate" id="${column.columnNameLower}AsString" name="${column.columnNameLower}AsString" style="width:140px" onFocus="new WdatePicker(this,'%Y-%M-%D %h:%m:%s',true)" value="${'$'}{model.${column.columnNameLower}AsString}"/>
			<#elseif column.displayType="image">
								
			<#elseif column.displayType="popup">	
				<s:hidden id="${column.columnNameLower}" name="${column.columnNameLower}" />
				<table border="0" cellpaccing="0" cellpadding="0" style="width:100%">
				<tr>
				<td style="width:20px;border:0px;">
					<img src="${'$'}{ctx}/images/edit/getbyid.gif" onclick="selectItem('${column.fktableAsClassName}','${column.columnNameLower}','${column.fkalias}','${column.fkfilter}')"/>
				</td>
				<td style="border:0px;">
					<s:textfield label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.fkalias}" name="${column.fkalias}" value="%{model.${column.fkalias}}" cssClass="inputClass"  theme="simple" readonly="true" />
				</td>			
				</tr>
				</table>
			<#elseif column.displayType="efcdpopup">	
				<s:hidden id="${column.columnNameLower}" name="${column.columnNameLower}" />
				<table border="0" cellpaccing="0" cellpadding="0" style="width:100%">
				<tr>
				<td style="width:20px;border:0px;">
					<img src="${'$'}{ctx}/images/edit/getbyid.gif" onclick="condSelectItem('${column.columnNameLower}','${column.fkalias}')"/>
				</td>
				<td style="border:0px;">
					<s:textfield label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.fkalias}" name="${column.fkalias}" value="%{model.${column.fkalias}}" cssClass="inputClass"  theme="simple" readonly="true" />		
				</td>			
				</tr>
				</table>
			<#elseif column.displayType="condpopup">	
				<table border="0" cellpaccing="0" cellpadding="0" style="width:100%">
				<tr>
				<td style="width:20px;border:0px;">
					<img src="${'$'}{ctx}/images/edit/getbyid.gif" onclick="condSelectItem('${column.columnNameLower}','${column.columnNameLower}Display')"/>
				</td>
				<td style="border:0px;">
					<s:textfield label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.columnNameLower}" name="${column.columnNameLower}" value="%{model.${column.columnNameLower}}" cssClass="inputClass"  theme="simple" readonly="true" />
				</td>			
				</tr>
				</table>
			<#elseif column.displayType="file">
				<table border="0" cellpaccing="0" cellpadding="0" style="width:100%">
				<tr>
				<td style="width:20px;border:0px;">
					<img src="${'$'}{ctx}/images/edit/icon-upload.gif" onclick="selectFile('http','${table.className}','${column.columnNameLower}')"/>
				</td>
				<td style="width:20px;border:0px;">
					<img src="${'$'}{ctx}/images/edit/icon-view.gif" border="0" onclick="viewfile('<s:property value="%{model.${column.columnNameLower}}"/>')"/>
				</td>
				<td style="border:0px;">									   								
					<s:textfield label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.columnNameLower}" name="${column.columnNameLower}" value="%{model.${column.columnNameLower}}" cssClass="inputClass"  theme="simple"/>					
				</td>			
				</tr>
				</table>
			<#elseif column.displayType="imagefile">
				<table border="0" cellpaccing="0" cellpadding="0" style="width:100%">
				<tr>
				<td style="width:20px;border:0px;">
					<img src="${'$'}{ctx}/images/edit/getbyid.gif" onclick="selectFile('image','${table.className}','${column.columnNameLower}')"/>
				</td>
				<td style="border:0px;">					
					<img id="img__${column.columnNameLower}" src="<s:property value="resourcebase"/>/<s:property value="%{model.${column.columnNameLower}}"/>" width="30" height="30" border="0" onclick="viewimage('img__${column.columnNameLower}')"/>
					<s:hidden id="${column.columnNameLower}" name="${column.columnNameLower}" value="%{model.${column.columnNameLower}}" />					
				</td>			
				</tr>
				</table>
			<#elseif column.displayType="httpfile">
				<table border="0" cellpaccing="0" cellpadding="0" style="width:100%">
				<tr>
				<td style="width:20px;border:0px;">
					<img src="${'$'}{ctx}/images/edit/getbyid.gif" onclick="selectFile('http','${table.className}','${column.columnNameLower}')"/>
				</td>
				<td style="border:0px;">
					<s:textfield label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.columnNameLower}" name="${column.columnNameLower}" value="%{model.${column.columnNameLower}}" cssClass="inputClass"  theme="simple"/>
				</td>			
				</tr>
				</table>
			<#elseif column.displayType="ftpfile">
				<table border="0" cellpaccing="0" cellpadding="0" style="width:100%">
				<tr>
				<td style="width:20px;border:0px;">
					<img src="${'$'}{ctx}/images/edit/getbyid.gif" onclick="selectFile('ftp','${table.className}','${column.columnNameLower}')"/>
				</td>
				<td style="border:0px;">
					<s:textfield label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.columnNameLower}" name="${column.columnNameLower}" value="%{model.${column.columnNameLower}}" cssClass="inputClass"  theme="simple"/>
				</td>			
				</tr>
				</table>	
			<#elseif column.displayType="combo">	
			<!--headerKey="0"   headerValue="请选择" -->
				<s:select label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.columnNameLower}" name="${column.columnNameLower}" value="%{model.${column.columnNameLower}}" list="${column.enumComboxList}" cssClass="comboxcss" required="${(!column.nullable)?string}" theme="simple"/>	
			<#elseif column.displayType="unixtime">
				<#if column.generate=="">
					
					<s:hidden id="${column.columnNameLower}" name="${column.columnNameLower}" value="%{model.${column.columnNameLower}}"/>				
	  				<input type="text" class="Wdate" id="${column.columnNameLower}AsDateTime" name="${column.columnNameLower}AsDateTime" 
	  				style="width:140px" onFocus="new WdatePicker(this,'%Y-%M-%D %h:%m:%s',true)" value="<s:property value="%{model.${column.columnNameLower}AsDateTime}"/>"/>
	  			
	  			
				<#else>
					<s:hidden id="${column.columnNameLower}" name="${column.columnNameLower}" value="%{model.${column.columnNameLower}}"/>
					<s:label value="%{model.${column.columnNameLower}AsDateTime}" theme="simple"/>					
				</#if>
				
			<#elseif column.displayType="datetime">								
				<#if column.javaType="java.lang.Long">
				<#elseif column.isDateTimeColumn>			
					<input type="text" class="Wdate" id="${column.columnNameLower}AsString" name="${column.columnNameLower}AsString" style="width:140px" onFocus="new WdatePicker(this,'%Y-%M-%D %h:%m:%s',true)" value="${'$'}{model.${column.columnNameLower}AsString}"/>					
				<#else>
					<#if column.dataformat=="yyyy-MM-dd hh:mm:ss">
						<input type="text" class="Wdate" id="${column.columnNameLower}" name="${column.columnNameLower}" style="width:140px" onFocus="new WdatePicker(this,'%Y-%M-%D %h:%m:%s',true)" value="${'$'}{model.${column.columnNameLower}}"/>
					<#elseif column.dataformat=="yyyy-MM-dd">
						<input type="text" class="Wdate" id="${column.columnNameLower}" name="${column.columnNameLower}" style="width:140px" onFocus="new WdatePicker(this,'%Y-%M-%D',true)" value="${'$'}{model.${column.columnNameLower}}"/>					
					<#elseif column.dataformat=="yyyyMMdd">
						<input type="text" class="Wdate" id="${column.columnNameLower}" name="${column.columnNameLower}" style="width:140px" onFocus="new WdatePicker(this,'%Y%M%D',true)" value="${'$'}{model.${column.columnNameLower}}"/>										
					<#else>
						<input type="text" class="Wdate" id="${column.columnNameLower}" name="${column.columnNameLower}" style="width:140px" onFocus="new WdatePicker(this,'%Y%M%D%h%m%s',true)" value="${'$'}{model.${column.columnNameLower}}"/>
					</#if>
				</#if>
			<#elseif column.displayType="time">
				<input id="${column.columnNameLower}" name="${column.columnNameLower}" type="text" readonly class="inputClass" value="${'$'}{model.${column.columnNameLower}}"  onclick="_TimeCtrl_SetTime(this,'${column.dataformat}')"/>
			<#elseif column.displayType="password">	 
				<s:password showPassword="true" label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.columnNameLower}" name="${column.columnNameLower}" value="%{model.${column.columnNameLower}}" cssClass="inputClass" required="${(!column.nullable)?string}"  theme="simple"/>
			<#elseif column.displayType="md5password">	 
				<s:hidden id="${column.columnNameLower}" name="${column.columnNameLower}" value="%{model.${column.columnNameLower}}"/>				
				<s:password label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.columnNameLower}__md5" name="${column.columnNameLower}__md5" value="" cssClass="inputClass" required="${(!column.nullable)?string}"  theme="simple"/>			
			<#else>						
				<#if column.editable="false">
	  				<s:textfield label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.columnNameLower}" name="${column.columnNameLower}" value="%{model.${column.columnNameLower}}" cssClass="inputClass" required="${(!column.nullable)?string}"  theme="simple" readonly="true"/>
	  			<#else>
	  				
	  				<s:textfield label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.columnNameLower}" name="${column.columnNameLower}" value="%{model.${column.columnNameLower}}" cssClass="inputClass" required="${(!column.nullable)?string}"  theme="simple"/>
	  			</#if>
	  		</#if>	  		
	  	</td>	
	</#if><#-- 非richtext & multiline -->
	<#assign rowseq=rowseq+1>
	<#if rowseq%2==1>
		</tr>
	</#if>
</#if>  <#-- !column.htmlHidden -->

</#list>
<#-- 增加一行补充，防止少了 -->
<#if rowseq%2!=1>
 	 <td class="tdLabel">&nbsp;</td>
	 <td class="tdField">&nbsp;</td>
  </tr>
</#if>