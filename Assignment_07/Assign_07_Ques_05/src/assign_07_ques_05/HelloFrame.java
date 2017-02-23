/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assign_07_ques_05;

/**
 *
 * @author Quayle
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelloFrame extends JFrame
{   
   private String message;
   private JLabel label;
   private JButton smallerButton;
   private JButton largerButton;
   private ActionListener largeListener;
   private ActionListener smallListener;
   
   private static int FRAME_WIDTH = 300;
   private static int FRAME_HEIGHT = 300;
   private static int DEFAULT_SIZE = 20;
   
   private static double fontSizeFactor = 1;

    public HelloFrame()
    {
        message = "Hello, World!";
        label = new JLabel(message);
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(0,1));
        
        smallerButton = new JButton("Smaller"); 
        smallListener = new SmallerFontListener();
        smallerButton.addActionListener(smallListener);
        
        largerButton = new JButton("Larger"); 
        largeListener = new LargerFontListener();
        largerButton.addActionListener(largeListener);
        
        southPanel.add(smallerButton);
        southPanel.add(largerButton);

        add(label, BorderLayout.CENTER);
        add(southPanel, BorderLayout.EAST);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }
    
    class LargerFontListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event) 
        {
            fontSizeFactor = 1.25 * fontSizeFactor;
            label.setFont(new Font("Serif", Font.PLAIN,
                (int) (DEFAULT_SIZE * fontSizeFactor)));
            label.repaint();
        } 
    }
    class SmallerFontListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event) 
        {
            fontSizeFactor = .75 * fontSizeFactor;
            label.setFont(new Font("Serif", Font.PLAIN,
                (int) (DEFAULT_SIZE * fontSizeFactor)));
            label.repaint();
        } 
    }
}

