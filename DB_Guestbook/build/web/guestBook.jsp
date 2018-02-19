<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import= "guestbook.*" %>


<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
       
        <h1>Add a new entry</h1>
        
        <form action="GuestBookServlet">
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
            <%= request.getAttribute("guestBookContents") %>
        </pre>
    </body>
</html>
