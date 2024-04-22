package net.flaxeneel2.uni.sem2.oop.coursework.UI.modals;

import javax.swing.*;
import java.awt.*;

public class CreateHorse extends JFrame {

    private Color[][] canvasState;

    private JButton editButton;

    public CreateHorse() {
        super("Create Horse");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        setSize(400, 400);
        this.setResizable(false);

        this.addBreeds();
        this.addCanvasOperations();



        this.setVisible(true);
    }

    private void addBreeds() {
        JPanel breedsContainer = new JPanel();
        breedsContainer.setLayout(new BorderLayout());
        JComboBox<String> breeds = new JComboBox<>(new String[]{"Thoroughbred",
                "Arabian",
                "Quarter Horse",
                "Appaloosa",
                "American Paint Horse",
                "Morgan",
                "Tennessee Walking Horse",
                "Andalusian",
                "Friesian",
                "Clydesdale"});

        this.add(new JLabel("Breeds:"), BorderLayout.WEST);
        this.add(breeds, BorderLayout.EAST);
    }

    private void addCanvasOperations() {
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.X_AXIS));
        JButton drawButton = new JButton("Draw a new horse");
        drawButton.addActionListener(e -> {
            new SpritesDrawer(this);
        });
        this.editButton = new JButton("Edit existing horse");
        this.editButton.addActionListener(e -> {
            new SpritesDrawer(this, canvasState);
        });
        this.editButton.setEnabled(false);
        optionsPanel.add(drawButton);
        optionsPanel.add(this.editButton);
        this.add(optionsPanel);
    }

    public void setCanvasState(Color[][] canvasState) {
        this.editButton.setEnabled(true);
        this.canvasState = canvasState;
    }
}
