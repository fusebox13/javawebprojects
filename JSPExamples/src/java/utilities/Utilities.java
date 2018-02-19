package utilities;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Note that the following is not Thread-Safe

public class Utilities {
    public static void add(String name, String path) throws IOException
    {
        FileWriter fr = new FileWriter(path, true);  // Open in append mode
        PrintWriter out = new PrintWriter(fr);
        out.println(name);
        out.close();  
    }
    
}