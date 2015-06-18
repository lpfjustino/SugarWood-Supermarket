package sugarwood.supermarket;

import sugarwood.supermarket.product.Product;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observer;
import sugarwood.supermarket.product.Sell;
import sugarwood.supermarket.product.SupermarketProduct;
import sugarwood.supermarket.product.SupplierProduct;


public class Supermarket implements Suppliable {
    ArrayList<User> users;
    Map<Product, Integer> stock;
    Map<SupermarketProduct, ArrayList<Observer>> waitList;
    ArrayList<Sell> history;
    
    public void sell(Product product, User user) {
        // TODO
    }
    
    // Efetua o reabastecimento de uma lista de produtos associada à quantidade
    // recebida e notifica os usuários inscritos na lista de espera
    @Override
    public void restock(Map<SupplierProduct, Integer> supply) {
        // TODO
    }
    
    public void registerUser(User user) {
        // TODO
    }
    
    public void registerProduct(SupermarketProduct product) {
        // TODO
    }
    
    public void listStock() {
        // TODO
    }
}
