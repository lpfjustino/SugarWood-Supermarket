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
                System.out.println(inputLine);
                Command cmd = Command.parseCommand(inputLine);
                String[] params = inputLine.split(",");
                
                // Comando válido
                switch(cmd) {
                    // TRATAR OPERAÇÕES
                    case LOGIN:
                        try {
                            authenticate(params[1], params[2], params[3]);
                            out.println(Command.LOGIN_SUCCESS.representation);
                        } catch(NoSuchUserException ex) {
                            out.println(Command.INVALID_USER);
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
    
    private void authenticate(String email, String pwd, String type)
            throws NoSuchUserException {
        ArrayList<User> users = CSVManager.fetch(User.class);
        User user = null;
        try {
            user = users
                    .stream()
                    .filter(usr -> {
                        return (usr.getMail().equals(email) &&
                                usr.getPassword().equals(pwd));
                    })
                    .findFirst()
                    .get();
            
        } catch(NoSuchElementException ex) {
            GUIManager.showDialog("Failure", "Login failed.",
                                    "User not found.");
        }
        
        if(user == null) {
            NoSuchUserException ex = new NoSuchUserException();
            throw ex;
        }
    }
}
