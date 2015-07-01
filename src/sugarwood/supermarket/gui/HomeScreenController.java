package sugarwood.supermarket.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
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
import sugarwood.supermarket.network.Command;
import sugarwood.supermarket.network.ConnectionsManager;

public class HomeScreenController implements Initializable {
	@FXML Button loginButton;
	@FXML TextField mail;
	@FXML TextField password;
	@FXML ToggleGroup userType;

	@FXML
	private void loginButtonAction(ActionEvent event) {
		// Tenta conectar-se ao servidor se já não estiver conectado
		if(SugarWoodSupermarket.getUserSocket() == null) {
			try {
				SugarWoodSupermarket.setUserSocket(new Socket(
						ConnectionsManager.IP, ConnectionsManager.PORT));
				Socket socket = SugarWoodSupermarket.getUserSocket();
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				String inputLine;
				
//				out.println(Command.);
			}
			catch (IOException ex) {
				GUIManager.showDialog("Failed", "Connection Failed.", "Connection"
						+ " with server failed. Please try again later.");
								return;
			}
		}

		if(!fieldsFilled()){
			GUIManager.showDialog("Failed", "Login Failed.", "Please fill all"
					+ " the fields.");
			return;
		}

		// Recupera os campos da GUI
		String email = mail.getText();
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

		if(!type.equals(""))
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

	public boolean fieldsFilled() {
		return( (!mail.getText().equals("")) &&
				(!password.getText().equals("")) &&
				(userType.getSelectedToggle() != null)
				);

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}
}