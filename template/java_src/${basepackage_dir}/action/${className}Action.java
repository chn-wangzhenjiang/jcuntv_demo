<#include "/custom.include">
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign pkname    = table.pkName>
<#assign classNameLower = className?uncap_first>
<#assign actionExtension = "do">
package ${basepackage}.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.micet.utils.MD5;
import com.micet.utils.SafeUtils;
import javacommon.util.ParamCondItem;
import javacommon.util.ParameterParseUtil;
import javacommon.util.ParamsInfo;

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.weaver.loadtime.Options;

import cn.org.rapid_framework.beanutils.BeanUtils;
import cn.org.rapid_framework.web.scope.Flash;

import com.micet.frame.PermissionManager;
import com.micet.model.Operator;
import com.micet.model.Sysmenu;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;


<#include "/java_imports.include">

public class ${className}Action extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "${jspFileBasePath}/query.jsp";
	protected static final String LIST_JSP= "${jspFileBasePath}/list.jsp";
	protected static final String CREATE_JSP = "${jspFileBasePath}/create.jsp";
	protected static final String EDIT_JSP = "${jspFileBasePath}/edit.jsp";
	protected static final String SHOW_JSP = "${jspFileBasePath}/show.jsp";
	protected static final String GRID_JSP= "${jspFileBasePath}/grid.jsp";	
	protected static final String ERROR_JSP= "../../error.jsp";
	
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!${actionBasePath}/list.${actionExtension}";
	protected static final String CONDLIST_ACTION = "!list.do";
	
	private ${className}Manager ${classNameLower}Manager;
	

	<#if table.listheight="">
	private int gridHeight=300;
	<#else>
	private int gridHeight=${table.listheight};
	</#if>
	public int getGridHeight(){
		return this.gridHeight;
	}
	public void setGridHeight(int value){
		this.gridHeight=value;
	}
	private int result=0;
	private String resultDesc="";
	private String returnURL="";
	
	public int getResult(){
		return this.result;	
	}
	public void setResult(int rst){
		this.result = rst;
	}
	public String getResultDesc(){
		return this.resultDesc;
	}
	public void setResultDesc(String rstdesc){
		this.resultDesc = rstdesc;
	}
	public String getReturnURL(){
		return this.returnURL;
	}
	public void setReturnURL(String url){
		this.returnURL = url;
	}
	
	private ${className} ${classNameLower};
	<#list table.compositeIdColumns as column>
	${column.javaType} id = null;
	</#list>
	
	<#list table.importedKeys.associatedTables?values as foreignKey>
		<#assign fkSqlTable = foreignKey.parentTable>
		<#assign fkTable    = fkSqlTable.className>
		<#assign fkPojoClass = fkSqlTable.className>
		<#assign fkPojoClassVar = fkPojoClass?uncap_first>
		<#list foreignKey.parentColumns?values as fkColumn>
		<#assign tableNameVar = foreignKey.childTable>
		<#if tableNameVar.className!=className>
		private ${tableNameVar.className}Manager ${tableNameVar.className?uncap_first}Manager;
	</#if>
	private List<${tableNameVar.className}> ${fkColumn}lists ;
	    </#list>
    </#list>
	private String[] items;

	public void prepare() throws Exception {
		if(!isListMethod())prepareEditData();
	}
	public void prepareEditData(){
		
		<#list table.columns as column>
		
			<#if column.fktable !="" && column.displayType="combo" && column.dataSrcType="2">
		init${column.fkalias?cap_first}Options();
			</#if>
		</#list>
		if (isNullOrEmptyString(id)) {
			${classNameLower} = new ${className}();
			java.util.Map tmprowmap = new HashMap();
			String tmpefcd = this.getEfcd();
			if((tmpefcd!=null)&&(!tmpefcd.equals(""))){
					List<ParamCondItem> tmpitems = ParameterParseUtil.analyseEfcdToList(tmpefcd);
					for(int i=0;i<tmpitems.size();i++){
						if(tmpitems.get(i).getCond()==ParameterParseUtil.COND_EQ){					
							tmprowmap.put(tmpitems.get(i).getName(),tmpitems.get(i).getValue());
							<#assign tmpindex=0>
							<#list table.columns as column>
							<#if column.fktable?length!=0>
							    <#assign tmpindex= tmpindex+1>
								<#if tmpindex=1>
									if(tmpitems.get(i).getName().equalsIgnoreCase("${column.sqlName}")){									
								<#else>
										else if(tmpitems.get(i).getName().equalsIgnoreCase("${column.sqlName}")){
								</#if>
									tmprowmap.put("${column.fkalias}",getFKDisplayValue("${column.fktable}","${column.fknamecolumn}","${column.fkidcolumn}",tmpitems.get(i).getValue(),""));
								}
							</#if>
							</#list>
							
						}
					}
			}		
			${classNameLower}.initFromRawMap(tmprowmap);			
		} else {
			//${classNameLower} = (${className})${classNameLower}Manager.getById(id);
			
			
			//java.util.Map tmprowmap = getRow("${className}",new String[]{"PKID"},new String[]{""+id});
			java.util.Map tmprowmap = getRow("${className}",new String[]{"${pkname}"},new String[]{""+id});
			
			${classNameLower} = new ${className}();
			${classNameLower}.initFromRawMap(tmprowmap);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写 */
	public void set${className}Manager(${className}Manager manager) {
		this.${classNameLower}Manager = manager;
	}	
	
	public Object getModel() {
		return ${classNameLower};
	}
	
	<#list table.compositeIdColumns as column>
	public void set${column.columnName}(${column.javaType} val) {
		this.id = val;
	}
	</#list>	

	public void setItems(String[] items) {
		this.items = items;
	}
	
	/** 执行搜索 */
	public String list() {
		/*${className}Query query = newQuery(${className}Query.class,DEFAULT_SORT_COLUMNS);
		
		Page page = ${classNameLower}Manager.findPage(query);
		savePage(page,query);*/
		//no need anymore,do it in ajax mode
		//GetAlloperator on that permission,and compare it with
		Operator tmpoperator = (Operator)this.getRequest().getSession().getAttribute("operator");
	      if(tmpoperator==null)return LOGIN_ACTION;
	      
		this.initPermission("${table.sqlName}");
		Map tmprightsmap = this.getRights("${table.sqlName}");
		<#list table.buttons as button>			
			if( haveButtons("${button.opname}")&& ((this.permission==65535)||((this.permission&SafeUtils.getInt(tmprightsmap.get("${button.opname}"),0))>0)))
			{
				this.addTbitem("${button.title}","${button.icon}","${button.action}","${button.opname}");
			}
		</#list>	
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		boolean tmpHavePermission = havePermission("${table.sqlName?lower_case}", PermissionManager.PERMISSION_VIEW);
    	if(!tmpHavePermission){
    		this.result = -1;
    		this.resultDesc="没有权限，请联系管理员";
    		return ERROR_JSP; 
    	}
		return SHOW_JSP;
	}
	/** 展示GRID*/
	public String showGrid() {
		return GRID_JSP;
	}
	/** 进入新增页面*/
	public String create() {
		boolean tmpHavePermission = havePermission("${table.sqlName?lower_case}", PermissionManager.PERMISSION_ADD);
		if(!tmpHavePermission){
    		this.result = -1;
    		this.resultDesc="没有权限，请联系管理员";
    		return ERROR_JSP; 
    	}
		   		  
		initList();
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		boolean tmpHavePermission = havePermission("${table.sqlName?lower_case}", PermissionManager.PERMISSION_ADD);
		if(!tmpHavePermission){
    		this.result = -1;
    		this.resultDesc="没有权限，请联系管理员";
    		return ERROR_JSP; 
    	}
		   
		<#list table.columns as column>
			
			<#if column.generate="auto" || column.generate="autorenew">
				<#if column.displayType="unixtime">
					<#if column.javaType="java.lang.Integer">
		this.${classNameLower}.set${column.columnName}(SafeUtils.getCurrentUnixTime());
					<#else>
		this.${classNameLower}.set${column.columnName}(SafeUtils.getCurrentTime());					
					</#if>
				<#else>
					<#if column.javaType="java.lang.Integer">					
						this.${classNameLower}.set${column.columnName}(getIntMandValue("${column.mandvalue}"));
					<#else>
						this.${classNameLower}.set${column.columnName}(getMandValue("${column.mandvalue}"));
					</#if>					
			    </#if>
			<#elseif column.displayType="md5password">
		   		if(!"".equals(this.${classNameLower}.get${column.columnName}__md5()))
		   			this.${classNameLower}.set${column.columnName}(MD5.getMD5(this.${classNameLower}.get${column.columnName}__md5()));			
		   <#elseif column.generate="autoseq">
        this.${classNameLower}.set${column.columnName}(generateSequenceID("${table.sqlName?lower_case}", this.${classNameLower} ,"${column.generateParam}"));
        	</#if>
		</#list>	
		/*获取所有的uniqueue fields，生成判断条件，看是否存在相同记录*/
		
		<#if table.uniqueFields!="">
			List<SqlColumnInfo> tmpsqlcolumlist = new ArrayList<SqlColumnInfo>();
			<#list table.columns as column>
				<#if table.uniqueFields?index_of(column.sqlName)!=-1>
			tmpsqlcolumlist.add(new SqlColumnInfo("${column.sqlName}",this.${classNameLower}.get${column.columnName}()));
					</#if>
			</#list>
			if(!checkUnique(0,"${table.sqlName}",tmpsqlcolumlist))
			{
				tmpsqlcolumlist = null;
				return CREATE_JSP;
			}
			tmpsqlcolumlist = null;
		</#if>
		String tmpid="";
		
				
		${classNameLower}Manager.save(${classNameLower});
		<#list table.compositeIdColumns as column>
			tmpid += this.${classNameLower}.get${column.columnName}();
		</#list>
		reportOperatorOperation("REGIST",${classNameLower},"${table.sqlName}","${table.tableAlias}",tmpid,${classNameLower}.toObjectString());
		
		Flash.current().success(CREATED_SUCCESS); //存放在Flash中的数据,在下一次http请求中仍然可以读取数据,error()用于显示错误消息
		return getListUrl(LIST_ACTION,CONDLIST_ACTION);
	}
	
	/**进入更新页面*/
	public String edit() {
		boolean tmpHavePermission = havePermission("${table.sqlName?lower_case}", PermissionManager.PERMISSION_UPDATE);
		if(!tmpHavePermission){
    		this.result = -1;
    		this.resultDesc="没有权限，请联系管理员";
    		return ERROR_JSP; 
    	}
		initList();
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		
		boolean tmpHavePermission = havePermission("${table.sqlName?lower_case}", PermissionManager.PERMISSION_UPDATE);
		if(!tmpHavePermission){
    		this.result = -1;
    		this.resultDesc="没有权限，请联系管理员";
    		return ERROR_JSP; 
    	}
		   
		/*如果有需要generateautorenew的时间，那么需要这边设置更新时间的*/
		<#list table.columns as column>
		
		<#if column.generate="autorenew">
			<#if column.displayType="unixtime">
				<#if column.javaType="java.lang.Integer">
		this.${classNameLower}.set${column.columnName}(SafeUtils.getCurrentUnixTime());
				<#else>
				this.${classNameLower}.set${column.columnName}(SafeUtils.getCurrentTime());					
				</#if>				
			<#else>
				<#if column.javaType="java.lang.Integer">					
				this.${classNameLower}.set${column.columnName}(getIntMandValue("${column.mandvalue}"));
				<#else>
				this.${classNameLower}.set${column.columnName}(getMandValue("${column.mandvalue}"));
				</#if>	
			</#if>			
		<#elseif column.displayType="md5password">
			if(!"".equals(this.${classNameLower}.get${column.columnName}__md5()))
				this.${classNameLower}.set${column.columnName}(MD5.getMD5(this.${classNameLower}.get${column.columnName}__md5()));				   
		</#if>
		</#list>
		${classNameLower}Manager.update(this.${classNameLower});
		String tmpid="";
		<#list table.compositeIdColumns as column>
		tmpid += this.${classNameLower}.get${column.columnName}();
		</#list>
		reportOperatorOperation("UPDATE",${classNameLower},"${table.sqlName}","${table.tableAlias}",tmpid,${classNameLower}.toObjectString());
		
		Flash.current().success(UPDATE_SUCCESS);
		return getListUrl(LIST_ACTION,CONDLIST_ACTION);
	}
	
	/**删除对象*/
	public String delete() {
		boolean tmpHavePermission = havePermission("${table.sqlName?lower_case}", PermissionManager.PERMISSION_DELETE);
		if(!tmpHavePermission){
    		this.result = -1;
    		this.resultDesc="没有权限，请联系管理员";
    		return ERROR_JSP; 
    	}
		   
    	
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			<#if table.compositeId>
			${className}Id id = (${className}Id)copyProperties(${className}Id.class,params);
			<#else>
				<#list table.compositeIdColumns as column>
			${column.javaType} id = new ${column.javaType}((String)params.get("${column.columnNameLower}"));
				</#list>
			</#if>
			//查询下看是否有，如果有进行操作
			reportOperatorOperation("DELETE",null,"${table.sqlName}","${table.tableAlias}",id.toString(),"");
			${classNameLower}Manager.removeById(id);
		}
		Flash.current().success(DELETE_SUCCESS);
		return getListUrl(LIST_ACTION,CONDLIST_ACTION);
	}
	/** 初始化列表*/
	public void initList(){
		 /** 效率很低，如果外键多这么处理的话，应该通过关联查询视图的方式获取 **/
		/*
		<#list table.importedKeys.associatedTables?values as foreignKey>
			<#assign fkSqlTable = foreignKey.parentTable>
			<#assign fkTable    = fkSqlTable.className>
			<#assign fkPojoClass = fkSqlTable.className>
			<#assign fkPojoClassVar = fkPojoClass?uncap_first>
			
			
			<#list foreignKey.parentColumns?values as fkColumn>
			<#assign tableNameVar = foreignKey.childTable>
			${fkColumn}lists = ${tableNameVar.className?uncap_first}Manager.findAll(); 
		    </#list>
	    </#list>
	    */
	}
	//创建项目
	<#list table.columns as column>
	
	<#if column.fktable !="" && column.displayType="combo" && column.dataSrcType="2">
		public ArrayList get${column.fkalias?cap_first}Options() {
			return this.${column.fkalias?uncap_first}Options;
		}
		private ArrayList ${column.fkalias?uncap_first}Options;
		private void init${column.fkalias?cap_first}Options(){
			String tmpfilter = "${column.fkfilter}";
			String tmpquerySql= "select ${column.fkidcolumn},${column.fknamecolumn} from ${column.fktable} as t";
			ParamsInfo tmpparamsinfo = null;
			String [] sqlParams = null;
			tmpparamsinfo = ParameterParseUtil
						.analyseEfcdToSql(tmpfilter);
			if (tmpparamsinfo == null)tmpparamsinfo = new ParamsInfo();
			if (tmpparamsinfo.condvalues.size() > 0) {
				sqlParams = new String[tmpparamsinfo.condvalues.size()];
				for (int i = 0; i < tmpparamsinfo.condvalues.size(); i++)
					sqlParams[i] = SafeUtils.getString(tmpparamsinfo.condvalues.get(i));
			}
			
			if (!tmpparamsinfo.condsql.equals("")) {
				tmpquerySql += " where " + tmpparamsinfo.condsql;
			}
			this.${column.fkalias?uncap_first}Options = queryForListOptions(tmpquerySql,sqlParams,"${column.fknamecolumn}","${column.fkidcolumn}");			
		}
	</#if>
	</#list>
	
	<#list table.importedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.parentTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	<#list foreignKey.parentColumns?values as fkColumn>
	<#assign tableNameVar = foreignKey.childTable>
	<#if tableNameVar.className!=className>
	public void set${tableNameVar.className}Manager(${tableNameVar.className}Manager manager) {
		this.${tableNameVar.className?uncap_first}Manager = manager;
	}
	public List<${tableNameVar.className}> get${fkColumn?cap_first}lists() {
		return this.${fkColumn}lists;
	}
	</#if>
    </#list>
    </#list>
	
}
