package net.flaxeneel2.uni.sem2.oop.coursework.UI.components;

import net.flaxeneel2.uni.sem2.oop.coursework.Main;
import net.flaxeneel2.uni.sem2.oop.coursework.storage.HorseData;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class HorseStatus extends JPanel {
    private ArrayList<Horse> horses;
    public HorseStatus() {

        super();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.horses = new ArrayList<>();
        this.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension((int) (Main.UI_INSTANCE.getSize().width*0.3), Main.UI_INSTANCE.getHeight()-100));
    }


    public void updateLanes(ArrayList<Horse> newHorses) {
        this.horses.clear();
        this.removeAll();
        this.revalidate();
        this.repaint();
        this.horses = newHorses;

        for(Horse horse : newHorses) {
            JPanel horseStatus = new JPanel();
            horseStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
            horseStatus.setLayout(new GridLayout(1, 2));
            horseStatus.setBorder(BorderFactory.createMatteBorder(2,0,2,0,Color.WHITE));
            JPanel horseInfo = new JPanel();
            horseInfo.setLayout(new GridLayout(4, 1));
            horseInfo.add(new JLabel("Name: " + horse.getName()));
            horseInfo.add(new JLabel("Confidence: " + horse.getHorseData().getConfidence()));
            horseInfo.add(new JLabel("Breed: " + horse.getHorseData().getBreed()));
            horseInfo.add(new JLabel("Odds: " + 0.1));
            JPanel horseAction = new JPanel();
            horseAction.setLayout(new GridLayout(4, 1));
            horseAction.add(new JButton("Bet on this horse"));
            horseAction.add(new JButton("View stats of this horse"));
            horseAction.add(new JButton("<Unused>"));
            horseAction.add(new JButton("<Unused>"));
            horseStatus.add(horseInfo);
            horseStatus.add(horseAction);
            this.add(horseStatus);
        }
    }

    public void dealWithSizeChange(int newWidth, int newHeight) {
        this.setPreferredSize(new Dimension((int) (newWidth*0.3), newHeight-100));
    }
}
