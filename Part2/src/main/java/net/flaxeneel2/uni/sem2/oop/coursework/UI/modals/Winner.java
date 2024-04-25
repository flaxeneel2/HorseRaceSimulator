package net.flaxeneel2.uni.sem2.oop.coursework.UI.modals;

import javax.swing.*;
import net.flaxeneel2.uni.sem2.oop.coursework.UI.components.Horse;

import java.awt.*;

public class Winner extends JFrame {
    public Winner(Horse winnerHorse) {
        super("Race Over!");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(400, 200);
        if(winnerHorse != null) {
            this.add(new JLabel("The horse " + winnerHorse.getHorseData().getName() + " has won the race!"));
            this.add(new JLabel("Total number of victories by this horse: " + winnerHorse.getHorseData().getRacesWon()));
            this.add(new JLabel("The horse had $" + winnerHorse.getAmountBet() + " bet on it!"));
            this.add(new JLabel("Congratulations to everyone that bet on this horse"));
        } else {
            this.add(new JLabel("All horses fell! There are no winners!"));
        }

        JButton ok = new JButton("OK");
        ok.setSize(new Dimension(this.getWidth()/2, 25));
        ok.addActionListener(e -> this.dispose());
        this.add(ok);

        this.setVisible(true);
    }
}
