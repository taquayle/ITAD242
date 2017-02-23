/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assign_07_ques_03;

/**
 *
 * @author Quayle
 */
import javax.swing.JFrame;



public class ColorPanelRunner
{
   /**       Creates and displays the application frame.    */    
    public static void main(String[] args) 
   {
      ColorFrame frame = new ColorFrame();
      frame.setSize(400, 400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

