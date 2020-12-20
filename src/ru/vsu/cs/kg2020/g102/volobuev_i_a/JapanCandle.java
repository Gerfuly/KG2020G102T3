package ru.vsu.cs.kg2020.g102.volobuev_i_a;

public class JapanCandle {
    int stPrice, d, lowerWh, upperWh;

    public JapanCandle (int stPrice, int d, int lowerWh, int upperWh) {
        this.stPrice = stPrice;
        this.d = d;
        this.lowerWh = lowerWh;
        this.upperWh = upperWh;
    }

    public int getStPrice() {
        return stPrice;
    }

    public int getD() {
        return d;
    }

    public int getLowerWh() {
        return lowerWh;
    }

    public int getUpperWh() {
        return upperWh;
    }
}
