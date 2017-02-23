/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_06_question_02;

import java.util.Scanner;

/**
 *
 * @author Quayle
 */
public class Assignment_06_Question_02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
   {
        Scanner input = new Scanner(System.in); 
       
        /* QUESTION 2.1 */ 
        
//        System.out.print("Please Enter an Integer: ");
//        
//        while (!input.hasNextInt()) { 
//        System.out.print("ERROR - Please enter a number: ");
//        input.next();}
//        
//        int x = input.nextInt();
//        System.out.println(x);   

        /* END QUESTION 2.1 */
        
        /* QUESTION 2.2 */ 
        int x;
        while(true)
        {
            System.out.print("Please Enter an Integer: ");
            try
            {
                if (!input.hasNextInt()) { throw new Exception();}
                x = input.nextInt();
                System.out.println(x);
                break;
            }
        
            catch(Exception e)
            {  
                System.out.println("Error: Invalid input");
                input.next();

            }
        }
        /* END QUESTION 2.2 */  
   }
}
