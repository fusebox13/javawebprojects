/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagescraper;

import im.goel.jreddit.submissions.Submission;
import im.goel.jreddit.submissions.Submissions;
import im.goel.jreddit.user.User;
import imageurldata.ImageUrlData;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import jdbc.ConnectionPool;
import org.json.simple.parser.ParseException;

public class ImageScraperThread implements Runnable
    {
        ConnectionPool cp;
        ServletContext servletContext;
        Connection connection;
        
        public ImageScraperThread(ConnectionPool cp, ServletContext servletContext)
        {
            this.cp = cp;
            this.servletContext = servletContext;
        }

        @Override
        public void run() {
            System.out.println("Image Scraper Thread Started");
            Statement statement;
            ArrayList<Submission> submissions = new ArrayList<Submission>();
            int page = 1;
            HashSet<String> subreddits = (HashSet<String>)servletContext.getAttribute("subreddits");
            
            
            String subreddit;
            
            
            
            User user = new User("Fusebot13", "Fusebot13");
            
            while (true)
            {
                Iterator hashIterator = subreddits.iterator();
                try {
                    user.connect();
                    System.out.println("Connected to Reddit");
                } catch (Exception ex) {
                    System.out.println(ex.toString());
                }

                try {
                    connection = cp.getConnection();
                    statement = connection.createStatement();

                    if (statement != null)
                    {
                        while(hashIterator.hasNext())
                        {
                            subreddit=(String)hashIterator.next();
                            
                            System.out.println("Connected to SQLDatabase");
                            submissions = Submissions.getSubmissions(subreddit, Submissions.Popularity.NEW, page, user);
                            
                            if(submissions != null)
                            {
                                for (int i = 0; i < submissions.size(); i++)
                                {
                                    String url = submissions.get(i).getUrl().toString();
                                    subreddit = submissions.get(i).getSubreddit();



                                    if(url.endsWith(".jpg"))
                                    {
                                        System.out.println(url);
                                        ImageUrlData IUD = new ImageUrlData(url, subreddit);
                                        System.out.println(IUD);
                                        System.out.println(IUD.addToDataBase(statement));
                                    }
                                }
                            }
                        }
                    }

                    if (statement != null)
                    {
                        statement.close();
                    }

                    if (connection != null) {
                        cp.free(connection);
                    }



                } catch (SQLException e) {
                    //todo

                } catch (IOException ex) {
                    //todo
                    
                } catch (ParseException ex) {
                    //todo
                    
                }

                try {
                    System.out.println("Going to sleep");
                    Thread.sleep(30000);
                } catch (InterruptedException ex) {
                    //todo
                }
                page++;
                System.out.println("Woke up");
            }
        
        }

    
        
       
   }