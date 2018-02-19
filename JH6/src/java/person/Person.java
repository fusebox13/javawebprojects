package person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Person 
{
    private String firstName="";
    private String middleName="";
    private String lastName="";
    private String eyeColor="";
    private String hairColor="";
    private String weight="";
    private String height="";
    private int index;
    
    Person(String firstName, String middleName, String lastName, 
            String eyeColor, String hairColor, String weight, String height, int index )
    {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.weight = weight;
        this.height = height;
        this.index = index;
    }
    
    Person(String firstName, String middleName, String lastName, 
            String eyeColor, String hairColor, String weight, String height)
    {
        this(firstName, middleName, lastName, eyeColor, hairColor, weight, height, -1);
    }
    
    public String validate()
    {
        String errorMessage = "";
        if (firstName.trim().length() == 0)
            errorMessage += "[First Name] ";
        if (middleName.trim().length() == 0)
            errorMessage += "[Middle Name] ";
        if (lastName.trim().length() == 0)
            errorMessage += "[Last Name] ";
        if (weight.trim().length() == 0)
            errorMessage += "[Weight] ";
        if (height.trim().length() == 0)
            errorMessage += "[Height] ";
        return errorMessage;
        
    }
    
    
    public int getIndex()
    {
        return index;
    }
    
    public void setIndex(int index)
    {
        this.index = index;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }
    public void setEyeColor(String eyeColor)
    {
        this.eyeColor = eyeColor;
    }
    
    public void setHairColor(String hairColor)
    {
        this.hairColor = hairColor;
    }
    
    public void setWeight(String weight)
    {
        this.weight = weight;
    }
    
    public void setHeight(String height)
    {
        this.height = height;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public String getMiddleName()
    {
        return middleName;
    }
                
    public String getEyeColor()
    {
        return eyeColor;
    }
    
    public String getHairColor()
    {
        return hairColor;
    }
    
    public String getWeight()
    {
        return weight;
    }
    
    public String getHeight()
    {
        return height;
    }
    
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;
        
        Person otherPerson = (Person)o;
        
        if(eyeColor.equals(otherPerson.eyeColor) 
                && hairColor.equals(otherPerson.hairColor)
                && weight.equals(otherPerson.weight) 
                && height.equals(otherPerson.height)
                && firstName.equals(otherPerson.firstName) 
                && lastName.equals(otherPerson.lastName)
                && middleName.equals(otherPerson.middleName))
            return true;
        else
            return false;
    }
    
     private String addQuotes(String s) {
        return "\'" + s + "\'";
    }
    
    public String update(int index, Statement statement)
    {
        String sql = "update People set firstName=" + addQuotes(firstName) +
                ", middleName=" + addQuotes(middleName) + ", lastName=" +
                addQuotes(lastName) + ", eyeColor=" + addQuotes(eyeColor) +
                ", hairColor=" + addQuotes(hairColor) + ", weight=" + addQuotes(weight)
                + ", height=" + addQuotes(height) + " where id=" + index;
        return executeUpdate(sql, statement);
    }
    
    public String insert(Statement statement)
    {
        String errorMessage = validate();
        String sql = "select firstName from People where firstName=" + addQuotes(firstName)
                + " AND middleName =" + addQuotes(middleName) + " AND lastName=" +
                addQuotes(lastName) + " AND eyeColor=" + addQuotes(eyeColor) +
                " AND hairColor=" + addQuotes(hairColor) + " AND weight=" + addQuotes(weight)
                + " AND height=" + addQuotes(height);
        
        try
        {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next())
                return "Person already exists";
        }
        catch (SQLException e)
        {
            return e.toString();
        }
        
        if (errorMessage == "")
        {
            sql = "insert into People values(" + addQuotes(firstName) + ","
                + addQuotes(middleName) + "," + addQuotes(lastName) + ","
                + addQuotes(eyeColor) + "," + addQuotes(hairColor) + ","
                + addQuotes(weight) + "," + addQuotes(height) + ", null)";
            
            return executeUpdate(sql, statement);
        }
        else
            return errorMessage;
    }
    
    public static String remove(int index, Statement statement) {
        String sql = "delete from People ";
        if (index >= 0)
            sql += " where id=" + index;
        return executeUpdate(sql, statement);
    }
    
    private static String executeUpdate(String sql, Statement statement) {
        String error = "";
        try {
            System.out.println("sql=" + sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            error = e.toString();
        }
        return error;
    }
    
     public static String getBooks(Statement statement, ArrayList<Person> people) {
        String error = "";
        try {
            String sql = "select * from People";
            System.out.println("sql="+sql);
            ResultSet rs = statement.executeQuery(sql);
            people.clear();
            while (rs.next()) {
                String f = rs.getString("firstName");
                String m = rs.getString("middleName");
                String l = rs.getString("lastName");
                String e = rs.getString("eyeColor");
                String h = rs.getString("hairColor");
                String wt = rs.getString("weight");
                String ht = rs.getString("height");
                
                int ind = rs.getInt("id");
                Person person = new Person(f, m, l, e, h, wt, ht, ind);
                people.add(person);
            }
        } catch (SQLException ex) {
            error = ex.toString();
        }
        return error;
    }
}