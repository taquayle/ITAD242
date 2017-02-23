/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assign_07_ques_09;

import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
/**
 *
 * @author Quayle
 */
public class Assign_07_Ques_09 {

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
        final Timer t = new Timer(1000, listener);
        t.start();
       
        class TimerToggler implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if (t.isRunning()) { t.stop(); }
                else { t.restart(); }
            }
        }
        
        class TimerExit implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            }
        }
        ActionListener listener2 = new TimerToggler();
        final Timer t2 = new Timer(15000, listener2);
        t2.start();
        ActionListener exit_listener = new TimerExit();
        final Timer t3 = new Timer(120000, exit_listener);
        t3.start();
        // Allow user to quit program by clicking OK on Dialog box.
        JOptionPane.showMessageDialog(null, "Please wait");
    }
   
    
}
