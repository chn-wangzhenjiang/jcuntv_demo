<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.model;

import java.util.List;
import java.math.BigDecimal;
import com.micet.utils.SafeUtils;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import javax.validation.constraints.*;

import org.hibernate.mapping.Map;
import org.hibernate.validator.constraints.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.org.rapid_framework.generator.provider.db.table.model.Column.EnumMetaDada;

<#include "/java_imports.include">

@Entity
@Table(name = "${table.sqlName}")
public class ${className} extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "${table.tableAlias}";
	<#list table.columns as column>
	
	
	public static final String ALIAS_${column.constantName} = "${column.columnAlias}";
	<#if column.dataSrc!="">
		public static final String ENUM_${column.constantName} = "${column.dataSrc}";	
	</#if>
	</#list>
	
	//date formats
	<#list table.columns as column>
	<#if column.isDateTimeColumn>
		<#if column.dataformat!="">
	public static final String FORMAT_${column.constantName} = "${column.dataformat}";
		<#else>
	public static final String FORMAT_${column.constantName} = DATE_TIME_FORMAT;
		</#if>
	<#elseif column.displayType="datetime">
		<#if column.dataformat!="">
	public static final String FORMAT_${column.constantName} = "${column.dataformat}";
		<#else>
	public static final String FORMAT_${column.constantName} = DATE_TIME_FORMAT;
		</#if>
	<#elseif column.displayType="time">
		<#if column.dataformat!="">
	public static final String FORMAT_${column.constantName} = "${column.dataformat}";
		<#else>
	public static final String FORMAT_${column.constantName} = TIME_FORMAT;
		</#if>
	</#if>
	</#list>
	
	<@generateFields/>
	<@generateCompositeIdConstructorIfis/>
	<@generatePkProperties/>
	<@generateNotPkProperties/>
	<@generateJavaManyToOne/>

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
		<#list table.columns as column>
			<#if !table.compositeId>
			.append("${column.columnName}",get${column.columnName}())
			</#if>
		</#list>
			.toString();
	}
	public String toObjectString() {
		return new StringBuilder("")
		<#list table.columns as column>
			<#if !table.compositeId>
			.append("${column.columnName}").append("=").append(get${column.columnName}()).append("\r\n")
			</#if>
		</#list>
			.toString();
	}
	public int hashCode() {
		return new HashCodeBuilder()
		<#list table.pkColumns as column>
			<#if !table.compositeId>
			.append(get${column.columnName}())
			</#if>
		</#list>
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ${className} == false) return false;
		if(this == obj) return true;
		${className} other = (${className})obj;
		return new EqualsBuilder()
			<#list table.pkColumns as column>
				<#if !table.compositeId>
			.append(get${column.columnName}(),other.get${column.columnName}())
				</#if>
			</#list>
			.isEquals();
	}
	public List<GenericProperty> toPropertyList(){
		List<GenericProperty> tmplist = new ArrayList<GenericProperty>();
		<#list table.columns as column> 
			tmplist.add(new GenericProperty("${column.columnName}","${column.javaType}",""+this.get${column.columnName}(),"${column.dataformat}"));	
		</#list>
		return tmplist;
	}
	public boolean initFromRawMap(java.util.Map map){
		boolean tmpret = true;
		if(map!=null){
		<#list table.columns as column>
		    if(map.containsKey("${column.sqlName}"))
		    {
		    	<#--${column.javaType}-->
			<#if column.javaType="java.lang.Integer" ||column.javaType="Integer">
				this.set${column.columnName}(SafeUtils.getInt(map.get("${column.sqlName}")));
			<#elseif column.javaType="java.lang.Long" ||  column.javaType="Long">
				this.set${column.columnName}(SafeUtils.getLong(map.get("${column.sqlName}")));
			<#elseif column.javaType="java.math.BigDecimal" ||  column.javaType="BigDecimal">
				this.set${column.columnName}(SafeUtils.getBigDecimal(map.get("${column.sqlName}")));
			<#elseif column.javaType="java.lang.Double" ||  column.javaType="Double">
				this.set${column.columnName}(SafeUtils.getDouble(map.get("${column.sqlName}")));
			<#elseif column.isDateTimeColumn>
				this.set${column.columnName}(SafeUtils.getDateFromTimeStamp(map.get("${column.sqlName}")));
			<#else>
				this.set${column.columnName}(SafeUtils.getString(map.get("${column.sqlName}")));
			</#if>
			<#if column.fktable!="">
				this.set${column.fkalias}(SafeUtils.getString(map.get("${column.fkalias}")));
			</#if>
		    }
		    <#if column.isDateTimeColumn>
		    	else if(map.containsKey("${column.sqlName}AsString")){		    	
		    		this.set${column.columnName}AsString(SafeUtils.getString(map.get("${column.sqlName}AsString")));
		    	}	
		    </#if>
		   	    
		</#list>
		}
		return tmpret;
	}
	public boolean initFromRawMapWithAllString(java.util.Map map){
		boolean tmpret = true;
		if(map!=null){
		<#list table.columns as column>
		    if(map.containsKey("${column.sqlName}"))
		    {
		    	<#--${column.javaType}-->
			<#if column.javaType="java.lang.Integer" ||column.javaType="Integer">
				this.set${column.columnName}(SafeUtils.getInt(map.get("${column.sqlName}")));
			<#elseif column.javaType="java.lang.Long" ||  column.javaType="Long">
				this.set${column.columnName}(SafeUtils.getLong(map.get("${column.sqlName}")));
			<#elseif column.javaType="java.math.BigDecimal" ||  column.javaType="BigDecimal">
				this.set${column.columnName}(SafeUtils.getBigDecimal(map.get("${column.sqlName}")));
			<#elseif column.javaType="java.lang.Double" ||  column.javaType="Double">
				this.set${column.columnName}(SafeUtils.getDouble(map.get("${column.sqlName}")));
			<#elseif column.isDateTimeColumn>
				this.set${column.columnName}AsString(SafeUtils.getString(map.get("${column.sqlName}")));
			<#else>
				this.set${column.columnName}(SafeUtils.getString(map.get("${column.sqlName}")));
			</#if>
			<#if column.fktable!="">
				this.set${column.fkalias}(SafeUtils.getString(map.get("${column.fkalias}")));
			</#if>
		    }
		</#list>
		}
		return tmpret;
	}
}

