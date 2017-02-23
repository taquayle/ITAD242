/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_05_question_02.temp;

/**
 *
 * @author Quayle
 */
public class CClass 
{
   private int cprivate;
   protected int cprotected;
   public int cpublic;
   int cpackage;

   /**
      Constructor for objects of class CClass
   */
   public CClass() 
   {
      // Initialize instance variables
      cprivate = 1;
      cprotected = 2;
      cpublic = 3;
      cpackage = 4;
   }

   public int addem()
   {
      return cprivate + cprotected + cpublic + cpackage;
   }
}

