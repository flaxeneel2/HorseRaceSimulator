package net.flaxeneel2.uni.sem2.oop.coursework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Testarea extends JFrame {
    private final int pixelSize = 10;
    private Color currentColor = Color.BLACK;
    private final JPanel canvas;

    public Testarea() {
        setTitle("Draw your horse");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int width = getWidth();
                int height = getHeight();
                for (int x = 0; x < width; x += pixelSize) {
                    for (int y = 0; y < height; y += pixelSize) {
                        g.setColor(Color.WHITE);
                        g.fillRect(x, y, pixelSize, pixelSize);
                        g.setColor(Color.BLACK);
                        g.drawRect(x, y, pixelSize, pixelSize);
                    }
                }
            }
        };
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawPixel(e);
            }
        });
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                drawPixel(e);
            }
        });

        JPanel controlPanel = new JPanel();
        JButton colorButton = new JButton("Choose Color");
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = JColorChooser.showDialog(null, "Choose Color", currentColor);
            }
        });
        JButton clearButton = new JButton("Clear Canvas");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearCanvas();
            }
        });
        controlPanel.add(colorButton);
        controlPanel.add(clearButton);
        controlPanel.add(new JButton("Save"));

        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void drawPixel(MouseEvent e) {
        int x = e.getX() / pixelSize * pixelSize;
        int y = e.getY() / pixelSize * pixelSize;
        Graphics g = canvas.getGraphics();
        g.setColor(currentColor);
        g.fillRect(x, y, pixelSize, pixelSize);
    }

    private void clearCanvas() {
        Graphics g = canvas.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Testarea::new);
    }
}
