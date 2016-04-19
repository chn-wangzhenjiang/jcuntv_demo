<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign actionExtension = "do">
package ${basepackage}.action.json;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javacommon.base.GenericService;
import javacommon.base.SpringContextUtil;
import javacommon.base.ZTreeNodeData;
import com.micet.utils.SafeUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

public class ${className}TreeDataAction extends ActionSupport{
	private Log log = LogFactory.getLog(${className}Action.class);  
	
	private GenericService genericService = (GenericService) SpringContextUtil.getBean("genericService");
	private String id="";
	@JSON(serialize=false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private List<ZTreeNodeData> nodes= new ArrayList<ZTreeNodeData>();
	public List<ZTreeNodeData> getNodes() {
		return nodes;
	}
	public void setNodes(List<ZTreeNodeData> nodes) {
		this.nodes = nodes;
	}
	@Override  
	public String execute() {		
		if(this.id==null||this.id.isEmpty())this.id="0";
		String tmpsql="select * from ${table.sqlName} where ${table.treeParentColumn}=?";
		List tmplist = genericService.queryForResult(tmpsql,new Object[]{id});
		if(tmplist!=null)
		{
			ZTreeNodeData tmpnode =null;
			for(int i=0;i<tmplist.size();i++){
				Map tmprow = (Map) tmplist.get(i);
				tmpnode = new ZTreeNodeData();				
				tmpnode.setId(SafeUtils.getString(tmprow.get("${table.treeIdColumn}")));
				tmpnode.setPid(id);
				tmpnode.setName(SafeUtils.getString(tmprow.get("${table.treeNameColumn}")));
				tmpnode.setOpen(false);	
				tmpnode.setNodes(null);
				if(SafeUtils.getInt(tmprow.get("HasSub"),0)==1)
					tmpnode.setIsParent(true);
				else tmpnode.setIsParent(false);
				nodes.add(tmpnode);
			}
		}
		return SUCCESS;
	}
}
