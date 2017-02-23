/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package queuedemo;

import java.util.ArrayList;

/**
 *
 * @author s-Tyler.Quayle
 */
public class Queue {
    private ArrayList<String> stringList;
    private int count;
    Queue()
    {
        stringList = new ArrayList();
        count = 0;
    }
    
    public synchronized void addCandidate(String generated)
    {        
        stringList.add(generated);
        notifyAll();
    }
    
    public int getCount(){return count;}
    public int getArraySize(){return stringList.size();}
    
    public synchronized void continueNotifying() { notify();}
    
    public synchronized String getFromArrayList() throws InterruptedException 
    {
          wait(); //Keeps thread from adding more to list while others are grabbing it
          
           String returnString = stringList.get(0);
          
           stringList.remove(0);
          count++;
          return returnString;
    }
    
}
