package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jokes.*;

public final class jokes_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 
    final int NUM_JOKES=3;
    Joke[] jokeList = new Joke[NUM_JOKES];
    boolean first=true;
 
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/includes/jokeInclude.jsp");
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
      out.write("\n");
      out.write('\n');

    if (first)
    {
        first = false;
        for (int i=0; i < NUM_JOKES; i++)
            jokeList[i] = new Joke();
    }
    String strIndex = request.getParameter("index");
    if (strIndex != null)
    {
        int index = Integer.parseInt(strIndex);
        Joke joke = jokeList[index];
        joke.setRating(strIndex, pageContext);
     }

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head><title>My Fun Page</title></head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<h3>3 Legged Chickens</h3>\n");

    pageContext.setAttribute("formIndex", 0);
 
      out.write('\n');
      out.write("Joke Rating = ");
      out.print(jokeList[ (Integer)pageContext.getAttribute("formIndex") ].getRating() );
      out.write("\n");
      out.write("<br><br>\n");
      out.write("<form action=\"jokes.jsp\">\n");
      out.write("<input type=\"radio\" name=\"rating\" value=\"1\">lame(1)\n");
      out.write("<input type=\"radio\" name=\"rating\" value=\"2\">average(2)\n");
      out.write("<input type=\"radio\" name=\"rating\" value=\"3\">good(3)\n");
      out.write("<input type=\"radio\" name=\"rating\" value=\"4\">excellent(4)\n");
      out.write("<input type=\"submit\" value=\"Submit your Rating\">\n");
      out.write("<input type=\"hidden\" name=\"index\" value=\"");
      out.print( pageContext.getAttribute("formIndex") );
      out.write("\" >\n");
      out.write("</form>");
      out.write("\n");
      out.write("\n");
      out.write("<pre>\n");
      out.write("A man was driving along a rural road one day when he saw a three\n");
      out.write("legged chicken.  He was amused enough to drive along side it for a\n");
      out.write("while, as he was driving he noticed the chicken was running 30 mph.\n");
      out.write("Pretty fast chicken, he thought, I wonder just how fast it can run.\n");
      out.write("So he sped up and the chicken did too!  They were now moving along\n");
      out.write("the road at 45 mph!  The man in the car sped up again, to his\n");
      out.write("surprise the chicken was still running ahead of him at 60 mph!!!\n");
      out.write(" \n");
      out.write("Suddenly the chicken turned off the road and ran down a long\n");
      out.write("driveway leading to a farmhouse.  The man followed the chicken to\n");
      out.write("the house and saw a man in the yard and dozens of three legged\n");
      out.write("chickens.  The man in the car called out to the farmer \"How did you\n");
      out.write("get all these three legged chickens?\"\n");
      out.write(" \n");
      out.write("The farmer replied, \"I breed 'em.  Ya see it's me, my wife and my\n");
      out.write("son living here and we all like to eat the chicken leg.  Since a\n");
      out.write("chicken only has two legs, I started breeding this three legged\n");
      out.write("variety so we could all eat our favorite piece.\"\n");
      out.write(" \n");
      out.write("\"That's amazing!\" said the driver \"How do they taste?\"\n");
      out.write(" \n");
      out.write("\"Don't rightly know, can't catch 'em.\"\n");
      out.write("\n");
      out.write("</pre>\n");
      out.write("<hr>\n");
      out.write("<h3>Knight's Work</h3>\n");

    pageContext.setAttribute("formIndex", 1);
 
      out.write('\n');
      out.write("Joke Rating = ");
      out.print(jokeList[ (Integer)pageContext.getAttribute("formIndex") ].getRating() );
      out.write("\n");
      out.write("<br><br>\n");
      out.write("<form action=\"jokes.jsp\">\n");
      out.write("<input type=\"radio\" name=\"rating\" value=\"1\">lame(1)\n");
      out.write("<input type=\"radio\" name=\"rating\" value=\"2\">average(2)\n");
      out.write("<input type=\"radio\" name=\"rating\" value=\"3\">good(3)\n");
      out.write("<input type=\"radio\" name=\"rating\" value=\"4\">excellent(4)\n");
      out.write("<input type=\"submit\" value=\"Submit your Rating\">\n");
      out.write("<input type=\"hidden\" name=\"index\" value=\"");
      out.print( pageContext.getAttribute("formIndex") );
      out.write("\" >\n");
      out.write("</form>");
      out.write("\n");
      out.write("<pre>\n");
      out.write("A knight and his men return to their castle after a long hard day of\n");
      out.write("fighting.\n");
      out.write(" \n");
      out.write("\"How are we faring?\" asks the king.\n");
      out.write(" \n");
      out.write("\"Sire,\" replies the knight, \"I have been robbing and pillaging on\n");
      out.write("your behalf all day, burning the towns of your enemies in the west.\"\n");
      out.write(" \n");
      out.write("\"What?!?\" shrieks the king. \"I don't have any enemies to the west!\"\n");
      out.write(" \n");
      out.write("\"Oh,\" says the knight. \"Well, you do now.\"\n");
      out.write("\n");
      out.write("\n");
      out.write("</pre>\n");
      out.write("<hr>\n");
      out.write("\n");
      out.write("<h3>Big Bridge</h3>\n");

    pageContext.setAttribute("formIndex", 2);
 
      out.write('\n');
      out.write("Joke Rating = ");
      out.print(jokeList[ (Integer)pageContext.getAttribute("formIndex") ].getRating() );
      out.write("\n");
      out.write("<br><br>\n");
      out.write("<form action=\"jokes.jsp\">\n");
      out.write("<input type=\"radio\" name=\"rating\" value=\"1\">lame(1)\n");
      out.write("<input type=\"radio\" name=\"rating\" value=\"2\">average(2)\n");
      out.write("<input type=\"radio\" name=\"rating\" value=\"3\">good(3)\n");
      out.write("<input type=\"radio\" name=\"rating\" value=\"4\">excellent(4)\n");
      out.write("<input type=\"submit\" value=\"Submit your Rating\">\n");
      out.write("<input type=\"hidden\" name=\"index\" value=\"");
      out.print( pageContext.getAttribute("formIndex") );
      out.write("\" >\n");
      out.write("</form>");
      out.write("\n");
      out.write("<pre>\n");
      out.write("\n");
      out.write("\n");
      out.write("One Wish\n");
      out.write("\n");
      out.write("A man was walking along a California beach when he stumbled across an\n");
      out.write("old lamp. He picked it up and rubbed it and out popped a genie.  The\n");
      out.write("genie said  \"OK so you released me from the lamp blah blah blah, but\n");
      out.write("this is the fourth time this week and I'm getting a little sick of\n");
      out.write("these wishes, So you can forget about three. You only get one wish.\"\n");
      out.write("\n");
      out.write("The man sat and thought about it for a while and said, \"I've always\n");
      out.write("wanted to go to Hawaii but I'm too scared to fly and I get very\n");
      out.write("seasick.  So could you build me a bridge to Hawaii so I can drive\n");
      out.write("over there?\"\n");
      out.write("\n");
      out.write("The gene laughed a replied, \"That's impossible. Think of the\n");
      out.write("logistics of that. How would the supports ever reach the bottom of\n");
      out.write("the Pacific?  Think of how much concrete....How much steel!!!! No\n");
      out.write("think of another wish.\"\n");
      out.write("\n");
      out.write("The man agreed and tried to think of a really good wish. He said,\n");
      out.write("\"I've been married and divorced four times. My wives have always said\n");
      out.write("I don't care and that I'm insensitive. I wish that I could understand\n");
      out.write("women. To know  what they are thinking when they give me the silent\n");
      out.write("treatment, To know why they are crying, To know what they want when\n");
      out.write("they say 'nothing'....\"\n");
      out.write("\n");
      out.write("The gene replies \"you want that bridge with two lanes or four?\"\n");
      out.write("\n");
      out.write("</pre>\n");
      out.write("</body>\n");
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
