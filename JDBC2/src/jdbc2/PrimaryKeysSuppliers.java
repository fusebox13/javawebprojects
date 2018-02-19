
package jdbc2;
import java.sql.*; 
     
public class PrimaryKeysSuppliers  {

   public static void main(String args[]) {
       Connection con=MyConnection.getConnection(args);
       String createString = "create table SUPPLIERSPK " +
                               "(SUP_ID INTEGER NOT NULL, " +
                               "SUP_NAME VARCHAR(40), " +
                               "STREET VARCHAR(40), " +
                               "CITY VARCHAR(20), " +
                               "STATE CHAR(2), " +
                               "ZIP CHAR(5), " +
                               "primary key(SUP_ID))";
       Statement stmt;

       if (con == null)
       {
           System.out.println("Unable to create connection");
           return;
       }
   
       try {           
           stmt  = con.createStatement();
           stmt.executeUpdate(createString);
   
           DatabaseMetaData dbmd = con.getMetaData();
   
           ResultSet rs = dbmd.getPrimaryKeys(null, null, "SUPPLIERSPK");
           while (rs.next()) {
               String name = rs.getString("TABLE_NAME");
               String columnName = rs.getString("COLUMN_NAME");
               String keySeq = rs.getString("KEY_SEQ");
               String pkName = rs.getString("PK_NAME");
               System.out.println("table name :  " + name);
               System.out.println("column name:  " + columnName);
           }
       
           rs.close();
           con.close();
   
       } catch(SQLException ex) {
           System.err.print("SQLException: ");
           System.err.println(ex.getMessage());
       }
   }
}