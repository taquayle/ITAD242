/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assign_07_ques_04;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Quayle
 */
public class JListDemo extends JFrame 
{
    private JPanel topPanel;
    private JList  listbox;
    
    // Contstants for frame creation and filling
    private final int LIST_SIZE = 90;
    private final int FRAME_WIDTH = 400;
    private final int FRAME_HEIGHT = 400;

    public JListDemo() 
    {
        // Set the frame characteristics
        setTitle( "JList demo" );
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setBackground(Color.gray);

        // Create a panel to hold all other components
        topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );

        // Create some items to add to the list
        String[] listData = new String[LIST_SIZE];
        for(int i = 0; i < LIST_SIZE; i++)
            listData[i] = "ITEM: " + (i + 1);

        // Create a new listbox control
        listbox = new JList( listData );
        
        // Creat sidescroll bar
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(listbox);
        
        topPanel.add(scrollPane, BorderLayout.CENTER );
    }
}
