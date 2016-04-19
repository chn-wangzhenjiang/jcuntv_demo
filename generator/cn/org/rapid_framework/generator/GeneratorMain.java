package cn.org.rapid_framework.generator;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;


import cn.org.rapid_framework.generator.provider.db.table.TableFactory;
import cn.org.rapid_framework.generator.provider.db.table.model.ButtonInfo;
import cn.org.rapid_framework.generator.provider.db.table.model.Column;
import cn.org.rapid_framework.generator.provider.db.table.model.Table;


/**
 * 
 * @author badqiu
 * @email badqiu(a)gmail.com
 */

public class GeneratorMain {
	public final static String DBTYPE="MYSQL";//ORACLE";//MYSQL 两个选项
	public static Map<String, String> tableMap = new HashMap<String, String>();
	public static Map<String, Map<String,String>> tableColumMap = new HashMap<String, Map<String,String>>();

	public static void initMap(String file){
		AccessTextFile accessTextFile = new AccessTextFile();
		StringBuffer buf = new StringBuffer();
		InputStream is;
		try {
			is = new   FileInputStream(file);
			accessTextFile.readToBuffer(buf, is);
			String text = new String(buf.toString().getBytes(),"utf-8");
//			System.out.println("buf:"+text);
			is.close();
			
			String[] tableArray = text.split("CREATE TABLE");
			System.out.println("tableArray:"+tableArray.length);
			
			for (int i=1;i<tableArray.length;i++){
				String temp = tableArray[i];
				String tabName = temp.substring(1,temp.indexOf("("));
				int lr = tabName.indexOf("\\n");
				if(lr>=0){
					tabName = tabName.substring(0,lr);
				}
				System.out.println("tabName:"+tabName);
				String s ="COMMENT ON TABLE "+tabName+" IS '";
				int l = temp.indexOf(s);
				
				String tabDesc = "";
				if(l>0){
					String str = temp.substring(l);
					tabDesc = str.substring(s.length(),str.indexOf("';"));
				}
				System.out.println("tabDesc:"+tabDesc);
				tableMap.put(tabName, tabDesc);
				Map<String,String> columMap = new HashMap<String,String>();
				String[] columTemp = temp.split("COMMENT ON COLUMN "+tabName+".");
				for(int k=1;k<columTemp.length;k++){
					String tmp = columTemp[k];
					int ln = tmp.indexOf("IS '");
					String columName = tmp.substring(0,ln);
					int lcr = columName.indexOf("\\n");
					if(lcr>=0){
						columName = columName.substring(0,lcr);
					}
					System.out.println("columName:"+columName);
					int pl = tmp.indexOf(";");
					String columDesc = "";
					if(pl>0){
						columDesc = tmp.substring(ln+4,pl-1);
					}
					columMap.put(columName, columDesc);
					System.out.println("columDesc:"+columDesc);
				}
				tableColumMap.put(tabName, columMap);
			}
			System.out.println("tableMap:"+tableMap.size());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 根据属性文件
	 * @param file
	 */
	public static void initPropMap(String file){
		AccessTextFile accessTextFile = new AccessTextFile();
		StringBuffer buf = new StringBuffer();
		InputStream is;
		int ln = 0;
		int tmpindex=0;
		String tmppropname="";
		String tmppropvalue="";
		try   {
			is = new   FileInputStream(file);
			DataInputStream   in   =   new   DataInputStream(is);
			while   (in.available()   !=0)   {
				String text = new String(in.readLine().getBytes("iso8859-1"),"utf-8");
	     	   	System.out.println("text:"+text);
	     	   	tmpindex =  text.indexOf("=");
	     	   	if(tmpindex!=-1)
	     	   	{
	     	   		tmppropname = text.substring(0,tmpindex);
	     	   		tmppropname = tmppropname.trim();
	     	   		tmppropvalue = text.substring(tmpindex+1);
	     	   		if(!tmppropname.startsWith("#"))//跳过注释
	     	   		{
	     	   			tableMap.put(tmppropname.trim().toUpperCase(), tmppropvalue.trim());
	     	   		}
	     	  
	     	   	}
	     	   	ln++;
			}
			in.close();
		}   catch   (Exception   e)   {
		System.err.println( "File   input   error ");
		} 
		
//		try {
//			is = new   FileInputStream(file);
//			FileReader fileRead = new FileReader(file);
//			 String   line;                 //   用来保存每行读取的内容
////	           BufferedReader   reader   =   new   BufferedReader(new   InputStreamReader(is));
//			 BufferedReader   reader   =   new   BufferedReader(fileRead);
//			 
//	           line   =   reader.readLine();               //   读取第一行
//	           int ln = 0;
//	           while   (line   !=   null)   {                     //   如果   line   为空说明读完了
//	        	   String text = new String(line.getBytes("iso8859-1"),"utf-8");
//	        	   System.out.println("text:"+text);
//	                   String[] temp = text.split("=");
//	                   if(temp.length<2){
//	                	   tableMap.put(temp[0].trim(), temp[0].trim());
//	                   }else{
//	                	   tableMap.put(temp[0].trim(), temp[1].trim());
//	                   }
//	                   line   =   reader.readLine();       //   读取下一行
//	                   ln++;
//	                   System.out.println("ln"+ln);
//	           }
//			String text = new String(buf.toString().getBytes(),"utf-8");
//			System.out.println("buf:"+text);
//			is.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	/**
	 * 请直接修改以下代码调用不同的方法以执行相关生成任务.
	 */
	public static void main(String[] args) throws Exception {
		
		String tmporders="OPTime:ASC|";
		tmporders = tmporders.replaceAll("\\|" , "");
		tmporders =tmporders.replaceAll(":", " ");			

		String file = "/Users/joe/rspro/rsbjs.properties";
		initPropMap(file);
		GeneratorFacade g = new GeneratorFacade();
//		g.printAllTableNames();				//打印数据库中的表名称
		List<Table> tableList = TableFactory.getInstance().getAllTables();
		StringBuffer buf = new StringBuffer();
		
	
		
		for(Table t : tableList){
			buf.append("outlookbar.additem('"+t.getTableAlias()+"',t,'pages/"+t.getClassName()+"/showGrid.do')\r\n");
		}
		
		g.deleteOutRootDir();							//删除生成器的输出目录
		//GeneratorProperties.getRequiredProperty("outRoot");
		//下面是记录所有表格和字段信息的文件
		LinkedHashSet<Column> tmpcolumns  = null;
		Column tmpcolumn= null;
		StringBuffer tmpsb =new StringBuffer();
		StringBuffer tmpsb2 =new StringBuffer();
		StringBuffer tmpsb5 = new StringBuffer();
		int tmptablealiasseq=0;
		String tmptablelink="";
		String tmpfields="";
		String tmpstr="";
		String tmppkidname="";
		int tmpcurrenttreattablecount=0;
		for(Table t : tableList){			
			//只处理符合规范的表格			
			tmpcolumns = t.getColumns();
			tmptablealiasseq=0;
			tmptablelink="";
			tmpfields="";			
			
			tmpstr = "create sequence S_"+t.getClassNameUpperCase()+"_"+t.getPkName().toUpperCase()+" minvalue 1 maxvalue 1000000000000000000000000000 start with 1 increment by 1 cache 20;\r\n";

			
			tmpsb5.append(tmpstr);
			
			//判断alias,获得关联的表名，字段等信息用于建立join,缺省全部为left join,今后可以考虑扩展
			
			if(DBTYPE.equals("ORACLE"))
				tmptablelink = t.getSqlName()+" t";
			else tmptablelink = t.getSqlName()+" as t";
			tmpfields = "t.*";//为了有效期间实际大部分字段可以不读取，这边简化多做了读取，例如text,blob,clob等字段
			//一般只用于int,flot,varchar等
			Iterator itr = tmpcolumns.iterator();
			String tmpkdomain="";
		    while (itr.hasNext()){
		     tmpcolumn = (Column)itr.next();
		     
		     if((tmpcolumn.getFktable()!=null)&&(!tmpcolumn.getFktable().equals("")))
		     {
		    	 tmptablealiasseq++;
		    	 if(DBTYPE.equals("ORACLE"))
		    		 tmptablelink+= " left join "+tmpcolumn.getFktable()+" t"+tmptablealiasseq;
		    	 else tmptablelink+= " left join "+tmpcolumn.getFktable()+" as t"+tmptablealiasseq;
		    	 tmptablelink+=" on t."+tmpcolumn.getSqlName()+"=t"+tmptablealiasseq+"."+tmpcolumn.getFkidcolumn();
		    	 tmpfields+=",t"+tmptablealiasseq+"."+tmpcolumn.getFknamecolumn()+" as "+ tmpcolumn.getFkalias();		    	
		     }
		     else if(tmpcolumn.isPk()){
		    	 tmpkdomain = tmpcolumn.getSqlName();
		     }
		     else{
		     }
		    }		    
		    tmpsb.append("tmptable = new TableInfo(\"").append(t.getClassName()).append("\",\"").append(t.getSqlName()).append("\",\"").append(t.getRemarks()).append("\");");
		    tmpsb.append("\r\n");
		    if(!tmpkdomain.equals(""))tmpsb.append(" tmptable.setPkdomain(\"").append(tmpkdomain).append("\");\r\n");
		    tmpsb.append("tmptable.setTablelink(\"").append(tmptablelink).append("\");");
		    tmpsb.append("\r\n");
			tmpsb.append("tmptable.setLinkfields(\"").append(tmpfields).append("\");");
			tmpsb.append("\r\n");
			
			
			
			//设置缺省排序，这样分页才速度快，否则会较慢
			if(t.getSortOrder()!=null){
				 tmporders = t.getSortOrder();
				if(!tmporders.equals("")){
					tmporders = tmporders.replaceAll("\\|" , "");
					tmporders =tmporders.replaceAll(":", " ");					
					tmpsb.append("tmptable.setSortorder(\"t.").append(tmporders).append("\");"); 
					tmpsb.append("\r\n");
				}
			}		
			
			tmptablealiasseq=0;
			 itr = tmpcolumns.iterator();
			 while (itr.hasNext()){
				
				 tmpcolumn = (Column)itr.next();
				 if(tmpcolumn.getDisplayType().equals("multiline")||tmpcolumn.getDisplayType().equals("richtext"))continue;//跳过多行的，或者多媒体html编辑的
				 if(tmpcolumn.getListShow().equals("0"))continue;
			tmpsb.append("tmptable.getColumns().add(new ColumnInfo(\"").append(tmpcolumn.getSqlName())
			.append("\",\"").append(tmpcolumn.getRemarks())
			.append("\",").append(tmpcolumn.isPk()==true?"true":"false")
			.append(",\"").append(tmpcolumn.getDisplayType())
			.append("\",\"").append(tmpcolumn.getDataSrcType())
			.append("\",\"").append(tmpcolumn.getDataSrc());
			  if((tmpcolumn.getFktable()!=null)&&(!tmpcolumn.getFktable().equals("")))
		     { tmptablealiasseq++;
				  tmpsb.append("\",\"").append(tmpcolumn.getFktable())
				  .append("\",\"").append(tmpcolumn.getFkidcolumn())
				  .append("\",\"").append(tmpcolumn.getFknamecolumn())
				  .append("\",\"").append("t"+tmptablealiasseq)
				  .append("\",\"").append(tmpcolumn.getFkalias());
		     }else{
		    	 tmpsb.append("\",\"").append("")
		    	 .append("\",\"").append("")
					.append("\",\"").append("")
					.append("\",\"").append("")
					.append("\",\"").append("");
		     }
			tmpsb.append("\",\"").append(tmpcolumn.getListWidth())
			.append("\"));\r\n");
			 }		
			 if(DBTYPE.equals("ORACLE")){
				 tmpsb2.append("insert into t_sysmenu (PKID,MenuName,MenuTips,NavigateUrl,NavigateTarget,Image,HoverImage,ActiveImage,ParentID,Seq,Status) values (S_SYSMENU_PKID.nextval,'").append(t.getTableAlias()).append("','','pages/").append(t.getClassName()).append("/list.do','','").append(t.getMenuIcon()).append("','").append(t.getMenuIcon()).append("','").append(t.getMenuIcon()).append("',47,2,1);");
			 }
			 else tmpsb2.append("insert into `t_sysmenu` (`MenuName`,`MenuTips`,`NavigateUrl`,`NavigateTarget`,`Image`,`HoverImage`,`ActiveImage`,`ParentID`,`Seq`,`Status`) values ('").append(t.getTableAlias()).append("','','pages/").append(t.getClassName()).append("/list.do','','").append(t.getMenuIcon()).append("','").append(t.getMenuIcon()).append("','").append(t.getMenuIcon()).append("',47,2,1);");
			tmpsb2.append("\r\n");
			tmpsb.append("tableMap.put(\"").append(t.getClassName().toLowerCase()).append("\",tmptable);");
			tmpsb.append("\r\n");
			tmpcurrenttreattablecount++;
		}
		createTxT("/Users/joe/rspro/generator_tableinfos.txt",tmpsb.toString());
		createTxT("/Users/joe/rspro/generator_menu.sql",tmpsb2.toString());
		createTxT("/Users/joe/rspro/generator_seq.sql",tmpsb5.toString());
		StringBuilder tmpsb3 = new StringBuilder();
		String tmprights="";
		String tmpname="";
		int tmppow=0;
		String tmpfktablealias="";
		StringBuilder tmpsb4 = new StringBuilder();
		for(Table t : tableList){						
			List<ButtonInfo> tmpbtninfos = t.getButtons();
			tmprights="";
			tmppow=0;
			for(int zz=0;zz<tmpbtninfos.size();zz++){				
				tmprights +=tmpbtninfos.get(zz).getOpname()+":"+tmpbtninfos.get(zz).getTitle()+";";
				tmpname = t.getTableAlias()+"["+tmpbtninfos.get(zz).getTitle()+"]";
				tmppow = (int)Math.pow(2, zz);
				if(DBTYPE.equals("ORACLE"))
					tmpsb3.append("insert into t_objectrights(PKID,Name,ObjectType,ObjectName,ObjectID,OPName,OPCNName,OPValue,Status)values(S_OBJECTRIGHTS_PKID.nextval,\'"+tmpname+"\',\'TABLE\',\'"+t.getTableAlias()+"\',\'"+t.getSqlName()+"\',\'"+tmpbtninfos.get(zz).getOpname()+"\',\'"+tmpbtninfos.get(zz).getOpname()+"\',"+tmppow+",1)");
				else
					tmpsb3.append("insert into t_objectrights(Name,ObjectType,ObjectName,ObjectID,OPName,OPCNName,OPValue,Status)values(\'"+tmpname+"\',\'TABLE\',\'"+t.getTableAlias()+"\',\'"+t.getSqlName()+"\',\'"+tmpbtninfos.get(zz).getOpname()+"\',\'"+tmpbtninfos.get(zz).getOpname()+"\',"+tmppow+",1)");
tmpsb3.append(";\r\n");			
			}
			
			
			if(DBTYPE.equals("ORACLE"))
				tmptablelink = t.getSqlName()+" t";
			else tmptablelink = t.getSqlName()+" as t";
			tmpfields = "t.*";//为了有效期间实际大部分字段可以不读取，这边简化多做了读取，例如text,blob,clob等字段
			//一般只用于int,flot,varchar等
			
			if(t.getSqlName().equals("t_cmschannel")){
				System.out.println("ab");
			}
			String tmpkdomain="";
			tmpfktablealias="";
			tmptablealiasseq=0;
			tmpcolumns = t.getColumns();
			Iterator itr = tmpcolumns.iterator();
		    while (itr.hasNext()){
		     tmpcolumn = (Column)itr.next();		     
		     if((tmpcolumn.getFktable()!=null)&&(!tmpcolumn.getFktable().equals("")))
		     {
		    	 tmptablealiasseq++;
		    	 if(DBTYPE.equals("ORACLE"))
		    		 tmptablelink+= " left join "+tmpcolumn.getFktable()+" t"+tmptablealiasseq;
		    	 else tmptablelink+= " left join "+tmpcolumn.getFktable()+" as t"+tmptablealiasseq;
		    	 tmptablelink+=" on t."+tmpcolumn.getSqlName()+"=t"+tmptablealiasseq+"."+tmpcolumn.getFkidcolumn();
		    	 tmpfields+=",t"+tmptablealiasseq+"."+tmpcolumn.getFknamecolumn()+" as "+ tmpcolumn.getFkalias();		    	
		     }
		     else if(tmpcolumn.isPk()){
		    	 tmpkdomain = tmpcolumn.getSqlName();
		     }
		     else{
		     }
		    }		
		    
			 tmpsb4.append("insert into t_tableinfo(Name,ListLink,ListFields,CNName,ObjectName,SqlTable,SortOrder)values(")
			 .append("\'").append(t.getClassName()).append("\',")
			 .append("\'").append(tmptablelink).append("\',")
			 .append("\'").append(tmpfields).append("\',")
			 .append("\'").append(t.getRemarks()).append("\',")
			 .append("\'").append(t.getClassName()).append("\',")
			 .append("\'").append(t.getSqlName()).append("\',")
			 .append("\'").append(t.getSortOrder()).append("\');\r\n");
			 
			 
			 
			tmpsb4.append("SELECT LAST_INSERT_ID() into @tmpinsertid;");			
			tmpcolumns = t.getColumns();
			itr = tmpcolumns.iterator();
			tmptablealiasseq=0;
			 while (itr.hasNext()){
				 tmpcolumn = (Column)itr.next();
				 tmpfktablealias="";
				 if((tmpcolumn.getFktable()!=null)&&(!tmpcolumn.getFktable().equals("")))
				 {
				    	 tmptablealiasseq++;
				    	 tmpfktablealias ="t"+tmptablealiasseq;
				 }
				  
			tmpsb4.append("insert into t_tablefield(TableID,Name,ADIName,CNName,")
			.append("IsPK,AutoInc,Nullable,DataType,DataLen,")
			.append("EditType,DataSrcType,DataSrc,DefaultValue,")
			.append("FKTable,FKIdColumn,FKNameColumn,FKTableAlias,FKAlias,")
			.append("ListShow,ListWidth,Generate,GenerateParam,CreateTime)values(@tmpinsertid,")
			.append("\'").append(tmpcolumn.getSqlName()).append("\',")
			.append("\'").append(tmpcolumn.getColumnName()).append("\',")
			.append("\'").append(tmpcolumn.getRemarks()).append("\',")
			.append(tmpcolumn.isPk()==true?1:0).append(",0,1,")
			.append("\'").append(tmpcolumn.getSqlTypeName()).append("\',256,")
			.append("\'").append(tmpcolumn.getDisplayType()).append("\',")
			.append("\'").append(tmpcolumn.getDataSrcType()).append("\',")
			.append("\'").append(tmpcolumn.getDataSrc()).append("\',")
			.append("\'").append(tmpcolumn.getDefaultValue()).append("\',")
			.append("\'").append(tmpcolumn.getFktable()).append("\',")
			.append("\'").append(tmpcolumn.getFkidcolumn()).append("\',")
			.append("\'").append(tmpcolumn.getFknamecolumn()).append("\',")
			.append("\'").append(tmpfktablealias).append("\',")
			.append("\'").append(tmpcolumn.getFkalias()).append("\',")
			.append("\'").append(tmpcolumn.getListShow()).append("\',")
			.append("\'").append(tmpcolumn.getListWidth()).append("\',")
			.append("\'").append(tmpcolumn.getGenerate()).append("\',")
			.append("\'").append(tmpcolumn.getGenerateParam()).append("\',")
			.append("unix_timestamp()")
			.append(");\r\n");
			 }
		}
		createTxT("/Users/joe/generator_sysresource.txt",tmpsb3.toString());
		createTxT("/Users/joe/generator_table.txt",tmpsb4.toString());
//		g.generateByTable("table_name","template");	//通过数据库表生成文件,template为模板的根目录
		g.generateByAllTable("template");	//自动搜索数据库中的所有表并生成文件,template为模板的根目录
		//g.generateBySpecialTable("template_multiview","multiview");//added by micet 20141223
		//g.generateBySpecialTable("template_tree","tree");//added by micet 20141223
//		g.generateByClass(Blog.class,"template_clazz");
		
//		g.deleteByTable("table_name", "template"); //删除生成的文件
		System.out.println(buf.toString()+"\r\n");
		
		///createTxT("d:\\generator-output\\nav.js",buf.toString()+"\r\n");
		//打开文件夹
//		Runtime.getRuntime().exec("cmd.exe /c start "+GeneratorProperties.getRequiredProperty("outRoot"));
	}
	public static void createTxT(String path,String content){ // 创建新的txt数据文件
		 File result = null;
	      FileWriter writer;
	      PrintWriter pw;
	     boolean bool ;
        bool = false;
    result = new File(path);
        try {
    result.createNewFile();// 在本地创建一个txt文件
    bool = true;
   } catch (IOException e) {
    bool = false;
    System.err.println(e);
   }
   if(bool){
    try {
    	 writer = new FileWriter(path);
	     pw = new PrintWriter(path);
	     pw.println(content);
	     pw.flush();
	     writer.close();
    } catch (FileNotFoundException e) {
     System.err.println(e);
    } catch (IOException e) {
    	System.err.println(e);
	}
   }
   
     }
}
