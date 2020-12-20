package ru.vsu.cs.kg2020.g102.volobuev_i_a;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Candles {
    final int xMax = 10;
    int xOffset=60, yOffset=0;
    int s=1;

    private final int gridStep = 100;

    public List<JapanCandle> list;

    public Candles() {
        list = new LinkedList<>();
    }

    public void addCandle(int stPrice, int d, int lowerWh, int upperWh, int n){
        if (n<list.size()) list.add(n, new JapanCandle(stPrice, d, upperWh, lowerWh));
        list.add(new JapanCandle(stPrice, d, upperWh, lowerWh));
    }

    public void addCandle(int stPrice, int d, int lowerWH, int upperWH){
        list.add(new JapanCandle(stPrice, d, lowerWH, upperWH));
    }

    public void deleteCandle (int n){
        if (n<list.size()) list.remove(n);
    }

    //
    public void delAll(){
        if (list.size()!=0)
            for (JapanCandle tmp:
                    list) {
                list.remove(tmp);
            }
    }
    //
    public void movRight(){
        this.xOffset+=20;
    }
    public void movLeft(){
        this.xOffset-=20;
    }

    public void movUp(){
        this.yOffset+=20;
    }
    public void movDown(){
        this.yOffset-=20;
    }
    //


    public void draw (Graphics2D g){
        g.setColor(Color.WHITE);
        int upperY=list.get(0).getStPrice()+list.get(0).getD(), lowerY=list.get(0).getStPrice()+list.get(0).getD();
        int currX = 0;
        for (JapanCandle tmp:
                list) {
            if (upperY<tmp.getUpperWh())
                upperY=tmp.getUpperWh();
            if (lowerY>tmp.getLowerWh())
                lowerY=tmp.getLowerWh();
        }
        PixelDrawer pd = new GraphicsPixelDrawer(g);
        LineDrawer ld = new WuLineDrawer(pd);
        for (int i = lowerY; i<upperY; i+=gridStep){
            g.drawString(Integer.toString(i), 2, 599-i-yOffset);
            ld.drawLine(0, 600-i-yOffset, 900, 600-i-yOffset, Color.LIGHT_GRAY);

            g.setColor(Color.WHITE);
        }
        g.drawString(Integer.toString(upperY), 2, 599-upperY-yOffset);
        ld.drawLine(0, 600-upperY-yOffset, 900, 600-upperY-yOffset, Color.LIGHT_GRAY);
        g.setColor(Color.WHITE);
        //
        for (JapanCandle tmp:
                list) {
            if (tmp.getD()>0)
                g.drawRect(currX-xMax+xOffset, 600-tmp.getStPrice()-tmp.getD()-yOffset, 2*xMax, tmp.getD());
            else
                g.fillRect(currX-xMax+xOffset, 600-tmp.getStPrice()-yOffset, 2*xMax, -tmp.getD());
            ld.drawLine(currX+xOffset, 600-tmp.getLowerWh()-yOffset, currX+xOffset, 600-tmp.getUpperWh()-yOffset,Color.WHITE);
            currX+=25;
        }
        currX = 60;
    }
}
