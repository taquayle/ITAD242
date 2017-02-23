/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quiz;

import java.util.ArrayList;

/**
 *
 * @author s-Tyler.Quayle
 */
public class MultiChoiceQuestion extends Question{
 
     private ArrayList<String> choices;
     private ArrayList<Integer> answers;
    /**
     * Constructs a choice question with no choices.
     */
    public MultiChoiceQuestion() {
        choices = new ArrayList<String>();
        answers = new ArrayList<Integer>();
    }

    /**
     * Adds an answer choice to this question.
     *
     * @param choice the choice to add
     * @param correct true if this is the correct choice, false otherwise
     */
    public void addChoice(String choice, boolean correct) {
        choices.add(choice);
        if (correct) {
            // Convert choices.size() to string
            String choiceString = "" + choices.size();
            setAnswer(choiceString);
        }
    }

    @Override
    public boolean checkAnswer(String response)
    {
      String[] checkAnswer = response.split(",");
      int correct = 0;

      for(int i = 0; i < answers.size(); i++)
          for(String inputAnswers : checkAnswer)
              if(Integer.parseInt(inputAnswers) == answers.get(i)) correct++;
 
      if(correct == answers.size()) return true;
      return false;
    }
    
    
     @Override
   public void setAnswer(String correctResponse)
   {
      answers.add(Integer.parseInt(correctResponse));
   }

    
    public void display() {
        // Display the question text
        super.display();
        // Display the answer choices
        for (int i = 0; i < choices.size(); i++) {
            int choiceNumber = i + 1;
            System.out.println(choiceNumber + ": " + choices.get(i));
        }
        System.out.println("Enter all that apply seperated by commas [eg: 1,2,4]");
        System.out.print("Choice(s): ");
    }
}
