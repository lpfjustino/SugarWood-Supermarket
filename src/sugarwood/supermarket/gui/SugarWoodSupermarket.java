package sugarwood.supermarket.gui;

import java.net.Socket;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sugarwood.supermarket.Supermarket;
import sugarwood.supermarket.User;
import sugarwood.supermarket.csv.CSVManager;

public class SugarWoodSupermarket extends Application {
    private static Supermarket supermarket;
    private static Socket userSocket;
    private static int userID;
    
    public SugarWoodSupermarket() {
        supermarket = new Supermarket();
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // Cria um primeiro usuário para ser administrador
        User user = new User(1, "admin", "admin", "admin", "admin", "admin");
        CSVManager.persist(user);

        launch(args);
    }
    
    public static Supermarket getSupermarket() {
        return supermarket;
    }
    
    public static Socket getUserSocket() {
        return userSocket;
    }

    public static void setUserSocket(Socket aUserSocket) {
        userSocket = aUserSocket;
    }
    
    public static int getUserID() {
        return userID;
    }

    public static void setUserID(int aUserID) {
        userID = aUserID;
    }
}