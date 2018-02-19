package myservlets;

import java.io.IOException;
import java_beans.Dog;
import java_beans.Person;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CallingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        request.setAttribute("dogName", "Spike");
        
        Dog d= new Dog("Spike");      
        request.setAttribute("dog",d);
        
        Person p = new Person("Mike", d);
        request.setAttribute("person", p);
        
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher("/JSP_Test.jsp");
        dispatcher.forward(request, response);
    }
   
}