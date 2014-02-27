package competitionsys.gui;

/**
 *
 * @author Michael
 */
public class MatchScheduleRow extends javax.swing.JPanel {

    /** Creates new form MatchScheduleRow */
    public MatchScheduleRow() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blue1 = new javax.swing.JLabel();
        matchNumber = new javax.swing.JLabel();
        blue2 = new javax.swing.JLabel();
        blue3 = new javax.swing.JLabel();
        red1 = new javax.swing.JLabel();
        red2 = new javax.swing.JLabel();
        red3 = new javax.swing.JLabel();
        battery = new javax.swing.JLabel();
        time = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        blue1.setBackground(new java.awt.Color(0, 0, 255));
        blue1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        blue1.setForeground(new java.awt.Color(255, 255, 255));
        blue1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        blue1.setText("Station 1");
        blue1.setOpaque(true);

        matchNumber.setBackground(new java.awt.Color(0, 0, 0));
        matchNumber.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        matchNumber.setForeground(new java.awt.Color(255, 255, 255));
        matchNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        matchNumber.setText("#");
        matchNumber.setOpaque(true);

        blue2.setBackground(new java.awt.Color(0, 0, 255));
        blue2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        blue2.setForeground(new java.awt.Color(255, 255, 255));
        blue2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        blue2.setText("Station 2");
        blue2.setOpaque(true);

        blue3.setBackground(new java.awt.Color(0, 0, 255));
        blue3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        blue3.setForeground(new java.awt.Color(255, 255, 255));
        blue3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        blue3.setText("Station 3");
        blue3.setOpaque(true);

        red1.setBackground(new java.awt.Color(255, 0, 0));
        red1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        red1.setForeground(new java.awt.Color(255, 255, 255));
        red1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        red1.setText("Station 1");
        red1.setOpaque(true);

        red2.setBackground(new java.awt.Color(255, 0, 0));
        red2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        red2.setForeground(new java.awt.Color(255, 255, 255));
        red2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        red2.setText("Station 2");
        red2.setOpaque(true);

        red3.setBackground(new java.awt.Color(255, 0, 0));
        red3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        red3.setForeground(new java.awt.Color(255, 255, 255));
        red3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        red3.setText("Station 3");
        red3.setOpaque(true);

        battery.setBackground(new java.awt.Color(0, 0, 0));
        battery.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        battery.setForeground(new java.awt.Color(255, 255, 255));
        battery.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        battery.setText("Battery");
        battery.setOpaque(true);

        time.setBackground(new java.awt.Color(0, 0, 0));
        time.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        time.setText("Est. Time");
        time.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(matchNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(blue1)
                .addGap(18, 18, 18)
                .addComponent(blue2)
                .addGap(18, 18, 18)
                .addComponent(blue3)
                .addGap(18, 18, 18)
                .addComponent(red1)
                .addGap(18, 18, 18)
                .addComponent(red2)
                .addGap(18, 18, 18)
                .addComponent(red3)
                .addGap(18, 18, 18)
                .addComponent(battery)
                .addGap(18, 18, 18)
                .addComponent(time)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(blue1)
                .addComponent(blue2)
                .addComponent(blue3)
                .addComponent(red1)
                .addComponent(red2)
                .addComponent(red3)
                .addComponent(battery)
                .addComponent(time)
                .addComponent(matchNumber))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel battery;
    private javax.swing.JLabel blue1;
    private javax.swing.JLabel blue2;
    private javax.swing.JLabel blue3;
    private javax.swing.JLabel matchNumber;
    private javax.swing.JLabel red1;
    private javax.swing.JLabel red2;
    private javax.swing.JLabel red3;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables

}
