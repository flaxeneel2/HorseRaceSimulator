package net.flaxeneel2.uni.sem2.oop.coursework.UI.components;

import net.flaxeneel2.uni.sem2.oop.coursework.Main;

import javax.swing.*;
import java.awt.*;

public class RaceData extends JPanel {
    public RaceData() {
        super(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension((int) (Main.UI_INSTANCE.getSize().width*0.3), Main.UI_INSTANCE.getHeight()-100));
    }


    public void dealWithSizeChange(int newWidth, int newHeight) {
        this.setPreferredSize(new Dimension((int) (newWidth*0.3), newHeight-100));
    }
}
