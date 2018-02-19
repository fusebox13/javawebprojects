
package radioActive;

import java.util.ArrayList;

public class RadioActiveCalculations {
    private String substance="";
    private double halfLife;
    private int years;
    private int pixelsInTotalBar;
    private ArrayList<RACalc> radioActiveArr=null;
    
    public void setSubstance(String s)
    {
        substance = s;
    }

// Notice this getter doesn't correspond to any instance variable
    public String getExtraTitle()
    {
        if (substance.length() > 0)
            return "for "+substance;
        else
            return "";
    }
    public void setHalfLife(double h)
    {
        halfLife =h;
    }
    public void setYears(int y)
    {
        years = y;
    }
    public void setPixelsInTotalBar(int p)
    {
        pixelsInTotalBar = p;
    }
    public String getTableData()
    {
        ArrayList<RACalc> raArr= getRadioActiveArr();
        StringBuilder sb = new StringBuilder();
        String eol = System.getProperty("line.separator");
        for (int y=0; y < raArr.size(); y++)
        { 
             RACalc rac = raArr.get(y);
             sb.append("<tr><td>" + y + "</td><td>"+
                     rac.getLostFraction()+"</td><td>" + 
                     rac.getCurrFraction() +"</td><td>" +
                     "<img src=\"red.gif\" height=\"10\" width=\""+
                     rac.getCurrFractionPixels() + "\" /></td></tr>" + eol);
                     
        }
        return sb.toString();       
    } 

    public ArrayList<RACalc> getRadioActiveArr()
    {
        if (radioActiveArr == null)
            radioActiveArr=calculateRadioActiveArr();
        return radioActiveArr;
    }
    
    private ArrayList<RACalc> calculateRadioActiveArr(){
        ArrayList<RACalc> raArr = new ArrayList<RACalc>();
        for (int y=0; y <= years; y++)
        {
            raArr.add (new RACalc(halfLife, y, pixelsInTotalBar));
        }
        
        return raArr;
    }    
}