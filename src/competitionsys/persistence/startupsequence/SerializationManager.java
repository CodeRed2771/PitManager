package competitionsys.persistence.startupsequence;

import competitionsys.persistence.Competition;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class SerializationManager {

    public static void writeMemory(String path) {
        try (FileOutputStream fileOut = new FileOutputStream(("".equals(path) ? "pitmanager" : path));
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(Competition.getInstance());
            out.close();
            fileOut.close();
        } catch (IOException e) {
            Logger.getLogger(SerializationManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void readMemoryIn(String path) throws InvalidClassException {
        try {
            try (FileInputStream fileIn = new FileInputStream(("".equals(path) ? "pitmanager" : path)); 
                    ObjectInputStream in = new ObjectInputStream(fileIn)) {
                Competition.setInstance((Competition) in.readObject());
            }
        } catch (InvalidClassException ex) {
            throw new InvalidClassException("Serialized file not valid");
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(SerializationManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
