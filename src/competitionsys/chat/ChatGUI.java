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
        displayMessage("Enter an IP, Password, and Nickname to start chatting...", STARTUP);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        ipField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nickNameField = new javax.swing.JTextField();
        connectButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();
        iAmServerButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatWindow = new javax.swing.JTextPane();
        inputField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("IP:");

        ipField.setBackground(new java.awt.Color(102, 102, 102));

        passwordField.setBackground(new java.awt.Color(102, 102, 102));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password:");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name:");

        nickNameField.setBackground(new java.awt.Color(102, 102, 102));
        nickNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nickNameFieldActionPerformed(evt);
            }
        });

        connectButton.setBackground(new java.awt.Color(0, 0, 0));
        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        disconnectButton.setBackground(new java.awt.Color(0, 0, 0));
        disconnectButton.setText("Disconnect");
        disconnectButton.setEnabled(false);
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        iAmServerButton.setBackground(new java.awt.Color(0, 0, 0));
        iAmServerButton.setText("I am Server");
        iAmServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iAmServerButtonActionPerformed(evt);
            }
        });

        chatWindow.setEditable(false);
        chatWindow.setBackground(new java.awt.Color(0, 0, 0));
        chatWindow.setFocusable(false);
        jScrollPane1.setViewportView(chatWindow);

        inputField.setBackground(new java.awt.Color(51, 51, 51));
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(40, 40, 40)
                                .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(4, 4, 4)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nickNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(iAmServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(disconnectButton)))
                        .addGap(0, 106, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1))))
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
                    .addComponent(connectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(iAmServerButton)
                    .addComponent(disconnectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inputFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputFieldFocusGained
        if ("Type your message here...".equals(inputField.getText()) && inputField.getFont() == fontI) {
            inputField.setFont(fontD);
            inputField.setText("");
        }
    }//GEN-LAST:event_inputFieldFocusGained

    private void inputFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputFieldFocusLost
        if ("".equals(inputField.getText())) {
            inputField.setFont(fontI);
            inputField.setText("Type your message here...");
        }
    }//GEN-LAST:event_inputFieldFocusLost

    private void inputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFieldActionPerformed
        client.processMessage(nickname + evt.getActionCommand());
        inputField.setText("");
    }//GEN-LAST:event_inputFieldActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        IP = ipField.getText();
        password = passwordField.getText();
        nickname = "[" + nickNameField.getText() + "] ";
        if ("".equals(IP) || "".equals(password) || "".equals(nickname)){
            displayMessage("You must enter a valid IP, password, and nickname.", ERRORMESSAGE);
        } else if (!"".equals(IP) || !"".equals(password) || !"".equals(nickname)){
            client = new Client(IP, 23666, password, nickNameField.getText(), this);
        }
    }//GEN-LAST:event_connectButtonActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
        IP = null;
        nickname = null;
        password = null;
        client.disconnect();
        setGuiDisconnected();
    }//GEN-LAST:event_disconnectButtonActionPerformed

    private void nickNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nickNameFieldActionPerformed
        connectButtonActionPerformed(evt);
    }//GEN-LAST:event_nickNameFieldActionPerformed

    private void iAmServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iAmServerButtonActionPerformed
        new StartServerGUI().setVisible(true);
    }//GEN-LAST:event_iAmServerButtonActionPerformed
    private void ableToType(boolean able) {
        inputField.setEnabled(able);
    }
    public void setGUIConnected(){
        inputField.setEnabled(true);
        connectButton.setEnabled(false);
        disconnectButton.setEnabled(true);
        iAmServerButton.setEnabled(false);
        ipField.setEnabled(false);
        passwordField.setEnabled(false);
        nickNameField.setEnabled(false);
    }

    public void setGuiDisconnected() {
        inputField.setEnabled(false);
        connectButton.setEnabled(true);
        disconnectButton.setEnabled(false);
        iAmServerButton.setEnabled(true);
        ipField.setEnabled(true);
        passwordField.setEnabled(true);
        nickNameField.setEnabled(true);
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
            StyleConstants.setForeground(keyWord, Color.ORANGE);
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
            System.out.println(e);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nickNameField;
    private javax.swing.JPasswordField passwordField;
    // End of variables declaration//GEN-END:variables
}
