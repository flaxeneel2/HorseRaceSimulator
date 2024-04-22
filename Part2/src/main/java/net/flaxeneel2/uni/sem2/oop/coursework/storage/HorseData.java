package net.flaxeneel2.uni.sem2.oop.coursework.storage;

import java.awt.*;

public class HorseData {
    private String name;
    private String breed;
    private Color[][] sprite;
    private double confidence;
    public HorseData(String name, String breed, double confidence, Color[][] sprite) {
        super();
        this.name = name;
        this.breed = breed;
        this.confidence = confidence;
        this.sprite = sprite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Color[][] getSprite() {
        return sprite;
    }

    public void setSprite(Color[][] sprite) {
        this.sprite = sprite;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
}
