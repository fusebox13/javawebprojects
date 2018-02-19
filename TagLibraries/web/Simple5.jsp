<%@page import="java.util.ArrayList,tlds.Movie  " %>
<%
    ArrayList<Movie> list = new ArrayList<Movie>();
    list.add(new Movie("Star Wars", "Science Fiction"));
    list.add(new Movie("Sleepless in Seatle", "Romance"));
    list.add(new Movie("What about Bob", "comedy"));

    request.setAttribute("movieCollection", list);
%>

<%@ taglib prefix="myTags" uri="http://wccnet.edu/chasselb/simpleTags" %>

<html><body>

Simple Tag 5:
<table border="4">
    <myTags:simple5 movieList="${movieCollection}">
        <tr>
            <td>${movie.name}</td>
            <td>${movie.genre}</td>
        </tr>
    </myTags:simple5>
</table>

</body></html>