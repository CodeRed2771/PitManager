package competitionsys.persistence;

import java.io.File;
import java.io.IOException;
import java.io.InvalidClassException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Michael
 */
public class StartupSequence {

    public static void loadInfo() {
        File serializedInfo = new File("pitmanager");
        File csvMatches = new File("matches.csv");
        File csvBatteries = new File("batteries.csv");

        if (serializedInfo.exists()) {
            try {
                FileIO.readMemoryIn("pitmanager");
            } catch (InvalidClassException ex) {
                Logger.getLogger(StartupSequence.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(new JPanel(),
                        "The Serialized Pit Manager file is no longer\n"
                        + "compatible with the current Pit Manager. The\n"
                        + "Pit Manager will now look for the required CSV files.\n",
                        "Corrupt or Old File", JOptionPane.ERROR_MESSAGE);
                if (csvMatches.exists() && csvBatteries.exists()) {
                    try {
                        serializedInfo.delete();
                        serializedInfo.createNewFile();
                        ReadCSV.readCSVFile("matches.csv", ReadCSV.MATCHES);
                        ReadCSV.readCSVFile("batteries.csv", ReadCSV.BATTERIES);
                        FileIO.writeMemory("pitmanager");
                    } catch (IOException ex1) {
                        Logger.getLogger(StartupSequence.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                } else {
                    JOptionPane.showMessageDialog(new JPanel(),
                            "The Pit Manager couldn't find the CSV Files.\n"
                                    + "Please create them.", "No Information", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            }
        } else {
            try {
                if (csvMatches.exists() && csvBatteries.exists()) {
                    serializedInfo.createNewFile();
                    ReadCSV.readCSVFile("matches.csv", ReadCSV.MATCHES);
                    ReadCSV.readCSVFile("batteries.csv", ReadCSV.BATTERIES);
                    FileIO.writeMemory("pitmanager");
                } else {
                    JOptionPane.showMessageDialog(new JPanel(),
                            "The Pit Manager couldn't find a serialized competition file."
                            + "\nThis may be because no information has ever been imported."
                            + "\n\nThe Pit Manager could not find the required files to"
                            + "\nsuccessfully import the information for a new competition."
                            + "\nOne or both of the required CSV files may be missing.  "
                            + "\nPlease create both a matches.csv and a batteries.csv file"
                            + "\nand place them in this directory.  ", "No Information", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            } catch (IOException ex) {
                Logger.getLogger(StartupSequence.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
