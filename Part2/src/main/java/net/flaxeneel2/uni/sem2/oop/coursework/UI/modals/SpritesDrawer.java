package net.flaxeneel2.uni.sem2.oop.coursework.UI.modals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SpritesDrawer extends JFrame {
    private int pixelSize = 10;
    private Color currentColor = Color.BLACK;
    private JPanel canvas;
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
        if(pixelsDrawn == null) pixelsDrawn = new Color[getWidth()/pixelSize * pixelSize][getHeight()/pixelSize * pixelSize];

        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int width = getWidth();
                int height = getHeight();

                for (int x = 0; x < width; x += pixelSize) {
                    for (int y = 0; y < height; y += pixelSize) {
                        if(fresh) {
                            pixelsDrawn[x][y] = new Color(255,255,255, 0);
                            g.setColor(Color.WHITE);
                        } else {
                            if(pixelsDrawn[x][y].getRGB() == new Color(255,255,255,0).getRGB()) g.setColor(Color.WHITE);
                            else g.setColor(pixelsDrawn[x][y]);
                        }
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
        if(e.getX() >= getWidth() || e.getY() >= getHeight() || e.getX() < 0 || e.getY() < 0) return;
        int x = e.getX() / pixelSize * pixelSize;
        int y = e.getY() / pixelSize * pixelSize;
        pixelsDrawn[x][y] = currentColor;
        Graphics g = canvas.getGraphics();
        g.setColor(currentColor);
        g.fillRect(x, y, pixelSize, pixelSize);
    }

    private void clearCanvas() {
        Graphics g = canvas.getGraphics();
        int width = getWidth();
        int height = getHeight();
        for (int x = 0; x < width-pixelSize; x += pixelSize) {
            for (int y = 0; y < height-pixelSize; y += pixelSize) {
                pixelsDrawn[x][y] = new Color(255,255,255, 0);
                g.setColor(Color.WHITE);
                g.fillRect(x, y, pixelSize, pixelSize);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, pixelSize, pixelSize);
            }
        }
    }
}
