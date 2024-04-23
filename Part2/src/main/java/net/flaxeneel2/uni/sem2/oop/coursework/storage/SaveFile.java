package net.flaxeneel2.uni.sem2.oop.coursework.storage;

import java.awt.*;
import java.io.Serializable;

public class SaveFile implements Serializable {
    public HorsesStore horses = new HorsesStore();
    public Color laneColor = Color.WHITE;
    public Color laneBorderColor = Color.BLACK;
    public boolean randomLaneColors = false;
}
