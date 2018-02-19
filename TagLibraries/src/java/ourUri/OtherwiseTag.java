package ourUri;


import java.util.*;

import javax.servlet.jsp.JspException;
import java.io.*;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class OtherwiseTag extends SimpleTagSupport {
  

    public void doTag() throws JspException, IOException
    {
              ChooseTag parent = (ChooseTag)findAncestorWithClass(this, ChooseTag.class);
              if (parent == null) 
                     {
                          System.out.println("Can't find parent ChooseTag");
                          throw new RuntimeException("Can't find parent ChooseTag");
                     }
              boolean condition = parent.getCondition();
        
  
             if (!condition)getJspBody().invoke(null);
    }

}
