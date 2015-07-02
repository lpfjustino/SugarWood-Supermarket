package sugarwood.supermarket.gui;

import java.net.Socket;
import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sugarwood.supermarket.Supermarket;
import sugarwood.supermarket.User;
import sugarwood.supermarket.product.SupermarketProduct;

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
        launch(args);
        SupermarketProduct smp;
        User user;
        
        smp = new SupermarketProduct("produto teste",
                new Date(), "LP", 1, 100.0);
        supermarket.registerProduct(smp, 5);

        smp = new SupermarketProduct("outro produto",
                new Date(), "elepe", 5, 150.50);
        supermarket.registerProduct(smp, 15);
        
        supermarket.listStock();
        
        user = new User(1, "LP", "Casa", "Tel", "Mail", "Pwd");
        supermarket.registerUser(user);
        user = new User(2, "Biffi", "Quintal de Campenis",
                "Outro Tel", "Outro Mail", "Outro Pwd");
        supermarket.registerUser(user);
        
//        supermarket.listUsers();
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