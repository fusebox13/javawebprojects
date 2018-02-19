package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import radioActive.*;
import java.util.*;

public final class RadioActiveJSPOld_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      radioActive.RadioActiveCalculations radioActive = null;
      synchronized (_jspx_page_context) {
        radioActive = (radioActive.RadioActiveCalculations) _jspx_page_context.getAttribute("radioActive", PageContext.PAGE_SCOPE);
        if (radioActive == null){
          radioActive = new radioActive.RadioActiveCalculations();
          _jspx_page_context.setAttribute("radioActive", radioActive, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("radioActive"), request);
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Servlet RadioActiveServlet</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1> Radio Active Calculations  \n");
      out.write("            ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((radioActive.RadioActiveCalculations)_jspx_page_context.findAttribute("radioActive")).getExtraTitle())));
      out.write("</h1>\n");
      out.write("       \n");
      out.write("            <table border=\"4\">\n");
      out.write("                <tr><th>Year</th><th>Amount Decayed</th><th>Fraction Remaining</th>\n");
      out.write("                <th>Bar Remaining</th></tr>\n");
      out.write("            \n");
      out.write("             ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((radioActive.RadioActiveCalculations)_jspx_page_context.findAttribute("radioActive")).getTableData())));
      out.write("\n");
      out.write("                \n");
      out.write("            </table>;\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>");
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
