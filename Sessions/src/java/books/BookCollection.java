package books;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

public class BookCollection {

    private ArrayList<Book> bkArray = new ArrayList<Book>();
    String errorMessage="";

    public int size() {
        return bkArray.size();
    }

    public Book getBook(int index) {
        return bkArray.get(index);
    }
    public String getErrorMessage()
    {
        return errorMessage;
    }

    public static BookCollection update(PageContext pageContext) {
        HttpSession session = pageContext.getSession();
        BookCollection bc = (BookCollection) session.getAttribute("BookCollection");
        if (bc == null) 
        {
            bc = new BookCollection(); // Default Constructor provided from compiler
            session.setAttribute("BookCollection", bc);
        }

        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        String action = request.getParameter("action");
        if (action != null) 
        {
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String isbn = request.getParameter("isbn");
            String edition = request.getParameter("edition");
            Book book = new Book(title, author, isbn, edition);

            if("Clear List".equals(action))
            {
                bc.bkArray.clear();
            }
            if ("add".equals(action)) {
                boolean found = false;
                // Check for uniqueness
                for (int i = 0; i < bc.bkArray.size(); i++) {
                    if (book.equals(bc.bkArray.get(i))) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    bc.bkArray.add(book);
                    bc.errorMessage="";
                }
                else
                    bc.errorMessage="Book already exists";
            }
            if ("remove".equals(action)) {
                for (int i = 0; i < bc.bkArray.size(); i++) {
                    if (book.equals(bc.bkArray.get(i))) {
                        bc.bkArray.remove(i);
                    }
                }
            }
            if("update".equals(action))
            {
                String strIndex = request.getParameter("index");
                int index = Integer.parseInt(strIndex);
                Book bk = bc.bkArray.get(index);
                bk.setTitle(title);
                bk.setAuthor(author);
                bk.setIsbn(isbn);
                bk.setEdition(edition);
            }
        }

        return bc;
    }
}