package radioActive;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import radioActive.RACalc;
import radioActive.RadioActiveCalculations;


@WebServlet(name = "RadioActiveServlet", urlPatterns = {"/RadioActiveServlet"})
public class RadioActiveServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Counting on our hidden variable being there and correct
        int pixelsInTotalBar = Integer.parseInt(request.getParameter("pixelsInTotalBar"));
       
        // text fields are assumed to never return null
        String extraTitleText = request.getParameter("substance").trim(); 
        if (extraTitleText.length() > 0)
            extraTitleText = " for "+ extraTitleText;
        
        String errorMsg ="";
        
        int years=0;
        double halfLife=1.0;
        try
        {
            years = Integer.parseInt(request.getParameter("years").trim());
        }
        catch (NumberFormatException e)
        {
            errorMsg += " Bad Number of Years. ";
        }
        
        try
        {
            halfLife = Double.parseDouble(request.getParameter("halfLife").trim());
            extraTitleText += ",  HalfLife = " + halfLife;
        }
        catch (NumberFormatException e)
        {
            errorMsg += " Bad Half Life. ";
        }
        
        
            
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RadioActiveServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            
            out.println("<h1> Radio Active Calculations " + extraTitleText + "</h1>");
            if (errorMsg.length() > 0)
                out.println("<h2> Bad User Inputs:</h2>" + errorMsg);
            else
            {
                
                out.println("<table border=\"4\" >");
                out.println("<tr><th>Year</th> <th>Amount Decayed</th><th>Fraction Remaining</th><th>Bar Remaining </th></tr>");
                ArrayList<RACalc> raArr = 
                        RadioActiveCalculations.getRadioActiveArr(halfLife,  years,  pixelsInTotalBar);
                
                for (int y=0; y < raArr.size(); y++)
                {
                    out.println("<tr>");
                    out.println("<td>"+ y + "</td>");   
                    RACalc rac = raArr.get(y);
                    out.println("<td>"+ rac.getLostFraction() + "</td>");
                    out.println("<td>"+ rac.getCurrFraction() + "</td>");
                    out.println("<td><img src=\"red.gif\" height=\"10\" width=\"" +
                            rac.getCurrFractionPixels() + "\" /></td>");
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