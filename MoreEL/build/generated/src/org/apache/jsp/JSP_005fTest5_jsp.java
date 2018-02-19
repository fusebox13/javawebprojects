package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class JSP_005fTest5_jsp extends org.apache.jasper.runtime.HttpJspBase
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


   // This could also be done in the front end Servlet of MVC. 
	response.addCookie( new Cookie("myCookie", "1234") );

      out.write("\n");
      out.write("\n");
      out.write("<html><body>\n");
      out.write("  <form action=JSP_Test5.jsp>\n");
      out.write("      <br>Name: <input type=\"text\" name=\"name\">\n");
      out.write("      <br>ID#: <input type=\"text\" name=\"empID\">\n");
      out.write("      <br>First Food: <input type=\"text\" name=\"food\">\n");
      out.write("      <br>Second Food: <input type=\"text\" name=\"food\">\n");
      out.write("      <br><input type=\"submit\">\n");
      out.write("  </form>\n");
      out.write("\n");
      out.write("<hr>\n");
      out.write("Request param name is ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("<br>Request param empID is: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.empID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("<br> Only prints first food: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.food}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("<br> Prints first food: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${paramValues.food[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("<br> Prints second food: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${paramValues.food[1]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("\n");
      out.write("<br> User-Agent: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${header[\"User-Agent\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("\n");
      out.write("<p>Configuration info: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.mainEmail}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("<br> Getting the cookie: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cookie.myCookie.value}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("\n");
      out.write("<hr>\n");
      out.write("<br> Equivalent code using scriplets:\n");
      out.write("Request param name is ");
      out.print( request.getParameter("name") );
      out.write("\n");
      out.write("<br>Request param empID is: ");
      out.print( request.getParameter("empID") );
      out.write("\n");
      out.write("<br> Only prints first food: ");
      out.print( request.getParameter("food") );
      out.write('\n');
      out.write('\n');

    String[] parmValues = request.getParameterValues("food");
    if (parmValues != null)
    {
        if (parmValues.length > 0)
            out.println("<br> Prints first food:"+ parmValues[0]);
        if (parmValues.length > 1)
            out.println("<br> Prints second food:"+ parmValues[1]);
            
    }

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<br> User-Agent: ");
      out.print( request.getHeader("User-Agent"));
      out.write("\n");
      out.write("\n");
      out.write("Configuration info: $");
      out.print( application.getInitParameter("mainEmail") );
      out.write('\n');
      out.write('\n');

Cookie[] cookies = request.getCookies();
for (int i=0; i < cookies.length; i++)
{
    if ((cookies[i].getName()).equals("myCookie"))
    {
       out.println("Cookie value from scriptlet="+ cookies[i].getValue());
    }
}

      out.write("\n");
      out.write("\n");
      out.write("\n");
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
