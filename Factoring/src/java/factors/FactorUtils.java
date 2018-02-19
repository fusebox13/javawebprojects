package factors;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class FactorUtils {
    public static ArrayList<Factor> update(HttpServletRequest request)
    {
        String number = request.getParameter("number");
        int num;
        request.setAttribute("message", "");
        if (number == null)
            return null; // Need to go to a form to enter in the number
        
        try
        {
            number = number.trim();
            num = Integer.parseInt(number);
        } 
        catch (NumberFormatException e)
        {
            request.setAttribute("message", "The last Input("+
                    number+" )was a bad input ... Please Enter a number");
            return null;
        }
        
        ArrayList<Factor> farr = new ArrayList<Factor>();
        boolean first=true;
        
        for (int base=2; base <= num; base++)
        {
            int exp = 0;
            while ((num % base) == 0)
            {
                exp +=1;
                num /= base;
            }
            if (exp > 0)
            {
                farr.add(new Factor(first,base,exp));
                first = false;
            }
        }
        
        return farr;
    }
    
}