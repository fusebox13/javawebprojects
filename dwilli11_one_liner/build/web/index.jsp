<%@page import= "oneliner.*, java.util.*" %>
<%!
    onelinerUtils utils;
    
    public void jspInit()
    {
        String fullPathName = onelinerUtils.init(getServletConfig(), getServletContext());
        utils = new onelinerUtils(fullPathName);
    }
    

%>

<%
    pageContext.setAttribute("ELScope", "Page Context");
    request.setAttribute("ELScope", "Request");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height:100%">
    <head>
        <link rel="stylesheet" type="text/css" href="animate-custom.css">
        <title>Oneliners! ${ELScope}</title>            
    </head>
    <body style="background-color:black;height:100%">
        
        <div style="height:100%">
            <div style="height:50%">
                <center><h2 class="animated fadeInUp" style="color:white;font-size:100px;font-family:Calibri"> <%= utils.getNextOneLiner() %> </h2></center>
            </div>
            <div style="height:50%">
                <form action="oneliner">
                <br/><center><input type="submit" class="animated fadeInDown" name="action" value="Next" style="height:100px;width:400px;font-size:50px;font-family:Calibri;background:black;color:white" /></center>
                </form>
            </div>
        </div>
    </body>
</html>

