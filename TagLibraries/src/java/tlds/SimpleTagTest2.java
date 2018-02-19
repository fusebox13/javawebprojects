package tlds;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Date;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;

public class SimpleTagTest2 extends SimpleTagSupport
{
    public void doTag() throws JspException, IOException
    {
        // Note that getJspContext() returns something like pageContext              
        PageContext pageContext = (PageContext)getJspContext();
        pageContext.setAttribute("date", new Date());

        JspFragment fragment = getJspBody();
        fragment.invoke(null);
    }
}