package guest;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GuestBook extends HttpServlet {
// instance variables ... note no problem here with multi-threads for these variables

    String guestFile="";
    String guestPath="";
    String fullFilePath="";
    
    public void init()
    {
        ServletConfig sc = getServletConfig();
        ServletContext sctx = getServletContext();
        guestFile = sc.getInitParameter("guestFile");
        guestPath = sc.getInitParameter("guestPath");
        
        System.out.println("guestFile="+ guestFile);
        System.out.println("guestPath="+guestPath);
        
        if (guestPath == null)
            guestPath="";
        else
            guestPath = guestPath.trim();
        
        if (guestFile == null)
            guestFile="GuestFileDefaultName.txt";
        
        if ( guestPath.length() == 0)
            fullFilePath = sctx.getRealPath("/WEB-INF/"+guestFile);
        else
        {
            //fullFilePath = System.getProperty("user.home")+"/" + guestPath + "/" + guestFile;
            String pathSeparator = System.getProperty("file.separator");
            fullFilePath = System.getProperty("user.home")+ pathSeparator + guestPath + pathSeparator + guestFile;
        }
        System.out.println("fullFilePath="+ fullFilePath);
            
    }
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GuestUserInput guser = new GuestUserInput();
        GuestBookUtils gbook = new GuestBookUtils(fullFilePath);

        if (guser.updateFromRequest(request))
        {
            gbook.add(guser.toString());
        }
        
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<body>");
            writeForm(out);
            
            out.println("<hr><pre>");
            out.println(gbook.getContents());
            out.println("</pre>");
            
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }
    private void writeForm(PrintWriter out)
    {
        out.println("<h1>Add a new entry</h1>");
        
        out.println("<form action=\"GuestBook\">");
        out.println("Full Name: <input type=\"text\" name=\"fullName\" size=\"60\" />");
            
        out.println("<p>Are  you a WCC Student: <input type=\"checkbox\" name=\"wccStudent\" value=\"yes\" />");
            
        out.println("<p>Gender: <input type=\"radio\" name=\"gender\" value=\"male\" />male");  
        out.println("<input type=\"radio\"  name=\"gender\" value=\"female\" />female"); 
        out.println("<input type=\"radio\" name=\"gender\"  value=\"unspecified\" />Unspecified");
        out.println("<p>Check any of the properties that apply:");
        out.println("<br/><input type=\"checkbox\" name=\"emailProperties\" value=\"businessEmail\" checked /> Add me to your Business Email List"); 
        out.println("<br/><input type=\"checkbox\" name=\"emailProperties\" value=\"spamEmail\" checked /> Add me to your Spam Email List");
        out.println("<br/><input type=\"checkbox\" name=\"emailProperties\" value=\"gamesEmail\" checked /> Add me to your advertising Email List");
        out.println("<br/><input type=\"checkbox\" name=\"emailProperties\" value=\"spywareEmail\" checked /> Add me to your spyware Email List"); 
            
        out.println("<p>Replace the dots with your Guestbook comment:");
        out.println("<br/><textarea name=\"information\" rows=\"5\" cols=\"65\">......</textarea>");
            
        out.println("<br/><input type=\"submit\" name=\"action\" value=\"Add Guestbook Entry\" />");
            
        out.println("</form>");
    
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}