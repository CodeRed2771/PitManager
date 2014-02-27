package competitionsys.persistence;

import java.io.File;
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
            FileIO.readMemoryIn("pitmanager");
        } else {
            if (csvMatches.exists() && csvBatteries.exists()) {
                ReadCSV.readCSVFile("matches.csv", ReadCSV.MATCHES);
                ReadCSV.readCSVFile("batteries.csv", ReadCSV.BATTERIES);
                FileIO.writeMemory("pitmanager");
            } else {
                JOptionPane.showMessageDialog(new JPanel(), "The Pit Manager cannot find a serialized"
                        + "\ncompetition file.  When looking for the\nmatches and"
                        + " batteries CSV files, one or\nboth of them were missing", "No Information", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
