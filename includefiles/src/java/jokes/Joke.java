package jokes;

import java.util.StringTokenizer;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;


public class Joke {
    private double pointTotal = 0.0;
    private int count=0;
    private String score = "No Rating Yet";
    
   
    synchronized public String getRating()
    {
        return score;
    }
    synchronized public void setRating(String indexStr, PageContext pageContext)
    {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        Cookie[] cookies = request.getCookies();
        String currJokeVotingCheck="";
        if (cookies != null)
        {
            for (int i=0; i < cookies.length; i++)
            {
                if ("jokeVotingCheck".equals(cookies[i].getName()))
                {
                    currJokeVotingCheck = cookies[i].getValue();
                    StringTokenizer parse = new StringTokenizer(currJokeVotingCheck,", ");
                    while(parse.hasMoreTokens())
                    {
                        if (indexStr.equals(parse.nextToken()))
                            return ; // This guy already voted
                    }
                }
                
            }
        }

        // Now we know this client hasn't voted on this joke before

        currJokeVotingCheck += indexStr +",";
                
        Cookie cookie = new Cookie("jokeVotingCheck", currJokeVotingCheck);
        //cookie.setMaxAge(3600*24); // Wait 24 hours before voting again. 
        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
        response.addCookie(cookie);
       
// Finally we are back to the business of updating the Joke Rating

        String strRating = request.getParameter("rating");
        int rating = Integer.parseInt(strRating);
        pointTotal += rating;
        count +=1;
        score = String.format("%.2f out of %d votes", pointTotal/count, count);
    }
    
}