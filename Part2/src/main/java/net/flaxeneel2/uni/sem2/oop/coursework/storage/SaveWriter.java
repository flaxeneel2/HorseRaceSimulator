package net.flaxeneel2.uni.sem2.oop.coursework.storage;

import javax.swing.*;
import java.io.*;

public class SaveWriter {
    public static void save(SaveFile s, File saveFile) {
        try {
            FileOutputStream fos = new FileOutputStream(saveFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s);
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
    }
    public static SaveFile load(File saveFile) {
        try {
            FileInputStream fis = new FileInputStream(saveFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            SaveFile save = (SaveFile) ois.readObject();
            ois.close();
            fis.close();
            return save;
        } catch (IOException | ClassNotFoundException ignored) {
            ignored.printStackTrace();
        }
        return null;
    }
}
