package jdbc2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class SqlCmdLine {
    public static void main(String[] args) 
    {
        Connection connection = MyConnection.getConnection(args);
        if (connection == null)
        {
            System.out.println("Unable to get a Data base connection ... exitting");
            return;
        }
        
        Scanner keyboard = new Scanner(System.in);
        String cmd="";
        boolean continueFlag = true;
        do
        {
            System.out.println("Enter SQL CMD:");
            cmd= keyboard.nextLine();
            
            
            if ("quit".equals(cmd))
                continueFlag = false;
            else
            {
                GenericBean gb = new GenericBean(connection, cmd);
                GenericBeanResult gbr = gb.getResults();
                System.out.println(gbr.toString());
                System.out.println("********************************");
            }
        } while (continueFlag);
        
        
        try { // Stupid that I need to do this.
            connection.close();
        } catch (SQLException ex) {  }
    }
    
}