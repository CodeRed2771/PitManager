package competitionsys.persistence;

import java.io.Serializable;

/**
 *
 * @author Michael
 */
public class Match implements Serializable {

    private int matchNumber;
    private String matchTime;
    
    private int blueStation1;
    private int blueStation2;
    private int blueStation3;

    private int redStation1;
    private int redStation2;
    private int redStation3;
    
    private Battery battery;

    public Match(int matchNumber, int redStation1, int redStation2, int redStation3, int blueStation1, int blueStation2, int blueStation3, String matchTime, Battery battery) {
        this.matchNumber = matchNumber;
        this.matchTime = matchTime;
        this.redStation1 = redStation1;
        this.redStation2 = redStation2;
        this.redStation3 = redStation3;
        this.blueStation1 = blueStation1;
        this.blueStation2 = blueStation2;
        this.blueStation3 = blueStation3;
        this.battery = battery;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public int getBlueStation1() {
        return blueStation1;
    }

    public void setBlueStation1(int blueStation1) {
        this.blueStation1 = blueStation1;
    }

    public int getBlueStation2() {
        return blueStation2;
    }

    public void setBlueStation2(int blueStation2) {
        this.blueStation2 = blueStation2;
    }

    public int getBlueStation3() {
        return blueStation3;
    }

    public void setBlueStation3(int blueStation3) {
        this.blueStation3 = blueStation3;
    }

    public int getRedStation1() {
        return redStation1;
    }

    public void setRedStation1(int redStation1) {
        this.redStation1 = redStation1;
    }

    public int getRedStation2() {
        return redStation2;
    }

    public void setRedStation2(int redStation2) {
        this.redStation2 = redStation2;
    }

    public int getRedStation3() {
        return redStation3;
    }

    public void setRedStation3(int redStation3) {
        this.redStation3 = redStation3;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }
    
    public boolean searchFor(int team){
        if (blueStation1 == team) {
        } else if (blueStation2 == team) {
        } else if (blueStation3 == team) {
        } else if (redStation1 == team) {
        } else if (redStation2 == team) {
        } else if (redStation3 == team) {
        } else {
            return false;
        }
        return true;
    }
}
