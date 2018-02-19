/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import imageurldata.ImageUrlData;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import jdbc.ConnectionPool;

/**
 *
 * @author Dan
 */
public class IndexServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext servletContext = getServletContext();
        ConnectionPool connectionPool = (ConnectionPool) servletContext.getAttribute("connectionPool");
       
        HttpSession session = request.getSession(true);
        
        
        if (session.getAttribute("index") == null)
        {
            int index = 0;
            session.setAttribute("index", index);
        }
        if (session.getAttribute("subreddit") == null)
        {
          String subreddit = "adviceanimals";
          session.setAttribute("subreddit", subreddit);
        }
        
        System.out.println("req get parm: " + (String)request.getParameter("subreddit"));
        if((String)request.getParameter("subreddit") == null || (String)request.getParameter("subreddit") == "");
        else
        {
            String subreddit = (String)request.getParameter("subreddit");
            session.setAttribute("subreddit", subreddit);
            HashSet<String> subreddits = (HashSet<String>)servletContext.getAttribute("subreddits");
            subreddits.add(subreddit);
            servletContext.setAttribute("subreddits", subreddits);
        }
        
        Connection connection;
        Statement statement;
        ArrayList<ImageUrlData> urlDataList = new ArrayList<ImageUrlData>();
        
        String errorMessage = "";
        
        
        try{
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            int index = (int)session.getAttribute("index");
            String subreddit = (String)session.getAttribute("subreddit");
            System.out.println("using : " + subreddit);
               
                if (statement != null && errorMessage.length() == 0){
                    urlDataList = ImageUrlData.getImageUrls(servletContext, statement, subreddit);
                
                String submit = request.getParameter("submit");
                
                if(submit != null  && urlDataList.size() > 0) 
                {
                    switch(submit)
                        {
                            case ">":
                                index = (index + 1) % urlDataList.size();
                                break;
                            case "<":
                                if (index == 0)
                                    index = urlDataList.size() - 1;
                                else
                                    index--;
                                break;
                            default:
                                //do nothing
                        }
                    
                }
                
                ImageUrlData randomImage;
                if (urlDataList.size() > 0)
                {
                    randomImage = urlDataList.get(index);
                }
                else
                {
                    randomImage = new ImageUrlData("badSubreddit.jpg", "nosubreddit");
                }
                session.setAttribute("index", index);
                request.setAttribute("randomImage", randomImage);
            }
            
            if (statement != null) {
                statement.close();
            }
            
            if(connection != null) {
                connectionPool.free(connection);
            }
        } catch (SQLException e)
        {
            errorMessage = e.toString();
        }
        
        request.setAttribute("errorMessage", errorMessage);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
        
        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

  