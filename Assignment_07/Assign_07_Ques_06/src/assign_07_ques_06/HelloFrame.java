/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assign_07_ques_06;

/**
 *
 * @author Quayle
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class HelloFrame extends JFrame
{   
   private String message;
   private JLabel label;
   private JMenuBar menuBar;
   private JMenu fontMenu;
   private JMenuItem largerItem;
   private JMenuItem smallerItem;
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
        
        add(label, BorderLayout.CENTER);
        createMenu();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }
    
    public void createMenu()
    {
        menuBar = new JMenuBar(); 
        setJMenuBar(menuBar);  

        fontMenu = new JMenu("Font"); 
        menuBar.add(fontMenu);  

        largerItem = new JMenuItem("Larger"); 
        fontMenu.add(largerItem);  
        largeListener = new LargerFontListener();
        largerItem.addActionListener(largeListener);
        
        smallerItem = new JMenuItem("Smaller"); 
        fontMenu.add(smallerItem);
        smallListener = new SmallerFontListener();
        smallerItem.addActionListener(smallListener);

        setJMenuBar(menuBar);
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

