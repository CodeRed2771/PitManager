package competitionsys.persistence;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class Competition implements Serializable {

    private static ArrayList<Match> matches;
    private static ArrayList<Battery> batteries;

    public Competition() {
        matches = new ArrayList<>();
        batteries = new ArrayList<>();
    }

    public static void addMatch(Match match) {
        matches.add(match);
    }

    public static Match getMatchByIndex(int index) {
        return matches.get(index);
    }

    public static Match getMatch(int matchNumber) {
        for (Match match : matches) {
            if (match.getMatchNumber() == matchNumber) {
                return match;
            }
        }
        return null;
    }

    public static void removeMatchByIndex(int index) {
        matches.remove(index);
    }

    public static void removeMatch(Match match) {
        matches.remove(match);
    }

    public static void removeMatch(int matchNumber) {
        for (Match match : matches) {
            if (match.getMatchNumber() == matchNumber) {
                matches.remove(match);
                return;
            }
        }
    }

    public static void addBattery(Battery match) {
        batteries.add(match);
    }

    public static Battery getBattery(int index) {
        return batteries.get(index);
    }

    public static Battery getBattery(String batteryLabel) {
        for (Battery battery : batteries) {
            if (battery.getBatteryLabel().equals(batteryLabel)) {
                return battery;
            }
        }
        return null;
    }

    public static void removeBatteryByIndex(int index) {
        batteries.remove(index);
    }

    public static void removeBattery(Battery battery) {
        batteries.remove(battery);
    }

    public static void removeBattery(String batteryLabel) {
        for (Battery battery : batteries) {
            if (battery.getBatteryLabel().equals(batteryLabel)) {
                batteries.remove(battery);
                return;
            }
        }
    }
}
