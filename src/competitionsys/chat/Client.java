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

    ChatGUI gui;
    
    public static boolean auth = false;
    public static boolean run = true;

    String nickname;

    public Client(String host, int port, String nickname, ChatGUI gui) {
        try {
            socket = new Socket(host, port);
            System.out.println("Client connected to " + socket);
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());
            this.nickname = nickname;
            dout.writeUTF(nickname);
            gui.setGUIConnected();
            this.gui = gui;
            start();
        } catch (IOException ie) {
            ie.printStackTrace();
            gui.displayMessage("An error ocurred while connecting to to server.", ChatGUI.ERRORMESSAGE);
        }
    }

    public void start() {
        run = true;
        Thread t = new Thread(this);
        t.start();
    }

    public void sendMessage(String message) {
        try {
            dout.writeUTF(message);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            run = false;
            auth = false;
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
            while (run) {
                String message = din.readUTF();
                switch (Integer.parseInt(message.substring(0, 1))) {
                    case 1:
                        gui.displayMessage(message.substring(1), ChatGUI.INCOMMINGMESSAGE);
                        break;
                    case 2:
                        gui.displayMessage(message.substring(1) + " has connected.", ChatGUI.MESSAGE);
                        break;
                    case 3:
                        gui.displayMessage(message.substring(1) + " has disconnected.", ChatGUI.MESSAGE);
                        break;
                    case 4:
                        gui.displayMessage(message.substring(1) + " has been banned.", ChatGUI.MESSAGE);
                        break;
                    case 5:
                        gui.displayMessage(message.substring(1), ChatGUI.MESSAGE);
                        break;
                    case 6:
                        auth = true;
                        break;
                    case 7:
                        disconnect();
                        break;
                }
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
