package net.flaxeneel2.uni.sem2.oop.coursework.UI;

import net.flaxeneel2.uni.sem2.oop.coursework.UI.components.HorseLanes;
import net.flaxeneel2.uni.sem2.oop.coursework.UI.components.HorseStatus;
import net.flaxeneel2.uni.sem2.oop.coursework.UI.components.SettingsBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RaceUI extends JFrame {
    private HorseLanes lanes;
    private HorseStatus race;
    private SettingsBar settingsBar;
    public RaceUI() {
        super("Horse Race simulator");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Horse simulator");
        this.setSize(new Dimension(800, 600));
        this.setMinimumSize(new Dimension(800, 600));


        this.setLayout(new BorderLayout());

        this.getContentPane().setBackground(new Color(85, 85, 85));

        this.setThemingDefaults();
    }

    public void initialise() {

        this.settingsBar = new SettingsBar();
        this.add(settingsBar, BorderLayout.NORTH);


        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                System.out.printf("Resizing components. \tHeight:%s\tWidth:%s\n", RaceUI.super.getHeight(), RaceUI.super.getWidth());
                lanes.dealWithSizeChange(RaceUI.super.getWidth(), RaceUI.super.getHeight());
                race.dealWithSizeChange(RaceUI.super.getWidth(), RaceUI.super.getHeight());
                lanes.revalidate();
                lanes.repaint();
                race.revalidate();
                race.repaint();
            }
        });


        this.lanes = new HorseLanes();
        this.add(this.lanes, BorderLayout.WEST);

        this.race = new HorseStatus();
        this.add(this.race, BorderLayout.EAST);

        this.setVisible(true);

    }

    public HorseLanes getLanes() {
        return this.lanes;
    }



    public void setThemingDefaults() {

        UIManager.put("Panel.background", new Color(34, 34, 34));
        UIManager.put("Panel.foreground", new Color(255, 255, 255));

        UIManager.put("Label.background", new Color(34, 34, 34));
        UIManager.put("Label.foreground", new Color(255, 255, 255));
        UIManager.put("Label.disabledForeground", new Color(100, 100, 100));

        UIManager.put("ComboBox.background", new Color(34, 34, 34));
        UIManager.put("ComboBox.foreground", new Color(255, 255, 255));
        //UIManager.put("ComboBox.selectionBackground", new Color(34, 34, 34));
        //UIManager.put("ComboBox.selectionForeground", new Color(255, 255, 255));

        UIManager.put("Button.background", new Color(34, 34, 34));
        UIManager.put("Button.foreground", new Color(255, 255, 255));

        UIManager.put("ScrollBar.background", new Color(34, 34, 34));
        UIManager.put("ScrollBar.foreground", new Color(255, 255, 255));
        UIManager.put("ScrollBar.thumb", new Color(0, 0, 0));

        UIManager.put("TextField.background", new Color(34, 34, 34));
        UIManager.put("TextField.foreground", new Color(255, 255, 255));
        UIManager.put("TextField.caretForeground" , Color.WHITE);


        UIManager.put("Slider.background", new Color(34, 34, 34));
        UIManager.put("Slider.foreground", new Color(255, 255, 255));



    }



    public void startRace() {
        this.settingsBar.disableAllComponents();
        this.lanes.readyAllHorses();
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(lanes::tickAllHorses, 100, 16, TimeUnit.MILLISECONDS);
        Runnable r = () -> this.settingsBar.enableAllComponents();
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        executorService.schedule(r, 5, TimeUnit.SECONDS);
    }
}
