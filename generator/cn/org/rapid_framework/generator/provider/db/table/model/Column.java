package cn.org.rapid_framework.generator.provider.db.table.model;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import cn.org.rapid_framework.generator.GeneratorProperties;
import cn.org.rapid_framework.generator.provider.db.table.model.ForeignKey.ReferenceKey;
import cn.org.rapid_framework.generator.provider.db.table.model.util.ColumnHelper;
import cn.org.rapid_framework.generator.util.GLogger;
import cn.org.rapid_framework.generator.util.StringHelper;
import cn.org.rapid_framework.generator.util.TestDataGenerator;
import cn.org.rapid_framework.generator.util.typemapping.ActionScriptDataTypesUtils;
import cn.org.rapid_framework.generator.util.typemapping.DatabaseDataTypesUtils;
import cn.org.rapid_framework.generator.util.typemapping.JavaPrimitiveTypeMapping;
import cn.org.rapid_framework.generator.util.typemapping.JdbcType;

/**
 * 用于生成代码的Columb对象.对应数据库表column
 * @author badqiu
 * @email badqiu(a)gmail.com
 */
public class Column implements java.io.Serializable,Cloneable{
	/**
	 * Reference to the containing table
	 */
	private Table _table;

	/**
	 * The java.sql.Types type
	 */
	private int _sqlType;

	private String _validate;
	
	public String getValidate() {
		return _validate;
	}

	public void setValidate(String validate) {
		_validate = validate;
	}
	private int mandatory;
	public int getMandatory(){
		return this.mandatory;
	}
	public void setMandatory(int mand){
		this.mandatory = mand;
	}
	/**
	 * The sql typename. provided by JDBC driver
	 */
	private String _sqlTypeName;

	/**
	 * The name of the column
	 */
	private String _sqlName;

	/**
	 * True if the column is a primary key
	 */
	private boolean _isPk;

	/**
	 * True if the column is a foreign key
	 */
	private boolean _isFk;

	/**
	 * @todo-javadoc Describe the column
	 */
	private int _size;

	/**
	 * @todo-javadoc Describe the column
	 */
	private int _decimalDigits;

	/**
	 * True if the column is nullable
	 */
	private boolean _isNullable;

	/**
	 * True if the column is indexed
	 */
	private boolean _isIndexed;

	/**
	 * True if the column is unique
	 */
	private boolean _isUnique;

	/**
	 * Null if the DB reports no default value
	 */
	private String _defaultValue;
	
	/**
	 * The comments of column
	 */
	private String _remarks;

	
	private String _listShow="1";
	
	
	public String getListShow() {
		return _listShow;
	}

	public void setListShow(String listShow) {
		_listShow = listShow;
	}
	/**
	 * 是否显示在列表中
	 */
	private int _gridcolumn;
	public int getGridColumn() {
		return _gridcolumn;
	}

	public void setGridColumn(int gridcolumn) {
		_gridcolumn = gridcolumn;
	}
	
	private int _searchcolumn;
	

	public int getSearchColumn() {
		return _searchcolumn;
	}

	public void setSearchColumn(int searchcolumn) {
		_searchcolumn = searchcolumn;
	}
	
	private String listwidth="100";
	
	public String getListWidth() {
		return listwidth;
	}

	public void setListWidth(String listwidth) {
		this.listwidth = listwidth;
	}

	/**
	 * 是否可排序字段
	 */
	private int _ordercolumn;
	

	public int getOrderColumn() {
		return _ordercolumn;
	}

	public void setOrderColumn(int ordercolumn) {
		_ordercolumn = ordercolumn;
	}

	/**
	 * 显示类型
	 */
	
	private String _displaytype;
	private String _displayParam="";
	
	public String getDisplayParam() {
		return _displayParam;
	}

	public void setDisplayParam(String _displayParam) {
		this._displayParam = _displayParam;
	}

	public String getDisplayCss() {
		return _displayCss;
	}

