package competitionsys.gui.cards;

import competitionsys.persistence.Competition;
import competitionsys.persistence.Match;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class Main extends javax.swing.JPanel {

    private static int CURRENT_MATCH = 0;
    private ArrayList<Match> schedule;

    private final MainHolder holder;
    
    /**
     * Creates new form Main
     */
    public Main(MainHolder holder) {
        initComponents();
        this.holder = holder;
    }

    public void init() {
        CURRENT_MATCH = Competition.getInstance().getNextCodeRedMatch();
        batteryPanel.init();
        matchSchedulePanel.init();
        schedule = Competition.getInstance().getCodeRedSchedule();
        refresh();
    }

    public void close() {

    }

    public void nowVisible() {
        // dont think we need to do anything here
    }

    public void nowHidden() {
        // dont think we need to do anything here
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nextMatchInfo = new javax.swing.JLabel();
        nextMatchPanel = new javax.swing.JPanel();
        nextMatchLabel = new javax.swing.JLabel();
        nextMatchNumber = new javax.swing.JLabel();
        chatPanel = new competitionsys.chat.ChatGUI();
        matchSchedulePanel = new competitionsys.gui.components.MatchSchedulePanel();
        checklistLabel = new javax.swing.JLabel();
        firstLogo = new javax.swing.JLabel();
        codeRedLogo = new javax.swing.JLabel();
        notesLabel = new javax.swing.JLabel();
        checklistPanel = new competitionsys.gui.components.CheckListContainer();
        controlPanel = new javax.swing.JPanel();
        currentMode = new javax.swing.JComboBox();
        nextButton = new javax.swing.JButton();
        modeLabel = new javax.swing.JLabel();
        previousButton = new javax.swing.JButton();
        openSetupButton = new javax.swing.JButton();
        notesScrollPane = new javax.swing.JScrollPane();
        notes = new javax.swing.JEditorPane();
        batteryPanel = new competitionsys.gui.components.Batteries();

        setBackground(new java.awt.Color(41, 41, 41));

        nextMatchInfo.setBackground(new java.awt.Color(255, 0, 0));
        nextMatchInfo.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        nextMatchInfo.setForeground(new java.awt.Color(255, 255, 255));
        nextMatchInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nextMatchInfo.setText("NEXT MATCH");
        nextMatchInfo.setMaximumSize(new java.awt.Dimension(10000000, 39));
        nextMatchInfo.setMinimumSize(new java.awt.Dimension(189, 39));
        nextMatchInfo.setOpaque(true);
        nextMatchInfo.setPreferredSize(new java.awt.Dimension(189, 39));

        nextMatchPanel.setBackground(new java.awt.Color(255, 0, 0));
        nextMatchPanel.setMaximumSize(new java.awt.Dimension(189, 120));
        nextMatchPanel.setMinimumSize(new java.awt.Dimension(189, 120));

        nextMatchLabel.setBackground(new java.awt.Color(255, 0, 0));
        nextMatchLabel.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        nextMatchLabel.setForeground(new java.awt.Color(255, 255, 255));
        nextMatchLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nextMatchLabel.setText("NEXT MATCH");

        nextMatchNumber.setBackground(new java.awt.Color(255, 0, 0));
        nextMatchNumber.setFont(new java.awt.Font("Arial Black", 1, 85)); // NOI18N
        nextMatchNumber.setForeground(new java.awt.Color(255, 255, 255));
        nextMatchNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nextMatchNumber.setText("108");
        nextMatchNumber.setToolTipText("");
        nextMatchNumber.setMaximumSize(new java.awt.Dimension(189, 121));
        nextMatchNumber.setMinimumSize(new java.awt.Dimension(189, 121));
        nextMatchNumber.setPreferredSize(new java.awt.Dimension(189, 121));

        javax.swing.GroupLayout nextMatchPanelLayout = new javax.swing.GroupLayout(nextMatchPanel);
        nextMatchPanel.setLayout(nextMatchPanelLayout);
        nextMatchPanelLayout.setHorizontalGroup(
            nextMatchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nextMatchPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(nextMatchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nextMatchLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nextMatchNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        nextMatchPanelLayout.setVerticalGroup(
            nextMatchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nextMatchPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(nextMatchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(nextMatchNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        checklistLabel.setBackground(new java.awt.Color(255, 255, 255));
        checklistLabel.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        checklistLabel.setForeground(new java.awt.Color(255, 255, 255));
        checklistLabel.setText("Checklist:");

        firstLogo.setBackground(new java.awt.Color(255, 255, 255));
        firstLogo.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        firstLogo.setForeground(new java.awt.Color(255, 255, 255));
        firstLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/competitionsys/gui/firstlogo.png"))); // NOI18N

        codeRedLogo.setBackground(new java.awt.Color(255, 255, 255));
        codeRedLogo.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        codeRedLogo.setForeground(new java.awt.Color(255, 255, 255));
        codeRedLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        codeRedLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/competitionsys/gui/mediumcodered.png"))); // NOI18N

        notesLabel.setBackground(new java.awt.Color(255, 255, 255));
        notesLabel.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        notesLabel.setForeground(new java.awt.Color(255, 255, 255));
        notesLabel.setText("Notes:");

        controlPanel.setBackground(new java.awt.Color(41, 41, 41));
        controlPanel.setMaximumSize(new java.awt.Dimension(401, 69));
        controlPanel.setMinimumSize(new java.awt.Dimension(401, 69));

        currentMode.setBackground(new java.awt.Color(41, 41, 41));
        currentMode.setForeground(java.awt.Color.white);
        currentMode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal Mode", "Eliminations Mode", "The Blue Alliance Info Lookup" }));
        currentMode.setFocusable(false);

        nextButton.setBackground(new java.awt.Color(41, 41, 41));
        nextButton.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        nextButton.setForeground(java.awt.Color.white);
        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/competitionsys/gui/next.png"))); // NOI18N
        nextButton.setFocusable(false);
        nextButton.setMaximumSize(new java.awt.Dimension(69, 69));
        nextButton.setMinimumSize(new java.awt.Dimension(69, 69));
        nextButton.setPreferredSize(new java.awt.Dimension(69, 69));
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        modeLabel.setBackground(new java.awt.Color(255, 255, 255));
        modeLabel.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        modeLabel.setForeground(new java.awt.Color(255, 255, 255));
        modeLabel.setText("Current Mode:");

        previousButton.setBackground(new java.awt.Color(41, 41, 41));
        previousButton.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        previousButton.setForeground(java.awt.Color.white);
        previousButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/competitionsys/gui/previous.png"))); // NOI18N
        previousButton.setFocusable(false);
        previousButton.setMaximumSize(new java.awt.Dimension(69, 69));
        previousButton.setMinimumSize(new java.awt.Dimension(69, 69));
        previousButton.setPreferredSize(new java.awt.Dimension(69, 69));
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        openSetupButton.setBackground(new java.awt.Color(41, 41, 41));
        openSetupButton.setForeground(java.awt.Color.white);
        openSetupButton.setText("Open Setup");
        openSetupButton.setFocusable(false);

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(currentMode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modeLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(openSetupButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(80, 80, 80)
                .addComponent(previousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(previousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addComponent(openSetupButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currentMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        notesScrollPane.setBackground(new java.awt.Color(41, 41, 41));
        notesScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        notesScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        notes.setBackground(new java.awt.Color(20, 20, 20));
        notes.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        notes.setForeground(new java.awt.Color(255, 255, 255));
        notes.setCaretColor(new java.awt.Color(255, 255, 255));
        notesScrollPane.setViewportView(notes);

        javax.swing.GroupLayout batteryPanelLayout = new javax.swing.GroupLayout(batteryPanel);
        batteryPanel.setLayout(batteryPanelLayout);
        batteryPanelLayout.setHorizontalGroup(
            batteryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        batteryPanelLayout.setVerticalGroup(
            batteryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(nextMatchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(nextMatchInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(matchSchedulePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(notesLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(notesScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                    .addComponent(batteryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checklistPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checklistLabel)
                                .addGap(330, 330, 330))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codeRedLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(nextMatchInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstLogo)
                            .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codeRedLogo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(batteryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(notesLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checklistLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checklistPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(notesScrollPane))
                .addGap(11, 11, 11))
            .addGroup(layout.createSequentialGroup()
                .addComponent(nextMatchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matchSchedulePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        if (CURRENT_MATCH > 0) {
            CURRENT_MATCH--;
            refresh();
        }
    }//GEN-LAST:event_previousButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if (CURRENT_MATCH < schedule.size() - 1) {
            CURRENT_MATCH++;
            refresh();
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void refresh() {
        Competition.getInstance().setNextCodeRedMatch(CURRENT_MATCH);
        Match match = schedule.get(CURRENT_MATCH);
        boolean red = match.getRedStation1() == 2771 || match.getRedStation2() == 2771 || match.getRedStation3() == 2771;
        nextMatchNumber.setText(String.valueOf(match.getMatchNumber()));
        nextMatchInfo.setText("Alliance: " + (red ? "Red Alliance" : "Blue Alliance") + "          Battery: " + match.getBattery().getBatteryLetter() + "          Time: " + match.getMatchTime());
        matchSchedulePanel.updateCurrentMatch(match.getMatchNumber() - 1);
        holder.setBackground(red ? Color.RED : Color.BLUE);
        nextMatchPanel.setBackground(red ? Color.RED : Color.BLUE);
        nextMatchInfo.setBackground(red ? Color.RED : Color.BLUE);
        batteryPanel.refresh();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private competitionsys.gui.components.Batteries batteryPanel;
    private competitionsys.chat.ChatGUI chatPanel;
    private javax.swing.JLabel checklistLabel;
    private competitionsys.gui.components.CheckListContainer checklistPanel;
    private javax.swing.JLabel codeRedLogo;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JComboBox currentMode;
    private javax.swing.JLabel firstLogo;
    private competitionsys.gui.components.MatchSchedulePanel matchSchedulePanel;
    private javax.swing.JLabel modeLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel nextMatchInfo;
    private javax.swing.JLabel nextMatchLabel;
    private javax.swing.JLabel nextMatchNumber;
    private javax.swing.JPanel nextMatchPanel;
    private javax.swing.JEditorPane notes;
    private javax.swing.JLabel notesLabel;
    private javax.swing.JScrollPane notesScrollPane;
    private javax.swing.JButton openSetupButton;
    private javax.swing.JButton previousButton;
    // End of variables declaration//GEN-END:variables

}
