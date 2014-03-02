package competitionsys.chat;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;


public class ServerThread extends Thread {

    private final Server server;
    private final Socket socket;
    private final String password;

    @SuppressWarnings("CallToThreadStartDuringObjectConstruction")
    public ServerThread(Server server, Socket socket, String password) {
        this.server = server;
        this.socket = socket;
        this.password = password;
        start();
    }

    @Override
    public void run() {
        try {
            DataInputStream din = new DataInputStream(socket.getInputStream());
            while (true) {
                String message = din.readUTF();
                String temp = message;
                String passCheck = temp.substring(0, 1);
                if ("ꜹ".equals(passCheck)){
                    String givenPassword = temp.substring(1);
                    if (givenPassword.equals(this.password)){
                        server.sendToAll("ꜹaccepted");
                    } else {
                        server.sendToAll("ꜹdenied");
                    }
                }
                System.out.println("Sending " + message);
                server.sendToAll(message);
            }
        } catch (EOFException ie) {
        } catch (IOException ie) {
        } finally {
            server.removeConnection(socket);
        }
    }
}