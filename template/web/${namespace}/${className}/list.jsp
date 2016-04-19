<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#assign className = table.className>   
<#assign pkName = table.pkName>
<#assign lowerCasePKName = table.pkName?lower_case>
<#assign classNameLower = className?uncap_first>

<%@page import="com.micet.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<head> 	
<#assign havecondsearch=0>
<#-- 此处是注释ut ui-lightness, redmond--> 
 	<sj:head locale='zh_CN' jqueryui="true" jquerytheme="redmond" /> 	
 	<title><%=${className}.TABLE_ALIAS%></title>
    <style type="text/css">
     .ui-jqgrid{
      	font-size:12px;
      }    
     
    </style>
	<link rel="stylesheet" href="${'$'}{ctx}/styles/global.css" />
	<script language="javascript" src="${'$'}{ctx}/js/flydiv.js"></script>	
	<link type="text/css" rel="stylesheet" href="${'$'}{ctx}/js/dialog/jquery_dialog.css" />
	<script type="text/javascript" src="${'$'}{ctx}/js/dialog/jquery_dialog.js"></script>
	<script language="javascript" src="${'$'}{ctx}/js/global.js?randomId=<%=Math.random()%>"></script>	
	<title><%=${className}.TABLE_ALIAS%></title>		
	<script type="text/javascript" >
		var efcd ="<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efcd"))%>";
		var efbuttons ="<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efbuttons"))%>";

<#if table.listheight="">
		var efgridHeight ="<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efgridHeight"))%>";
<#else>
		var efgridHeight ="<%=com.micet.utils.SafeUtils.getString(request.getAttribute("gridHeight"))%>";
