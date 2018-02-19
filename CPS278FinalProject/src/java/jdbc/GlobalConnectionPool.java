package jdbc;

import imagescraper.ImageScraperThread;
import java.sql.SQLException;
import java.util.HashSet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GlobalConnectionPool implements ServletContextListener {
    
    Thread t = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        System.out.println("Servlet listener started!");
        ServletContext servletContext = sce.getServletContext();
        ConnectionPool connectionPool = new ConnectionPool();
        
        HashSet<String> subreddits = new HashSet<String>();
        subreddits.add("earthporn");
        subreddits.add("funny");
        
        servletContext.setAttribute("subreddits", subreddits);

        String userid = servletContext.getInitParameter("db_userid");
        String password = servletContext.getInitParameter("db_password");

        // The following code be configurables in web.xml, but for simplicity I have them hard-coded
        int initialConnections = 3;
        int maxConnections = 20;
        boolean waitIfBusy = true;
        
         

        // Initialize the Connection Pool
        try {
            connectionPool.CreateConnectionPool(userid, password,
                    initialConnections, maxConnections, waitIfBusy);
            servletContext.setAttribute("connectionPool", connectionPool);
            System.out.println("GlobalConnectionPool has setup the connection pool");
            
            System.out.println("Attempting to start the image scraper thread");
            if(t == null || !t.isAlive())
            {
                t = new Thread(new ImageScraperThread(connectionPool, servletContext));
                t.start();
                System.out.println("Imagescraper started");
            }
            
           
        } catch (SQLException e) {
            System.out.println("init SQLException caught: " + e);
        }
        
       
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        ServletContext servletContext = sce.getServletContext();
        ConnectionPool connectionPool = (ConnectionPool) servletContext.getAttribute("connectionPool");
        if (connectionPool != null) {
            connectionPool.closeAllConnections();
            System.out.println("GlobalConnectionPool closed out the connection pool");
        }
        t.interrupt();
        
    }
}