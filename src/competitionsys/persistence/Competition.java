package competitionsys.persistence;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class Competition implements Serializable {

    private static Competition competition = null;
    private final ArrayList<Match> matches;
    private final ArrayList<Battery> batteries;
    
    private final ArrayList<Match> codeRedSchedule;
    private int nextCodeRedMatch = 0;
    
    private String notes;
    
    private boolean memoryInitialized = false;

    private Competition() {
        matches = new ArrayList<>();
        batteries = new ArrayList<>();
        codeRedSchedule = new ArrayList<>();
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

    public ArrayList<Match> getMatches() {
        ArrayList<Match> ret = matches;
        return ret;
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
            if (battery.getBatteryLetter().equals(batteryLabel)) {
                return battery;
            }
        }
        return new Battery("", false);
    }

    public void removeBatteryByIndex(int index) {
        batteries.remove(index);
    }

    public void removeBattery(Battery battery) {
        batteries.remove(battery);
    }

    public void removeBattery(String batteryLabel) {
        for (Battery battery : batteries) {
            if (battery.getBatteryLetter().equals(batteryLabel)) {
                batteries.remove(battery);
                return;
            }
        }
    }

    public int getNumberOfBatteries() {
        return batteries.size();
    }

    public ArrayList<Battery> getBatteries() {
        ArrayList<Battery> ret = batteries;
        return ret;
    }
    
    public ArrayList<Match> getCodeRedSchedule(){
        ArrayList<Match> ret = codeRedSchedule;
        return ret;
    }
    
    public void initCodeRedSchedule() {
        codeRedSchedule.clear();
        for (Match match : matches){
            if(match.searchFor(2771)){
                codeRedSchedule.add(match);
            }
        }
    }

    public int getNextCodeRedMatch() {
        return nextCodeRedMatch;
    }

    public void setNextCodeRedMatch(int nextCodeRedMatch) {
        this.nextCodeRedMatch = nextCodeRedMatch;
    }

    public boolean isMemoryInitialized() {
        return memoryInitialized;
    }

    public void setMemoryInitialized(boolean memoryInitialized) {
        this.memoryInitialized = memoryInitialized;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
