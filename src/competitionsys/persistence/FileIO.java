package competitionsys.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class FileIO {

    public static void writeMemory(String path) {
        try (FileOutputStream fileOut = new FileOutputStream(("".equals(path) ? "pitmanager" : path));
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(Competition.getInstance());
            out.close();
            fileOut.close();
        } catch (IOException e) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void readMemoryIn(String path) {
        try {
            try (FileInputStream fileIn = new FileInputStream(("".equals(path) ? "pitmanager" : path)); 
                    ObjectInputStream in = new ObjectInputStream(fileIn)) {
                Competition.setInstance((Competition) in.readObject());
            }
        }catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
