package sugarwood.supermarket.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SuperMarketServer extends Thread {
    private Socket socket =  null;
    
    public SuperMarketServer(Socket socket) {
        super("SuperMarketServer Thread");
        this.socket = socket;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("ALGUM FILHO DA PUTA CONECTOU NESSE LIXO");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                Command cmd = Command.parseCommand(inputLine);
                
                // Comando válido
                if(cmd != null) {
                    // TRATAR OPERAÇÃO
                
                    if (cmd.equals(Command.EXIT))
                        break;
                }
            }
            out.close();
            in.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}