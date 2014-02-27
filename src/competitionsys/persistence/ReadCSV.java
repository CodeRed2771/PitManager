package competitionsys.persistence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class ReadCSV {

    public static int MATCHES = 0;
    public static int BATTERIES = 1;

    public static void readCSVFile(String path, int type) {
        BufferedReader read;
        String line;
        String cvsSplitBy = ",";
        try {
            read = new BufferedReader(new FileReader(path));

            if (type == MATCHES) {
                while ((line = read.readLine()) != null) {
                    String[] matchData = line.split(cvsSplitBy);

                    Competition.getInstance().addMatch(convertToMatch(matchData));
                }
            } else if (type == BATTERIES) {
                 while ((line = read.readLine()) != null) {
                    String[] batteryData = line.split(cvsSplitBy);

                    Competition.getInstance().addBattery(convertToBattery(batteryData));
                }
            }

            read.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Match convertToMatch(String[] match) {
        return new Match(Integer.parseInt(match[0]),
                Integer.parseInt(match[1]),
                Integer.parseInt(match[2]),
                Integer.parseInt(match[3]),
                Integer.parseInt(match[4]),
                Integer.parseInt(match[5]),
                Integer.parseInt(match[6]),
                match[7].toString(),
                match[8].toString());
    }

    private static Battery convertToBattery(String[] battery) {
        return new Battery(battery[0], battery[1], battery[2]);
    }
}
