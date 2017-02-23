/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_06_question_01;

import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author Quayle
 */
public class Assignment_06_Question_01 {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args)
   {
      int x = getInt();
      System.out.println(x);
   }
    public static int getInt() 
    {
        
        Scanner input = new Scanner(System.in); 
        System.out.print("Please Enter an Integer: ");

        /* QUESTION 1.1 */ 
//        if (!input.hasNextInt()) { throw new IllegalArgumentException();  }
        /* END QUESTION 1.1 */
        
        /* QUESTION 1.2 */ 
        try
        {
            if (!input.hasNextInt()) { throw new IOException("Invalid Input");  }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        /* END QUESTION 1.2 */
        int temp = input.nextInt();
        
        return temp;
   }

    
}
