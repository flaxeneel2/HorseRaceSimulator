package net.flaxeneel2.uni.sem2.oop.coursework.UI.components;

import net.flaxeneel2.uni.sem2.oop.coursework.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HorseLanes extends JPanel {
    private ArrayList<JPanel> lanes;
    public HorseLanes() {
        super();
        this.lanes = new ArrayList<>();

        this.setBackground(new Color(255, 255, 0));
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setPreferredSize(new Dimension(((int) (Main.UI_INSTANCE.getSize().width*0.8)), Main.UI_INSTANCE.getSize().height-100));
    }

    public void updateLanes(int numLanes) {
        if(this.lanes.size() == numLanes) return;
    }
}
