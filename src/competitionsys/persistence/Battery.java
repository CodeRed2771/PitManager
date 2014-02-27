package competitionsys.persistence;

/**
 *
 * @author Michael
 */
public class Battery {
    private String batteryLabel;
    private String batteryDescription;
    private String batteryStatus;

    public Battery(String batteryLabel, String batteryDescription, String batteryStatus) {
        this.batteryLabel = batteryLabel;
        this.batteryDescription = batteryDescription;
        this.batteryStatus = batteryStatus;
    }

    public String getBatteryLabel() {
        return batteryLabel;
    }

    public void setBatteryLabel(String batteryLabel) {
        this.batteryLabel = batteryLabel;
    }

    public String getBatteryDescription() {
        return batteryDescription;
    }

    public void setBatteryDescription(String batteryDescription) {
        this.batteryDescription = batteryDescription;
    }

    public String getBatteryStatus() {
        return batteryStatus;
    }

    public void setBatteryStatus(String batteryStatus) {
        this.batteryStatus = batteryStatus;
    }
}
