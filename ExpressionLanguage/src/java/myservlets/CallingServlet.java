package myservlets;

import java.io.IOException;
import java_beans.City;
import java_beans.Mayor;
import java_beans.State;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CallingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // forward request and response objects to JSP page
    
        HttpSession session = request.getSession(true);

        Mayor bob = new Mayor();
        bob.setAge(48);
        bob.setName("Bob");
        session.setAttribute("bob", bob);


        State michigan = buildState();
        session.setAttribute("title","Information about Michigan");
        session.setAttribute("state", michigan);

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher("/JSP_Test.jsp");
        dispatcher.forward(request, response);
    }
    private State buildState()
    {
        Mayor mLansing = new Mayor();
        mLansing.setName("John Doe");
        mLansing.setAge(53);
        
        Mayor mDetroit = new Mayor();
        mDetroit.setName("Fred Smith");
        mDetroit.setAge(58);
        
        City detroit = new City();
        detroit.setPopulation(900000);
        detroit.setName("Detroit");
        detroit.setMayor(mDetroit);
        
        City lansing = new City();
        lansing.setPopulation(80000);
        lansing.setName("Lansing");
        lansing.setMayor(mLansing);
        
        State michigan = new State();
        michigan.setPopulation(9100000);
        michigan.setName("Michigan");
        michigan.setCapital(lansing);
        michigan.setLargestCity(detroit);
        
        return michigan;
    }
}