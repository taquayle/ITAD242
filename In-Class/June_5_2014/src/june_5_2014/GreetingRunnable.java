/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package june_5_2014;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
/**
 *
 * @author julie_000
 */
public class GreetingRunnable implements Runnable {

    private static final int REPETITIONS = 50;
    private static final int DELAY = 1000;

    private String greeting;

    /**
     * Constructs the runnable object.
     *
     * @param aGreeting the greeting to display
     */
    public GreetingRunnable(String aGreeting) {
        greeting = aGreeting;
    }

    public void run() {
        try {
            for (int i = 1; i <= REPETITIONS; i++) {
                Date now = new Date();
                System.out.println(now + " " + greeting);
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException exception) {
        }
    }

}