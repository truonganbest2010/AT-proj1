package view;

import javax.swing.*;
import java.awt.*;

public class DrawingCanvas extends JPanel {

    private WordGuessGamePanel panel;
    
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

        

    }


}