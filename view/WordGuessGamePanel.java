package view;

import java.awt.*;

import javax.swing.*;

import controller.KeysListener;
import model.WordGuessGame;

public class WordGuessGamePanel {

    public enum GameState {
        READY, PLAYING, GAMEOVER, WIN
    }
    
    private JFrame window;
    private JTextField gameKey = new JTextField();
    private JTextField guessKey = new JTextField();
    private DrawingCanvas canvas = new DrawingCanvas(this);
    private WordGuessGame wordGuessGame = new WordGuessGame();
    private JButton[] characterKey;
    private JButton newKey = new JButton("New");

    private GameState gameState = GameState.READY;

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

        gameKey.setEditable(false);
        guessKey.setEditable(false);
        
        northPanel.add(gameKey);
        northPanel.add(guessKey);

        cp.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4, 7));
        cp.add(BorderLayout.SOUTH, southPanel);


        KeysListener eventListener = new KeysListener(this);
        
        characterKey = new JButton[26];
        for (int i = 0; i < 26; i++){
            characterKey[i] = new JButton("" + (char)(97+i));
            southPanel.add(characterKey[i]);
            characterKey[i].addActionListener(eventListener);
        }

        southPanel.add(newKey);
        newKey.addActionListener(eventListener);

        for (var i: characterKey){
            i.setEnabled(false);
        }

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

    public WordGuessGame getWordGuessGame(){
        return wordGuessGame;
    }

    public JButton[] getCharacterKey(){
        return characterKey;
    }

    public JButton getNewKey(){
        return newKey;
    }

    public GameState getGameState(){
        return gameState;
    }

    public void setGameState(GameState state){
        this.gameState = state;
    }

}