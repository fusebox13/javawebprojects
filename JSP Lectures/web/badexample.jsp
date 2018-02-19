<%@page import= "java.util.Calendar" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bad Example</title>
    </head>
    <body>
        <h1>Bad Example</h1>
        <% Calendar now = Calendar.getInstance();

// This example is actually a very bad example of how not to use JSP.
// The example works, but you normally don't want to bounce back and
// forth between Html mode and Java mode


          int hour =
          now.get(Calendar.HOUR_OF_DAY);
          if (hour < 12){ 
%> 
          <H3>Good Morning</H3> 
<% 
          } 
          else if (hour < 18) { 
%> 
          <H3>Good Afternoon</H3>
<% 
          } 
          else { 
%> 
          <H3>Good Evening </H3> 
<% 
          } 
%> 

<hr>
<h1>Alternative to the above </h1>
<%   Calendar now2 = Calendar.getInstance();
// Here is an alternative
     int hour2 =
     now2.get(Calendar.HOUR_OF_DAY);
     if (hour < 12) 
        out.println("<H3>Good Morning</H3>");   
     else if (hour < 18)
        out.println("<H3>Good Afternoon</H3>");
     else  
        out.println("<H3>Good Evening </H3>"); 
%> 
    
    </body>
</html>