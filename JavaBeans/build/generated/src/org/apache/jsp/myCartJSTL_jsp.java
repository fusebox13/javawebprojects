package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class myCartJSTL_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      beans.Cart myCart = null;
      synchronized (session) {
        myCart = (beans.Cart) _jspx_page_context.getAttribute("myCart", PageContext.SESSION_SCOPE);
        if (myCart == null){
          myCart = new beans.Cart();
          _jspx_page_context.setAttribute("myCart", myCart, PageContext.SESSION_SCOPE);
        }
      }
      out.write("  \n");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("myCart"), "choice", request.getParameter("choice"), request, "choice", false);
      out.write(' ');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("myCart"), "cmd", request.getParameter("cmd"), request, "cmd", false);
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("<html> \n");
      out.write("<head> \n");
      out.write("    <title>Shopping Cart</title> \n");
      out.write("</head> \n");
      out.write(" \n");
      out.write(" <body > \n");
      out.write("\n");
      out.write(" \n");
      out.write("<form type=POST action=myCart.jsp>  \n");
      out.write(" \n");
      out.write("<table border = \"4\"> \n");
      out.write("    <!--");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((beans.Cart)_jspx_page_context.findAttribute("myCart")).getTableData())));
      out.write("-->\n");
      out.write("    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${myCart.tableData}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("</table> \n");
      out.write("<hr>\n");
      out.write("<h3>Using JSTL</h3>\n");
      out.write("<table border = \"4\"> \n");
      out.write("    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("</table>\n");
      out.write("<BR> \n");
      out.write("Please enter item to add or remove: \n");
      out.write("<br> \n");
      out.write("Add Item: \n");
      out.write(" \n");
      out.write("<SELECT NAME=\"choice\"> \n");
      out.write("<OPTION>Potato Chips \n");
      out.write("<OPTION>Twinkies \n");
      out.write("<OPTION>Cherry Pie \n");
      out.write("<OPTION>Double Cheese Pizza\n");
      out.write("<OPTION>Ding Dongs \n");
      out.write("<OPTION>Coke \n");
      out.write("<OPTION>French Fries\n");
      out.write("<OPTION>Deep Fried Onion Rings\n");
      out.write("<OPTION>Extra Salt \n");
      out.write("<OPTION>Ice Cream \n");
      out.write("<OPTION>Chocolate Shake \n");
      out.write("<OPTION>Bacon (Real Bacon with extra greese)\n");
      out.write("</SELECT> \n");
      out.write(" \n");
      out.write(" \n");
      out.write("<br> <br> \n");
      out.write("<INPUT TYPE=submit name=\"cmd\" value=\"Add\"> \n");
      out.write("<INPUT TYPE=submit name=\"cmd\" value=\"Remove\">  \n");
      out.write(" \n");
      out.write("</form> \n");
      out.write("        \n");
      out.write("\n");
      out.write("</body> \n");
      out.write("</html> \n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("junkFood");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${myCart.list}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("         <tr>\n");
          out.write("             <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${junkFood}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("         </tr>\n");
          out.write("      ");
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
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
