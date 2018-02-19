package jdbc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.StringTokenizer;
import tools.MyInput;

class Prepared {
    
    public static void main(String[] args) {
        
        System.out.println(args[0] + args[1]);
        MyInput in = new MyInput("coffee_data.sql");
        Connection con;
        PreparedStatement prepStmt;
        try {
            con = MyConnection.getConnection(args);
            prepStmt = con.prepareStatement(
                    "Insert into COFFEES values(?,?,?,?,?)");
            String line = in.get();

            while (line != null) {
                StringTokenizer parse = new StringTokenizer(line, " ,\n");
                int colCount = 1;
                while (parse.hasMoreTokens()) {
                    prepStmt.setString(colCount++, parse.nextToken());
                    // There are other methods like setInt, etc.
                }
                prepStmt.executeUpdate();
                line = in.get();
            }

            prepStmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("--- SQLException caught:" + e);
        }

    }
}