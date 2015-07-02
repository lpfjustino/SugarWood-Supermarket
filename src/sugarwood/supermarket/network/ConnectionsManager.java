package sugarwood.supermarket.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionsManager {
    public static final int PORT = 1234;
    public static final String IP = "127.0.0.1";
    
    
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            boolean listening = true;
            
            new Thread(() -> {
                while(listening) {
                    try {
                        Socket newClient = server.accept();
                        new ConnectionsHandler(newClient).start();
                    } catch (IOException ex) {
                    }
                }
            }).start();
        } catch (IOException ex) {
            Logger.getLogger(ConnectionsManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}