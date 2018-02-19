<html><body>
       <h2> Expression Language example review</h2>
       <h3>dogName=${dogName}</h3>
       <h3>dog.name=${dog.name}</h3>
       <h3>person.dog.name=${person.dog.name}</h3>
<hr>
       JSP Version of the above:
      
       <h3>dogName=<%=request.getAttribute("dogName") %></h3>
       <h3>dog.name=<%=((java_beans.Dog)request.getAttribute("dog")).getName() %></h3>
       <h3>person.dog.name=<%=((java_beans.Person)request.getAttribute("person")).getDog().getName() %></h3>

</body></html>