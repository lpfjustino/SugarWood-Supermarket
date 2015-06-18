package sugarwood.supermarket;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class ConnectionsManager {
    private ServerSocket server;
    private ArrayList<Socket> connections;

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
}
