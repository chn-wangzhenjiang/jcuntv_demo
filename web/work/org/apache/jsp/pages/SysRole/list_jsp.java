package org.apache.jsp.pages.SysRole;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.pkit.model.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(7);
    _jspx_dependants.add("/commons/taglibs.jsp");
    _jspx_dependants.add("/pages/SysRole/base.jsp");
    _jspx_dependants.add("/pages/SysRole/../base.jsp");
    _jspx_dependants.add("/pages/SysRole/../../base.jsp");
    _jspx_dependants.add("/commons/meta.jsp");
    _jspx_dependants.add("/commons/messages.jsp");
    _jspx_dependants.add("/WEB-INF/tags/simpletable/pageToolbar.tag");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_rapid_override_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_rapid_block_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_rapid_override_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_url_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_rapid_block_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_rapid_override_name.release();
    _jspx_tagPool_c_url_value_nobody.release();
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
    _jspx_tagPool_c_out_value_nobody.release();
    _jspx_tagPool_rapid_block_name_nobody.release();
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
//用于实现jsp模板的继承关系,请查看:http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      //  rapid:override
      cn.org.rapid_framework.web.tags.OverrideTag _jspx_th_rapid_override_0 = (cn.org.rapid_framework.web.tags.OverrideTag) _jspx_tagPool_rapid_override_name.get(cn.org.rapid_framework.web.tags.OverrideTag.class);
      _jspx_th_rapid_override_0.setPageContext(_jspx_page_context);
      _jspx_th_rapid_override_0.setParent(null);
      _jspx_th_rapid_override_0.setName("head");
      int _jspx_eval_rapid_override_0 = _jspx_th_rapid_override_0.doStartTag();
      if (_jspx_eval_rapid_override_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_rapid_override_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_rapid_override_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_rapid_override_0.doInitBody();
        }
        do {
          out.write("\r\n");
          out.write("\t<title>");
          out.print(SysRole.TABLE_ALIAS);
          out.write(" 维护</title>\r\n");
          out.write("\t<link href=\"");
          if (_jspx_meth_c_url_0(_jspx_th_rapid_override_0, _jspx_page_context))
            return;
          out.write("\" type=\"text/css\" rel=\"stylesheet\">\r\n");
          out.write("\t<link href=\"");
          if (_jspx_meth_c_url_1(_jspx_th_rapid_override_0, _jspx_page_context))
            return;
          out.write("\" type=\"text/css\" rel=\"stylesheet\">\r\n");
          out.write("\t<script type=\"text/javascript\" src=\"");
          if (_jspx_meth_c_url_2(_jspx_th_rapid_override_0, _jspx_page_context))
            return;
          out.write("\"></script>\r\n");
          out.write("\t\r\n");
          out.write("\t<script type=\"text/javascript\" >\r\n");
          out.write("\t\t$(document).ready(function() {\r\n");
          out.write("\t\t\t// 分页需要依赖的初始化动作\r\n");
          out.write("\t\t\twindow.simpleTable = new SimpleTable('queryForm',");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page.thisPageNumber}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(',');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page.pageSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(',');
          out.write('\'');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageRequest.sortColumns}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("');\r\n");
          out.write("\t\t});\r\n");
          out.write("\t\tfunction search(){\r\n");
          out.write("\t\t\tvar s = document.getElementById(\"searchImg\").src;\r\n");
          out.write("\t\t\tif(document.getElementById(\"queryPanelId\").style.display!=\"none\"){\r\n");
          out.write("\t\t\t\tdocument.getElementById(\"queryPanelId\").style.display=\"none\";\r\n");
          out.write("\t\t\t\tdocument.getElementById(\"searchImg\").src=s.replace('magnifier1.png','magnifier.png');\t\t\t\t\r\n");
          out.write("\t\t\t}else{\r\n");
          out.write("\t\t\t\tdocument.getElementById(\"queryPanelId\").style.display=\"\";\r\n");
          out.write("\t\t\t\tdocument.getElementById(\"searchImg\").src=s.replace('magnifier.png','magnifier1.png');\r\n");
          out.write("\t\t\t}\r\n");
          out.write("\t\t}\r\n");
          out.write("\t\tfunction openPage(url){\r\n");
          out.write("\t\t\topenDialog(url,'myDialog',600,500,400,150);\r\n");
          out.write("\t\t}\r\n");
          out.write("\t</script>\r\n");
          int evalDoAfterBody = _jspx_th_rapid_override_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_rapid_override_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_rapid_override_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_rapid_override_name.reuse(_jspx_th_rapid_override_0);
        return;
      }
      _jspx_tagPool_rapid_override_name.reuse(_jspx_th_rapid_override_0);
      out.write("\r\n");
      out.write("\r\n");
      //  rapid:override
      cn.org.rapid_framework.web.tags.OverrideTag _jspx_th_rapid_override_1 = (cn.org.rapid_framework.web.tags.OverrideTag) _jspx_tagPool_rapid_override_name.get(cn.org.rapid_framework.web.tags.OverrideTag.class);
      _jspx_th_rapid_override_1.setPageContext(_jspx_page_context);
      _jspx_th_rapid_override_1.setParent(null);
      _jspx_th_rapid_override_1.setName("content");
      int _jspx_eval_rapid_override_1 = _jspx_th_rapid_override_1.doStartTag();
      if (_jspx_eval_rapid_override_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_rapid_override_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_rapid_override_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_rapid_override_1.doInitBody();
        }
        do {
          out.write("\r\n");
          out.write("\t<form id=\"queryForm\" name=\"queryForm\" action=\"");
          if (_jspx_meth_c_url_3(_jspx_th_rapid_override_1, _jspx_page_context))
            return;
          out.write("\" method=\"get\" style=\"display: inline;\">\r\n");
          out.write("\t<div class=\"queryPanel\" id=\"queryPanelId\" style=\"display:none\" >\r\n");
          out.write("\t\t<fieldset>\r\n");
          out.write("\t\t\t<legend>搜索</legend>\r\n");
          out.write("\t\t\t<table class=\"queryPanel_table\">\r\n");
          out.write("\t\t\t\t<tr class=\"queryPanel_tr\">\t\r\n");
          out.write("\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t<td class=\"queryPanel_tdLabel\">");
          out.print(SysRole.ALIAS_NAME);
          out.write("</td>\t\t\r\n");
          out.write("\t\t\t\t\t\t\t<td>\r\n");
          out.write("\t\t\t\t\t\t<input value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${query.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" id=\"name\" name=\"name\" maxlength=\"20\"  class=\"queryPanel_input\"/>\r\n");
          out.write("\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t<td class=\"queryPanel_tdLabel\">");
          out.print(SysRole.ALIAS_DESCRIPTION);
          out.write("</td>\t\t\r\n");
          out.write("\t\t\t\t\t\t\t<td>\r\n");
          out.write("\t\t\t\t\t\t<input value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${query.description}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" id=\"description\" name=\"description\" maxlength=\"64\"  class=\"queryPanel_input\"/>\r\n");
          out.write("\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t<td class=\"queryPanel_tdLabel\">");
          out.print(SysRole.ALIAS_LOCKED);
          out.write("</td>\t\t\r\n");
          out.write("\t\t\t\t\t\t\t<td>\r\n");
          out.write("\t\t\t\t\t\t<input value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${query.locked}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" id=\"locked\" name=\"locked\" maxlength=\"10\"  class=\"queryPanel_input\"/>\r\n");
          out.write("\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t</tr>\t\r\n");
          out.write("\t\t\t</table>\r\n");
          out.write("\t\t</fieldset>\r\n");
          out.write("\t </div>\r\n");
          out.write("\t\r\n");
          out.write("\t<div class=\"gridTable\">\r\n");
          out.write("\t\r\n");
          out.write("\t\t");
          if (_jspx_meth_simpletable_pageToolbar_0(_jspx_th_rapid_override_1, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\r\n");
          out.write("\t\t<table width=\"100%\"  border=\"0\" cellspacing=\"0\" class=\"gridBody\">\r\n");
          out.write("\t\t  <thead>\r\n");
          out.write("\t\t\t  \r\n");
          out.write("\t\t\t  <tr>\r\n");
          out.write("\t\t\t\t<th style=\"width:1px;\"> </th>\r\n");
          out.write("\t\t\t\t<th style=\"width:1px;\"><input type=\"checkbox\" onclick=\"setAllCheckboxState('items',this.checked)\"></th>\r\n");
          out.write("\t\t\t\t\r\n");
          out.write("\t\t\t\t<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->\r\n");
          out.write("\t\t\t\t<th sortColumn=\"name\" >");
          out.print(SysRole.ALIAS_NAME);
          out.write("</th>\r\n");
          out.write("\t\t\t\t<th sortColumn=\"description\" >");
          out.print(SysRole.ALIAS_DESCRIPTION);
          out.write("</th>\r\n");
          out.write("\t\t\t\t<th sortColumn=\"locked\" >");
          out.print(SysRole.ALIAS_LOCKED);
          out.write("</th>\r\n");
          out.write("\t\r\n");
          out.write("\t\t\t\t<th>操作</th>\r\n");
          out.write("\t\t\t  </tr>\r\n");
          out.write("\t\t\t  \r\n");
          out.write("\t\t  </thead>\r\n");
          out.write("\t\t  <tbody>\r\n");
          out.write("\t\t  \t  ");
          if (_jspx_meth_c_forEach_0(_jspx_th_rapid_override_1, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t  </tbody>\r\n");
          out.write("\t\t</table>\r\n");
          out.write("\t\r\n");
          out.write("\t\t");
          if (_jspx_meth_simpletable_pageToolbar_1(_jspx_th_rapid_override_1, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t</div>\r\n");
          out.write("\t</form>\r\n");
          int evalDoAfterBody = _jspx_th_rapid_override_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_rapid_override_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_rapid_override_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_rapid_override_name.reuse(_jspx_th_rapid_override_1);
        return;
      }
      _jspx_tagPool_rapid_override_name.reuse(_jspx_th_rapid_override_1);
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" >\r\n");
      out.write("function showLoading(){\r\n");
      out.write("\tparent.document.getElementById(\"Container\").style.display=\"\";\r\n");
      out.write("\tparent.document.getElementById(\"gridFrameDiv\").style.display=\"none\";\r\n");
      out.write("}\r\n");
      out.write("parent.document.getElementById(\"Container\").style.display=\"none\";\r\n");
      out.write("parent.document.getElementById(\"gridFrameDiv\").style.display=\"\";\r\n");
      out.write("</script>\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
//用于实现jsp模板的继承关系,请查看:http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_set_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">\r\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-store\"/>\r\n");
      out.write("<meta http-equiv=\"Pragma\" content=\"no-cache\"/>\r\n");
      out.write("<meta http-equiv=\"Expires\" content=\"0\"/>\r\n");
      out.write("\r\n");
      out.write("<!-- optional javascript: effects.js,jquery.js -->\r\n");
      out.write("\t<link href=\"");
      if (_jspx_meth_c_url_4(_jspx_page_context))
        return;
      out.write("\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- rapid-validation BEGIN-->\r\n");
      out.write("\t<link href=\"");
      if (_jspx_meth_c_url_5(_jspx_page_context))
        return;
      out.write("\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("\t<script src=\"");
      if (_jspx_meth_c_url_6(_jspx_page_context))
        return;
      out.write("\" type=\"text/javascript\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- \r\n");
      out.write("\t<script src=\"");
      if (_jspx_meth_c_url_7(_jspx_page_context))
        return;
      out.write("\" type=\"text/javascript\"></script>\r\n");
      out.write("\t-->\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- show validation error as tooptips -->\r\n");
      out.write("\t<script src=\"");
      if (_jspx_meth_c_url_8(_jspx_page_context))
        return;
      out.write("\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<link href=\"");
      if (_jspx_meth_c_url_9(_jspx_page_context))
        return;
      out.write("\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("\t\r\n");
      out.write("\t<script src=\"");
      if (_jspx_meth_c_url_10(_jspx_page_context))
        return;
      out.write("\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- rapid-validation END-->\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_url_11(_jspx_page_context))
        return;
      out.write("\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_url_12(_jspx_page_context))
        return;
      out.write("\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_url_13(_jspx_page_context))
        return;
      out.write("\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("\t");
      if (_jspx_meth_rapid_block_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
//用于实现jsp模板的继承关系,请查看:http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_set_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");
      if (_jspx_meth_rapid_block_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("ctx");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_url_0(javax.servlet.jsp.tagext.JspTag _jspx_th_rapid_override_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_0.setPageContext(_jspx_page_context);
    _jspx_th_c_url_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_rapid_override_0);
    _jspx_th_c_url_0.setValue("/styles/common.css");
    int _jspx_eval_c_url_0 = _jspx_th_c_url_0.doStartTag();
    if (_jspx_th_c_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_0);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_0);
    return false;
  }

  private boolean _jspx_meth_c_url_1(javax.servlet.jsp.tagext.JspTag _jspx_th_rapid_override_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_1.setPageContext(_jspx_page_context);
    _jspx_th_c_url_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_rapid_override_0);
    _jspx_th_c_url_1.setValue("/widgets/simpletable/simpletable.css");
    int _jspx_eval_c_url_1 = _jspx_th_c_url_1.doStartTag();
    if (_jspx_th_c_url_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_1);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_1);
    return false;
  }

  private boolean _jspx_meth_c_url_2(javax.servlet.jsp.tagext.JspTag _jspx_th_rapid_override_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_2.setPageContext(_jspx_page_context);
    _jspx_th_c_url_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_rapid_override_0);
    _jspx_th_c_url_2.setValue("/widgets/simpletable/simpletable.js");
    int _jspx_eval_c_url_2 = _jspx_th_c_url_2.doStartTag();
    if (_jspx_th_c_url_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_2);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_2);
    return false;
  }

  private boolean _jspx_meth_c_url_3(javax.servlet.jsp.tagext.JspTag _jspx_th_rapid_override_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_3.setPageContext(_jspx_page_context);
    _jspx_th_c_url_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_rapid_override_1);
    _jspx_th_c_url_3.setValue("/pages/SysRole/list.do");
    int _jspx_eval_c_url_3 = _jspx_th_c_url_3.doStartTag();
    if (_jspx_th_c_url_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_3);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_3);
    return false;
  }

  private boolean _jspx_meth_simpletable_pageToolbar_0(javax.servlet.jsp.tagext.JspTag _jspx_th_rapid_override_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  simpletable:pageToolbar
    org.apache.jsp.tag.web.simpletable.pageToolbar_tag _jspx_th_simpletable_pageToolbar_0 = new org.apache.jsp.tag.web.simpletable.pageToolbar_tag();
    _jspx_th_simpletable_pageToolbar_0.setJspContext(_jspx_page_context);
    _jspx_th_simpletable_pageToolbar_0.setParent(_jspx_th_rapid_override_1);
    _jspx_th_simpletable_pageToolbar_0.setPage((cn.org.rapid_framework.page.Page) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page}", cn.org.rapid_framework.page.Page.class, (PageContext)_jspx_page_context, null, false));
    _jspx_th_simpletable_pageToolbar_0.setJspBody(new list_jspHelper( 0, _jspx_page_context, _jspx_th_simpletable_pageToolbar_0, null));
    _jspx_th_simpletable_pageToolbar_0.doTag();
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_rapid_override_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_rapid_override_1);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page.result}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    _jspx_th_c_forEach_0.setVar("item");
    _jspx_th_c_forEach_0.setVarStatus("status");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t  \t  \r\n");
          out.write("\t\t\t  <tr class=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.count % 2 == 0 ? 'odd' : 'even'}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\">\r\n");
          out.write("\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page.thisPageFirstElementNumber + status.index}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t<td><input type=\"checkbox\" name=\"items\" value=\"id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("&\"></td>\r\n");
          out.write("\t\t\t\t\r\n");
          out.write("\t\t\t\t<td>");
          if (_jspx_meth_c_out_0(_jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("&nbsp;</td>\r\n");
          out.write("\t\t\t\t<td>");
          if (_jspx_meth_c_out_1(_jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("&nbsp;</td>\r\n");
          out.write("\t\t\t\t<td>");
          if (_jspx_meth_c_out_2(_jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("&nbsp;</td>\r\n");
          out.write("\t\t\t\t<td>\r\n");
          out.write("\t\t\t\t\t<a href=\"javascript:void(-1)\" onclick=\"openPage('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("/pages/SysRole/show.do?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("&')\">查看</a>&nbsp;&nbsp;&nbsp;\r\n");
          out.write("\t\t\t\t\t<a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("/pages/SysRole/edit.do?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("&\">修改</a>\r\n");
          out.write("\t\t\t\t</td>\r\n");
          out.write("\t\t\t  </tr>\r\n");
          out.write("\t\t\t  \r\n");
          out.write("\t\t  \t  ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_c_out_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_1.setPageContext(_jspx_page_context);
    _jspx_th_c_out_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.description}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_1 = _jspx_th_c_out_1.doStartTag();
    if (_jspx_th_c_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
    return false;
  }

  private boolean _jspx_meth_c_out_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_2.setPageContext(_jspx_page_context);
    _jspx_th_c_out_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.locked}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_2 = _jspx_th_c_out_2.doStartTag();
    if (_jspx_th_c_out_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
    return false;
  }

  private boolean _jspx_meth_simpletable_pageToolbar_1(javax.servlet.jsp.tagext.JspTag _jspx_th_rapid_override_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  simpletable:pageToolbar
    org.apache.jsp.tag.web.simpletable.pageToolbar_tag _jspx_th_simpletable_pageToolbar_1 = new org.apache.jsp.tag.web.simpletable.pageToolbar_tag();
    _jspx_th_simpletable_pageToolbar_1.setJspContext(_jspx_page_context);
    _jspx_th_simpletable_pageToolbar_1.setParent(_jspx_th_rapid_override_1);
    _jspx_th_simpletable_pageToolbar_1.setPage((cn.org.rapid_framework.page.Page) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page}", cn.org.rapid_framework.page.Page.class, (PageContext)_jspx_page_context, null, false));
    _jspx_th_simpletable_pageToolbar_1.setJspBody(new list_jspHelper( 1, _jspx_page_context, _jspx_th_simpletable_pageToolbar_1, null));
    _jspx_th_simpletable_pageToolbar_1.doTag();
    return false;
  }

  private boolean _jspx_meth_c_set_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_1.setPageContext(_jspx_page_context);
    _jspx_th_c_set_1.setParent(null);
    _jspx_th_c_set_1.setVar("ctx");
    _jspx_th_c_set_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
    return false;
  }

  private boolean _jspx_meth_c_url_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_4 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_4.setPageContext(_jspx_page_context);
    _jspx_th_c_url_4.setParent(null);
    _jspx_th_c_url_4.setValue("/styles/global.css");
    int _jspx_eval_c_url_4 = _jspx_th_c_url_4.doStartTag();
    if (_jspx_th_c_url_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_4);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_4);
    return false;
  }

  private boolean _jspx_meth_c_url_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_5 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_5.setPageContext(_jspx_page_context);
    _jspx_th_c_url_5.setParent(null);
    _jspx_th_c_url_5.setValue("/scripts/rapid-validation/validation.css");
    int _jspx_eval_c_url_5 = _jspx_th_c_url_5.doStartTag();
    if (_jspx_th_c_url_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_5);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_5);
    return false;
  }

  private boolean _jspx_meth_c_url_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_6 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_6.setPageContext(_jspx_page_context);
    _jspx_th_c_url_6.setParent(null);
    _jspx_th_c_url_6.setValue("/scripts/rapid-validation/prototype_for_validation.js");
    int _jspx_eval_c_url_6 = _jspx_th_c_url_6.doStartTag();
    if (_jspx_th_c_url_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_6);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_6);
    return false;
  }

  private boolean _jspx_meth_c_url_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_7 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_7.setPageContext(_jspx_page_context);
    _jspx_th_c_url_7.setParent(null);
    _jspx_th_c_url_7.setValue("/scripts/rapid-validation/effects.js");
    int _jspx_eval_c_url_7 = _jspx_th_c_url_7.doStartTag();
    if (_jspx_th_c_url_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_7);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_7);
    return false;
  }

  private boolean _jspx_meth_c_url_8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_8 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_8.setPageContext(_jspx_page_context);
    _jspx_th_c_url_8.setParent(null);
    _jspx_th_c_url_8.setValue("/scripts/rapid-validation/tooltips.js");
    int _jspx_eval_c_url_8 = _jspx_th_c_url_8.doStartTag();
    if (_jspx_th_c_url_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_8);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_8);
    return false;
  }

  private boolean _jspx_meth_c_url_9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_9 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_9.setPageContext(_jspx_page_context);
    _jspx_th_c_url_9.setParent(null);
    _jspx_th_c_url_9.setValue("/scripts/rapid-validation/tooltips.css");
    int _jspx_eval_c_url_9 = _jspx_th_c_url_9.doStartTag();
    if (_jspx_th_c_url_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_9);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_9);
    return false;
  }

  private boolean _jspx_meth_c_url_10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_10 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_10.setPageContext(_jspx_page_context);
    _jspx_th_c_url_10.setParent(null);
    _jspx_th_c_url_10.setValue("/scripts/rapid-validation/validation_cn.js");
    int _jspx_eval_c_url_10 = _jspx_th_c_url_10.doStartTag();
    if (_jspx_th_c_url_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_10);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_10);
    return false;
  }

  private boolean _jspx_meth_c_url_11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_11 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_11.setPageContext(_jspx_page_context);
    _jspx_th_c_url_11.setParent(null);
    _jspx_th_c_url_11.setValue("/scripts/application.js");
    int _jspx_eval_c_url_11 = _jspx_th_c_url_11.doStartTag();
    if (_jspx_th_c_url_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_11);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_11);
    return false;
  }

  private boolean _jspx_meth_c_url_12(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_12 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_12.setPageContext(_jspx_page_context);
    _jspx_th_c_url_12.setParent(null);
    _jspx_th_c_url_12.setValue("/scripts/jquery.js");
    int _jspx_eval_c_url_12 = _jspx_th_c_url_12.doStartTag();
    if (_jspx_th_c_url_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_12);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_12);
    return false;
  }

  private boolean _jspx_meth_c_url_13(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_13 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_13.setPageContext(_jspx_page_context);
    _jspx_th_c_url_13.setParent(null);
    _jspx_th_c_url_13.setValue("/scripts/My97DatePicker/WdatePicker.js");
    int _jspx_eval_c_url_13 = _jspx_th_c_url_13.doStartTag();
    if (_jspx_th_c_url_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_13);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_13);
    return false;
  }

  private boolean _jspx_meth_rapid_block_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  rapid:block
    cn.org.rapid_framework.web.tags.BlockTag _jspx_th_rapid_block_0 = (cn.org.rapid_framework.web.tags.BlockTag) _jspx_tagPool_rapid_block_name_nobody.get(cn.org.rapid_framework.web.tags.BlockTag.class);
    _jspx_th_rapid_block_0.setPageContext(_jspx_page_context);
    _jspx_th_rapid_block_0.setParent(null);
    _jspx_th_rapid_block_0.setName("head");
    int _jspx_eval_rapid_block_0 = _jspx_th_rapid_block_0.doStartTag();
    if (_jspx_th_rapid_block_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_rapid_block_name_nobody.reuse(_jspx_th_rapid_block_0);
      return true;
    }
    _jspx_tagPool_rapid_block_name_nobody.reuse(_jspx_th_rapid_block_0);
    return false;
  }

  private boolean _jspx_meth_c_set_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_2.setPageContext(_jspx_page_context);
    _jspx_th_c_set_2.setParent(null);
    _jspx_th_c_set_2.setVar("ctx");
    _jspx_th_c_set_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_set_2 = _jspx_th_c_set_2.doStartTag();
    if (_jspx_th_c_set_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_2);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_2);
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${flash.success != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t<div class=\"flash_success\">\r\n");
        out.write("\t\t");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${flash.success}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("<br/>\r\n");
        out.write("\t</div>    \r\n");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${flash.error != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t<div class=\"flash_error\">\r\n");
        out.write("\t\t");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${flash.error}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("<br/>\r\n");
        out.write("\t</div> \r\n");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_rapid_block_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  rapid:block
    cn.org.rapid_framework.web.tags.BlockTag _jspx_th_rapid_block_1 = (cn.org.rapid_framework.web.tags.BlockTag) _jspx_tagPool_rapid_block_name_nobody.get(cn.org.rapid_framework.web.tags.BlockTag.class);
    _jspx_th_rapid_block_1.setPageContext(_jspx_page_context);
    _jspx_th_rapid_block_1.setParent(null);
    _jspx_th_rapid_block_1.setName("content");
    int _jspx_eval_rapid_block_1 = _jspx_th_rapid_block_1.doStartTag();
    if (_jspx_th_rapid_block_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_rapid_block_name_nobody.reuse(_jspx_th_rapid_block_1);
      return true;
    }
    _jspx_tagPool_rapid_block_name_nobody.reuse(_jspx_th_rapid_block_1);
    return false;
  }

  private class list_jspHelper
      extends org.apache.jasper.runtime.JspFragmentHelper
  {
    private javax.servlet.jsp.tagext.JspTag _jspx_parent;
    private int[] _jspx_push_body_count;

    public list_jspHelper( int discriminator, JspContext jspContext, javax.servlet.jsp.tagext.JspTag _jspx_parent, int[] _jspx_push_body_count ) {
      super( discriminator, jspContext, _jspx_parent );
      this._jspx_parent = _jspx_parent;
      this._jspx_push_body_count = _jspx_push_body_count;
    }
    public boolean invoke0( JspWriter out ) 
      throws Throwable
    {
      out.write("\r\n");
      out.write("\t\t\t<img id=\"searchImg\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/magnifier.png\" width=\"22\" onclick=\"search()\" class=\"stdButton\" alt=\"\" />\r\n");
      out.write("\t\t\t<input type=\"submit\" class=\"stdButton\" style=\"width:80px\" value=\"查询\" onclick=\"showLoading();getReferenceForm(this).action='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/pages/SysRole/list.do'\"/>\r\n");
      out.write("\t\t\t<input type=\"submit\" class=\"stdButton\" style=\"width:80px\" value=\"新增\" onclick=\"getReferenceForm(this).action='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/pages/SysRole/create.do'\"/>\r\n");
      out.write("\t\t\t<input type=\"button\" class=\"stdButton\" style=\"width:80px\" value=\"删除\" onclick=\"batchDelete('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/pages/SysRole/delete.do','items',document.forms.queryForm)\"/>\r\n");
      out.write("\t\t\t<input type=\"button\" class=\"stdButton\" style=\"width:80px\" value=\"刷新\" onclick=\"showLoading();window.location.reload()\"/>\r\n");
      out.write("\t\t");
      return false;
    }
    public boolean invoke1( JspWriter out ) 
      throws Throwable
    {
      out.write("\r\n");
      out.write("\t\t");
      return false;
    }
    public void invoke( java.io.Writer writer )
      throws JspException
    {
      JspWriter out = null;
      if( writer != null ) {
        out = this.jspContext.pushBody(writer);
      } else {
        out = this.jspContext.getOut();
      }
      try {
        switch( this.discriminator ) {
          case 0:
            invoke0( out );
            break;
          case 1:
            invoke1( out );
            break;
        }
      }
      catch( Throwable e ) {
        if (e instanceof SkipPageException)
            throw (SkipPageException) e;
        throw new JspException( e );
      }
      finally {
        if( writer != null ) {
          this.jspContext.popBody();
        }
      }
    }
  }
}
