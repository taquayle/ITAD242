/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_05_question_03;

import java.util.*;

public class AnimalRunner
{
   public static void main(String[] args)
   {
      Speakable [] animalTalk = new Speakable[2];
      animalTalk[0] = new Dog("Fred");
      animalTalk[1] = new Cat("Wanda");
      for (Speakable obj : animalTalk)
      {
         obj.speak();
      }

   }
}
