package net.flaxeneel2.uni.sem2.oop.coursework;

import net.flaxeneel2.uni.sem2.oop.coursework.UI.RaceUI;
import net.flaxeneel2.uni.sem2.oop.coursework.storage.HorsesStore;

public class Main {
    public static RaceUI UI_INSTANCE;
    public static HorsesStore STORAGE;
    public static void main(String[] args) {
        UI_INSTANCE = new RaceUI();
        STORAGE = new HorsesStore();
        UI_INSTANCE.initialise();
    }
}