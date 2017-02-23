/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_05_question_03;

/**
 *
 * @author Quayle
 */
public class Dog implements Speakable
{
   private String name;

   public Dog(String name)
   {
      this.name = name;
   }

   public void speak()
   {
     System.out.println("Woof! Woof!");
   }

   public String toString()
   {
      return "Dog:  " + name;
   }
}

