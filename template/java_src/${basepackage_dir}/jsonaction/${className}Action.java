<#include "/custom.include">
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign actionExtension = "do">
package ${basepackage}.jsonaction;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javacommon.base.GenericService;
import javacommon.util.JsonHelper;
import com.micet.utils.SafeUtils;
import javacommon.base.SpringContextUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import cn.org.rapid_framework.beanutils.BeanUtils;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.web.scope.Flash;

import com.micet.frame.PermissionManager;
import com.micet.frame.SystemConst;
import com.micet.model.Operator;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;


<#include "/java_imports.include">

public class ${className}Action extends BaseStruts2Action{
	
	private ${className}Manager ${classNameLower}Manager;	
	private ${className} ${classNameLower};
	
	
	private Log log = LogFactory.getLog(${className}Action.class);  
	private List  gridModel = Collections.emptyList();   
    //get how many rows we want to have into the grid - rowNum attribute in the grid
    private Integer             rows             = 0;

    //Get the requested page. By default grid sets this to 1.
    private Integer             page             = 0;

    // sorting order - asc or desc
    private String              sord;

    // get index row - i.e. user click to sort.
    private String              sidx;
    private String values="";
    public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
	}
    public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSearchOper() {
		return searchOper;
	}

	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}
	/**
	 * 查询字段
	 */
    private String              searchField;

    /**
     * 查询字符串
     */
    private String              searchString;

    // he Search Operation ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
    /**
     * 查询条件
     */
    private String              searchOper;

    /**
     * 总页数
     */
    private Integer             total            = 0;

    /**
     * 总记录数
     */
    private Integer             records          = 0;
    
    /**
     * 操作结果，返回删除，更新，添加等基本操作结果
     */
    private Integer 			result			= 0;
    public void setResult(int result){
    	this.result = result;
    }
    public int getResult(){
    	return this.result;
    }
    /**
     * 返回结果描述
     */
    private String              resultDesc      = "";
    public void setResultDesc(String resultDesc){
    	this.resultDesc = resultDesc;
    }
    public String getResultDesc(){
    	return this.resultDesc;
    }
    /**
     * 主键列表，用于批量操作，例如删除，状态批量更新
     */
    private String              ids			= "";
    public void setIds(String ids){
    	this.ids = ids;
    }
    public String getIds(){
    	return this.ids;
    }
    
    public String getOpname() {
		return opname;
	}

	public void setOpname(String opname) {
		this.opname = opname;
	}

	public String getOpparam() {
		return opparam;
	}

	public void setOpparam(String opparam) {
		this.opparam = opparam;
	}
	/**
     * 动作名称 
     */
    private String opname="";
     
	/**
	 * 动作参数
	 */
	private String opparam="";
	
	
    public List getGridModel() {   
        return gridModel;   
    }   
    public void setGridModel(List gridModel) {   
        this.gridModel = gridModel;   
    }   
    public Integer getRows() {   
        return rows;   
    }   
    public void setRows(Integer rows) {   
        this.rows = rows;   
    }   
    public Integer getPage() {   
        return page;   
    }   
    public void setPage(Integer page) {   
        this.page = page;   
    }   
    public Integer getTotal() {   
        return total;   
    }   
    public void setTotal(Integer total) {   
        this.total = total;   
    }   
    public Integer getRecords() {   
        return records;   
    }   
    public void setRecord(Integer records) {   
        this.records = records;   
    }   
    public String getSord() {   
        return sord;   
    }   
    public void setSord(String sord) {   
        this.sord = sord;   
    }   
    public String getSidx() {   
        return sidx;   
    }   
    public void setSidx(String sidx) {   
        this.sidx = sidx;   
    }  
    /**
     * 列表操作
     * @return
     */
    public String list() {   
    	boolean tmpHavePermission = havePermission("${table.sqlName?lower_case}", PermissionManager.PERMISSION_VIEW);
    	if(!tmpHavePermission)return ERROR;
    	
    	 try {   
         	List results = Collections.emptyList(); 
         	String tmporder=null;
       		if((this.sidx!=null)&&(!this.sidx.equals("")))
           	{
       			tmporder = this.sidx;
       			if((this.sord!=null)&&(!this.sord.equals("")))
       				tmporder += " "+this.sord;
       			else tmporder +=" asc";
           	}
         	${className}Query query = newQuery(${className}Query.class,tmporder);    		
     		Page<${className}> tmpqueryResult = ${classNameLower}Manager.findPage(query);
     	    
             records = tmpqueryResult.getTotalCount();
             
             if(rows<=0)rows=10;
             total = (int) Math.ceil((double) records / (double) rows);   
             if(page>total)page =total;
             int to = (rows * page);
             int from = to - rows;                         
             results = tmpqueryResult.getResult();   
             this.setGridModel(results);   
             
             return SUCCESS;   
         } catch (Exception e) {   
             e.printStackTrace();   
             this.addActionError(e.getMessage());   
             return ERROR;   
        }
    }  
    /***
     * 执行任意动作
     * @return
     */
    public String action(){
    	return baseDoAction("${table.sqlName?lower_case}",this.ids,this.opname,this.opparam);
    }
    /***
     * 删除
     * @return
     */
    public String delete(){
        	boolean tmpHavePermission = havePermission("${table.sqlName?lower_case}", PermissionManager.PERMISSION_DELETE);
        	if(!tmpHavePermission)return ERROR;        	
        	String tmpitems = SafeUtils.getString(this.ids);
        	if(!tmpitems.equals("")){
        		String[]tmpids = tmpitems.split(",");
        		for(int i=0;i<tmpids.length;i++){
        			reportOperatorOperation("DELETE",null,"${table.sqlName}","${table.tableAlias}",tmpids[i].toString(),"");
       				
        			<#list table.columns as column>
        			<#if column.pk>
        					<#if column.javaType="java.lang.Long">
        			this.${classNameLower}Manager.removeById(SafeUtils.getLong(tmpids[i]));
        					<#else>
        			this.${classNameLower}Manager.removeById(SafeUtils.getInteger(tmpids[i]));
        					</#if>
        				</#if>
        			</#list>
        			
       				
       			}        
        	}
    	return SUCCESS;
    }
    
    /**
     * 更新操作
     * @return
     */
    public String update(){
    	this.result = 0;
    	if(this.${classNameLower}==null) this.${classNameLower} = new ${className}();
    	Map tmpparammap  = null;
    	try{
    		tmpparammap = JsonHelper.Json2Map(this.values);
    		this.${classNameLower}.initFromRawMap(tmpparammap);
        	
    	<#list table.columns as column>
		<#if column.displayType="unixtime">
			<#if column.generate="autorenew">			
				<#if column.javaType="java.lang.Integer">
		this.${classNameLower}.set${column.columnName}(SafeUtils.getCurrentUnixTime());
				<#else>
				this.${classNameLower}.set${column.columnName}(SafeUtils.getCurrentTime());					
				</#if>				
			</#if>
		</#if>
		</#list>
		${classNameLower}Manager.update(this.${classNameLower});
		String tmpid="";
		<#list table.compositeIdColumns as column>
		tmpid += this.${classNameLower}.get${column.columnName}();
		</#list>
		reportOperatorOperation("UPDATE",${classNameLower},"${table.sqlName}","${table.tableAlias}",tmpid,${classNameLower}.toObjectString());
    	}catch(Exception ex){
    		this.result=-1;
    		this.resultDesc=ex.getMessage();
    	}
    	
    	return SUCCESS;
    }
    /**
     * 添加操作
     * @return
     */
    public String add(){
    	this.result = 0;
    	if(this.${classNameLower}==null) this.${classNameLower} = new ${className}();
    	Map tmpparammap  = null;
    	try{
    		tmpparammap = JsonHelper.Json2Map(this.values);
    		this.${classNameLower}.initFromRawMap(tmpparammap);
    	<#list table.columns as column>
		<#if column.displayType="unixtime">
			<#if column.generate="auto" || column.generate="autorenew">			
				<#if column.javaType="java.lang.Integer">
	this.${classNameLower}.set${column.columnName}(SafeUtils.getCurrentUnixTime());
				<#else>
	this.${classNameLower}.set${column.columnName}(SafeUtils.getCurrentTime());					
				</#if>				
		    </#if>
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
    	}catch(Exception ex){
    		this.result=-1;
    		this.resultDesc=ex.getMessage();
    	}
    	return SUCCESS;
    }
    public void set${className}Manager(${className}Manager manager) {
		this.${classNameLower}Manager = manager;
	}	
}
