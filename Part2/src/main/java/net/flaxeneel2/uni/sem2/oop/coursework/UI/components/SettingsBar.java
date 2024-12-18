package net.flaxeneel2.uni.sem2.oop.coursework.UI.components;

import net.flaxeneel2.uni.sem2.oop.coursework.Main;
import net.flaxeneel2.uni.sem2.oop.coursework.UI.modals.EditDefaults;
import net.flaxeneel2.uni.sem2.oop.coursework.UI.modals.GenericMessageModal;
import net.flaxeneel2.uni.sem2.oop.coursework.UI.modals.ViewHorses;
import net.flaxeneel2.uni.sem2.oop.coursework.storage.SaveFile;
import net.flaxeneel2.uni.sem2.oop.coursework.storage.SaveWriter;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.util.Arrays;

import static net.flaxeneel2.uni.sem2.oop.coursework.Main.getSaveFile;

public class SettingsBar extends JPanel {

    private final JButton startButton;

    private JComboBox<Integer> laneDropdown;

    private JComboBox<Integer> trackLengthDropdown;

    private JLabel balance;

    public SettingsBar() {
        super();
        Dimension panelDimensions = Main.UI_INSTANCE.getSize();
        this.setSize(new Dimension(panelDimensions.width, 50));
        this.add(this.getLaneDropdown());
        this.add(this.getTrackLengthDropdown());

        this.startButton = new JButton("Start");
        startButton.addActionListener(e -> Main.UI_INSTANCE.startRace());
        this.add(startButton);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> Main.UI_INSTANCE.resetRace());

        this.add(resetButton);

        JButton viewHorses = new JButton("View horses");
        viewHorses.addActionListener(e -> new ViewHorses());
        this.add(viewHorses);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogType(JFileChooser.SAVE_DIALOG);
            chooser.setSelectedFile(new File("Save.hrs"));
            chooser.setFileFilter(new FileNameExtensionFilter("Horse Race Simulator Saves", "hrs"));
            chooser.showSaveDialog(this);
            if (chooser.getSelectedFile() != null) {
                File file = chooser.getSelectedFile();
                SaveWriter.save(getSaveFile(), file);
            }
        });

        JButton loadButton = new JButton("Load");
        loadButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogType(JFileChooser.OPEN_DIALOG);
            chooser.setSelectedFile(new File("Save.hrs"));
            chooser.setFileFilter(new FileNameExtensionFilter("Horse Race Simulator Saves", "hrs"));
            chooser.showOpenDialog(this);
            if (chooser.getSelectedFile() != null) {
                File file = chooser.getSelectedFile();
                SaveFile save = SaveWriter.load(file);
                if(save != null) {
                    Main.setSaveFile(save);
                    Main.UI_INSTANCE.updateBalance();
                    Main.UI_INSTANCE.resetRace();
                    Main.UI_INSTANCE.getLanes().repaintAllLanes();
                } else {
                    System.out.println("Was null!");
                }
            }
        });

        this.add(saveButton);
        this.add(loadButton);

        JButton editDefaults = new JButton("Edit Defaults");
        editDefaults.addActionListener(e -> new EditDefaults());
        this.add(editDefaults);

        balance = new JLabel("Balance: $" + getSaveFile().balance);

        this.add(balance);

        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

    }

    private JPanel getLaneDropdown() {
        JPanel panel = new JPanel();
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setLayout(new FlowLayout());

        panel.add(new JLabel("Number of lanes:   "));
        laneDropdown = new JComboBox<>(new Integer[]{2, 3, 4, 5, 6, 7, 8, 9, 10});
        laneDropdown.setSelectedIndex(1);
        laneDropdown.addActionListener(e -> {
            int laneSelect = laneDropdown.getSelectedIndex()+2;

            if(laneSelect >= 5 && Main.UI_INSTANCE.getHeight() < 700+((laneSelect-5)*125)) {
                GenericMessageModal modal = new GenericMessageModal("Please increase your window size!");
                modal.setMessages(String.format("Recommended size for %s lanes is 1200x%s", laneSelect, 700+((laneSelect-5)*125)));
                modal.makeVisibile();
            }
            Main.UI_INSTANCE.getLanes().updateLanes(laneSelect);
        });


        laneDropdown.setSize((int) (Main.UI_INSTANCE.getSize().width*0.2), panel.getHeight());

        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        laneDropdown.setEditable(false);
        panel.add(laneDropdown);
        return panel;
    }

    public void updateBalance() {
        balance.setText(String.format("Balance: $%s", getSaveFile().balance));
    }

    private JPanel getTrackLengthDropdown() {
        JPanel panel = new JPanel();
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setLayout(new FlowLayout());

        panel.add(new JLabel("Length of track (multiple of window size * 0.8):   "));
        trackLengthDropdown = new JComboBox<>(new Integer[]{1, 2, 4});
        trackLengthDropdown.addActionListener(e -> Main.UI_INSTANCE.getLanes().updateLengthMultiplier((int) Math.pow(2, trackLengthDropdown.getSelectedIndex())));

        trackLengthDropdown.setSize((int) (Main.UI_INSTANCE.getSize().width*0.3), panel.getHeight());

        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        trackLengthDropdown.setEditable(false);
        panel.add(trackLengthDropdown);
        return panel;
    }



    public void disableAllComponents() {
        startButton.setText("Race ongoing...");
        laneDropdown.setEnabled(false);
        trackLengthDropdown.setEnabled(false);
        Arrays.stream(this.getComponents()).forEach(c -> c.setEnabled(false));
    }
    public void enableAllComponents() {
        Arrays.stream(this.getComponents()).forEach(c -> c.setEnabled(true));
        laneDropdown.setEnabled(true);
        trackLengthDropdown.setEnabled(true);
        startButton.setText("Start");
    }
}
