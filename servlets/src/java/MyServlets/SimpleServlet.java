package MyServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilities.Utilities;


public class SimpleServlet extends HttpServlet {
    String filename="";
    @Override
    public void init() throws ServletException
    {
        ServletConfig sc = getServletConfig();
        filename = sc.getInitParameter("filename");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        //response.setContentType("text/plain");
        
        PrintWriter out = response.getWriter();
        try {
            
            out.println("<html>");
            out.println("<body>");
           
            String fullName = request.getParameter("fullName");
            
            // Write out fullName to some file
            ServletContext sc = getServletContext();
            String path= sc.getRealPath("/WEB-INF/"+filename);
            //System.out.println("path="+path);
            Utilities.add(fullName, path);
            out.println("<h3>"+fullName + " written to file</h3>");
            
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }
 
}