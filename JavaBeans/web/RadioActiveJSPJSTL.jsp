<%@page import="radioActive.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="radioActive"  class="radioActive.RadioActiveCalculations"/>
<jsp:setProperty name="radioActive" property="*" />
<html>
    <head>
        <title>Servlet RadioActiveServlet</title>
    </head>
    <body>
        <h1> Radio Active Calculations  
           <!-- <jsp:getProperty name="radioActive" property="extraTitle" />-->
            ${radioActive.extraTitle}
        </h1>
       
            <table border="4">
                <tr><th>Year</th><th>Amount Decayed</th><th>Fraction Remaining</th>
                <th>Bar Remaining</th></tr>
            
             <!--<jsp:getProperty name="radioActive" property="tableData" />-->
             ${radioActive.tableData}
                
            </table>
            <hr>
            <h1>Using forEach loop </h1>
            <table border="4">
                <tr><th>Year</th><th>Amount Decayed</th><th>Fraction Remaining</th>
                <th>Bar Remaining</th></tr>
            
                  <c:forEach var="raCalc" items="${radioActive.radioActiveArr}" 
                             varStatus="loopStatus">
                     <tr><td>${loopStatus.index}</td>
                            <td>${raCalc.lostFraction}</td><td>${raCalc.currFraction}</td>
                          <td><img src="red.gif" height="10" 
                                     width="${raCalc.currFractionPixels}" /></td>  
                    
                     </tr>
                  </c:forEach>
            </table>
        
    </body>
</html>