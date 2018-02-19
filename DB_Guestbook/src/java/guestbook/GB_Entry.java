/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guestbook;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;


public class GB_Entry {
    private String fullName="";
    private String wccStudent="";
    private String gender="";
    private String emailProperties="";
    private String information="";
    
// Java Bean Requirements
    public GB_Entry()
    { // Needed to be a Java Bean
    }
    
    public String getFullName()
    {
        return fullName;
    }
    public String getWccStudent()
    {
        return wccStudent;
    }
    public String getGender()
    {
        return gender;
    }
    public String getEmailProperties()
    {
        return emailProperties;
    }
    public String getInformation()
    {
        return information;
    }


    private static void processQuery(HttpServletRequest request, Statement statement) throws SQLException
    {
        String sql = "select fullName, wccStudent, gender, emailProperties, information from GBook";
        ResultSet rs = statement.executeQuery(sql);
        
        ArrayList<GB_Entry> results = new ArrayList<GB_Entry>();
        while (rs.next())
        {
            GB_Entry gb = new GB_Entry();
            gb.fullName=rs.getString("fullName");
            gb.wccStudent=rs.getString("wccStudent");
            gb.gender=rs.getString("gender");
            gb.emailProperties=rs.getString("emailProperties");
            gb.information=rs.getString("information");
            results.add(gb);
        }
        request.setAttribute("results", results);

        // Until we get all of the EL and JSTL in place, we will simplify things for 
        // the time being:
        StringBuilder sb= new StringBuilder();
        String eol = System.getProperty("line.separator");
        for (int i=0; i < results.size(); i++)
        {
            GB_Entry gb = results.get(i);
            sb.append("firstName=" + gb.fullName);
            sb.append(" wccStudent=" + gb.wccStudent);
            sb.append(" gender=" + gb.gender);
            sb.append(" emailProperties=" + gb.emailProperties);
            sb.append(eol + "information=" + gb.information);
            sb.append(eol + "******************" + eol);
        }
        request.setAttribute("guestBookContents", sb.toString());
    }
    
    public static void update(Connection connection, HttpServletRequest request) 
                                    throws SQLException
    {
        String action = request.getParameter("action");
                                            
        GB_Entry pgb = new GB_Entry();
        Statement statement = connection.createStatement();
        if ("Add Guestbook Entry".equals(action))
        {
            pgb.fullName=getNonNull(request, "fullName");
            pgb.wccStudent = getNonNull(request, "wccStudent");
            pgb.gender = getNonNull(request, "gender");
            pgb.emailProperties = getNonNullValues(request, "emailProperties");           
            pgb.information = getNonNull(request, "information");
            String sql = "insert into GBook values(" +
                    quoteSurround(pgb.fullName) +"," +
                    quoteSurround(pgb.wccStudent) +"," +
                    quoteSurround(pgb.gender) +"," +
                    quoteSurround(pgb.emailProperties) +"," +
                    quoteSurround(pgb.information) +")" ;
            statement.executeUpdate(sql);          
        }
        processQuery(request, statement);
        statement.close();
    }
    public static void setError(SQLException e, HttpServletRequest request)
    {
        request.setAttribute("sqlError", e.toString());
    }

    private static String quoteSurround(String s)
    {
        // Remove any " or ' characters and surround the result with '
        StringBuilder sb= new StringBuilder();
        char quote = '\'';
        sb.append(quote);
        for (int i=0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c == '"' || c == quote)
                sb.append(' ');
            else
                sb.append(c);
        }
        sb.append(quote);
        return sb.toString();
    }

    private static String getNonNull(HttpServletRequest request, String name)
    {
        String s = request.getParameter(name);
        if (s == null) s ="";
        return s;
    }

// Process inputs where there are multiple entries in the form with the same name

    private static String getNonNullValues(HttpServletRequest request, String name)
    {
        String[] arr = request.getParameterValues(name);
        String s ="";
        if (arr != null)
        {
            for (int i=0; i < arr.length; i++)
            {
                s += arr[i];
                if (i < arr.length-1)
                    s += ", ";
            }   
        }
        return s;
    }

}
