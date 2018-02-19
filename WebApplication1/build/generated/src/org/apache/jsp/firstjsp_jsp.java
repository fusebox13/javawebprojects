package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class firstjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n");
      out.write("<!-- saved from url=(0056)https://gettysburg.wccnet.edu/aa/web/Clem/home/home.html -->\n");
      out.write("<HTML><HEAD><META content=\"IE=5.0000\" http-equiv=\"X-UA-Compatible\">\n");
      out.write("<TITLE>Clem's Home Page</TITLE> \n");
      out.write("<META http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">\n");
      out.write("<STYLE type=\"text/css\">\n");
      out.write("<!--\n");
      out.write(".redText {\n");
      out.write("    color: #FF0000;\n");
      out.write("}\n");
      out.write("a {\n");
      out.write("    color: #FF00CC;\n");
      out.write("    font-weight: bold;\n");
      out.write("}\n");
      out.write("-->\n");
      out.write("</STYLE>\n");
      out.write(" \n");
      out.write("<META name=\"GENERATOR\" content=\"MSHTML 10.00.9200.16635\"></HEAD> \n");
      out.write("<BODY background=\"seal.jpg\" bgcolor=\"#ffffff\">\n");
      out.write("<DIV class=\"redText\">\n");
      out.write("<H1><B>Clem Hasselbach's Home Page</B></H1>\n");
      out.write("<H2>BE212 , chasselb@wccnet.edu</H2>\n");
      out.write("<P><IMG width=\"225\" height=\"225\" alt=\"Clem\" \n");
      out.write("src=\"chasselb.jpg\"></P>\n");
      out.write("<H2>Spring/Summer   2013:</H2>\n");
      out.write("<OL>\n");
      out.write("  <LI><B>Course: cps161S13</B><BR>\n");
      out.write("  <TABLE border=\"4\">\n");
      out.write("    <TBODY>\n");
      out.write("    <TR>\n");
      out.write("      <TH width=\"124\">Section</TH>\n");
      out.write("      <TH width=\"58\"></TH>\n");
      out.write("      <TH width=\"61\"></TH></TR>\n");
      out.write("    <TR>\n");
      out.write("      <TD width=\"124\"><STRONG>cps161</STRONG></TD>\n");
      out.write("      <TD width=\"58\"><A href=\"https://gettysburg.wccnet.edu/aa/login_stu.jsp?teacherName=chasselb&amp;courseName=cps161S13-1\" \n");
      out.write("        target=\"Aardvark_StuTop\">Student Login</A></TD>\n");
      out.write("      <TD width=\"61\"><A href=\"https://gettysburg.wccnet.edu/aa/web/Clem/cps161S13/Web/index.html\">Web \n");
      out.write("        Site</A></TD>\n");
      out.write("      <TD width=\"112\"><A href=\"https://gettysburg.wccnet.edu/aa/login_teach.jsp?teacherName=chasselb&amp;courseName=cps161S13-1&amp;address=WorkList\" \n");
      out.write("        target=\"Aardvark_Top\">Teacher Schedule </A></TD></TR></TBODY></TABLE></LI>\n");
      out.write("  <LI><B>Course: cps171S13</B><BR>\n");
      out.write("  <TABLE border=\"4\">\n");
      out.write("    <TBODY>\n");
      out.write("    <TR>\n");
      out.write("      <TH width=\"124\">Section</TH>\n");
      out.write("      <TH width=\"58\"></TH>\n");
      out.write("      <TH width=\"61\"></TH></TR>\n");
      out.write("    <TR>\n");
      out.write("      <TD width=\"124\"><STRONG>cps171</STRONG></TD>\n");
      out.write("      <TD width=\"58\"><A href=\"https://gettysburg.wccnet.edu/aa/login_stu.jsp?teacherName=chasselb&amp;courseName=cps171S13-1\" \n");
      out.write("        target=\"Aardvark_StuTop\">Student Login</A></TD>\n");
      out.write("      <TD width=\"61\"><A href=\"https://gettysburg.wccnet.edu/aa/web/Clem/cps171S13/Web/index.html\">Web \n");
      out.write("        Site</A></TD>\n");
      out.write("      <TD width=\"112\"><A href=\"https://gettysburg.wccnet.edu/aa/login_teach.jsp?teacherName=chasselb&amp;courseName=cps171S13-1&amp;address=WorkList\" \n");
      out.write("        target=\"Aardvark_Top\">Teacher Schedule </A></TD></TR></TBODY></TABLE></LI></OL>\n");
      out.write("<P>&nbsp;</P>\n");
      out.write("<HR>\n");
      out.write("\n");
      out.write("<H2>Winter   2013:</H2>\n");
      out.write("<OL>\n");
      out.write("  <LI><B>Course: cps161W13</B><BR>\n");
      out.write("  <TABLE border=\"4\">\n");
      out.write("    <TBODY>\n");
      out.write("    <TR>\n");
      out.write("      <TH width=\"124\">Section</TH>\n");
      out.write("      <TH width=\"58\"></TH>\n");
      out.write("      <TH width=\"61\"></TH></TR>\n");
      out.write("    <TR>\n");
      out.write("      <TD width=\"124\"><STRONG>cps161</STRONG></TD>\n");
      out.write("      <TD width=\"58\"><A href=\"https://gettysburg.wccnet.edu/aa/login_stu.jsp?teacherName=chasselb&amp;courseName=cps161W13-1\" \n");
      out.write("        target=\"Aardvark_StuTop\">Student Login</A> </TD>\n");
      out.write("      <TD width=\"61\"><A href=\"https://gettysburg.wccnet.edu/aa/web/Clem/cps161W13/Web/index.html\">Web \n");
      out.write("        Site</A>                               </TD>\n");
      out.write("      <TD width=\"112\"><A href=\"https://gettysburg.wccnet.edu/aa/login_teach.jsp?teacherName=chasselb&amp;courseName=cps161W13-1&amp;address=WorkList\" \n");
      out.write("        target=\"Aardvark_Top\">Teacher Schedule </A> </TD></TR></TBODY></TABLE></LI>\n");
      out.write("  <LI><B>Course: cps171W13</B><BR>\n");
      out.write("  <TABLE border=\"4\">\n");
      out.write("    <TBODY>\n");
      out.write("    <TR>\n");
      out.write("      <TH width=\"124\">Section</TH>\n");
      out.write("      <TH width=\"58\"></TH>\n");
      out.write("      <TH width=\"61\"></TH></TR>\n");
      out.write("    <TR>\n");
      out.write("      <TD width=\"124\"><STRONG>cps171</STRONG></TD>\n");
      out.write("      <TD width=\"58\"><A href=\"https://gettysburg.wccnet.edu/aa/login_stu.jsp?teacherName=chasselb&amp;courseName=cps171W13-1\" \n");
      out.write("        target=\"Aardvark_StuTop\">Student Login</A> </TD>\n");
      out.write("      <TD width=\"61\"><A href=\"https://gettysburg.wccnet.edu/aa/web/Clem/cps171W13/Web/index.html\">Web \n");
      out.write("        Site</A>                               </TD>\n");
      out.write("      <TD width=\"112\"><A href=\"https://gettysburg.wccnet.edu/aa/login_teach.jsp?teacherName=chasselb&amp;courseName=cps171W13-1&amp;address=WorkList\" \n");
      out.write("        target=\"Aardvark_Top\">Teacher Schedule </A> </TD></TR></TBODY></TABLE></LI>\n");
      out.write("  <LI><B>Course: cps251W13</B><BR>\n");
      out.write("  <TABLE border=\"4\">\n");
      out.write("    <TBODY>\n");
      out.write("    <TR>\n");
      out.write("      <TH width=\"124\">Section</TH>\n");
      out.write("      <TH width=\"58\"></TH>\n");
      out.write("      <TH width=\"61\"></TH></TR>\n");
      out.write("    <TR>\n");
      out.write("      <TD width=\"124\"><STRONG>cps251</STRONG></TD>\n");
      out.write("      <TD width=\"58\"><A href=\"https://gettysburg.wccnet.edu/aa/login_stu.jsp?teacherName=chasselb&amp;courseName=cps251W13-1\" \n");
      out.write("        target=\"Aardvark_StuTop\">Student Login</A> </TD>\n");
      out.write("      <TD width=\"61\"><A href=\"https://gettysburg.wccnet.edu/aa/web/Clem/cps251W13/Web/index.html\">Web \n");
      out.write("        Site</A>                               </TD>\n");
      out.write("      <TD width=\"112\"><A href=\"https://gettysburg.wccnet.edu/aa/login_teach.jsp?teacherName=chasselb&amp;courseName=cps251W13-1&amp;address=WorkList\" \n");
      out.write("        target=\"Aardvark_Top\">Teacher Schedule </A> </TD></TR></TBODY></TABLE></LI></OL>\n");
      out.write("<P>&nbsp;</P>\n");
      out.write("<HR>\n");
      out.write("\n");
      out.write("<H2><A \n");
      out.write("href=\"https://gettysburg.wccnet.edu/aa/web/Clem/home/clem.html\">Information \n");
      out.write("about Clem Hasselbach</A>  </H2>\n");
      out.write("<HR>\n");
      out.write("  Last Updated:    <!-- #BeginDate format:Am1a -->May 11, 2013 8:44 AM<!-- #EndDate --> \n");
      out.write("  <p>\n");
      out.write("      Current Time = \n");
      out.write("      ");

          java.util.Date d = new java.util.Date();
          out.println(d.toString());
      
      out.write("\n");
      out.write("<P></P></DIV></BODY></HTML>\n");
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
