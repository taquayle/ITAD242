/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package createpoints;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author s-Tyler.Quayle
 */
public class CreatePoints {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("How many points would you like to create: ");
        
        //  Int used to build arrayList of obj MyPoints
        int userInputNumber = userInput.nextInt();
        
        //  ArrayList of Class MyPoint
        ArrayList<MyPoint> listPoints = new ArrayList();
        
        //  For loop to build MyPoint instances and add them to the ArrayList 
        for(int i = 0; i < userInputNumber; i++)
        {
            MyPoint temp = new MyPoint(i+1, i+1);
            listPoints.add(temp);
        }
        
        //  Enhanced for loop to display ArrayList
        for(MyPoint displayMyPoints : listPoints)
            System.out.println(displayMyPoints);
       
        
        // TODO code application logic here
    }
    
}
