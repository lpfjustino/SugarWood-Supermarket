package sugarwood.supermarket.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ConnectionsManager {
    private ServerSocket server;
    private ArrayList<Socket> connections;
    private boolean listening;
    public static final int PORT = 1234;
    public static final String IP = "127.0.0.1";
    
    public ConnectionsManager() {
        listening = true;
        connections = new ArrayList<>();
        try {
            server = new ServerSocket(PORT);
            initialize();
        } catch (IOException ex) {
        }
    }

    public ServerSocket getServer() {
        return server;
    }

    public void setServer(ServerSocket server) {
        this.server = server;
    }

    public ArrayList<Socket> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<Socket> connections) {
        this.connections = connections;
    }
    
    private void initialize() {
        new Thread(() -> {
            while(listening) {
                try {
                    Socket newClient = server.accept();
                    connections.add(newClient);
                    new SuperMarketServer(newClient).start();
                } catch (IOException ex) {
                }
            } 
        }).start();
    }
}