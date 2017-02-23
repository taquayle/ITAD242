/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testarraylistmethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 *
 * @author Tyler Quayle
 */
public class TestArrayListMethods {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<Integer> sortMerge(ArrayList<Integer> a, ArrayList<Integer> b) {
        // Your algorithm goes here
        ArrayList<Integer> resultArrayList = a;
        
        for(Integer step : b)
            resultArrayList.add(step);
        
        Collections.sort(resultArrayList);
        
        return resultArrayList; // This needs to be declared of course
    }

    
    public static void main(String[] args) {
        // TODO code application logic here
        // Declaration of the ArrayLists used (ArrayList<Integer>)
         ArrayList<Integer> aList = new ArrayList<Integer>();
         ArrayList<Integer> bList = new ArrayList<Integer>();
        
        // Read in values from the console for the first ArrayList 
        //(finished when a simple return with no value given)
        Scanner sc = new Scanner(System.in);
        String line = "";
        System.out.print("Input a number for List A: ");
        while (sc.hasNextLine() && !(line = sc.nextLine()).equals("")) {
            System.out.print("Input a number for List A: ");
            int val = Integer.parseInt(line);      
            aList.add(val);
        }
        
        // Read in values from the console for the second ArrayList 
        //(finished when a simple return with no value given)
        System.out.print("\nInput a number for List B: ");
        while (sc.hasNextLine() && !(line = sc.nextLine()).equals("")) {
            System.out.print("Input a number for List B: ");
            int val = Integer.parseInt(line);      
            bList.add(val);
        }
        // Sort each ArrayList separately
        Collections.sort(bList);
        Collections.sort(aList);
        // Merge the sorted lists
        
        // Initialize array list b to some values
        
        ArrayList<Integer> sortedArray = sortMerge(aList, bList);

        System.out.println("Result of merge sort of sortedOne and sortedTwo is: ");
        //Use the enhanced for loop to display the result, numbers separated by commas
        for(Integer output : sortedArray)
            System.out.print(output + " ");
        
        }

    }
