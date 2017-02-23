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
public class MyCircle {
    private MyPoint center;
    private int radius;
    
    //  Default Contructor
    public MyCircle() { center = new MyPoint(); radius = 1; }
    
    //  Assignment Constructor, accepting obj of type MyPoint and Int
    public MyCircle(MyPoint _center, int _radius) 
    {
        center = new MyPoint(_center.getX(), _center.getY());
        radius = _radius;
    }
    
    //  Get and Set radius methods
    public int getRadius() { return radius; }
    public void setRadius(int _radius) { radius = _radius; }
    
    // Get and Set center methods that accept and return objects of type MyPoint
    public MyPoint getCenter() { return center; }
    public void setCenter(MyPoint _center)
    { center = new MyPoint(_center.getX(), _center.getY()); }
    
    // Get Center X and Y using the MyPoint.getX() and MyPoint.getY() methods
    public int getCenterX() { return center.getX(); }
    public int getCenterY() { return center.getY(); }
    
    // Set Center by accepting in 2 ints and calling MyPoint.set methods
    public void setCenterXY( int _x, int _y){ center.setX(_x); center.setY(_y);}
    
    //@override
    public String toString() 
    {return String.format("Circle @ " + center + " radius = " + radius);}
    
    //  Returns type double of area. Area equation = r^2*PI
    public double getArea(){ return (Math.pow(radius, 2) * Math.PI);}
}
