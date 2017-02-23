package carsmover;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Tyler Quayle
 */
/**
 * A car shape that can be positioned anywhere on the screen.
 */
public class Car {

    private int xLeft;
    private int yTop;

    /**
     * Constructs a car with a given top left corner
     *
     * @param x the x coordinate of the top left corner
     * @param y the y coordinate of the top left corner
     */
    public Car(int x, int y) {
        xLeft = x;
        yTop = y;
    }

    /**
     * Moves this car by a given distance.
     *
     * @param dx the distance in x-direction
     * @param dy the distance in y-direction
     */
    public void translate(int dx, int dy) {
        xLeft = xLeft + dx;
        yTop = yTop + dy;
    }

    /**
     * Draws the car.
     *
     * @param g the graphics context
     */
    public void draw(Graphics g) {
        g.drawRect(xLeft, yTop + 10, 60, 10);
        g.drawOval(xLeft + 10, yTop + 20, 10, 10);
        g.drawOval(xLeft + 40, yTop + 20, 10, 10);

        g.drawLine(xLeft + 10, yTop + 10, xLeft + 20, yTop);
        g.drawLine(xLeft + 20, yTop, xLeft + 40, yTop);
        g.drawLine(xLeft + 40, yTop, xLeft + 50, yTop + 10);
    }
}
