/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc2;

import java.sql.*; 
     
public class Join {

   public static void main(String args[]) {
       Connection con=MyConnection.getConnection(args);
       String query = "select SUPPLIERS.SUP_NAME, COFFEES.COF_NAME " +
                      "from COFFEES, SUPPLIERS " +
                      "where SUPPLIERS.SUP_NAME = 'Acme, Inc.' AND " +
                      "SUPPLIERS.SUP_ID = COFFEES.SUP_ID";
       Statement stmt;
       if (con == null)
       {
           System.out.println("Unable to create connection");
           return;
       }
       
       try {   
           stmt = con.createStatement();                           
   
           ResultSet rs = stmt.executeQuery(query);
           System.out.println("Supplier, Coffee:");
           while (rs.next()) {
               String supName = rs.getString(1);
               String cofName = rs.getString(2);
               System.out.println("    " + supName + ", " + cofName);
           }

           stmt.close();
           con.close();

       } catch(SQLException ex) {
           System.err.print("SQLException: ");
           System.err.println(ex.getMessage());
       }   
   }
}