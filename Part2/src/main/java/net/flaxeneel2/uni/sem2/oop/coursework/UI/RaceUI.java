package net.flaxeneel2.uni.sem2.oop.coursework.UI;

import net.flaxeneel2.uni.sem2.oop.coursework.UI.components.HorseLanes;
import net.flaxeneel2.uni.sem2.oop.coursework.UI.components.RaceData;
import net.flaxeneel2.uni.sem2.oop.coursework.UI.components.SettingsBar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RaceUI extends JFrame {
    private HorseLanes lanes;
    private RaceData race;
    public RaceUI() {
        super("Horse Race simulator");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Horse simulator");
        this.setSize(new Dimension(800, 600));
        this.setMinimumSize(new Dimension(800, 600));

        GridBagLayout gridBagLayout = new GridBagLayout();

        gridBagLayout.columnWeights = new double[]{0.8, 0.2};
        gridBagLayout.rowWeights = new double[]{0.1, 0.9};


        this.setLayout(gridBagLayout);

        this.getContentPane().setBackground(new Color(85, 85, 85));

        this.setThemingDefaults();
    }

    public void initialise() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.insets = new Insets(0,0,0,0);

        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.weightx = 0;
        constraints.gridy = 0;


        this.add(new SettingsBar(), constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        constraints.gridy = 1;
        constraints.weighty=0.1;
        constraints.weightx = 1;


        this.lanes = new HorseLanes();
        this.add(this.lanes, constraints);


        constraints.gridx = 1;
        this.race = new RaceData();
        this.add(this.race, constraints);

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
