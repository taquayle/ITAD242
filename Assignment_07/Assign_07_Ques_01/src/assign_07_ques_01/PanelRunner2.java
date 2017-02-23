/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assign_07_ques_01;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
/**
 *
 * @author Quayle
 */
public class PanelRunner2
{
 
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Color Panels");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(1200, 1000));
        panel.setLayout(new BorderLayout());
        
        GridLayout center_Layout = new GridLayout(1,0);
        JPanel center_panel = new JPanel();
        center_panel.setPreferredSize(new Dimension(400, 200));
        center_panel.setLayout(center_Layout);
        
        JPanel subpanelRed = new JPanel();
        subpanelRed.setPreferredSize(new Dimension(200, 200));
        subpanelRed.setBackground(Color.RED);

        JPanel subpanelWhite = new JPanel();
        subpanelWhite.setPreferredSize(new Dimension(200, 200));
        subpanelWhite.setBackground(Color.WHITE);

        JPanel subpanelBlue = new JPanel();
        subpanelBlue.setPreferredSize(new Dimension(200, 200));
        subpanelBlue.setBackground(Color.BLUE);

        JPanel subpanelGreen = new JPanel();
        subpanelGreen.setPreferredSize(new Dimension(200, 200));
        subpanelGreen.setBackground(Color.GREEN);

        JPanel subpanelYellow = new JPanel();
        subpanelYellow.setPreferredSize(new Dimension(200, 200));
        subpanelYellow.setBackground(Color.YELLOW);

        JPanel subpanelOrange = new JPanel();
        subpanelOrange.setPreferredSize(new Dimension(200, 200));
        subpanelOrange.setBackground(Color.ORANGE);

        center_panel.add(subpanelBlue);
        center_panel.add(subpanelGreen);
        
        panel.add(subpanelRed, BorderLayout.NORTH);
        panel.add(subpanelWhite, BorderLayout.WEST);
        panel.add(center_panel, BorderLayout.CENTER);
        panel.add(subpanelYellow, BorderLayout.EAST);
        panel.add(subpanelOrange, BorderLayout.SOUTH);
        
        
        frame.add(panel);
       
        frame.setVisible(true);
    }   
}
