package sugarwood.supermarket.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SugarwoodServer {
    public static final int PORT = 1234;
    public static final String IP = "127.0.0.1";
    
    public static void main(String[] args) {
        try {
            boolean listening = true;
            ServerSocket server = new ServerSocket(PORT);
            
            // Designa uma thread para tratar novas conexões
            new Thread(() -> {
                while(listening) {
                    try {
                        Socket newClient = server.accept();
                        new ConnectionsHandler(newClient).start();
                        System.out.println("CRIOU UM SOCKET PRO BRODER");
                    } catch (IOException ex) {
                    }
                }
            }).start();
        } catch (IOException ex) {
        }
    }
}