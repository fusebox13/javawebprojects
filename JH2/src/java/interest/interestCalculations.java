package interest;

import java.util.ArrayList;

public class interestCalculations {
    
     public static ArrayList<interestCalc> getInterestCalcs(double principal, double interestRate, double monthlyPayment, int years)
    {
        ArrayList<interestCalc> interestArr = new ArrayList();
        int months = years * 12;
        for (int m=0; m <= months; m++)
        {
            interestCalc ic = new interestCalc(interestRate, monthlyPayment, principal);
            if (principal >= 0)
            {    
                interestArr.add(ic);
        
            }
            else
                m = months;
            
            principal = ic.getNewPrincipal();
            
        }
        
        return interestArr;
    }    
}
