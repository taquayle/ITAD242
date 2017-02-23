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
abstract class Shape {
    protected String color;
    protected Boolean filled;
    public Shape() {
        color = "red";
        filled = true;
    }
    public Shape(String color, Boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Boolean isFilled() {
        return filled;
    }
    public void setFilled(Boolean filled) {
        this.filled = filled;
    }
    public String toString() {
        String notString;
        if (filled) {
            notString = "";
        }
        else {
            notString ="not ";
        }
        return ("A shape with the color of "+ color + " which is "+ notString + "filled");
    }
    
    abstract double getArea();
    abstract double getPerimeter();

            
}
