package beans;

import java.io.*;
import java.util.*;

public class Cart {

    private ArrayList<String> list = new ArrayList<String>();
    private String selectedChoice = "";

    public void setChoice(String choice) {
        if (choice != null) {
            selectedChoice = choice;
        }
    }

    public void setCmd(String cmd) {
        if (cmd == null) {
            return;
        }

        if (cmd.equals("Remove")) {
            list.remove(selectedChoice);
        }
        if (cmd.equals("Add")) {
            list.add(selectedChoice);
        }
    }

    public ArrayList<String> getList()
    {
        return list;
    }

    public String getTableData() {
        String eol = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append("<tr><td>" + list.get(i) + "</td></tr>" + eol);
            
        }


        return sb.toString();
    }
}
