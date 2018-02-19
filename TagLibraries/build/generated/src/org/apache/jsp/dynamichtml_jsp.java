package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class dynamichtml_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/myTagLib.tld");
  }

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
      out.write('\n');

    ArrayList<String> colorList = new ArrayList<String>();
    colorList.add("red");
    colorList.add("blue");
    colorList.add("green");
    colorList.add("pink");
    colorList.add("orange");
    colorList.add("yellow");
    colorList.add("purple");

    request.setAttribute("colorList", colorList);

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html><body>\n");
      out.write("\n");
      out.write("\n");
      out.write("<hr>\n");
      out.write("Select custom tag\n");
      out.write("<form method='Post', action='SelectBeer'>\n");
      out.write("    ");
      if (_jspx_meth_myTags_select_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    <br><br><input type=\"SUBMIT\">\n");
      out.write("</form>\n");
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

  private boolean _jspx_meth_myTags_select_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  myTags:select
    tlds.SelectTagHandler _jspx_th_myTags_select_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(tlds.SelectTagHandler.class) : new tlds.SelectTagHandler();
    _jspx_th_myTags_select_0.setJspContext(_jspx_page_context);
    _jspx_th_myTags_select_0.setName("color");
    _jspx_th_myTags_select_0.setSize("3");
    _jspx_th_myTags_select_0.setOptionsList((java.util.List) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${colorList}", java.util.List.class, (PageContext)_jspx_page_context, null));
    _jspx_th_myTags_select_0.doTag();
    return false;
  }
}