</#if>		
		var efrowNum ="<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efrowNum"))%>";
		var efrowList ="<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efrowList"))%>";
		var efpopup="<%=com.micet.utils.SafeUtils.getString(request.getAttribute("efpopup"))%>";
		$(document).ready(function() {
			 
			});
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
		function openPage(url){
			openDialog(url,'myDialog',600,500,400,150);
		}
		function action(optip,opname,params){
			_aIDs = $("#gridtable").jqGrid('getGridParam','selarrrow');
			var tmpitems="";
			var tmparray = new Array();
			if(_aIDs.length>0)
			{
					for (var i=0; i < _aIDs.length; i++) {
    	 				var rowData = $("#gridtable").jqGrid("getRowData", _aIDs[i]);
    	 				if(tmpitems!="")tmpitems+=",";    	 			
    	 				//tmpitems+=rowData.PKID;
    	 				tmpitems += rowData.${pkName};
    	 				tmparray.push(rowData);
    	 			}    	 	    
    	 	}		    	
    	 	 
			if(jsActionHook('${'$'}{ctx}','${className}',optip,opname,params,"Array",tmpitems,efcd)==1){
				return;
			}
			
			if(_aIDs.length>0)
			{
				if(window.confirm('您确认要'+optip+'选择的这些项吗?'))
				{
													
					var tmpurl="${'$'}{ctx}/json/${className}/action.do?opname="+opname+"&opparam="+params+"&ids="+tmpitems;
    	 		   	$.ajax({  
        				async : false,  
        				cache:false,  
        				type: 'POST',  
			        	dataType : "json",  
        				url:   tmpurl,  
        				error: function () {  
            			alert(optip+'失败');  
        				},  
        				success:function(data){      
            				refresh();
        				}  
    				});      	 			
    			}
    	 	}    
		}
		function view(){
			s = $("#gridtable").jqGrid('getGridParam','selrow');//selarrrow');
			if((s!=null)&&(s!=undefined))
			{
    	 		var rowData = $("#gridtable").jqGrid("getRowData", s);
    	 		if((rowData!=null)&&(rowData!=undefined))
    	 		{
    	 			if(jsActionHook('${'$'}{ctx}','${className}','查看','VIEW','','PKID',rowData.${pkName},efcd)==1)    	 			
						return;			
					window.location.href="${'$'}{ctx}/pages/${className}/show.do?${lowerCasePKName}="+rowData.${pkName}+"&efcd="+efcd+"&efrowList="+efrowList+"&efrowNum="+efrowNum+"&efgridHeight="+efgridHeight+"&efbuttons="+efbuttons+"&efpopup="+efpopup;
<#--    	 			//window.location.href="${'$'}{ctx}/pages/${className}/show.do?pkid="+rowData.PKID+"&efcd="+efcd;
    	 			//window.open ('${'$'}{ctx}/pages/${className}/show.do?pkid='+rowData.PKID, 'newwindow', 'height=100, width=400, top=0, left=0, toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, status=no');
-->    	 			 
    	 			
    	 		}
    	 	}   
		}
		function exportxls(){
			if(jsActionHook('${'$'}{ctx}','${className}','导出','EXPORTXLS','','NULL','',efcd)==1)
				return;
			window.location.href="${'$'}{ctx}/exportxls.do?tablename=${className}&opname=exportxls&efcd="+efcd+"&efrowList="+efrowList+"&efrowNum="+efrowNum+"&efgridHeight="+efgridHeight+"&efbuttons="+efbuttons+"&efpopup="+efpopup;
		}
		function add(){
			if(jsActionHook('${'$'}{ctx}','${className}','添加','ADD','','NULL','',efcd)==1)
				return;
			window.location.href="${'$'}{ctx}/pages/${className}/create.do?efcd="+efcd+"&efrowList="+efrowList+"&efrowNum="+efrowNum+"&efgridHeight="+efgridHeight+"&efbuttons="+efbuttons+"&efpopup="+efpopup;
		}
		function edit(){
			s = $("#gridtable").jqGrid('getGridParam','selrow');//selarrrow');
			if((s!=null)&&(s!=undefined))
			{
    	 		var rowData = $("#gridtable").jqGrid("getRowData", s);
    	 		if((rowData!=null)&&(rowData!=undefined))
    	 		{
    	 			if(jsActionHook('${'$'}{ctx}','${className}','编辑','UPDATE','','PKID',rowData.${pkName},efcd)==1)    	 			
						return;
					window.location.href="${'$'}{ctx}/pages/${className}/edit.do?${lowerCasePKName}="+rowData.${pkName}+"&efcd="+efcd+"&efrowList="+efrowList+"&efrowNum="+efrowNum+"&efgridHeight="+efgridHeight+"&efbuttons="+efbuttons+"&efpopup="+efpopup;

<#--    	 			//window.location.href="${'$'}{ctx}/pages/${className}/edit.do?pkid="+rowData.PKID+"&efcd="+efcd;
-->
    	 		}
    	 	}   
		}
		function remove(){
			if(jsActionHook('${'$'}{ctx}','${className}','删除','DELETE','','NULL','',efcd)==1)
				return;
			
			_aIDs = $("#gridtable").jqGrid('getGridParam','selarrrow');
			if(_aIDs.length>0)
			{
				if(window.confirm('您确认要删除选择的这些项吗?'))
				{
			    var tmpitems="";
				for (var i=0; i < _aIDs.length; i++) {
    	 			var rowData = $("#gridtable").jqGrid("getRowData", _aIDs[i]);
    	 			//jsRemove(rowData.PKID);
    	 			if(tmpitems!="")tmpitems+=",";    	 			
    	 			//tmpitems+=rowData.PKID;
    	 			tmpitems+=rowData.${pkName};
    	 		}
    	 		   $.ajax({  
        async : false,  
        cache:false,  
        type: 'POST',  
        dataType : "json",  
        url: "${'$'}{ctx}/json/${className}/delete.do?ids="+tmpitems+"&efcd="+efcd+"&efrowList="+efrowList+"&efrowNum="+efrowNum+"&efgridHeight="+efgridHeight+"&efpopup="+efpopup, 
        error: function () {  
            alert('删除失败');  
        },  
        success:function(data){    
            //alert(data.nodes);  
            refresh();
        }  
    });      	 			
    }
    	 	}         
		}	
		function refresh(){
			$("#gridtable").trigger("reloadGrid");
		}
		function onmyrowdblclick()
		{
			return false;
		}
		$.subscribe('rowselect', function(event,data){
	 	//alert(data);
	 	tmpviewrowid = event.originalEvent.id;
	 	var rowData = $("#gridtable").jqGrid("getRowData",tmpviewrowid);
	 	//alert(rowData.ID);
	 	});
		
		function dosearch(){
		 	var tmpsearchcond="";
			var rules = "";		 	
		 	<#list table.columns as column>
				<#if column.condsearch="1">	
				<#assign havecondsearch=1>			
			if(${'$'}("${'#'}chk__${column.columnNameLower}").is(':checked'))
			{
					 	tmpfieldname ="${column.columnNameLower}"
					<#if column.displayType="combo">
						tmpfieldvalue = document.getElementById('${column.columnNameLower}').value;
						tmpop='eq';							
					<#elseif column.displayType="unixtime">
						  				  	
					<#elseif column.displayType="popup">	
						tmpfieldvalue = document.getElementById('${column.columnNameLower}').value;
						tmpop='eq';								
					<#elseif column.displayType="efcdpopup">
						tmpfieldvalue = document.getElementById('${column.columnNameLower}').value;
						tmpop='eq';		
					<#elseif column.displayType="condpopup">
						tmpfieldvalue = document.getElementById('${column.columnNameLower}').value;
						tmpop='eq';		
					<#else>			
						tmpfieldvalue = document.getElementById('${column.columnNameLower}').value;
						<#if column.sqlTypeName="varchar">									
						tmpop='cn';
						<#else>
						tmpop = 'eq';			  		
						</#if>						
		 	  		</#if>
		 	   //eq 等于   cn 包含    如果数字用eq,如果字符串用cn
		 	   		if(tmpfieldname!="")
    					rules +=',{"field":"'+tmpfieldname + '","op":"' +tmpop+ '","data":"'+ tmpfieldvalue  +'"}';
			}
   				</#if>
    		</#list>  
		    if(rules) { //(6)如果rules不为空，且长度大于0，则去掉开头的逗号  
       			rules = rules.substring(1);  
     		}
    		//(7)串联好filtersStr字符串  
   			var filtersStr = '{"groupOp":"AND","rules":[' + rules + ']}';       
    		var postData = $("#gridtable").jqGrid("getGridParam", "postData");       
    		//(8)将filters参数串加入postData选项  
   			$.extend(postData, {filters: filtersStr});       
   			$("#gridtable").jqGrid("setGridParam", {  
       			search:  true    //(9)将jqGrid的search选项设为true  
   			}).trigger("reloadGrid", [{page:1}]);   //(10)重新载入Grid表格  
    
    		

		}
		
		
        Date.prototype.pattern=function(fmt) {       
     var o = {        
     "M+" : this.getMonth()+1, //月份       
     "d+" : this.getDate(), //日       
     "h+" : this.getHours() == 0 ? 12 : this.getHours(), //小时       
     "H+" : this.getHours(), //小时       
     "m+" : this.getMinutes(), //分       
     "s+" : this.getSeconds(), //秒       
     "q+" : Math.floor((this.getMonth()+3)/3), //季度       
     "S" : this.getMilliseconds() //毫秒       
     };       
     var week = {       
     "0" : "\u65e5",       
     "1" : "\u4e00",       
     "2" : "\u4e8c",       
     "3" : "\u4e09",       
     "4" : "\u56db",       
     "5" : "\u4e94",       
     "6" : "\u516d"      
     };       
     if(/(y+)/.test(fmt)){       
         fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));       
     }       
     if(/(E+)/.test(fmt)){       
         fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "\u661f\u671f" : "\u5468") : "")+week[this.getDay()+""]);       
     }       
     for(var k in o){       
         if(new RegExp("("+ k +")").test(fmt)){       
             fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));       
         }       
     }       
     return fmt;       
  }  
	function getFormatUnixTimeOnlyDate(cellvalue, options, rowObject){
          var tmpvalue="";
          if((cellvalue!=null)&&(cellvalue!="")&&(cellvalue!="0")){
        	var unixTimestamp = new Date(parseInt(cellvalue)* 1000);
        	tmpvalue = unixTimestamp.pattern("yyyy-MM-dd");
          }
          return tmpvalue;
	}
	function getFormatUnixTime(cellvalue, options, rowObject){
          var tmpvalue="";
          if((cellvalue!=null)&&(cellvalue!="")&&(cellvalue!="0")){
        	var unixTimestamp = new Date(parseInt(cellvalue)* 1000);
        	tmpvalue = unixTimestamp.pattern("yyyy-MM-dd HH:mm:ss");
          }
          return tmpvalue;
    }
        <#list table.columns as column>
			<#if !column.htmlHidden>
					<#if column.displayType="combo">
	function getDisplay${column.sqlName}(cellvalue, options, rowObject){
        					var tmpdisplay="";
        					var tmpstr = ";${column.dataSrc};";
        				    var tmpvalue=""+cellvalue;
        					var tmpindex = tmpstr.indexOf(";"+tmpvalue+":");
        					if(tmpindex!=-1){
        						var tmpendindex = tmpstr.indexOf(";",tmpindex+tmpvalue.length+2);        						
        						if(tmpendindex==-1)tmpendindex = tmpstr.length;        						
        						tmpindex +=tmpvalue.length+2;
        						tmpdisplay = tmpstr.substr(tmpindex,tmpendindex-tmpindex);
        					}
        					tmpdisplay+="&nbsp;";
        					return tmpdisplay;
        					
    }
        			</#if>
        	</#if>
        </#list>
        
	</script>
