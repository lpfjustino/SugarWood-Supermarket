package sugarwood.supermarket;

import sugarwood.supermarket.product.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observer;
import sugarwood.supermarket.csv.CSVManager;
import sugarwood.supermarket.product.Sell;
import sugarwood.supermarket.product.StockItem;
import sugarwood.supermarket.product.SupermarketProduct;


public class Supermarket implements Suppliable {
    private ArrayList<User> users;
    private ArrayList<StockItem> stock;
    private HashMap<SupermarketProduct, ArrayList<Observer>> waitList;
    private ArrayList<Sell> history;
    private ArrayList<Supply> supplyBuffer;
    
    public Supermarket() {
        users = CSVManager.fetch(User.class);
        stock = CSVManager.fetch(StockItem.class);
        waitList = new HashMap<>();
        history = new ArrayList<>();
        supplyBuffer = new ArrayList<>();
    }
    
    public synchronized void sell(SupermarketProduct product, User user) {
        StockItem item = stock
                .stream()
                .filter((stockItem) -> {
                    return stockItem.getProduct().getId() == product.getId();
                })
                .findAny()
                .get();
        
        StockItem replace = new StockItem();
        replace.setProduct(item.getProduct());
        replace.setQuantity(item.getQuantity() - 1);
        
        stock.remove(item);
        stock.add(replace);
        
        CSVManager.persist(replace);
        stock = CSVManager.fetch(StockItem.class);
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
        CSVManager.persist(user);
        setUsers(CSVManager.fetch(User.class));
    }
    
    public void registerProduct(SupermarketProduct product, int qty) {
        StockItem newItem = new StockItem(product, qty);
        CSVManager.persist(newItem);
        setStock(CSVManager.fetch(StockItem.class));
    }
    
    public void listStock() {
        getStock()
                .stream()
                .forEach((entry) -> {
                    System.out.println(entry.getProduct() + "\nQty: "
                            + entry.getQuantity() + "\n");
                });
    }
    
    public void listUsers() {
        getUsers()
                .stream()
                .forEach(user -> {
                    System.out.println(user);
                });
    }
    
    public User userFromID(int id) {
        return users
                .stream()
                .filter((User user) -> {
                    return user.getId() == id;
                })
                .findAny()
                .get();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<StockItem> getStock() {
        return stock;
    }

    public void setStock(ArrayList<StockItem> stock) {
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
}