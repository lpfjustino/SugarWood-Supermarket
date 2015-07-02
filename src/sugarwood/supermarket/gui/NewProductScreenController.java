package sugarwood.supermarket.gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import sugarwood.supermarket.User;
import sugarwood.supermarket.csv.CSVManager;
import sugarwood.supermarket.product.StockItem;
import sugarwood.supermarket.product.SupermarketProduct;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewProductScreenController implements Initializable {

	User user;

	@FXML private TextField idField = new TextField();
	@FXML private TextField nameField = new TextField();
	@FXML private TextField priceField = new TextField();
	@FXML private TextField supplierField = new TextField();
	@FXML private TextField qtyField = new TextField();

	Stage primaryStage;
	public Date goodThru;

	@FXML
	private DatePicker datePicker;

	@FXML
	private void datePickerAction(ActionEvent event) {

		primaryStage = (Stage) ((DatePicker) event.getSource()).getScene().getWindow();
		Platform.runLater(
				() -> {
					String pattern = "dd-MM-yyyy";
					datePicker.setPromptText(pattern.toLowerCase());
					LocalDate localDate = datePicker.getValue();
					goodThru = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
				});
	}


	@FXML
	private void confirmButtonAction(ActionEvent event) {
		try {
			// Recupera os campos da GUI
			int id = Integer.parseInt(idField.getText());
			String name = nameField.getText();
			Double price = Double.parseDouble(priceField.getText());
			String supplier = supplierField.getText();
			int qty = Integer.parseInt(qtyField.getText());

			// Cria uma instância do produto
			SupermarketProduct superProduct = new SupermarketProduct(name, goodThru, supplier, id, price);
			StockItem item = new StockItem(superProduct, qty);

			// Verifica se ocorreu uma inserção ou remoção e notifica o usuário
			// com um Alert apropriado
			CSVManager.persist(item);

			GUIManager.showDialog("Success",
					"Product registered/updated.",
					"The new product has been registered/updated successfully.");

		} catch (NumberFormatException ex) {
			ex.printStackTrace();
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
