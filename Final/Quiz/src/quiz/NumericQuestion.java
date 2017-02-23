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
public class NumericQuestion extends Question{
    
    double answer;
    
    NumericQuestion(){}
    
    void setAnswer(double correctAnswer)
    {
        answer = correctAnswer;
    }
    
    @Override
   public boolean checkAnswer(String response)
   {
      double reponseAsDouble = Double.parseDouble(response);
      double MAX_VALUE = answer +.01;
      double MIN_VALUE = answer - .01;
      if(reponseAsDouble <= MAX_VALUE && reponseAsDouble >= MIN_VALUE) return true;
      return false;
   }
}
