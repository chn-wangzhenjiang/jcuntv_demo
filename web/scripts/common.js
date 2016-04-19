function initCombox(comaboxId,comboxvalue,comboxstr){
$(function(){
	   var dat=comboxstr;
	  
	   var len=parseInt(dat.length);
	     
	   var str= new Array();   
	   
	     var datstr=dat.substring(0,len);
	     
	   str=datstr.split(";");
	          
	   $.each( str, function(i, n){
	   		var temp = str[i].split("("); 
	   		var defaultSel = "";
	   		if(temp[0]==comboxvalue) defaultSel = " selected ";
	      $(comaboxId).append("<option value='"+temp[0]+"' "+defaultSel+">"+temp[1].substring(0,temp[1].length-1)+"</option>");
	   });
     });
}