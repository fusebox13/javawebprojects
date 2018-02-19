<%-- 
    Document   : index
    Created on : Sep 30, 2013, 10:15:28 AM
    Author     : Dan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     <h1>Demo Global Declarations </h1>
        
        <%! int hitCounter=0; %>
        <h2>Hit Counter: <%=++hitCounter%> </h2>       
        <%
            String people = addAnotherPerson(
                    request.getParameter("name"), request.getParameter("age"));
        %>
        
        People= <%=people %>
    </body>
</html>

<%@page import= "java.util.ArrayList" %>
<%!
    class Person
    {
        String name;
        int age=0;
        Person(String n, String a)
        {
            name = n;
            try
            {
                age = Integer.parseInt(a);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Received a bad age:" +e);
            }
        }
        public String toString()
        {
            return name +":" + age;
        }
    }
    
    ArrayList<Person> personArr = new ArrayList<Person>();
    
    synchronized String addAnotherPerson(String name, String age)
    {
        if (name != null && age != null)
            personArr.add(new Person(name, age));
        return personArr.toString();
    }
%>