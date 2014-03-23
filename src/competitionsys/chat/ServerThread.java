package competitionsys.chat;

import competitionsys.chat.Server.Connection;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class ServerThread implements Runnable {

    private final Connection connection;
    private final Server server;

    boolean isAuth = false;
    int authTries = 0;

    public ServerThread(Server server, Connection connection) {
        this.server = server;
        this.connection = connection;
    }

    public ServerThread start() {
        new Thread(this).start();
        return this;
    }

    @Override
    public void run() {
        try {
            DataInputStream din = connection.getDataInputStream();
            connection.getDataOutputStream().writeUTF("5Please enter your password...");
            while (!isAuth) {
                String password = din.readUTF();
                if (password.equals(server.password)) {
                    isAuth = true;
                    server.authenticateClient(connection);
                    server.relayNewAuthenticatedConnection(connection);
                    connection.getDataOutputStream().writeUTF("5You are now connected.");
                    connection.getDataOutputStream().writeUTF("6");
                } else {
                    authTries++;
                    if (authTries >= 3) {
                        connection.getDataOutputStream().writeUTF("5Too many failed attempts, you are banned.");
                        connection.getDataOutputStream().writeUTF("7");
                        server.relayBan(connection);
                        server.ban(connection);
                        connection.close();
                    } else {
                        connection.getDataOutputStream().writeUTF("5Incorrect, please try again.");
                    }
                }
            }

            while (true && isAuth) {
                String message = din.readUTF();
                server.relayMessage(message, connection);
            }
        } catch (EOFException ie) {
        } catch (IOException ie) {
        } finally {
            if (isAuth) {
                server.removeAuthenticatedClient(connection);
                server.relayAuthenticatedConnectionDisconnect(connection);
            } else {
                server.removeUnauthenticatedClient(connection);
            }
            connection.close();
        }
    }
}
