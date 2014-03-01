package competitionsys;

import competitionsys.persistence.FileIO;
import competitionsys.persistence.ReadCSV;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JOptionPane;

/**
 *
 * @author Michael
 */
public class Window extends javax.swing.JFrame {

    /**
     * Creates new form Window
     */
    public Window() {
        initComponents();
        //<editor-fold defaultstate="collapsed" desc=" Center Window to Screen ">
        GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = g.getScreenDevices();

        int width = devices[0].getDisplayMode().getWidth();
        int height = devices[0].getDisplayMode().getHeight();

        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (width - w) / 2;
        int y = (height - h) / 2;
        this.setLocation(x, y);
        //</editor-fold>
        
        nextMatchPanel1.refresh();
        
        setupCloseListener();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        chatGUI1 = new competitionsys.chat.ChatGUI();
        nextMatchPanel1 = new competitionsys.gui.NextMatchPanel();
        actionPanel2 = new competitionsys.gui.ActionPanel();
        matchSchedulePanel2 = new competitionsys.gui.MatchSchedulePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Pit Manager");
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);

        container.setBackground(new java.awt.Color(0, 0, 0));

        chatGUI1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        actionPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        matchSchedulePanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chatGUI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextMatchPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actionPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                    .addComponent(matchSchedulePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addComponent(nextMatchPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chatGUI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(containerLayout.createSequentialGroup()
                        .addComponent(actionPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8)
                        .addComponent(matchSchedulePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private competitionsys.gui.ActionPanel actionPanel2;
    private competitionsys.chat.ChatGUI chatGUI1;
    private javax.swing.JPanel container;
    private competitionsys.gui.MatchSchedulePanel matchSchedulePanel2;
    private competitionsys.gui.NextMatchPanel nextMatchPanel1;
    // End of variables declaration//GEN-END:variables
}
