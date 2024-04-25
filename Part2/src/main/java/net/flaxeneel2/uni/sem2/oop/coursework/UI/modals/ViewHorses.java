package net.flaxeneel2.uni.sem2.oop.coursework.UI.modals;

import net.flaxeneel2.uni.sem2.oop.coursework.storage.HorseData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static net.flaxeneel2.uni.sem2.oop.coursework.Main.getSaveFile;

public class ViewHorses extends JFrame {


    public ViewHorses() {
        this.setTitle("Saved Horses");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FlowLayout layout = new FlowLayout();
        layout.setVgap(10);

        this.setLayout(layout);
        this.setLocationRelativeTo(null);
        setSize(400, 440);
        this.setVisible(true);
        this.setResizable(false);



        JButton newHorse = new JButton("+ New Horse");
        newHorse.addActionListener(e -> new CreateHorse(this));
        newHorse.setBackground(Color.BLUE);
        newHorse.setAlignmentX(Component.RIGHT_ALIGNMENT);
        this.add(newHorse);

        this.addEntries(new ArrayList<>(Arrays.asList(getSaveFile().horses.getAllHorses())));
    }

    public void addEntry(HorseData horse) {
        JPanel horsePanel = new JPanel();

        horsePanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        GridLayout gridLayout = new GridLayout(1, 2);
        horsePanel.setLayout(gridLayout);

        horsePanel.setBackground(new Color(54,54,54));

        horsePanel.setPreferredSize(new Dimension(this.getWidth(), 100));



        JPanel actions = new JPanel();

        actions.setLayout(new BorderLayout());
        actions.setBackground(new Color(54,54,54));

        JPanel details = new JPanel();
        details.setLayout(new BoxLayout(details, BoxLayout.Y_AXIS));
        details.setBackground(new Color(54,54,54));
        details.add(new JLabel("Name: " + horse.getName()));
        details.add(new JLabel("Confidence: " + horse.getConfidence()));
        details.add(new JLabel("Breed: " + horse.getBreed()));

        horsePanel.add(details);

        JButton useHorse = new JButton("Use Horse");

        useHorse.addActionListener(e -> new UseHorse(horse));

        JButton deleteHorse = new JButton("Delete Horse");

        deleteHorse.setBackground(new Color(124, 45, 45, 255));

        deleteHorse.addActionListener(e -> {
            getSaveFile().horses.removeHorse(horse.getName());
            this.remove(horsePanel);
            this.revalidate();
            this.repaint();
        });

        JButton viewHorseStats = new JButton("View Horse Stats");

        viewHorseStats.addActionListener(e -> new ViewHorseStats(horse));


        actions.add(useHorse,       BorderLayout.NORTH);
        actions.add(viewHorseStats, BorderLayout.CENTER);
        actions.add(deleteHorse,    BorderLayout.SOUTH);


        horsePanel.add(actions);

        this.add(horsePanel);
        this.revalidate();
        this.repaint();
    }

    public void addEntries(ArrayList<HorseData> horses) {
        horses.forEach(this::addEntry);
    }
}
