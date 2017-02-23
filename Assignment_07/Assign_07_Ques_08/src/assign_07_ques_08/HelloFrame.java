/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assign_07_ques_08;

/**
 *
 * @author Quayle
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class HelloFrame extends JFrame
{   
    private String message;
    private JLabel label;
    private JRadioButton helloButton;
    private JRadioButton goodbyeButton;
    private JCheckBox cruelCheckBox;
    private JPanel southPanel;
    
    private static int FRAME_WIDTH = 300;
    private static int FRAME_HEIGHT = 300;
    private static int DEFAULT_SIZE = 20;
   
    public static final int SMALL_SIZE = 12; 
    public static final int MEDIUM_SIZE = 18; 
    public static final int LARGE_SIZE = 24; 
    public static final int EXTRA_LARGE_SIZE = 36;


    public HelloFrame()
    {
        message = "Hello, World!";
        label = new JLabel(message);
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        
        add(label, BorderLayout.CENTER);
        createSouthPanel();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }
    
    public void createSouthPanel()
    {
        ButtonGroup group = new ButtonGroup(); 
        ActionListener mesListener = new messageListener();
        
        cruelCheckBox = new JCheckBox("Cruel");
        cruelCheckBox.addActionListener(mesListener);
        
        helloButton = new JRadioButton("Hello");
        helloButton.addActionListener(mesListener);
        
        goodbyeButton = new JRadioButton("Goodbye");
        goodbyeButton.addActionListener(mesListener);
       
        group.add(helloButton); 
        group.add(goodbyeButton); 
        helloButton.setSelected(true);
        
        southPanel = new JPanel(); 
        southPanel.add(helloButton); 
        southPanel.add(goodbyeButton); 
        southPanel.add(cruelCheckBox);
        add(southPanel, BorderLayout.SOUTH);

    }
    class messageListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event) 
        {
            String message = ""; 
            if (helloButton.isSelected()) { message = "Hello, "; }
            else if (goodbyeButton.isSelected()) { message = "Goodbye, "; }
            if (cruelCheckBox.isSelected()) { message = message + " Cruel";} 
            message = message + " World!"; 
            label.setText(message); 
        } 
    }
}

