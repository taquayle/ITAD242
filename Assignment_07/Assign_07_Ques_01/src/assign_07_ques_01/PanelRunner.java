/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;

public class PanelRunner
{
   /**
      Creates and displays the application frame.
   */
   public static void main(String[] args) 
   {
      JFrame frame = new JFrame("Color Panels");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(1200, 1000);
      JPanel panel = new JPanel();
      panel.setPreferredSize(new Dimension(1200, 1000));
      JPanel subpanel1 = new JPanel();
      subpanel1.setBackground(Color.RED);
      subpanel1.setPreferredSize(new Dimension(200, 1000));
      panel.add(subpanel1);
      frame.add(panel);
      frame.setVisible(true);
   }
}

