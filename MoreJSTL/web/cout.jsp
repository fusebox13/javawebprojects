<%
    request.setAttribute("tip", "<b> </b> is for making things <b>bold</b>");
    request.setAttribute("user1", "Clem Hasselbach"); 
%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html><body>
   The tip is - ${tip}
   <br> Using cout default approach -<c:out value='${tip}' />
   <br>Using cout with escapeXml='false' (note default is true) -<c:out value='${tip}' escapeXml='false' />
   <br> user1 is there - <c:out value='${user1}' default='Guest' />
   <br> user2 is NOT there - <c:out value='${user2}' default='Guest' />

</body></html>