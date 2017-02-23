/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testabstractshape;

/**
 *
 * @author 
 */
public class Circle extends Shape {

    protected double radius;

    public Circle() {
        super();
        radius = 1.0;
    }

    public Circle(double radius) {
        super();
        this.radius = radius;
    }
    
    //  ADDED CONSTRUCTOR AS PER THE UML DIAGRAM
    public Circle(double radius, String color, Boolean filled) {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }
    
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
        return ("A Circle with radius=" + radius + ", which is a subclass of " + super.toString());
    }
}
