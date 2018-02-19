/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oneliner;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dan
 */
public class onelinerServlet extends HttpServlet {

    String fileName = "";
    String path = "";
    String fullFilePath = "";
    String pathSeparator = System.getProperty("file.separator");
    int index = 0;
    onelinerUtils utils;
    
    @Override
    public void init()
    {
        ServletConfig sc = getServletConfig();
        ServletContext sctx = getServletContext();
        fileName = sc.getInitParameter("fileName");
        path = sc.getInitParameter("path");
        
        
        if (path == null)
            path="onelinerServlet";
        else
            path = path.trim();
        
        if (fileName == null)
            fileName="oneliners.txt";
        
        if (path.length() == 0)
            fullFilePath = sctx.getRealPath("/WEB-INF/"+ path + pathSeparator + fileName);
        else
        {
            fullFilePath = System.getProperty("user.home")+ pathSeparator + path + pathSeparator + fileName;
            utils = new onelinerUtils(fullFilePath);
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
       
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html style=\"height:100%\">");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"animate-custom.css\">");
            out.println("<title>Servlet onelinerServlet</title>");            
            out.println("</head>");
            out.println("<body style=\"background-color:black;height:100%\">");
            out.println("<div style=\"height:100%\">");
            out.println("<div style=\"height:50%\">");
            out.println("<center><h2 class=\"animated fadeInUp\" style=\"color:white;font-size:100px;font-family:Calibri\">");
            //out.println("<center><h1><p style=\"color:white\">" + utils.getNextOneLiner() + "</p></h1></center>");
            out.println(utils.getNextOneLiner());
            out.println("</h2></center>");
            out.println("</div>");
            out.println("<div style=\"height:50%\">");
            out.println("<form action=\"onelinerServlet\">");
            out.println("<br/><center><input type=\"submit\" class=\"animated fadeInDown\" name= \"action\" value=\"Next\" style=\"height:100px;width:400px;font-size:50px;font-family:Calibri;background:black;color:white\" /></center>");
            out.println("</form>");
            out.println("</div>");
            out.println("</div>");
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
