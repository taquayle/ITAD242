/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.util.Scanner;

/**
 *
 * @author Tyler Quayle
 */
public class Quiz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Question first = new Question();
        first.setText("Who was the inventor of Java?");
        first.setAnswer("James Gosling");

        ChoiceQuestion second = new ChoiceQuestion();
        second.setText("In which country was the inventor of Java born?");
        second.addChoice("Australia", false);
        second.addChoice("Canada", true);
        second.addChoice("Denmark", false);
        second.addChoice("United States", false);

        NumericQuestion third = new NumericQuestion();
        third.setText("What is pi to the second digit?");
        third.setAnswer(3.14);
        
        FillnQuestion fourth = new FillnQuestion();
        fourth.setText("The inventor of java was _James Gosling_");
        
        MultiChoiceQuestion fifth = new MultiChoiceQuestion();
        fifth.setText("Which of these are planets? ");
        fifth.addChoice("Earth", true);
        fifth.addChoice("Jupiter", true);
        fifth.addChoice("Venus", true);
        fifth.addChoice("Pluto", false);

        presentQuestion(first);
        presentQuestion(second);
        presentQuestion(third);
        presentQuestion(fourth);
        presentQuestion(fifth);
    }

    /**
     * Presents a question to the user and checks the response.
     *
     * @param q the question
     */
    public static void presentQuestion(Question q) {
        q.display();
        System.out.print("Your answer: ");
        Scanner in = new Scanner(System.in);
        String response = in.nextLine();
        System.out.println(q.checkAnswer(response));
    }
}
