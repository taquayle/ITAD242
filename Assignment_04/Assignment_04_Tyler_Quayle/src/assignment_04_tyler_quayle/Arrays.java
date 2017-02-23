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
    //              Question 01                 //
    /********************************************/
public class Arrays
{
   public static void main(String[] args)
   {
      double[] x = {8, 4, 5, 21, 7, 9, 18, 2, 100};
      System.out.println("Before rotation:  ==============================");
      for (int i = 0; i < x.length; i++)
      {
         System.out.println("x[" + i + "]:  " + x[i]);
      }
      x = rotate(x, 3);
      System.out.println("After rotation:  ==============================");       
      for (int i = 0; i < x.length; i++)
      {
         System.out.println("x[" + i + "]:  " + x[i]);
      } 
   }
   
 public static double[] rotate(double[] x, int k){
      reverse(x, 0,  x.length -1);
       reverse(x, 0, k-1);
     reverse(x, k, x.length-1);
        return x;
    }
    public static void reverse(double[] x, int start, int end){
        while(start < end){
                swap(x, start, end);
                start++;
                end--;
        }
    }
    public static void swap(double[] a, int pos1, int pos2){
        double temp = a[pos1];
        a[pos1]= a[pos2];
        a[pos2] = temp;
    }
}

   
