package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class catch_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_catch;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_catch_var;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_catch = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_catch_var = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_catch.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_catch_var.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"errorPage.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html><body>\n");
      out.write("\n");
      out.write("About to be bad ....\n");
      out.write("\n");
      //  c:catch
      org.apache.taglibs.standard.tag.common.core.CatchTag _jspx_th_c_catch_0 = (org.apache.taglibs.standard.tag.common.core.CatchTag) _jspx_tagPool_c_catch.get(org.apache.taglibs.standard.tag.common.core.CatchTag.class);
      _jspx_th_c_catch_0.setPageContext(_jspx_page_context);
      _jspx_th_c_catch_0.setParent(null);
      int[] _jspx_push_body_count_c_catch_0 = new int[] { 0 };
      try {
        int _jspx_eval_c_catch_0 = _jspx_th_c_catch_0.doStartTag();
        if (_jspx_eval_c_catch_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\n");
            out.write("     <br>Inside the catch ...  \n");
            out.write("     ");
 int x = 10/0; 
            out.write("\n");
            out.write("     We will never get here\n");
            int evalDoAfterBody = _jspx_th_c_catch_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_catch_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_catch_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_catch_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_catch_0.doFinally();
        _jspx_tagPool_c_catch.reuse(_jspx_th_c_catch_0);
      }
      out.write("\n");
      out.write("\n");
      out.write("<br>If we get here, we survived\n");
      out.write("\n");
      out.write("<hr>\n");
      out.write("We might want to look at the exception coming from this problem:\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      //  c:catch
      org.apache.taglibs.standard.tag.common.core.CatchTag _jspx_th_c_catch_1 = (org.apache.taglibs.standard.tag.common.core.CatchTag) _jspx_tagPool_c_catch_var.get(org.apache.taglibs.standard.tag.common.core.CatchTag.class);
      _jspx_th_c_catch_1.setPageContext(_jspx_page_context);
      _jspx_th_c_catch_1.setParent(null);
      _jspx_th_c_catch_1.setVar("myException");
      int[] _jspx_push_body_count_c_catch_1 = new int[] { 0 };
      try {
        int _jspx_eval_c_catch_1 = _jspx_th_c_catch_1.doStartTag();
        if (_jspx_eval_c_catch_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\n");
            out.write("     <br>Inside the catch ...  \n");
            out.write("     ");
 int x2 = 10/0; 
            out.write("\n");
            out.write("     We will never get here\n");
            int evalDoAfterBody = _jspx_th_c_catch_1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_catch_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_catch_1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_catch_1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_catch_1.doFinally();
        _jspx_tagPool_c_catch_var.reuse(_jspx_th_c_catch_1);
      }
      out.write("\n");
      out.write("\n");
      out.write("<br>If we get here, we survived\n");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("<br> Note that following doesn't work because this page is not an error page:\n");
      out.write("<br> Exception = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.exception}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("\n");
      out.write("</body></html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${myException != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("    <br>There was an exception: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${myException}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write('\n');
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
}
