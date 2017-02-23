/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package queuedemo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author s-Tyler.Quayle
 */
public class ProducerThread implements Runnable {
    
    Queue producer;
    
    ProducerThread(Queue list)
    {
        producer = list;
    }
    
    @Override
    public void run() {
        
        while(producer.getCount() < 100)
        {
            if(producer.getArraySize() < 10)
            {
                producer.addCandidate(new Date().toString());
            }else producer.continueNotifying();
        }
    }
    
    
    
}
