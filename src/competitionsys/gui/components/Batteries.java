package competitionsys.gui.components;

import competitionsys.persistence.Battery;
import competitionsys.persistence.Competition;
import competitionsys.persistence.Match;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class Batteries extends javax.swing.JPanel {

    ArrayList<Match> matches; // Code Red's Matches ArralList
    ArrayList<Battery> batteryList; // Battery ArrayList: See bottom of file.

    private final int OFFSET_X = 10; // X starting position for the charging station.
    private final int OFFSET_Y = 10; // Y starting position for the charging station.
    private final int MAIN_SQUARE_SIZE = 60; // the length in pixels of one side of a charging square.
    private final int TOTAL_ROBOT_WIDTH = 150; // the length in pixels of the total robot width; borders and inside.
    private final int TOTAL_ROBOT_HEIGHT = 300; // the length in pixels of the total robot hieght; borders and inside.
    private final int ROBOT_BORDER_SIZE = 15; // the width in pixels of the colored border around the robot.
    private final int CHARGER_SLOTS_X = 3; // how many squares are drawn left to right.
    private final int CHARGER_SLOTS_Y = 4; // how many squares are draw top to bottom.

    private boolean skipAutoCharge = false; // when the battery is manually changed in slot (0, 0), we don't want the auto charge to change it back.

    /**
     * Creates new form NewBatteries
     */
    public Batteries() {
        initComponents(); // Intitalize GUI Components.
        addMouseListener(new Batteries.MouseListener()); // Add MouseListener for manual battery change.
        repaint(); // PAINT COMPONENTS.
    }

    public void init() {
        matches = Competition.getInstance().getCodeRedSchedule();
        batteryList = new ArrayList<>();
        for (Match match : matches) {
            batteryList.add(match.getBattery());
        }

        if (matches == null) {
            matches = new ArrayList<>();
        }
    }

    /**
     * Double Buffer: creates a back buffer, draws to it, then swaps buffers.
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        Image dbImg = createImage(getWidth(), getHeight());
        Graphics dbg = dbImg.getGraphics();
        draw(dbg);
        g.drawImage(dbImg, 0, 0, this);
    }

    /**
     * Double Buffer: draws to back buffer.
     *
     * @param g
     */
    private void draw(Graphics g) {
        // Certain things may only be done while the JVM is running, because accessing 
        // the Competition instance will screw up the NetBeans GUI Builder.
        if (Competition.getInstance().isMemoryInitialized()) {
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 45));

            // DRAW SMALL SLOTS ON TOP
            for (int i = OFFSET_X; i <= OFFSET_X + (MAIN_SQUARE_SIZE * (CHARGER_SLOTS_X - 1)); i += MAIN_SQUARE_SIZE) {
                g.drawRect(i, OFFSET_Y, MAIN_SQUARE_SIZE, MAIN_SQUARE_SIZE / 2);
            }

            // DRAW ROBOT BORDER; MATCH COLOR
            Match match = matches.get(Competition.getInstance().getNextCodeRedMatch());
            if (match.getBlueStation1() == 2771 || match.getBlueStation2() == 2771 || match.getBlueStation3() == 2771) {
                g.setColor(Color.BLUE);
            } else {
                g.setColor(Color.RED);
            }
            g.fillRect(OFFSET_X + CHARGER_SLOTS_X * MAIN_SQUARE_SIZE + 25, OFFSET_Y, TOTAL_ROBOT_WIDTH, TOTAL_ROBOT_HEIGHT);

            // DRAW ROBOT (GREY), ON TOP OF BORDER
            g.setColor(Color.DARK_GRAY);
            g.fillRect(OFFSET_X + CHARGER_SLOTS_X * MAIN_SQUARE_SIZE + 25 + ROBOT_BORDER_SIZE, OFFSET_Y + ROBOT_BORDER_SIZE, TOTAL_ROBOT_WIDTH - ROBOT_BORDER_SIZE * 2, TOTAL_ROBOT_HEIGHT - ROBOT_BORDER_SIZE * 2);

            // THE REMAINDER OF THIS IF STATEMENT IS THE VERY CONFUSING PROCESS OF DRAWING THE BATTERIES
            ArrayList<String> usedAlready = new ArrayList<>();
            FontMetrics metrics = g.getFontMetrics(); // figure out font metrics.
            int currentSlot = 0; // the current slot: if a repeat is encountered it doesn't count as a slot.
            for (int i = Competition.getInstance().getNextCodeRedMatch(); i < Competition.getInstance().getNextCodeRedMatch() + matches.size(); i++) {
                Battery battery = batteryList.get(wrapIndex(i, batteryList));
                if (usedAlready.contains(battery.getBatteryLetter())) {
                    continue;
                }
                usedAlready.add(battery.getBatteryLetter());
                int[] pos = convertSlotToIndex(currentSlot);
                if (pos[0] == -1) {
                    g.setColor(Color.white);
                    g.drawString(battery.getBatteryLetter(), (TOTAL_ROBOT_WIDTH - metrics.stringWidth(battery.getBatteryLetter())) / 2 + OFFSET_X + CHARGER_SLOTS_X * MAIN_SQUARE_SIZE + 25, OFFSET_Y + TOTAL_ROBOT_HEIGHT / 3);
                    battery.setCharged(false);
                } else {
//                    if (pos[0] == manualChange[0] && pos[1] == manualChange[1]) {
//                        battery.setCharged(!battery.isCharged());
//                        manualChange[0] = -1;
//                    } else 
                    if (pos[0] == 0 && pos[1] == 0 && !skipAutoCharge) {
                        battery.setCharged(true);
                    }
                    g.setColor(battery.isCharged() ? Color.green : Color.red);
                    g.fillRect(OFFSET_X + pos[0] * MAIN_SQUARE_SIZE, OFFSET_Y + MAIN_SQUARE_SIZE / 2 + pos[1] * MAIN_SQUARE_SIZE, MAIN_SQUARE_SIZE, MAIN_SQUARE_SIZE);
                    g.setColor(Color.white);
                    g.drawString(battery.getBatteryLetter(),
                            (MAIN_SQUARE_SIZE - metrics.stringWidth(battery.getBatteryLetter())) / 2 + OFFSET_X + pos[0] * MAIN_SQUARE_SIZE, OFFSET_Y + MAIN_SQUARE_SIZE / 2 + metrics.getHeight() - 7 + pos[1] * MAIN_SQUARE_SIZE);
                }
                currentSlot++;
            }
        }

        // The following things are drawn regardless if the memory is initialized:
        // DRAW 12 MAIN WHITE SLOTS
        g.setColor(Color.white);
        for (int x = OFFSET_X; x <= OFFSET_X + (MAIN_SQUARE_SIZE * (CHARGER_SLOTS_X - 1)); x += MAIN_SQUARE_SIZE) {
            for (int y = OFFSET_Y + MAIN_SQUARE_SIZE / 2; y <= OFFSET_Y + MAIN_SQUARE_SIZE / 2 + (MAIN_SQUARE_SIZE * (CHARGER_SLOTS_Y - 1)); y += MAIN_SQUARE_SIZE) {
                g.drawRect(x, y, MAIN_SQUARE_SIZE, MAIN_SQUARE_SIZE);
            }
        }
    }
    
    // Used only when the next / previous buttons are pressed, and resets the auto charge.
    public void refresh() {
        skipAutoCharge = false;
        repaint();
    }

    public int[] convertSlotToIndex(int index) {
        if (index == 0) { // The First one goes on the robot, so the position is invalid.
            int[] a = {-1, 0};
            return a;
        } else {
            index--; // the below equation needs the slots to be numbered starting with a 0.
            // (The remainder of the index / 3, by the index / 3 rounded down to the nearest int.
            int[] a = {index % CHARGER_SLOTS_X, (int) (Math.floor(index / CHARGER_SLOTS_X))};
            return a;
        }
    }

    //Wrap an index to fit within the bounds of a given array.  For Example:
    // An array has 3 items.  Index of 3 would be changed to 0; 7 would be 1.
    private int wrapIndex(int i, ArrayList al) {
        return i < al.size() ? i : wrapIndex(i - al.size(), al);
    }

    int[] calculateSlotForMouseClick(int x, int y) {
        x = x - OFFSET_X;
        y = y - OFFSET_Y - MAIN_SQUARE_SIZE / 2;
        int[] a = {((x - (x % MAIN_SQUARE_SIZE)) / MAIN_SQUARE_SIZE),
            ((y - (y % MAIN_SQUARE_SIZE)) / MAIN_SQUARE_SIZE)};
        return a;
    }

    void negateBatteryAtPos(int[] changepos) {
        ArrayList<String> usedAlready = new ArrayList<>();
        int currentSlot = 0; // the current slot: if a repeat is encountered it doesn't count as a slot.
        for (int i = Competition.getInstance().getNextCodeRedMatch(); i < Competition.getInstance().getNextCodeRedMatch() + matches.size(); i++) {
            Battery battery = batteryList.get(wrapIndex(i, batteryList));
            if (usedAlready.contains(battery.getBatteryLetter())) {
                continue;
            }
            usedAlready.add(battery.getBatteryLetter());
            int[] pos = convertSlotToIndex(currentSlot);
            System.out.println("(" + pos[0] + ", " + pos[1] + ")\t" + "(" + changepos[0] + ", " + changepos[1] + ")");
            if (pos[0] == changepos[0] && pos[1] == changepos[1]) {
                battery.setCharged(!battery.isCharged());
                break;
            }
            currentSlot++;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(41, 41, 41));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
private class MouseListener extends MouseAdapter implements MouseMotionListener {

        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX(), y = e.getY();
            negateBatteryAtPos(calculateSlotForMouseClick(x, y));
            skipAutoCharge = true;
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }
}
/* 
 BATTERY ARRAYLISTS AND EXPLAINATION:
 When the init() method is called, an ArrayList of batteries is created by 
 iterating through the ArrayList of Code Red Matches and pulling out each battery.

 When it is time to draw the battery panel and robot:
 1) the the battery matching the next match int (Main.CURRENT_MATCH) is drawn on the robot.
 2) the next battery (Main.CURRENT_MATCH + 1) is drawn in battery slot 1.  (Row 1, Column 1)
 3) this process is repeated for the rest of the batteries.
 4) if a repeat battery is encountered, it is skipped, as the battery closer to the current
 match is more important.
 5) the system loops around the ArrayList until it makes it back to where it started, then it stops.

 HOW CHARGING IS MAGICALLY KEPT TRACK OF:
 When the two CSVs are read in, the battery file is read in first.  Then, the matches
 CSV is read.  When a match references a Battery, the instance matching that letter 
 is put into the match.  For Example, if matches 1 and 10 both have battery A, they
 will moth have the same exact instance of a Battery.  This solves a huge nightmare
 keeping track of charged state in this file, because duplicate batteries in the batteryList
 are actually the same instance put into the ArrayList multiple times.  Hopefully this makes
 sense.  If it doesn't, go read the ReadCSV file and you will get it.  
 */
