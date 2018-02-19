package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html style =\"height: 100%\">\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"font.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>le Reddit Image Scraper</title>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color:white;height:100%\">\n");
      out.write("        \n");
      out.write("        <div style =\"height: 100%\">\n");
      out.write("            \n");
      out.write("            <div style=\"height:50px;background:#C3C3E5;padding:20px\">\n");
      out.write("                <div style=\"float:left;font-family: Cursif;font-size:24px;color: white\"><center>le Reddit Image Scraper</font></center></div>\n");
      out.write("                <form action=\"IndexServlet\">\n");
      out.write("                    <center>\n");
      out.write("                        <input type =\"submit\" value =\"Go\" name=\"submit\" style=\"float:right;min-height:30px;\">\n");
      out.write("                        <input type=\"text\" name =\"subreddit\" value =\"Enter a subreddit.\" style=\"float:right;height:30px;width:150px\" onfocus=\"this.value = '';\">\n");
      out.write("                    </center>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div style=\"min-height:5%;padding:10px\"> \n");
      out.write("                <form action=\"IndexServlet\">\n");
      out.write("                    <center>\n");
      out.write("                        <input type=\"image\" src=\"downvote.png\" value =\"<\" name=\"submit\" style=\"max-height: 5%\">\n");
      out.write("                        <input type=\"image\"src=\"upvote.png\" value =\">\" name=\"submit\" style=\"max-height: 5%\">\n");
      out.write("                    <center>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <div style =max-height:90%><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${randomImage.imageUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" style=\"max-width:80%;display: block;margin-left:auto;margin-right:auto\"></div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("       \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
