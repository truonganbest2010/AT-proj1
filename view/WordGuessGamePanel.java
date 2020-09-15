package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import controller.AlphabetsListener;

public class WordGuessGamePanel {
    
    private JFrame window;
    private JTextField gameKey = new JTextField();
    private JTextField guessKey = new JTextField();
    private DrawingCanvas canvas = new DrawingCanvas(this);
    private JButton[] characterKey = new JButton[26];
    private JButton newKey = new JButton("New");

    public WordGuessGamePanel(JFrame window){
        this.window = window;
        window.setTitle("Word Guess Game");
    }

    public void init(){
        Container cp = window.getContentPane();
        window.setPreferredSize(new Dimension(500, 500));
        
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,1));
        //TitledBorder northTitle = BorderFactory.createTitledBorder("Key");
        //northPanel.setBorder(northTitle);
        cp.add(BorderLayout.NORTH, northPanel);

        gameKey.setEnabled(false);
        guessKey.setEnabled(false);
        northPanel.add(gameKey);
        northPanel.add(guessKey);

        cp.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4, 7));
        //TitledBorder southTitle = BorderFactory.createTitledBorder("Input");
        //southPanel.setBorder(southTitle);
        cp.add(BorderLayout.SOUTH, southPanel);


        AlphabetsListener eventListener = new AlphabetsListener(this);
        int i = 0;
        for (char c = 'a' ; c < 'z'; c++){
            characterKey[i] = new JButton("" + c);
            southPanel.add(characterKey[i]);
            characterKey[i].addActionListener(eventListener);
            i++;
        } i = 0;

        southPanel.add(newKey);
        newKey.addActionListener(eventListener);

    }

    public JTextField getGameKey(){
        return gameKey;
    }

    public JTextField getGuessKey(){
        return guessKey;
    }

    public DrawingCanvas getCanvas(){
        return canvas;
    }

    public JButton[] getCharacterKey(){
        return characterKey;
    }

    public JButton getNewKey(){
        return newKey;
    }
}