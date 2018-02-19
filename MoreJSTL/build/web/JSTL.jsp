<%
    String[] people={"Einstein", "Lincoln", "Washington", "Kennedy", "King"};
    request.setAttribute("people", people);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html><body>
   <h2>Words</h2>

   <h3>Using forEach </h3>
   <table border="4">
      <c:forEach var="person" items="${people}" >
         <tr>
             <td>${person}</td>
         </tr>
      </c:forEach>
   </table>

   <hr>

   <h3>Using forEach with a counter </h3>
   <table border="4">
      <c:forEach var="person" items="${people}" varStatus="peopleLoopStatus">
         <tr>
             <td>${person}</td><td>count=${peopleLoopStatus.count}, index=${peopleLoopStatus.index}</td>
             <td>first=${peopleLoopStatus.first}, last=${peopleLoopStatus.last}</td>
         </tr>
      </c:forEach>
   </table>

   <hr>

   <h3>Similar code in a scriplet </h3>
   <table border="4">
      <%
        String[] people2 = (String[]) request.getAttribute("people");
        String person2 = null;
        for (int i=0; i < people2.length; i++)
        {
          person2 = people2[i];
      %>
         <tr>
             <td><%= person2 %></td>
         </tr>
      <% } %>
   </table>





</body></html>