package competitionsys.gui;

/**
 *
 * @author Michael
 */
public class ActionPanel extends javax.swing.JPanel {

    /** Creates new form ActionPanel */
    public ActionPanel() {
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

        batteries = new competitionsys.gui.actionpanels.Batteries();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new java.awt.CardLayout());
        add(batteries, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private competitionsys.gui.actionpanels.Batteries batteries;
    // End of variables declaration//GEN-END:variables

}
