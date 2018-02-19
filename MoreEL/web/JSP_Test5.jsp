<%
   // This could also be done in the front end Servlet of MVC. 
	response.addCookie( new Cookie("myCookie", "1234") );
%>

<html><body>
  <form action=JSP_Test5.jsp>
      <br>Name: <input type="text" name="name">
      <br>ID#: <input type="text" name="empID">
      <br>First Food: <input type="text" name="food">
      <br>Second Food: <input type="text" name="food">
      <br><input type="submit">
  </form>

<hr>
Request param name is ${param.name}
<br>Request param empID is: ${param.empID}
<br> Only prints first food: ${param.food}
<br> Prints first food: ${paramValues.food[0]}
<br> Prints second food: ${paramValues.food[1]}

<br> User-Agent: ${header["User-Agent"]}

<p>Configuration info: ${initParam.mainEmail}
<br> Getting the cookie: ${cookie.myCookie.value}

<hr>
<br> Equivalent code using scriplets:
Request param name is <%= request.getParameter("name") %>
<br>Request param empID is: <%= request.getParameter("empID") %>
<br> Only prints first food: <%= request.getParameter("food") %>

<%
    String[] parmValues = request.getParameterValues("food");
    if (parmValues != null)
    {
        if (parmValues.length > 0)
            out.println("<br> Prints first food:"+ parmValues[0]);
        if (parmValues.length > 1)
            out.println("<br> Prints second food:"+ parmValues[1]);
            
    }
%>


<br> User-Agent: <%= request.getHeader("User-Agent")%>

Configuration info: $<%= application.getInitParameter("mainEmail") %>

<%
Cookie[] cookies = request.getCookies();
for (int i=0; i < cookies.length; i++)
{
    if ((cookies[i].getName()).equals("myCookie"))
    {
       out.println("Cookie value from scriptlet="+ cookies[i].getValue());
    }
}
%>


</body></html>