<#macro generateFields>

<#if table.compositeId>
	private ${className}Id id;
	<#list table.columns as column>
		<#if !column.pk>			
			<#if column.generate="auto">
				<#if column.displayType="unixtime">
					<#if column.javaType="java.lang.Integer">
						private ${column.javaType} ${column.columnNameLower}=(int)(System.currentTimeMillis()/1000);
					<#elseif column.javaType="java.util.Date">
						private ${column.javaType} ${column.columnNameLower};
					<#else>
						private ${column.javaType} ${column.columnNameLower};
					</#if>
				<#else>
					private ${column.javaType} ${column.columnNameLower};
				</#if>				
			<#else>				
					private ${column.javaType} ${column.columnNameLower};
			</#if>			
		</#if>
	</#list>
<#else>
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	<#list table.columns as column>
    /**
     * ${column.columnAlias!}       db_column: ${column.sqlName} 
     */ 	
	${column.hibernateValidatorExprssion}
	<#if column.generate="auto">
	<#if column.displayType="unixtime">
		<#if column.javaType="java.lang.Integer">
			private ${column.javaType} ${column.columnNameLower}=(int)(System.currentTimeMillis()/1000);
		<#elseif column.javaType="java.util.Date">
			private ${column.javaType} ${column.columnNameLower};
		<#else>
			private ${column.javaType} ${column.columnNameLower};
		</#if>
	<#else>
		private ${column.javaType} ${column.columnNameLower};
	</#if>				
	<#else>
		<#if column.defaultValue??>
			<#if column.displayType="md5password">		 
			private ${column.javaType} ${column.columnNameLower} = "${column.defaultValue}";
			private ${column.javaType} ${column.columnNameLower}__md5;/*for md5 transfer*/
		 	<#else>
				<#if column.javaType="java.lang.String">
			private ${column.javaType} ${column.columnNameLower} = "${column.defaultValue}";
				<#elseif column.javaType="java.lang.Long">
			private ${column.javaType} ${column.columnNameLower} = ${column.defaultValue}L;
				<#elseif column.javaType="java.math.BigDecimal" ||  column.javaType="BigDecimal">
			private ${column.javaType} ${column.columnNameLower} = new BigDecimal(${column.defaultValue});
				<#else>
			private ${column.javaType} ${column.columnNameLower} = ${column.defaultValue};
				</#if>
			</#if>
		<#else>
			 <#if column.displayType="md5password">
			 private ${column.javaType} ${column.columnNameLower};
			 private ${column.javaType} ${column.columnNameLower}__md5;/*for md5 transfer*/
			 <#else>
			 private ${column.javaType} ${column.columnNameLower};
			 </#if>
		</#if>
	 </#if>
	 <#if column.fktable!="">			
		private java.lang.String  ${column.fkalias?uncap_first};
	 </#if>
	
	</#list>
	//columns END
</#if>

</#macro>

<#macro generateCompositeIdConstructorIfis>

	<#if table.compositeId>
	public ${className}(){
	}
	public ${className}(${className}Id id) {
		this.id = id;
	}
	<#else>
	<@generateConstructor className/>
	</#if>
	
</#macro>

<#macro generatePkProperties>
	<#if table.compositeId>
	@EmbeddedId
	public ${className}Id getId() {
		return this.id;
	}
	
	public void setId(${className}Id id) {
		this.id = id;
	}
	<#else>
		<#list table.columns as column>
			<#if column.pk>

	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}

	<#-- mysql-->
 @Id @GeneratedValue(generator="custom-id")
	@GenericGenerator(name="custom-id", strategy = "increment")
