<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.basic;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.micet.dao.DaoSupport;
import com.micet.entity.Page;
import com.micet.util.PageData;


<#include "/java_imports.include">

/** 
 * 类名称：${className}Service
 * @author micet
 * @time ${now?string('yyyy-MM-dd')}
 * @version
 */
@Service("${classNameLower}Service")
public class ${className}Service{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/*
	* 通过id获取数据
	*/
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("${className}Mapper.findById", pd);
	}	
	/*
	* 保存
	*/
	public void insert(PageData pd)throws Exception{
		dao.save("${className}Mapper.insert", pd);
	}
	/*
	* 修改
	*/
	public void update(PageData pd)throws Exception{
		dao.update("${className}Mapper.update", pd);
	}
	/*
	* 删除
	*/
	public void delete(PageData pd)throws Exception{
		dao.delete("${className}Mapper.delete", pd);
	}
	
	/*
	* 批量删除
	*/
	public void deleteAll(String[] USER_IDS)throws Exception{
		dao.delete("${className}Mapper.deleteAll", USER_IDS);
	}
	/*
	*列表
	*/
	public List<PageData> listPdPage(Page page)throws Exception{
		return (List<PageData>) dao.findForList("${className}Mapper.listPage", page);
	}
	
	/*
	*列表(全部)
	*/
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>) dao.findForList("${className}Mapper.listAll", pd);
	}
	
}
