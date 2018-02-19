package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;

public final class badexample_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Bad Example</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Bad Example</h1>\n");
      out.write("        ");
 Calendar now = Calendar.getInstance();

// This example is actually a very bad example of how not to use JSP.
// The example works, but you normally don't want to bounce back and
// forth between Html mode and Java mode


          int hour =
          now.get(Calendar.HOUR_OF_DAY);
          if (hour < 12){ 

      out.write(" \n");
      out.write("          <H3>Good Morning</H3> \n");
 
          } 
          else if (hour < 18) { 

      out.write(" \n");
      out.write("          <H3>Good Afternoon</H3>\n");
 
          } 
          else { 

      out.write(" \n");
      out.write("          <H3>Good Evening </H3> \n");
 
          } 

      out.write(" \n");
      out.write("\n");
      out.write("<hr>\n");
      out.write("<h1>Alternative to the above </h1>\n");
   Calendar now2 = Calendar.getInstance();
// Here is an alternative
     int hour2 =
     now2.get(Calendar.HOUR_OF_DAY);
     if (hour < 12) 
        out.println("<H3>Good Morning</H3>");   
     else if (hour < 18)
        out.println("<H3>Good Afternoon</H3>");
     else  
        out.println("<H3>Good Evening </H3>"); 

      out.write(" \n");
      out.write("    \n");
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