<#-- 
 ORACLE
 	@Id  
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="S_${table.sqlName}_ID")  
	@SequenceGenerator(name="S_${table.sqlName}_ID", sequenceName="S_${table.className?upper_case}_${column.sqlName?upper_case}")  
--> 
	@Column(name = "${column.sqlName}", unique = ${column.unique?string}, nullable = ${column.nullable?string}, insertable = true, updatable = true, length = ${column.size})
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
			</#if>
		</#list>
	</#if>
	
</#macro>

<#macro generateNotPkProperties>
	<#list table.columns as column>
		<#if !column.pk>
		
			<#if column.displayType="md5password">	
	@Transient
	public String get${column.columnName}__md5() {
		return this.${column.columnNameLower}__md5;
	}
	public void set${column.columnName}__md5(String value) {
		this.${column.columnNameLower}__md5 = value;
	}			
			
			<#elseif column.isDateTimeColumn>
	@Transient
	public String get${column.columnName}AsString() {
			return DateConvertUtils.format(get${column.columnName}(), FORMAT_${column.constantName});
	}
	public void set${column.columnName}AsString(String value) {
			set${column.columnName}(DateConvertUtils.parse(value, FORMAT_${column.constantName},${column.javaType}.class));
	}	
			<#elseif column.displayType=="popup">
			@Transient
			public String get${column.fkalias}() {
				return this.${column.fkalias?uncap_first};
			}
			public void set${column.fkalias}(String ${column.fkalias?uncap_first}) {
				this.${column.fkalias?uncap_first} = ${column.fkalias?uncap_first};
			}
			<#elseif column.displayType=="efcdpopup">
			@Transient
			public String get${column.fkalias}() {
				return this.${column.fkalias?uncap_first};
			}
			public void set${column.fkalias}(String ${column.fkalias?uncap_first}) {
				this.${column.fkalias?uncap_first} = ${column.fkalias?uncap_first};
			}
			<#elseif column.displayType="combo">
				<#if column.fktable !="" && column.displayType="combo" && column.dataSrcType="2">
			@Transient
			public String get${column.fkalias}() {
					return this.${column.fkalias?uncap_first};
			}
			public void set${column.fkalias}(String ${column.fkalias?uncap_first}) {
					this.${column.fkalias?uncap_first} = ${column.fkalias?uncap_first};
			}
				<#elseif column.dataSrc!="">
			@Transient
			public String get${column.columnName}Enum() {
					return getEnumValue(get${column.columnName}(), ENUM_${column.constantName});
			}
				</#if>
			<#elseif column.displayType="unixtime">
	@Transient
	public String get${column.columnName}AsDateTime() {
		<#if column.dataformat="yyyy-MM-dd">
		return getFormatDateTimeFromUnixTime(get${column.columnName}(),"yyyy-MM-dd");
		<#else>
		return getFormatDateTimeFromUnixTime(get${column.columnName}());
		</#if>
	}
	@Transient
	public void set${column.columnName}AsDateTime(String value){
		<#if column.dataformat="yyyy-MM-dd">
		set${column.columnName}(getUnixTimeFromString(value,"yyyy-MM-dd"));
		<#else>
		set${column.columnName}(getUnixTimeFromString(value,"yyyy-MM-dd HH:mm:ss"));
		</#if>
	}
			<#elseif column.displayType="multiline">
			@Transient
			public String get${column.columnName}AsLabel() {
				return getDisplayLabelForMultilineText(get${column.columnName}());
			}			
			</#if>		
	
	@Column(name = "${column.sqlName}", unique = ${column.unique?string}, nullable = ${column.nullable?string}, insertable = true, updatable = true, length = ${column.size})
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	
		</#if>
	</#list>
</#macro>


<#macro generateJavaOneToMany>
	<#list table.exportedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.parentTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	
	
	private Set ${fkPojoClassVar}s = new HashSet(0);
	public void set${fkPojoClass}s(Set<${fkPojoClass}> ${fkPojoClassVar}){
		this.${fkPojoClassVar}s = ${fkPojoClassVar};
	}
	
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "${classNameLower}")
	public Set<${fkPojoClass}> get${fkPojoClass}s() {
		return ${fkPojoClassVar}s;
	}
	</#list>
</#macro>

<#macro generateJavaManyToOne>
	<#list table.importedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.parentTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	<#assign tableNameVar = foreignKey.childTable>
	
	private ${tableNameVar.className} ${tableNameVar.className?uncap_first};
	public void set${tableNameVar.className}(${tableNameVar.className} ${tableNameVar.className?uncap_first}){
		this.${tableNameVar.className?uncap_first} = ${tableNameVar.className?uncap_first};
	}
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumns({
	<#list foreignKey.parentColumns?values as fkColumn>
		@JoinColumn(name = "${fkColumn}",nullable = false, insertable = false, updatable = false) <#if fkColumn_has_next>,</#if>
    </#list>
	})
	public ${tableNameVar.className} get${tableNameVar.className}() {
		return ${tableNameVar.className?uncap_first};
	}
	</#list>
</#macro>

