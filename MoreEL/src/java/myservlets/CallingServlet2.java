package myservlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CallingServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext sc = getServletContext();
        String[] colors={"red", "pink", "purple", "magenta", "yellow", "black", "white", "green", 
            "neon", "brown", "orange", "mello_yellow"};
        
        ArrayList<String> colorsList= new ArrayList<String>();
        for (int i=0; i < colors.length; i++)
            colorsList.add(colors[i]);
        
        sc.setAttribute("colorsList", colorsList);
        
        sc.setAttribute("colors", colors);
        sc.setAttribute("background", 4);
        
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher("/JSP_Test2.jsp");
        dispatcher.forward(request, response);
    }
   
}