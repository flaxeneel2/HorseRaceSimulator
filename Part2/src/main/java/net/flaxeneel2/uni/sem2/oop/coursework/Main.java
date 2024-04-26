package net.flaxeneel2.uni.sem2.oop.coursework;

import net.flaxeneel2.uni.sem2.oop.coursework.UI.RaceUI;
import net.flaxeneel2.uni.sem2.oop.coursework.storage.SaveFile;

public class Main {
    public static RaceUI UI_INSTANCE;
    private static SaveFile SAVE_FILE;
    public static void main(String[] args) {
        startRaceGUI();
    }

    public static void startRaceGUI() {
        UI_INSTANCE = new RaceUI();
        setSaveFile(new SaveFile());
        UI_INSTANCE.initialise();
    }

    public static SaveFile getSaveFile() {
        return SAVE_FILE;
    }

    public static void setSaveFile(SaveFile saveFile) {
        SAVE_FILE = saveFile;
    }
}