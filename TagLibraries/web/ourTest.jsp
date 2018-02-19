<%
    String[] movieList = {"Amelie", "Return of the King", "Mean Girls"};
    request.setAttribute("movieList", movieList);

    String userPref = request.getParameter("userPref");
    if (userPref != null)
            request.setAttribute("userPref", userPref);


%>
<%@ taglib uri="http://wccnet.edu/clem/our_uri" prefix="c" %>

<html><body>
   <h2>Movie List</h2>

   <h3>Using forEach </h3>
   <table border="4">
      <c:forEach var="movie" items="${movieList}" >
         <tr>
             <td>${movie}</td>
         </tr>
      </c:forEach>
   </table>

   <hr>

   
<h3>Using the "if" statment</h3>
    <c:if test="${userPref  == 'performance'}">
        Now you can stop even if you <em> drive insanely fast</em>
    </c:if>
    <c:if test="${userPref eq 'safety'}">
        Our brakes won't lock up no matter how bad a driver you are.
    </c:if>
    <c:if test="${userPref=='maintenance'}">
        Lost your tech job? No problem--you won't have to service these brakes 
        <br>for at least three years.
    </c:if>
<hr>

<h3>Using the "choose"/"when" statment</h3>
<c:choose>
    <c:when test="${userPref  eq 'performance'}">
        Now you can stop even if you <em> drive insanely fast</em>
    </c:when>
    <c:when test="${userPref eq 'safety'}">
        Our brakes won't lock up no matter how bad a driver you are.
    </c:when>
    <c:when test="${userPref=='maintenance'}">
        Lost your tech job? No problem--you won't have to service these brakes 
        <br>for at least three years.
    </c:when>

    <c:otherwise>
        Our brakes are the best.
    </c:otherwise>

</c:choose>



<h3>The Brakes</h3>
Our advanced anti-lock brake system (ABS)
<br>is engineered to give you the ability to steer
<br>even as you're stopping.  We have the best
<br>speed sensors of any car this size.

   
<form action="ourTest.jsp">
        <br><input type="radio" name="userPref" value="performance">Performance
        <br><input type="radio" name="userPref" value="safety">Safety
        <br><input type="radio" name="userPref" value="maintenance">Maintenance
        <br><input type="submit"  value="Submit">
    </form> 





</body></html>