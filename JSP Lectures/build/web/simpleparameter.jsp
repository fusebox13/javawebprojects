<% 
    String[] hobbyArr = request.getParameterValues("hobby");
    String hobbies="No Hobbies";
    if (hobbyArr != null)
    {
        hobbies ="";
        for (int i=0; i < hobbyArr.length; i++)
        {
            hobbies += hobbyArr[i] + " ";
        }
    }
 %>
<html>
    <body>
        <h1>Simple parameter</h1>
        So your name is <%= request.getParameter("fullName") %>
        <p>
        Your hobbies are <%= hobbies %>
        
    </body>
</html>