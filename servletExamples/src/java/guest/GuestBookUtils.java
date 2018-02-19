package guest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class GuestBookUtils {
    String filepath;
    
    public GuestBookUtils(String filepath)
    {
        this.filepath = filepath;
    }
    
// This routine reads in the whole contents of a text file and returns it as a String

    public String getContents() 
    {
        File file = new File(filepath);
        StringBuilder sb = new StringBuilder();
        String eol = System.getProperty("line.separator");
        try
        {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine())
            {
                sb.append(scan.nextLine() + eol);
            }
        }
        catch (FileNotFoundException e)
        {
            sb.append("No Guestbook Entries yet");
            System.out.println("FileNotFound for file: "+ filepath);
        }
        return sb.toString();
    }
    
// This routine Opens a file in append mode and adds the "toAdd" String to the 
//      end of the file.

    public void add(String toAdd) throws IOException
    {
        File file = new File(filepath);
        file.getParentFile().mkdirs();
        PrintWriter out = new PrintWriter(
                new FileWriter(file, true));
        out.println(toAdd);        
        out.close();
    }
    
}