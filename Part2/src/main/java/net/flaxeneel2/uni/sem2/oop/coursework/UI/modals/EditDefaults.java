package net.flaxeneel2.uni.sem2.oop.coursework.UI.modals;

import net.flaxeneel2.uni.sem2.oop.coursework.storage.SaveFile;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;

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

        JPanel trackColorSelection = new JPanel();
        trackColorSelection.setLayout(new BorderLayout());
        trackColorSelection.setPreferredSize(new Dimension(this.getWidth()-20, 50));
        trackColorSelection.setBorder(BorderFactory.createLineBorder(getSaveFile().laneColor));
        JButton colorChooserButton = new JButton("Choose Color");

        AtomicReference<Color> trackColor = new AtomicReference<>(getSaveFile().laneColor);

        //colorButton.addActionListener(e -> currentColor = JColorChooser.showDialog(null, "Choose Color", currentColor));
        colorChooserButton.addActionListener(e -> {
            trackColor.set(JColorChooser.showDialog(this, "Choose Color", trackColor.get()));
            trackColorSelection.setBorder(BorderFactory.createLineBorder(trackColor.get()));
        });

        trackColorSelection.add(new JLabel("Track Color:"), BorderLayout.WEST);
        trackColorSelection.add(colorChooserButton, BorderLayout.EAST);

        this.add(trackColorSelection);

        JCheckBox randomColor = new JCheckBox("Random Color");
        randomColor.setSelected(getSaveFile().randomLaneColors);
        this.add(randomColor);

        JPanel trackBorderColorSelection = new JPanel();

        trackBorderColorSelection.setBorder(BorderFactory.createLineBorder(getSaveFile().laneBorderColor));

        AtomicReference<Color> trackBorderColor = new AtomicReference<>(getSaveFile().laneBorderColor);

        trackBorderColorSelection.setLayout(new BorderLayout());
        trackBorderColorSelection.setPreferredSize(new Dimension(this.getWidth()-20, 50));
        JButton trackBorderColorChooserButton = new JButton("Choose Border Color");
        trackBorderColorChooserButton.addActionListener(e -> {
            trackBorderColor.set(JColorChooser.showDialog(this, "Choose Color", trackBorderColorSelection.getBackground()));
            trackBorderColorSelection.setBorder(BorderFactory.createLineBorder(trackBorderColor.get()));
        });

        trackBorderColorSelection.add(new JLabel("Track Border Color:"), BorderLayout.WEST);
        trackBorderColorSelection.add(trackBorderColorChooserButton, BorderLayout.EAST);
        this.add(trackBorderColorSelection);











        JPanel cancelSaveButtonsContainer = new JPanel();
        cancelSaveButtonsContainer.setLayout(new GridLayout(1, 2));
        cancelSaveButtonsContainer.setPreferredSize(new Dimension(this.getWidth(), 25));

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> this.dispose());
        cancelButton.setBackground(new Color(124, 45, 45, 255));

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            SaveFile save = getSaveFile();
            save.laneColor = trackColor.get();
            save.laneBorderColor = trackBorderColor.get();
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
