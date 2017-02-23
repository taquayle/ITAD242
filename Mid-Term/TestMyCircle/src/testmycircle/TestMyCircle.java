/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testmycircle;

/**
 *
 * @author s-Tyler.Quayle
 */
public class TestMyCircle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //  Creating MyCircle array with size for 2 obj's
        MyCircle[] circleArray = new MyCircle[2];
        
        //  Setting First circle to Center(2,3) Radius of 5
        //  Second circle to Center(0,0) Radius of 7
        circleArray[0] = new MyCircle(new MyPoint(2,3), 5);
        circleArray[1] = new MyCircle(new MyPoint(), 7);
        
        //  Display Circles
        displayCircles(circleArray);
        
        //  Set Radius of first Circle to 29
        //  Set Center of second circle to (1, 1)
        circleArray[0].setRadius(29);
        circleArray[1].setCenterXY(1, 1);
        
        //  Display Circles
        displayCircles(circleArray);
        
        //  Set second circles center to same as first circle center
        //  using the getCenter() and setCenter(MyPoint) methods
        circleArray[1].setCenter(circleArray[0].getCenter());
        
        //  Display Circles
        displayCircles(circleArray);
        
    }
    
    //Method created to forgo using multiple Enhanced for loops
    public static void displayCircles(MyCircle[] display)
    {
        for(MyCircle displayer : display)
            System.out.println(displayer);
    }
}