</head>
<#if table.showpath=="1">
<div class="bread">

                    您的当前位置：<span><%=${className}.TABLE_ALIAS%></span>
</div>
</#if>
<#if havecondsearch=1>	
<div class="quick-enter-wrap">
	<b class="rc rc-tp"><b class="x1"></b><b class="x2"></b></b>
	<div class="quick-enter">
 	<table width="90%">
 	 <tr>
 	 	<td>&nbsp;请输入查询条件</td>
 	 </tr>
	 <tr>	 
	 <td>	 
	 <table> 
	 <!--一行5个输入项  -->
	    <#assign rowseq=1>	 
	    <#assign columncount=5>
	 	<#list table.columns as column>
				<#if column.condsearch="1">
					<#if rowseq%columncount==1>
					<tr>
    				</#if> 
				
					<td>
						<td>&nbsp;<input type="checkbox" id="chk__${column.columnNameLower}" name="chk__${column.columnNameLower}"/></td>
					</td>
					<td>
						<%=${className}.ALIAS_${column.constantName}%>:&nbsp;
					</td>
					<td>
					<#if column.displayType="combo">
						<!--headerKey="0"   headerValue="请选择" -->
						<s:select label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.columnNameLower}" name="${column.columnNameLower}" value="" list="${column.enumComboxList}" cssClass="comboxcss" required="${(!column.nullable)?string}" theme="simple"/>	
					<#elseif column.displayType="unixtime">
						<s:hidden id="${column.columnNameLower}" name="${column.columnNameLower}" value=""/>
						<#if column.dataformat="yyyy-MM-dd">
						<input type="text" class="Wdate" id="${column.columnNameLower}AsDateTime" name="${column.columnNameLower}AsDateTime" 
	  							style="width:140px" onFocus="new WdatePicker(this,'%Y-%M-%D',false)" value=""/>	  					
						<#else>				
	  					<input type="text" class="Wdate" id="${column.columnNameLower}AsDateTime" name="${column.columnNameLower}AsDateTime" 
	  							style="width:140px" onFocus="new WdatePicker(this,'%Y-%M-%D %h:%m:%s',true)" value=""/>
	  					</#if>	  				  	
					<#elseif column.displayType="popup">	
						<s:hidden id="${column.columnNameLower}" name="${column.columnNameLower}" />
						<table border="0" cellpaccing="0" cellpadding="0" style="width:100%">
							<tr>
								<td style="width:20px;border:0px;">
									<img src="${'$'}{ctx}/images/edit/getbyid.gif" onclick="selectItem('${column.fktableAsClassName}','${column.columnNameLower}','${column.fkalias}','${column.fkfilter}')"/>
								</td>
								<td style="border:0px;">
									<s:textfield label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.fkalias}" name="${column.fkalias}" value="" cssClass="inputClass"  theme="simple" readonly="true" />
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
							<s:textfield label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.fkalias}" name="${column.fkalias}" value="" cssClass="inputClass"  theme="simple" readonly="true" />		
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
								<s:textfield label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.columnNameLower}" name="${column.columnNameLower}" value="" cssClass="inputClass"  theme="simple" readonly="true" />
							</td>			
						</tr>
						</table>
					<#else>						
						<s:textfield label="%{@${basepackage}.model.${className}@ALIAS_${column.constantName}}" id="${column.columnNameLower}" name="${column.columnNameLower}" value="" cssClass="inputClass" required="${(!column.nullable)?string}"  theme="simple"/>	  		
		 	  		</#if>
					</td>
		 	  		<#assign rowseq=rowseq+1>
					<#if rowseq%columncount==1>
					<td class="tdField">&nbsp;</td>
					</tr>
					</#if>
		 	  	</#if>
		</#list>
		<#-- 增加一行补充，防止少了 -->
		<#if rowseq%columncount!=1>
 	 				<td class="tdField">&nbsp;</td>
  					</tr>
		</#if>
	</table>
	</td>
	</tr>
	</table>
	</div>	
	<b class="rc rc-bt"><b class="x1"></b><b class="x2"></b></b>
