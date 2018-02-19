<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String userPref = request.getParameter("userPref");
    if (userPref != null)
            pageContext.setAttribute("userPref", userPref);
%>
<!-- The following does the same thing as the above scriplet -->
<c:set var="userPref" value="${param.userPref}"/>

<html><body>
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


<h3>The Brakes</h3>
Our advanced anti-lock brake system (ABS)
<br>is engineered to give you the ability to steer
<br>even as you're stopping.  We have the best
<br>speed sensors of any car this size.

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


<hr>

    <form action="ifthen.jsp">
        <br><input type="radio" name="userPref" value="performance">Performance
        <br><input type="radio" name="userPref" value="safety">Safety
        <br><input type="radio" name="userPref" value="maintenance">Maintenance
        <br><input type="submit"  value="Submit">
    </form> 

</body></html>
