/*
    PrimesList

    Main storage of the what the Producer and Consumer threads find
    canidate_list consists of objects of PrimeCanidates produced by GenerateThread (producer thread)
    prime_list consists of objects of Primes produced by CheckerThreads (consumer thread)
    
    Also will read in from files the intial values for candidates as well as
    all primes so they can be checked if they are duplicates before they are inserted
    into file
*/

package assignment_08;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author Quayle
 */
public class PrimesList {
    
    private ArrayList<PrimeCandidate> candidate_List;
    private ArrayList<Primes> prime_List;
    private ArrayList<BigInteger> checked_Primes;
    
    private String PRIME_CANDIDATES_FILE_NAME;
    private String PRIME_NUMBERS_FILE_NAME;
    
    private PrimeCandidate lastCandidate;
    
    private long current_prime_candidate = 2;
    
    public PrimesList(final int WRITE_TO_FILE_TIMER, String CANDIDATE_FILE_NAME, String PRIME_FILE_NAME)
    {
        candidate_List = new ArrayList();
        prime_List = new ArrayList();
        checked_Primes = new ArrayList();
        PRIME_CANDIDATES_FILE_NAME = CANDIDATE_FILE_NAME;
        PRIME_NUMBERS_FILE_NAME = PRIME_FILE_NAME;
        
        try
        {
            readCandidatesFromFile();
            readPrimesFromFile();
            createFiles();
        }catch (InterruptedException e) {}
        
        final Timer t = new Timer(WRITE_TO_FILE_TIMER, new writeToFileTimer());
        t.start();
    }
    
    // FOR USE WHEN STARTING GENERATOR THREAD, IF NO FILE IS FOUND, STARTS AT 3
    public long getLatestCandidateFromFile() { return current_prime_candidate; }
    
    
    // USED BY GENERATOR THREAD TO ADD TO CANDIDATE LIST
    public synchronized void addCandidate(PrimeCandidate candidate)
    {        
        candidate_List.add(candidate);
        lastCandidate = candidate;
        notifyAll();
    }
    
    // USED BY GENERATOR THREAD TO SHOW THE CURRENT AMOUNT OF ITEMS IN QUEUE
    public synchronized String getCandidateQueue(){return BigInteger.valueOf(candidate_List.size()).toString();}
    
    // USED BY GENERATOR THREAD TO CHECK IF QUEUE IS EMPTY OF FULL
    public synchronized int getCandidateQueueInt(){return candidate_List.size();}
    
    // USED BY THE GENERATOR THREAD AS IT NEEDS TO BE CONSTANTLY TELLING THE
    // CONSUMER THREADS ITS OKAY TO KEEP PULLING
    public synchronized void continueNotifying() { notify();}
    
    
    // USED BY CONSUMER (CHECK) THREADS, EVERYTIME ONE OF THEM GRABS FROM THE LIST
    // IT DELETES THE ONE IT GRABBED SO IT'S READY FOR THE NEXT THREAD TO PULL
    public synchronized PrimeCandidate getFromArrayList() throws InterruptedException 
    {
          wait(); //Keeps thread from adding more to list while others are grabbing it
          
          PrimeCandidate returnCandidate = new PrimeCandidate(candidate_List.get(0));
          
          candidate_List.remove(0);
          
          return returnCandidate;
    }
    
    // USED BY CONSUMER (CHECK) THREADS WHEN THEY FIND A PRIME
    public synchronized void addPrime(Primes foundPrime)
    {        
        prime_List.add(foundPrime);
        notifyAll();
    }
    
