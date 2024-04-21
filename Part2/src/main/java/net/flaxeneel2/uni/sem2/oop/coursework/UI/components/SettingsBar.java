package net.flaxeneel2.uni.sem2.oop.coursework.UI.components;

import net.flaxeneel2.uni.sem2.oop.coursework.Main;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SettingsBar extends JPanel {

    private JButton startButton;

    public SettingsBar() {
        super();
        Dimension panelDimensions = Main.UI_INSTANCE.getSize();
        this.setSize(new Dimension(panelDimensions.width, 50));
        this.add(this.getLaneDropdown());
        this.startButton = new JButton("Start");
        startButton.addActionListener(e -> Main.UI_INSTANCE.startRace());
        this.add(startButton);
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

    }

    private JPanel getLaneDropdown() {
        JPanel panel = new JPanel();
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setLayout(new FlowLayout());

        panel.add(new JLabel("Number of lanes:   "));
        JComboBox<Integer> laneDropdown = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        laneDropdown.addActionListener(e -> {
            Main.UI_INSTANCE.getLanes().updateLanes(laneDropdown.getSelectedIndex()+1);
        });

        laneDropdown.setSize((int) (Main.UI_INSTANCE.getSize().width*0.2), panel.getHeight());

        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        laneDropdown.setEditable(true);
        panel.add(laneDropdown);
        return panel;
    }
    public void disableAllComponents() {
        startButton.setText("Race ongoing...");
        Arrays.stream(this.getComponents()).forEach(c -> c.setEnabled(false));
    }
    public void enableAllComponents() {
        Arrays.stream(this.getComponents()).forEach(c -> c.setEnabled(true));
        startButton.setText("Start");
    }
}
