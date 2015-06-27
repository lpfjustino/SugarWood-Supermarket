package sugarwood.supermarket.product;

import java.util.Date;


public class SupermarketProduct extends Product {
    private int id;
    private double price;
    
    public SupermarketProduct(Product product, int id, double price) {
        this.setId(id);
        this.setPrice(price);
        this.setName(product.getName());
        this.setGoodThru(product.getGoodThru());
        this.setSupplier(product.getSupplier());
    }
    
    public SupermarketProduct(String name, Date goodThru, String supplier,
                                                         int id, double price) {
        this.setId(id);
        this.setPrice(price);
        this.setName(name);
        this.setGoodThru(goodThru);
        this.setSupplier(supplier);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        String display = "ID: " + getId() + "\n" +
                "Name: " + getName() + "\n" +
                "GoodThru: " + getGoodThru() + "\n" +
                "Supplier: " + getSupplier() + "\n" +
                "Price: " + getPrice();
        
        return display;
    }
}
