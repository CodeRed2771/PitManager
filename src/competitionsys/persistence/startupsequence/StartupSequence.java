package competitionsys.persistence.startupsequence;

import competitionsys.persistence.Battery;
import competitionsys.persistence.Competition;
import competitionsys.persistence.Match;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Michael
 */
public class StartupSequence {

    private static final File serializedInfo = new File("pitmanager");
    private static final File csvMatches = new File("matches.csv");
    private static final File csvBatteries = new File("batteries.csv");
    private static final File csvSchedule = new File("schedule.csv");

    public static boolean checkForSerializedData() {
        return serializedInfo.exists();
    }

    public static boolean loadSerializedData() {
        try {
            SerializationManager.readMemoryIn("pitmanager");
            return true;
        } catch (InvalidClassException ex) {
            Logger.getLogger(StartupSequence.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean checkIfCSVDataExists() {
        return csvMatches.exists() && csvBatteries.exists();
    }

    public static boolean loadCSVData() {
        try {
            CSVReader.readBatteries();
            CSVReader.readMatches();
            return true;
        } catch (IOException | IndexOutOfBoundsException ex) {
            Logger.getLogger(StartupSequence.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean scrapeInfo(String url) {
        String[][] table = null;
        int firstRealRow = 0;
        boolean firstRealRowInitialized = false;
        try {
            Document doc = Jsoup.connect(url).get();
            Elements tableElements = doc.select("table");

            Elements tableRowElements = tableElements.select(":not(thead) tr");
            System.out.println("Rows: " + tableRowElements.size());
            table = new String[tableRowElements.size()][8];
            for (int r = 0; r < tableRowElements.size(); r++) {
                System.out.println("Row loop: " + r);
                Element row = tableRowElements.get(r);
                Elements rowItems = row.select("td");

                if (rowItems.get(1).text().contains("AM") || rowItems.get(1).text().contains("PM")) {
                    if (!firstRealRowInitialized) {
                        firstRealRow = r;
                        table = new String[tableRowElements.size() - firstRealRow][9];
                        firstRealRowInitialized = true;
                    }
                    table[r - firstRealRow][0] = rowItems.get(0).text();
                    table[r - firstRealRow][1] = rowItems.get(2).text();
                    table[r - firstRealRow][2] = rowItems.get(3).text();
                    table[r - firstRealRow][3] = rowItems.get(4).text();
                    table[r - firstRealRow][4] = rowItems.get(5).text();
                    table[r - firstRealRow][5] = rowItems.get(6).text();
                    table[r - firstRealRow][6] = rowItems.get(7).text();
                    String s = rowItems.get(1).text();
                    String time = s.substring(s.indexOf(":") - 3, s.indexOf(":") + 6);
                    time = time.replaceAll("-", " ");
                    time = time.trim();
                    table[r - firstRealRow][7] = time;
                }
            }
            csvSchedule.delete();
            csvSchedule.createNewFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvSchedule))) {
                System.out.println(writer);
                for (String[] row : table) {
                    for (int i = 0; i < row.length; i++) {
                        if (row[i] == null) {
                            break;
                        }
                        writer.write(row[i]);
                        if (i < 8) {
                            writer.write(",");
                        }
                    }
                    writer.newLine();
                }
                writer.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(StartupSequence.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static Match[] loadScheduleFile() {
        try {
            return CSVReader.readSchedule();
        } catch (IOException | IndexOutOfBoundsException ex) {
            Logger.getLogger(StartupSequence.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void setupFromCompetedSchedule(Match[] matches, Battery[] batteries) {
        CSVReader.setupFromCompetedSchedule(matches, batteries);
    }
    
    public static void deleteSerializedData() {
        serializedInfo.delete();
    }
    
    public static void deleteCSVData() {
        csvBatteries.delete();
        csvMatches.delete();
    }

    public static void finish() {
        Competition.getInstance().initCodeRedSchedule();
        Competition.getInstance().setNextCodeRedMatch(0);
        Competition.getInstance().setMemoryInitialized(true);
    }
}
