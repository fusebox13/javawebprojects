<%@page import= "interest.*, java.util.*" %>
<%
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
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interest Rate Calculations</title>
    </head>
    <body>
        
        <h1> Interest Rate Calculations </h1>
        <%
            if (errorMessage.length() > 0)
                out.println("<h2> Bad User Inputs:</h2>" + errorMessage);
            else
            {
        %>
                
                <table border="4">
                <tr><th>Month</th> <th>Interest</th><th>Principal</th></tr>
                
                <%
                    ArrayList<interestCalc> interestArr = 
                    interestCalculations.getInterestCalcs(principal,  interestRate,  monthlyPayment, years);
                
                    for (int m=0; m < interestArr.size(); m++)
                    {
                        interestCalc intCalc = interestArr.get(m);
                %>
                        <tr>
                        <td> <%= m %> </td>   
                        <td> <%= intCalc.getCurrentInterestPaid() %> </td>
                        <td> <%= intCalc.getCurrentPrincipal() %> </td>
                        </tr>
                <%
                    }
                out.println("</table>");
            }
    
        %>
        
        
    </body>
</html>
