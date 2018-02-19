<html> 
<body> 
    <h1>Prime Factors</h1> 
    <h3><%=  (request.getAttribute("message")==null?"":request.getAttribute("message")) %></h3>
        <form action="<%= request.getParameter("Action") %>"> 
            Number to be factored: 
            <input type="text" name="number" size="8"> 
            <br><input type="submit" value="Factor Number"> 
        </form> 
</body> 
</html> 