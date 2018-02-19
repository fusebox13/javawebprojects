/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc2;
import java.sql.*; 

public class BatchUpdate {

   public static void main(String args[]) throws SQLException {

       ResultSet rs = null;
       PreparedStatement ps = null;
       Connection con=MyConnection.getConnection(args);
       Statement stmt;

      
       if (con == null)
       {
           System.out.println("Unable to create connection");
           return;
       }
       try {
           con.setAutoCommit(false);

           stmt = con.createStatement();  

           stmt.addBatch("INSERT INTO COFFEES " + 
                "VALUES('Amaretto', 49, 9.99, 0, 0)");
           stmt.addBatch("INSERT INTO COFFEES " +
               "VALUES('Hazelnut', 49, 9.99, 0, 0)");
           stmt.addBatch("INSERT INTO COFFEES " +
               "VALUES('Amaretto_decaf', 49, 10.99, 0, 0)");
           stmt.addBatch("INSERT INTO COFFEES " +
               "VALUES('Hazelnut_decaf', 49, 10.99, 0, 0)");

           int [] updateCounts = stmt.executeBatch();
           con.commit();
           con.setAutoCommit(true);

           ResultSet uprs = stmt.executeQuery("SELECT * FROM COFFEES");

           System.out.println("Table COFFEES after insertion:");
           while (uprs.next()) {
               String name = uprs.getString("COF_NAME");
               int id = uprs.getInt("SUP_ID");
               float price = uprs.getFloat("PRICE");
               int sales = uprs.getInt("SALES");
               int total = uprs.getInt("TOTAL");
               System.out.print(name + "   " + id + "   " + price);
               System.out.println("   " + sales + "   " + total);
           }

           uprs.close();
           stmt.close();
           con.close();

       } catch(BatchUpdateException b) {
           System.err.println("-----BatchUpdateException-----"+b);
           System.err.print("Update counts:  ");
           int [] updateCounts = b.getUpdateCounts();
           for (int i = 0; i < updateCounts.length; i++) {
               System.err.print(updateCounts[i] + "   ");
           }
           System.err.println("");

       } catch(SQLException ex) {
           System.err.println("-----SQLException-----"+ex);
       }
   }
}
