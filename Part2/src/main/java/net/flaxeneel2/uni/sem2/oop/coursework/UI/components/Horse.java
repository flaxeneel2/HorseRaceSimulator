package net.flaxeneel2.uni.sem2.oop.coursework.UI.components;

import net.flaxeneel2.uni.sem2.oop.coursework.storage.HorseData;

import java.awt.*;
import java.util.Random;

public class Horse extends Canvas {
    private int distanceTravelled;
    private int distanceTravelledLastFrame;
    private final int MULT_FACTOR = 50; //makes the race move faster or slower
    private int limit;

    private boolean fallen;

    private HorseData horseData;


    public Horse(int limit, HorseData horseData) {
        super();
        setBackground(Color.WHITE);
        setForeground(Color.RED);
        this.distanceTravelled = 0;
        this.distanceTravelledLastFrame = 0;
        this.horseData = horseData;
        this.limit = limit;
    }

    public void tick() {
        if(this.fallen) return;
        distanceTravelledLastFrame = distanceTravelled;
        int newOffset = (int) (distanceTravelled + horseData.getConfidence()*MULT_FACTOR)+MULT_FACTOR/25;
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
        this.distanceTravelled = 0;
        this.fallen = false;
        this.distanceTravelledLastFrame = 0;
    }

    private void tickFall() {
        double confidence = horseData.getConfidence();
        double chance = (Math.pow(Math.E, (2*confidence-1.25)) - 1.25 - (2* confidence)/5 + 1/Math.E )/1.93;
        if(new Random().nextDouble() > 1-chance) {
            this.fall();
        }
    }

    public HorseData getHorseData() {
        return horseData;
    }

    public void paint(Graphics g) {
        g.clearRect(distanceTravelledLastFrame-50, 30, distanceTravelled -distanceTravelledLastFrame+50, 100);
        int xOffset = 0;
        int yOffset  = 0;
        for(Color[] row : this.horseData.getSprite()) {
            for(Color c : row) {
                g.setColor(c);
                g.fillRect(distanceTravelled+xOffset, 30+yOffset,10, 10);
                xOffset+=10;
            }
            xOffset=0;
            yOffset+=10;
        }

    }
}
