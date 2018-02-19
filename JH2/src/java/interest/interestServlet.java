/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dan
 */
@WebServlet(name = "interestServlet", urlPatterns = {"/interestServlet"})
public class interestServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet interestServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1> Interest Rate Calculations " + "</h1>");
            if (errorMessage.length() > 0)
                out.println("<h2> Bad User Inputs:</h2>" + errorMessage);
            else
            {
                
                out.println("<table border=\"4\" >");
                out.println("<tr><th>Month</th> <th>Interest</th><th>Principal</th></tr>");
                ArrayList<interestCalc> interestArr = 
                        interestCalculations.getInterestCalcs(principal,  interestRate,  monthlyPayment, years);
                
                for (int m=0; m < interestArr.size(); m++)
                {
                    out.println("<tr>");
                    out.println("<td>"+ m + "</td>");   
                    interestCalc intCalc = interestArr.get(m);
                    out.println("<td>"+ intCalc.getCurrentInterestPaid() + "</td>");
                    out.println("<td>"+ intCalc.getCurrentPrincipal() + "</td>");
                    out.println("</tr>");
                }
                
                out.println("</table>");
            }
            
            
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
