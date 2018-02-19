package radioActive;


public class RACalc {
    private double currFraction;
    private int pixelsInTotalBar;
    private double halfLife;
    
    RACalc(double halfLife, double years, int pixelsInTotalBar)
    {
        this.halfLife = halfLife;
        this.pixelsInTotalBar = pixelsInTotalBar;
        // N(t) = Initial * (1/2)**(time/thalfLife)
        currFraction = Math.pow(.5, years/halfLife);
    }
    public String getCurrFraction()
    {
//Note the following formatting trick:
        String s = String.format("%.6f", currFraction);
        return s;
    }
    public String getLostFraction()
    {
        String s = String.format("%.6f", 1.0 - currFraction);
        return s;
    }
    public int getCurrFractionPixels()
    {
        return (int)(currFraction * pixelsInTotalBar);
    }
    
}