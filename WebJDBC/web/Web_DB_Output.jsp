<%@page import="JDBC.WebBeanResult"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web DB Output</title>
    </head>
    <body>
        <h1>Web Database Output</h1>
        <%
            WebBeanResult webBeanResult = (WebBeanResult)request.getAttribute("webBeanResult");
            out.println(webBeanResult.toHtml());
         %>
    </body>
</html>