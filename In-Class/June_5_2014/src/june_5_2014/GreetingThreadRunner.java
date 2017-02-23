/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package june_5_2014;

/**
 *
 * @author Tyler
 */
public class GreetingThreadRunner {
    public static void main(String[] args)
    {
        GreetingRunnable r1 = new GreetingRunnable("Hello World");
        GreetingRunnable r2 = new GreetingRunnable("Goodbye World");
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException exception)
        {

        }
        t1.stop();
    }
}
