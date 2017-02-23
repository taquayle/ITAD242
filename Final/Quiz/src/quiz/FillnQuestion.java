/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quiz;

/**
 *
 * @author s-Tyler.Quayle
 */
public class FillnQuestion extends Question{
    String answer;
    
    FillnQuestion(){}
    
    @Override
   public void setText(String questionText)   
   {
       questionText = questionText + " "; //Otherwise out of bounds exception
       String[] findAnswer = questionText.split("_");
       answer = findAnswer[1];
   
       super.setText(findAnswer[0] + "____" + findAnswer[2]);
       super.setAnswer(answer);
   }
}
