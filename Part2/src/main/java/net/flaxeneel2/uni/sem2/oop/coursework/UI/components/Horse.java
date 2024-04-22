package net.flaxeneel2.uni.sem2.oop.coursework.UI.components;

import net.flaxeneel2.uni.sem2.oop.coursework.storage.HorseData;

import java.awt.*;

public class Horse extends Canvas {
    private int distanceTravelled;
    private int limit;

    private boolean fallen;

    private HorseData horseData;


    public Horse(int limit, HorseData horseData) {
        super();
        setBackground(Color.WHITE);
        setForeground(Color.RED);
        this.distanceTravelled = 0;
        this.horseData = horseData;
        this.limit = limit;
    }

    public void tick() {
        if(this.fallen) return;
        int newOffset = (int) (distanceTravelled + horseData.getConfidence()*100);
        if(newOffset < 0) {
            newOffset = 0;
        }
        distanceTravelled = newOffset;
        this.paint(this.getGraphics());
    }

    public void fall() {
        this.fallen = true;
        setForeground(Color.BLUE);
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
        g.clearRect((int) (distanceTravelled -(horseData.getConfidence()*100)), 30, 100, 80);
        g.fillRect(distanceTravelled, 30,100, 80);

    }
}
