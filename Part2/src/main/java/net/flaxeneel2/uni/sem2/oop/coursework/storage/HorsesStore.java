package net.flaxeneel2.uni.sem2.oop.coursework.storage;

import net.flaxeneel2.uni.sem2.oop.coursework.UI.components.Horse;

import java.awt.*;
import java.io.Serializable;
import java.util.HashMap;

public class HorsesStore implements Serializable {
    private HashMap<String, HorseData> horses;
    public HorsesStore() {
        horses = new HashMap<>();
    }
    public void addHorse(HorseData horse) {
        System.out.printf("Horse named %s saved to persistent store.%n", horse.getName());
        System.out.println("new Color[][] {");
        for(Color[] colors : horse.getSprite()) {
            System.out.println("    new Color[] {");
            for(Color color : colors) {
                if(color == null) continue;
                System.out.printf("        new Color(%s, %s, %s, %s),%n", color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
            }
            System.out.println("    },");
        }
        System.out.println("}");
        horses.put(horse.getName(), horse);
    }
    public HorseData getHorse(String name) {
        return horses.get(name);
    }
    public HorseData removeHorse(String name) {
        return horses.remove(name);
    }
    public HorseData removeHorse(HorseData horse) {
        return horses.remove(horse.getName());
    }
    public HorseData[] getAllHorses() {
        return horses.values().toArray(new HorseData[0]);
    }
}
