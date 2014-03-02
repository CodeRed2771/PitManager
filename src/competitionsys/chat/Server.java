package competitionsys.chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server extends Thread{

    private ServerSocket ss;
    private final ArrayList<Connection> outputStreams = new ArrayList<>();
    private final int port;
    private final String password;

    @SuppressWarnings("CallToThreadStartDuringObjectConstruction")
    public Server(int port, String password) throws IOException {
        this.port = port;
        this.password = password;
        start();
    }
    
    @Override
    public void run(){
        try {
            listen(port, password);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listen(int port, String password) throws IOException {
        ss = new ServerSocket(port);
        System.out.println("Listening on " + ss);
        while (true) {
            Socket s = ss.accept();
            System.out.println("Connection from " + s);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            outputStreams.add(new Connection(s, dout));
            ServerThread serverThread = new ServerThread(this, s, password);
        }
    }
    
    void sendToAll(String message) {
        synchronized (outputStreams) {
            for (Connection c : outputStreams) {
                DataOutputStream dout = c.dout;
                try {
                    dout.writeUTF(message);
                } catch (IOException ie) {
                    System.out.println(ie);
                }
            }
        }
    }

    void removeConnection(Socket s) {
        synchronized (outputStreams) {
            System.out.println("Removing connection to " + s);
            for (Connection c : outputStreams){
                if (c.s == s){
                    outputStreams.remove(c);
                }
            }
            try {
                s.close();
            } catch (IOException ie) {
                System.out.println("Error closing " + s);
            }
        }
    }
    
    private class Connection {
        Socket s;
        DataOutputStream dout;

        public Connection(Socket s, DataOutputStream dout) {
            this.s = s;
            this.dout = dout;
        }
    }
}