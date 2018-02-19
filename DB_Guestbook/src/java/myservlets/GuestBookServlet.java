package myservlets;

import guestbook.GB_Entry;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbc.ConnectionPool;


public class GuestBookServlet extends HttpServlet {

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url="/guestBookJSTL.jsp";
        try {
            ServletContext servletContext = getServletContext();
            ConnectionPool connectionPool = (ConnectionPool) servletContext.getAttribute("connectionPool");
           
            Connection connection=null;
            try {
                connection = connectionPool.getConnection();
                GB_Entry.update(connection, request);
            } 
            catch (SQLException ex) 
            {
                GB_Entry.setError(ex,  request);
                url="/guestBookError.jsp";
            }
           
            if (connection != null)
                connectionPool.free(connection);
        } finally {            
            RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response); 
        }
    }
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    
}
