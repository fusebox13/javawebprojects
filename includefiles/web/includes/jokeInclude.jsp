Joke Rating = <%=jokeList[ (Integer)pageContext.getAttribute("formIndex") ].getRating() %>
<br><br>
<form action="jokes.jsp">
<input type="radio" name="rating" value="1">lame(1)
<input type="radio" name="rating" value="2">average(2)
<input type="radio" name="rating" value="3">good(3)
<input type="radio" name="rating" value="4">excellent(4)
<input type="submit" value="Submit your Rating">
<input type="hidden" name="index" value="<%= pageContext.getAttribute("formIndex") %>" >
</form>