	public void setDisplayCss(String _displayCss) {
		this._displayCss = _displayCss;
	}
	private String _displayCss="";
	private String _otherfields="";//用于设置而外的字段
	
	public String getDisplayType() {
		return _displaytype;
	}

	public String getOtherFields() {		
		return _otherfields;
	}

	public void setOtherFields(String otherfields) {
		_otherfields = otherfields;
	}

	public void setDisplayType(String displaytype) {
		_displaytype = displaytype;
	}
	
	private String _dataformat;

	public String getDataformat() {
		return _dataformat;
	}

	public void setDataformat(String dataformat) {
		this._dataformat = dataformat;
	}

	public String getDataSrcType() {
		return _datasrctype;
	}

	public void setDataSrcType(String datasrctype) {
		_datasrctype = datasrctype;
	}
	
	private String generate="manual";
	
	
	public String getGenerate() {
		return generate;
	}

	public void setGenerate(String generate) {
		this.generate = generate;
	}
	
	private String trigger="";
	
	public String getTrigger() {
		return trigger;
	}

	public void setTrigger(String trigger) {
		this.trigger = trigger;
	}
	private String generateParam="";
	

	public String getGenerateParam() {
		return generateParam;
	}

	public void setGenerateParam(String generateParam) {
		this.generateParam = generateParam;
	}

	/**
	 * 是否可编辑
	 */
	private String editable="true";

	public String getEditable() {
		return editable;
	}

	public void setEditable(String editable) {
		this.editable = editable;
	}

	public String getDataSrc() {
		return _datasrc;
	}

	public void setDataSrc(String datasrc) {
		_datasrc = datasrc;
	}



	/**
	 * 数据源类型
	 */
	private String _datasrctype;
	/**
	 * 数据源
	 */
	private String _datasrc;
	
	
	/**
	 * @param table
	 * @param sqlType
	 * @param sqlTypeName
	 * @param sqlName
	 * @param size
	 * @param decimalDigits
	 * @param isPk
	 * @param isNullable
	 * @param isIndexed
	 * @param isUnique
	 * @param defaultValue
	 * @param remarks
	 */
	public Column(Table table, int sqlType, String sqlTypeName,
			String sqlName, int size, int decimalDigits, boolean isPk,
			boolean isNullable, boolean isIndexed, boolean isUnique,
			String defaultValue,String remarks) {
		if(sqlName == null) throw new NullPointerException();
		_table = table;
		_sqlType = sqlType;
		_sqlName = sqlName;
		_sqlTypeName = sqlTypeName;
		_size = size;
		_decimalDigits = decimalDigits;
		_isPk = isPk;
		_isNullable = isNullable;
		_isIndexed = isIndexed;
		_isUnique = isUnique;
		_defaultValue = defaultValue;
		_remarks = remarks;
		
		GLogger.trace(sqlName + " isPk -> " + _isPk);
		
		initOtherProperties();
	}

	public Column(Column c) {
        this(c.getTable(),
           c.getSqlType(),
           c.getSqlTypeName(),
           c.getSqlName(),
           c.getSize(),
           c.getDecimalDigits(),
           c.isPk(),
           c.isNullable(),
           c.isIndexed(),
           c.isUnique(),
           c.getDefaultValue(),
           c.getRemarks());
	}
	
	public Column() {
	}
	
	/**
	 * Gets the SqlType attribute of the Column object
	 * 
	 * @return The SqlType value
	 */
	public int getSqlType() {
		return _sqlType;
	}

	/**
	 * Gets the Table attribute of the DbColumn object
	 * 
	 * @return The Table value
	 */
	public Table getTable() {
		return _table;
	}

	/**
	 * Gets the Size attribute of the DbColumn object
	 * 
	 * @return The Size value
	 */
	public int getSize() {
		return _size;
	}

	/**
	 * Gets the DecimalDigits attribute of the DbColumn object
	 * 
	 * @return The DecimalDigits value
	 */
	public int getDecimalDigits() {
		return _decimalDigits;
	}

