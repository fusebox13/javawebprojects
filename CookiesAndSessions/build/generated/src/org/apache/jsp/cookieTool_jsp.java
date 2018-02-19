package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cookieTool_jsp extends org.apache.jasper.runtime.HttpJspBase
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


    String cookieName=request.getParameter("cookieName");
    String cookieValue=request.getParameter("cookieValue");
    String cookieAge=request.getParameter("cookieAge");
    if (cookieName==null) cookieName="";
    if (cookieValue==null) cookieValue="";
    if (cookieAge==null) cookieAge="";
    
    String action = request.getParameter("action");
    if (action != null && cookieName.length() > 0)
    {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        
        if ("delete".equals(action))
        {
            cookie.setMaxAge(0);
        }
        else
        {
            int age=-1; // expires after browser is closed
            cookieAge = cookieAge.trim();
            if (cookieAge.length() > 0)
            {
                try
                {
                    age = Integer.parseInt(cookieAge);
                }
                catch (RuntimeException e)
                {
                    
                }
                System.out.println("Cookie age="+age);
                cookie.setMaxAge(age);
            }
        }
        response.addCookie(cookie);
    }
    
    Cookie[] cookies = request.getCookies();    
    if (cookies == null)
        cookies = new Cookie[0];
    

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cookie Tool</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Cookie Tool</h1>\n");
      out.write("        <form action=\"cookieTool.jsp\">\n");
      out.write("            <input type=\"text\" name=\"cookieName\" value=\"\"/> Cookie Name\n");
      out.write("            <br><input type=\"text\" name=\"cookieValue\" value=\"\" /> Cookie Value           \n");
      out.write("            <br><input type=\"text\" name=\"cookieAge\" value=\"\" />  Cookie Age: \n");
      out.write("            Age in seconds (0 ==> delete now, less than 0 means it dies when browser dies \n");
      out.write("            <br><input type=\"submit\" name=\"action\" value=\"add\" />\n");
      out.write("            \n");
      out.write("            <br><input type=\"submit\" name=\"action\" value=\"delete\" />\n");
      out.write("        </form>\n");
      out.write("        <hr>\n");
      out.write("        <table border=\"4\">\n");
      out.write("            <tr><th>Name</th><th>Value</th><th>Age</th><th>Domain</th><th>Path</th></tr>\n");
      out.write("        ");

           for (int i=0; i < cookies.length; i++)
           {
               Cookie cookie = cookies[i];
               // Exit Java mode 
               
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( cookie.getName());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( cookie.getValue());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( cookie.getMaxAge());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( cookie.getDomain());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( cookie.getPath());
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("               ");
// Enter Java mode to finish for loop
           }
        
      out.write("\n");
      out.write("        </table>\n");
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
