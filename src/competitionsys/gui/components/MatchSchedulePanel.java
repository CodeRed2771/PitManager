package competitionsys.gui.components;

import competitionsys.persistence.Competition;
import competitionsys.persistence.Match;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;

/**
 *
 * @author Michael
 */
public class MatchSchedulePanel extends javax.swing.JPanel {

    private ArrayList<Match> matches;
    private ArrayList<MatchScheduleRow> rows;
    private int lastIndex = 0;
    private boolean notFirst = false;

    /**
     * Creates new form MatchSchedulePanel
     */
    public MatchSchedulePanel() {
        initComponents();
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
    }

    public void init() {
        matches = Competition.getInstance().getMatches();
        rows = new ArrayList<>();
        setupRows();
    }

    private void setupRows() {
        schedulePanel.setLayout(new BoxLayout(schedulePanel, BoxLayout.Y_AXIS));
        schedulePanel.add(Box.createRigidArea(new Dimension(0, 6)));
        for (Match match : matches) {
            MatchScheduleRow msr = new MatchScheduleRow();
            msr.setLabels(match);
            schedulePanel.add(msr);
            schedulePanel.add(Box.createRigidArea(new Dimension(0, 6)));
            rows.add(msr);
        }
    }

    public void updateCurrentMatch(int index) {
        rows.get(lastIndex).setHighlighted(false);
        rows.get(index).setHighlighted(true);
        lastIndex = index;
        if (notFirst) {
            jScrollPane1.getVerticalScrollBar().setValue(6 + 14 * index + 6 * index - 6);
        }
        notFirst = true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        schedulePanel = new javax.swing.JPanel();
        newMatchScheduleLabels1 = new competitionsys.gui.components.MatchScheduleLabels();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setBackground(new java.awt.Color(41, 41, 41));

        jScrollPane1.setBackground(new java.awt.Color(41, 41, 41));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(100, 100));

        schedulePanel.setBackground(new java.awt.Color(20, 20, 20));
        schedulePanel.setMaximumSize(new java.awt.Dimension(626, 998));
        schedulePanel.setMinimumSize(new java.awt.Dimension(626, 998));

        javax.swing.GroupLayout schedulePanelLayout = new javax.swing.GroupLayout(schedulePanel);
        schedulePanel.setLayout(schedulePanelLayout);
        schedulePanelLayout.setHorizontalGroup(
            schedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );
        schedulePanelLayout.setVerticalGroup(
            schedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 998, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(schedulePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newMatchScheduleLabels1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newMatchScheduleLabels1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private competitionsys.gui.components.MatchScheduleLabels newMatchScheduleLabels1;
    private javax.swing.JPanel schedulePanel;
    // End of variables declaration//GEN-END:variables

}