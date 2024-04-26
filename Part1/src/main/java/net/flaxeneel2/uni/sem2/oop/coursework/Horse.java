package net.flaxeneel2.uni.sem2.oop.coursework;

import javax.swing.*;

/**
 * Write a description of class Horse here.
 * 
 * @author Siddhant Misra
 * @version 1
 */
public class Horse
{
    //Fields of class Horse
    private int distanceTravelled;
    private char symbol;
    private String name;
    private boolean fallen;
    private double confidence;

//Constructor of class Horse
    /**
     * Constructor for objects of class Horse
     */
    public Horse(char horseSymbol, String horseName, double horseConfidence)
    {
       this.setSymbol(horseSymbol);
       this.setName(horseName);
       this.setConfidence(horseConfidence);
    }
    
    
    
    //Other methods of class Horse
    public void fall()
    {
        this.setFallen(true);
        this.confidence-=0.1;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasFallen() {
        return fallen;
    }

    public void setFallen(boolean fallen) {
        this.fallen = fallen;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public void moveForward() {
        this.setDistanceTravelled(this.getDistanceTravelled()+1);
    }

    public void goBackToStart() {
        this.setDistanceTravelled(0);

    }
    
}
