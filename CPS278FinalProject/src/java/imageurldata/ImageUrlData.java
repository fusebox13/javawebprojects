/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageurldata;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import sql.Sql;




public class ImageUrlData {
    
   
    private String imageUrl;
    private String subreddit;
    
    public ImageUrlData(String imageUrl, String subreddit)
    {
        this.imageUrl = imageUrl;
        this.subreddit = subreddit.toLowerCase();
    }
    
    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }
    
    public void setSubreddit(String subreddit)
    {
        this.subreddit = subreddit.toLowerCase();
    }
    
    public String getImageUrl()
    {
        return imageUrl;
    }
    
    public String getSubreddit()
    {
        return subreddit;
    }
    
    public String toString()
    {
        return this.imageUrl + ", " + this.subreddit;
    }
    
    
    public String addToDataBase(Statement s)
    {
        String errorMessage = "";
        String sql = "select imageURL from " + subreddit + " where imageUrl=" + addQuotes(imageUrl);
        
        try
        {
            ResultSet rs = s.executeQuery(sql);
            if (rs.next())
                errorMessage = "Duplicate Entry";
        }
        catch (SQLException e)
        {
            errorMessage = e.toString();
        }
        
        if(errorMessage == "")
        {
            sql = "insert into " + subreddit + " values(" + "null, " + addQuotes(imageUrl) + ")";
            return executeUpdate(sql, s);
        }
        else
            return errorMessage;
          
    }

    private String addQuotes(String s) {
        return "\'" + s + "\'";
    }
    
     private static String executeUpdate(String sql, Statement statement) {
        
        String errorMessage = "";
        try {
            System.out.println("sql=" + sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            errorMessage = e.toString();
        }
        return errorMessage;
    }
     
      public static ArrayList<ImageUrlData> getImageUrls(ServletContext servletcontext, Statement statement, String subreddit) {
          
        ArrayList<ImageUrlData> imageUrlDataArray = new ArrayList<ImageUrlData>();
        try {
            String sql = "select * from " + subreddit;
            System.out.println("sql="+sql);
            ResultSet rs = statement.executeQuery(sql);
            imageUrlDataArray.clear();
            while (rs.next()) {
                String imageUrl = rs.getString("imageURL");
                int imageIndex = rs.getInt("imageIndex");
                
                
                ImageUrlData imageUrlDataPoint = new ImageUrlData(imageUrl, subreddit);
                imageUrlDataArray.add(imageUrlDataPoint);
            }
        } catch (SQLException ex) {
            if (ex.toString().indexOf("doesn't exist") != -1)
            {
                
                    Sql.createURLTable(statement, subreddit);
                    System.out.println("Calling getImageUrls again");
                    int index = 0;
                    servletcontext.setAttribute("index", index);
                    return getImageUrls(servletcontext, statement, subreddit);
               
            }
            System.out.println("Error in getImageUrls: " + ex.toString());
        }
        System.out.println("returning: " + imageUrlDataArray);
        return imageUrlDataArray;
    }
      
      
}