	/**
	 * Gets the SqlTypeName attribute of the Column object
	 * 
	 * @return The SqlTypeName value
	 */
	public String getSqlTypeName() {
		return _sqlTypeName;
	}

	/**
	 * Gets the SqlName attribute of the Column object
	 * 
	 * @return The SqlName value
	 */
	public String getSqlName() {
		if(_sqlName == null) throw new NullPointerException();
		return _sqlName;
	}

	
	/**
	 * Gets the Pk attribute of the Column object
	 * 
	 * @return The Pk value
	 */
	public boolean isPk() {
		return _isPk;
	}

	/**
	 * Gets the Fk attribute of the Column object
	 * 
	 * @return The Fk value
	 */
	public boolean isFk() {
		return _isFk;
	}

	/**
	 * Gets the Nullable attribute of the Column object
	 * 
	 * @return The Nullable value
	 */
	public  boolean isNullable() {
		return _isNullable;
	}

	/**
	 * Gets the Indexed attribute of the DbColumn object
	 * 
	 * @return The Indexed value
	 */
	public  boolean isIndexed() {
		return _isIndexed;
	}

	/**
	 * Gets the Unique attribute of the DbColumn object
	 * 
	 * @return The Unique value
	 */
	public boolean isUnique() {
		return _isUnique;
	}

	/**
	 * Gets the DefaultValue attribute of the DbColumn object
	 * 
	 * @return The DefaultValue value
	 */
	public  String getDefaultValue() {
		return _defaultValue;
	}

    /**
     * 列的数据库备注
     * @return
     */
	public  String getRemarks() {
		return _remarks;
	}

    public void setUpdatable(boolean updatable) {
        this.updatable = updatable;
    }

    public void setInsertable(boolean insertable) {
        this.insertable = insertable;
    }
    
    public void setNullable(boolean v) {
        this._isNullable = v;
    }
    
    public void setUnique(boolean unique) {
        _isUnique = unique;
    }

    public void setPk(boolean v) {
        this._isPk = v;
    }	
	/**
	 * Describe what the method does
	 * 
	 * @return Describe the return value
	 * @todo-javadoc Write javadocs for method
	 * @todo-javadoc Write javadocs for return value
	 */
	public int hashCode() {
		if(getTable() != null) {
			return (getTable().getSqlName() + "#" + getSqlName()).hashCode();
		}else {
			return (getSqlName()).hashCode();
		}
	}

