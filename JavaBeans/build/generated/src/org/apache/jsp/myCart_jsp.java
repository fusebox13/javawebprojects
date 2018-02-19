package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class myCart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" <body> \n");
      out.write(" \n");
      out.write("<form type=POST action=myCart.jsp>  \n");
      out.write(" \n");
      out.write("<table border = 4> \n");
      out.write("    ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((beans.Cart)_jspx_page_context.findAttribute("myCart")).getTableData())));
      out.write("\n");
      out.write("  \n");
      out.write("</table>     \n");
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
      out.write("      \n");
      out.write("</body> \n");
      out.write("</html> ");
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
