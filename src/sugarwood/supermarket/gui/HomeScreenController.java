package sugarwood.supermarket.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class HomeScreenController implements Initializable {

    @FXML private Button manager = new Button();
    @FXML private Button supplier = new Button();
    @FXML private Button client = new Button();

    Stage primaryStage;
	
    @FXML
    private void managerButtonAction(ActionEvent event) {
    	
    	primaryStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    	Platform.runLater(
            () -> {
                try {
                    Parent managerScreen = FXMLLoader.load(getClass().getResource("/src/sugarwood.supermarket.gui/ManagerScreen.fxml"));
                    Scene scene = new Scene(managerScreen);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                } catch (IOException ex) { }
            });
    }
    
    @FXML
    private void supplierButtonAction(ActionEvent event) {
    	
    	primaryStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    	Platform.runLater(
            () -> {
                try {
                    Parent supplierScreen = FXMLLoader.load(getClass().getResource("/src/sugarwood.supermarket.gui/SupplierScreen.fxml"));
                    Scene scene = new Scene(supplierScreen);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                } catch (IOException ex) { }
            });
    }
    
    @FXML
    private void clientButtonAction(ActionEvent event) {
    	
    	primaryStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    	Platform.runLater(
            () -> {
                try {
                    Parent onlineStoreScreen = FXMLLoader.load(getClass().getResource("/src/sugarwood.supermarket.gui/OnlineStoreScreen.fxml"));
                    Scene scene = new Scene(onlineStoreScreen);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                } catch (IOException ex) { }
            });
    }
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    
    
}
