package competitionsys.persistence.startupsequence;

import competitionsys.persistence.Battery;
import competitionsys.persistence.Competition;
import competitionsys.persistence.Match;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class CSVReader {

    public static void readBatteries() throws IOException, IndexOutOfBoundsException {
        BufferedReader read;
        String line;
        String cvsSplitBy = ",";
        read = new BufferedReader(new FileReader("batteries.csv"));

        while ((line = read.readLine()) != null) {
            String[] batteryData = line.split(cvsSplitBy);

            Competition.getInstance().addBattery(convertToBattery(batteryData));
        }

        read.close();
    }

    public static void readMatches() throws IOException, IndexOutOfBoundsException {
        BufferedReader read;
        String line;
        String cvsSplitBy = ",";
        read = new BufferedReader(new FileReader("matches.csv"));

        while ((line = read.readLine()) != null) {
            String[] matchData = line.split(cvsSplitBy);

            Competition.getInstance().addMatch(convertToMatch(matchData));
        }

        read.close();
    }
    
    public static Match[] readSchedule() throws IOException, IndexOutOfBoundsException {
        ArrayList<Match> matches = new ArrayList<>();
        
        BufferedReader read;
        String line;
        String cvsSplitBy = ",";
        read = new BufferedReader(new FileReader("schedule.csv"));

        while ((line = read.readLine()) != null) {
            String[] matchData = line.split(cvsSplitBy);

            matches.add(convertToMatch_1(matchData));
        }

        read.close();
        return matches.toArray(new Match[matches.size()]);
    }
    
    public static void setupFromCompetedSchedule(Match[] matches, Battery[] batteries) {
        for (Battery battery : batteries) {
            Competition.getInstance().addBattery(battery);
        }
        
        for (Match match : matches) {
            Competition.getInstance().addMatch(match);
        }
    }

    private static Match convertToMatch(String[] match) throws IndexOutOfBoundsException {
        return new Match(Integer.parseInt(match[0]),
                Integer.parseInt(match[1]),
                Integer.parseInt(match[2]),
                Integer.parseInt(match[3]),
                Integer.parseInt(match[4]),
                Integer.parseInt(match[5]),
                Integer.parseInt(match[6]), match[8],
                Competition.getInstance().getBattery(match[7]));
    }

    private static Battery convertToBattery(String[] battery) throws IndexOutOfBoundsException {
        return new Battery(battery[0],
                " ".equals(battery[1]) ? true : Boolean.parseBoolean(battery[1]));
    }
    
    private static Match convertToMatch_1(String[] match) throws IndexOutOfBoundsException {
        return new Match(Integer.parseInt(match[0]),
                Integer.parseInt(match[1]),
                Integer.parseInt(match[2]),
                Integer.parseInt(match[3]),
                Integer.parseInt(match[4]),
                Integer.parseInt(match[5]),
                Integer.parseInt(match[6]), match[7],
                new Battery("", false));
    }
}
