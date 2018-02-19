package tlds;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;

public class SimpleTagTest4 extends SimpleTagSupport
{
    String[] movies={"Monsoon Wedding", "Saved!", "Fahrenheit 9/11"};

    public void doTag() throws JspException, IOException
    {              
        PageContext pageContext = (PageContext)getJspContext();

        for (int i=0; i < movies.length; i++)
        {
            pageContext.setAttribute("movie", movies[i]);
            JspFragment fragment = getJspBody();
            fragment.invoke(null);
        }
    }
}