package my_servlets;

import JDBC.GenericBean;
import JDBC.GenericBeanResult;
import JDBC.MyConnection;
import JDBC.WebBeanResult;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebLoginEachTime extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            ServletContext servletContext = getServletContext();
            String[] args = {servletContext.getInitParameter("db_userid"),
                servletContext.getInitParameter("db_password")};

            Connection connection = MyConnection.getConnection(args);

            String sqlCmd = request.getParameter("sqlCmd");
            GenericBean gb = new GenericBean(connection, sqlCmd);
            GenericBeanResult genericBeanResult = gb.getResults();
            WebBeanResult webBeanResult = new WebBeanResult(genericBeanResult);


            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }

            request.setAttribute("webBeanResult", webBeanResult);
            String url = "/Web_DB_Output.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);


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