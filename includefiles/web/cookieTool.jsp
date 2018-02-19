<%
    String cookieName=request.getParameter("cookieName");
    String cookieValue=request.getParameter("cookieValue");
    String cookieAge=request.getParameter("cookieAge");
    if (cookieName==null) cookieName="";
    if (cookieValue==null) cookieValue="";
    if (cookieAge==null) cookieAge="";
    
    String action = request.getParameter("action");
    if (action != null && cookieName.length() > 0)
    {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        
        if ("delete".equals(action))
        {
            cookie.setMaxAge(0);
        }
        else
        {
            int age=-1; // expires after browser is closed
            cookieAge = cookieAge.trim();
            if (cookieAge.length() > 0)
            {
                try
                {
                    age = Integer.parseInt(cookieAge);
                }
                catch (RuntimeException e)
                {
                    
                }
                System.out.println("Cookie age="+age);
                cookie.setMaxAge(age);
            }
        }
        response.addCookie(cookie);
    }
    
    Cookie[] cookies = request.getCookies();    
    if (cookies == null)
        cookies = new Cookie[0];
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cookie Tool</title>
    </head>
    <body>
        <h1>Cookie Tool</h1>
        <form action="cookieTool.jsp">
            <input type="text" name="cookieName" value=""/> Cookie Name
            <br><input type="text" name="cookieValue" value="" /> Cookie Value           
            <br><input type="text" name="cookieAge" value="" />  Cookie Age: 
            Age in seconds (0 ==> delete now, less than 0 means it dies when browser dies 
            <br><input type="submit" name="action" value="add" />
            
            <br><input type="submit" name="action" value="delete" />
        </form>
        <hr>
        <table border="4">
            <tr><th>Name</th><th>Value</th><th>Age</th><th>Domain</th><th>Path</th></tr>
        <%
           for (int i=0; i < cookies.length; i++)
           {
               Cookie cookie = cookies[i];
               // Exit Java mode 
               %>
            <tr>
                <td><%= cookie.getName()%></td>
                <td><%= cookie.getValue()%></td>
                <td><%= cookie.getMaxAge()%></td>
                <td><%= cookie.getDomain()%></td>
                <td><%= cookie.getPath()%></td>
            </tr>
               <%// Enter Java mode to finish for loop
           }
        %>
        </table>
    </body>
</html>