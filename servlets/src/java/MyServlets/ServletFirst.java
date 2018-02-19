/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dan
 */
@WebServlet(name = "ServletFirst", urlPatterns = {"/ServletFirst"})
public class ServletFirst extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletFirst</title>");            
            out.println("</head>");
            out.println("<body>");
           
            out.println("<h1>Welcome</h1>");
            out.println("Here is the information we collected from you");
            
            String fullName = request.getParameter("fullName");
            String wccStudent = request.getParameter("wccStudent");
            String gender = request.getParameter("gender");
            String classYear = request.getParameter("classYear");
            String[] properties = request.getParameterValues("properties");
            String information = request.getParameter("information");
            
            out.println("<p>your full name is: " + fullName);
            if (wccStudent != null)
            {
                out.println("<p>The answer to whether you are a WCC student is: " + wccStudent);
            }
            if (gender != null)
                out.println("<p>Your gender is " + gender);
            out.println("<p>Your class year is: " + classYear);
            if (properties != null && properties.length > 0)
            {
                out.println("<p>Your properties are: ");
                for (int i=0; i < properties.length; i++)
                    out.println(" " + properties[i]);
            }
            out.println("<p>Your extra information is: " + information);
            
            out.println("<h2> Parameters</h2>");
            out.println("<table border=\"4\" >");
            Enumeration e = request.getParameterNames();
            out.println("<tr><th>NAME</th><th>VALUE</th></tr>");

            while (e.hasMoreElements()) {
                String name = (String) e.nextElement();
                String[] values = request.getParameterValues(name);
                out.println("<tr><td>" + name + "</td><td>" );
                for (int i=0; i < values.length; i++)
                {
                    if (i > 0) out.print(", ");
                    out.println(values[i]);
                }
                out.println("</td></tr>");

            }
            out.println("</table>");
            
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
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
