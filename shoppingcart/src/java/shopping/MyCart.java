package shopping;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

public class MyCart {

    private ArrayList<CartItem> cartArr = new ArrayList<CartItem>();
    private String errMessage = "";

    public String getErrorMessage() {
        return errMessage;
    }

    public int size() {
        return cartArr.size();
    }

    public static MyCart update(PageContext pageContext) {

        HttpSession session = pageContext.getSession();
        MyCart mc = (MyCart) session.getAttribute("MyCart");
        if (mc == null) {
            mc = new MyCart(); // Default Constructor provided from compiler
            session.setAttribute("MyCart", mc);
        }

        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        String action = request.getParameter("action");
        if (action == null) {
            return mc;
        }

        String description = request.getParameter("description");
        String strPrice = request.getParameter("price");
        String strIncrement = request.getParameter("increment");
        String itemId = request.getParameter("itemId");
        double price = 0.0;
        int increment = 0;
        mc.errMessage = "";

        try {
            strPrice = strPrice.trim();
            price = Double.parseDouble(strPrice);
        } catch (RuntimeException e) {
            System.out.println("Bad Price: This shouldn't happen :" + strPrice + " " + e);
        }
        try {
            strIncrement = strIncrement.trim();
            increment = Integer.parseInt(strIncrement);
        } catch (RuntimeException e) {
            mc.errMessage = "Bad Increment value";
            System.out.println("Bad Increment: This Can happen :" + strIncrement + " " + e);
        }


        CartItem ci = mc.getCartItem(itemId);
        if (ci == null ) 
        {
            if (increment > 0)
            {
                ci = new CartItem(description, itemId, price, increment);
                mc.cartArr.add(ci);
            }
        } else {
            ci.update(action, increment);
            if (ci.getTotalNumber()== 0)
            {
                // If the total is now zero, we want to remove it from the ArrayList
                for (int i=0; i< mc.cartArr.size(); i++)
                {
                    if (mc.cartArr.get(i).match(ci.getItemId()))
                        mc.cartArr.remove(i);
                }
            }
        }

        return mc;
    }

    private CartItem getCartItem(String itemId) {
        for (int i = 0; i < cartArr.size(); i++) {
            CartItem ci = cartArr.get(i);
            if (ci.match(itemId)) {
                return ci;
            }
        }
        return null;
    }

    public int getCartTotalNum(String itemId) {
        CartItem ci = getCartItem(itemId);
        if (ci == null) {
            return 0;
        } else {
            return ci.getTotalNumber();
        }
    }

    public String getCartValue(String itemId) {
        CartItem ci = getCartItem(itemId);
        if (ci == null) {
            return "";
        } else {
            double value = ci.getTotalValue();
            String s = String.format("$%.2f", value);
            return s;
        }
    }

    public String getTotalMyCartValue() {
        double total = 0;
        for (int i = 0; i < cartArr.size(); i++) {
            CartItem ci = cartArr.get(i);
            total += ci.getTotalValue();
        }
        String s = String.format("$%.2f", total);
        return s;
    }

    public CartItem getCartItem(int index) {
        if (index < 0 || index >= cartArr.size()) {
            return null;
        } else {
            return cartArr.get(index);
        }
    }
}