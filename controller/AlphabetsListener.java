package controller;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import view.WordGuessGamePanel;

public class AlphabetsListener implements ActionListener {

    private WordGuessGamePanel panel;

    public AlphabetsListener(WordGuessGamePanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JButton key = (JButton) e.getSource();
        
        if (key == panel.getNewKey()){

        } else {
            key.setEnabled(true);
            String character = key.getText();

            // System.out.println(character);
        }
    }


}