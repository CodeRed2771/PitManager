package competitionsys.persistence;

import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class Competition {

    ArrayList<Match> matches;
    ArrayList<Battery> batteries;

    public Competition() {
        matches = new ArrayList<>();
        batteries = new ArrayList<>();
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
}
