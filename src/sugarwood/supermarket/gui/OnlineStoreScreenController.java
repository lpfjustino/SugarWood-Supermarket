package sugarwood.supermarket.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
                .forEach((stockItem) -> {
                    items.add(stockItem.getProduct().getName()
                        + "(" + stockItem.getQuantity() + ")");
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
