package person;


import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;


public class PersonCollection {
    
    public static String update(Statement statement, HttpServletRequest request)
    {
        String errorMessage="";
        String action = request.getParameter("action");
        if (action != null ) {
            String firstName = request.getParameter("firstName");
            String middleName = request.getParameter("middleName");
            String lastName = request.getParameter("lastName");
            String eyeColor = request.getParameter("eyeColor");
            String hairColor = request.getParameter("hairColor");
            String weight = request.getParameter("weight");
            String height = request.getParameter("height");
            Person person = new Person(firstName, middleName, lastName, eyeColor,
                    hairColor, weight, height);

            String strIndex;
            int index;

            switch (action) {
                case "destroy":
                    errorMessage=Person.remove(-1, statement);
                    break;
                case "add":
                    errorMessage = person.insert(statement);
                    break;
                case "remove":
                    strIndex = request.getParameter("index");
                    index = Integer.parseInt(strIndex);
                    errorMessage = Person.remove(index, statement);
                    break;
                case "update":
                    strIndex = request.getParameter("index");
                    index = Integer.parseInt(strIndex);
                    errorMessage = person.update(index, statement);
                    break;
            }

        }
        
        ArrayList<Person> people = new ArrayList<>();
        errorMessage += Person.getBooks(statement, people);
        request.setAttribute("people", people);
        
        return errorMessage;
    }

}