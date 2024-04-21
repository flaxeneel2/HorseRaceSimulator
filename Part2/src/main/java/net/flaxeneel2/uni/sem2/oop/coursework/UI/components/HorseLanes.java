package net.flaxeneel2.uni.sem2.oop.coursework.UI.components;

import net.flaxeneel2.uni.sem2.oop.coursework.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HorseLanes extends JPanel {
    private ArrayList<Canvas> lanes;
    public HorseLanes() {
        super();
        this.lanes = new ArrayList<>();

        this.setBackground(new Color(255, 255, 0));
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void updateLanes(int numLanes) {
        if(this.lanes.size() == numLanes) return;
        this.lanes.clear();
        this.removeAll();
        this.revalidate();
        this.repaint();
        Random random = new Random();
        for(int i = 0; i < numLanes; i++) {
            Canvas panel = new Canvas();
            panel.setBackground(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            this.add(panel);
            this.lanes.add(panel);
        }
    }

    public void dealWithSizeChange(int newWidth, int newHeight) {
        this.setPreferredSize(new Dimension((int) (newWidth*0.7), newHeight-100));
    }
}