    // ONLY USED IN DEBUGGING BY ME, TO SHOW IF THEY CONSUMER THREADS WERE PUSHING
    // TO THE SAME STACK OF PRIME NUMBERS.
    public synchronized String getPrimeQueue(){return BigInteger.valueOf(prime_List.size()).toString();}
    
    
    // USED BY THIS CLASS (PRIMES_LIST) TO KEEP A RUNNING TIMER. EVERY X MILLISECONDS
    // WILL WRITE TO FILE
    class writeToFileTimer implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            System.out.println("\nWriting to File");
            try{writeToFile();}catch (InterruptedException e) {}
        }
    }
    
    // USED BY THIS CLASS (PRIMES_LIST), WHEN INTIALIZED WILL FILL THE CANDIDATE
    // LIST FROM FILE
    private synchronized void readCandidatesFromFile() throws InterruptedException
    {
        try {
            System.out.print("Checking for Prime Candidates file: ");
            
            SimpleDateFormat parserSDF = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
            BigInteger candidate_from_file;
            Date date_from_file;
            
            BufferedReader in = new BufferedReader(new FileReader(PRIME_CANDIDATES_FILE_NAME));
           

            
            if(in.readLine() != null)
            {
                String str = in.readLine();
                String[] commaSplit = str.split(",");
                while ((str = in.readLine()) != null) 
                {
                    try
                    {
                    commaSplit = str.split(",");
                    candidate_from_file = BigInteger.valueOf(Long.parseLong(commaSplit[0]));
                    date_from_file = parserSDF.parse(commaSplit[1]);
                    addCandidate(new PrimeCandidate(candidate_from_file,date_from_file));
                    }catch(ParseException e){}
                }
                System.out.println("\tStarting Prime Candidate: " + commaSplit[0] + " | Created on: " + commaSplit[1]);
                // USED BY GENERATOR THREAD TO DETERMINE WHAT NUMBER TO START AT
                // DEFUALT OF 3 IF NO FILE EXSISTS
                current_prime_candidate = Long.parseLong(commaSplit[0]);
            }
            else{ System.out.println("\tFile " + PRIME_CANDIDATES_FILE_NAME + 
                                    " IS EMPTY!\n\t\t\t\t\tSTARTING CANDIDATE SEARCH AT: "+
                                    current_prime_candidate);}
            in.close();

        }   catch (IOException e) 
            {System.out.println("\t"+PRIME_CANDIDATES_FILE_NAME + 
                                " NOT FOUND!\n\t\t\t\t\tSTARTING CANDIDATE SEARCH AT: "+
                                current_prime_candidate);}  
    } 
    
    // USED BY THIS CLASS (PRIMES_LIST), WHEN INTIALIZED WILL FILL THE PRIME
    // LIST FROM FILE
    private synchronized void readPrimesFromFile() throws InterruptedException
    {
        try {
            System.out.print("\nChecking for Prime Number File: ");
            BufferedReader in = new BufferedReader(new FileReader(PRIME_NUMBERS_FILE_NAME));
            
            BigInteger prime_from_file;
            String str;
            String[] commaSplit;
            if(in.readLine() != null)
            {
                while ((str = in.readLine()) != null) 
                {
                    commaSplit = str.split(",");
                    prime_from_file = BigInteger.valueOf(Long.parseLong(commaSplit[0]));
                    checked_Primes.add(prime_from_file);
                }
                System.out.println("\t" + checked_Primes.size() + " Primes successfully inserted from file");
            }
            else{ System.out.println("\tFile " + PRIME_NUMBERS_FILE_NAME + " IS EMPTY!");
                insertFirstPrimes();}
            in.close();

        }catch (IOException e) {System.out.println("\t" + PRIME_NUMBERS_FILE_NAME + " NOT FOUND!");
            insertFirstPrimes();}     
    } 
    
    // INSERTS FIRST 3 PRIMES (1,2,3) SINCE THE CHECK FOR PRIMES METHODS WILL NOT
    // RECOGNIZE THESE
    private void insertFirstPrimes()
    {
        System.out.println("\nInserting first 3 Primes into ArrayList of Primes");
        
        for(int i = 1; i < 4; i++ )
            addPrime(new Primes(BigInteger.valueOf(i), new Date(), new Date()));
    }
    
    // CHECK FOR DUPLICATES OF PRIMES BEFORE WRITING TO FILE
    private void checkForDuplicates()
    {
        for(int i = 0; i < checked_Primes.size(); i++)
            for(int j = 0; j < prime_List.size(); j++)
                if(prime_List.get(j).getPrime().equals(checked_Primes.get(i)))
                {
                    prime_List.remove(j);
                    checkForDuplicates();
                }
    }
    
    // CALLED BY THIS CLASS (PRIMES_LIST) TO WRITE ALL CURRENT ITEMS IN BOTH QUEUES
    // WILL APPEND IF PRIME, OVERWRITE IF CANDIDATES
    private synchronized void writeToFile() throws InterruptedException
    {
        wait();
        try
        {
            FileWriter fw = new FileWriter(PRIME_NUMBERS_FILE_NAME,true); //the true will append the new data
  
            int duplicates = prime_List.size();
            
            System.out.print("Checking for Duplicates...");
            checkForDuplicates();
                
            System.out.println(" Duplicates Found: " + (duplicates-prime_List.size()));
            
            System.out.println("Writing " + prime_List.size() + " primes to file");
            while(!prime_List.isEmpty())
            {
                    fw.write(prime_List.get(0).toString() + 
                        System.getProperty("line.separator"));//appends the string to the file
                    checked_Primes.add(prime_List.get(0).getPrime());
                    prime_List.remove(0);
            }
            fw.close();

            fw = new FileWriter(PRIME_CANDIDATES_FILE_NAME, false); // false will not append
            
            // IF CANDIDATE LIST WAS EMPTY ON TIME OF WRITE, WRITE TO FILE LAST CANDIDATE
            // TO BE PUT INTO THE LIST
            if(candidate_List.isEmpty()) {fw.write(lastCandidate.toString());}
            for(PrimeCandidate loop: candidate_List)
                fw.write(loop.toString() + System.getProperty("line.separator"));
            
            fw.close();
        }catch(IOException ioe){System.err.println("IOException: " + ioe.getMessage());}
    }
    
    //  USED TO CREATE FILES, IF THEY ARE ALREADY CREATED THEY ARE OPENED THAN CLOSED
    private synchronized void createFiles() throws InterruptedException
    {
        try
        {
            System.out.println("\nCreating Files");
            FileWriter fw = new FileWriter(PRIME_NUMBERS_FILE_NAME,true); //the true will append the new data
            fw.close();
            fw = new FileWriter(PRIME_CANDIDATES_FILE_NAME, false); // false will not append
            fw.close();
        }catch(IOException ioe){System.err.println("IOException: " + ioe.getMessage());}
    }
}
