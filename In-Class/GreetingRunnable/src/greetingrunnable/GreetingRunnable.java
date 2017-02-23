/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package greetingrunnable;

/**
 *
 * @author Tyler
 */
public class GreetingRunnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GreetingRunnable r1 = new GreetingRunnable("Hello World");
        GreetingRunnable r1 = new GreetingRunnable("Hello World");
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start;
        t2.start;
    }
    
}
