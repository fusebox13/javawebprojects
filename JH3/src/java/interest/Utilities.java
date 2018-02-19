
package interest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Utilities {
    
    public static String validateParameters(HttpServletRequest request, HttpServletResponse response)
    {
        String errorMessage = "";
        
        double interestRate = 0.06;
        double monthlyPayment = 150.00;
        double principal = 6000.00;
        int years = 0;
        
        try{
            interestRate = Double.parseDouble(request.getParameter("interestRate").trim());
        }
        catch (NumberFormatException e){
            errorMessage += "Invalid interest rate. ";
        }
        
        try{
            monthlyPayment = Double.parseDouble(request.getParameter("monthlyPayment").trim());
        }
        catch (NumberFormatException e){
            errorMessage += "Invalid monthly payment.";
        }
        
        try{
            principal = Double.parseDouble(request.getParameter("principal").trim());
        }
        catch (NumberFormatException e)
        {
            errorMessage += "Invalid principal.";
        }
        
        //Need to get from the HTML still
        try{
            years = Integer.parseInt(request.getParameter("years").trim());
        }
        catch (NumberFormatException e)
        {
            errorMessage += "Invalid years";
        }
        
        return errorMessage;
    }
    
}
