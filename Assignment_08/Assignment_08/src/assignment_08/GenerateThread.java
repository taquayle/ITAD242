/*
    GenerateThread
    
    Is the 'producer' thread that will continously find prime canidates, which
    are numbers that are odd and not divisable by three.

    Will only find numbers when there are less than MAX_QUEUE_SIZE in the queue
    as having it unwatched caused over 400,000 candidates to be in the queue
    within 2 seconds of program start. Slowing everything down
*/

package assignment_08;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * @author Quayle
*/
public class GenerateThread implements Runnable{
    
    
    /* START: For Controlling the thread */
    private boolean alive = true;
    private boolean toggle = true;
    private int MAX_QUEUE_SIZE;
    /* END: For Controlling thread */
    
    private PrimesList prime_list;
    
    private String currentCandidate;
    
    // START: FOR PANEL LAYOUT //
    private JPanel genPanel = new JPanel();
    
    private JLabel headLabel = new JLabel("Generate Thread");
    
    private JPanel centerLeftPanel = new JPanel();
    private JLabel lastLabel = new JLabel("Last");
    private JPanel lastPane = new JPanel();
    private JLabel lastOutput = new JLabel();
    
    private JPanel centerRightPanel = new JPanel();
    private JLabel queueLabel = new JLabel("Queue");
    private JPanel queuePane = new JPanel();
    private JLabel queueOutput = new JLabel();
  
    private JPanel buttonPane = new JPanel();
    private JButton pauseButton = new JButton("Pause");
    private JButton terminateButton = new JButton("Terminate");
    // END: FOR PANEL LAYOUT //
   
    
    GenerateThread(PrimesList list, int MAX_QUEUE, int REFRESH_TIMER)
    {
        prime_list = list;
        MAX_QUEUE_SIZE = MAX_QUEUE;
        System.out.println("\nCreating | Generator");
        final Timer t = new Timer(REFRESH_TIMER, new panelUpdate());
        t.start();
    }
   
    public JPanel createPanel()
    {
        genPanel.setLayout(new GridLayout(1,4));
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

        queuePane.add(queueOutput);
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
   
    // TIMER LISTENER, DEPENDENT ON REFRESH_TIMER
    class panelUpdate implements ActionListener
    {   @Override
        public void actionPerformed(ActionEvent event){updateLabels();}}
    
    // UPDATES THE LABELS TO DISPLAY CURRENT CANDIDATE AND TOTAL QUEUE SIZE
    public void updateLabels()
    {   lastOutput.setText(currentCandidate);
        queueOutput.setText(prime_list.getCandidateQueue());}
    
    @Override
    public void run() 
    {
        long i = prime_list.getLatestCandidateFromFile();
        currentCandidate = "" + i;
        updateLabels(); //TO DISPLAY STARTING VARIABLES
        while(alive)
        {
            if(toggle)
            {
                if(prime_list.getCandidateQueueInt() > MAX_QUEUE_SIZE) {continueNotifying();}
                else
                {
                    if(i % 2 == 1)
                        if(!TestForPrime.isDividableBy3(BigInteger.valueOf(i)))
                            prime_list.addCandidate(new PrimeCandidate(BigInteger.valueOf(i)));
                    currentCandidate = "" + i;
                    i++;
                }
            }
            if(!toggle)continueNotifying(); // WHILE "PAUSED" SO OTHER THREADS CAN CONTINUE DRAWING FROM QUEUE
        }
        while(!alive){continueNotifying();}
    }
   
    // CONTINUES NOTIFYING OTHER THREADS WHEN PAUSED OR TERMINATED SINCE THEY WILL
    // NOT RUN UNLESS THEY HAVE BEEN GIVEN THE 'GO AHEAD' (NOTIFY())
    public synchronized void continueNotifying(){prime_list.continueNotifying();}
   

    
    // LISTENER THAT WILL KILL THE THREAD PRIME CANDIDATE PRODUCER
    // ALSO GREYS OUT BOTH BUTTONS TO SHOW THREAD IS DEAD
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
    
    // USED BY THIS THREAD TO PAUSE, BUT NOT KILL, THE THREAD
    private void pauseToggle()
    {
        headLabel.setText("Generate Thread");
        if(toggle)
                pauseButton.setText("Start");
        if(!toggle)
                pauseButton.setText("Pause");
        toggle = !toggle;
    }
    
    // LISTENER THAT WILL TEMPORARILY STOP THE PRODUCER
    class pauseListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        { pauseToggle();}
    }
}
