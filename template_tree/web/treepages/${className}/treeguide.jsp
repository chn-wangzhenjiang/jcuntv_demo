 <%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
 <HTML>
 <HEAD>
  <TITLE> Category </TITLE>
 <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="../../js/ztree/demoStyle/demo.css" type="text/css">
  <link rel="stylesheet" href="../../js/ztree/zTreeStyle/zTreeStyle.css" type="text/css">
  <script type="text/javascript" src="../../js/ztree/jquery-1.4.2.js"></script>
  <script type="text/javascript" src="../../js/ztree/jquery-ztree-2.5.js"></script>
  <style>
  div${'#'}rMenu {position:absolute; visibility:hidden; 
  background:${'#'}f0f0f0; border:1px solid ${'#'}979797; -moz-box-shadow: 1px 1px 2px ${'#'}999; -webkit-box-shadow: 1px 1px 2px ${'#'}999; box-shadow: 1px 1px 2px ${'#'}999;  
  top:0; text-align: left;}
  
div${'#'}rMenu ul li{
	cursor: pointer;
	list-style: none outside none;	
}
div${'#'}rMenu li{}
div.zmyTreeBackground {
	height:100%;
	padding:5px 0 0px 5px;
	text-align:left;
	width:200px;	
}

ul${'#'}myTree {
	width:195px;
	height:96%;
	overflow-y:scroll;
	overflow-x:auto;
}
  </style>
  <SCRIPT LANGUAGE="JavaScript">
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
  <!--
  
   var remoteAysncUrl="<%=basePath%>/jsons/CategoryTreeData.do";
	var setting = {  
	async : true,
	asyncUrl:getAsyncUrl,
	asyncParam : ["id"],
    isSimpleData : true,    
    treeNodeKey : "id",     
    treeNodeParentKey : "pid",
    rootPID : "",
    nameCol : "name",
    showLine : true,            
    checkable : false,
    expandSpeed : "fast",   
    callback : {   
    		asyncSuccess:zTreeOnAsyncSuccess,
    		click: zTreeOnClick,
            rightClick : zTreeOnRightClick  
    }         
};  
function getAsyncUrl(treeNode){
	   return remoteAysncUrl+"?domain="+$("${'#'}domain").val();
}
function zTreeOnClick(event, treeId, treeNode) {
	//alert(treeNode.tId + ", " + treeNode.name+","+treeNode.id);
<% String tmpuse = request.getParameter("use");
	if("category".equals(tmpuse))
	{ 
%>	
	parent.contentlist.location.href="../../pages/Cmscategory/list.do?efcd=ParentID:1:"+treeNode.id;
<%  }else{%>
	parent.contentlist.location.href="../../pages/CmscategoryContent/list.do?efcd=CategoryID:1:"+treeNode.id;
<%
	}
%>	
}

  function zTreeOnRightClick(event, treeId, treeNode) {  
  		/*alert('abc');
        if (!treeNode) {  
            zTree.cancelSelectedNode();  
            }*/
<%if("category".equals(tmpuse)){%>            
			if (!treeNode && event.target.tagName.toLowerCase() != "button" && $(event.target).parents("a").length == 0) {
				zTree.cancelSelectedNode();
				showRMenu("root", event.clientX, event.clientY);
			} else if (treeNode && !treeNode.noR) {
				zTree.selectNode(treeNode);
				showRMenu("node", event.clientX, event.clientY);
			}
<%}%>
	}

var zTree;  
var rMenu;	
	function showRMenu(type, x, y) {
			$("#rMenu ul").show();
			if (type=="root") {
				$("#m_del").hide();
				$("#m_check").hide();
				$("#m_unCheck").hide();
			} else {
				$("#m_del").show();
				$("#m_check").show();
				$("#m_unCheck").show();
			}
			rMenu.css({"top":y+"px", "left":x+"px", "visibility":"visible"});

			$("body").bind("mousedown", onBodyMouseDown);
		}
		function hideRMenu() {
			if (rMenu) rMenu.css({"visibility": "hidden"});
			$("body").unbind("mousedown", onBodyMouseDown);
		}
		function onBodyMouseDown(event){
			if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length>0)) {
				rMenu.css({"visibility" : "hidden"});
			}
		}
	

