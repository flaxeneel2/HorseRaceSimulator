package net.flaxeneel2.uni.sem2.oop.coursework.UI.modals;

import net.flaxeneel2.uni.sem2.oop.coursework.Horse;

import javax.swing.*;
import java.util.ArrayList;

public class ViewHorses extends JFrame {

    public ViewHorses() {
        this.setTitle("Saved Horses");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setLocationRelativeTo(null);
        setSize(400, 440);
        this.setVisible(true);

        JButton newHorse = new JButton("New Horse");
        newHorse.addActionListener(e -> {
            new CreateHorse();
        });
        this.add(newHorse);
    }

    public void addEntry(Horse horse) {

    }

    public void addEntries(ArrayList<Horse> horses) {

    }
}
