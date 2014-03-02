package competitionsys.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/*
 * ERROR CODES FOR PROGRAM - 485 - LINE 53 UNKNOWN SERVER REPONSE FOR GIVEN PASSWORD.
 */
public class Client implements Runnable {

    private Socket socket;
    private DataOutputStream dout;
    private DataInputStream din;
    private String nickname;
    private boolean sendingConnectionInfo = false;
    
    ChatGUI gui;

    @SuppressWarnings("CallToThreadStartDuringObjectConstruction")
    public Client(String host, int port, String password, String nickname, ChatGUI gui) {
        this.gui = gui;
        try {
            socket = new Socket(host, port);
            System.out.println("connected to " + socket);
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());
            this.nickname=nickname;
            processPassword(password);
            new Thread(this).start();
        } catch (IOException ie) {
            System.out.println(ie);
            gui.displayMessage("An error ocurred while connecting to to server.", ChatGUI.ERRORMESSAGE);
        }
    }

    public void processMessage(String message) {
        try {
            dout.writeUTF(message);
        } catch (IOException ie) {
            System.out.println(ie);
        }
    }

    private void processPassword(String password) {
        try {
            dout.writeUTF("ꜹ" + password);
            String serverReply = din.readUTF();
            switch (serverReply) {
                case "ꜹaccepted":
                    gui.setGUIConnected();
                    gui.displayMessage("Connected", ChatGUI.MESSAGE);
                    sendingConnectionInfo = true;
                    processMessage("ꜹ1"+nickname);
                    break;
                case "ꜹdenied":
                    gui.displayMessage("Incorrect password.  ", ChatGUI.ERRORMESSAGE);
                    disconnect();
                    break;
                default:
                    gui.displayMessage("The server gave an unknown responce for the given password.  ERROR CODE 485.", ChatGUI.ERRORMESSAGE);
                    disconnect();
                    break;
            }
        } catch (IOException ex) {
            gui.displayMessage("An error ocurred while sending the password to the server.", ChatGUI.ERRORMESSAGE);
        }
    }

    public void disconnect() {
        try {
            sendingConnectionInfo = true;
            processMessage("ꜹ2"+nickname);
            socket.close();
            din.close();
            dout.close();
            gui.setGuiDisconnected();
            gui.displayMessage("Disconnected.", ChatGUI.MESSAGE);
        } catch (IOException ex) {
            gui.displayMessage("Couldn't disconnect from the server.", ChatGUI.ERRORMESSAGE);
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = din.readUTF();
                if (!"ꜹ".equals(message.substring(0, 1))) {
                    String tempNick = "[" + nickname + "] ";
                    if (tempNick.equals(message.substring(0, tempNick.length()))){
                        gui.displayMessage(message, ChatGUI.MYMESSAGE);
                    } else {
                        gui.displayMessage(message, ChatGUI.INCOMMINGMESSAGE);
                    }
                } else if ("ꜹ1".equals(message.substring(0, 2)) && sendingConnectionInfo == false){
                    gui.displayMessage(message.substring(2) +" has connected.", ChatGUI.MESSAGE);
                } else if ("ꜹ1".equals(message.substring(0, 2)) && sendingConnectionInfo == true){
                    sendingConnectionInfo = false;
                }else if ("ꜹ2".equals(message.substring(0, 2)) && sendingConnectionInfo == false){
                    gui.displayMessage(message.substring(2) +" has disconnected.", ChatGUI.MESSAGE);
                } else if ("ꜹ2".equals(message.substring(0, 2)) && sendingConnectionInfo == true){
                    sendingConnectionInfo = false;
                }
            }
        } catch (IOException ie) {
            System.out.println(ie);
        }
    }
}
