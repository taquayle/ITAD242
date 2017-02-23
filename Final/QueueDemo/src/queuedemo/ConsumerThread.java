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
public class ConsumerThread implements Runnable {
    Queue consumer;
    
    public ConsumerThread(Queue list)
    {
        consumer = list;
    }

    @Override
    public void run() {
        while(consumer.getCount() < 100)
        {
            try{
            System.out.println("Consumer Thread Get #" + (consumer.getCount()+1) + " "+ consumer.getFromArrayList());
            }catch(InterruptedException e){}
        }
    }
}
