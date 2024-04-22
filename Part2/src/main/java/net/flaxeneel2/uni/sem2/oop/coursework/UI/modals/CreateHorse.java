package net.flaxeneel2.uni.sem2.oop.coursework.UI.modals;

import javax.swing.*;
import java.awt.*;

import static net.flaxeneel2.uni.sem2.oop.coursework.Main.STORAGE;

public class CreateHorse extends JFrame {

    private Color[][] canvasState;

    private JButton editButton;

    private String breed;

    private String name;



    public CreateHorse() {
        super("Create Horse");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        setSize(400, 400);
        this.setResizable(false);

        this.addNameInput();
        this.addBreeds();
        this.addCanvasOperations();



        this.setVisible(true);
    }

    private void addBreeds() {
        JPanel breedsContainer = new JPanel();
        breedsContainer.setPreferredSize(new Dimension(this.getWidth()-20, 25));
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
        breeds.setPreferredSize(new Dimension(this.getWidth()/2, 25));
        breedsContainer.add(new JLabel("Breed:"), BorderLayout.WEST);
        breedsContainer.add(breeds, BorderLayout.EAST);
        this.add(breedsContainer);
    }

    private void addNameInput() {
        JPanel nameInputContainer = new JPanel();
        nameInputContainer.setLayout(new BorderLayout());
        nameInputContainer.setPreferredSize(new Dimension(this.getWidth()-20, 25));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameInput = new JTextField();
        nameInput.addActionListener(e -> {
            name = nameInput.getText();
        });
        nameInput.setPreferredSize(new Dimension(this.getWidth()/2, 25));
        nameInputContainer.add(nameLabel, BorderLayout.WEST);
        nameInputContainer.add(nameInput, BorderLayout.EAST);
        this.add(nameInputContainer);

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

    public void saveHorseToStore() {
        STORAGE.addHorse(null);
    }
}
