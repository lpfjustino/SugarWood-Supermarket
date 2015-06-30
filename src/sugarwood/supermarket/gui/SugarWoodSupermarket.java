package sugarwood.supermarket.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sugarwood.supermarket.SugarwoodClient;
import sugarwood.supermarket.Supermarket;
import sugarwood.supermarket.product.SupermarketProduct;

public class SugarWoodSupermarket extends Application {
    private static Supermarket supermarket;
    
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
        SugarwoodClient user;
        
//        smp = new SupermarketProduct("produto teste",
//                new Date(0), "LP", 1, 100.0);
//        supermarket.registerProduct(smp, 5);
//        
//        smp = new SupermarketProduct("outro produto",
//                new Date(10000), "élepê", 5, 150.50);
//        supermarket.registerProduct(smp, 15);
        
//        supermarket.listStock();
        
//        user = new SugarwoodClient(1, "LP", "Casa", "Tel", "Mail", "Pwd", 
//                supermarket);
//        supermarket.registerUser(user);
//        user.login();
//        user = new SugarwoodClient(1, "Biffi", "Quintal de Campenis",
//                "Outro Tel", "Outro Mail", "Outro Pwd", supermarket);
//        supermarket.registerUser(user);
//        supermarket.listUsers();
    }
    
    public static Supermarket getSupermarket() {
        return supermarket;
    }
}
