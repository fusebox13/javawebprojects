<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import= "guestbook.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
           <!-- <%= request.getAttribute("guestBookContents") %>-->
           ${guestBookContents}
        </pre>
        <hr>
        <h2>Using JSTL</h2>
        <table border="4">             
          <tr><th>fullName</th><th>wccStudent</th><th>gender</th>
                  <th>emailProperties</th><th>information</th></tr>
          <c:forEach var="gbe" items="${results}" >
             <tr>
               <td>${gbe.fullName}</td>
               <td>${gbe.wccStudent}</td>
               <td>${gbe.gender}</td>
               <td>${gbe.emailProperties}</td>  
               <td>${gbe.information}</td>
             </tr>
          </c:forEach>
        </table>
        
    </body>
</html