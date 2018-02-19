<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="factors.*,java.util.*"  %>

<%
 ArrayList<Factor> factorArr = FactorUtils.update(request); 
 if (factorArr==null)
 {
 %>
       <jsp:forward page="NumberPrompt.jsp?Action=FactorNumber.jsp"/> 
 <%
 }
 %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factor</title>
    </head>
    <body>
        <h1>Factoring the number <%=request.getParameter("number")%></h1>
        <%
             if (factorArr.size() <= 1) 
             { // Exit to Html mode
         %>
            <h3>PRIME</h3>
         <%  // Entering Java mode
             }
             else
             {
                for (int i=0; i < factorArr.size(); i++)
                {
                    out.println(factorArr.get(i));
                }
             } // Exitting to Html Mode
          %>
          <p>
          <a href="NumberPrompt.jsp?Action=FactorNumber.jsp"> Enter another number to factor</a>
    </body>
</html>
