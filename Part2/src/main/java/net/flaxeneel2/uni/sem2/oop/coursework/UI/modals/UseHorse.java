package net.flaxeneel2.uni.sem2.oop.coursework.UI.modals;

import net.flaxeneel2.uni.sem2.oop.coursework.Main;
import net.flaxeneel2.uni.sem2.oop.coursework.storage.HorseData;

import javax.swing.*;
import java.awt.*;

public class UseHorse extends JFrame {
    private int selectedLane = 1;
    public UseHorse(HorseData horse) {
        super("Select a lane for the horse");

        this.setSize(new Dimension(400, 200));
        this.setLayout(new GridLayout(2, 1));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        JPanel selector = new JPanel();

        selector.setSize(new Dimension(this.getWidth(), 50));

        GridLayout selectorLayout = new GridLayout(1, 2);
        selectorLayout.setHgap(10);
        selector.setLayout(selectorLayout);
        selector.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
        selector.add(new JLabel("Lane: "));


        JComboBox<Integer> possibleLanes = new JComboBox<>();
        for(int i = 1; i<= Main.UI_INSTANCE.getLanes().getLaneCount(); i++) {
            possibleLanes.addItem(i);
        }
        possibleLanes.addActionListener(e -> selectedLane = possibleLanes.getSelectedIndex()+1);

        JPanel actions = new JPanel();
        GridLayout actionsLayout = new GridLayout(1, 2);
        actions.setLayout(actionsLayout);

        actions.setSize(new Dimension(this.getWidth(), 50));

        JButton ok = new JButton("OK");

        ok.addActionListener(e -> {
            Main.UI_INSTANCE.getLanes().setHorse(horse, selectedLane-1);
            this.dispose();
        });

        JButton cancel = new JButton("Cancel");

        cancel.addActionListener(e -> this.dispose());

        selector.add(possibleLanes);
        actions.add(ok);
        actions.add(cancel);
        this.add(selector);
        this.add(actions);
        this.setVisible(true);
    }
}
