package net.flaxeneel2.uni.sem2.oop.coursework.UI.modals;

import net.flaxeneel2.uni.sem2.oop.coursework.UI.components.Horse;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static net.flaxeneel2.uni.sem2.oop.coursework.Main.STORAGE;

public class ViewHorses extends JFrame {

    private JPanel horsesList;

    public ViewHorses() {
        this.setTitle("Saved Horses");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setLocationRelativeTo(null);
        setSize(400, 440);
        this.setVisible(true);



        JButton newHorse = new JButton("+ New Horse");
        newHorse.addActionListener(e -> {
            new CreateHorse();
        });
        newHorse.setBackground(Color.BLUE);
        newHorse.setAlignmentX(Component.RIGHT_ALIGNMENT);
        this.add(newHorse);

        this.horsesList = new JPanel();

        this.addEntries(new ArrayList<>(Arrays.asList(STORAGE.getAllHorses())));
    }

    public void addEntry(Horse horse) {

    }

    public void addEntries(ArrayList<Horse> horses) {
        //Arrays.stream(this.horsesList.getComponents()).forEach(Component::di)
    }
}
