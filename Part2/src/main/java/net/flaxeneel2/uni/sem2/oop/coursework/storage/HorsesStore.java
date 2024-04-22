package net.flaxeneel2.uni.sem2.oop.coursework.storage;

import net.flaxeneel2.uni.sem2.oop.coursework.UI.components.Horse;

import java.util.HashMap;

public class HorsesStore {
    private HashMap<String, HorseData> horses;
    public HorsesStore() {
        horses = new HashMap<>();
    }
    public void addHorse(HorseData horse) {
        System.out.printf("Horse named %s saved to persistent store.%n", horse.getName());
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
