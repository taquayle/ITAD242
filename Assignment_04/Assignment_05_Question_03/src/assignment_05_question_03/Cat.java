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
public class Cat implements Speakable
{
   private final String name;

   public Cat(String name)
   {
      this.name = name;
   }

   public void speak()
   {
     System.out.println("Meow! Meow!");
   }

   public String toString()
   {
      return "Cat:  " + name;
   }
}
