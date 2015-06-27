package sugarwood.supermarket;

import sugarwood.supermarket.product.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observer;
import sugarwood.supermarket.product.Sell;
import sugarwood.supermarket.product.SupermarketProduct;


public class Supermarket implements Suppliable {
    ArrayList<User> users;
    HashMap<SupermarketProduct, Integer> stock;
    HashMap<SupermarketProduct, ArrayList<Observer>> waitList;
    ArrayList<Sell> history;
    ArrayList<Supply> supplyBuffer;
    
    public Supermarket() {
        users = new ArrayList<>();
        stock = new HashMap<>();
        waitList = new HashMap<>();
        history = new ArrayList<>();
        supplyBuffer = new ArrayList<>();
    }
    
    public synchronized void sell(Product product, User user) {
        // TODO
    }
    
    // Efetua o reabastecimento de uma lista de produtos associada à quantidade
    // recebida e notifica os usuários inscritos na lista de espera
    @Override
    public void restock(Supply supply) {
        supplyBuffer.add(supply);
    }
    
    private void refillProduct(Product product, Integer qty) {
        
    }
    
    public void registerUser(User user) {
        users.add(user);
    }
    
    public void registerProduct(SupermarketProduct product, int qty) {
        stock.put(product, qty);
    }
    
    public void listStock() {
        stock.forEach((product, qty) -> {
            System.out.println(product + "\nQty: " + qty + "\n");
        });
    }
    
    public void listUsers() {
        users
                .stream()
                .forEach(user -> {
                    System.out.println(user);
                });
    }
}
