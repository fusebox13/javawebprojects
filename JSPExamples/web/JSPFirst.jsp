 <%         
            String fullName = request.getParameter("fullName");
            String wccStudent = request.getParameter("wccStudent");
            String gender = request.getParameter("gender");
            String classYear = request.getParameter("classYear");
            String[] propertyArr = request.getParameterValues("properties");
            String properties ="";
            if (propertyArr != null && propertyArr.length > 0)
            {
                for (int i=0; i < propertyArr.length; i++)
                    properties += propertyArr[i] + " ";
            }
            String information = request.getParameter("information");
   %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP First</title>
    </head>
    <body>
      
         <h1>Welcome</h1>
            Here is the information we collected from you
            
            <p>your full name is: <%= fullName %>
            <p>The answer to whether you are a WCC student is: <%= wccStudent%>
            <p>Your gender is <%= gender%>
            <p>Your class year is: <%= classYear%>
            <p>Your properties are: <%= properties%>
            <p>Your extra information is: <%= information%>
        
        
    </body>
</html>