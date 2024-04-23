package net.flaxeneel2.uni.sem2.oop.coursework.UI.modals;

import net.flaxeneel2.uni.sem2.oop.coursework.storage.SaveFile;
import net.flaxeneel2.uni.sem2.oop.coursework.storage.SaveWriter;

import javax.swing.*;
import java.awt.*;

import static net.flaxeneel2.uni.sem2.oop.coursework.Main.getSaveFile;
import static net.flaxeneel2.uni.sem2.oop.coursework.Main.setSaveFile;

public class EditDefaults extends JFrame {
    public EditDefaults() {
        super("Edit Defaults");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(new Dimension(800, 600));

        FlowLayout layout = new FlowLayout();
        layout.setVgap(10);
        this.setLayout(layout);

        JPanel trackColor = new JPanel();
        trackColor.setLayout(new BorderLayout());
        trackColor.setPreferredSize(new Dimension(this.getWidth()-20, 50));
        trackColor.setBackground(getSaveFile().laneColor);
        JButton colorChooserButton = new JButton("Choose Color");


        //colorButton.addActionListener(e -> currentColor = JColorChooser.showDialog(null, "Choose Color", currentColor));
        colorChooserButton.addActionListener(e -> {
            trackColor.setBackground(JColorChooser.showDialog(this, "Choose Color", trackColor.getBackground()));
        });

        trackColor.add(new JLabel("Track Color:"), BorderLayout.WEST);
        trackColor.add(colorChooserButton, BorderLayout.EAST);

        this.add(trackColor);

        JCheckBox randomColor = new JCheckBox("Random Color");
        randomColor.setSelected(getSaveFile().randomLaneColors);
        this.add(randomColor);

        JPanel trackBorderColor = new JPanel();
        trackBorderColor.setLayout(new BorderLayout());
        trackBorderColor.setPreferredSize(new Dimension(this.getWidth()-20, 50));
        JButton trackBorderColorChooserButton = new JButton("Choose Border Color");
        trackBorderColorChooserButton.addActionListener(e -> {
            trackBorderColor.setBackground(JColorChooser.showDialog(this, "Choose Color", trackBorderColor.getBackground()));
        });

        trackBorderColor.add(new JLabel("Track Border Color:"), BorderLayout.WEST);
        trackBorderColor.add(trackBorderColorChooserButton, BorderLayout.EAST);
        this.add(trackBorderColor);











        JPanel cancelSaveButtonsContainer = new JPanel();
        cancelSaveButtonsContainer.setLayout(new GridLayout(1, 2));
        cancelSaveButtonsContainer.setPreferredSize(new Dimension(this.getWidth(), 25));

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> this.dispose());
        cancelButton.setBackground(new Color(124, 45, 45, 255));

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            SaveFile save = getSaveFile();
            save.laneColor = trackColor.getBackground();
            save.laneBorderColor = trackBorderColor.getBackground();
            save.randomLaneColors = randomColor.isSelected();
            setSaveFile(save);
            this.dispose();
        });
        saveButton.setBackground(new Color(0, 84, 0, 255));

        cancelSaveButtonsContainer.add(cancelButton);
        cancelSaveButtonsContainer.add(saveButton);
        this.add(cancelSaveButtonsContainer);








        this.setVisible(true);
    }
}
