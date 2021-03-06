package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import guest.*;

public final class gbook2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    String fullFilePath="";
    
// Overriding the jspInit routine in the JSP Servlet class
// Note that this code is mostly just a copy of the init() code in the Servlet version
  public void jspInit()
  {    
        ServletConfig sc = getServletConfig();
        ServletContext sctx = getServletContext();
        String guestFile = sc.getInitParameter("guestFile");
        String guestPath = sc.getInitParameter("guestPath");
        
        System.out.println("guestFile="+ guestFile);
        System.out.println("guestPath="+guestPath);
        
        if (guestPath == null)
            guestPath="";
        else
            guestPath = guestPath.trim();
        
        if (guestFile == null)
            guestFile="GuestFileDefaultName.txt";
        
        if ( guestPath.length() == 0)
            fullFilePath = sctx.getRealPath("/WEB-INF/"+guestFile);
        else
        {
            //fullFilePath = System.getProperty("user.home")+"/" + guestPath + "/" + guestFile;
            String pathSeparator = System.getProperty("file.separator");
            fullFilePath = System.getProperty("user.home")+ pathSeparator + guestPath + pathSeparator + guestFile;
        }
        System.out.println("From JSP: fullFilePath="+ fullFilePath);
  }

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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write('\n');

        // Lifted from the top of the Guestbook Servlet

        GuestUserInput guser = new GuestUserInput();
        GuestBookUtils gbook = new GuestBookUtils(fullFilePath);

        if (guser.updateFromRequest(request))
        {
            gbook.add(guser.toString());
        }

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title></title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       \n");
      out.write("        <h1>Add a new entry</h1>\n");
      out.write("        \n");
      out.write("        <form action=\"gbook2\">\n");
      out.write("        Full Name: <input type=\"text\" name=\"fullName\" size=\"60\" />\n");
      out.write("            \n");
      out.write("        <p>Are  you a WCC Student: <input type=\"checkbox\" name=\"wccStudent\" value=\"yes\" />\n");
      out.write("            \n");
      out.write("        <p>Gender: <input type=\"radio\" name=\"gender\" value=\"male\" />male  \n");
      out.write("        <input type=\"radio\"  name=\"gender\" value=\"female\" />female \n");
      out.write("        <input type=\"radio\" name=\"gender\"  value=\"unspecified\" />Unspecified\n");
      out.write("        <p>Check any of the properties that apply:\n");
      out.write("        <br/><input type=\"checkbox\" name=\"emailProperties\" value=\"businessEmail\" checked /> Add me to your Business Email List \n");
      out.write("        <br/><input type=\"checkbox\" name=\"emailProperties\" value=\"spamEmail\" checked /> Add me to your Spam Email List\n");
      out.write("        <br/><input type=\"checkbox\" name=\"emailProperties\" value=\"gamesEmail\" checked /> Add me to your advertising Email List\n");
      out.write("        <br/><input type=\"checkbox\" name=\"emailProperties\" value=\"spywareEmail\" checked /> Add me to your spyware Email List \n");
      out.write("            \n");
      out.write("        <p>Replace the dots with your Guestbook comment:\n");
      out.write("        <br/><textarea name=\"information\" rows=\"5\" cols=\"65\">......</textarea>\n");
      out.write("            \n");
      out.write("        <br/><input type=\"submit\" name=\"action\" value=\"Add Guestbook Entry\" />\n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("    \n");
      out.write("        <hr>  \n");
      out.write("        <pre>\n");
      out.write("            ");
      out.print( gbook.getContents() );
      out.write("\n");
      out.write("        </pre>\n");
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