var treeNodes=[];  
 function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
            //zTree.expandAll(true);
        }


    $(document).ready(function(){
    $.ajax({  
        async : false,  
        cache:false,  
        type: 'POST',  
        dataType : "json",  
        url: remoteAysncUrl,  
        error: function () {  
            alert('Request Failed');  
        },  
        success:function(data){    
            //alert(data.nodes);  
            treeNodes = data.nodes;  
        }  
    });  
    treeNodes = [{id:"",name:"${table.tableAlias}导航 ",isParent:true}];
    zTree = ${'$'}("${'#'}myTree").zTree(setting, treeNodes);
    rMenu = ${'$'}("${'#'}rMenu");  
    });
   var Sys = {};
        var ua = navigator.userAgent.toLowerCase();
        var s;
        (s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] :
        (s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :
        (s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :
        (s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :
        (s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;
        
    function setReturnValue(type,vReturnValue){
    	if((vReturnValue!=null)&&(vReturnValue!="")){
    		if(type=='add')
    			addnode(vReturnValue.categoryId,vReturnValue.name);
    		else updatenode(vReturnValue.categoryId,vReturnValue.name);
    	}
    }
    function preAddTreeNode()
    {
    	hideRMenu();  
    	var tmptreenode = zTree.getSelectedNode();
  		if(tmptreenode!=null && tmptreenode!=undefined)
  		{  		
    		var tmpurl="../../advpages/Cmscategory/create.do?efcd=ParentID:1:"+tmptreenode.id+";Domain:1:"+$("#domain").val();
    		tmpreturnvalue = window.showModalDialog(tmpurl,null,"dialogWidth=600px;dialogHeight=450px;resizable=no;scroll=no;");
    		if(!Sys.ie)setReturnValue('add',tmpreturnvalue);    	
    	}
    }
    function preUpdateTreeNode()
    {
   		 hideRMenu();  
    	var tmptreenode = zTree.getSelectedNode();
  		if(tmptreenode!=null && tmptreenode!=undefined)
  		{  		
    		var tmpurl="../../advpages/Cmscategory/edit.do?CategoryID="+tmptreenode.id;
    		var tmpreturnvalue = window.showModalDialog(tmpurl,window,"dialogWidth=650px;dialogHeight=450px;resizable=no;scroll=no;");
    		if(!Sys.ie)setReturnValue('update',tmpreturnvalue);
    	}
    }
    function preRemoveTreeNode(){
    	hideRMenu();
    	if(confirm("您确认要删除吗?")){
    		var tmptreenode = zTree.getSelectedNode();
  		if(tmptreenode!=null && tmptreenode!=undefined)
  		{  	
    			$.ajax( {
			async : false,
			cache : false,
			type : 'POST',
			dataType : "json",
			url : "<%=basePath%>/jsons/Cmscategory/delete.do?categoryId="+ tmptreenode.id,
			error : function() {
				alert('删除失败');
			},
			success : function(data) {  
			removenode();
		}
		});		
		}
    	}    	 
    } 
  var addCount=0;
  function addnode(idvalue,namevalue)
  {
  		
  		//opener.document.all.tvalue.value 
  		
  		zTree.addNodes(zTree.getSelectedNode(), [{ name:namevalue,id:idvalue}]);
  }
  function removenode()
  {
  		hideRMenu();  
  		var node = zTree.getSelectedNode();
		if (node) {
			if (node.nodes && node.nodes.length > 0) {
				var msg = "Are you confirm to delete!";
				if (confirm(msg)==true){
					zTree.removeNode(node);
				}
			} else {
				zTree.removeNode(node);
			}
		}
  }
  function updatenode(id,newname)
  {
  	hideRMenu();
  	var tmptreenode = zTree.getSelectedNode();
  	if(tmptreenode!=null && tmptreenode!=undefined)
  	{
  		tmptreenode.name=newname;
  		zTree.updateNode(tmptreenode, true);
  		
  	}
  }
  function ondomainchange(){  	
  	var treeNodes = zTree.getNodes();
	zTree.reAsyncChildNodes(treeNodes[0], "refresh", false);  	
  }
  //-->
  </SCRIPT>
</HEAD>
<body>     	
  	<div class="zmyTreeBackground">
			<ul id="myTree" class="tree"></ul>
	</div>	
	<div id="rMenu">
	<ul>
		<li id="m_add" onclick="preAddTreeNode();">增加${table.tableAlias}</li>
		<li id="m_add" onclick="preUpdateTreeNode();">更改${table.tableAlias}</li>
		<li id="m_del" onclick="preRemoveTreeNode();">删除${table.tableAlias}</li>		
		<li>&nbsp;</li>
	</ul>
</div>	
</body>