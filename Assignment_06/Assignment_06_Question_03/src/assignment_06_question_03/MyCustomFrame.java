/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_06_question_03;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Quayle
 */
public class MyCustomFrame extends JFrame implements ActionListener{
    
    private JFrame frame = new JFrame();
    private JButton newButton = new JButton();
    private JPanel panel = new JPanel();
    private boolean switchToggle = true;
    private String buttonText, buttonToggleText, labelText, labelToggleText;
    private final int FRAME_WIDTH = 350, FRAME_HEIGHT = 100;
    
    // DEFAULT CONSTRUCTOR TO SET THE FRAME UP
    public MyCustomFrame()
    {
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("A Button to click System ON or OFF");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    //SETS THE BUTTON TEXT AND THE TEXT WHEN BUTTON IS PRESSED
    public void setButtonText(String t) { buttonText = t; }
    public void setButtonToggleText(String t) { buttonToggleText = t; }
    
    //SETS THE LABEL TEXT AND THE TEXT WHEN BUTTON IS PRESSED
    public void setLabelText(String t) { labelText = t; }
    public void setLabelToggleText(String t) { labelToggleText = t; }
    
    //USED TO CLEAR AND UPDATE PANELS WHEN BUTTON IS PRESSED, OTHERWISE IT
    //WILL KEEP ADDING MORE AND MORE TEXT WITHOUT CLEARING OLD TEXT
    public void updatePanel() { frame.add(panel);}
    public void clearPanel(){panel.removeAll(); panel.updateUI();}
    
    //SETS THE INTIAL STATE OF THE BUTTON
    public void addButton()
    {
        newButton.setText(buttonText);
        //used to create button of constant width
        //newButton.setPreferredSize(new Dimension(80,30)); 
        newButton.addActionListener(this);
        panel.add(newButton);
        updatePanel();
    }
    
    //SETS THE INTIAL STATE OF THE LABEL
    public void addLabel() {panel.add(new JLabel(labelText));}
    
    // ACTIONLISTENER TO CHECK IF BUTTON IS PRESSED AND UPDATES ACCORDINGLY
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        clearPanel();
        if(switchToggle)
        {
            newButton.setText(buttonToggleText);
            panel.add(newButton);
            panel.add(new JLabel(labelToggleText));
        }
        else
        {
            newButton.setText(buttonText);
            panel.add(newButton);
            panel.add(new JLabel(labelText));
        }
        updatePanel();
        switchToggle = !switchToggle;
    }
}

  