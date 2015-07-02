package sugarwood.supermarket.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import sugarwood.supermarket.User;
import sugarwood.supermarket.product.StockItem;
import sugarwood.supermarket.product.SupermarketProduct;

public class OnlineStoreScreenController implements Initializable {
    @FXML Button addButton = new Button();
    @FXML Button removeButton = new Button();
    @FXML Button checkoutButton = new Button();
    @FXML ListView availableProducts = new ListView();
    @FXML ListView shoppingCart = new ListView();
    
    ObservableList<String> cartItems = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        ObservableList<String> items = FXCollections.observableArrayList();
        
        SugarWoodSupermarket.getSupermarket().getStock()
                .stream()
                .filter((currentItem) -> {
                    return (currentItem.getQuantity() > 0);
                })
                .forEach((stockItem) -> {
                    items.add(stockItem.getProduct().getName());
                });
        
        availableProducts.setItems(items);        
    }
    
    @FXML
    private void addButtonAction(ActionEvent event) {
        String selected = (String) availableProducts.getSelectionModel().getSelectedItem();
        
        cartItems.add(selected);
        shoppingCart.setItems(cartItems);
    }
    
    @FXML
    private void removeButtonAction(ActionEvent event) {
        String selected = (String) shoppingCart.getSelectionModel().getSelectedItem();
        cartItems.remove(selected);
        shoppingCart.setItems(cartItems);
    }
    
    @FXML
    private void checkoutButtonAction(ActionEvent event) {
        cartItems
                .stream()
                .forEach((boughtItem) -> {
                    SupermarketProduct product = productFromName(boughtItem);
                    int id = SugarWoodSupermarket.getUserID();
                    User user = SugarWoodSupermarket.getSupermarket().userFromID(id);
                    
                    SugarWoodSupermarket.getSupermarket().sell(product, user);
                });
        
        GUIManager.showDialog("Success", "Login success.", "Your purchase has"
                + "been successfully completed.");
        
        // Retorna para a tela principal
        Stage primaryStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    	Platform.runLater(
            () -> {
                try {
                    Parent homeScreen = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
                    Scene scene = new Scene(homeScreen);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                } catch (IOException ex) {
                }
            });
    }
    
    private SupermarketProduct productFromName(String name) {
        StockItem stockItem = SugarWoodSupermarket.getSupermarket().getStock()
                            .stream()
                            .filter((StockItem item) -> {
                                return item.getProduct().getName().equals(name);
                            })
                            .findAny()
                            .get();
        
        return stockItem.getProduct();
    }
}
