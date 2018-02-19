<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import= "guest.*" %>
<%!
    String fullFilePath="";
    
// Overriding the jspInit routine in the JSP Servlet class
// Note that this code is mostly just a copy of the init() code in the Servlet version
  public void jspInit()
  {    
        ServletConfig sc = getServletConfig();
        ServletContext sctx = getServletContext();
        String guestFile = sc.getInitParameter("guestFile");
        String guestPath = sc.getInitParameter("guestPath");
        
        System.out.println("guestFile="+ guestFile);
        System.out.println("guestPath="+guestPath);
        
        if (guestPath == null)
            guestPath="";
        else
            guestPath = guestPath.trim();
        
        if (guestFile == null)
            guestFile="GuestFileDefaultName.txt";
        
        if ( guestPath.length() == 0)
            fullFilePath = sctx.getRealPath("/WEB-INF/"+guestFile);
        else
        {
            //fullFilePath = System.getProperty("user.home")+"/" + guestPath + "/" + guestFile;
            String pathSeparator = System.getProperty("file.separator");
            fullFilePath = System.getProperty("user.home")+ pathSeparator + guestPath + pathSeparator + guestFile;
        }
        System.out.println("From JSP: fullFilePath="+ fullFilePath);
  }
%>
<%
        // Lifted from the top of the Guestbook Servlet

        GuestUserInput guser = new GuestUserInput();
        GuestBookUtils gbook = new GuestBookUtils(fullFilePath);

        if (guser.updateFromRequest(request))
        {
            gbook.add(guser.toString());
        }
%>
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
       
        <h1>Add a new entry</h1>
        
        <form action="gbook2">
        Full Name: <input type="text" name="fullName" size="60" />
            
        <p>Are  you a WCC Student: <input type="checkbox" name="wccStudent" value="yes" />
            
        <p>Gender: <input type="radio" name="gender" value="male" />male  
        <input type="radio"  name="gender" value="female" />female 
        <input type="radio" name="gender"  value="unspecified" />Unspecified
        <p>Check any of the properties that apply:
        <br/><input type="checkbox" name="emailProperties" value="businessEmail" checked /> Add me to your Business Email List 
        <br/><input type="checkbox" name="emailProperties" value="spamEmail" checked /> Add me to your Spam Email List
        <br/><input type="checkbox" name="emailProperties" value="gamesEmail" checked /> Add me to your advertising Email List
        <br/><input type="checkbox" name="emailProperties" value="spywareEmail" checked /> Add me to your spyware Email List 
            
        <p>Replace the dots with your Guestbook comment:
        <br/><textarea name="information" rows="5" cols="65">......</textarea>
            
        <br/><input type="submit" name="action" value="Add Guestbook Entry" />
            
        </form>
    
        <hr>  
        <pre>
            <%= gbook.getContents() %>
        </pre>
    </body>
</html>