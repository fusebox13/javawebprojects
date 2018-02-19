/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc2;
import java.sql.*; 

public class ScrollableResultSet {

   public static void main(String args[]) {
       Connection con=MyConnection.getConnection(args);
       Statement stmt;
            
       if (con == null)
       {
           System.out.println("Unable to create connection");
           return;
       }

       try {
           stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                       ResultSet.CONCUR_READ_ONLY);

           ResultSet srs = stmt.executeQuery("SELECT * FROM COFFEES");

           srs.absolute(4); 
           int rowNum = srs.getRow(); // rowNum should be 4
           System.out.println("rowNum should be 4 " + rowNum);
           srs.relative(-3); 
           rowNum = srs.getRow(); // rowNum should be 1
           System.out.println("rowNum should be 1 " + rowNum);
           srs.relative(2); 
           rowNum = srs.getRow(); // rowNum should be 3
           System.out.println("rowNum should be 3 " + rowNum);

           srs.absolute(1);
           System.out.println("after last? " + srs.isAfterLast() );
           if (!srs.isAfterLast()) {
               String name = srs.getString("COF_NAME");
               float price = srs.getFloat("PRICE");
               System.out.println(name + "     " + price);
           }
           
           // Go through result set in backwards order
           srs.afterLast();
           while (srs.previous()) {
               String name = srs.getString("COF_NAME");
               float price = srs.getFloat("PRICE");
               System.out.println(name + "     " + price);
           }

           srs.close();
           stmt.close();
           con.close();

       } catch(SQLException ex) {
           System.err.println("-----SQLException-----"+ex);
       }
   }
}
