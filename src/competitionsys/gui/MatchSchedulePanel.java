package competitionsys.gui;

import competitionsys.persistence.Competition;
import competitionsys.persistence.Match;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class MatchSchedulePanel extends javax.swing.JPanel implements Runnable {

    private int page = 1;
    private final int maxpages;
    private boolean refresh = false;

    private MatchScheduleRow rows[];
    private ArrayList<Match> matches;

    /**
     * Creates new form MatchSchedulePanel
     */
    public MatchSchedulePanel() {
        initComponents();

        maxpages = (int) (Math.ceil(Competition.getInstance().getNumberOfMatches() / 13.0d));

        setupRows();
        init();
        refresh();
    }
    
    public void start(){
        new Thread().start();
    }

    private void init() {
        Competition c = Competition.getInstance();
        matches = c.getMatches();
    }

    private void refresh() {
        for (int i = 0; i < 13; i++) {
            try { 
            Match m = matches.get((page - 1) * 13 + i);
            rows[i].setLabels(m);
            } catch (IndexOutOfBoundsException ex) {
                rows[i].setLabelsBlank();
            }
        }
        pageNumberLabel.setText("Page " + String.valueOf(page) + " of " + String.valueOf(maxpages));
    }

    private void setupRows() {
        rows = new MatchScheduleRow[13];
        rows[0] = row1;
        rows[1] = row2;
        rows[2] = row3;
        rows[3] = row4;
        rows[4] = row5;
        rows[5] = row6;
        rows[6] = row7;
        rows[7] = row8;
        rows[8] = row9;
        rows[9] = row10;
        rows[10] = row11;
        rows[11] = row12;
        rows[12] = row13;
    }

    @Override
    public void run() {
        while (true) {
            if (refresh) {
                refresh();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(MatchSchedulePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        bottomSeparator = new javax.swing.JSeparator();
        pageNumberLabel = new javax.swing.JLabel();
        sideSeparator = new javax.swing.JSeparator();
        pageUpButton = new javax.swing.JButton();
        pageDownButton = new javax.swing.JButton();
        labels = new competitionsys.gui.MatchScheduleLabels();
        row1 = new competitionsys.gui.MatchScheduleRow();
        row2 = new competitionsys.gui.MatchScheduleRow();
        row3 = new competitionsys.gui.MatchScheduleRow();
        row4 = new competitionsys.gui.MatchScheduleRow();
        row5 = new competitionsys.gui.MatchScheduleRow();
        row6 = new competitionsys.gui.MatchScheduleRow();
        row7 = new competitionsys.gui.MatchScheduleRow();
        row8 = new competitionsys.gui.MatchScheduleRow();
        row9 = new competitionsys.gui.MatchScheduleRow();
        row10 = new competitionsys.gui.MatchScheduleRow();
        row11 = new competitionsys.gui.MatchScheduleRow();
        row12 = new competitionsys.gui.MatchScheduleRow();
        row13 = new competitionsys.gui.MatchScheduleRow();

        setBackground(new java.awt.Color(0, 0, 0));

        bottomSeparator.setBackground(new java.awt.Color(0, 0, 0));
        bottomSeparator.setForeground(new java.awt.Color(255, 255, 255));

        pageNumberLabel.setBackground(new java.awt.Color(0, 0, 0));
        pageNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pageNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        pageNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pageNumberLabel.setText("Page # of #");
        pageNumberLabel.setOpaque(true);

        sideSeparator.setBackground(new java.awt.Color(0, 0, 0));
        sideSeparator.setForeground(new java.awt.Color(255, 255, 255));
        sideSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        pageUpButton.setBackground(new java.awt.Color(0, 0, 0));
        pageUpButton.setText("↑");
        pageUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pageUpButtonActionPerformed(evt);
            }
        });

        pageDownButton.setBackground(new java.awt.Color(0, 0, 0));
        pageDownButton.setText("↓");
        pageDownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pageDownButtonActionPerformed(evt);
            }
        });

        row1.setMaximumSize(new java.awt.Dimension(551, 14));

        row2.setMaximumSize(new java.awt.Dimension(551, 14));

        row3.setMaximumSize(new java.awt.Dimension(551, 14));

        row4.setMaximumSize(new java.awt.Dimension(551, 14));

        row5.setMaximumSize(new java.awt.Dimension(551, 14));

        row6.setMaximumSize(new java.awt.Dimension(551, 14));

        row7.setMaximumSize(new java.awt.Dimension(551, 14));

        row8.setMaximumSize(new java.awt.Dimension(551, 14));

        row9.setMaximumSize(new java.awt.Dimension(551, 14));

        row10.setMaximumSize(new java.awt.Dimension(551, 14));

        row11.setMaximumSize(new java.awt.Dimension(551, 14));

        row12.setMaximumSize(new java.awt.Dimension(551, 14));

        row13.setMaximumSize(new java.awt.Dimension(551, 14));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pageNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bottomSeparator)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labels, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(row1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(row2, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(row3, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(row4, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(row5, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(row6, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(row7, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(row8, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(row9, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(row10, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(row11, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(row12, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(row13, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sideSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pageDownButton))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pageUpButton))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sideSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(pageUpButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pageDownButton)
                        .addGap(74, 74, 74))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(row1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(row2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(row3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(row4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(row5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(row6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(row7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(row8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(row9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(row10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(row11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(row12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(row13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(bottomSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pageNumberLabel)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pageUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pageUpButtonActionPerformed
        if (page > 1) {
            page--;
            refresh = true;
        }
    }//GEN-LAST:event_pageUpButtonActionPerformed

    private void pageDownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pageDownButtonActionPerformed
        if (page < maxpages) {
            page++;
            refresh = true;
        }
    }//GEN-LAST:event_pageDownButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator bottomSeparator;
    private competitionsys.gui.MatchScheduleLabels labels;
    private javax.swing.JButton pageDownButton;
    private javax.swing.JLabel pageNumberLabel;
    private javax.swing.JButton pageUpButton;
    private competitionsys.gui.MatchScheduleRow row1;
    private competitionsys.gui.MatchScheduleRow row10;
    private competitionsys.gui.MatchScheduleRow row11;
    private competitionsys.gui.MatchScheduleRow row12;
    private competitionsys.gui.MatchScheduleRow row13;
    private competitionsys.gui.MatchScheduleRow row2;
    private competitionsys.gui.MatchScheduleRow row3;
    private competitionsys.gui.MatchScheduleRow row4;
    private competitionsys.gui.MatchScheduleRow row5;
    private competitionsys.gui.MatchScheduleRow row6;
    private competitionsys.gui.MatchScheduleRow row7;
    private competitionsys.gui.MatchScheduleRow row8;
    private competitionsys.gui.MatchScheduleRow row9;
    private javax.swing.JSeparator sideSeparator;
    // End of variables declaration//GEN-END:variables

}
