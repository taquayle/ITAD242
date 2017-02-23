/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_04_tyler_quayle;

/**
 *
 * @author Quayle
 */
import java.util.ArrayList;

public class ArrayListRunner
{
   public static void main(String[] args)
   {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Alice");
        names.add("Bob");
        names.add("Connie");
        names.add("David");
        names.add("Edward");
        names.add("Fran");
        names.add("Gomez");
        names.add("Harry");
        System.out.println("Part A: " + names);
        System.out.println("Part B: " + names.get(0) +  ", " + names.get(7));
        System.out.println("Part C: " + names.size());
        System.out.println("Part D: " + names.get(names.size()-1));
        names.set(0, "Alice B. Toklas");
        System.out.println("Part E: " + names);
        names.add(4, "Doug");
        System.out.println("Part F: " + names);
        System.out.print("Part G: ");
        for(String output : names)
            System.out.print(output + ", ");
        ArrayList<String> names2 = new ArrayList<String>(names);
        System.out.println("\nPart H: " + names2);
        names.remove(0);
        System.out.println("Part I: " + names);
        System.out.println("Part I: " + names2);
   }
} 

