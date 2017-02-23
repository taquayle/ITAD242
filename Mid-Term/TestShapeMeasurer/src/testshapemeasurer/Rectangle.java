/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testshapemeasurer;

/**
 *
 * @author 
 */
public class Rectangle implements ShapeMeasurer {
    protected double width;
    protected double length;
    //NEEDED TO ADD THESE SINCE SHAPE IS NOW MISSING
    protected String color;
    protected boolean filled;
    
    public Rectangle () {
        super();
        width = 1.0;
        length = 1.0;
    }
    //  ADDED EXTRA CONSTRUCTOR AS PER THE UML DIAGRAM
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    public Rectangle(double width, double length, String color, Boolean filled) {
        this.width = width;
        this.length = length;
        this.color = color;
        this.filled = filled;
    }
    

   
    public double getWidth(){
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public double getArea() {
        return(width*length);
    }
    public double getPerimeter() {
        return (2*(width+length));
    }
    @Override
    public String toString() {
        return ("A Rectangle with width="+width+" and length="+length);
    }
}
