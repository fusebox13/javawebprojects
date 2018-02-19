
package interest;

public class interestCalc {
    private double interestRate;
    private double monthlyPayment;
    private double principal;
    private double interestPaid;
    
    
    interestCalc(double i, double m, double p)
    {
        this.interestRate = i;
        this.monthlyPayment = m;
        this.principal = p;
        
    }
    
    public double getNewPrincipal()
    {
        interestPaid = principal * interestRate/(12 * 100 );
        return principal + interestPaid - monthlyPayment;
    }
    
    public String getCurrentPrincipal()
    {
        String s = String.format("%.2f", principal);
        return s;
    }

    
    public String getCurrentInterestPaid()
    {
        String s = String.format("%.2f", interestPaid);
        return s;
    }
}