</div>
</#if>
<div class="quick-enter-wrap">
	<b class="rc rc-tp"><b class="x1"></b><b class="x2"></b></b>
	<div class="quick-enter">
		<% int permission = com.micet.utils.SafeUtils.getInt(request.getAttribute("permission"));%>                    		
<#if havecondsearch=1>	
		<div class="btnpt"><a href="javascript:dosearch();" onfocus="this.blur();"><span class="icon"><img src="../../images/icon-19.gif" /></span><span class="txt">查找</span></a></div>
</#if>		
		<s:if test="tbitems!=null">
   			<s:iterator  id="item"  value="%{tbitems}">   		
   			<div class="btnpt"><a href="javascript:<s:property value="#item.js" />;" onfocus="this.blur();"><span class="icon"><img src="../../images/<s:property value="#item.image" />" /></span><span class="txt"><s:property value="#item.title" /></span></a></div>
   			</s:iterator>
   		</s:if>
   			
		<div class="btnpt"><a href="javascript:refresh();" onfocus="this.blur();"><span class="icon"><img src="../../images/icon-7.gif" /></span><span class="txt">刷新</span></a></div>
	</div>
	<b class="rc rc-bt"><b class="x1"></b><b class="x2"></b></b>
</div>
<div style="width:99%;">
	<s:set name="tablename" value="%{'${className}'}" />	
 	<s:set name="fields" value="" />
	
    <sjg:grid
        id="gridtable"
        caption="%{@${className}.TABLE_ALIAS}"
        dataType="json"
        href="../../jsons/GenericSelect.do?tb=%{tablename}&fd=%{fields}&efcd=%{efcd}"
        pager="true"
        gridModel="gridModel"
        rowList="%{efrowList}"
        rowNum="%{efrowNum}"
        value=""
        rownumbers="true"
        viewrecords="true"
        multiselect="true"
        multiboxonly="true"
        hidegrid="false"
        shrinkToFit="false"
        autowidth="true"
