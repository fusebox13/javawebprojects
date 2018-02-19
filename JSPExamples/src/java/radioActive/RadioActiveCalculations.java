package radioActive;

import java.util.ArrayList;


public class RadioActiveCalculations {
    
    public static ArrayList<RACalc> getRadioActiveArr(double halfLife, int years, int pixelsInTotalBar)
    {
        ArrayList<RACalc> raArr = new ArrayList<RACalc>();
        for (int y=0; y <= years; y++)
        {
            raArr.add (new RACalc(halfLife, y, pixelsInTotalBar));
        }
        
        return raArr;
    }    
}