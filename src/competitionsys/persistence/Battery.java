package competitionsys.persistence;

import java.io.Serializable;

/**
 *
 * @author Michael
 */
public class Battery implements Serializable {

    private String batteryLetter;
    private boolean charged;

    public Battery(String batteryLetter) {
        this.batteryLetter = batteryLetter;
        charged = true;
    }

    public Battery(String batteryLetter, boolean charged) {
        this.batteryLetter = batteryLetter;
        this.charged = charged;
    }

    public String getBatteryLetter() {
        return batteryLetter;
    }

    public void setBatteryLetter(String batteryLetter) {
        this.batteryLetter = batteryLetter;
    }

    public boolean isCharged() {
        return charged;
    }

    public void setCharged(boolean charged) {
        this.charged = charged;
    }
}
