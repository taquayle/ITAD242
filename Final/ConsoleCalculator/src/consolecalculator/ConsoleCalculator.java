/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package consolecalculator;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Julien Feis Job Site
 */
public class ConsoleCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // The main program asks the user to give number 1
        // then reads in number 1
        // then asks the user to give number 2
        // then asks the user to give the operation wanted:
        // 'a','A', '+' for add, 's', 'S', '-' for subtract
        // Implement the decision with a switch statement
        // Make each input that is wrong throw an IOException with different message
        // Catch IOException and decide depending on the message what to tell the user
        // Loop up to 3 times until the user give the correct input, stop after the third try
        // Do the calculation and print the result
        // print finally "Goodbye" in any case
        Scanner sc = new Scanner(System.in);
        
        double inputOne = 0;
        double inputTwo = 0;
        
        inputOne = getNumber(1);
        inputTwo = getNumber(2);
        
        try{calculator(1, inputOne, inputTwo);}catch(IOException e){}
       
        System.out.println("\nGoodbye!");
    }
    
    public static void calculator(int tryNum, double a, double b) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        String regexAdd = "[aA+]";
        String regexSub = "[sS-]";
        if(tryNum < 4)
        {
            try{
            String temp;
            System.out.print("Pleas enter [a][A][+] for addition\n or [s][S][-] for subtraction\nInput:");
            temp = sc.next();
            if(temp.matches(regexAdd)) System.out.print("Addition: " + (a+b));
            
            else if(temp.matches(regexSub)) System.out.print("Subtraction: " + (a-b));
            
            else {throw new IOException("Your input was incorrect, try again");}
            
            }catch(IOException e)
                {System.out.println(e); 
                calculator(tryNum+1, a, b);}
        }   
    }
    
    public static double getNumber(int which)
    {
        double temp = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter for number " + which + ": ");
        try{temp = sc.nextDouble();}
        catch(Exception e){ System.out.println("Incorrect input");
                            getNumber(which);} 
        return temp;
    }
}
