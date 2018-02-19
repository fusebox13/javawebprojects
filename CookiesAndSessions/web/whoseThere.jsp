<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Whose There?</title>
    </head>
    <body>
        <h1>Whose There?  - <%=request.getAttribute("kk_type")%></h1>
        <form action="<%=response.encodeURL("KnockKnockServlet")%>">
            <input type="submit" name="action" value="<%=request.getAttribute("clue") + " Who?"%> " />
            <input type="hidden" name="index" value="<%=request.getAttribute("index")%>"  />
        </form>
    </body>
</html>