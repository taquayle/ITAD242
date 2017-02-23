/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assign_07_ques_03;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Quayle
 */
public class ColorFrame extends JFrame{
    private JLabel Label1;
    private JLabel Label2;
    private JLabel Label3;
    private JComboBox red;
    private JComboBox green;
    private JComboBox blue;
    private final int MAX_COUNT = 255;
    private ActionListener listener;
    Container contentPane ;

    public ColorFrame()
    {
        super("Color Frame");
        listener = new ChoiceListener();
        colorComboBox(); 
    }

    class ChoiceListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            setColor();
        }
    }


    public JComboBox redBox()
    {
        red = new JComboBox();
        red.setPreferredSize(new Dimension(10,20));
        for (int i = 0; i <= MAX_COUNT; i++)
            red.addItem(i);
        red.setEditable(false);
        red.addActionListener(listener);
        return red;
    }

    public JComboBox greenBox()
    {
        green = new JComboBox();
        green.setPreferredSize(new Dimension(10,20));
        for (int i = 0; i <= MAX_COUNT; i++)
            green.addItem(i);
     
        green.setEditable(false);
        green.addActionListener(listener);
        return green;
    }

    public JComboBox blueBox()
    {
        blue = new JComboBox();
        blue.setPreferredSize(new Dimension(10,20));
        for (int i = 0; i <= MAX_COUNT; i++)
            blue.addItem(i);
        blue.setEditable(false);
        blue.addActionListener(listener);
        return blue;
    }

    public void colorComboBox()
    {
        GridLayout boxes = new GridLayout(3,1);
        setLayout(boxes);
        Label1 = new JLabel("Red");
        Label2 = new JLabel("Green");
        Label3 = new JLabel("Blue");

        add(Label1);
        add(redBox());
        add(Label2);
        add(greenBox());
        add(Label3);
        add(blueBox());
    }

    public void setColor()
    {
        int red_number = (int) red.getSelectedItem();
        int green_number = (int) green.getSelectedItem();
        int blue_number = (int) blue.getSelectedItem();
        getContentPane().setBackground(new Color(red_number, green_number, blue_number));
        repaint();
    }
}
