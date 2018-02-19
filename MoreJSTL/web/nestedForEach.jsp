<%
    String[] people={"Einstein", "Lincoln", "Washington", "Kennedy", "King"};
    request.setAttribute("people", people);

    String[] states={"Michigan", "Ohio", "Indiana", "Wisconsin", "Pennsylvania"};
    String[] cities={"Lansing", "Detroit", "Ann Arbor", "Columbus", "Chicago"};
    java.util.ArrayList<String[]> categories = new java.util.ArrayList<String[]>();
    categories.add(people);
    categories.add(states);
    categories.add(cities);
    request.setAttribute("categories", categories);
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html><body>
   <h2>Category Lists</h2>

   <h3>Using forEach </h3>
   <table border="4">
      <c:forEach var="categoryElement" items="${categories}" >
         <tr>
         <c:forEach var="word" items="${categoryElement}" >
                 <td>${word}</td>
         </c:forEach>
        </tr>
      </c:forEach>
    </table>

   <hr>
<h2>Equivalent Scriplet version</h2>
   <table border="4">
   <%
    java.util.ArrayList<String[]> categories2 = 
            (java.util.ArrayList<String[]>)request.getAttribute("categories");
    for (int element=0; element < categories2.size(); element++)
    {
        out.println("<tr>");
        String[] category2 = categories2.get(element);
        for (int i=0; i < category2.length; i++)
        {
            out.println("<td>"+category2[i] + "</td>");
        }
        out.println("</tr>");
    }
    
    %>
    </table>
  </body></html>