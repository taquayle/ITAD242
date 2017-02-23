/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assign_07_ques_02;

import javax.swing.JFrame;

/**
 *
 * @author Quayle
 */
public class ComboPanelRunner
{
   /**       Creates and displays the application frame.    */    
    public static void main(String[] args) 
   {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400, 500);
      ComboPanel cp = new ComboPanel();
      frame.add(cp);
      frame.setVisible(true);
   }
}
