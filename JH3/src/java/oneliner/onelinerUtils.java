package oneliner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class onelinerUtils {
    
    String fullPathName = "";
    ArrayList<String> arr;
    
    public onelinerUtils(String p)
    {
        this.fullPathName = p;
    }
    
    protected void getOneLiners()
    {
        File f = new File(fullPathName);
        arr = new ArrayList();
        try
        {
            Scanner fileScanner = new Scanner(f);
            while (fileScanner.hasNextLine())
            {
                arr.add(fileScanner.nextLine());
            }
            fileScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("FileNotFound for file: "+ fullPathName);
        } 
        
    }
    
    public String getNextOneLiner()
    {
        getOneLiners();
        String oneLiner = arr.get(new Random().nextInt(arr.size()));
        System.out.println(oneLiner);
        return oneLiner;
      
    }
    
    public static String init(ServletConfig sc, ServletContext sctx)
    {
        String fileName;
        String path;
        String fullFilePath;
        String pathSeparator = System.getProperty("file.separator");
        
        fileName = sc.getInitParameter("fileName");
        path = sc.getInitParameter("path");
        
        
        if (path == null)
            path="onelinerServlet";
        else
            path = path.trim();
        
        if (fileName == null)
            fileName="oneliners.txt";
        
      
        fullFilePath = sctx.getRealPath("/WEB-INF/"+ pathSeparator + fileName);
       
        return fullFilePath;
        
    }
    
    
}