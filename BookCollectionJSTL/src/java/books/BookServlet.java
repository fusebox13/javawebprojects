package books;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class BookServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Book> bookCollection ;
        HttpSession session = request.getSession();
        bookCollection = (ArrayList<Book>) session.getAttribute("BookCollection");
        if (bookCollection == null) 
        {
            bookCollection = new ArrayList<>();
            session.setAttribute("BookCollection", bookCollection);
        }
        String errorMessage = BookCollection.update(bookCollection, request);
        request.setAttribute("errorMessage",errorMessage);
             
        RequestDispatcher dispatcher =
             getServletContext().getRequestDispatcher("/bookCollection.jsp");
        dispatcher.forward(request, response);  
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}