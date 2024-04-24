package net.flaxeneel2.uni.sem2.oop.coursework.UI.components;

import net.flaxeneel2.uni.sem2.oop.coursework.Main;
import net.flaxeneel2.uni.sem2.oop.coursework.storage.HorseData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static net.flaxeneel2.uni.sem2.oop.coursework.Main.getSaveFile;

public class HorseLanes extends JPanel {
    private ArrayList<Horse> horses;
    public HorseLanes() {
        super();

        this.horses = new ArrayList<>();


        this.setBackground(new Color(255, 255, 0));
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void updateLanes(int numLanes) {
        if(this.horses.size() == numLanes) return;
        this.horses.clear();
        this.removeAll();
        this.revalidate();
        this.repaint();

        Random random = new Random();
        for(int i = 0; i < numLanes; i++) {
            HorseData horseData = HorseData.random();
            Horse horse = new Horse(this.getWidth(), horseData);
            Color trackColor = getSaveFile().laneColor;
            if(getSaveFile().randomLaneColors) trackColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            horse.setBackground(trackColor);
            this.add(horse);
            this.horses.add(horse);
        }
        Main.UI_INSTANCE.getRaceStatus().updateLanes(this.horses);
    }

    public void dealWithSizeChange(int newWidth, int newHeight) {
        this.setPreferredSize(new Dimension((int) (newWidth*0.7), newHeight-100));
        for(Horse horse : this.horses) {
            horse.setLimit(this.getWidth());
        }
    }

    public int getLaneCount() {
        return this.horses.size();
    }

    public void readyAllHorses() {
        for(Horse horse : this.horses) {
            horse.setLimit(this.getWidth());
            horse.getReady();
        }
    }

    public void setHorse(HorseData horseData, int index) {
        Horse horse = new Horse(this.getWidth(), horseData);
        Random random = new Random();
        Color trackColor = getSaveFile().laneColor;
        if(getSaveFile().randomLaneColors) trackColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        horse.setBackground(trackColor);

        this.horses.set(index, horse);
        this.remove(index);
        this.add(horse, index);

        Main.UI_INSTANCE.getRaceStatus().updateLanes();
    }

    public void tickAllHorses() {
        for(Horse horse : this.horses) {
            horse.tick();
        }
    }
}
