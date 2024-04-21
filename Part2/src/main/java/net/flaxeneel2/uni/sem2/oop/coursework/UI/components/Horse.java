package net.flaxeneel2.uni.sem2.oop.coursework.UI.components;

import java.awt.*;

public class Horse extends Canvas {
    private int offset;
    private int mult;
    private int limit;
    public Horse(int limit) {
        super();
        setBackground(Color.WHITE);
        setForeground(Color.RED);
        this.offset = 0;
        this.mult = 10;
        this.limit = limit;
    }

    public void tick() {
        int newOffset = offset + (mult);
        if(newOffset > limit) {
            newOffset = limit;
            mult = -10;
        } else if(newOffset < 0) {
            newOffset = 0;
            mult = 10;
        }
        offset = newOffset;
        this.paint(this.getGraphics());

    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void getReady() {
        Graphics g = this.getGraphics();
        g.fillRect(0, 15, 30, 30);
    }

    public void paint(Graphics g) {
        System.out.println(offset);
        g.clearRect(offset-mult, 30, 100, 80);
        g.fillRect(offset, 30,100, 80);
    }
}
