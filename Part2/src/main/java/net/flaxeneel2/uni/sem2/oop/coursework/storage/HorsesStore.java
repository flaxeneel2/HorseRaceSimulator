package net.flaxeneel2.uni.sem2.oop.coursework.storage;

import java.io.Serializable;
import java.util.HashMap;

public class HorsesStore implements Serializable {
    private final HashMap<String, HorseData> horses;
    public HorsesStore() {
        horses = new HashMap<>();
    }
    public void addHorse(HorseData horse) {
        horses.put(horse.getName(), horse);
    }
    public HorseData getHorse(String name) {
        return horses.get(name);
    }
    public void removeHorse(String name) {
        horses.remove(name);
    }
    public HorseData removeHorse(HorseData horse) {
        return horses.remove(horse.getName());
    }
    public HorseData[] getAllHorses() {
        return horses.values().toArray(new HorseData[0]);
    }
}