<#if table.listheight="">        
        height="%{efgridHeight}"
<#else>
        height="%{gridHeight}"
</#if>        
        navigator="true"
        navigatorAdd="false"
        navigatorEdit="false"
        navigatorDelete="false"
        navigatorSearch="true"
        navigatorSearchOptions="{multipleSearch:true}"
    	onSelectRowTopics="rowselect"
    	ondblclick="onmyrowdblclick()"
  
    >
    	<#list table.columns as column>
				<#if !column.htmlHidden>
					<#if column.listShow!="0">						
						<#if column.isDateTimeColumn>
							<sjg:gridColumn name="${column.sqlName}" index="${column.sqlName}" title="%{@com.micet.model.${className}@ALIAS_${column.constantName}}" sortable="true"/>
						<#elseif column.displayType="unixtime">
							<#if column.dataformat="yyyy-MM-dd">
							<sjg:gridColumn name="${column.sqlName}" index="${column.sqlName}" title="%{@com.micet.model.${className}@ALIAS_${column.constantName}}" formatter="getFormatUnixTimeOnlyDate" sortable="true"/>
							<#else>
					    	<sjg:gridColumn name="${column.sqlName}" index="${column.sqlName}" title="%{@com.micet.model.${className}@ALIAS_${column.constantName}}" formatter="getFormatUnixTime" sortable="true"/>
					    	</#if>
						<#elseif column.displayType="popup">
							<sjg:gridColumn name="${column.fkalias}" index="${column.fkalias}" title="%{@com.micet.model.${className}@ALIAS_${column.constantName}}" sortable="true"/>
						<#elseif column.displayType="condpopup">
							<sjg:gridColumn name="${column.fkalias}" index="${column.fkalias}" title="%{@com.micet.model.${className}@ALIAS_${column.constantName}}" sortable="true"/>
						<#elseif column.displayType="efcdpopup">
							<sjg:gridColumn name="${column.fkalias}" index="${column.fkalias}" title="%{@com.micet.model.${className}@ALIAS_${column.constantName}}" sortable="true"/>						
						<#elseif column.displayType="combo">
							<sjg:gridColumn name="${column.sqlName}" index="${column.sqlName}" title="%{@com.micet.model.${className}@ALIAS_${column.constantName}}" formatter="getDisplay${column.sqlName}"  sortable="true"/>
						<#elseif column.displayType="multiline">
						
						<#else>
							<sjg:gridColumn name="${column.sqlName}" index="${column.sqlName}" title="%{@com.micet.model.${className}@ALIAS_${column.constantName}}" sortable="true"/>
						</#if>
					</#if>
				<#else>
					<sjg:gridColumn name="${column.sqlName}" index="${column.sqlName}" title="%{@com.micet.model.${className}@ALIAS_${column.constantName}}" hidden="true" sortable="true"/>
				</#if>
		</#list>
		</sjg:grid>
</div>
</body>	