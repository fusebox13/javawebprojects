package ourUri;


import java.util.*;

import javax.servlet.jsp.JspException;
import java.io.*;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class IfTag extends SimpleTagSupport {
    
       boolean condition=false;

       public void setTest(Boolean b)
       {
           condition =b;
       }
      


    public void doTag() throws JspException, IOException
    {
        if (condition)                     
            getJspBody().invoke(null);
    }

}