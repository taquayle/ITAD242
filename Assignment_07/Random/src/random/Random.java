/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package random;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;

/**
 *
 * @author Quayle
 */
public class Random {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        class CurrentTimePrinter implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                System.out.println(new Date());
            }
        }
        
        ActionListener listener = new CurrentTimePrinter();
        
        Timer t = new Timer(1000, listener); 
        t.start();
    }
    
}
