/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factors;


public class Factor {
   int base;
   int exponent;
   boolean first;
   Factor(boolean first, int base, int exponent)
   {
       this.base = base;
       this.exponent = exponent;
       this.first = first;
   }
   public String toString()
   {
       String retval=base+"";
       if (exponent > 1)
           retval = base+"<sup>"+exponent+"</sup>";
       if (!first)
           retval = "times "+ retval;
       
       return retval;
   }
}
