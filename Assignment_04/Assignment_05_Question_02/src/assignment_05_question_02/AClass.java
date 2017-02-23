/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_05_question_02;

import assignment_05_question_02.temp.CClass;

/**
 *
 * @author Quayle
 */
public class AClass
{
   private int aprivate;
   protected int aprotected;
   public int apublic;
   int apackage;
   static int noAObjects = 0;

   /**
      Think about these declarations
   */
   BClass bobj = new BClass();
   CClass cobj = new CClass();

   /**
      Constructor for objects of class AClass.
   */
   public AClass()
   {
      // Initialize instance variables
      aprivate = 1;
      aprotected = 2;
      apublic = 3;
      apackage = 4;
      noAObjects ++;
   }

   public int addem()
   {
        //System.out.println(bobj.bprivate);
            // Cannot access, private variable
        
       System.out.println(bobj.bprotected);
            // Can access, protected can be accessed within package
        
        System.out.println(bobj.bpublic);
            // Public variable, can access
        
        System.out.println(bobj.bpackage);
            // Can Access public and in same package
        
        //System.out.println(cobj.cprivate);
            // Private, cannot access
        
        //System.out.println(cobj.cprotected);
            // Protected in different package. cannot access
        
        System.out.println(cobj.cpublic);
            // Public cannot access
        
        //System.out.println(cobj.cpackage);
            // Different package, cannot access
        
      return aprivate + aprotected + apublic + apackage;
   }
}

