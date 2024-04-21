package net.flaxeneel2.uni.sem2.oop.coursework.UI.components;

import net.flaxeneel2.uni.sem2.oop.coursework.Main;

import javax.swing.*;
import java.awt.*;

public class SettingsBar extends JPanel {

    public SettingsBar() {
        super();
        Dimension panelDimensions = Main.UI_INSTANCE.getSize();
        this.setPreferredSize(new Dimension(panelDimensions.width, 50));
        this.add(this.getLaneDropdown());
        this.add(new JButton("bruh"));
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

    }

    private JPanel getLaneDropdown() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Number of lanes: "));
        JComboBox<Integer> laneDropdown = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        laneDropdown.addActionListener(e -> {
            Main.UI_INSTANCE.getLanes().updateLanes(laneDropdown.getSelectedIndex()+1);
        });
        laneDropdown.setEditable(true);
        laneDropdown.setSize(100, panel.getHeight());
        panel.add(laneDropdown);
        return panel;
    }
}
