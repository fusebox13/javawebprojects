package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class MonthlyAgenda_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");


    java.util.Calendar now = java.util.Calendar.getInstance();
    int month_num = now.get(java.util.Calendar.MONTH);
    String[] month_arr = {"January", "February", "March", "April", "May", "June",
                      "July", "August", "September", "October", "November", "December"};
    String month = month_arr[month_num - java.util.Calendar.JANUARY];
    String nextMonth = month_arr[(month_num - java.util.Calendar.JANUARY +1) % 12];
 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>");
      out.print(month);
      out.write(" Business Meeting</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Agenda for the Month of ");
      out.print(month);
      out.write("</h1>\n");
      out.write("        <ol>\n");
      out.write("            <li>Coffee and Donuts time</li>\n");
      out.write("            <li>Old business</li>\n");
      out.write("            <li>New business</li>          \n");
      out.write("            <li>Looking ahead to the Month of ");
      out.print( nextMonth);
      out.write("</li>\n");
      out.write("        </ol>\n");
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
