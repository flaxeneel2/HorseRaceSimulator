package net.flaxeneel2.uni.sem2.oop.coursework.UI;

import net.flaxeneel2.uni.sem2.oop.coursework.UI.components.HorseLanes;
import net.flaxeneel2.uni.sem2.oop.coursework.UI.components.SettingsBar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RaceUI extends JFrame {
    private HorseLanes lanes;
    public RaceUI() {
        super("Horse Race simulator");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Horse simulator");
        this.setSize(new Dimension(1920, 1080));
        this.setMinimumSize(new Dimension(800, 600));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        this.getContentPane().setBackground(new Color(85, 85, 85));

        this.setThemingDefaults();
    }

    public void initialise() {
        this.lanes = new HorseLanes();

        this.add(new SettingsBar(), BorderLayout.NORTH);
        this.add(this.lanes, BorderLayout.WEST);

        this.setVisible(true);
    }

    public HorseLanes getLanes() {
        return this.lanes;
    }

    public void setThemingDefaults() {

        UIManager.put("Panel.background", new Color(34, 34, 34));
        UIManager.put("Panel.foreground", new Color(255, 255, 255));

        UIManager.put("Label.background", new Color(34, 34, 34));
        UIManager.put("Label.foreground", new Color(255, 255, 255));

        UIManager.put("ComboBox.background", new Color(34, 34, 34));
        UIManager.put("ComboBox.foreground", new Color(255, 255, 255));
        //UIManager.put("ComboBox.selectionBackground", new Color(34, 34, 34));
        //UIManager.put("ComboBox.selectionForeground", new Color(255, 255, 255));

        UIManager.put("Button.background", new Color(34, 34, 34));
        UIManager.put("Button.foreground", new Color(255, 255, 255));

        UIManager.put("ScrollBar.background", new Color(34, 34, 34));
        UIManager.put("ScrollBar.foreground", new Color(255, 255, 255));
        UIManager.put("ScrollBar.thumb", new Color(0, 0, 0));

        UIManager.put("TextField.background", new Color(34, 34, 34));
        UIManager.put("TextField.foreground", new Color(255, 255, 255));

    }
}
