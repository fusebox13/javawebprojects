<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="shopping.*"  %> 
<%
    MyCart myCart = MyCart.update(pageContext);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
    <body>
        <h1>ShoppingCart</h1>
        <h3><%= myCart.getErrorMessage() %></h3>
        <table border="4">
            <tr><th>Item</th><th>Price</th><th>Increment</th><th>Action</th><th>Total #</th><th>Total $</th></tr>
           
            
            <%
                    CartItem cart = new CartItem("Pants", "A", 25.99, 0);
                 %>
                <%@ include file="/includes/shoppingRow.jsp" %>
                 <%
                    cart = new CartItem("Shirts", "B", 19.99, 0);
                 %>
                <%@ include file="/includes/shoppingRow.jsp" %>
            
                <%
                    cart = new CartItem("Socks", "C", 5.99, 0);
                 %>
                <%@ include file="/includes/shoppingRow.jsp" %>
                           
                <%
                    cart = new CartItem("M & Ms", "D", 0.85, 0);
                 %>
                <%@ include file="/includes/shoppingRow.jsp" %>
            
        </table>
            
            
            
        <hr>
        <h3>Total Value in the Cart is <%= myCart.getTotalMyCartValue() %></h3>
        <table border="3">
            <tr><th>Item</th><th>Price</th><th>Total #</th><th>Total $</th></tr>
        <%
            for (int i=0; i < myCart.size(); i++)
            {
                CartItem ci = myCart.getCartItem(i);
                // Returning to Html Mode
        %>
            <tr>
                <td><%=ci.getDescription() %></td>
                <td><%=ci.getPrice() %></td>
                <td><%=ci.getTotalNumber() %></td>
                <td><%=String.format("$%.2f",   ci.getTotalValue()) %></td>
            </tr>
        <%
                // Returning to Java Mode
            }
         %>
        </table>
    </body>
</html>