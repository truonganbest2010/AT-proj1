package view;

import javax.swing.*;
import java.awt.*;

public class DrawingCanvas extends JPanel {

    private WordGuessGamePanel panel;
    private int countHealth;
    
    public DrawingCanvas(WordGuessGamePanel panel){
        this.panel = panel;
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Font fontCourier = new Font("Courier", Font.BOLD, 30);

        WordGuessGamePanel.GameState state = panel.getGameState();
        if (state == WordGuessGamePanel.GameState.READY){
            g2.setColor(Color.YELLOW);
            g2.setFont(fontCourier);
            g2.drawString("Click <New> to START Game", 30, 150);
        }
        else if (state == WordGuessGamePanel.GameState.GAMEOVER){
                g2.setColor(Color.RED);
                g2.setFont(fontCourier);
                g2.drawString("YOU LOST!", 170, 150);
                g2.drawString("Click <New> to Continue", 45, 200);
        }
        else if (state == WordGuessGamePanel.GameState.PLAYING){
           
            g2.setColor(Color.BLUE);
            g2.setFont(fontCourier);

            g2.drawString("HEALTH LEVEL", 50, 100);

            for (int i = 0; i < countHealth; i++){
                g2.fillRect(i*50 + 100, 150, 30, 60);
            }
        }
        else
        {
            g2.setColor(Color.WHITE);
            g2.setFont(fontCourier);
            g2.drawString("YOU WON!", 170, 150);
            g2.drawString("Click <New> to Continue", 45, 200);
        }


    }

    public void setCountHealth(int count){
        this.countHealth = count;
    }


}