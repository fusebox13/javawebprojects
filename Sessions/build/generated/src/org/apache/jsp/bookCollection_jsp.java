package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import books.*;

public final class bookCollection_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");

    BookCollection bookCollection = BookCollection.update(pageContext);
 
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Book Collection</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Book Collection</h1>\n");
      out.write("        \n");
      out.write("        <form action=\"bookCollection.jsp\">\n");
      out.write("            <input type=\"submit\" name =\"action\" value=\"Clear List\">\n");
      out.write("        </form>\n");
      out.write("        <p>\n");
      out.write("        \n");
      out.write("        <form action=\"bookCollection.jsp\">\n");
      out.write("            <input type=\"text\" name=\"title\" /> Title\n");
      out.write("            <br><input type=\"text\" name=\"author\" /> Author\n");
      out.write("            <br><input type=\"text\" name=\"isbn\" /> ISBN\n");
      out.write("            \n");
      out.write("            <br><input type=\"text\" name=\"edition\" /> Edition\n");
      out.write("            <br><input type=\"submit\" name=\"action\" value=\"add\" />\n");
      out.write("        </form>\n");
      out.write("        <hr>\n");
      out.write("        <h3>");
      out.print(bookCollection.getErrorMessage());
      out.write("</h3>\n");
      out.write("        \n");
      out.write("        <table border=\"3\">\n");
      out.write("            <tr><th>Title</th><th>Author</th><th>Isbn</th><th>Edition</th><th></th></tr>\n");
      out.write("        ");

            for (int i=0; i <  bookCollection.size(); i++)
            {
                Book book = bookCollection.getBook(i);
         
      out.write("\n");
      out.write("            <tr>\n");
      out.write("            <form action=\"bookCollection.jsp\">\n");
      out.write("                <td><input type=\"text\" read name=\"title\" value=\"");
      out.print(book.getTitle());
      out.write("\" /></td>\n");
      out.write("                <td><input type=\"text\" read name=\"author\" value=\"");
      out.print(book.getAuthor());
      out.write("\" /></td>\n");
      out.write("                <td><input type=\"text\" read name=\"isbn\" value=\"");
      out.print(book.getIsbn());
      out.write("\" /></td>\n");
      out.write("                <td><input type=\"text\" read name=\"edition\" value=\"");
      out.print(book.getEdition());
      out.write("\" /></td>\n");
      out.write("                <td><input type=\"submit\" name=\"action\" value=\"remove\" /></td>\n");
      out.write("                <td><input type=\"submit\" name=\"action\" value=\"update\" />\n");
      out.write("                    <input type=\"hidden\" name =\"index\" value=\"");
      out.print(i);
      out.write("\"\n");
      out.write("                </td>\n");
      out.write("            </form>\n");
      out.write("            </tr>\n");
      out.write("         ");

            }
          
      out.write("\n");
      out.write("        </table>\n");
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
