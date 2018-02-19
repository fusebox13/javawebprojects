package jdbc1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CreateCitiesTable {
    
    
    public static String insert(String c, String s, int p)
    {
        return "insert into cities " + "values('" + c +"','" + s + "','" + p + "')";
    }
    public static void main(String[] args)
    {
        Connection c = MyConnection.getConnection(args);
        Statement s;
        
        String createCitiesTable = "create table cities " +
                "(CityName varchar(40), " +
                "StateName varchar(40), " +
                "Population int)";
                                  
        
        if (c == null)
        {
            System.out.println("Unable to connect");
            return;
        }
        try {
            s = c.createStatement();
            s.executeUpdate("drop table cities");
            s.executeUpdate(createCitiesTable);
            
            s.executeUpdate(insert("San Francisco", "California", 980000 ));
            s.executeUpdate(insert("San Pedro", "California", 120000 ));
            s.executeUpdate(insert("Fresno", "California", 500000 ));
            s.executeUpdate(insert("Ann Arbor", "Michigan", 140000 ));
            s.executeUpdate(insert("Lansing", "Michigan", 90000 ));
            s.executeUpdate(insert("Detroit", "Michigan", 2100000 ));
            s.executeUpdate(insert("Austin", "Texas", 500000 ));
            s.executeUpdate(insert("Dallas", "Texas", 2100000 ));
            s.executeUpdate(insert("Cleveland", "Ohio", 1200000 ));
            s.executeUpdate(insert("Columbus", "Ohio", 200000 ));
            
            
            ResultSet r = s.executeQuery("select * from cities");
            while (r.next()) 
            {
               String city = r.getString("CityName");
               String state = r.getString("StateName");
               int pop = r.getInt("Population");
               System.out.println("CityName=" + city + " StateName=" + state + " Population=" + pop);
            }
            s.close();
            c.close();
            } catch (SQLException ex) {
            Logger.getLogger(CreateStatesTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
}


