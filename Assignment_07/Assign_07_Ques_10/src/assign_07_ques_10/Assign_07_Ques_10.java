/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assign_07_ques_10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;


/**
 *
 * @author Quayle
 */
public class Assign_07_Ques_10 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) 
    {
        final JFrame frame = new JFrame();
        frame.setSize(new Dimension(400,400));
        frame.setTitle("Mouse Listener Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.RED);
       
        class EnterExitListener implements MouseListener
        {

            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               System.out.println("Mouse Entered");
         
               frame.getContentPane().setBackground(Color.BLUE);
               frame.repaint();

            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("Mouse Exited");
                frame.getContentPane().setBackground(Color.RED);
                frame.repaint();
            }
        }
        final MouseListener frameListener = new EnterExitListener();
        frame.addMouseListener(frameListener);
    }
       
}


    
    

