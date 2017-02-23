/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testmypoint;

/**
 *
 * @author s-Tyler.Quayle
 */
public class TestMyPoint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //  Creating first point with default constructor to (0,0)
        MyPoint pointOne = new MyPoint();
        //  Creating second point to assignment constructor to (-3,2)
        MyPoint pointTwo = new MyPoint(-3,2);
        
        //  Output both points
        System.out.println(pointOne);
        System.out.println(pointTwo);
        
        //  Setting first point to be new values of (3, -2)
        pointOne.setX(3);
        pointOne.setY(-2);
        
        System.out.println(pointOne + " has X-Coordinate @ " + pointOne.getX() +
                   " and Y-Coordinate @ " + pointOne.getY());
        
        System.out.println(pointTwo + " has X-Coordinate @ " + pointTwo.getX() +
                           " and Y-Coordinate @ " + pointTwo.getY());
        
        System.out.println("Distance between " + pointOne + " and " + pointTwo +
                           "is: " + pointOne.distance(pointTwo));
        // TODO code application logic here
    }
    
}
