package tlds;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;


public class SimpleTagTest1 extends SimpleTagSupport
{
    public void doTag() throws JspException, IOException
    {                  
        PageContext pageContext = (PageContext)getJspContext();
        JspWriter out = pageContext.getOut();
        out.print("This is the lamest use of a custom tag");
    }
}
