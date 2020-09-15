package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class WordGuessGamePanel {
    
    private JFrame window;
    private JTextField gamekey = new JTextField();
    private JTextField guesskey = new JTextField();
    private DrawingCanvas canvas = new DrawingCanvas(this);

    public WordGuessGamePanel(JFrame window){
        this.window = window;
        window.setTitle("Word Guess Game");
    }

    public void init(){
        Container cp = window.getContentPane();
        window.setPreferredSize(new Dimension(500, 500));
        
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,1));
        TitledBorder northTitle = BorderFactory.createTitledBorder("Key");
        northPanel.setBorder(northTitle);
        cp.add(BorderLayout.NORTH, northPanel);

        gamekey.setEnabled(false);
        guesskey.setEnabled(false);
        northPanel.add(gamekey);
        northPanel.add(guesskey);

        cp.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4, 7));
        TitledBorder southTitle = BorderFactory.createTitledBorder("Input");
        southPanel.setBorder(southTitle);
        cp.add(BorderLayout.SOUTH, southPanel);
        



    }
}