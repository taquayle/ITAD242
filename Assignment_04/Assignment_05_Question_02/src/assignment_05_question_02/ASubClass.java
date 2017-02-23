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
public class ASubClass extends AClass
{
   private int adprivate;
   protected int asprotected;
   public int aspublic;
   int aspackage;

   /**
      Think about these declarations
   */
   BClass bobj = new BClass();
   CClass cobj = new CClass();

   /**
      Constructor for objects of class ASubClass
   */
   public ASubClass()
   {
      // Initialize instance variables
      //asprivate = 1;    //Cannot assign this variable, as it's private;
      asprotected = 2;
      aspublic = 3;
      aspackage = 4;
   }

   public int addem()
   {
    // System.out.println(bobj.bprivate);     
        //Cannot access Private Directly
      
    System.out.println(bobj.bprotected); 
        // Protected, can be accessed by any subclasses without need for get methods
    
    System.out.println(bobj.bpublic);
        // Public variable, can be accessed by anything at anytime
    
    System.out.println(bobj.bpackage);
        // Package variable, can be accessed by any class in the package, but no
      
    //System.out.println(cobj.cprivate);  
        //Cannot access Private Directly
    
    //System.out.println(cobj.cprotected);
        // Cannot be accessed, as ASub does not extend CClass so protected are not accessable
    
    System.out.println(cobj.cpublic);
        // Public variable, can be accessed by anything at anytime
    
    //System.out.println(cobj.cpackage);
        // Cpackage cannot be accessed outside of CClass
   
    // System.out.println(aprivate);
        // Private variable, cannot be accessed
    
    System.out.println(aprotected);
        // Protected, can be accessed by ASub, since it is subclass
    
    System.out.println(apublic);
        // Public, can be accessed at anytime
    
    System.out.println(apackage);
        // ASub is subclass of A, can access AClass
      return adprivate + asprotected + aspublic + aspackage
         + aprotected + apublic + apackage;
   }
}
