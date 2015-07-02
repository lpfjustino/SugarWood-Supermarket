package sugarwood.supermarket.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import sugarwood.supermarket.NoSuchUserException;
import sugarwood.supermarket.User;
import sugarwood.supermarket.csv.CSVManager;
import sugarwood.supermarket.gui.GUIManager;

public class ConnectionsHandler extends Thread {
    private Socket socket =  null;
    
    public ConnectionsHandler(Socket socket) {
        super("SuperMarketServer Thread");
        this.socket = socket;
    }
    
    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
            String inputLine;
            
            All:
            while ((inputLine = in.readLine()) != null) {
                String[] params = inputLine.split(",");
                Command cmd = Command.parseCommand(params[0]);
                
                // Comando válido
                switch(cmd) {
                    // TRATAR OPERAÇÕES
                    case LOGIN:
                        try {
                            User user = authenticate(params[1], params[2], params[3]);
                            out.println(Command.loginResponse(true, user));
                        } catch(NoSuchUserException ex) {
                            out.println(Command.loginResponse(false, null));
                        }
                        break;
                
                    case EXIT:
                        break All;
                }
            }
            out.close();
            in.close();
            socket.close();

        } catch (IOException e) {
        }
    }
    
    // Autentica o login do usuário
    private User authenticate(String email, String pwd, String type)
            throws NoSuchUserException {
        // Preenche uma coleção de usuários para verificar se o usuário está
        // cadastrado
        ArrayList<User> users = CSVManager.fetch(User.class);
        NoSuchUserException nsu = new NoSuchUserException();
        
        try {
            User user = users
                .stream()
                .filter(usr -> {
                    return (usr.getMail().equals(email) &&
                            usr.getPassword().equals(pwd));
                })
                .findFirst()
                .get();
       
            if(user == null)
                throw nsu;
            
            else
                return user;
        }
        catch(NoSuchElementException ex) {
            throw nsu;
        }
        
    }
}
