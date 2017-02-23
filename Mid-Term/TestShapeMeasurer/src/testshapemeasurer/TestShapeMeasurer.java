/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testshapemeasurer;

import java.util.ArrayList;

/**
 *
 * @author s-Tyler.Quayle
 */
public class TestShapeMeasurer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<ShapeMeasurer> shapeList = new ArrayList<ShapeMeasurer>();
      
        //  CREATING CIRCLES USING ALL THREE CONSTRUCTORS
        shapeList.add(new Circle());
        shapeList.add(new Circle(1));
        shapeList.add(new Circle(2, "RED", false));
        //  CREATING RECTANGLES USING ALL THREE CONSTRUCTORS
        shapeList.add(new Rectangle());
        shapeList.add(new Rectangle(3,4));
        shapeList.add(new Rectangle(5,6,"BLUE", false));
        //  CREATING SQUARES USING ALL THREE CONSTUCTORS
        shapeList.add(new Square());
        shapeList.add(new Square(7));
        shapeList.add(new Square(8,"GREEN", true));
        
        // For loop to display all interface methods
        for(int i = 0; i < shapeList.size(); i++)
            System.out.println("Area: " + shapeList.get(i).getArea() +
                               " - Perimeter " + shapeList.get(i).getPerimeter());
        
        // Enhanced for loop to display all toString functions
        for(ShapeMeasurer display : shapeList)
            System.out.println(display);
    }
}
