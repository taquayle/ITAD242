/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assign_07_ques_11;

import javax.swing.JFrame;

/**
 *
 * @author Quayle
 */
public class FourLineComponentViewer {
    public static void main(String[] args) 
    {
        final int FRAME_WIDTH = 400;
        final int FRAME_HEIGHT = 400;

        final JFrame frame = new JFrame();
        
        FourLineComponent lineComponent = new FourLineComponent(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.add(lineComponent);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
