package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class WordGuessGamePanel {
    
    private JFrame window;
    private JTextField gamekey = new JTextField();
    private JTextField guesskey = new JTextField();

    public WordGuessGamePanel(JFrame window){
        this.window = window;
        window.setTitle("Word Guess Game");
    }

    public void init(){
        Container cp = window.getContentPane();
        
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,1));
        TitledBorder northTitle = BorderFactory.createTitledBorder("Key");
        northPanel.setBorder(northTitle);

        gamekey.setEnabled(false);
        guesskey.setEnabled(false);
        northPanel.add(gamekey);
        northPanel.add(guesskey);
        




    }
}