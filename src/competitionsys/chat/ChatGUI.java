package competitionsys.chat;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author michael
 */
public final class ChatGUI extends javax.swing.JPanel {

    public static String nickname, IP, password;
    private Client client = null;

    public static final int STARTUP = 4, MESSAGE = 1, MYMESSAGE = 2, INCOMMINGMESSAGE = 3, ERRORMESSAGE = 5;

    final Font fontD = new JLabel().getFont();
    Font fontI = new Font(fontD.getFontName(), Font.ITALIC, 15);
    Font fontB = new Font(fontD.getFontName(), Font.BOLD, 15);

    public ChatGUI() {
        initComponents();
        ableToType(false);
        inputField.setFont(fontI);
        inputField.setText("Type your message here...");
        displayMessage("Enter an IP and a nickname to start chatting...", STARTUP);
        inputField.setForeground(new Color(255, 255, 255));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        ipField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nickNameField = new javax.swing.JTextField();
        connectButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();
        iAmServerButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatWindow = new javax.swing.JTextPane();
        inputField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("IP:");

        ipField.setBackground(new java.awt.Color(0, 0, 0));
        ipField.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name:");

        nickNameField.setBackground(new java.awt.Color(0, 0, 0));
        nickNameField.setForeground(new java.awt.Color(255, 255, 255));
        nickNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nickNameFieldActionPerformed(evt);
            }
        });

        connectButton.setBackground(new java.awt.Color(0, 0, 0));
        connectButton.setText("Connect");
        connectButton.setFocusable(false);
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        disconnectButton.setBackground(new java.awt.Color(0, 0, 0));
        disconnectButton.setText("Disconnect");
        disconnectButton.setEnabled(false);
        disconnectButton.setFocusable(false);
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        iAmServerButton.setBackground(new java.awt.Color(0, 0, 0));
        iAmServerButton.setText("Start Server");
        iAmServerButton.setFocusable(false);
        iAmServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iAmServerButtonActionPerformed(evt);
            }
        });

        chatWindow.setEditable(false);
        chatWindow.setBackground(new java.awt.Color(0, 0, 0));
        chatWindow.setFocusable(false);
        jScrollPane1.setViewportView(chatWindow);

        inputField.setBackground(new java.awt.Color(0, 0, 0));
        inputField.setForeground(new java.awt.Color(255, 255, 255));
        inputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFieldActionPerformed(evt);
            }
        });
        inputField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputFieldFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addComponent(nickNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(connectButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disconnectButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iAmServerButton))
                    .addComponent(inputField))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(nickNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connectButton)
                    .addComponent(disconnectButton)
                    .addComponent(iAmServerButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inputFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputFieldFocusGained
        if ("Type your message here...".equals(inputField.getText()) && inputField.getFont() == fontI) {
            inputField.setFont(fontD);
            inputField.setText("");
        }
        inputField.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_inputFieldFocusGained

    private void inputFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputFieldFocusLost
        if ("".equals(inputField.getText())) {
            inputField.setFont(fontI);
            inputField.setText("Type your message here...");
        }
        inputField.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_inputFieldFocusLost

    private void inputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFieldActionPerformed
        client.sendMessage(evt.getActionCommand());
        if (Client.auth) {
            displayMessage(nickname + evt.getActionCommand(), MYMESSAGE);
        }
        inputField.setText("");
    }//GEN-LAST:event_inputFieldActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        IP = ipField.getText();
        nickname = "[" + nickNameField.getText() + "] ";
        if ("".equals(IP) || "".equals(nickname)) {
            displayMessage("You must enter a valid IP and nickname.", ERRORMESSAGE);
        } else {
            client = new Client(IP, 23666, nickNameField.getText(), this);
        }
    }//GEN-LAST:event_connectButtonActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
        IP = null;
        nickname = null;
        client.disconnect();
        setGuiDisconnected();
    }//GEN-LAST:event_disconnectButtonActionPerformed

    private void nickNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nickNameFieldActionPerformed
        connectButtonActionPerformed(evt);
    }//GEN-LAST:event_nickNameFieldActionPerformed

    private void iAmServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iAmServerButtonActionPerformed
        new StartServerGUI(this).setVisible(true);
    }//GEN-LAST:event_iAmServerButtonActionPerformed

    public void setIPtoLocalhost() {
        ipField.setText("localhost");
    }

    private void ableToType(boolean able) {
        inputField.setEnabled(able);
    }

    public void setGUIConnected() {
        inputField.setEnabled(true);
        connectButton.setEnabled(false);
        disconnectButton.setEnabled(true);
        iAmServerButton.setEnabled(false);
        ipField.setEnabled(false);
        nickNameField.setEnabled(false);
        inputField.setForeground(new Color(255, 255, 255));
    }

    public void setGuiDisconnected() {
        inputField.setEnabled(false);
        connectButton.setEnabled(true);
        disconnectButton.setEnabled(false);
        iAmServerButton.setEnabled(true);
        ipField.setEnabled(true);
        nickNameField.setEnabled(true);
        inputField.setForeground(new Color(255, 255, 255));
    }

    public void displayMessage(String message, int type) {
        StyledDocument doc = chatWindow.getStyledDocument();
        SimpleAttributeSet keyWord = new SimpleAttributeSet();
        StyleConstants.setForeground(keyWord, Color.BLUE);
        StyleConstants.setBold(keyWord, true);
        final String finalmessage;
        String prefix = null;
        if (type == 1) {
            StyleConstants.setForeground(keyWord, Color.MAGENTA);
            prefix = "\n[INFO] ";
        } else if (type == 2) {
            StyleConstants.setForeground(keyWord, Color.WHITE);
            prefix = "\n";
        } else if (type == 3) {
            StyleConstants.setForeground(keyWord, Color.BLUE);
            prefix = "\n";
        } else if (type == 4) {
            StyleConstants.setForeground(keyWord, Color.MAGENTA);
            prefix = "[INFO] ";
        } else if (type == 5) {
            StyleConstants.setForeground(keyWord, Color.RED);
            prefix = "\n";
        }
        finalmessage = prefix + message;
        try {
            doc.insertString(doc.getLength(), finalmessage, keyWord);
            chatWindow.setCaretPosition(chatWindow.getDocument().getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane chatWindow;
    private javax.swing.JButton connectButton;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JButton iAmServerButton;
    private javax.swing.JTextField inputField;
    private javax.swing.JTextField ipField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nickNameField;
    // End of variables declaration//GEN-END:variables
}
