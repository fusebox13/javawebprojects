package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Person.*;

public final class PersonCollection_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");

    PersonCollection personCollection = PersonCollection.update(pageContext);    

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Super Secret NSA Database</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Super Secret NSA Database</h1>\n");
      out.write("        <p>\n");
      out.write("        <div>    \n");
      out.write("        <form action=\"PersonCollection.jsp\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"label\">First Name</div>\n");
      out.write("                <div class=\"form\"> <input class=\"nameBox\" type=\"text\" name=\"firstName\"  /></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"label\">Middle Name</div>\n");
      out.write("                <div class=\"form\"> <input class=\"nameBox\" type=\"text\" name=\"middleName\"  /></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"label\">Last Name</div>\n");
      out.write("                <div class=\"form\"> <input class=\"nameBox\" type=\"text\" name=\"lastName\"  /></div>\n");
      out.write("            </div>\n");
      out.write("       \n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"selectLabel\">Eye Color</div>\n");
      out.write("                \n");
      out.write("                <div class=\"selectLabel\">Hair Color</div>\n");
      out.write("                <div class=\"hwLabel\">Weight</div>\n");
      out.write("                <div class=\"hwLabel\">Height</div>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"select\">\n");
      out.write("                    <select class =\"selectBox\" name=\"eyeColor\">\n");
      out.write("                        <option value=\"Amber\">Amber</option>\n");
      out.write("                        <option value=\"Blue\">Blue</option>\n");
      out.write("                        <option value=\"Brown\">Brown</option>\n");
      out.write("                        <option value=\"Gray\">Gray</option>\n");
      out.write("                        <option value=\"Green\">Green</option>\n");
      out.write("                        <option value=\"Hazel\">Hazel</option>\n");
      out.write("                        <option value=\"Red\">Red</option>\n");
      out.write("                        <option value=\"Violet\">Violet</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"select\">\n");
      out.write("                    <select class =\"selectBox\" name=\"hairColor\">\n");
      out.write("                        <option value=\"Auburn\">Auburn</option>\n");
      out.write("                        <option value=\"Black\">Black</option>\n");
      out.write("                        <option value=\"Brown\">Brown</option>\n");
      out.write("                        <option value=\"Blond\">Blond</option>\n");
      out.write("                        <option value=\"Chestnut\">Chestnut</option>\n");
      out.write("                        <option value=\"Red\">Red</option>\n");
      out.write("                        <option value=\"Gray\">Gray</option>\n");
      out.write("                        <option value=\"White\">White</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"hwLabel\">\n");
      out.write("                    <input class=\"hwBox\" type=\"text\" name=\"weight\" width/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"hwLabel\">\n");
      out.write("                    <input class=\"hwBox\" type=\"text\" name =\"height\"/> \n");
      out.write("                </div>\n");
      out.write("            \n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <input class=\"button\" type=\"submit\" name=\"action\" value=\"Add\"/>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("        <hr>\n");
      out.write("        <h3>");
      out.print(personCollection.getErrorMessage());
      out.write("</h3>\n");
      out.write("        \n");
      out.write("        <table cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("            ");

                if(personCollection.hasEntries())
                {
            
      out.write("\n");
      out.write("            \n");
      out.write("            <tr><th>First Name</th><th>Middle Name</th><th>Last Name</th><th>Eye Color</th><th>Hair Color</th><th>Weight</th><th>Height</th></tr>\n");
      out.write("        \n");
      out.write("            ");

                
                    for (int i=0; i < personCollection.size(); i++)
                    {
                        Person tdPerson = personCollection.getPerson(i);
            
      out.write("\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("            <form action=\"PersonCollection.jsp\">\n");
      out.write("                <td><input class=\"outBox\" type =\"text\" read name=\"firstName\" value=\"");
      out.print(tdPerson.getAttribute("firstName"));
      out.write("\"/></td>\n");
      out.write("                <td><input class=\"outBox\" type =\"text\" read name=\"middleName\" value=\"");
      out.print(tdPerson.getAttribute("middleName"));
      out.write("\"/></td>\n");
      out.write("                <td><input class=\"outBox\" type =\"text\" read name=\"lastName\" value=\"");
      out.print(tdPerson.getAttribute("lastName"));
      out.write("\"/></td>\n");
      out.write("                <td><input class=\"outBox\" type =\"text\" read name=\"eyeColor\" value=\"");
      out.print(tdPerson.getAttribute("eyeColor"));
      out.write("\"/></td>\n");
      out.write("                <td><input class=\"outBox\" type =\"text\" read name=\"hairColor\" value=\"");
      out.print(tdPerson.getAttribute("hairColor"));
      out.write("\"/></td>\n");
      out.write("                <td><input class=\"outBox\" type =\"text\" read name=\"weight\" value=\"");
      out.print(tdPerson.getAttribute("weight"));
      out.write("\"/></td>\n");
      out.write("                <td><input class=\"outBox\" type =\"text\" read name=\"height\" value=\"");
      out.print(tdPerson.getAttribute("height"));
      out.write("\"/></td>\n");
      out.write("                <td><input class=\"button\" type=\"submit\" name=\"action\" value=\"remove\"/></td>\n");
      out.write("                <td><input class=\"button\" type=\"submit\" name=\"action\" value=\"update\"/></td>\n");
      out.write("                <input type=\"hidden\" name=\"index\" value=\"");
      out.print( i);
      out.write("\"/>\n");
      out.write("            </form>\n");
      out.write("            </tr>\n");
      out.write("            ");

                    }
            
      out.write("\n");
      out.write("    </table>\n");
      out.write("    \n");
      out.write("    <form action=\"PersonCollection.jsp\">\n");
      out.write("            <input class=\"button\" type=\"submit\" name=\"action\" value=\"Destroy\">\n");
      out.write("    </form>\n");
      out.write("    ");

                }
    
      out.write("\n");
      out.write("        \n");
      out.write("            \n");
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
