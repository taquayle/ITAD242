/*
    Primes
    
    Class used by consumer threads when it finds a prime number, takes in
    the Prime number as well as the time which the candidate was created
    and the time at which it was fetched. It than squares the prime as well
    as creates a new time stamp for when the instance of the class was created
 */

package assignment_08;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Quayle
 */
public class Primes {
    private BigInteger prime;
    private BigInteger primeSquared;
    private Date timeCandidateCreated;
    private Date timeFetched;
    private Date timePrimeFound;
    
    public Primes(BigInteger _prime, Date _timeCandidateCreated, Date _timeFetched)
    {
        prime = _prime;
        primeSquared = prime.multiply(prime);
        timeCandidateCreated = _timeCandidateCreated;
        timeFetched = _timeFetched;
        timePrimeFound = new Date();
    }
    
    public Primes(Primes rightPrime)
    {
        prime = rightPrime.getPrime();
        primeSquared = rightPrime.getPrimeSquared();
        timeCandidateCreated = rightPrime.getTimeCreated();
        timeFetched = rightPrime.getTimeFetched();
        timePrimeFound = rightPrime.getTimeFound();
    }
    
    public BigInteger getPrime() { return prime; }
    public BigInteger getPrimeSquared() { return primeSquared; }
    public Date getTimeCreated() { return timeCandidateCreated; }
    public Date getTimeFetched() { return timeFetched; }
    public Date getTimeFound() { return timePrimeFound; }
    
    @Override
    public String toString()
    {
        return  prime + "," + primeSquared  + "," + timePrimeFound  + "," + 
                timeFetched + "," + timeCandidateCreated;
    }
    
    
    
}
