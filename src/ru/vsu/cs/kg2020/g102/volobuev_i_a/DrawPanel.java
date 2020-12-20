package ru.vsu.cs.kg2020.g102.volobuev_i_a;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    private Candles list = new Candles();


    public Candles getCM(){
        return list;
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;
        gr.setColor(Color.darkGray);
        gr.fillRect(0,0,900,600);


        list.draw(gr);

    }

    public void movLeft(){
        list.movLeft();
    }
    public void movRight(){
        list.movRight();
    }
    public void movUp(){
        list.movUp();
    }
    public void movDown(){
        list.movDown();
    }
}
