<%@page import="java.util.*"  %>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Headers</title>
    </head>
    <body>
        <h1>Http Headers</h1>
        <table border="3">
            <tr><th>Header Name</th><th>Header Value</th></tr>
        <%
            Enumeration<String> enumeration = request.getHeaderNames(); 
            while (enumeration.hasMoreElements())
            {
                String name=enumeration.nextElement();
                Enumeration<String> valuesEnumeration = request.getHeaders(name);
                while (valuesEnumeration.hasMoreElements())
                {
                    String headerValue = valuesEnumeration.nextElement();
         %>
            <tr>
                <td><%=name %></td>
                <td><%=headerValue %></td>
            </tr>
         <%
                } // end of the inner while loop
            } // end of the outer while loop
         %>
        </table>
    </body>
</html>