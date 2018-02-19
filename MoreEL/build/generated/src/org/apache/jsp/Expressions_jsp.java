package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Expressions_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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

      out.write("<html><body>\n");
      out.write("  <form action=Expressions.jsp>\n");
      out.write("      <br>x: <input type=\"text\" name=\"x\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.x}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("      <br>y: <input type=\"text\" name=\"y\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.y}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("      <br>z: <input type=\"text\" name=\"z\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.z}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("      <br><input type=\"submit\">\n");
      out.write("  </form>\n");
      out.write("\n");
      out.write("<hr>\n");
      out.write("<p>\n");
      out.write("    <br>x + y is ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.x + param.y}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    <br>x - y is ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.x - param.y}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    <br>x * y is ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.x * param.y}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    <br>x / y is ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.x / param.y}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    <br>x % y is ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.x % param.y}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    \n");
      out.write("    <p>x == y is ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.x == param.y}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    <br>x != y is ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.x != param.y}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    <br>x < y is ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.x < param.y}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    <br>x <= y is ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.x <= param.y}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    <br>x > y is ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.x > param.y}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    <br>x >= y is ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.x >= param.y}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    \n");
      out.write("    <p>\n");
      out.write("    <br>x < z && x > y is ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.x < param.z && param.x > param.y}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    <br>x < z || x > y is ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.x < param.z || param.x > param.y}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    <br>(x < z) || (x > y) is ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(param.x < param.z) || (param.x > param.y)}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" \n");
      out.write("    <br>!(x < z)  is ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${!(param.x < param.z) }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    <p>\n");
      out.write("    <br>x == 1 is ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.x == 1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    <br>x == '1' is ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.x == '1'}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    <br>x == '1x' is ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.x == '1x'}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("\n");
      out.write("        \n");
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
}