	/**
	 * Describe what the method does
	 * 
	 * @param o
	 *            Describe what the parameter does
	 * @return Describe the return value
	 * @todo-javadoc Write javadocs for method
	 * @todo-javadoc Write javadocs for method parameter
	 * @todo-javadoc Write javadocs for return value
	 */
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o instanceof Column) {
			Column other = (Column)o;
			if(getSqlName().equals(other.getSqlName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Describe what the method does
	 * 
	 * @return Describe the return value
	 * @todo-javadoc Write javadocs for method
	 * @todo-javadoc Write javadocs for return value
	 */
	public String toString() {
		return getSqlName();
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			//ignore
			return null;
		}
	}
	
	/**
	 * Describe what the method does
	 * 
	 * @return Describe the return value
	 * @todo-javadoc Write javadocs for method
	 * @todo-javadoc Write javadocs for return value
	 */
	protected  String prefsPrefix() {
		return "tables/" + getTable().getSqlName() + "/columns/" + getSqlName();
	}

	/**
	 * Sets the Pk attribute of the DbColumn object
	 * 
	 * @param flag
	 *            The new Pk value
	 */
	void setFk(boolean flag) {
		_isFk = flag;
	}
	
	public String getUnderscoreName() {
		return getSqlName().toLowerCase();
	}

    /** 
     * 根据列名，根据sqlName计算得出，示例值： BirthDate
     **/
	public String getColumnName() {
		return columnName;
	}

    /** 
     * 第一个字母小写的columName,等价于: StringHelper.uncapitalize(getColumnName()),示例值: birthDate
     **/
	public String getColumnNameFirstLower() {
		return StringHelper.uncapitalize(getColumnName());
	}

    /** 
     * 全部小写的columName,等价于: getColumnName().toLowerCase(),示例值: birthdate
     **/
	public String getColumnNameLowerCase() {
		return getColumnName().toLowerCase();
	}

    /**
     * 使用 getColumnNameFirstLower()替换
     * @deprecated use getColumnNameFirstLower() instead
     */
	public String getColumnNameLower() {
		return getColumnNameFirstLower();
	}

    /**
     * 得到 jdbcSqlType类型名称，示例值:VARCHAR,DECIMAL, 现Ibatis3使用该属性
     */
	public String getJdbcSqlTypeName() {
		return getJdbcType();
	}
	
	/**
     * 得到 jdbcSqlType类型名称，示例值:VARCHAR,DECIMAL, 现Ibatis3使用该属性
     */
    public String getJdbcType() {
        String result = JdbcType.getJdbcSqlTypeName(getSqlType());
        return result;
    }
    /**
     * 列的别名，等价于：getRemarks().isEmpty() ? getColumnNameFirstLower() : getRemarks()
     * 
     * <br />
     * 示例值: birthDate
     */
	public String getColumnAlias() {
		return columnAlias;
	}

    /**
     * 列的常量名称
     * 
     * <br />
     * 示例值: BIRTH_DATE
     */
	public String getConstantName() {
		return StringHelper.toUnderscoreName(getColumnName()).toUpperCase();
	}
	/**
     * 列的常量名称 小写
     * 
     * <br />
     * 示例值: birth_date
     */
	public String getConstantLowerName() {
		return StringHelper.toUnderscoreName(getColumnName()).toLowerCase();
	}
	/**
	 * 
	 * @deprecated
	 */
	public boolean getIsNotIdOrVersionField() {
		return !isPk();
	}
	
	/**得到 rapid-validation的验证表达式: required min-value-800  */
	public String getValidateString() {
		return isNullable() ? getNoRequiredValidateString() :  "required " + getNoRequiredValidateString();
	}
	
	/**得到 rapid-validation的验证表达式: min-value-800  */
	public String getNoRequiredValidateString() {
		return ColumnHelper.getRapidValidation(this);
	}

	/** 得到JSR303 bean validation(Hibernate Validator)的验证表达式: @NotNull @Min(100) @Max(800) */
	public String[] getHibernateValidatorConstraintNames() {
		return ColumnHelper.removeHibernateValidatorSpecialTags(getHibernateValidatorExprssion());
	}
	
	/** 得到JSR303 bean validation(Hibernate Validator)的验证表达式: @NotNull @Min(100) @Max(800) */
	public String getHibernateValidatorExprssion() {
		return hibernateValidatorExprssion;
	}

	public void setHibernateValidatorExprssion(String v) {
		hibernateValidatorExprssion = v;
	}
	
	/** 列是否是String类型 */
	public boolean getIsStringColumn() {
		return DatabaseDataTypesUtils.isString(getJavaType());
	}
	
	/** 列是否是日期类型 */
	public boolean getIsDateTimeColumn() {
		return DatabaseDataTypesUtils.isDate(getJavaType());
	}
	
	/** 列是否是Number类型 */
	public boolean getIsNumberColumn() {
		return DatabaseDataTypesUtils.isFloatNumber(getJavaType()) 
			|| DatabaseDataTypesUtils.isIntegerNumber(getJavaType());
	}
	
	/** 检查是否包含某些关键字,关键字以逗号分隔 */
	public boolean contains(String keywords) {
		if(keywords == null) throw new IllegalArgumentException("'keywords' must be not null");
		return StringHelper.contains(getSqlName(), keywords.split(","));
	}
	
	public boolean isHtmlHidden() {
		return (isPk() && _table.isSingleId())||
			this._displaytype.equals("hidden");//add dispalytype=hidden for inner use
	}

    /**
     * 得到对应的javaType,如java.lang.String,
     * @return
     */
	public String getJavaType() {
		return javaType;
	}

    /**
     * 得到简短的javaType的名称，如com.company.model.UserInfo,将返回 UserInfo
     * @return
     */
	public String getSimpleJavaType() {
		return StringHelper.getJavaClassSimpleName(getJavaType());
	}
	/**
     * 得到尽可能简短的javaType的名称，如果是java.lang.String,将返回String, 如com.company.model.UserInfo,将返回 com.company.model.UserInfo
     * @return
     */
	public String getPossibleShortJavaType() {
	    if(getJavaType().startsWith("java.lang.")) {
	        return getSimpleJavaType();
	    }else {
	        return getJavaType();
	    }
    }

	public boolean isPrimitive() {
	    return JavaPrimitiveTypeMapping.getWrapperTypeOrNull(getJavaType()) != null;
	}
    /**
     * 得到原生类型的javaType,如java.lang.Integer将返回int,而非原生类型,将直接返回getSimpleJavaType()
     * @return
     */	
	public String getPrimitiveJavaType() {
		return JavaPrimitiveTypeMapping.getPrimitiveType(getSimpleJavaType());
	}
	
	/** 得到ActionScript的映射类型,用于Flex代码的生成  */
	public String getAsType() {
		return asType;
	}
	
	/** 得到列的测试数据  */
	public String getTestData() {
		return new TestDataGenerator().getDBUnitTestData(getColumnName(),getJavaType(),getSize());
	}
	
	/** 列是否可以更新  */
	public boolean isUpdatable() {
		return updatable;
	}

	/** 列是否可以插入  */
	public boolean isInsertable() {
		return insertable;
	}
	
	/** 得到枚举(enum)的类名称，示例值：SexEnum  */
	public String getEnumClassName() {
		return enumClassName;
	}
	
	/** 枚举值,以分号分隔,示例值:M(1,男);F(0,女) 或者是:M(男);F(女)  */
	public String getEnumString() {
		
		String tmpenumstring="";
		 String []tmpitems = this._datasrc.split(";");
		 for(int i=0;i<tmpitems.length;i++)
		 {
			 String[] valTemp = tmpitems[i].split(":");
			 if(valTemp.length==2)
			 {
				 tmpenumstring += ";" + valTemp[0]+"("+valTemp[1]+")";
			 }
		 }
		 if(!"".equals(tmpenumstring))
			  tmpenumstring = tmpenumstring.substring(1);
		 return tmpenumstring;	 
   }
	  
	public String getEnumComboxList(){	
	 String tmpenumstring="";
	 String []tmpitems = this._datasrc.split(";");
	 for(int i=0;i<tmpitems.length;i++)
	 {
		 String[] valTemp = tmpitems[i].split(":");
		 if(valTemp.length==2)
		 {
			  tmpenumstring += ",'" + valTemp[0]+"':'"+valTemp[1]+"'";
		 }
	 }
	 if(!"".equals(tmpenumstring))
		 tmpenumstring = "#{"+tmpenumstring.substring(1)+"}";
	 return tmpenumstring;	 
}
	
	public HashMap<String,String> getEnumMap() {
		
		HashMap<String,String> enumMap  = new HashMap<String,String>();
		 String tmpenumstring="";
		 String []tmpitems = this._datasrc.split(";");
		 for(int i=0;i<tmpitems.length;i++)
		 {
			 String[] valTemp = tmpitems[i].split(":");
			 if(valTemp.length==2)
			 {
				 enumMap.put(valTemp[0], valTemp[1]);
			 }
		 }
		return enumMap;
	}

	
	public List<DataSrcItem> getDataSrcList() {
		List<DataSrcItem>tmplist =  new ArrayList();
		DataSrcItem tmpdata  =null;
		String [] tmpitems = this._datasrc.split(";");
		if(tmpitems!=null){
			for(int i=0;i<tmpitems.length;i++){
				String [] tmpstrs = tmpitems[i].split(":");
				if(tmpstrs.length==2){//key,value
					tmpdata = new DataSrcItem(tmpstrs[0],tmpstrs[1]);
					tmplist.add(tmpdata);
				}
				else if(tmpstrs.length==4)//条件，fktable,fkidcolumn,fknamecolumn
				{
					tmpdata = new DataSrcItem(tmpstrs[0],"",tmpstrs[1],tmpstrs[2],tmpstrs[3]);
					tmplist.add(tmpdata);
				}
			}			
		}		
		return tmplist;		
	}
	
	public List<String> getOtherFieldsList() {
		return StringHelper.string2List(this.getOtherFields());
	}
	
	/** 解析getEnumString()字符串转换为List<EnumMetaDada>对象  */
	
	public List<EnumMetaDada> getEnumList() {
		return StringHelper.string2EnumMetaData(getEnumString());
	}
	/** 是否是枚举列，等价于:return getEnumList() != null && !getEnumList().isEmpty()  */
	public boolean isEnumColumn() {
		return false;//getEnumList() != null && !getEnumList().isEmpty();
	}
	
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public void setColumnAlias(String columnAlias) {
		this.columnAlias = columnAlias;
	}

	public void setColumnName(String columnName) {
		//如果是D_的标准字段，那么去掉D_
		String tmpstr = columnName;
		if(tmpstr.toLowerCase().startsWith("d_"))
		{
			this.columnName = columnName.substring(2);
		}
		else this.columnName = columnName;
	}

	public void setAsType(String asType) {
		this.asType = asType;
	}

	public void setEnumClassName(String enumClassName) {
		this.enumClassName = enumClassName;
	}
	
	

//	public void setBelongsTo(String foreignKey) {
//		ReferenceKey ref = ReferenceKey.fromString(foreignKey);
//		if(ref != null && _table != null) {
//			_table.getImportedKeys().addForeignKey(ref.tableName, ref.columnSqlName, getSqlName(), ref.columnSqlName.hashCode());
//		}
//	}
//	
//	public void setHasAndBelongsToMany(String foreignKey) {
//	}

	private ReferenceKey hasOne;
	public String getHasOne() {
		return ReferenceKey.toString(hasOne);
	}
	
	/** nullValue for ibatis sqlmap: <result property="age" column="age" nullValue="0"  /> */
	public String getNullValue() {
		return JavaPrimitiveTypeMapping.getDefaultValue(getJavaType());
	}

	public boolean isHasNullValue() {
		return JavaPrimitiveTypeMapping.getWrapperTypeOrNull(getJavaType()) != null;
	}
	
    /**
     * 设置many-to-one,foreignKey格式: fk_table_name(fk_column) 或者 schema_name.fk_table_name(fk_column)
     * @param foreignKey
     * @return
     */
	public void setHasOne(String foreignKey) {
		hasOne = ReferenceKey.fromString(foreignKey);
		if(hasOne != null && _table != null) {
//			Table refTable = TableFactory.getInstance().getTable(hasOne.tableName);
//			_table.getImportedKeys().addForeignKey(refTable.getSqlName(), hasOne.columnSqlName, getSqlName(), hasOne.columnSqlName.toLowerCase().hashCode());
			_table.getImportedKeys().addForeignKey(hasOne.tableName, hasOne.columnSqlName, getSqlName(), hasOne.columnSqlName.toLowerCase().hashCode());
		}
	}
	
	private ReferenceKey hasMany = null;
	public String getHasMany() {
		return ReferenceKey.toString(hasMany);
	}

    /**
     * 设置one-to-many,foreignKey格式: fk_table_name(fk_column) 或者 schema_name.fk_table_name(fk_column)
     * @param foreignKey
     * @return
     */
	public void setHasMany(String foreignKey) {
		hasMany = ReferenceKey.fromString(foreignKey);
		if(hasMany != null && _table != null) {
//			Table refTable = TableFactory.getInstance().getTable(hasMany.tableName);
//			_table.getExportedKeys().addForeignKey(refTable.getSqlName(), hasMany.columnSqlName, getSqlName(), hasMany.columnSqlName.toLowerCase().hashCode());
			_table.getExportedKeys().addForeignKey(hasMany.tableName, hasMany.columnSqlName, getSqlName(), hasMany.columnSqlName.toLowerCase().hashCode());
		}
	}

	private void initOtherProperties() {
		String normalJdbcJavaType = DatabaseDataTypesUtils.getPreferredJavaType(getSqlType(), getSize(), getDecimalDigits());
		javaType = GeneratorProperties.getProperty("java_typemapping."+normalJdbcJavaType,normalJdbcJavaType).trim();
		
		
		
		columnName = StringHelper.toUnderscoreName(getSqlName());//update by micet 20150601
		//如果是D_的标准字段，那么去掉D_
		String tmpstr = columnName;
		if(tmpstr.toLowerCase().startsWith("d_"))
		{
			columnName = columnName.substring(2);
		}
		columnName = StringHelper.makeAllWordFirstLetterUpperCase(columnName);
		
		enumClassName = getColumnName()+"Enum";		
		asType = ActionScriptDataTypesUtils.getPreferredAsType(getJavaType());	
		columnAlias = StringHelper.removeCrlf(StringHelper.defaultIfEmpty(getRemarks(), getColumnNameFirstLower()));
		setHibernateValidatorExprssion(ColumnHelper.getHibernateValidatorExpression(this));
	}
	
	/** 删除聚集函数的相关char,示例转换 count(*) => count, max(age) => max_age, sum(income) => sum_income */
    public static String removeAggregationColumnChars(String columSqlName) {
        return columSqlName.replace('(', '_').replace(")", "").replace("*", "");
    }
	
    
    //下面的字段用于产生关联查询，用于采用其他的方法来生成sql语句，而不是采用hibernate
    private String fktable;//关联表
    public static String removeTableSqlNamePrefix(String sqlName) {
		String prefixs = GeneratorProperties.getProperty("tableRemovePrefixes", "");
		for(String prefix : prefixs.split(",")) {
			String removedPrefixSqlName = StringHelper.removePrefix(sqlName, prefix,true);
			if(!removedPrefixSqlName.equals(sqlName)) {
				return removedPrefixSqlName;
			}
		}
		return sqlName;
	}

    public String getFktableAsClassName(){
    	String tmpClassName = fktable;
          if(!StringHelper.isBlank(tmpClassName)) {
    	        String removedPrefixSqlName = removeTableSqlNamePrefix(fktable);
    	        String tmpstr = removedPrefixSqlName;
    	        //去掉T_或者TBL_
    	        if(tmpstr.toLowerCase().startsWith("t_"))
    	        {
    	        	removedPrefixSqlName = removedPrefixSqlName.substring(2);
    	        }
    	        else if(tmpstr.toLowerCase().startsWith("tbl_"))
    	        {
    	        	removedPrefixSqlName = removedPrefixSqlName.substring(4);
    	        }
    	        return StringHelper.makeAllWordFirstLetterUpperCase(StringHelper.toUnderscoreName(removedPrefixSqlName));
    	    }else {
    	    	return tmpClassName;
    	    }
    }
    public String getFktable() {
		return fktable;
	}

	public void setFktable(String fktable) {
		this.fktable = fktable;
	}

	public String getFkidcolumn() {
		return fkidcolumn;
	}

	public void setFkidcolumn(String fkidcolumn) {
		this.fkidcolumn = fkidcolumn;
	}

	public String getFknamecolumn() {
		return fknamecolumn;
	}

	public void setFknamecolumn(String fknamecolumn) {
		this.fknamecolumn = fknamecolumn;
	}

	public String getFkalias() {
		return fkalias;
	}

	public void setFkalias(String fkalias) {
		this.fkalias = fkalias;
	}

	private String fkidcolumn;//关联表用于关联的字段
    private String fknamecolumn;//关联表用于显示的字段名称
    private String fkalias;//用于产生新的字段别名
    private String fkcondcolumn;
    private String fkfilter;
    private String mandvalue;//强制值，一般用于设置例如operatorid等从Session中获取，或者从reqeust中获取
    private String condsearch;
    private String uploadfolder;
	public String getUploadfolder() {
		return uploadfolder;
	}

	public void setUploadfolder(String uploadfolder) {
		this.uploadfolder = uploadfolder;
	}

	public String getMandvalue() {
		return mandvalue;
	}

	public String getCondsearch() {
		return condsearch;
	}

	public void setCondsearch(String condsearch) {
		this.condsearch = condsearch;
	}

	public void setMandvalue(String mandvalue) {
		this.mandvalue = mandvalue;
	}

	public String getFkfilter() {
		return fkfilter;
	}

	public void setFkfilter(String fkfilter) {
		this.fkfilter = fkfilter;
	}

	public String getFkcondcolumn() {
		return fkcondcolumn;
	}
	public void setFkcondcolumn(String fkcondcolumn) {
		this.fkcondcolumn = fkcondcolumn;
	}
    
    
	private boolean unsigned = false;
	public boolean isUnsigned() {
		return unsigned;
	}

	public void setUnsigned(boolean unsigned) {
		this.unsigned = unsigned;
	}
	private int precision=0;
	private int scale=0;
	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}
	private String javaType;
	private String columnAlias;
	private String columnName;
	private String asType;	
	private String enumClassName;
	private boolean updatable = true;	
	private boolean insertable = true;	
	private String hibernateValidatorExprssion;
//	private String rapidValidation;
	/**
	 * public enum ${enumClassName} {
	 * 		${enumAlias}(${enumKey},${enumDesc});
	 * 		private String key;
	 * 		private String value;
	 * }
	 * @author badqiu
	 */
	public static class DataSrcItem{
		private String key;//用于保存 
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getFktable() {
			return fktable;
		}
		public void setFktable(String fktable) {
			this.fktable = fktable;
		}
		public String getFkidcolumn() {
			return fkidcolumn;
		}
		public void setFkidcolumn(String fkidcolumn) {
			this.fkidcolumn = fkidcolumn;
		}
		public String getFknamecolumn() {
			return fknamecolumn;
		}
		public void setFknamecolumn(String fknamecolumn) {
			this.fknamecolumn = fknamecolumn;
		}
		private String value;//用于显示
		//只用于condtable的datasrc=2的情况	
		private String fktable;
		private String fkidcolumn;
		private String fknamecolumn;
		public DataSrcItem(String key,String value){
			this.key = key;
			this.value = value;
			
		}
		public DataSrcItem(String key,String value,String fktable,String fkidcolumn,String fknamecolumn){
			this.key = key;
			this.value = value;
			this.fktable = fktable;
			this.fkidcolumn = fkidcolumn;
			this.fknamecolumn = fknamecolumn;
		}
	};
	public static class EnumMetaDada {
		private String enumAlias;
		private String enumKey;
		private String enumDesc;
		public EnumMetaDada(String enumAlias, String enumKey, String enumDesc) {
			super();
			this.enumAlias = enumAlias;
			this.enumKey = enumKey;
			this.enumDesc = enumDesc;
		}
		
		public String getEnumAlias() {
			return enumAlias;
		}
		public String getEnumKey() {
			return enumKey;
		}
		public String getEnumDesc() {
			return enumDesc;
		}
	}
	
	private String cond;
	public String getCond() {
		return cond;
	}

	public void setCond(String cond) {
		this.cond = cond;
	}

	
}
