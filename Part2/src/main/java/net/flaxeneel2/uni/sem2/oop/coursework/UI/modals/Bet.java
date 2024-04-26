package net.flaxeneel2.uni.sem2.oop.coursework.UI.modals;

import net.flaxeneel2.uni.sem2.oop.coursework.Main;
import net.flaxeneel2.uni.sem2.oop.coursework.UI.components.Horse;
import net.flaxeneel2.uni.sem2.oop.coursework.util.IntegerFilter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class Bet extends JFrame {
    public Bet(Horse horse) {
        super("Bet");

        this.setLayout(new GridLayout(2, 1));
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel betPanel = new JPanel();
        betPanel.setLayout(new FlowLayout());
        betPanel.setPreferredSize(new Dimension(this.getWidth(), 25));
        betPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 25, 5));
        JTextField amountInput = new JTextField();

        ((PlainDocument) amountInput.getDocument()).setDocumentFilter(new IntegerFilter(0, Main.getSaveFile().balance));

        JButton ok = new JButton("OK");

        ok.setEnabled(false);

        amountInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                ok.setEnabled(!amountInput.getText().isEmpty());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                ok.setEnabled(!amountInput.getText().isEmpty());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                ok.setEnabled(!amountInput.getText().isEmpty());
            }
        });
        amountInput.setPreferredSize(new Dimension(this.getWidth()/2, 25));

        betPanel.add(new JLabel("Amount to bet:"));
        betPanel.add(amountInput);
        this.add(betPanel);

        JPanel actions = new JPanel();
        FlowLayout actionsLayout = new FlowLayout();
        actions.setLayout(actionsLayout);

        actions.setPreferredSize(new Dimension(this.getWidth(), 25));



        ok.addActionListener(e -> {
            int amount = Integer.parseInt(amountInput.getText());
            horse.addToBet(amount);
            Main.getSaveFile().balance-=amount;
            this.dispose();
        });

        JButton cancel = new JButton("Cancel");

        cancel.addActionListener(e -> this.dispose());

        actions.add(ok);
        actions.add(cancel);

        this.add(actions);

        this.setVisible(true);
    }
}
