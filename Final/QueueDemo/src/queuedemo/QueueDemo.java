/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package queuedemo;

/**
 *
 * @author s-Tyler.Quayle
 */
public class QueueDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Queue mainQueue = new Queue();
        
        ProducerThread generator = new ProducerThread(mainQueue);
        Thread p1 = new Thread(generator);
        
        ConsumerThread consumer = new ConsumerThread(mainQueue);
        Thread c1 = new Thread(consumer);
        
        p1.start();
        c1.start();
    }
    
}
