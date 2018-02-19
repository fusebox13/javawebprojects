package tlds;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.*;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;

public class SimpleTagTest5 extends SimpleTagSupport
{
    private List movieList;

    public void setMovieList(List movieList)
    {
        this.movieList = movieList;
    }

    public void doTag() throws JspException, IOException
    {    
              
        PageContext pageContext = (PageContext)getJspContext();

        for (int i=0; i < movieList.size(); i++)
        {
            Movie movie = (Movie)movieList.get(i);
            pageContext.setAttribute("movie", movie);        
            
           JspFragment fragment = getJspBody();
           fragment.invoke(null);
        }
    }
}