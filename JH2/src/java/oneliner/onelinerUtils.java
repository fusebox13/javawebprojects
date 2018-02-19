
package oneliner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
    
    
}
