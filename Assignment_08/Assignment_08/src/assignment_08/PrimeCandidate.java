/*
    PrimeCandidate
    
    Class used by GeneratorThread, CheckThread and to a lesser extent PrimeList.
    A simple class with 1 BigInt (candidate) and the Date (timeStamp) at which
    it was created. Date is automatically created if only the BigInt is passed
    into it on created (Partial Constructor)
*/

package assignment_08;

import java.math.BigInteger;

import java.util.Date;

/**
 *
 * @author Quayle
 */
public class PrimeCandidate {
    
    private BigInteger candidate;
    private Date timeStamp;
    
    // DEFUALT CONSTRUCTOR
    public PrimeCandidate(){candidate = BigInteger.valueOf(0); timeStamp = new Date();}
    
    // PARTIAL CONSTRUCTOR
    public PrimeCandidate(BigInteger big)
    {
        candidate = big;
        timeStamp = new Date();
    }
    
    // FULL CONSTRUCTOR
    public PrimeCandidate(BigInteger big, Date time)
    {
        candidate = big;
        timeStamp = time;
    }
   
    // COPY CONSTRUCTOR
    public PrimeCandidate(PrimeCandidate rightCan)
    {
        candidate = rightCan.getCandidate();
        timeStamp = rightCan.getTimeStamp();
    }
    
    // GET METHODS
    public BigInteger getCandidate() {return candidate;}
    public Date getTimeStamp() {return timeStamp;}
    
    // SET MEHTODS
    public void setCandidate(BigInteger big) { candidate = big;}
    public void setTimeStamp(Date time) {timeStamp = time;}
    
    // OVERRIDE TO STRING, NEED THE COMMA FOR READ IN PURPOSES
    @Override
    public String toString(){return candidate + "," + timeStamp;}
    
}
