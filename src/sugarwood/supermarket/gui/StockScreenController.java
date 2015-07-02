package sugarwood.supermarket.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import sugarwood.supermarket.product.StockItem;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class StockScreenController implements Initializable {
    Stage primaryStage;

    @FXML private TableView<StockItem> usersTable;
    
    // Users table
    @FXML private TableColumn<StockItem, String> nameCollumn;
    @FXML private TableColumn<StockItem, Integer> qtyCollumn;
    
    @FXML
    private void rbUsersClick(ActionEvent event) {
        // Alterna entre as tabelas dependendo do que o usuário deseja listar
        usersTable.setVisible(true);
        
        // Insere os valores na tabela
        qtyCollumn.setCellValueFactory(cell -> {
            int qty = ((StockItem) cell.getValue()).getQuantity();
            return new ReadOnlyObjectWrapper<>(qty);
        });
        nameCollumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        ObservableList<StockItem> data = FXCollections.observableArrayList();
        	SugarWoodSupermarket.getSupermarket().getStock()
                .stream()
                .forEach( item -> {
                    data.add(item);
                });
        usersTable.setItems(data);
    }
        
    @FXML
    private void homeButtonAction(ActionEvent event) {
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
