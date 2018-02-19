package Person;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;


public class PersonCollection 
{
    private ArrayList<Person> personArray = new ArrayList<Person>();
    String errorMessage = "";
    
    public int size()
    {
        return personArray.size();
    }
    
    public Person getPerson(int index)
    {
        return personArray.get(index);
    }
    
    public String getErrorMessage()
    {
        return errorMessage;
    }
    
    public boolean hasEntries()
    {
        if (personArray.isEmpty())
            return false;
        else
            return true;
    }
    
    public static PersonCollection update(PageContext application)
    {
        HttpSession session = application.getSession();
        
        PersonCollection pc = (PersonCollection)session.getAttribute("PersonCollection");
        if(pc == null)
        {
            pc = new PersonCollection();
            session.setAttribute("PersonCollection", pc);
        }
        
        HttpServletRequest request = (HttpServletRequest) application.getRequest();
        String action = request.getParameter("action");
        if (action != null)
        {
            String firstName = request.getParameter("firstName");
            String middleName = request.getParameter("middleName");
            String lastName = request.getParameter("lastName");
            String eyeColor = request.getParameter("eyeColor");
            String hairColor = request.getParameter("hairColor");
            String weight = request.getParameter("weight");
            String height = request.getParameter("height");
            
            Person person = new Person(firstName, middleName, lastName, eyeColor, hairColor, weight, height);
            
          
            if ("Destroy".equals(action))
            {
                pc.personArray.clear();
                pc.errorMessage = "Data Destroyed";
            }
            
            if ("Add".equals(action))
            {
                pc.errorMessage = person.validate();
                boolean duplicate = false;
                boolean validated = false;
                
                if(pc.errorMessage == "")
                    validated = true;
                else
                    pc.errorMessage = "Invalid: " + pc.errorMessage;
                
                for (int i = 0; i < pc.personArray.size(); i++)
                {
                    if(person.equals(pc.personArray.get(i)))
                    {
                        duplicate = true;
                        break;
                    }
                }
                
                if (!duplicate)
                {
                    if (validated)
                    {
                        pc.personArray.add(person);
                        pc.errorMessage = "";
                    }
                }
                else
                    pc.errorMessage = "Duplicate Person";
            }
            
            if ("remove".equals(action))
            {
                for (int i = 0; i < pc.personArray.size(); i++)
                {
                    if (person.equals(pc.personArray.get(i)))
                        pc.personArray.remove(i);
                }
                pc.errorMessage = person + " removed.";
                
            }
            
            if ("update".equals(action))
            {
                String strIndex = request.getParameter("index");
                int index = Integer.parseInt(strIndex);
                
                Person p = pc.personArray.get(index);
                p.setFirstName(firstName);
                p.setMiddleName(middleName);
                p.setLastName(lastName);
                p.setEyeColor(eyeColor);
                p.setHairColor(hairColor);
                p.setWeight(weight);
                p.setHeight(height);
                pc.errorMessage = person + " updated.";
                
            }
        }
        return pc;
    }
    
}
