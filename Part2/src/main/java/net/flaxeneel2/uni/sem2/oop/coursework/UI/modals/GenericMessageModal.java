package net.flaxeneel2.uni.sem2.oop.coursework.UI.modals;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class GenericMessageModal extends JFrame {
    public GenericMessageModal(String title) {
        super(title);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
    }
    private void addOkButton() {
        JButton ok = new JButton("OK");
        ok.setSize(new Dimension(this.getWidth()/2, 25));
        ok.addActionListener(e -> this.dispose());
        this.getContentPane().add(ok);
    }

    public void setMessages(ArrayList<String> messages) {
        this.getContentPane().removeAll();
        setLayout(new GridLayout(messages.size()+1, 1));
        messages.forEach(message -> this.add(new JLabel(message)));
        addOkButton();
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }

    public void setMessages(String ...messages) {
        ArrayList<String> messagesList = new ArrayList<>();
        Collections.addAll(messagesList, messages);
        this.setMessages(messagesList);
    }

    public void makeVisibile() {
        this.setVisible(true);
    }

}
