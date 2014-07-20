package competitionsys;

import competitionsys.persistence.FileIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Michael
 */
public class Window extends javax.swing.JFrame {

    /**
     * Creates new form PitManager2
     */
    public Window() {
        initComponents();
        this.setLocation(0, 0);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        
        setupCloseListener();
    }

    public void initCards() {
        mainCard.init();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardPanel = new javax.swing.JPanel();
        mainCard = new competitionsys.gui.cards.MainHolder();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Pit Manager");
        setBackground(new java.awt.Color(41, 41, 41));
        setMinimumSize(new java.awt.Dimension(1150, 750));

        cardPanel.setBackground(new java.awt.Color(0, 0, 0));
        cardPanel.setLayout(new java.awt.CardLayout());

        mainCard.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        mainCard.setMinimumSize(new java.awt.Dimension(840, 525));
        cardPanel.add(mainCard, "main");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
      private void setupCloseListener() {
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            Window gui;

            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                int close = JOptionPane.showConfirmDialog(gui, "Are you sure you want to close?", "Confirm Close", JOptionPane.YES_NO_OPTION);
                if (close == 0) {
                    
                    FileIO.writeMemory("pitmanager");
                    System.exit(0);
                }
            }

            public java.awt.event.WindowAdapter init(Window gui) {
                this.gui = gui;
                return this;
            }
        }.init(this));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardPanel;
    private competitionsys.gui.cards.MainHolder mainCard;
    // End of variables declaration//GEN-END:variables

}
