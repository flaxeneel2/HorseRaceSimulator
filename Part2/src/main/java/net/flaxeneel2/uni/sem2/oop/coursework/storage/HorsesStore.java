package net.flaxeneel2.uni.sem2.oop.coursework.storage;

import net.flaxeneel2.uni.sem2.oop.coursework.UI.components.Horse;

import java.util.HashMap;

public class HorsesStore {
    private HashMap<String, Horse> horses;
    public HorsesStore() {
        horses = new HashMap<>();
    }
    public void addHorse(Horse horse) {
        horses.put(horse.getName(), horse);
    }
    public Horse getHorse(String name) {
        return horses.get(name);
    }
    public Horse removeHorse(String name) {
        return horses.remove(name);
    }
    public Horse removeHorse(Horse horse) {
        return horses.remove(horse.getName());
    }
    public Horse[] getAllHorses() {
        return horses.values().toArray(new Horse[0]);
    }
}
