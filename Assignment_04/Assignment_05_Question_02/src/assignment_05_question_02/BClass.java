/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_05_question_02;

/**
 *
 * @author Quayle
 */
public class BClass
{
   private int bprivate;
   protected int bprotected;
   public int bpublic;
   int bpackage;

   /**
      Constructor for objects of class BClass.
   */
   public BClass()
   {
      // Initialize instance variables
      bprivate = 1;
      bprotected = 2;
      bpublic = 3;
      bpackage = 4;
   }

   public int addem()
   {
      return bprivate + bprotected + bpublic + bpackage;
   }
}
