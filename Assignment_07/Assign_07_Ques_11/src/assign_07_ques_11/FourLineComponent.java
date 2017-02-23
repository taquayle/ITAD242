/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assign_07_ques_11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Quayle
 */
public class FourLineComponent extends JPanel implements MouseListener {
    
    private int mouseX;
    private int mouseY;
    FourLineComponent(int width, int height) {
        super();
        setPreferredSize(new Dimension(width,height));
        mouseX = 50;
        mouseY = 100;
        addMouseListener(this);
    }
    
    public void setXY(int x, int y)
    {
        mouseX = x; mouseY = y;
    }

    @Override
    public void paintComponent(Graphics g) 
    {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.black);
        
        g.drawLine(mouseX, mouseY, 0, 0);                      //Top Left
        g.drawLine(mouseX, mouseY, 0, getHeight());            //Bottom Left
        g.drawLine(mouseX, mouseY, getWidth(), 0);             //Top Right
        g.drawLine(mouseX, mouseY, getWidth(), getHeight());   //Bottom Right
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse Clicked at (" + e.getX() + ", " + e.getY() + ")");
        setXY (e.getX(),e.getY());
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
