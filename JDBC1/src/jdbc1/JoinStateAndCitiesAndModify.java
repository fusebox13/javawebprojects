package jdbc1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JoinStateAndCitiesAndModify {
    
    
    public static void main(String[] args)
    {
        Connection c = MyConnection.getConnection(args);
        Statement s;
        String joinCommand = "select CityName, cities.Population, states.StateName, Region from cities, states where cities.StateName = states.StateName";
        String deleteCommand = "delete from cities where CityName='San Francisco'";
        String updateCommand = "update cities set population=9999 where CityName='San Pedro'";
        try {
            s = c.createStatement();
            
            
            ResultSet r = s.executeQuery(joinCommand);
            while (r.next()) 
            {
               String city = r.getString("CityName");
               String state = r.getString("StateName");
               String region = r.getString("Region");
               int pop = r.getInt("Population");
               System.out.println("CityName=" + city + " StateName=" + state + " Population=" + pop + " Region=" + region);
            }
            
            System.out.println("**************************************************");
            s.executeUpdate(deleteCommand);
            s.executeUpdate(updateCommand);
            
            r = s.executeQuery(joinCommand);
            while (r.next()) 
            {
               String city = r.getString("CityName");
               String state = r.getString("StateName");
               String region = r.getString("Region");
               int pop = r.getInt("Population");
               System.out.println("CityName=" + city + " StateName=" + state + " Population=" + pop + " Region=" + region);
            }
            
            s.close();
            c.close();
            } catch (SQLException ex) {
            Logger.getLogger(CreateStatesTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
}


