package competitionsys;

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
        matchSchedulePanel1 = new competitionsys.gui.MatchSchedulePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Pit Manager");
        setBackground(new java.awt.Color(0, 0, 0));

        container.setBackground(new java.awt.Color(0, 0, 0));

        chatGUI1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        matchSchedulePanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chatGUI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matchSchedulePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                .addContainerGap())
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(matchSchedulePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chatGUI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private competitionsys.chat.ChatGUI chatGUI1;
    private javax.swing.JPanel container;
    private competitionsys.gui.MatchSchedulePanel matchSchedulePanel1;
    // End of variables declaration//GEN-END:variables
}
