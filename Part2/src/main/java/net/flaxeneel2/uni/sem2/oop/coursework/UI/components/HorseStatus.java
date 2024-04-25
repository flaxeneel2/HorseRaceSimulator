package net.flaxeneel2.uni.sem2.oop.coursework.UI.components;

import net.flaxeneel2.uni.sem2.oop.coursework.Main;
import net.flaxeneel2.uni.sem2.oop.coursework.UI.modals.Bet;
import net.flaxeneel2.uni.sem2.oop.coursework.UI.modals.ViewHorseStats;
import net.flaxeneel2.uni.sem2.oop.coursework.util.OddsCalculator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HorseStatus extends JPanel {
    private ArrayList<Horse> horses;
    private int position = 1;
    private int numFinished = 0;
    private Horse winnerHorse = null;
    public HorseStatus() {

        super();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension((int) (Main.UI_INSTANCE.getSize().width*0.3), Main.UI_INSTANCE.getHeight()-100));
    }


    public void updateLanes(ArrayList<Horse> newHorses) {
        if(horses == null) this.horses = newHorses;
        this.updateLanes();
    }

    public void updateLanes() {
        this.removeAll();

        this.position = 1;
        this.winnerHorse = null;

        OddsCalculator.calculateOdds(this.horses);


        for(Horse horse : this.horses) {
            JPanel horseStatus = new JPanel();
            horseStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
            horseStatus.setLayout(new GridLayout(1, 2));
            horseStatus.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
            JPanel horseInfo = new JPanel();
            horseInfo.setLayout(new GridLayout(4, 1));

            horseInfo.add(new JLabel("Name: " + horse.getHorseData().getName()));

            JLabel confidence = new JLabel(String.format("Confidence: %.3f", horse.getHorseData().getConfidence()));
            this.putClientProperty(horse.getHorseData().getName() + "-confidence", confidence);
            horseInfo.add(confidence);

            horseInfo.add(new JLabel("Breed: " + horse.getHorseData().getBreed()));
            horseInfo.add(new JLabel(String.format("Odds: %.3f", horse.getOdds())));
            JPanel horseStatusRight = new JPanel();
            horseStatusRight.setLayout(new GridLayout(4, 1));

            JLabel positioning = new JLabel("Position: DNF");
            this.putClientProperty(horse.getHorseData().getName() + "-positioning", positioning);

            horseStatusRight.add(positioning);

            JLabel status = new JLabel("Status: Running");
            this.putClientProperty(horse.getHorseData().getName() + "-status", status);
            horseStatusRight.add(status);

            JButton betButton = new JButton("Bet on this horse");
            betButton.addActionListener(e -> new Bet(horse));

            horseStatusRight.add(betButton);

            JButton viewStats = new JButton("View stats of this horse");
            viewStats.addActionListener(e -> new ViewHorseStats(horse.getHorseData()));


            horseStatusRight.add(viewStats);
            horseStatus.add(horseInfo);
            horseStatus.add(horseStatusRight);
            this.add(horseStatus);
        }
        this.revalidate();
        this.repaint();
    }

    public void updateConfidenceOfHorse(Horse horse) {
        JLabel confidence = (JLabel) this.getClientProperty(horse.getHorseData().getName() + "-confidence");
        confidence.setText(String.format("Confidence: %.3f", horse.getHorseData().getConfidence()));
        numFinished++;
        if(numFinished == this.horses.size()) {
            Main.UI_INSTANCE.stopRace();
            this.numFinished = 0;
        }
    }

    public void updatePositioningOfHorse(Horse horse) {
        JLabel positioning = (JLabel) this.getClientProperty(horse.getHorseData().getName() + "-positioning");
        positioning.setText("Position: " + this.position);
        if(position == 1) {
            winnerHorse = horse.clone();
            horse.getHorseData().setRacesWon(horse.getHorseData().getRacesWon()+1);
        }
        else horse.getHorseData().setRacesLost(horse.getHorseData().getRacesLost()+1);
        switch (position) {
            case 1:
                positioning.setForeground(new Color(255, 215, 0));
                break;
            case 2:
                positioning.setForeground(new Color(255, 255, 255));
                break;
            case 3:
                positioning.setForeground(new Color(205, 127, 50));
                break;
            default:
                positioning.setForeground(new Color(255, 255, 255, 128));
                break;
        }
        position++;
    }

    public Horse getWinnerHorse() {
        return winnerHorse;
    }

    public void updateStatusOfHorse(Horse horse, String status) {
        JLabel statusLabel = (JLabel) this.getClientProperty(horse.getHorseData().getName() + "-status");
        if(status.equals("Fallen")) {
            statusLabel.setForeground(Color.RED);
            JLabel positioning = (JLabel) this.getClientProperty(horse.getHorseData().getName() + "-positioning");
            positioning.setForeground(Color.RED);
        }
        statusLabel.setText("Status: " + status);
    }

    public void dealWithSizeChange(int newWidth, int newHeight) {
        this.setPreferredSize(new Dimension((int) (newWidth*0.3), newHeight-100));
    }
}
