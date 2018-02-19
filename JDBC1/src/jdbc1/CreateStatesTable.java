/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CreateStatesTable {
    
    public static void main(String[] args)
    {
        Connection c = MyConnection.getConnection(args);
        Statement s;
        
        String createStateTable = "create table states " +
                "(StateName varchar(40), " +
                "Region enum('east', 'midwest', 'west', 'south', 'southwest'), " +
                "LargestCity varchar(40), " +
                "Capital varchar(40), " +
                "Population int)";
                                  
        
        if (c == null)
        {
            System.out.println("Unable to connect");
            return;
        }
        try {
            s = c.createStatement();
            s.executeUpdate("drop table states");
            s.executeUpdate(createStateTable);
            
            s.executeUpdate("insert into states " +
                    "values('California', 'west', 'Los Angeles', 'Sacramento', '20000000')");
            s.executeUpdate("insert into states " +
                    "values('Michigan', 'midwest', 'Detroit', 'Lansing', '8000000')");
            s.executeUpdate("insert into states " +
                    "values('Texas', 'southwest', 'Dallas', 'Austin', '10000000')");
            s.executeUpdate("insert into states " +
                    "values('Ohio', 'midwest', 'Cleveland', 'Columbus', '8500000')");
            
            ResultSet r = s.executeQuery("select * from states");
            while (r.next()) 
            {
               String state = r.getString("StateName");
               String region = r.getString("Region");
               String lcity = r.getString("LargestCity");
               String ccity = r.getString("Capital");
               int pop = r.getInt("Population");
               System.out.println("State=" + state + " Region=" + region + " Largest City=" + lcity + " Capital=" + ccity + " Population=" + pop);
            }
            s.close();
            c.close();
            } catch (SQLException ex) {
            Logger.getLogger(CreateStatesTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
}


