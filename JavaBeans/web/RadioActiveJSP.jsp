<%@page import="radioActive.*,java.util.*"%>
<jsp:useBean id="radioActive"  class="radioActive.RadioActiveCalculations"/>
<jsp:setProperty name="radioActive" property="*" />
<html>
    <head>
        <title>Servlet RadioActiveServlet</title>
    </head>
    <body>
        <h1> Radio Active Calculations  
            <jsp:getProperty name="radioActive" property="extraTitle" /></h1>
       
            <table border="4">
                <tr><th>Year</th><th>Amount Decayed</th><th>Fraction Remaining</th>
                <th>Bar Remaining</th></tr>
            
             <jsp:getProperty name="radioActive" property="tableData" />
                
            </table>;
        
        
    </body>
</html>