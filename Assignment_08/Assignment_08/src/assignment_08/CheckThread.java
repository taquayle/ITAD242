/*
    CheckThread

    Is this program these are the consumer threads that check for primes by
    grabbing candidates generated by the producer thread (GeneratorThread)

    Created on startup, the amount of threads being governed by the 
    NUMBER_OF_THREADS variable in main. If a prime is found it is put into the
    prime number list locasted in PrimesList.java
*/

package assignment_08;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author Quayle
 */
public class CheckThread  implements Runnable{

    private PrimesList prime_list;
    
    /* START: For Controlling the thread */
    private boolean alive = true;
    private boolean toggle = true;
    /* END: For Controlling thread */
    
    
    private Date timeFetched;
    private String lastPrimeFound;
    private String currentPrime;
    private PrimeCandidate recieved;
    private String threadName;
    
    // START: FOR PANEL LAYOUT //
    private JPanel genPanel = new JPanel();
    
    private JLabel headLabel = new JLabel("Generate Thread");
    
    private JPanel centerLeftPanel = new JPanel();
    private JLabel lastLabel = new JLabel("Last");
    private JPanel lastPane = new JPanel();
    private JLabel lastOutput = new JLabel();
    
    private JPanel centerRightPanel = new JPanel();
    private JLabel queueLabel = new JLabel("In-Work");
    private JPanel queuePane = new JPanel();
    private JLabel currentOutput = new JLabel();
  
    private JPanel buttonPane = new JPanel();
    private JButton pauseButton = new JButton("Pause");
    private JButton terminateButton = new JButton("Terminate");
    // END: FOR PANEL LAYOUT //
    
    
    // CONSTRUCTOR
    CheckThread(PrimesList list, String name, int REFRESH_TIMER)
    {
        prime_list = list;
        threadName = name;
        headLabel.setText(threadName);
        System.out.println("Creating | " + name);

        final Timer t = new Timer(REFRESH_TIMER, new panelUpdate());
        t.start();
    }
    

   public JPanel createPanel()
   {
        genPanel.setLayout(new GridLayout(1,5));
        // TO SET THE BLACK BORDER AROUND THE PANELS HOLDING CURRENT SIZE AND 
        // PRIME CANDIDATE
        lastPane.setBorder(BorderFactory.createLineBorder(Color.black));
        queuePane.setBorder(BorderFactory.createLineBorder(Color.black));
        
        // ADD LISTENER TO TERMINATE THREAD
        terminateButton.addActionListener(new terminateListener());
        
        // ADD LISTENER TO PAUSE THREAD
        pauseButton.addActionListener(new pauseListener());
       
        lastPane.add(lastOutput);
        centerLeftPanel.add(lastLabel);
        centerLeftPanel.add(lastPane);

        queuePane.add(currentOutput);
        centerRightPanel.add(queueLabel);
        centerRightPanel.add(queuePane);
        
        buttonPane.add(pauseButton);
        buttonPane.add(terminateButton);
       
        genPanel.add(headLabel);
        genPanel.add(centerLeftPanel);
        genPanel.add(centerRightPanel);
        genPanel.add(buttonPane);
        
        return genPanel;
    }
   
    // LISTENS FOR TIMER, DEPENDED ON REFRESH_TIMER
    class panelUpdate implements ActionListener
    {   @Override
        public void actionPerformed(ActionEvent event){updateLabels();}}
    
    // UPDATES THE LABELS TO SHOW CURRENT PRIME CANDIDATE BEING WORKED ON
    // AS WELL AS THE LAST PRIME FOUND
    public void updateLabels()
    {   lastOutput.setText(lastPrimeFound);
        currentOutput.setText(currentPrime);}
    
    @Override
    public void run() 
    {   
        try 
        {
            // SET INTIAL VALUES BEFORE THREAD 'STARTS'
            recieved = new PrimeCandidate(prime_list.getFromArrayList());
            lastPrimeFound = currentPrime = recieved.getCandidate().toString();
            updateLabels();
            while(!Thread.interrupted() && alive)
            {
               
                if(toggle)
                {
                    headLabel.setText(threadName); // used in event of queue being emptied
                    try
                    {
                        recieved = new PrimeCandidate(prime_list.getFromArrayList());
                        timeFetched = new Date();
                        currentPrime = recieved.getCandidate().toString();
                        if(TestForPrime.isPrime(recieved.getCandidate()))
                        {
                            lastPrimeFound = recieved.getCandidate().toString();

                            prime_list.addPrime(new Primes( recieved.getCandidate(),
                                                            recieved.getTimeStamp(), 
                                                            timeFetched));
                        }
                    }catch(IndexOutOfBoundsException e)
                    {System.out.println("QUEUE EMPTY"); 
                    headLabel.setText("QUEUE EMPTY, START ALL");
                    pauseToggle();}
                }
               
            }
         } catch (InterruptedException e) {}
    }
    

    // LISTENS TO TERMINATE BUTTON, IF HIT, KILLS THE THREAD
    // AND DISABLES BUTTONS SO CANNOT BE RESTARTED
    class terminateListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        { 
            terminateButton.setEnabled(false);
            pauseButton.setEnabled(false);
            alive = false;
        }
    }
    
    // USED BY THIS THREAD TO PAUSE, AND NOT KILL, THE THREAD
    private void pauseToggle()
    {
            if(!toggle)
                    pauseButton.setText("Pause");
            if(toggle)
                    pauseButton.setText("Start");
            toggle = !toggle;
    }
   
    // USED FOR THE PAUSE/START BUTTON
    class pauseListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        { pauseToggle();}
    }
}


