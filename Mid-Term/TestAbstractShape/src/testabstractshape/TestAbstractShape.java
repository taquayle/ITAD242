/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testabstractshape;

/**
 *
 * @author s-Tyler.Quayle
 */
public class TestAbstractShape {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Shape s1 = new Circle(5.5, "RED", false);  // Upcast Circle to Shape
System.out.println(s1);                    // which version?: shape.toString
System.out.println(s1.getArea());          // which version?: circle.getArea
System.out.println(s1.getPerimeter());     // which version?: circle.getPerimeter
System.out.println(s1.getColor());
System.out.println(s1.isFilled());
//System.out.println(s1.getRadius());     //Compiler Error, shape does not have getRadius method
                                          //or an abstract version to allow Circle.getRadius to be used
   
Circle c1 = (Circle)s1;                   // Downcast back to Circle
System.out.println(c1);
System.out.println(c1.getArea());           
System.out.println(c1.getPerimeter());
System.out.println(c1.getColor());
System.out.println(c1.isFilled());
System.out.println(c1.getRadius());
   
//Shape s2 = new Shape();   // Compiler Error as Shape is abstract therefore cannot be instantiated
   
Shape s3 = new Rectangle(1.0, 2.0, "RED", false);   // Upcast
System.out.println(s3);
System.out.println(s3.getArea());
System.out.println(s3.getPerimeter());
System.out.println(s3.getColor());
//System.out.println(s3.getLength()); // Compiler Error, shape does not have getLength method
                                      // or an Abstract version to allow rectangle.getLength to be used
   
Rectangle r1 = (Rectangle)s3;   // downcast
System.out.println(r1);
System.out.println(r1.getArea());
System.out.println(r1.getColor());
System.out.println(r1.getLength());
   
Shape s4 = new Square(6.6);     // Upcast
System.out.println(s4);
System.out.println(s4.getArea());
System.out.println(s4.getColor());
//System.out.println(s4.getSide()); // Compiler Error as shape does not have a getSide() method
                                    // or an abstract version which would than allow compiler
                                    // to use Rectangle.getSide(). Which would mean that
                                    // Rectangle class would also need abstract method
  
// Take note that we downcast Shape s4 to Rectangle, 
//  which is a superclass of Square, instead of Square
Rectangle r2 = (Rectangle)s4;
System.out.println(r2);
System.out.println(r2.getArea());
System.out.println(r2.getColor());
//System.out.println(r2.getSide()); //Compiler Error as Rectangle does not have getSide() method
System.out.println(r2.getLength());
   
// Downcast Rectangle r2 to Square
Square sq1 = (Square)r2;
System.out.println(sq1);
System.out.println(sq1.getArea());
System.out.println(sq1.getColor());
System.out.println(sq1.getSide());
System.out.println(sq1.getLength());

    }
    
}
