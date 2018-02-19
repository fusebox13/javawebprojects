<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="books.*"  %>
<%
    BookCollection bookCollection = BookCollection.update(pageContext);
 %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Collection</title>
    </head>
    <body>
        <h1>Book Collection</h1>
        
        <form action="bookCollection.jsp">
            <input type="submit" name ="action" value="Clear List">
        </form>
        <p>
        
        <form action="bookCollection.jsp">
            <input type="text" name="title" /> Title
            <br><input type="text" name="author" /> Author
            <br><input type="text" name="isbn" /> ISBN
            
            <br><input type="text" name="edition" /> Edition
            <br><input type="submit" name="action" value="add" />
        </form>
        <hr>
        <h3><%=bookCollection.getErrorMessage()%></h3>
        
        <table border="3">
            <tr><th>Title</th><th>Author</th><th>Isbn</th><th>Edition</th><th></th></tr>
        <%
            for (int i=0; i <  bookCollection.size(); i++)
            {
                Book book = bookCollection.getBook(i);
         %>
            <tr>
            <form action="bookCollection.jsp">
                <td><input type="text" read name="title" value="<%=book.getTitle()%>" /></td>
                <td><input type="text" read name="author" value="<%=book.getAuthor()%>" /></td>
                <td><input type="text" read name="isbn" value="<%=book.getIsbn()%>" /></td>
                <td><input type="text" read name="edition" value="<%=book.getEdition()%>" /></td>
                <td><input type="submit" name="action" value="remove" /></td>
                <td><input type="submit" name="action" value="update" />
                    <input type="hidden" name ="index" value="<%=i%>"
                </td>
            </form>
            </tr>
         <%
            }
          %>
        </table>
    </body>
</html>
