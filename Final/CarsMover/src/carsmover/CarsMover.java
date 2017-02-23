/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carsmover;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Tyler Quayle
 */
public class CarsMover {

    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 400;
    private static final int CAR_HEIGHT = 40;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame();

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(new GridLayout(3,1));
        frame.setTitle("CarMover");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final CarComponent component = new CarComponent();
        component.setPreferredSize(new Dimension(FRAME_WIDTH, CAR_HEIGHT));
        
        final CarComponent blueCar = new CarComponent(FRAME_WIDTH-80, 0, Color.BLUE);
        component.setPreferredSize(new Dimension(FRAME_WIDTH, CAR_HEIGHT));
        
        
        final CarComponent redCar = new CarComponent(0,0, Color.RED);
        component.setPreferredSize(new Dimension(FRAME_WIDTH, CAR_HEIGHT));
        
        frame.add(component);
        frame.add(blueCar);
        frame.add(redCar);
        frame.setVisible(true);

        class TimerListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {
                component.moveCarBy(5, 0);
                component.repaint();
                blueCar.moveCarBy(-5,0);
                blueCar.repaint();
                redCar.moveCarBy(5,0);
                redCar.repaint();
            }
        }
        ActionListener listener = new TimerListener();

        final int DELAY = 100; // Milliseconds between timer ticks
        Timer t = new Timer(DELAY, listener);
        t.start();
    }

}
