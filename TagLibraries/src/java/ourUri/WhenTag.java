package ourUri;


import java.util.*;

import javax.servlet.jsp.JspException;
import java.io.*;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class WhenTag extends SimpleTagSupport {
    
       boolean condition=false;

       public void setTest(Boolean b)
       {
           condition =b;
       }
      


    public void doTag() throws JspException, IOException
    {
        if (condition)
              {                     
                     ChooseTag parent = (ChooseTag)findAncestorWithClass(this, ChooseTag.class);
                     if (parent == null) 
                     {
                          System.out.println("Can't find parent ChooseTag");
                          throw new RuntimeException("Can't find parent ChooseTag");
                     }
       
                     parent.setCondition(true); 
                     getJspBody().invoke(null);
              }
    }

}