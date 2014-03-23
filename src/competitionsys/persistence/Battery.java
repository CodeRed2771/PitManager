package competitionsys.persistence;

import java.io.Serializable;

/**
 *
 * @author Michael
 */
public class Battery implements Serializable {
    private String batteryLabel;
    private String batteryNotes;
    private String batteryStatus;
    private String batteryCharge;

    public Battery(String batteryLabel, String batteryNotes, String batteryStatus, String batteryCharge) {
        this.batteryLabel = batteryLabel;
        this.batteryNotes = batteryNotes;
        this.batteryStatus = batteryStatus;
        this.batteryCharge = batteryCharge;
    }

    public String getBatteryLabel() {
        return batteryLabel;
    }

    public void setBatteryLabel(String batteryLabel) {
        this.batteryLabel = batteryLabel;
    }

    public String getBatteryNotes() {
        return batteryNotes;
    }

    public void setBatteryNotes(String batteryDescription) {
        this.batteryNotes = batteryDescription;
    }

    public String getBatteryStatus() {
        return batteryStatus;
    }

    public void setBatteryStatus(String batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

    public String getBatteryCharge() {
        return batteryCharge;
    }

    public void setBatteryCharge(String batteryCharge) {
        this.batteryCharge = batteryCharge;
    }
}