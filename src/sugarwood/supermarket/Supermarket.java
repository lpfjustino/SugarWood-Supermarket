package sugarwood.supermarket;

import sugarwood.supermarket.product.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observer;
import sugarwood.supermarket.network.ConnectionsManager;
import sugarwood.supermarket.product.Sell;
import sugarwood.supermarket.product.SupermarketProduct;


public class Supermarket implements Suppliable {
    private ArrayList<User> users;
    private HashMap<SupermarketProduct, Integer> stock;
    private HashMap<SupermarketProduct, ArrayList<Observer>> waitList;
    private ArrayList<Sell> history;
    private ArrayList<Supply> supplyBuffer;
    private ConnectionsManager connectionManager;
    
    public Supermarket() {
        users = new ArrayList<>();
        stock = new HashMap<>();
        waitList = new HashMap<>();
        history = new ArrayList<>();
        supplyBuffer = new ArrayList<>();
        connectionManager = new ConnectionsManager();
    }
    
    public synchronized void sell(Product product, User user) {
        // TODO
    }
    
    // Efetua o reabastecimento de uma lista de produtos associada à quantidade
    // recebida e notifica os usuários inscritos na lista de espera
    @Override
    public void restock(Supply supply) {
        getSupplyBuffer().add(supply);
    }
    
    private void refillProduct(SupermarketProduct product, Integer qty) {
        
    }
    
    public void registerUser(User user) {
        getUsers().add(user);
    }
    
    public void registerProduct(SupermarketProduct product, int qty) {
        getStock().put(product, qty);
    }
    
    public void listStock() {
        getStock().forEach((product, qty) -> {
            System.out.println(product + "\nQty: " + qty + "\n");
        });
    }
    
    public void listUsers() {
        getUsers()
                .stream()
                .forEach(user -> {
                    System.out.println(user);
                });
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public HashMap<SupermarketProduct, Integer> getStock() {
        return stock;
    }

    public void setStock(HashMap<SupermarketProduct, Integer> stock) {
        this.stock = stock;
    }

    public HashMap<SupermarketProduct, ArrayList<Observer>> getWaitList() {
        return waitList;
    }

    public void setWaitList(HashMap<SupermarketProduct, ArrayList<Observer>> waitList) {
        this.waitList = waitList;
    }

    public ArrayList<Sell> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Sell> history) {
        this.history = history;
    }

    public ArrayList<Supply> getSupplyBuffer() {
        return supplyBuffer;
    }

    public void setSupplyBuffer(ArrayList<Supply> supplyBuffer) {
        this.supplyBuffer = supplyBuffer;
    }

    public ConnectionsManager getConnectionManager() {
        return connectionManager;
    }

    public void setConnectionManager(ConnectionsManager connectionManager) {
        this.connectionManager = connectionManager;
    }
}
