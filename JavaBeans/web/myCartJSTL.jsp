<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="myCart" scope="session" class="beans.Cart" />  
<jsp:setProperty name="myCart" property="choice" param="choice"/> 
<jsp:setProperty name="myCart" property="cmd" param="cmd"/>  


<html> 
<head> 
    <title>Shopping Cart</title> 
</head> 
 
 <body > 

 
<form type=POST action=myCart.jsp>  
 
<table border = "4"> 
    <!--<jsp:getProperty name="myCart" property="tableData" />-->
    ${myCart.tableData}
</table> 
<hr>
<h3>Using JSTL</h3>
<table border = "4"> 
    <c:forEach var="junkFood" items="${myCart.list}" >
         <tr>
             <td>${junkFood}</td>
         </tr>
      </c:forEach>
</table>
<BR> 
Please enter item to add or remove: 
<br> 
Add Item: 
 
<SELECT NAME="choice"> 
<OPTION>Potato Chips 
<OPTION>Twinkies 
<OPTION>Cherry Pie 
<OPTION>Double Cheese Pizza
<OPTION>Ding Dongs 
<OPTION>Coke 
<OPTION>French Fries
<OPTION>Deep Fried Onion Rings
<OPTION>Extra Salt 
<OPTION>Ice Cream 
<OPTION>Chocolate Shake 
<OPTION>Bacon (Real Bacon with extra greese)
</SELECT> 
 
 
<br> <br> 
<INPUT TYPE=submit name="cmd" value="Add"> 
<INPUT TYPE=submit name="cmd" value="Remove">  
 
</form> 
        

</body> 
</html> 
