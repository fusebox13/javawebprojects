package ourUri;


import java.util.*;

import javax.servlet.jsp.JspException;
import java.io.*;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class ChooseTag extends SimpleTagSupport {
    
       boolean condition=false;

       public void setCondition(boolean b)
       {
           condition =b;
       }
       public boolean getCondition()
       {
           return condition;
       }
      


    public void doTag() throws JspException, IOException
    {  
           getJspBody().invoke(null);
    }

}