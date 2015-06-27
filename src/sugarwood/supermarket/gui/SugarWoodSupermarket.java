package sugarwood.supermarket.gui;

import java.util.Date;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sugarwood.supermarket.Supermarket;
import sugarwood.supermarket.product.SupermarketProduct;

public class SugarWoodSupermarket extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
//        launch(args);
        Supermarket supermarket = new Supermarket();
        SupermarketProduct smp;
        
        smp = new SupermarketProduct("produto teste",
                new Date(0), "LP", 1, 100.0);
        supermarket.registerProduct(smp, 5);
        
        smp = new SupermarketProduct("outro produto",
                new Date(10000), "élepê", 5, 150.50);
        supermarket.registerProduct(smp, 15);
        
        supermarket.listStock();
    }
    
}
