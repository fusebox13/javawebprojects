<tr>
                <form action="shoppingCart.jsp">
                    <td><input type="text" name="description" value="<%=cart.getDescription()%>" readonly /></td>
                    <td><input type="text" name="price" value="<%=cart.getPrice()%>" readonly /></td>
                    <td><input type="text" name="increment" /></td>
                    <td>
                        <input type="hidden" name="itemId" value="<%=cart.getItemId()%>" />
                        <input type="submit" name="action" value="add" />
                        <input type="submit" name="action" value="remove" />
                    </td>
                </form>
                <td><%= myCart.getCartTotalNum(cart.getItemId())%></td>
                <td><%= myCart.getCartValue(cart.getItemId())%></td>
            </tr>