package competitionsys.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class Server implements Runnable {

    private static final ArrayList<Connection> authenticatedClients = new ArrayList<>();
    private static final ArrayList<Connection> unauthenticatedClients = new ArrayList<>();
    private static final ArrayList<InetAddress> bannedAddresses = new ArrayList<>();

    ServerSocket ss;
    public String password;

    public int port;

    public Server(int port, String password) {
        this.port = port;
        this.password = password;
    }

    public Server start() {
        new Thread(this).start();
        return this;
    }

    @Override
    public void run() {
        try {
            ss = new ServerSocket(port);
            System.out.println("Listening on " + ss);
            while (true) {
                Socket s = ss.accept();
                if (!bannedAddresses.contains(s.getInetAddress())) {
                    System.out.println("Connection from " + s);
                    DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                    DataInputStream din = new DataInputStream(s.getInputStream());
                    String nickname = din.readUTF();
                    Connection connection = new Connection(s, dout, din, nickname);
                    unauthenticatedClients.add(connection);
                    ServerThread serverThread = new ServerThread(this, connection).start();
                } else {
                    DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                    dout.writeUTF("5Connection refused becuase you are banned.");
                    dout.writeUTF("7");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void authenticateClient(Connection connection) {
        unauthenticatedClients.remove(connection);
        authenticatedClients.add(connection);
    }

    public void removeAuthenticatedClient(Connection connection) {
        authenticatedClients.remove(connection);
    }

    public void removeUnauthenticatedClient(Connection connection) {
        unauthenticatedClients.remove(connection);
    }

    public void ban(Connection connection) {
        bannedAddresses.add(connection.getSocket().getInetAddress());
    }

    public void relayMessage(String message, Connection connection) {
        relay("1[" + connection.nickname + "]" + " " + message, connection);
    }

    public void relayNewAuthenticatedConnection(Connection connection) {
        relay("2" + connection.nickname, connection);
    }

    public void relayAuthenticatedConnectionDisconnect(Connection connection) {
        relay("3" + connection.nickname, connection);
    }

    public void relayBan(Connection connection) {
        relay("4" + connection.nickname, connection);
    }

    private void relay(String message, Connection sender) {
        synchronized (authenticatedClients) {
            for (Connection connection : authenticatedClients) {
                try {
                    if (connection != sender) {
                        connection.getDataOutputStream().writeUTF(message);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public class Connection {

        private Socket s;
        private DataOutputStream dout;
        private DataInputStream din;

        String nickname;

        public Connection(Socket s, DataOutputStream dout, DataInputStream din, String nickname) {
            this.s = s;
            this.dout = dout;
            this.din = din;
            this.nickname = nickname;
        }

        public void close() {
            try {
                nickname = "";
                s.close();
                dout.close();
                din.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public Socket getSocket() {
            return s;
        }

        public void setSocket(Socket s) {
            this.s = s;
        }

        public DataOutputStream getDataOutputStream() {
            return dout;
        }

        public void setDataOutputStream(DataOutputStream dout) {
            this.dout = dout;
        }

        public DataInputStream getDataInputStream() {
            return din;
        }

        public void setDataInputStream(DataInputStream din) {
            this.din = din;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }
}
