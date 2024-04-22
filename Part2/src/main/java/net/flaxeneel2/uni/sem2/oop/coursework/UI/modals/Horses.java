package net.flaxeneel2.uni.sem2.oop.coursework.UI.modals;

import net.flaxeneel2.uni.sem2.oop.coursework.Horse;

import javax.swing.*;
import java.util.ArrayList;

public class Horses extends JFrame {

    public Horses() {
        this.setTitle("Saved Horses");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void addEntry(Horse horse) {

    }

    public void addEntries(ArrayList<Horse> horses) {

    }
}
