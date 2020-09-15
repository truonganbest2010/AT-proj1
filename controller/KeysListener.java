package controller;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import view.WordGuessGamePanel;

public class KeysListener implements ActionListener {

    private WordGuessGamePanel panel;

    public KeysListener(WordGuessGamePanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JButton keys = (JButton) e.getSource();
        
        if (keys == panel.getNewKey()){
            for (var i: panel.getCharacterKey()){
                i.setEnabled(true);
            }
            panel.setGameState(WordGuessGamePanel.GameState.PLAYING);
            panel.getWordGuessGame().chooseNewWord();
            Font font = new Font("Courier", Font.BOLD, 20);
            String keyWord;
            keyWord = panel.getWordGuessGame().getStringOfKey();
            panel.getGameKey().setFont(font);
            panel.getGameKey().setForeground(Color.RED);;
            panel.getGameKey().setText(keyWord);
            String guessWord;
            guessWord = panel.getWordGuessGame().getStringOfGuess();
            panel.getGuessKey().setFont(font);
            panel.getGuessKey().setText(guessWord);

            panel.getCanvas().setCountHealth(panel.getWordGuessGame().getCountHealth());

            panel.getCanvas().repaint();
        } else {
            keys.setEnabled(false);
            char c = keys.getText().charAt(0);
            panel.getWordGuessGame().guessKeyInsert(c);
            String guess = panel.getWordGuessGame().getStringOfGuess();
            panel.getGuessKey().setFont(new Font("Courier", Font.BOLD, 20));
            panel.getGuessKey().setText(guess);

            panel.getCanvas().setCountHealth(panel.getWordGuessGame().getCountHealth());

            if (panel.getWordGuessGame().getCountHealth() == 0 && !panel.getWordGuessGame().getGameFinish())
            {
                panel.setGameState(WordGuessGamePanel.GameState.GAMEOVER);
                for (var i: panel.getCharacterKey()){
                    i.setEnabled(false);
                }
            } 
            if (panel.getWordGuessGame().getCountHealth() > 0 && panel.getWordGuessGame().getGameFinish()){
                panel.setGameState(WordGuessGamePanel.GameState.WIN);
                for (var i: panel.getCharacterKey()){
                    i.setEnabled(false);
                }
            }

            panel.getCanvas().repaint();
            
            // System.out.println(c);
        }
    }


}