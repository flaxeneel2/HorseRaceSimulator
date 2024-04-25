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
        informationPanel.setLayout(new GridLayout(9, 2));
        informationPanel.setSize(new Dimension(this.getWidth(), this.getHeight()));

        informationPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        informationPanel.add(new JLabel("Name"));
        informationPanel.add(new JLabel(horseData.getName()));

        informationPanel.add(new JLabel("Breed"));
        informationPanel.add(new JLabel(horseData.getBreed()));

        informationPanel.add(new JLabel("Confidence"));
        informationPanel.add(new JLabel(String.format("%.3f", horseData.getConfidence())));

        informationPanel.add(new JLabel("Total number of races"));
        informationPanel.add(new JLabel(String.valueOf(horseData.getRacesLost() + horseData.getRacesWon())));

        informationPanel.add(new JLabel("Total number of races lost"));
        informationPanel.add(new JLabel(String.valueOf(horseData.getRacesLost())));

        informationPanel.add(new JLabel("Total number of races won"));
        informationPanel.add(new JLabel(String.valueOf(horseData.getRacesWon())));

        informationPanel.add(new JLabel("Total distance travelled"));
        informationPanel.add(new JLabel(horseData.getTotalDistanceTravelled()/40.0 + " meters."));

        informationPanel.add(new JLabel("Total Time spent on track"));
        informationPanel.add(new JLabel(horseData.getTimeOnTrack() + " ticks"));

        informationPanel.add(new JLabel("Average speed"));
        informationPanel.add(new JLabel(String.format("%.2f km/h", horseData.getAverageSpeed())));


        this.add(informationPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
