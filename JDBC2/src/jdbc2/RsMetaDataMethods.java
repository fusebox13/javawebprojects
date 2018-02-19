
package jdbc2;

import java.sql.*;
     
public class RsMetaDataMethods {

   public static void main(String args[]) {
       Connection con=MyConnection.getConnection(args);

       Statement stmt;
              
       if (con == null)
       {
           System.out.println("Unable to create connection");
           return;
       }

       try {
           stmt = con.createStatement();                           
   
           ResultSet rs = stmt.executeQuery("select * from COFFEES");
           ResultSetMetaData rsmd = rs.getMetaData();
   
           int numberOfColumns = rsmd.getColumnCount();

           // Note that column index starts at 1 and not 0

           for (int i = 1; i <= numberOfColumns; i++) {
               String colName = rsmd.getColumnName(i);
               String tableName = rsmd.getTableName(i);
               String name = rsmd.getColumnTypeName(i);
               boolean caseSen = rsmd.isCaseSensitive(i);
               boolean writable = rsmd.isWritable(i);
               System.out.println("Information for column " + colName);
               System.out.println("    Column is in table " + tableName);
               System.out.println("    DBMS name for type is " + name);
               System.out.println("    Is case sensitive:  " + caseSen);
               System.out.println("    Is possibly writable:  " + writable);
               System.out.println("");
           }
   
           while (rs.next()) {

            // Note that column index starts at 1 and not 0

               for (int i = 1; i<=numberOfColumns; i++) {
                   String s = rs.getString(i);
                   System.out.print(s + "  ");
               }
               System.out.println("");
           }
   
           stmt.close();
           con.close();
       
       } catch(SQLException ex) {
           System.err.println("SQLException: " + ex.getMessage());
       }
   }
}