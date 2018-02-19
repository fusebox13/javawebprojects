/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc2;

import java.sql.Connection;
import java.sql.SQLException;
import tools.MyInput;
import tools.MyOutput;

public class SqlCmdLine2 {

    public static void main(String[] args) {
        MyInput myInput;
        MyOutput myOutput;
        Connection connection = MyConnection.getConnection(args);

        if (connection == null) {
            System.out.println("Unable to get a Data base connection ... exitting");
            return;
        }
        if (args.length < 3) {
            myInput = new MyInput(); // Input from keyboard
        } else {
            myInput = new MyInput(args[2]); // Input from a file
        }
        if (args.length < 4) {
            myOutput = new MyOutput(); // Screen Monitor
        } else {
            myOutput = new MyOutput(args[3]); // Output redirected to a file
        }

        String cmd = "";
        boolean continueFlag = true;
        do {
            if (args.length < 3) 
            {
                if (cmd.length() == 0)
                    System.out.println("Enter SQL CMD:");
                else
                    System.out.println("==>");
            }
            String line = myInput.get();
            if (line == null) {
                continueFlag = false;
            } else {
                int index = line.indexOf(';');
                if (index < 0) {
                    cmd += line + " "; // Concatenate if missing ';'
                } else {
                    cmd += line.substring(0, index);

                    if ("quit".equals(cmd)) {
                        continueFlag = false;
                    } else {
                        GenericBean gb = new GenericBean(connection, cmd);
                        GenericBeanResult gbr = gb.getResults();
                        myOutput.println(gbr.toString());
                        myOutput.println("********************************");
                    }
                    cmd = "";
                }
            }
        } while (continueFlag);

        try { // Stupid that I need to do this.
            connection.close();
        } catch (SQLException ex) {  }
    }
}