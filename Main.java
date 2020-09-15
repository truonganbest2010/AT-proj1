import javax.swing.JFrame;

import view.WordGuessGamePanel;

public class Main{
    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(400, 200);

        var mainPanel = new WordGuessGamePanel(window);
        mainPanel.init();

        window.pack();
        window.setVisible(true);
    }
}