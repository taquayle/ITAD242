/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carsmover;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Tyler Quayle
 */
/**
 * This component displays a car that can be moved.
 */
public class CarComponent extends JComponent {

    private Car car;
    private Color bodyColor;
    
    public CarComponent() {
        // The rectangle that the paint method draws 
        car = new Car(0, 0);
    }
    
    public CarComponent(int x, int y, Color _bodyColor)
    {
        bodyColor = _bodyColor;
        car = new Car(x, y);
    }
    
    public void paintComponent(Graphics g) {
        g.setColor(bodyColor);
        car.draw(g);
    }

    /**
     * Moves the rectangle by a given amount.
     *
     * @param x the amount to move in the x-direction
     * @param y the amount to move in the y-direction
     */
    public void moveCarBy(int dx, int dy) {
        car.translate(dx, dy);
        repaint();
    }

}
