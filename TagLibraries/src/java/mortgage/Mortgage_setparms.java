package mortgage;


import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class Mortgage_setparms extends SimpleTagSupport {


    double principal=-1, interest=-1, payment=-1, months=-1;
    ServletRequest request;
    PageContext pageContext;
    
    public void setPrincipal(double p)
    {
        principal = p;
    }
    public void setInterest(double i)
    {
        interest=i;
    }
    public void setPayment(double p)
    {
        payment=p;
    }
    public void setMonths(int m)
    {
        months=m;
    }
    
    private void convertDoubleParm(double value, String name)
    {
        String str = request.getParameter(name);
        if (value < 0 && str != null)
        {        
            try
            {
                value = Double.parseDouble(str);
            }
            catch (RuntimeException e)
            {
                System.out.println("convertDoubleParm: "+e);
                throw new RuntimeException("OMG SHIT IS FUCKED UP!");
            }
        }
        pageContext.setAttribute(name, new Double(value));
    }
    
    public void doTag() throws JspException, IOException
    {
        pageContext =(PageContext) getJspContext();
        request = pageContext.getRequest();
        
        convertDoubleParm(principal, "principal");
        convertDoubleParm(interest, "interest");
        convertDoubleParm(payment, "payment");
        convertDoubleParm(months, "months");
    }

}