package net.flaxeneel2.uni.sem2.oop.coursework.UI.modals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SpritesDrawer extends JFrame {
    private final int pixelSize = 10;
    private Color currentColor = Color.BLACK;
    private final JPanel canvas;
    private Color[][] pixelsDrawn;

    public SpritesDrawer(CreateHorse parentFrame) {
        this(parentFrame, null);
    }

    public SpritesDrawer(CreateHorse parentFrame, Color[][] canvasState) {
        setTitle("Draw your horse");
        setSize(416, 476);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        pixelsDrawn = canvasState;
        boolean fresh = canvasState == null;
        if(pixelsDrawn == null) pixelsDrawn = new Color[100][100];

        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int width = getWidth();
                int height = getHeight();
                int extX = 0;
                int extY = 0;
                for (int x = 0; x < width; x += pixelSize) {
                    for (int y = 0; y < height; y += pixelSize) {
                        if(fresh) {
                            pixelsDrawn[extX][extY] = new Color(255,255,255, 0);
                            g.setColor(Color.WHITE);
                        } else {
                            if(pixelsDrawn[x][y].getRGB() == new Color(255,255,255,0).getRGB()) g.setColor(Color.WHITE);
                            else g.setColor(pixelsDrawn[x][y]);
                        }
                        g.fillRect(x, y, pixelSize, pixelSize);
                        g.setColor(Color.BLACK);
                        g.drawRect(x, y, pixelSize, pixelSize);
                        extY++;
                    }
                    extY=0;
                    extX++;
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
        colorButton.addActionListener(e -> currentColor = JColorChooser.showDialog(null, "Choose Color", currentColor));
        JButton clearButton = new JButton("Clear Canvas");
        clearButton.addActionListener(e -> clearCanvas());
        controlPanel.add(colorButton);
        controlPanel.add(clearButton);
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            parentFrame.setSprite(this.pixelsDrawn);
            this.dispose();
        });
        controlPanel.add(saveButton);


        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void drawPixel(MouseEvent e) {
        if(e.getX() >= getWidth()-16 || e.getY() >= getHeight()-76 || e.getX() < 0 || e.getY() < 0) return;
        System.out.printf("Got through X: %s%n", e.getX());
        System.out.printf("Got through Y: %s%n", e.getY());
        int x = e.getX() / pixelSize * pixelSize;
        int y = e.getY() / pixelSize * pixelSize;
        pixelsDrawn[x/10][y/10] = currentColor;
        Graphics g = canvas.getGraphics();
        g.setColor(currentColor);
        g.fillRect(x, y, pixelSize, pixelSize);
    }

    private void clearCanvas() {
        Graphics g = canvas.getGraphics();
        int width = getWidth();
        int height = getHeight();
        int extX = 0;
        int extY = 0;
        for (int x = 0; x < width; x += pixelSize) {
            for (int y = 0; y < height; y += pixelSize) {
                pixelsDrawn[extX][extY] = new Color(255,255,255, 0);
                g.setColor(Color.WHITE);
                g.fillRect(x, y, pixelSize, pixelSize);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, pixelSize, pixelSize);
                extY++;
            }
            extY=0;
            extX++;
        }
    }
}
