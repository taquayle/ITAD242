/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assign_07_ques_07;

/**
 *
 * @author Quayle
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class HelloFrame extends JFrame
{   
    private String message;
    private JLabel label;
    private JPanel southPanel;
    private JComboBox comboBox;
    private ActionListener comboBoxListener;

    private static int FRAME_WIDTH = 300;
    private static int FRAME_HEIGHT = 300;
    private static int DEFAULT_SIZE = 20;
   
    private static double fontSizeFactor = 1;
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
        ActionListener CBListener = new comboBoxListener();
        comboBox = new JComboBox(); 
        comboBox.addItem("Small"); 
        comboBox.addItem("Medium"); 
        comboBox.addItem("Large"); 
        comboBox.addItem("Extra Large");
        southPanel = new JPanel(); 
        southPanel.add(comboBox); 
        comboBox.addActionListener(CBListener);
        add(southPanel, BorderLayout.SOUTH);

    }
    class comboBoxListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event) 
        {
            String item = (String) comboBox.getSelectedItem();
            int messageSize = DEFAULT_SIZE; 
            if (item.equals("Small")) { messageSize = SMALL_SIZE; } 
            else if (item.equals("Medium")) { messageSize = MEDIUM_SIZE; } 
            else if (item.equals("Large")) { messageSize = LARGE_SIZE; } 
            else if (item.equals("Extra Large")) { messageSize = EXTRA_LARGE_SIZE; }
            label.setFont(new Font("Serif", Font.PLAIN, messageSize));
            label.repaint();

        } 
    }
}

