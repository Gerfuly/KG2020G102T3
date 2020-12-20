package ru.vsu.cs.kg2020.g102.volobuev_i_a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainWindow extends JFrame {
    public MainWindow() throws HeadlessException{
        DrawPanel dp = new DrawPanel();
        this.add(dp);

        Candles cm = dp.getCM();
        cm.addCandle(400, 25, 350, 500);
        cm.addCandle(425, 25, 375, 475);
        cm.addCandle(450, -50, 375, 475);
        cm.addCandle(400, 75, 350, 500);
        cm.addCandle(20, 400, 10, 500);
        cm.addCandle(150, 50, 100,270);

        this.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==37){
                    dp.movLeft();
                    dp.repaint();
                }
                if (e.getKeyCode()==39){
                    dp.movRight();
                    dp.repaint();
                }
                if (e.getKeyCode()==38){
                    dp.movUp();
                    dp.repaint();
                }
                if (e.getKeyCode()==40){
                    dp.movDown();
                    dp.repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

            @Override
            public void keyTyped(KeyEvent e) {

            }
        });

    }
}
