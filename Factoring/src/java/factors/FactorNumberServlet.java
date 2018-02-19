/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factors;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dan
 */
@WebServlet(name = "FactorNumberServlet", urlPatterns = {"/FactorNumberServlet"})
public class FactorNumberServlet extends HttpServlet {

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
         ArrayList<Factor>factorArr = FactorUtils.update(request);
        if (factorArr == null)
        {
            RequestDispatcher dispatcher =
                  getServletContext().getRequestDispatcher(
                    "/NumberPrompt.jsp?Action=FactorNumberServlet");
            dispatcher.forward(request, response);
            return;
        }
        
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FactorNumberServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Factoring the number "+ request.getParameter("number")+"</h1>");
            if (factorArr.size() <= 1) 
            {
                 out.println("<h3>PRIME</h3>");
            }
            else
            {
                for (int i=0; i < factorArr.size(); i++)
                {
                    out.println(factorArr.get(i));
                }
            }
            out.println("<p>");
            out.println("<a href=\"NumberPrompt.jsp?Action=FactorNumberServlet\"> Enter another number to factor</a>");
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
