package competitionsys.persistence;

/**
 *
 * @author Michael
 */
public class Match {
    private int matchNumber;
    
    private int blueStation1;
    private int blueStation2;
    private int blueStation3;
    
    private int redStation1;
    private int redStation2;
    private int redStation3;

    public int getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
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
}
