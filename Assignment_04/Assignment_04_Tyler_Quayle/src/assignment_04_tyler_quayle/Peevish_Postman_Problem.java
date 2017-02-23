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

    /********************************************/
    //              Question 03                 //
    /********************************************/
public class Peevish_Postman_Problem {
    
    public static void main(String[] args)
    {
    boolean[] doors = new boolean[101]; //defaulted to false;

    for(int i = 1; i < 101; i++)
        for(int j = 1; j < 101; j++)
            if(j % i == 0)doors[j] = !doors[j];
        
    
    System.out.println("Doors that are open: ");
    for(int j = 1; j < 101; j++)
        if(doors[j] == true) System.out.print(j + " ");
            
          
        
    }    
}


