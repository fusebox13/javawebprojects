package ourUri;


import java.util.*;

import javax.servlet.jsp.JspException;
import java.io.*;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class ForEachTag extends SimpleTagSupport {
    
       PageContext pageContext;
       ArrayList list;
       String name;

       public void setVar(String name)
       {
           this.name=name;
       }
       public void setItems(ArrayList list)
       {
           this.list = list;
       }
       public void setItems(String[] slist)
       {
           list = new ArrayList();
           for (int i=0; i < slist.length; i++)
              list.add(slist[i]);
       }


    public void doTag() throws JspException, IOException
    {
        pageContext =(PageContext) getJspContext();        

        for (int i=0; i < list.size(); i++)
        {            
            pageContext.setAttribute(name, list.get(i));                     
            getJspBody().invoke(null);
        }
    }

}