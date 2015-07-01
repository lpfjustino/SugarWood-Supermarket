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
import javafx.stage.Stage;

public class ManagerScreenController implements Initializable {
	
	@FXML private Button newUser = new Button();
    @FXML private Button newProduct = new Button();
    @FXML private Button stock = new Button();

    Stage primaryStage;
	
    @FXML
    private void newUserButtonAction(ActionEvent event) {
    	
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
    private void newProductButtonAction(ActionEvent event) {
    	
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
    private void stockButtonAction(ActionEvent event) {
    	
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
        // TODO
    }    
    
}
