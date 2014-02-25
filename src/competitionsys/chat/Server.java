package competitionsys.chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server extends Thread{

    private ServerSocket ss;
    private Hashtable outputStreams = new Hashtable();
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
            outputStreams.put(s, dout);
            ServerThread serverThread = new ServerThread(this, s, password);
        }
    }

    Enumeration getOutputStreams() {
        return outputStreams.elements();
    }

    void sendToAll(String message) {
        synchronized (outputStreams) {
            for (Enumeration e = getOutputStreams(); e.hasMoreElements();) {
                DataOutputStream dout = (DataOutputStream) e.nextElement();
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
            outputStreams.remove(s);
            try {
                s.close();
            } catch (IOException ie) {
                System.out.println("Error closing " + s);
            }
        }
    }
}