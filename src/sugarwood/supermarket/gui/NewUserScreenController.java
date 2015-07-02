package sugarwood.supermarket.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import sugarwood.supermarket.User;
import sugarwood.supermarket.csv.CSVManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewUserScreenController implements Initializable {
	
	User user;
    
    @FXML private TextField idField = new TextField();
    @FXML private TextField nameField = new TextField();
    @FXML private TextField addressField = new TextField();
    @FXML private TextField phoneField = new TextField();
    @FXML private TextField mailField = new TextField();
    @FXML private TextField passwordField = new TextField();

    Stage primaryStage;
	
    @FXML
    private void confirmButtonAction(ActionEvent event) {
        try {
            // Recupera os campos da GUI
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String mail = mailField.getText();
            String password = passwordField.getText();

            // Cria uma instância do novo usuario
            user = new User (id, name, address, phone, mail, password);
        
            // Verifica se ocorreu uma inserção ou remoção e notifica o usuário
            // com um Alert apropriado
            CSVManager.persist(user);
            
            GUIManager.showDialog("Success",
                                        "User registered/updated.",
                                        "The user has been registered/updated successfully.");
        
        } catch (NumberFormatException ex) {
        }
        
        // Retorna para a tela principal
        primaryStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    	Platform.runLater(
            () -> {
                try {
                    Parent loans = FXMLLoader.load(getClass().getResource("ManagerScreen.fxml"));
                    Scene scene = new Scene(loans);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                } catch (IOException ex) { }
            });
	}
    
    @FXML
    private void cancelButtonAction(ActionEvent event) {
        // Retorna para a tela principal
        primaryStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    	Platform.runLater(
            () -> {
                try {
                    Parent loans = FXMLLoader.load(getClass().getResource("ManagerScreen.fxml"));
                    Scene scene = new Scene(loans);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                } catch (IOException ex) { }
            });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
