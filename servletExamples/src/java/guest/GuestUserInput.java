package guest;

import javax.servlet.http.HttpServletRequest;

enum GENDER_TYPE {male, female, unspecified};
enum EMAIL_PROPERTY_TYPE {businessEmail, spamEmail, gamesEmail, spywareEmail};

public class GuestUserInput {
    private String fullName="";
    private boolean wccStudent=false;
    private GENDER_TYPE gender=GENDER_TYPE.unspecified;
    private EMAIL_PROPERTY_TYPE[] emailProperties=null;
    private String information;
    
    public String toString()
    {
        String eol = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append("Full Name: " + fullName + eol);
        if (wccStudent)
            sb.append("WCC Student " + eol);
        sb.append("Gender: " + gender.toString() +eol);
        if (emailProperties != null)
        {
            sb.append("Email Properties: " );
            for (int i= 0; i < emailProperties.length; i++)
            {
                sb.append(emailProperties[i].toString()+"  ");
            }
            sb.append(eol);
        }
        sb.append("Information: " + information + eol);
        sb.append("*********************************************************"+eol);
        
        return sb.toString();
    }
    
    public boolean updateFromRequest(HttpServletRequest request)
    {
        String action = request.getParameter("action");
        if (action == null)
            return false; // No form submission ... must be going straight to the servlet
        
        fullName = request.getParameter("fullName");
        information = request.getParameter("information");
        
        if (request.getParameter("wccStudent") != null)
            wccStudent = true;
        
        String sg = request.getParameter("gender");
        if (sg != null)
        {
            gender = GENDER_TYPE.valueOf(sg);
        }
        
        String[] spArr = request.getParameterValues("emailProperties");
        if (spArr != null)
        {
            emailProperties = new EMAIL_PROPERTY_TYPE[spArr.length];
            for (int i=0; i < spArr.length; i++)
                emailProperties[i] = EMAIL_PROPERTY_TYPE.valueOf(spArr[i]);
        }
        return true;
    }
}