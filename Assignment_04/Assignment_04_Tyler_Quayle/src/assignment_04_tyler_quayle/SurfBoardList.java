/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_04_tyler_quayle;


import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author Quayle
 */
public class SurfBoardList{
    static class surfBoard
    {
        private final int lastSerialNumber = 10000;
        private int serialNumber;
        
        public surfBoard(int serial)
        {
            serialNumber = serial;
        }
        
        @Override public String toString()
        {
            return "Serial Number: " + serialNumber + 
                   "\t out of " + lastSerialNumber;
        }
    }
    public static void main(String[] args)
    {
        ArrayList<surfBoard> surfBoardList = new ArrayList<surfBoard>();
        Scanner uInput = new Scanner(System.in);
        char answer;
        int i = 1;
        do{
            System.out.println("Enter Y to create a surfboard or N to exit");
            answer = uInput.next().charAt(0);
            if(answer == 'y' || answer == 'Y')
            {
                surfBoard newBoard = new surfBoard(i++);
                surfBoardList.add(newBoard);
                System.out.println("Surfboard Created");
            }
            else if(answer == 'n' || answer == 'N')
                System.out.println("N entered, current list of boards:");
            else{
                System.out.println("Error: Invalid input");
                answer = 'y';}
            
        }while (answer == 'y' || answer == 'Y');
        
        for(surfBoard output : surfBoardList)
            System.out.println(output);
    }
}
