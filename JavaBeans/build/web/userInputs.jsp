<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="userInputs"  class="beans.UserInputs"/>
<jsp:setProperty name="userInputs" property="*" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>user inputs</title>
    </head>
    <body>
      
         <h1>Welcome</h1>
            Here is the information we collected from you
            
            <p>your full name is: <jsp:getProperty name="userInputs" property="fullName" />
            <p>The answer to whether you are a WCC student is: <jsp:getProperty name="userInputs" property="wccStudent" />
            <p>Your gender is <jsp:getProperty name="userInputs" property="gender" />
            <p>Your class year is: <jsp:getProperty name="userInputs" property="classYear" />
            <p>Your extra information is: <jsp:getProperty name="userInputs" property="information" />
                
            <p>your full name is: ${userInputs.fullName}
            <p>The answer to whether you are a WCC student is: ${userInputs.wccStudent}
            <p>Your gender is ${userInputs.gender}
            <p>Your class year is: ${userInputs.classYear}
            <p>Your extra information is: ${userInputs.information}
        
        
    </body>
</html>