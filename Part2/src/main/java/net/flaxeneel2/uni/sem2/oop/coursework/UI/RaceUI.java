package net.flaxeneel2.uni.sem2.oop.coursework.UI;

import net.flaxeneel2.uni.sem2.oop.coursework.UI.components.HorseLanes;
import net.flaxeneel2.uni.sem2.oop.coursework.UI.components.HorseStatus;
import net.flaxeneel2.uni.sem2.oop.coursework.UI.components.SettingsBar;
import net.flaxeneel2.uni.sem2.oop.coursework.UI.modals.Winner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RaceUI extends JFrame {
    private HorseLanes lanes;
    private HorseStatus raceStatus;
    private SettingsBar settingsBar;
    private ScheduledExecutorService executor;
    public RaceUI() {
        super("Horse Race simulator");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Horse simulator");
        this.setSize(new Dimension(1200, 600));
        this.setMinimumSize(new Dimension(800, 600));


        this.setLayout(new BorderLayout());

        this.getContentPane().setBackground(new Color(85, 85, 85));

        this.setThemingDefaults();
    }

    public void updateBalance() {
        this.settingsBar.updateBalance();
    }

    public void initialise() {

        this.settingsBar = new SettingsBar();
        this.add(settingsBar, BorderLayout.NORTH);


        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                dealWithSizeChange();
            }
        });


        this.lanes = new HorseLanes();
        this.add(this.lanes, BorderLayout.WEST);

        this.raceStatus = new HorseStatus();
        this.add(this.raceStatus, BorderLayout.EAST);

        SwingUtilities.invokeLater(this::dealWithSizeChange);


        this.lanes.updateLanes(3);

        this.setVisible(true);

    }

    public void dealWithSizeChange() {
        System.out.printf("Resizing components. \tWidth:%s\tHeight:%s\n", RaceUI.super.getWidth(), RaceUI.super.getHeight());
        lanes.dealWithSizeChange(RaceUI.super.getWidth(), RaceUI.super.getHeight());
        raceStatus.dealWithSizeChange(RaceUI.super.getWidth(), RaceUI.super.getHeight());
        lanes.revalidate();
        lanes.repaint();
        raceStatus.revalidate();
        raceStatus.repaint();
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
        UIManager.put("ComboBox.disabledBackground", new Color(34, 34, 34));
        UIManager.put("ComboBox.foreground", new Color(255, 255, 255));

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

        UIManager.put("ScrollPane.background", new Color(34, 34, 34));
        UIManager.put("ScrollPane.foreground", new Color(255, 255, 255));

        UIManager.put("TabbedPane.background", new Color(34, 34, 34));
        UIManager.put("TabbedPane.foreground", new Color(255, 255, 255));

        UIManager.put("List.background", new Color(34, 34, 34));
        UIManager.put("List.foreground", new Color(255, 255, 255));

        UIManager.put("CheckBox.background", new Color(34, 34, 34));
        UIManager.put("CheckBox.foreground", new Color(255, 255, 255));

    }

    public HorseStatus getRaceStatus() {
        return raceStatus;
    }

    public void stopRace() {
        executor.shutdown();
        this.settingsBar.enableAllComponents();
        this.updateBalance();
        new Winner(this.raceStatus.getWinnerHorse());
    }

    public void resetRace() {
        this.lanes.readyAllHorses();
        this.settingsBar.enableAllComponents();
        this.updateBalance();
        this.raceStatus.updateLanes();
    }

    public void startRace() {
        this.settingsBar.disableAllComponents();
        this.updateBalance();
        this.raceStatus.updateLanes();
        this.lanes.readyAllHorses();
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(lanes::tickAllHorses, 0, 16667, TimeUnit.MICROSECONDS);
    }
}
