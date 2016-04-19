<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign sqlName = table.sqlName>
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

<#include "/java_imports.include">

import static cn.org.rapid_framework.util.ObjectUtils.*;
import org.springframework.stereotype.Repository;

@Repository
public class ${className}Dao extends BaseHibernateDao<${className},${table.idColumn.javaType}>{

	public Class getEntityClass() {
		return ${className}.class;
	}
	
	public Page findPage(${className}Query query) {
		String sql = "select t from ${className} t where 1=1 "
			<#list table.columns as column>
			  	<#if column.isNotIdOrVersionField>
			  	<#if column.isDateTimeColumn>
				+ "/~ and t.${column.columnNameLower} >= {${column.columnNameLower}Begin} ~/"
				+ "/~ and t.${column.columnNameLower} <= {${column.columnNameLower}End} ~/"
				<#else>
			  	+ "/~ and t.${column.columnNameLower} = {${column.columnNameLower}} ~/"
			  	</#if>
				</#if>
			</#list>
				+ "/~ order by [sortColumns] ~/";

		return pageQuery(sql,query);
	}
	
	<#list table.columns as column>
	<#if column.unique && !column.pk>
	public ${className} getBy${column.columnName}(${column.javaType} v) {
		return (${className}) findByProperty("${column.columnNameLower}",v);
	}	
	</#if>
	</#list>

}
