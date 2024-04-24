package net.flaxeneel2.uni.sem2.oop.coursework.UI.modals;

import net.flaxeneel2.uni.sem2.oop.coursework.storage.HorseData;

import javax.swing.*;
import java.awt.*;

public class ViewHorseStats extends JFrame {
    public ViewHorseStats(HorseData horseData) {
        super("View Horse Stats");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(new Dimension(416, 600));
        setLayout(new BorderLayout());

        JPanel informationPanel = new JPanel();
        informationPanel.setLayout(new GridLayout(7, 2));
        informationPanel.setSize(new Dimension(this.getWidth(), this.getHeight()));

        informationPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        informationPanel.add(new JLabel("Name"));
        informationPanel.add(new JLabel(horseData.getName()));

        informationPanel.add(new JLabel("Breed"));
        informationPanel.add(new JLabel(horseData.getBreed()));

        informationPanel.add(new JLabel("Confidence"));
        informationPanel.add(new JLabel(String.valueOf(horseData.getConfidence())));

        informationPanel.add(new JLabel("Total number of races"));
        informationPanel.add(new JLabel(String.valueOf(horseData.getRacesLost() + horseData.getRacesWon())));

        informationPanel.add(new JLabel("Total number of races lost"));
        informationPanel.add(new JLabel(String.valueOf(horseData.getRacesLost())));

        informationPanel.add(new JLabel("Total number of races won"));
        informationPanel.add(new JLabel(String.valueOf(horseData.getRacesWon())));

        informationPanel.add(new JLabel("Total distance travelled"));
        informationPanel.add(new JLabel(String.valueOf(horseData.getTotalDistanceTravelled())));


        this.add(informationPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
