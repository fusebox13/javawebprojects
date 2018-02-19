/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import im.goel.jreddit.submissions.Submission;
import im.goel.jreddit.submissions.Submissions;
import im.goel.jreddit.user.User;
import imageurldata.ImageUrlData;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Dan
 */
public class Sql {
    
    
    public static void createURLTable(Statement statement, String subreddit)
    {
        try {
            ArrayList<Submission> submissions = new ArrayList<Submission>();
            subreddit = subreddit.toLowerCase();
            User user = new User("Fusebot13", "Fusebot13");
            
            String sql = "create table " + subreddit.toLowerCase() + " ( imageIndex int auto_increment, imageURL varchar(400) unique, primary key (imageIndex) );";
            statement.executeUpdate(sql);
            try {
                user.connect();
                System.out.println("Connected to Reddit");
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
            try {
                submissions = Submissions.getSubmissions(subreddit, Submissions.Popularity.HOT, 5, user);
            } catch (IOException ex) {
                System.out.println("Unable to connect to reddit");
            } catch (ParseException ex) {
                System.out.println("Unable to parse JSON document");
            }
            
            if(submissions != null)
            {
                
                    for (int i = 0; i < submissions.size(); i++)
                    {
                        String url = submissions.get(i).getUrl().toString();

                        if(url.endsWith(".jpg"))
                                        {
                                            System.out.println(url);
                                            ImageUrlData IUD = new ImageUrlData(url, subreddit);
                                            System.out.println(IUD);
                                            System.out.println(IUD.addToDataBase(statement));
                                        }
                    }
             
                }
        } catch (SQLException ex) {
            System.out.println("Sql.createURLTable threw an exception:" + ex.toString());
        }
        }
        
        
        
   }
    

