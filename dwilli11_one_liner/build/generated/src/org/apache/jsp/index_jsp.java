package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oneliner.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    onelinerUtils utils;
    
    public void jspInit()
    {
        String fullPathName = onelinerUtils.init(getServletConfig(), getServletContext());
        utils = new onelinerUtils(fullPathName);
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

      out.write('\n');
      out.write('\n');
      out.write('\n');

    pageContext.setAttribute("ELScope", "Page Context");
    request.setAttribute("ELScope", "Request");


      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html style=\"height:100%\">\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"animate-custom.css\">\n");
      out.write("        <title>Oneliners! ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ELScope}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</title>            \n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color:black;height:100%\">\n");
      out.write("        \n");
      out.write("        <div style=\"height:100%\">\n");
      out.write("            <div style=\"height:50%\">\n");
      out.write("                <center><h2 class=\"animated fadeInUp\" style=\"color:white;font-size:100px;font-family:Calibri\"> ");
      out.print( utils.getNextOneLiner() );
      out.write(" </h2></center>\n");
      out.write("            </div>\n");
      out.write("            <div style=\"height:50%\">\n");
      out.write("                <form action=\"oneliner\">\n");
      out.write("                <br/><center><input type=\"submit\" class=\"animated fadeInDown\" name=\"action\" value=\"Next\" style=\"height:100px;width:400px;font-size:50px;font-family:Calibri;background:black;color:white\" /></center>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
