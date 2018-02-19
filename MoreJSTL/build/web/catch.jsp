<%@ page errorPage="errorPage.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html><body>

About to be bad ....

<c:catch>
     <br>Inside the catch ...  
     <% int x = 10/0; %>
     We will never get here
</c:catch>

<br>If we get here, we survived

<hr>
We might want to look at the exception coming from this problem:



<c:catch var="myException" >
     <br>Inside the catch ...  
     <% int x2 = 10/0; %>
     We will never get here
</c:catch>

<br>If we get here, we survived
<c:if test="${myException != null}" >
    <br>There was an exception: ${myException}
</c:if>

<br> Note that following doesn't work because this page is not an error page:
<br> Exception = ${pageContext.exception}

</body></html>