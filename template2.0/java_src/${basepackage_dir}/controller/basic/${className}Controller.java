<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.controller.basic;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.micet.service.basic.${className}Service;
import com.micet.controller.base.BaseController;
import com.micet.entity.Page;
import com.micet.entity.basic.${className};
import com.micet.util.AppUtil;
import com.micet.util.Const;
import com.micet.util.Jurisdiction;
import com.micet.util.MD5;
import com.micet.util.ObjectExcelView;
import com.micet.util.PageData;

/** 
 * 类名称：${className}Controller
 * @author micet
 * @time ${now?string('yyyy-MM-dd')}
 * @version
 */
@Controller
@RequestMapping(value="/${classNameLower}")
public class ${className}Controller extends BaseController {
	
	String menuUrl = "${classNameLower}/list.do"; //菜单地址(权限用)
	@Resource(name="${classNameLower}Service")
	private ${className}Service ${classNameLower}Service;
	
	
	/**
	 * 保存
	 */
	@RequestMapping(value="/save")
	public ModelAndView saveU(PrintWriter out) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		if(null == ${classNameLower}Service.findById(pd)){
			if(Jurisdiction.buttonJurisdiction(menuUrl, "add")){
				${className}.preSaveCheck(pd,"save");
				${classNameLower}Service.insert(pd);
			} //判断新增权限
			mv.addObject("msg","success");
		}else{
			mv.addObject("msg","failed");
		}
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value="/update")
	public ModelAndView editU(PrintWriter out) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();	
		if(Jurisdiction.buttonJurisdiction(menuUrl, "edit")){
			${className}.preSaveCheck(pd,"update");
			${classNameLower}Service.update(pd);
		}
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 判断是否存在
	 */
	@RequestMapping(value="/has")
	@ResponseBody
	public Object has(){
		Map<String,String> map = new HashMap<String,String>();
		String errInfo = "success";
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			if(${classNameLower}Service.findById(pd) != null){
				errInfo = "error";
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		map.put("result", errInfo);				//返回结果
		return AppUtil.returnObject(new PageData(), map);
	}
	

	/**
	 * 去修改页面
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEditU(){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			pd = ${classNameLower}Service.findById(pd);								//根据ID读取
			${className}.preDisplayCheck(pd,"edit");
			mv.setViewName("basic/${className}/${className}_edit");
			mv.addObject("msg", "update");
			mv.addObject("pd", pd);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}						
		return mv;
	}
	
	/**
	 * 去新增页面
	 */
	@RequestMapping(value="/goAdd")
	public ModelAndView goAddU(){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			${className}.preDisplayCheck(pd,"add");
			mv.setViewName("basic/${className}/${className}_edit");
			mv.addObject("msg", "save");
			mv.addObject("pd", pd);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}						
		return mv;
	}
	
	/**
	 * 显示列表
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			page.setPd(pd);
			List<PageData>	dataList = ${classNameLower}Service.listPdPage(page);

			mv.setViewName("basic/${className}/${className}_list");
			mv.addObject("dataList", dataList);
			mv.addObject("pd", pd);
			mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		
		return mv;
	}

	/**
	 * 删除
	 */
	@RequestMapping(value="/delete")
	public void deleteU(PrintWriter out){
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			if(Jurisdiction.buttonJurisdiction(menuUrl, "del")){${classNameLower}Service.delete(pd);}
			out.write("success");
			out.close();
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		
	}
	
	/**
	 * 批量删除
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAllU() {
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			pd = this.getPageData();
			List<PageData> pdList = new ArrayList<PageData>();
			String IDS = pd.getString("IDS");
			
			if(null != IDS && !"".equals(IDS)){
				String Array_IDS[] = IDS.split(",");
				if(Jurisdiction.buttonJurisdiction(menuUrl, "del")){${classNameLower}Service.deleteAll(Array_IDS);}
				pd.put("msg", "ok");
			}else{
				pd.put("msg", "no");
			}
			
			pdList.add(pd);
			map.put("list", pdList);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		} finally {
			logAfter(logger);
		}
		return AppUtil.returnObject(pd, map);
	}
	
	
	/*
	 * 导出会员信息到excel
	 * @return
	 */
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel(){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
			if(Jurisdiction.buttonJurisdiction(menuUrl, "cha")){	
			
				Map<String,Object> dataMap = new HashMap<String,Object>();
				List<String> titles = new ArrayList<String>();
				
				<#list table.columns as c>
				<#if c.pk>
				<#else>		
				titles.add("${c.columnAlias}");
				</#if>
				</#list>			
			
				dataMap.put("titles", titles);
				
				List<PageData> dataList = ${classNameLower}Service.listAll(pd);
				List<PageData> varList = new ArrayList<PageData>();
				for(int i=0;i<dataList.size();i++){
					PageData vpd = new PageData();
					
					<#list table.columns as c>
					<#if c.pk>
					<#else>		
					vpd.put("var${c_index}", dataList.get(i).getString("${c.columnName}"));	
					</#if>
					</#list>		
				
					varList.add(vpd);
				}
				
				dataMap.put("varList", varList);
				
				ObjectExcelView erv = new ObjectExcelView();
				mv = new ModelAndView(erv,dataMap);
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	//===================================================================================================
	
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
	
	/* ===============================权限================================== */
	public Map<String, String> getHC(){
		Subject currentUser = SecurityUtils.getSubject();  //shiro管理的session
		Session session = currentUser.getSession();
		return (Map<String, String>)session.getAttribute(Const.SESSION_QX);
	}
	/* ===============================权限================================== */
}
