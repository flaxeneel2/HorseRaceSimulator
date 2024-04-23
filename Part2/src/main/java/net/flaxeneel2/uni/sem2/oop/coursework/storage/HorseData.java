package net.flaxeneel2.uni.sem2.oop.coursework.storage;

import java.awt.*;
import java.util.Random;

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


    public static HorseData random() {
        final String[] RANDOM_NAMES = {
                "Midnight Shadow",
                "Golden Star",
                "Whispering Wind",
                "Thunder Hoof",
                "Misty Meadow",
                "Silver Blaze",
                "Stormy Sky",
                "Dancing Spirit",
                "Rusty Sun",
                "Sapphire Dream",
                "Moonlit Magic",
                "Rocky Mountain",
                "Sunny Day",
                "Frosty Morning",
                "Autumn Breeze",
                "Spirit Dancer",
                "Rapid Fire",
                "Amber Sunset",
                "Wildflower",
                "Echo Valley"
        };

        final String[] RANDOM_BREEDS = new String[]{
                "Thoroughbred",
                "Arabian",
                "Quarter Horse",
                "Appaloosa",
                "American Paint Horse",
                "Morgan",
                "Tennessee Walking Horse",
                "Andalusian",
                "Friesian",
                "Clydesdale"
        };

        Random rand = new Random();
        String name = RANDOM_NAMES[rand.nextInt(RANDOM_NAMES.length)];
        String breed = RANDOM_BREEDS[rand.nextInt(RANDOM_BREEDS.length)];
        double confidence = rand.nextDouble(0.05, 1);
        Color[][] sprite = new Color[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                sprite[i][j] = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
            }
        }
        return new HorseData(name, breed, confidence, sprite);

    }
}
