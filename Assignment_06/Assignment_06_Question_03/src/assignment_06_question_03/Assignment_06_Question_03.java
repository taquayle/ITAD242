/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_06_question_03;

import java.awt.event.ActionEvent;

/**
 *
 * @author Quayle
 */
public class Assignment_06_Question_03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyCustomFrame myFrame = new MyCustomFrame();
        myFrame.setButtonText("ON");
        myFrame.setButtonToggleText("OFF");
        myFrame.setLabelText("System is OFF");
        myFrame.setLabelToggleText("System is ON");
        myFrame.addButton();
        myFrame.addLabel();
    }
    
}
    

