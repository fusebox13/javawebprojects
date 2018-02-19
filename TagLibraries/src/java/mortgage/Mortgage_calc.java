package mortgage;


import java.io.IOException;
import java.text.NumberFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class Mortgage_calc extends SimpleTagSupport {


    double principal=-1, interest=-1, payment=-1;
    int months=-1;
    PageContext pageContext;


    private double getParm(String name)
    {
        Double d = (Double)pageContext.getAttribute(name);
        if (d == null) return -1;
        return d;
    }

    public void doTag() throws JspException, IOException
    {
        pageContext =(PageContext) getJspContext();
        principal=getParm("principal");
        interest = getParm("interest");
        payment = getParm("payment");
        months = (int)getParm("months");

        double monthly_interest=0.0;
        double curr_principal = principal;

        for (int i=0; i < months; i++)
        {
            monthly_interest = curr_principal * interest /(12 * 100);
            curr_principal = curr_principal + monthly_interest - payment;
            if (curr_principal > 0)
            {
                pageContext.setAttribute("curr_principal", String.format("%,.2f",curr_principal));
                pageContext.setAttribute("monthly_interest", String.format("%,.2f",monthly_interest));
                pageContext.setAttribute("month_num", new Integer(i));
            }
            else break;     
            getJspBody().invoke(null);
        }
    }

}