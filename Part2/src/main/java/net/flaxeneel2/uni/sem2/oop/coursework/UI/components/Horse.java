package net.flaxeneel2.uni.sem2.oop.coursework.UI.components;

import net.flaxeneel2.uni.sem2.oop.coursework.Main;
import net.flaxeneel2.uni.sem2.oop.coursework.storage.HorseData;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

import static net.flaxeneel2.uni.sem2.oop.coursework.Main.getSaveFile;


public class Horse extends Canvas  implements Cloneable{
    private int distanceTravelled;

    private boolean finishBroadcast = false;

    private int amountBet;

    private int limit;

    private boolean fallen;

    private double odds;

    private HorseData horseData;



    public Horse(int limit, HorseData horseData) {
        super();
        setBackground(Color.WHITE);
        setForeground(Color.RED);
        this.distanceTravelled = 0;
        this.horseData = horseData;
        this.limit = limit;
        this.amountBet = 0;
    }

    public void tick() {
        if(this.hasFinished() && !this.finishBroadcast) {
            Main.UI_INSTANCE.getRaceStatus().updatePositioningOfHorse(this);
            this.horseData.setConfidence(this.horseData.getConfidence() + 0.1);
            Main.UI_INSTANCE.getRaceStatus().updateConfidenceOfHorse(this);
            Main.UI_INSTANCE.getRaceStatus().updateStatusOfHorse(this, "Finished");
            this.finishBroadcast = true;
            this.amountBet = 0;
        }

        if(this.fallen || this.hasFinished()) return;
        this.tickFall();
        if(this.fallen) return;
        //makes the race move faster or slower
        int MULT_FACTOR = 8/Main.UI_INSTANCE.getLanes().getLengthMultiplier();
        int speed = (int) Math.round((new Random().nextDouble(0.5,1.5)* MULT_FACTOR)*(Math.log10(horseData.getConfidence()+0.2) + ((17- horseData.getConfidence())/10)));
        int newOffset = distanceTravelled + speed;
        if(newOffset < 0) {
            newOffset = 0;
        }
        this.horseData.setTimeOnTrack(this.horseData.getTimeOnTrack() + 1);
        this.horseData.setTotalDistanceTravelled(this.horseData.getTotalDistanceTravelled() + (speed * Main.UI_INSTANCE.getLanes().getLengthMultiplier()));
        distanceTravelled = newOffset;

        this.paint(this.getGraphics());
    }

    public double getOdds() {
        return odds;
    }

    public void setOdds(double odds) {
        this.odds = odds;
    }

    public void fall() {
        this.fallen = true;
        this.amountBet = 0;
        Main.UI_INSTANCE.getRaceStatus().updateStatusOfHorse(this, "Fallen");
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

    public void addToBet(int amount) {
        this.amountBet += amount;
    }

    public void getReady() {

        this.distanceTravelled = 0;
        this.fallen = false;
        this.finishBroadcast = false;
        this.paint(this.getGraphics());
    }

    private void tickFall() {
        double confidence = horseData.getConfidence();
        double chance = ((Math.pow(Math.E, (2*confidence - 1.25)) - 0.54 - ((2*confidence))/5 + (1/Math.E))/1.93)/45.0;
        if(new Random().nextInt(100) > (1-chance)*100) {
            this.fall();
        }
    }

    public HorseData getHorseData() {
        return horseData;
    }

    public void setHorseData(HorseData horseData) {
        this.horseData = horseData;
    }

    public boolean hasFinished() {
        return this.distanceTravelled + 100 >= this.limit;
    }

    public void paint(Graphics gr) {
        final int PIXEL_SIZE = 2;
        if(this.getBufferStrategy() == null) {
            this.createBufferStrategy(2);
        }
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        Graphics g = bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, getWidth(), getHeight());
        int xOffset = 0;
        int yOffset  = 0;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(getSaveFile().laneBorderColor);
        g2d.drawRect(0, 0, getWidth(), getHeight() - 1);
        Color[][] sprite = this.getHorseData().getSprite();
        for (Color[] row : sprite) {
            if(row.length==0) continue;
            for (Color color : row) {
                if(color == null) continue;
                Color c = this.fallen && color.getAlpha() != 0 ? new Color(255, 0, 0) : color;
                g.setColor(c);
                g.fillRect(distanceTravelled + xOffset, ((this.getHeight())/3) + yOffset, PIXEL_SIZE, PIXEL_SIZE);
                yOffset += PIXEL_SIZE;
            }
            yOffset = 0;
            xOffset += PIXEL_SIZE;
        }

        g.dispose();

        bufferStrategy.show();
    }

    public int getAmountBet() {
        return amountBet;
    }

    @Override
    public Horse clone() {
        try {
            return (Horse) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
