<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><body>
<h1>${title}</h1>

<table border="4">
      <c:forEach var="state" items="${states}" >
         <tr>
             <td>${state.name}</td><td>${state.population}</td>
         </tr>
      </c:forEach>
   </table>
   
   
<hr>
<h1>Another loop using "varStatus"</h1>
<table border="4">
      <c:forEach var="state" items="${states}" varStatus="loopStatus">
         <tr>
             <td>${state.name}</td><td>${state.population}</td>
             <td>index=${loopStatus.index} count=${loopStatus.count} </td>
             <td>first=${loopStatus.first} last=${loopStatus.last} </td>
         </tr>
      </c:forEach>
   </table>
   
</body></html>