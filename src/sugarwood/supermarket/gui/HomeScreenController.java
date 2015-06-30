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
import sugarwood.supermarket.SugarwoodClient;
import sugarwood.supermarket.User;

public class HomeScreenController implements Initializable {
    @FXML Button mail;
    @FXML TextField username;
    @FXML TextField password;
    @FXML ToggleGroup userType;
    
    @FXML
    private void loginButtonAction(ActionEvent event) {
        // Recupera os campos da GUI
        String email = this.mail.getText();
        String pwd = password.getText();
        String type = ((RadioButton) userType.getSelectedToggle()).getText();

        try {
            // VERIFICAR NO CSV VALIDADE DO USUARIO E SENHA
            // RECUPERAR A PARTIR DO CSV AS INFORMAÇÕES DO USUÁRIO
            // INSTANCIÁ-LO E CHAMAR SUA FUNÇÃO login()
            SugarwoodClient user = new User(1, "a", "b", "c", "d","e");
            user.login();

            GUIManager.showDialog("Success", "Login success.", "You've been"
                    + " successfully logged in.");
        }
        catch (IOException ex){
            GUIManager.showDialog("Failure", "Login failed.",
                                    "Couldn't connect to server.");
        }
        
        changeScreen(event, type);
    }
    
    private void changeScreen(ActionEvent event, String type) {
        String resourcePath;
        
        switch(type) {
            case "Client":
                resourcePath = "OnlineStoreScreen.fxml";
                break;
                
            case "Manager":
                resourcePath = "ManagerScreen.fxml";
                break;
                
            case "Supplier":
                resourcePath = "SupplierScreen.fxml";
                break;
                
            default:
                resourcePath = "HomeScreen.fxml";
                break;
        }
        
        // Retorna para a tela principal
        Stage primaryStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    	Platform.runLater(
            () -> {
                try {
                    Parent newScreen = FXMLLoader.load(getClass().getResource(resourcePath));
                    Scene scene = new Scene(newScreen);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                } catch (IOException ex) { }
            });
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
