package knockKnock;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KnockKnockServlet extends HttpServlet {

    String clues[] = { "Turnip", "Little Old Lady", 
                      "Atch", "Who", "Who" };
    String answers[] ={ 
        "Turnip the heat, it's cold in here!",
        "I didn't know you could yodel!",
        "Bless you!",
        "Is there an owl in here?",
        "Is there an echo in here?" };
   
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = null;
        String action = request.getParameter("action");
        String kk_type = getServletContext().getInitParameter("knockKnockType");       
        
        if (kk_type==null)
            kk_type="hidden";
        
        String indexStr = "";
        int index=-1;
        
        switch(kk_type)
        {
            case "hidden":
                indexStr = request.getParameter("index");
                break;
            case "cookie":
                Cookie[] cookies = request.getCookies();
                if (cookies != null)
                {
                    for (int i=0; i < cookies.length; i++)
                    {
                        if ("index".equals(cookies[i].getName()))
                        {
                            indexStr = cookies[i].getValue();
                            break;
                        }
                    }
                }
                break;
            case "session":      
                session = request.getSession(true);
                indexStr = (String)session.getAttribute("index");
                break;
        }
        try
        {
            index = Integer.parseInt(indexStr.trim());
        }
        catch(RuntimeException e)
        {
            System.out.println("This can happen ... just to let you know:" + e);
        }
        
        
        
        String url="/knockKnock.jsp";
        if ("Whose There?".equals(action))
        {
            url = "/whoseThere.jsp";
            index += 1;
            request.setAttribute("clue", clues[index % clues.length]);
            switch(kk_type)
            {
                case "hidden":
                    request.setAttribute("index", index);
                    break;
                case "cookie":
                    Cookie cookie = new Cookie("index", ""+index);
                    response.addCookie(cookie);
                    break;
                case "session":     
                    session.setAttribute("index", index+"");
                    break;
            }
            
        }
        else
        {
            String answer ="";
            if (index >= 0)
                answer = answers[index % answers.length];
            request.setAttribute("answer", answer);
            if (kk_type.equals("hidden"))
                request.setAttribute("index", index);
        }
        
         
         request.setAttribute("kk_type", kk_type);
         RequestDispatcher dispatcher =
             getServletContext().getRequestDispatcher(url);
         dispatcher.forward(request, response); 
       
    }

}