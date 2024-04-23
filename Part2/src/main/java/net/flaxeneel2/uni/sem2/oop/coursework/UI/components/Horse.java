package net.flaxeneel2.uni.sem2.oop.coursework.UI.components;

import net.flaxeneel2.uni.sem2.oop.coursework.Main;
import net.flaxeneel2.uni.sem2.oop.coursework.storage.HorseData;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Horse extends Canvas {
    private int distanceTravelled;
    private int distanceTravelledLastFrame;
    private final int MULT_FACTOR = 7; //makes the race move faster or slower
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
        this.tickFall();
        if(this.fallen) return;
        distanceTravelledLastFrame = distanceTravelled;
        int speed = (int) Math.round((new Random().nextDouble(0.5,1.5)*MULT_FACTOR)*(Math.log10(horseData.getConfidence()+0.2) + ((17- horseData.getConfidence())/10)));
        int newOffset = (int) (distanceTravelled + speed);
        if(newOffset < 0) {
            newOffset = 0;
        }
        distanceTravelled = newOffset;

        this.paint(this.getGraphics());
    }

    public void fall() {
        this.fallen = true;
        horseData.setConfidence(horseData.getConfidence()-0.1);
        Main.UI_INSTANCE.getRaceStatus().updateConfidenceOfHorse(this);
        this.paint(this.getGraphics());
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
        //TODO: fix the equation below.
        double chance = ((Math.pow(Math.E, (2*confidence - 1.25)) - 0.54 - ((2*confidence))/5 + (1/Math.E))/1.93)/45.0;
        if(new Random().nextInt(100) > (1-chance)*100) {
            this.fall();
        }
    }

    public HorseData getHorseData() {
        return horseData;
    }

    public boolean hasFinished() {
        return false;
    }

    public void paint(Graphics g) {
        g.clearRect(distanceTravelledLastFrame-50, 30, distanceTravelled -distanceTravelledLastFrame+100, 100);
        int xOffset = 0;
        int yOffset  = 0;
        Color[][] sprite = this.getHorseData().getSprite();
        for (Color[] row : sprite) {
            if(row.length==0) continue;
            for (Color color : row) {
                Color c = this.fallen ? new Color(255, 0, 0) : color;
                g.setColor(c);
                g.fillRect(distanceTravelled + xOffset, 30 + yOffset, 2, 2);
                yOffset += 2;
            }
            yOffset = 0;
            xOffset += 2;
        }

    }
}
