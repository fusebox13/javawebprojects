<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Knock-Knock</title>
    </head>
    <body>
        <h1>Knock Knock!!  - <%=request.getAttribute("kk_type")%> </h1>
        <h3>  <%= request.getAttribute("answer")%> </h3>
        <form action="<%=response.encodeURL("KnockKnockServlet")%>" >
            <input type="submit" name="action" value="Whose There?" />
            <input type="hidden" name="index" value="<%=request.getAttribute("index")%>"  />
        </form>
    </body>
</html>