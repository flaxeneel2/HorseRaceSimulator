package net.flaxeneel2.uni.sem2.oop.coursework;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Testarea extends JFrame {
    private DisplayGraphics canvas;
    public static void main(String[] args) {
        new Testarea();
    }


    public Testarea() {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DisplayGraphics graphics = new DisplayGraphics(800);
        this.canvas = graphics;
        frame.add(graphics);
        frame.setVisible(true);
        this.startTicking();
        canvas.startTicking();

    }

    public void startTicking() {
        Runnable r = this::tick;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(r, 100, 2, TimeUnit.MILLISECONDS);
    }

    public void tick() {
        this.canvas.tick();
    }



}

class DisplayGraphics extends Canvas {
    private int offset;
    private int mult;
    private int limit;
    public void paint(Graphics g) {
        System.out.println(offset);
        g.clearRect(offset-mult, 30, Math.abs(mult), 80);
        g.fillRect(offset, 30,100, 80);


    }
    public DisplayGraphics(int limit) {
        setBackground(Color.WHITE);
        setForeground(Color.RED);
        this.offset = 0;
        this.mult = 10;
        this.limit = limit;



    }

    public boolean isReady() {
        return this.getBufferStrategy() != null;
    }

    public void startTicking() {
//        this.createBufferStrategy(3);
//        BufferStrategy strat = this.getBufferStrategy();
//        Graphics g = strat.getDrawGraphics();
//        do {
//            int newOffset = offset + (mult);
//            if(newOffset > limit) {
//                newOffset = limit;
//                mult = -10;
//            } else if(newOffset < 0) {
//                newOffset = 0;
//                mult = 10;
//            }
//            offset = newOffset;
//
//            try {
//                System.out.println(offset);
//                g.fillRect(offset, 30,100, 80);
//
//            } finally {
//                g.dispose();
//            }
//            strat.show();
//        } while (strat.contentsLost());
    }

    public void tick() {
        int newOffset = offset + (mult);
        if(newOffset > limit) {
            newOffset = limit;
            mult = -10;
        } else if(newOffset < 0) {
            newOffset = 0;
            mult = 10;
        }
        offset = newOffset;
        this.paint(this.getGraphics());

    }

}