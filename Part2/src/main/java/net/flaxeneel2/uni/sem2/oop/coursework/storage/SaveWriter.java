package net.flaxeneel2.uni.sem2.oop.coursework.storage;

import net.flaxeneel2.uni.sem2.oop.coursework.UI.modals.GenericMessageModal;

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
        } catch (IOException e) {
            GenericMessageModal errorModal = new GenericMessageModal("Cannot write save file to disk!");
            errorModal.setMessages("Cannot write save file to disk!", "Please view the error below: ", e.getLocalizedMessage());
            errorModal.makeVisibile();
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
        } catch (IOException | ClassNotFoundException e) {
            GenericMessageModal errorModal = new GenericMessageModal("Cannot load save file from disk!");
            errorModal.setMessages("Cannot load save file from disk!", "Please view the error below:", e.getLocalizedMessage());
            errorModal.makeVisibile();
        }
        return null;
    }
}
