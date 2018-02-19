<%    
    request.setAttribute("userPref", "default");
%> 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html><body>
//The following is equivalent to 
//pageContext.setAttribute("user1", "cowboy");

    <c:set var="user1" value="cowboy"/>

    <c:set var="userx" value="to_delete"/>

<p>
    You can also have the value come in through the body of a tag instead of the value attribute
    Note that the default level is page, but you can also use session, request, and application
    <c:set var="user2" scope="session">
        Sheriff, Bartender, Cowgirl
    </c:set>


<p>
   The body can also include a previously defined variable
    <c:set var="user3">
        ${userPref}
    </c:set>

   The body can also include a previously defined variable
    <c:set var="user4" value="${userPref}" />


<p>
   To remove a variable
    <c:remove var="userx"/>

<hr>
    Let's take a look at the results of our variables
    <br>userPref = ${userPref}
    <br>user1 = ${user1}
    <br>user2 = ${user2}
    <br>user3 = ${user3}
    <br>user4 = ${user4}
    <br>userx = ${userx}



</body></html>