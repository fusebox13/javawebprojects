package books;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class BookCollection {

    public static String update(ArrayList<Book> bookCollection, HttpServletRequest request) {

        String errorMessage = "";

        String action = request.getParameter("action");
        if (action == null) {
            return "";
        }

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");
        String edition = request.getParameter("edition");
        Book book = new Book(title, author, isbn, edition);

        String strIndex;
        int index;

        switch (action) {
            case "Clear List":
                bookCollection.clear();
                break;

            case "add":
                if (bookCollection.indexOf(book) < 0) {
                    bookCollection.add(book);
                } else {
                    errorMessage = "Book already exists";
                }
                break;

            case "remove":
                strIndex = request.getParameter("index");
                index = Integer.parseInt(strIndex);
                bookCollection.remove(index);
                break;

            case "update":
                strIndex = request.getParameter("index");
                index = Integer.parseInt(strIndex);
                Book bk = bookCollection.get(index);
                bk.setTitle(title);
                bk.setAuthor(author);
                bk.setEdition(edition);
                bk.setIsbn(isbn);
                break;
        }
        return errorMessage;
    }
}
