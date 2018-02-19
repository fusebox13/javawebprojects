package shopping;


public class CartItem {
    private int totalNumber=0;
    private String itemId="";
    private String description="";
    private double price=0;
    
    public String getItemId()
    {
        return itemId;
    }
    
    public int getTotalNumber()
    {
        return totalNumber;
    }
    public String getDescription()
    {
        return description;
    }
    
    public double getPrice()
    {
        return price;
    }
    public double getTotalValue()
    {
        return price * totalNumber;     
    }
    
    public boolean match(String otherItemId)
    {
        if (itemId.equals(otherItemId))
            return true;
        else
            return false;
    }
    public CartItem(String description, String itemId, double price, int number)
    {
        this.description = description;
        this.itemId = itemId;
        this.price = price;
        totalNumber = number;
    }
    public void update(String action, int number)
    {
        if ("add".equals(action))
            totalNumber += number;
        else if ("remove".equals(action))
        {
            totalNumber -= number;
            if (totalNumber < 0)
                totalNumber = 0;
        }
    }
}