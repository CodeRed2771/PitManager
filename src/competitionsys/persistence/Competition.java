package competitionsys.persistence;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class Competition implements Serializable {

    private static Competition competition = null;
    private ArrayList<Match> matches;
    private ArrayList<Battery> batteries;

    private Competition() {
        matches = new ArrayList<>();
        batteries = new ArrayList<>();
    }

    public static Competition getInstance() {
        if (competition == null) {
            competition = new Competition();
        }
        return competition;
    }

    public static void setInstance(Competition newCompetition) {
        if (competition == null) {
            competition = newCompetition;
        }
    }

    public void addMatch(Match match) {
        matches.add(match);
    }

    public Match getMatchByIndex(int index) {
        return matches.get(index);
    }

    public Match getMatch(int matchNumber) {
        for (Match match : matches) {
            if (match.getMatchNumber() == matchNumber) {
                return match;
            }
        }
        return null;
    }

    public void removeMatchByIndex(int index) {
        matches.remove(index);
    }

    public void removeMatch(Match match) {
        matches.remove(match);
    }

    public void removeMatch(int matchNumber) {
        for (Match match : matches) {
            if (match.getMatchNumber() == matchNumber) {
                matches.remove(match);
                return;
            }
        }
    }

    public int getNumberOfMatches() {
        return matches.size();
    }

    public void addBattery(Battery match) {
        batteries.add(match);
    }

    public Battery getBattery(int index) {
        return batteries.get(index);
    }

    public Battery getBattery(String batteryLabel) {
        for (Battery battery : batteries) {
            if (battery.getBatteryLabel().equals(batteryLabel)) {
                return battery;
            }
        }
        return null;
    }

    public void removeBatteryByIndex(int index) {
        batteries.remove(index);
    }

    public void removeBattery(Battery battery) {
        batteries.remove(battery);
    }

    public void removeBattery(String batteryLabel) {
        for (Battery battery : batteries) {
            if (battery.getBatteryLabel().equals(batteryLabel)) {
                batteries.remove(battery);
                return;
            }
        }
    }
    
    public int getNumberOfBatteries(){
        return batteries.size();
    }
}
