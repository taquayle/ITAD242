/*
    TestForPrime
    
    Class used to check whether or not a number is a prime candidate by first
    finding if it odd (done in GenerateThread) than checking if can be divided
    by 3, using isDividableBy3.

    Checkthreads check is a number is prime by Using isPrime, which uses EuclidGCD
    to find all potential GCD's and test agaisn't them
*/

package assignment_08;

import java.math.BigInteger;

/**
 *
 * @author Quayle
 */
public class TestForPrime {
    
    
    // USED BY CHECK THREADS (CONSUMER THREADS) TO SEE IF A NUMBER FROM ISPRIME
    // IS A PRIME OR NOT
    public static BigInteger EuclidGCD(BigInteger x, BigInteger y)
    {
       
        while(x.compareTo(y) != 0)
        {
           if(x.compareTo(y) == 1)x = x.subtract(y);
           else y = y.subtract(x);
        }
        return y;
    }
    
    // USED BY CHECK THREADS (CONSUMER THREADS) TO FIGURE OUT IF NUMBER IS PRIME
    public static Boolean isPrime(BigInteger p)
    {
        BigInteger r = BigInteger.valueOf(4);
        
        boolean primeCheck = true;
        
        while(r.compareTo(p) != 0)
        {
            if(EuclidGCD(p,r).compareTo(BigInteger.ONE) != 0)
               primeCheck = false;
            r = r.add(BigInteger.ONE); 
        }
        return primeCheck;
    }
    
    // USED BY GENERATE THREADS (PRODUCER THREAD) TO FIND IF A NUMBER IS A POTENTIAL
    // PRIME, IF RETURNS TRUE, THREAD KEEPS MOVING IF FALSE, ADDED TO CANIDATE ARRAY
    // IN PRIMESLIST
    public static Boolean isDividableBy3(BigInteger p)
    {
        String threeCheck = p.toString(); 
        int total = 0;
        
        for(int i = 0; i < threeCheck.length(); i++)
        {
            total += Character.getNumericValue(threeCheck.charAt(i));
         
        }
        if(total > 9) return isDividableBy3(BigInteger.valueOf(total));
        
        if(total % 3 == 0) return true;
        
        else return false;
    }
}
