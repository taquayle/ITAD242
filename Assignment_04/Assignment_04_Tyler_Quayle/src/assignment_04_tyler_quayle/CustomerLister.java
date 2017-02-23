/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_04_tyler_quayle;

import java.util.Scanner;

/**
 *
 * @author Quayle
 */

    /********************************************/
    //              Question 02                 //
    /********************************************/

public class CustomerLister {
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String[] customerName = {"Cathy", "Ben", "Jorge", "Wanda", "Freddie"};
        double[] customerBalance = new double[5];
        
        for(int i = 0; i < customerName.length; i++)
        {
            System.out.print("Input balance for " + customerName[i] + ": ");
            customerBalance[i] = input.nextDouble();
        }
        
        for(int i = 0; i < customerName.length; i++)
            System.out.println(customerName[i] + "\t:\t$" + customerBalance[i]);
    }
    
}
