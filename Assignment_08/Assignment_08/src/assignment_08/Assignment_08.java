/*
    Mutli-threaded Producer - Consumer program to find Prime Numbers
    
    Tyler Quayle
    Lake Washington Insitute of Technology 
    ITAD 242 JAVA Programming
    Spring 2014
    Instructor: Julien Feis
*/

package assignment_08;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/*
 * @author Quayle
*/
public class Assignment_08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
    /* START: MAIN SETTINGS */
    /**/
    /**/    System.out.println("CURRENT SETTINGS, CHANGE IN ASSIGNMENT_08 MAIN");
    /**/    System.out.println("****************************************************");
    /**/    // MAIN FRAME WIDTH AND HEIGHT
    /**/    final int FRAME_WIDTH = 800, FRAME_HEIGHT = 600;
    /**/
    /**/    // CREATES THREADS + PANELS OF X MANY
    /**/    final int NUMBER_OF_THREADS = 5;
    /**/    System.out.println("NUMBER OF CONSUMER THREADS:\t" + NUMBER_OF_THREADS);
    /**/    
    /**/    // HOW OFTEN LABELS WILL UPDATE, 1000 = 1 SEC
    /**/    final int REFRESH_TIMER = 1000;
    /**/    System.out.println("PANEL REFRESH RATE:\t\t" + (REFRESH_TIMER/1000) + " SECONDS" );
    /**/    
    /**/    // HOW MANY CANDIDATES CAN BE QUEUED, IF NOT USED CANDIDATES BECOME 
    /**/    // UNWIELDLY (10,000,000+ IN QUEUE, 60MB+ DAT FILES)
    /**/    final int MAX_QUEUE_SIZE = 1000;
    /**/    System.out.println("MAX QUEUE OF GENERATOR THREAD:\t" + MAX_QUEUE_SIZE);
    /**/    
    /**/    // HOW OFTEN PROGRAM WILL WRITE TO FILE, 60000 = 1 MIN
    /**/    final int WRITE_TO_FILE_TIMER = 60000;
    /**/    System.out.println("TIME BETWEEN FILE WRITES:\t" + (WRITE_TO_FILE_TIMER/1000) + " SECONDS");
    /**/    
    /**/    // FILE PATHS OF FILES
    /**/    final String PRIME_CANDIDATES_FILE_NAME = "prime_candidates.dat";
    /**/    final String PRIME_NUMBERS_FILE_NAME = "prime_numbers.dat";
    /**/    System.out.println("PRIME CANDIDATES FILE PATH:\t" + PRIME_CANDIDATES_FILE_NAME);
    /**/    System.out.println("PRIME NUMBERS FILE PATH:\t" + PRIME_NUMBERS_FILE_NAME);
    /**/    System.out.println("****************************************************\n");
    /**/
    /* END: MAIN PROGRAM SETTINGS*/
        
        PrimesList main_list = new PrimesList(WRITE_TO_FILE_TIMER,
                                              PRIME_CANDIDATES_FILE_NAME,
                                              PRIME_NUMBERS_FILE_NAME);
        JFrame GUI = new JFrame();
        
        // Layout Determined by number of Threads
        JPanel primePanel = new JPanel(new GridLayout(NUMBER_OF_THREADS+2,1));
        
        GUI.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        GUI.setTitle("Tyler Quayle - Multi Thread Prime Generator");
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // CREATE AND START THE PRIME GENERATOR
        GenerateThread generator = new GenerateThread(main_list, MAX_QUEUE_SIZE, REFRESH_TIMER);
        primePanel.add(generator.createPanel());
        Thread primeGenerator = new Thread(generator);
        primeGenerator.start();
        
        // CREATES THE CHECK THREADS
        for(int i = 0; i < NUMBER_OF_THREADS; i++)
            primePanel.add(createCheckThread(new CheckThread(main_list, 
                                            "Test Thread "+(i+1),
                                            REFRESH_TIMER)));

        GUI.add(primePanel);
        GUI.add(exitPanel(), BorderLayout.SOUTH);
        GUI.setVisible(true);  
    }
    
    // CREATES PANEL FOR DISPLAYING CONSUMER THREADS, AND STARTS THREAD
    public static JPanel createCheckThread(CheckThread cThread)
    {
        Thread tempThread = new Thread(cThread);
        tempThread.start();
        
        return cThread.createPanel();
    }
    
    // PANEL CONTAINING THE EXIT BUTTON, ALWAYS SITUATED ON BOTTOM
    public static JPanel exitPanel()
    {
        JPanel exitPane = new JPanel();
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new exitListener());
        exitPane.add(exitButton, BorderLayout.EAST);
        return exitPane;
    }
    
    // LISTENER THAT EXITS THE PROGRAM IF EXIT_BUTTON IS HIT
    static class exitListener implements ActionListener
    {   @Override
        public void actionPerformed(ActionEvent e) { System.exit(0);}}
}