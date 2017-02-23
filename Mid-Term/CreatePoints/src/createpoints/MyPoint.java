/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package createpoints;

/**
 *
 * @author s-Tyler.Quayle
 */
public class MyPoint {


    /**
     * @param args the command line arguments
     */

    private int x;
    private int y;
   
//  Default constructor, setting x and y to Zero(0)
    public MyPoint(){ x = 0; y = 0;}
//    Constructor for assigning values private variables
    public MyPoint(int _x, int _y) {x = _x; y = _y; }

//   Functions for getting and setting X point 
    public int getX() { return x; }
    public void setX(int _x) { x = _x; }

//    Functions for getting and setting Y point
    public int getY() { return y; }
    public void setY(int _y) { y = _y; } 
//    Overriding toString() method, outputting of [MyPoint @ (x, y)]
    //@Overide
    public String toString() {  return String.format("MyPoint @ (" + x + ", " + y + ")"); }
//    Overloaded distance method with variables being two intergers 
    public double distance(int toCheckX, int toCheckY)
    { 
        int xDiff = this.x - toCheckX;
        int yDiff = this.y - toCheckY;
        return Math.sqrt( (xDiff * xDiff) + (yDiff * yDiff));
    }
//    Overloaded distance method with variable being Obj of type MyPoint
    public double distance(MyPoint input)
    {
        int xDiff = this.x - input.getX();
        int yDiff = this.y - input.getY();
        return Math.sqrt( (xDiff * xDiff) + (yDiff * yDiff));
    }
}
