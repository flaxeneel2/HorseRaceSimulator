package net.flaxeneel2.uni.sem2.oop.coursework.UI.modals;

import javax.swing.*;
import java.awt.*;

public class CreateHorse extends JFrame {
    public CreateHorse() {
        super("Create Horse");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        setSize(400, 400);
        this.setResizable(false);


        JButton drawButton = new JButton("Draw a new horse");
        drawButton.addActionListener(e -> {
            new SpritesDrawer();
        });
        this.add(drawButton);

        this.setVisible(true);
    }
}
