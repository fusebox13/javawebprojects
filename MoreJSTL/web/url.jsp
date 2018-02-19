<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html><body>

<c:set var="sentence" value="She sells sea shells down by the sea shore"/>
<c:set var="bad_chars" value="; & < > =" />

The following will encode our URL
<c:url var="inputUrl" value="/inputComments.jsp">
    <c:param name="sentence" value="${sentence}" />
    <c:param name="bad_chars" value="${bad_chars}"/>
</c:url> 


// Note the difference in the outputs below. 
<c:url var="inputUrl2" value="http://russet.wccnet.edu/inputComments.jsp">
    <c:param name="sentence" value="${sentence}" />
    <c:param name="bad_chars" value="${bad_chars}"/>
</c:url> 


<hr>
    Let's take a look at our URL
    <br>inputUrl = ${inputUrl}
    <br>inputUrl2 = ${inputUrl2}
    <p><a href="${inputUrl2}">inputComments</a>


</body></html>