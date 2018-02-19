package myservlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java_beans.Quote;

public class CallingServlet3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext sc = getServletContext();
        
        Quote q1 = new Quote("Abraham Lincoln" ,
                "Nearly all men can stand adversity, but if you want to test a man's character, give him power.");
        
        Quote q2 = new Quote("Abraham Lincoln" ,
                "Better to remain silent and be thought a fool than to speak out and remove all doubt.");
        
        Quote q3 = new Quote("Abraham Lincoln" ,
                "In the end, it's not the years in your life that count. It's the life in your years.");
         
        Quote q4 = new Quote("Abraham Lincoln" ,
                "Most folks are as happy as they make up their minds to be.");
        
        Quote q5= new Quote("Albert Einstein",
                "Only two things are infinite, the universe and human stupidity, and I'm not sure about the former.");
        
        Quote q6= new Quote("Albert Einstein",
                "When you are courting a nice girl an hour seems like a second. When you sit on a red-hot cinder a second seems like an hour. That's relativity.");
        
        Quote q7= new Quote("Albert Einstein",
                "Great spirits have always encountered violent opposition from mediocre minds.");
        
        java.util.Map<String, Quote> quotes = new java.util.HashMap<String, Quote>();
        quotes.put("abe1", q1);
        quotes.put("abe2", q2);
        quotes.put("abe3", q3);
        quotes.put("abe4", q4);
        
        quotes.put("albert1", q5);
        quotes.put("albert2", q6);
        quotes.put("albert3", q7);
        
        sc.setAttribute("quotes", quotes);
        
        // For our second JSP_Test.jsp we will be using the following:
        quotes.put("7", q7);
        request.setAttribute("best", "albert3");

 
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher("/JSP_Test4.jsp");
        dispatcher.forward(request, response);
    }
   
}