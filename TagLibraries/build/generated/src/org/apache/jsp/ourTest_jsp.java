package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ourTest_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/ourTest.tld");
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

      out.write("%\n");
      out.write("    String[] movieList = {\"Amelie\", \"Return of the King\", \"Mean Girls\"};\n");
      out.write("    request.setAttribute(\"movieList\", movieList);\n");
      out.write("\n");
      out.write("    String userPref = request.getParameter(\"userPref\");\n");
      out.write("    if (userPref != null)\n");
      out.write("            request.setAttribute(\"userPref\", userPref);\n");
      out.write("\n");
      out.write("\n");
      out.write("%>\n");
      out.write("\n");
      out.write("\n");
      out.write("<html><body>\n");
      out.write("   <h2>Movie List</h2>\n");
      out.write("\n");
      out.write("   <h3>Using forEach </h3>\n");
      out.write("   <table border=\"4\">\n");
      out.write("      ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("   </table>\n");
      out.write("\n");
      out.write("   <hr>\n");
      out.write("\n");
      out.write("   \n");
      out.write("<h3>Using the \"if\" statment</h3>\n");
      out.write("    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<hr>\n");
      out.write("\n");
      out.write("<h3>Using the \"choose\"/\"when\" statment</h3>\n");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<h3>The Brakes</h3>\n");
      out.write("Our advanced anti-lock brake system (ABS)\n");
      out.write("<br>is engineered to give you the ability to steer\n");
      out.write("<br>even as you're stopping.  We have the best\n");
      out.write("<br>speed sensors of any car this size.\n");
      out.write("\n");
      out.write("   \n");
      out.write("<form action=\"ourTest.jsp\">\n");
      out.write("        <br><input type=\"radio\" name=\"userPref\" value=\"performance\">Performance\n");
      out.write("        <br><input type=\"radio\" name=\"userPref\" value=\"safety\">Safety\n");
      out.write("        <br><input type=\"radio\" name=\"userPref\" value=\"maintenance\">Maintenance\n");
      out.write("        <br><input type=\"submit\"  value=\"Submit\">\n");
      out.write("    </form> \n");
      out.write("\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    ourUri.ForEachTag _jspx_th_c_forEach_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(ourUri.ForEachTag.class) : new ourUri.ForEachTag();
    _jspx_th_c_forEach_0.setJspContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setVar("movie");
    _jspx_th_c_forEach_0.setItems((java.util.ArrayList) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${movieList}", java.util.ArrayList.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setJspBody(new ourTest_jspHelper( 0, _jspx_page_context, _jspx_th_c_forEach_0, null));
    _jspx_th_c_forEach_0.doTag();
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    ourUri.IfTag _jspx_th_c_if_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(ourUri.IfTag.class) : new ourUri.IfTag();
    _jspx_th_c_if_0.setJspContext(_jspx_page_context);
    _jspx_th_c_if_0.setTest((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userPref  == 'performance'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_if_0.setJspBody(new ourTest_jspHelper( 1, _jspx_page_context, _jspx_th_c_if_0, null));
    _jspx_th_c_if_0.doTag();
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    ourUri.IfTag _jspx_th_c_if_1 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(ourUri.IfTag.class) : new ourUri.IfTag();
    _jspx_th_c_if_1.setJspContext(_jspx_page_context);
    _jspx_th_c_if_1.setTest((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userPref eq 'safety'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_if_1.setJspBody(new ourTest_jspHelper( 2, _jspx_page_context, _jspx_th_c_if_1, null));
    _jspx_th_c_if_1.doTag();
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    ourUri.IfTag _jspx_th_c_if_2 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(ourUri.IfTag.class) : new ourUri.IfTag();
    _jspx_th_c_if_2.setJspContext(_jspx_page_context);
    _jspx_th_c_if_2.setTest((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userPref=='maintenance'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_if_2.setJspBody(new ourTest_jspHelper( 3, _jspx_page_context, _jspx_th_c_if_2, null));
    _jspx_th_c_if_2.doTag();
    return false;
  }

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    ourUri.ChooseTag _jspx_th_c_choose_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(ourUri.ChooseTag.class) : new ourUri.ChooseTag();
    _jspx_th_c_choose_0.setJspContext(_jspx_page_context);
    _jspx_th_c_choose_0.setJspBody(new ourTest_jspHelper( 4, _jspx_page_context, _jspx_th_c_choose_0, null));
    _jspx_th_c_choose_0.doTag();
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    ourUri.WhenTag _jspx_th_c_when_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(ourUri.WhenTag.class) : new ourUri.WhenTag();
    _jspx_th_c_when_0.setJspContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent(_jspx_parent);
    _jspx_th_c_when_0.setTest((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userPref  eq 'performance'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_when_0.setJspBody(new ourTest_jspHelper( 5, _jspx_page_context, _jspx_th_c_when_0, null));
    _jspx_th_c_when_0.doTag();
    return false;
  }

  private boolean _jspx_meth_c_when_1(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    ourUri.WhenTag _jspx_th_c_when_1 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(ourUri.WhenTag.class) : new ourUri.WhenTag();
    _jspx_th_c_when_1.setJspContext(_jspx_page_context);
    _jspx_th_c_when_1.setParent(_jspx_parent);
    _jspx_th_c_when_1.setTest((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userPref eq 'safety'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_when_1.setJspBody(new ourTest_jspHelper( 6, _jspx_page_context, _jspx_th_c_when_1, null));
    _jspx_th_c_when_1.doTag();
    return false;
  }

  private boolean _jspx_meth_c_when_2(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    ourUri.WhenTag _jspx_th_c_when_2 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(ourUri.WhenTag.class) : new ourUri.WhenTag();
    _jspx_th_c_when_2.setJspContext(_jspx_page_context);
    _jspx_th_c_when_2.setParent(_jspx_parent);
    _jspx_th_c_when_2.setTest((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userPref=='maintenance'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_when_2.setJspBody(new ourTest_jspHelper( 7, _jspx_page_context, _jspx_th_c_when_2, null));
    _jspx_th_c_when_2.doTag();
    return false;
  }

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    ourUri.OtherwiseTag _jspx_th_c_otherwise_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(ourUri.OtherwiseTag.class) : new ourUri.OtherwiseTag();
    _jspx_th_c_otherwise_0.setJspContext(_jspx_page_context);
    _jspx_th_c_otherwise_0.setParent(_jspx_parent);
    _jspx_th_c_otherwise_0.setJspBody(new ourTest_jspHelper( 8, _jspx_page_context, _jspx_th_c_otherwise_0, null));
    _jspx_th_c_otherwise_0.doTag();
    return false;
  }

  private class ourTest_jspHelper
      extends org.apache.jasper.runtime.JspFragmentHelper
  {
    private javax.servlet.jsp.tagext.JspTag _jspx_parent;
    private int[] _jspx_push_body_count;

    public ourTest_jspHelper( int discriminator, JspContext jspContext, javax.servlet.jsp.tagext.JspTag _jspx_parent, int[] _jspx_push_body_count ) {
      super( discriminator, jspContext, _jspx_parent );
      this._jspx_parent = _jspx_parent;
      this._jspx_push_body_count = _jspx_push_body_count;
    }
    public boolean invoke0( JspWriter out ) 
      throws Throwable
    {
      out.write("\n");
      out.write("         <tr>\n");
      out.write("             <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${movie}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("         </tr>\n");
      out.write("      ");
      return false;
    }
    public boolean invoke1( JspWriter out ) 
      throws Throwable
    {
      out.write("\n");
      out.write("        Now you can stop even if you <em> drive insanely fast</em>\n");
      out.write("    ");
      return false;
    }
    public boolean invoke2( JspWriter out ) 
      throws Throwable
    {
      out.write("\n");
      out.write("        Our brakes won't lock up no matter how bad a driver you are.\n");
      out.write("    ");
      return false;
    }
    public boolean invoke3( JspWriter out ) 
      throws Throwable
    {
      out.write("\n");
      out.write("        Lost your tech job? No problem--you won't have to service these brakes \n");
      out.write("        <br>for at least three years.\n");
      out.write("    ");
      return false;
    }
    public boolean invoke4( JspWriter out ) 
      throws Throwable
    {
      out.write("\n");
      out.write("    ");
      if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      out.write("\n");
      out.write("    ");
      if (_jspx_meth_c_when_1((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      out.write("\n");
      out.write("    ");
      if (_jspx_meth_c_when_2((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      out.write("\n");
      out.write("\n");
      out.write("    ");
      if (_jspx_meth_c_otherwise_0((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      out.write('\n');
      out.write('\n');
      return false;
    }
    public boolean invoke5( JspWriter out ) 
      throws Throwable
    {
      out.write("\n");
      out.write("        Now you can stop even if you <em> drive insanely fast</em>\n");
      out.write("    ");
      return false;
    }
    public boolean invoke6( JspWriter out ) 
      throws Throwable
    {
      out.write("\n");
      out.write("        Our brakes won't lock up no matter how bad a driver you are.\n");
      out.write("    ");
      return false;
    }
    public boolean invoke7( JspWriter out ) 
      throws Throwable
    {
      out.write("\n");
      out.write("        Lost your tech job? No problem--you won't have to service these brakes \n");
      out.write("        <br>for at least three years.\n");
      out.write("    ");
      return false;
    }
    public boolean invoke8( JspWriter out ) 
      throws Throwable
    {
      out.write("\n");
      out.write("        Our brakes are the best.\n");
      out.write("    ");
      return false;
    }
    public void invoke( java.io.Writer writer )
      throws JspException
    {
      JspWriter out = null;
      if( writer != null ) {
        out = this.jspContext.pushBody(writer);
      } else {
        out = this.jspContext.getOut();
      }
      try {
        switch( this.discriminator ) {
          case 0:
            invoke0( out );
            break;
          case 1:
            invoke1( out );
            break;
          case 2:
            invoke2( out );
            break;
          case 3:
            invoke3( out );
            break;
          case 4:
            invoke4( out );
            break;
          case 5:
            invoke5( out );
            break;
          case 6:
            invoke6( out );
            break;
          case 7:
            invoke7( out );
            break;
          case 8:
            invoke8( out );
            break;
        }
      }
      catch( Throwable e ) {
        if (e instanceof SkipPageException)
            throw (SkipPageException) e;
        throw new JspException( e );
      }
      finally {
        if( writer != null ) {
          this.jspContext.popBody();
        }
      }
    }
  }
}
