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
public class Circle implements ShapeMeasurer {

    protected double radius;
    //NEEDED TO ADD THESE SINCE SHAPE IS NOW MISSING
    protected String color;
    protected boolean filled;
    
    public Circle() {
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }
    
    //  ADDED CONSTRUCTOR AS PER THE UML DIAGRAM
    public Circle(double radius, String color, Boolean filled) {
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }
    
    //  NEEDED TO ADD SETCOLOR AND SETFILLED SINCE SHAPE IS NOW MISSING
    public void setColor(String color) { this.color = color; }
    public void setFilled(boolean filled) { this.filled = filled; }
    
    public double getRadius() {
        return radius;

    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return (radius * radius * Math.PI);
    }

    public double getPerimeter() {
        return (2 * radius * Math.PI);
    }

    @Override
    public String toString() {
        return ("A Circle with radius=" + radius);
    }
}
